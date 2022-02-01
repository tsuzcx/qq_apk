package com.tencent.tmediacodec.codec;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodec.CodecException;
import android.media.MediaCodec.CryptoException;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCrypto;
import android.media.MediaDescrambler;
import android.media.MediaFormat;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.Surface;
import com.tencent.tmediacodec.TCodecManager;
import com.tencent.tmediacodec.callback.CodecCallback;
import com.tencent.tmediacodec.hook.HookManager;
import com.tencent.tmediacodec.hook.PreloadSurface;
import com.tencent.tmediacodec.hook.PreloadSurfaceTexture;
import com.tencent.tmediacodec.reuse.ReuseHelper;
import com.tencent.tmediacodec.reuse.ReuseHelper.AdaptationWorkaroundMode;
import com.tencent.tmediacodec.reuse.ReuseHelper.ReuseType;
import com.tencent.tmediacodec.util.LogUtils;
import com.tencent.tmediacodec.util.TUtils;
import com.tencent.tmediacodec.util.ThreadManager;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class ReuseCodecWrapper
  implements CodecWrapper
{
  public static final int CANT_REUSE_LIMIT = 3;
  public static final int ID_HISTORY_LIMIT = 100;
  public static final int METHOD_DEQUEUE_INPUT_BUFFER = 0;
  public static final int METHOD_DEQUEUE_OUTPUT_BUFFER = 1;
  public static final int TRY_AGAIN_LATER_LIMIT = 100;
  private static final Map<Surface, ReuseCodecWrapper> mSurfaceMap = new ConcurrentHashMap();
  public final String TAG;
  private final ReuseHelper.AdaptationWorkaroundMode adaptationMode;
  public boolean adaptive;
  @Nullable
  private CodecCallback callback;
  @Nullable
  private MediaCodecInfo.CodecCapabilities capabilities;
  @NonNull
  private final MediaCodec codec;
  @NonNull
  protected final CodecMaxValues codecMaxValues;
  protected final String codecName;
  @NonNull
  public ReuseCodecWrapper.DecodeState decodeState;
  @NonNull
  public final FormatWrapper format;
  private boolean hasReused;
  public boolean isRecycled;
  private int mCantReuseCount;
  private int[] mDequeueInOutputTryAgainCount;
  private boolean mErrorHappened;
  private boolean mHasAlwaysTryAgainError;
  private boolean mHasConfigureCalled;
  private final HashSet<Integer> mHoldBufferOutIndex;
  private boolean mReleaseCalled;
  private final Set<SurfaceTexture> mStoreToRelease;
  @Nullable
  protected Surface mSurface;
  private String mSurfaceTextureName;
  private long mThreadId;
  private final ArrayList<Long> mThreadIdHistory;
  @NonNull
  private ReuseHelper.ReuseType reuseType;
  public boolean secure;
  @NonNull
  private ReuseCodecWrapper.CodecState state;
  
  public ReuseCodecWrapper(@NonNull MediaCodec paramMediaCodec, @NonNull FormatWrapper paramFormatWrapper)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ReuseCodecWrapper[");
    localStringBuilder.append(hashCode());
    localStringBuilder.append("]");
    this.TAG = localStringBuilder.toString();
    this.decodeState = ReuseCodecWrapper.DecodeState.Started;
    this.mSurfaceTextureName = "";
    this.state = ReuseCodecWrapper.CodecState.Uninitialized;
    this.mHoldBufferOutIndex = new HashSet();
    this.mThreadIdHistory = new ArrayList();
    this.reuseType = ReuseHelper.ReuseType.KEEP_CODEC_RESULT_NO;
    this.mStoreToRelease = new LinkedHashSet();
    this.mDequeueInOutputTryAgainCount = new int[2];
    boolean bool2 = false;
    this.mErrorHappened = false;
    this.mHasAlwaysTryAgainError = false;
    this.mCantReuseCount = 0;
    this.codec = paramMediaCodec;
    this.format = paramFormatWrapper;
    this.codecMaxValues = new CodecMaxValues(paramFormatWrapper.maxWidth, paramFormatWrapper.maxHeight, paramFormatWrapper.maxInputSize);
    this.codecName = TUtils.getCodeName(this.codec);
    this.adaptationMode = ReuseHelper.codecAdaptationWorkaroundMode(this.codecName);
    if (Build.VERSION.SDK_INT >= 18)
    {
      if ((Build.VERSION.SDK_INT == 29) && (paramFormatWrapper.rotationDegrees != 0)) {
        bool1 = false;
      } else {
        bool1 = true;
      }
      paramMediaCodec = this.TAG;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("canCallGetCodecInfo:");
      localStringBuilder.append(bool1);
      LogUtils.d(paramMediaCodec, localStringBuilder.toString());
      if (bool1) {
        this.capabilities = this.codec.getCodecInfo().getCapabilitiesForType(paramFormatWrapper.sampleMimeType);
      }
    }
    paramMediaCodec = this.capabilities;
    if ((paramMediaCodec != null) && (TUtils.isAdaptive(paramMediaCodec))) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.adaptive = bool1;
    paramMediaCodec = this.capabilities;
    boolean bool1 = bool2;
    if (paramMediaCodec != null)
    {
      bool1 = bool2;
      if (TUtils.isSecure(paramMediaCodec)) {
        bool1 = true;
      }
    }
    this.secure = bool1;
  }
  
  private void bindingSurface(Surface paramSurface)
  {
    mSurfaceMap.put(paramSurface, this);
  }
  
  private String byte2HexString(Byte paramByte)
  {
    return String.format("%02X", new Object[] { Integer.valueOf(paramByte.intValue() & 0xFF) });
  }
  
  private void checkSurfaceBindingAndRecycle(Surface paramSurface)
  {
    Object localObject1;
    Object localObject2;
    if (LogUtils.isLogEnable())
    {
      localObject1 = this.TAG;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this);
      ((StringBuilder)localObject2).append(" checkSurfaceBinding size:");
      ((StringBuilder)localObject2).append(mSurfaceMap.size());
      ((StringBuilder)localObject2).append(" mSurfaceMap:");
      ((StringBuilder)localObject2).append(mSurfaceMap);
      LogUtils.d((String)localObject1, ((StringBuilder)localObject2).toString());
    }
    if (mSurfaceMap.containsKey(paramSurface))
    {
      localObject1 = (ReuseCodecWrapper)mSurfaceMap.get(paramSurface);
      boolean bool;
      if ((localObject1 != null) && (((ReuseCodecWrapper)localObject1).isReleaseCalled())) {
        bool = true;
      } else {
        bool = false;
      }
      if (LogUtils.isLogEnable())
      {
        localObject2 = this.TAG;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this);
        localStringBuilder.append(", surface:");
        localStringBuilder.append(paramSurface);
        localStringBuilder.append(" has been used by ");
        localStringBuilder.append(localObject1);
        localStringBuilder.append(" isReleaseCalled:");
        localStringBuilder.append(bool);
        localStringBuilder.append(", ignore but we can release it...");
        LogUtils.e((String)localObject2, localStringBuilder.toString());
      }
      if (bool) {
        ((ReuseCodecWrapper)localObject1).recycle();
      }
    }
  }
  
  private int checkSurfaceState(Surface paramSurface)
  {
    if (paramSurface == null) {
      return 10003;
    }
    if (!paramSurface.isValid()) {
      return 10004;
    }
    return 0;
  }
  
  public static CodecWrapper create(@NonNull MediaCodec paramMediaCodec, @NonNull String paramString, @NonNull FormatWrapper paramFormatWrapper)
  {
    if (TUtils.isVideo(paramString)) {
      return new VideoCodecWrapper(paramMediaCodec, paramFormatWrapper);
    }
    return new AudioCodecWrapper(paramMediaCodec, paramFormatWrapper);
  }
  
  private void dumpInputBuffer(int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4)
  {
    if (!TCodecManager.isDebug()) {
      return;
    }
    for (;;)
    {
      try
      {
        ByteBuffer localByteBuffer = this.codec.getInputBuffers()[paramInt1];
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("\n########################## ");
        localStringBuilder.append(this);
        localStringBuilder.append(" dumpInputBuffer ###################");
        localStringBuilder = new StringBuilder(localStringBuilder.toString());
        paramInt1 = 0;
        if (paramInt1 < 4)
        {
          localStringBuilder.append("\n");
          paramInt3 = 0;
          if (paramInt3 >= 16) {
            break label165;
          }
          localStringBuilder.append(" ");
          localStringBuilder.append(byte2HexString(Byte.valueOf(localByteBuffer.get(paramInt1 * 4 + paramInt2 + paramInt3))));
          paramInt3 += 1;
          continue;
        }
        if (LogUtils.isLogEnable())
        {
          LogUtils.v(this.TAG, localStringBuilder.toString());
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        LogUtils.e(this.TAG, "dumpInputBuffer error", localThrowable);
      }
      return;
      label165:
      paramInt1 += 1;
    }
  }
  
  private void dumpSurfaceMap(String paramString)
  {
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this);
    localStringBuilder.append("    ");
    localStringBuilder.append(paramString);
    localStringBuilder.append("     dumpSurfaceMap:");
    localStringBuilder.append(mSurfaceMap);
    LogUtils.i(str, localStringBuilder.toString());
  }
  
  private void handleCoreAPIException(int paramInt, String paramString, Throwable paramThrowable)
  {
    handleCoreAPIException(paramInt, paramString, paramThrowable, false, this.mSurface);
  }
  
  private void handleCoreAPIException(int paramInt, String paramString, Throwable paramThrowable, boolean paramBoolean, Surface paramSurface)
  {
    this.mErrorHappened = true;
    if (paramThrowable == null) {
      localObject = "";
    } else {
      localObject = paramThrowable.getLocalizedMessage();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(" handleCoreAPIException exception:");
    localStringBuilder.append((String)localObject);
    paramString = localStringBuilder.toString();
    int i = paramInt;
    if (paramBoolean)
    {
      int j = checkSurfaceState(paramSurface);
      i = paramInt;
      if (j != 0) {
        i = j;
      }
    }
    paramSurface = new JSONObject();
    try
    {
      paramSurface.put("errorCode", i);
      paramSurface.put("exceptionMsg", paramString);
      if (this.callback != null) {
        this.callback.onReuseCodecAPIException(paramSurface.toString(), paramThrowable);
      }
    }
    catch (JSONException paramSurface)
    {
      paramSurface.printStackTrace();
    }
    paramSurface = this.TAG;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("hasReused:");
    ((StringBuilder)localObject).append(this.hasReused);
    ((StringBuilder)localObject).append("    errorCode:");
    ((StringBuilder)localObject).append(i);
    ((StringBuilder)localObject).append(", ");
    ((StringBuilder)localObject).append(paramString);
    LogUtils.e(paramSurface, ((StringBuilder)localObject).toString(), paramThrowable);
    releaseCodecWhenError(i);
  }
  
  private void hookSurfaceNotRelease()
  {
    HookManager.hookSurfaceCallback(this.mSurfaceTextureName, new ReuseCodecWrapper.1(this));
  }
  
  @TargetApi(23)
  private void innerSetOutputSurface(Surface paramSurface)
  {
    innerSetOutputSurface(paramSurface, true);
  }
  
  @TargetApi(23)
  private void innerSetOutputSurface(Surface paramSurface, boolean paramBoolean)
  {
    if (this.mSurface == paramSurface)
    {
      localObject = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this);
      localStringBuilder.append(", innerSetOutputSurface error surface:");
      localStringBuilder.append(paramSurface);
      localStringBuilder.append(" is same, stack:");
      localStringBuilder.append(Log.getStackTraceString(new Throwable()));
      LogUtils.w((String)localObject, localStringBuilder.toString());
      return;
    }
    Object localObject = null;
    if (LogUtils.isLogEnable())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this);
      ((StringBuilder)localObject).append(" configure, call innerSetOutputSurface surface:");
      ((StringBuilder)localObject).append(paramSurface);
      ((StringBuilder)localObject).append("  decodeState:");
      ((StringBuilder)localObject).append(this.decodeState);
      ((StringBuilder)localObject).append(" callByInner:");
      ((StringBuilder)localObject).append(paramBoolean);
      localObject = ((StringBuilder)localObject).toString();
      LogUtils.d(this.TAG, (String)localObject);
    }
    try
    {
      setSurface(paramSurface);
      this.codec.setOutputSurface(paramSurface);
      releaseStoreSurfaceTexture();
      return;
    }
    catch (Throwable localThrowable)
    {
      int i;
      if (!(localThrowable instanceof IllegalStateException))
      {
        if ((localThrowable instanceof IllegalArgumentException)) {
          i = 30001;
        } else {
          i = 0;
        }
      }
      else {
        i = 30000;
      }
      handleCoreAPIException(i, (String)localObject, localThrowable, true, paramSurface);
      throw localThrowable;
    }
  }
  
  private boolean isAlwaysTryAgain(int paramInt1, int paramInt2)
  {
    boolean bool = false;
    if (paramInt2 == -1)
    {
      int[] arrayOfInt = this.mDequeueInOutputTryAgainCount;
      arrayOfInt[paramInt1] += 1;
      if (arrayOfInt[paramInt1] > 100) {
        bool = true;
      }
      return bool;
    }
    this.mDequeueInOutputTryAgainCount[paramInt1] = 0;
    return false;
  }
  
  private boolean isNotMyThread()
  {
    return Thread.currentThread().getId() != this.mThreadId;
  }
  
  private final void markPreloadSurfaceTexture()
  {
    Surface localSurface = this.mSurface;
    try
    {
      if ((localSurface instanceof PreloadSurface))
      {
        Object localObject1 = ((PreloadSurface)localSurface).getSurfaceTexture();
        if ((localObject1 instanceof PreloadSurfaceTexture)) {
          this.mStoreToRelease.add(localObject1);
        }
        if (LogUtils.isLogEnable())
        {
          localObject1 = this.TAG;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("markPreloadSurfaceTexture oldSurface:");
          ((StringBuilder)localObject2).append(localSurface);
          ((StringBuilder)localObject2).append(" success");
          LogUtils.d((String)localObject1, ((StringBuilder)localObject2).toString());
          return;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      Object localObject2 = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("markPreloadSurfaceTexture oldSurface:");
      localStringBuilder.append(localSurface);
      localStringBuilder.append(" failed");
      LogUtils.e((String)localObject2, localStringBuilder.toString(), localThrowable);
    }
  }
  
  private void onReuseCodec()
  {
    int[] arrayOfInt = this.mDequeueInOutputTryAgainCount;
    arrayOfInt[0] = 0;
    arrayOfInt[1] = 0;
  }
  
  private void onSurfaceTextureUnbinding(String paramString)
  {
    HookManager.unHookSurfaceCallback(paramString);
  }
  
  private final void processInputBufferWithReConfig(int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4)
  {
    this.codec.queueInputBuffer(paramInt1, paramInt2, paramInt3, paramLong, paramInt4);
  }
  
  private final void queueInputBufferForAdaptation(int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4)
  {
    int i = ReuseCodecWrapper.5.$SwitchMap$com$tencent$tmediacodec$reuse$ReuseHelper$ReuseType[this.reuseType.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3) {
          return;
        }
        this.codec.queueInputBuffer(paramInt1, paramInt2, paramInt3, paramLong, paramInt4);
        return;
      }
      processInputBufferWithReConfig(paramInt1, paramInt2, paramInt3, paramLong, paramInt4);
      return;
    }
    LogUtils.w(this.TAG, "queueInputBufferForAdaptation error for KEEP_CODEC_RESULT_NO");
  }
  
  private void realConfigure(@NonNull MediaFormat paramMediaFormat, @Nullable Surface paramSurface, int paramInt, @Nullable MediaDescrambler paramMediaDescrambler)
  {
    Object localObject;
    if (LogUtils.isLogEnable())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this);
      ((StringBuilder)localObject).append(", configure mediaFormat:");
      ((StringBuilder)localObject).append(paramMediaFormat);
      ((StringBuilder)localObject).append(" surface:");
      ((StringBuilder)localObject).append(paramSurface);
      ((StringBuilder)localObject).append(" flags:");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" descrambler:");
      ((StringBuilder)localObject).append(paramMediaDescrambler);
      ((StringBuilder)localObject).append(" state:");
      ((StringBuilder)localObject).append(this.state);
      ((StringBuilder)localObject).append(" mHasConfigureCalled：");
      ((StringBuilder)localObject).append(this.mHasConfigureCalled);
      localObject = ((StringBuilder)localObject).toString();
      LogUtils.d(this.TAG, (String)localObject);
    }
    else
    {
      localObject = null;
    }
    try
    {
      this.codec.configure(paramMediaFormat, paramSurface, paramInt, paramMediaDescrambler);
      setSurface(paramSurface);
      this.state = ReuseCodecWrapper.CodecState.Configured;
      return;
    }
    catch (Throwable paramMediaFormat)
    {
      if (!(paramMediaFormat instanceof MediaCodec.CodecException))
      {
        if (!(paramMediaFormat instanceof IllegalStateException))
        {
          if ((paramMediaFormat instanceof MediaCodec.CryptoException)) {
            paramInt = 10001;
          } else {
            paramInt = 0;
          }
        }
        else {
          paramInt = 10000;
        }
      }
      else {
        paramInt = 10002;
      }
      handleCoreAPIException(paramInt, (String)localObject, paramMediaFormat, true, paramSurface);
      throw paramMediaFormat;
    }
  }
  
  private void realConfigure(@NonNull MediaFormat paramMediaFormat, @Nullable Surface paramSurface, @Nullable MediaCrypto paramMediaCrypto, int paramInt)
  {
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = localObject3;
    try
    {
      if (LogUtils.isLogEnable())
      {
        localObject1 = localObject3;
        localObject2 = new StringBuilder();
        localObject1 = localObject3;
        ((StringBuilder)localObject2).append(this);
        localObject1 = localObject3;
        ((StringBuilder)localObject2).append(", realConfigure mediaFormat:");
        localObject1 = localObject3;
        ((StringBuilder)localObject2).append(paramMediaFormat);
        localObject1 = localObject3;
        ((StringBuilder)localObject2).append(" surface:");
        localObject1 = localObject3;
        ((StringBuilder)localObject2).append(paramSurface);
        localObject1 = localObject3;
        ((StringBuilder)localObject2).append(" crypto:");
        localObject1 = localObject3;
        ((StringBuilder)localObject2).append(paramMediaCrypto);
        localObject1 = localObject3;
        ((StringBuilder)localObject2).append(" flags:");
        localObject1 = localObject3;
        ((StringBuilder)localObject2).append(paramInt);
        localObject1 = localObject3;
        ((StringBuilder)localObject2).append(" state:");
        localObject1 = localObject3;
        ((StringBuilder)localObject2).append(this.state);
        localObject1 = localObject3;
        ((StringBuilder)localObject2).append(" mHasConfigureCalled：");
        localObject1 = localObject3;
        ((StringBuilder)localObject2).append(this.mHasConfigureCalled);
        localObject1 = localObject3;
        localObject2 = ((StringBuilder)localObject2).toString();
        localObject1 = localObject2;
        LogUtils.d(this.TAG, (String)localObject2);
      }
      localObject1 = localObject2;
      this.codec.configure(paramMediaFormat, paramSurface, paramMediaCrypto, paramInt);
      localObject1 = localObject2;
      setSurface(paramSurface);
      localObject1 = localObject2;
      this.state = ReuseCodecWrapper.CodecState.Configured;
      return;
    }
    catch (Throwable paramMediaFormat)
    {
      if (!(paramMediaFormat instanceof IllegalStateException))
      {
        if ((paramMediaFormat instanceof MediaCodec.CryptoException)) {
          paramInt = 10001;
        } else {
          paramInt = 0;
        }
      }
      else {
        paramInt = 10000;
      }
      handleCoreAPIException(paramInt, localObject1, paramMediaFormat, true, paramSurface);
      throw paramMediaFormat;
    }
  }
  
  private void releaseCodecWhenError(int paramInt)
  {
    int i;
    if (paramInt < 40000) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      String str = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this);
      localStringBuilder.append("    releaseCodecWhenError, errorCode:");
      localStringBuilder.append(paramInt);
      LogUtils.e(str, localStringBuilder.toString());
      release();
    }
  }
  
  private final void releaseOldSurface(Surface paramSurface)
  {
    if (paramSurface != null) {
      ThreadManager.execute(new ReuseCodecWrapper.2(this, paramSurface));
    }
  }
  
  private void releaseStoreSurfaceTexture()
  {
    releaseStoreSurfaceTexture(true);
  }
  
  private void releaseStoreSurfaceTexture(boolean paramBoolean)
  {
    Object localObject;
    if (LogUtils.isLogEnable())
    {
      localObject = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this);
      localStringBuilder.append(", releaseStoreSurfaceTexture mStoreToRelease:");
      localStringBuilder.append(this.mStoreToRelease);
      LogUtils.d((String)localObject, localStringBuilder.toString());
    }
    if (!this.mStoreToRelease.isEmpty())
    {
      localObject = new ArrayList(this.mStoreToRelease);
      this.mStoreToRelease.clear();
      if (paramBoolean)
      {
        ThreadManager.execute(new ReuseCodecWrapper.3(this, (List)localObject));
        return;
      }
      releaseSurfaceTexture((List)localObject);
    }
  }
  
  private final void releaseSurfaceTexture(List<SurfaceTexture> paramList)
  {
    Object localObject2;
    if (LogUtils.isLogEnable())
    {
      localObject1 = this.TAG;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this);
      ((StringBuilder)localObject2).append(", releaseSurfaceTexture toReleaseSet:");
      ((StringBuilder)localObject2).append(paramList);
      LogUtils.d((String)localObject1, ((StringBuilder)localObject2).toString());
    }
    Object localObject1 = new LinkedHashSet();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localObject2 = (SurfaceTexture)paramList.next();
      HookManager.realReleaseSurfaceTexture((SurfaceTexture)localObject2);
      ((Set)localObject1).add(localObject2.toString());
    }
    removeSurfaceBinding((Set)localObject1);
  }
  
  private final void removeStoreSurfaceTextureFromToReleaseSet(String paramString)
  {
    if (LogUtils.isLogEnable())
    {
      localObject = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this);
      localStringBuilder.append(", removeStoreSurfaceTexture nameSurfaceTexture:");
      localStringBuilder.append(paramString);
      LogUtils.d((String)localObject, localStringBuilder.toString());
    }
    Object localObject = this.mStoreToRelease.iterator();
    while (((Iterator)localObject).hasNext()) {
      if (TextUtils.equals(((Iterator)localObject).next().toString(), paramString)) {
        ((Iterator)localObject).remove();
      }
    }
  }
  
  private void removeSurfaceBinding(Set paramSet)
  {
    removeSurfaceBinding(paramSet, Collections.emptySet());
  }
  
  private void removeSurfaceBinding(Set paramSet1, Set paramSet2)
  {
    Object localObject2;
    if (LogUtils.isLogEnable())
    {
      localObject1 = this.TAG;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this);
      ((StringBuilder)localObject2).append(", removeSurfaceBinding toReleaseNameSet:");
      ((StringBuilder)localObject2).append(paramSet1);
      ((StringBuilder)localObject2).append(" toReleaseCodecSet:");
      ((StringBuilder)localObject2).append(paramSet2);
      LogUtils.d((String)localObject1, ((StringBuilder)localObject2).toString());
    }
    Object localObject1 = mSurfaceMap.entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      String str = TUtils.getSurfaceTextureName((Surface)((Map.Entry)localObject2).getKey());
      int i;
      if ((!paramSet1.contains(str)) && (!paramSet2.contains(((Map.Entry)localObject2).getValue()))) {
        i = 0;
      } else {
        i = 1;
      }
      if (i != 0)
      {
        ((Iterator)localObject1).remove();
        onSurfaceTextureUnbinding(str);
      }
    }
  }
  
  private void resetParam()
  {
    this.mHasAlwaysTryAgainError = false;
    this.mCantReuseCount = 0;
  }
  
  private final void setSurface(Surface paramSurface)
  {
    if (LogUtils.isLogEnable())
    {
      String str = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this);
      localStringBuilder.append(", oldSurface:");
      localStringBuilder.append(this.mSurface);
      localStringBuilder.append(" CodecWrapperSetSurface surface:");
      localStringBuilder.append(paramSurface);
      LogUtils.i(str, localStringBuilder.toString());
    }
    HookManager.unHookSurfaceCallback(this.mSurfaceTextureName);
    removeSurfaceBinding(new HashSet(Collections.singletonList(this.mSurfaceTextureName)));
    markPreloadSurfaceTexture();
    setToMySurface(paramSurface);
    removeStoreSurfaceTextureFromToReleaseSet(this.mSurfaceTextureName);
    if (paramSurface != null)
    {
      checkSurfaceBindingAndRecycle(paramSurface);
      bindingSurface(paramSurface);
      hookSurfaceNotRelease();
    }
  }
  
  private void setToMySurface(Surface paramSurface)
  {
    this.mSurface = paramSurface;
    this.mSurfaceTextureName = "";
    if (paramSurface != null) {
      this.mSurfaceTextureName = TUtils.getSurfaceTextureName(paramSurface);
    }
  }
  
  private void trackDecodeApi(int paramInt1, int paramInt2)
  {
    if ((!this.mHasAlwaysTryAgainError) && (isAlwaysTryAgain(paramInt1, paramInt2)))
    {
      this.mHasAlwaysTryAgainError = true;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this);
      localStringBuilder.append(", trackDecodeApi state:");
      localStringBuilder.append(this.state);
      localStringBuilder.append("  surfaceState:");
      Object localObject = this.mSurface;
      if (localObject != null) {
        localObject = Boolean.valueOf(((Surface)localObject).isValid());
      } else {
        localObject = null;
      }
      localStringBuilder.append(localObject);
      localObject = localStringBuilder.toString();
      if (paramInt1 == 0)
      {
        handleCoreAPIException(40002, (String)localObject, null);
        return;
      }
      if (paramInt1 == 1) {
        handleCoreAPIException(60002, (String)localObject, null);
      }
    }
  }
  
  public void attachThread()
  {
    long l = Thread.currentThread().getId();
    if (this.mThreadIdHistory.contains(Long.valueOf(l))) {
      return;
    }
    this.mThreadId = l;
    this.mThreadIdHistory.add(Long.valueOf(this.mThreadId));
    if (this.mThreadIdHistory.size() > 100) {
      this.mThreadIdHistory.remove(0);
    }
  }
  
  @NonNull
  public abstract ReuseHelper.ReuseType canReuse(@NonNull FormatWrapper paramFormatWrapper);
  
  @TargetApi(26)
  public void configure(@NonNull MediaFormat paramMediaFormat, @Nullable Surface paramSurface, int paramInt, @Nullable MediaDescrambler paramMediaDescrambler)
  {
    if (isNotMyThread())
    {
      LogUtils.w(this.TAG, "ignore call method configure for isNotMyThread");
      return;
    }
    this.mHasConfigureCalled = true;
    try
    {
      this.mReleaseCalled = false;
      if (this.state == ReuseCodecWrapper.CodecState.Uninitialized)
      {
        realConfigure(paramMediaFormat, paramSurface, paramInt, paramMediaDescrambler);
        return;
      }
      if (paramSurface != null)
      {
        onReuseCodec();
        innerSetOutputSurface(paramSurface);
      }
      return;
    }
    catch (Throwable paramMediaFormat)
    {
      throw paramMediaFormat;
    }
  }
  
  public void configure(@NonNull MediaFormat paramMediaFormat, @Nullable Surface paramSurface, @Nullable MediaCrypto paramMediaCrypto, int paramInt)
  {
    if (isNotMyThread())
    {
      LogUtils.w(this.TAG, "ignore call method configure for isNotMyThread");
      return;
    }
    this.mHasConfigureCalled = true;
    try
    {
      this.mReleaseCalled = false;
      if (this.state == ReuseCodecWrapper.CodecState.Uninitialized)
      {
        realConfigure(paramMediaFormat, paramSurface, paramMediaCrypto, paramInt);
        return;
      }
      if (paramSurface != null)
      {
        onReuseCodec();
        innerSetOutputSurface(paramSurface);
      }
      return;
    }
    catch (Throwable paramMediaFormat)
    {
      throw paramMediaFormat;
    }
  }
  
  public int dequeueInputBuffer(long paramLong)
  {
    if (isNotMyThread())
    {
      LogUtils.w(this.TAG, "ignore call method dequeueInputBuffer for isNotMyThread");
      return -1;
    }
    Object localObject3 = null;
    Object localObject2 = null;
    int i = 0;
    Object localObject1 = localObject3;
    try
    {
      int j = this.codec.dequeueInputBuffer(paramLong);
      localObject1 = localObject3;
      if (LogUtils.isLogEnable())
      {
        localObject1 = localObject3;
        localObject2 = new StringBuilder();
        localObject1 = localObject3;
        ((StringBuilder)localObject2).append(this);
        localObject1 = localObject3;
        ((StringBuilder)localObject2).append(", dequeueInputBuffer state:");
        localObject1 = localObject3;
        ((StringBuilder)localObject2).append(this.state);
        localObject1 = localObject3;
        ((StringBuilder)localObject2).append(" decodeState:");
        localObject1 = localObject3;
        ((StringBuilder)localObject2).append(this.decodeState);
        localObject1 = localObject3;
        ((StringBuilder)localObject2).append(" , result=");
        localObject1 = localObject3;
        ((StringBuilder)localObject2).append(j);
        localObject1 = localObject3;
        localObject2 = ((StringBuilder)localObject2).toString();
        localObject1 = localObject2;
        LogUtils.v(this.TAG, (String)localObject2);
      }
      localObject1 = localObject2;
      this.decodeState = ReuseCodecWrapper.DecodeState.DequeueIn;
      localObject1 = localObject2;
      this.state = ReuseCodecWrapper.CodecState.Running;
      localObject1 = localObject2;
      trackDecodeApi(0, j);
      return j;
    }
    catch (Throwable localThrowable)
    {
      if (!(localThrowable instanceof IllegalStateException))
      {
        if ((localThrowable instanceof IllegalArgumentException)) {
          i = 40001;
        }
      }
      else {
        i = 40000;
      }
      handleCoreAPIException(i, localObject1, localThrowable);
      throw localThrowable;
    }
  }
  
  public int dequeueOutputBuffer(@NonNull MediaCodec.BufferInfo paramBufferInfo, long paramLong)
  {
    if (isNotMyThread())
    {
      LogUtils.w(this.TAG, "ignore call method dequeueOutputBuffer for isNotMyThread");
      return -1;
    }
    String str = null;
    Object localObject2 = null;
    Object localObject1 = str;
    try
    {
      i = this.codec.dequeueOutputBuffer(paramBufferInfo, paramLong);
      paramBufferInfo = localObject2;
      localObject1 = str;
      if (LogUtils.isLogEnable())
      {
        localObject1 = str;
        paramBufferInfo = new StringBuilder();
        localObject1 = str;
        paramBufferInfo.append(this);
        localObject1 = str;
        paramBufferInfo.append(", dequeueOutputBuffer outIndex:");
        localObject1 = str;
        paramBufferInfo.append(i);
        localObject1 = str;
        str = paramBufferInfo.toString();
        paramBufferInfo = str;
        localObject1 = str;
        if ((this instanceof VideoCodecWrapper))
        {
          localObject1 = str;
          LogUtils.v(this.TAG, str);
          paramBufferInfo = str;
        }
      }
      localObject1 = paramBufferInfo;
      this.mHoldBufferOutIndex.add(Integer.valueOf(i));
      localObject1 = paramBufferInfo;
      this.decodeState = ReuseCodecWrapper.DecodeState.DequeueOut;
      localObject1 = paramBufferInfo;
      trackDecodeApi(1, i);
      return i;
    }
    catch (Throwable paramBufferInfo)
    {
      int i = 0;
      if ((Build.VERSION.SDK_INT >= 21) && ((paramBufferInfo instanceof MediaCodec.CodecException))) {
        i = 60001;
      } else if ((paramBufferInfo instanceof IllegalStateException)) {
        i = 60000;
      }
      handleCoreAPIException(i, (String)localObject1, paramBufferInfo);
      throw paramBufferInfo;
    }
  }
  
  public void flush()
  {
    if (isNotMyThread()) {
      LogUtils.w(this.TAG, "call method flush for isNotMyThread...");
    }
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = localObject3;
    try
    {
      if (LogUtils.isLogEnable())
      {
        localObject1 = localObject3;
        localObject2 = new StringBuilder();
        localObject1 = localObject3;
        ((StringBuilder)localObject2).append(this);
        localObject1 = localObject3;
        ((StringBuilder)localObject2).append(", flush state:");
        localObject1 = localObject3;
        ((StringBuilder)localObject2).append(this.state);
        localObject1 = localObject3;
        localObject2 = ((StringBuilder)localObject2).toString();
        localObject1 = localObject2;
        LogUtils.d(this.TAG, (String)localObject2);
      }
      localObject1 = localObject2;
      this.codec.flush();
      localObject1 = localObject2;
      this.state = ReuseCodecWrapper.CodecState.Flushed;
      return;
    }
    catch (Throwable localThrowable)
    {
      int i = 0;
      if ((Build.VERSION.SDK_INT >= 21) && ((localThrowable instanceof MediaCodec.CodecException))) {
        i = 90001;
      } else if ((localThrowable instanceof IllegalStateException)) {
        i = 90000;
      }
      handleCoreAPIException(i, localObject1, localThrowable);
      throw localThrowable;
    }
  }
  
  @Nullable
  public final CodecCallback getCallback()
  {
    return this.callback;
  }
  
  @NonNull
  public final MediaCodec getCodec()
  {
    return this.codec;
  }
  
  public String getCodecName()
  {
    return this.codecName;
  }
  
  @NonNull
  public final FormatWrapper getFormat()
  {
    return this.format;
  }
  
  @NonNull
  public MediaCodec getMediaCodec()
  {
    return this.codec;
  }
  
  public boolean isNeedKeep()
  {
    if (TCodecManager.isLeakFixed()) {
      return (!this.mErrorHappened) && (TCodecManager.getInstance().isGlobalReuseEnable()) && (TCodecManager.getInstance().isAllowKeepPool());
    }
    return (!this.mErrorHappened) && (TCodecManager.getInstance().isGlobalReuseEnable());
  }
  
  public final boolean isReleaseCalled()
  {
    return this.mReleaseCalled;
  }
  
  public boolean needToErase()
  {
    return this.mCantReuseCount >= 3;
  }
  
  public void prepareToReUse()
  {
    resetParam();
    if (TCodecManager.isLeakFixed())
    {
      if (this.state == ReuseCodecWrapper.CodecState.Running) {
        try
        {
          flush();
        }
        catch (IllegalStateException localIllegalStateException)
        {
          LogUtils.e(this.TAG, "flush failed in prepareToReUse", localIllegalStateException);
        }
      }
    }
    else if (this.state != ReuseCodecWrapper.CodecState.Flushed) {
      flush();
    }
    this.hasReused = true;
  }
  
  public void queueInputBuffer(int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4)
  {
    if (isNotMyThread())
    {
      LogUtils.w(this.TAG, "ignore call method queueInputBuffer for isNotMyThread");
      return;
    }
    Object localObject = null;
    if (LogUtils.isLogEnable())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this);
      ((StringBuilder)localObject).append(", queueInputBuffer index:");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(" offset:");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(" size:");
      ((StringBuilder)localObject).append(paramInt3);
      ((StringBuilder)localObject).append(" presentationTimeUs:");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(' ');
      ((StringBuilder)localObject).append("flags:");
      ((StringBuilder)localObject).append(paramInt4);
      ((StringBuilder)localObject).append(" state:");
      ((StringBuilder)localObject).append(this.state);
      ((StringBuilder)localObject).append(" decodeState:");
      ((StringBuilder)localObject).append(this.decodeState);
      localObject = ((StringBuilder)localObject).toString();
      LogUtils.v(this.TAG, (String)localObject);
    }
    try
    {
      if (this.hasReused) {
        queueInputBufferForAdaptation(paramInt1, paramInt2, paramInt3, paramLong, paramInt4);
      } else {
        this.codec.queueInputBuffer(paramInt1, paramInt2, paramInt3, paramLong, paramInt4);
      }
      this.decodeState = ReuseCodecWrapper.DecodeState.QueueIn;
      return;
    }
    catch (Throwable localThrowable)
    {
      paramInt1 = 0;
      if ((Build.VERSION.SDK_INT >= 21) && ((localThrowable instanceof MediaCodec.CodecException))) {
        paramInt1 = 50001;
      } else if (!(localThrowable instanceof IllegalStateException))
      {
        if ((localThrowable instanceof MediaCodec.CryptoException)) {
          paramInt1 = 50002;
        }
      }
      else {
        paramInt1 = 50000;
      }
      handleCoreAPIException(paramInt1, (String)localObject, localThrowable);
      throw localThrowable;
    }
  }
  
  public final void recycle()
  {
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this);
    localStringBuilder.append(", recycle isRecycled:");
    localStringBuilder.append(this.isRecycled);
    localStringBuilder.append("  mSurfaceMap.size:");
    localStringBuilder.append(mSurfaceMap.size());
    localStringBuilder.append("...... stack:");
    localStringBuilder.append(Log.getStackTraceString(new Throwable()));
    LogUtils.d(str, localStringBuilder.toString());
    if (this.isRecycled)
    {
      LogUtils.w(this.TAG, "ignore recycle for has isRecycled is true.");
      return;
    }
    this.mHasConfigureCalled = false;
    this.isRecycled = true;
    removeSurfaceBinding(Collections.emptySet(), Collections.singleton(this));
    ThreadManager.runOnSubThread(new ReuseCodecWrapper.4(this));
    mSurfaceMap.remove(this.mSurface);
    this.state = ReuseCodecWrapper.CodecState.Uninitialized;
  }
  
  public void release()
  {
    StringBuilder localStringBuilder;
    if (LogUtils.isLogEnable())
    {
      String str1 = this.TAG;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this);
      localStringBuilder.append(" call release mHoldBufferOutIndex:");
      localStringBuilder.append(this.mHoldBufferOutIndex);
      localStringBuilder.append(" mReleaseCalled:");
      localStringBuilder.append(this.mReleaseCalled);
      localStringBuilder.append(" stack:");
      localStringBuilder.append(Log.getStackTraceString(new Throwable()));
      LogUtils.d(str1, localStringBuilder.toString());
    }
    this.mReleaseCalled = true;
    this.mHasConfigureCalled = false;
    if (isNeedKeep())
    {
      try
      {
        flush();
      }
      catch (IllegalStateException localIllegalStateException)
      {
        LogUtils.e(this.TAG, "flush failed for not in the Executing state.", localIllegalStateException);
      }
      TCodecManager.getInstance().recycleCodecFromRunning(this);
      return;
    }
    if (LogUtils.isLogEnable())
    {
      String str2 = this.TAG;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Don't not keep the codec, release it ..., mErrorHappened:");
      localStringBuilder.append(this.mErrorHappened);
      LogUtils.w(str2, localStringBuilder.toString());
    }
    TCodecManager.getInstance().removeCodecFromRunningPool(this);
    recycle();
    this.state = ReuseCodecWrapper.CodecState.Released;
  }
  
  @TargetApi(21)
  public void releaseOutputBuffer(int paramInt, long paramLong)
  {
    if (isNotMyThread())
    {
      LogUtils.w(this.TAG, "ignore call method releaseOutputBuffer for isNotMyThread");
      return;
    }
    Object localObject = null;
    if (LogUtils.isLogEnable())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this);
      ((StringBuilder)localObject).append(", releaseOutputBuffer API21");
      ((StringBuilder)localObject).append(paramInt);
      String str = ((StringBuilder)localObject).toString();
      localObject = str;
      if ((this instanceof VideoCodecWrapper))
      {
        LogUtils.v(this.TAG, str);
        localObject = str;
      }
    }
    this.mHoldBufferOutIndex.remove(Integer.valueOf(paramInt));
    try
    {
      this.codec.releaseOutputBuffer(paramInt, paramLong);
      this.decodeState = ReuseCodecWrapper.DecodeState.ReleaseOut;
      return;
    }
    catch (Throwable localThrowable)
    {
      paramInt = 0;
      if ((Build.VERSION.SDK_INT >= 21) && ((localThrowable instanceof MediaCodec.CodecException))) {
        paramInt = 70002;
      } else if ((localThrowable instanceof IllegalStateException)) {
        paramInt = 70001;
      }
      handleCoreAPIException(paramInt, (String)localObject, localThrowable);
      throw localThrowable;
    }
  }
  
  public void releaseOutputBuffer(int paramInt, boolean paramBoolean)
  {
    if (isNotMyThread())
    {
      LogUtils.w(this.TAG, "ignore call method releaseOutputBuffer for isNotMyThread");
      return;
    }
    Object localObject = null;
    if (LogUtils.isLogEnable())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this);
      ((StringBuilder)localObject).append(", releaseOutputBuffer render:");
      ((StringBuilder)localObject).append(paramBoolean);
      localObject = ((StringBuilder)localObject).toString();
      LogUtils.v(this.TAG, (String)localObject);
    }
    try
    {
      this.mHoldBufferOutIndex.remove(Integer.valueOf(paramInt));
      this.codec.releaseOutputBuffer(paramInt, paramBoolean);
    }
    catch (Throwable localThrowable)
    {
      if (this.state != ReuseCodecWrapper.CodecState.Flushed)
      {
        String str = this.TAG;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this);
        localStringBuilder.append(", releaseOutputBuffer failed, ignore e:");
        LogUtils.w(str, localStringBuilder.toString(), localThrowable);
      }
      paramInt = 0;
      if ((Build.VERSION.SDK_INT >= 21) && ((localThrowable instanceof MediaCodec.CodecException))) {
        paramInt = 70002;
      } else if ((localThrowable instanceof IllegalStateException)) {
        paramInt = 70001;
      }
      handleCoreAPIException(paramInt, (String)localObject, localThrowable);
    }
    this.decodeState = ReuseCodecWrapper.DecodeState.ReleaseOut;
  }
  
  @TargetApi(21)
  public void reset()
  {
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = localObject3;
    try
    {
      if (LogUtils.isLogEnable())
      {
        localObject1 = localObject3;
        localObject2 = new StringBuilder();
        localObject1 = localObject3;
        ((StringBuilder)localObject2).append(this);
        localObject1 = localObject3;
        ((StringBuilder)localObject2).append(", callMsg state:");
        localObject1 = localObject3;
        ((StringBuilder)localObject2).append(this.state);
        localObject1 = localObject3;
        localObject2 = ((StringBuilder)localObject2).toString();
        localObject1 = localObject2;
        LogUtils.d(this.TAG, (String)localObject2);
      }
      localObject1 = localObject2;
      if (!isNeedKeep())
      {
        localObject1 = localObject2;
        this.codec.reset();
        localObject1 = localObject2;
        this.state = ReuseCodecWrapper.CodecState.Uninitialized;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      int i = 0;
      if (!(localThrowable instanceof MediaCodec.CodecException))
      {
        if ((localThrowable instanceof IllegalStateException)) {
          i = 80000;
        }
      }
      else {
        i = 80001;
      }
      handleCoreAPIException(i, localObject1, localThrowable);
      throw localThrowable;
    }
  }
  
  public final void setCallback(@Nullable CodecCallback paramCodecCallback)
  {
    this.callback = paramCodecCallback;
  }
  
  @NonNull
  public ReuseHelper.ReuseType setCanReuseType(@NonNull FormatWrapper paramFormatWrapper)
  {
    this.reuseType = canReuse(paramFormatWrapper);
    return this.reuseType;
  }
  
  public void setCodecCallback(@Nullable CodecCallback paramCodecCallback)
  {
    this.callback = paramCodecCallback;
  }
  
  @TargetApi(23)
  public void setOutputSurface(@NonNull Surface paramSurface)
  {
    innerSetOutputSurface(paramSurface, false);
  }
  
  public void start()
  {
    if (this.state != ReuseCodecWrapper.CodecState.Configured)
    {
      localObject1 = this.TAG;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("start ignore:");
      ((StringBuilder)localObject2).append(this.state);
      LogUtils.d((String)localObject1, ((StringBuilder)localObject2).toString());
      return;
    }
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = localObject3;
    try
    {
      if (LogUtils.isLogEnable())
      {
        localObject1 = localObject3;
        localObject2 = new StringBuilder();
        localObject1 = localObject3;
        ((StringBuilder)localObject2).append(this);
        localObject1 = localObject3;
        ((StringBuilder)localObject2).append(", start state:");
        localObject1 = localObject3;
        ((StringBuilder)localObject2).append(this.state);
        localObject1 = localObject3;
        localObject2 = ((StringBuilder)localObject2).toString();
        localObject1 = localObject2;
        LogUtils.d(this.TAG, (String)localObject2);
      }
      localObject1 = localObject2;
      if (this.state == ReuseCodecWrapper.CodecState.Configured)
      {
        localObject1 = localObject2;
        this.codec.start();
        localObject1 = localObject2;
        this.state = ReuseCodecWrapper.CodecState.Running;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      int i = 0;
      if ((Build.VERSION.SDK_INT >= 21) && ((localThrowable instanceof MediaCodec.CodecException))) {
        i = 20001;
      } else if ((localThrowable instanceof IllegalStateException)) {
        i = 20000;
      }
      handleCoreAPIException(i, (String)localObject1, localThrowable);
      throw localThrowable;
    }
  }
  
  public void stop()
  {
    String str;
    StringBuilder localStringBuilder;
    if (LogUtils.isLogEnable())
    {
      str = this.TAG;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this);
      localStringBuilder.append(", stop");
      LogUtils.d(str, localStringBuilder.toString());
    }
    if (!isNeedKeep())
    {
      if (LogUtils.isLogEnable())
      {
        str = this.TAG;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(this);
        localStringBuilder.append(", codec real stop");
        LogUtils.d(str, localStringBuilder.toString());
      }
      try
      {
        this.codec.stop();
        this.state = ReuseCodecWrapper.CodecState.Uninitialized;
        return;
      }
      catch (IllegalStateException localIllegalStateException)
      {
        this.state = ReuseCodecWrapper.CodecState.Uninitialized;
        LogUtils.e(this.TAG, "stop failed", localIllegalStateException);
        throw localIllegalStateException;
      }
    }
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(super.toString());
    localStringBuilder.append(" mReleaseCalled:");
    localStringBuilder.append(this.mReleaseCalled);
    localStringBuilder.append(" isRecycled:");
    localStringBuilder.append(this.isRecycled);
    return localStringBuilder.toString();
  }
  
  public void trackCantReuse()
  {
    this.mCantReuseCount += 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tmediacodec.codec.ReuseCodecWrapper
 * JD-Core Version:    0.7.0.1
 */