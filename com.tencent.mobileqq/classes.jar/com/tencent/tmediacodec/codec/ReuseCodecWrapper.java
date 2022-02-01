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
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class ReuseCodecWrapper
  implements CodecWrapper
{
  public static final int CANT_REUSE_LIMIT = 3;
  public static final int ID_HISTORY_LIMIT = 100;
  public static final int METHOD_DEQUEUE_INPUT_BUFFER = 0;
  public static final int METHOD_DEQUEUE_OUTPUT_BUFFER = 1;
  public static final String TAG = "ReuseCodecWrapper";
  public static final int TRY_AGAIN_LATER_LIMIT = 100;
  private static final HashMap<Surface, ReuseCodecWrapper> mSurfaceMap = new HashMap();
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
  public ReuseCodecWrapper.DecodeState decodeState = ReuseCodecWrapper.DecodeState.Started;
  @NonNull
  public final FormatWrapper format;
  private boolean hasReused;
  public boolean isRecycled;
  private int mCantReuseCount = 0;
  private int[] mDequeueInOutputTryAgainCount = new int[2];
  private boolean mErrorHappened = false;
  private boolean mHasAlwaysTryAgainError = false;
  private boolean mHasConfigureCalled;
  private final HashSet<Integer> mHoldBufferOutIndex = new HashSet();
  private boolean mReleaseCalled;
  private final Set<SurfaceTexture> mStoreToRelease = new LinkedHashSet();
  @Nullable
  protected Surface mSurface;
  private String mSurfaceTextureName = "";
  private long mThreadId;
  private final ArrayList<Long> mThreadIdHistory = new ArrayList();
  @NonNull
  private ReuseHelper.ReuseType reuseType = ReuseHelper.ReuseType.KEEP_CODEC_RESULT_NO;
  public boolean secure;
  @NonNull
  private ReuseCodecWrapper.CodecState state = ReuseCodecWrapper.CodecState.Uninitialized;
  
  public ReuseCodecWrapper(@NonNull MediaCodec paramMediaCodec, @NonNull FormatWrapper paramFormatWrapper)
  {
    this.codec = paramMediaCodec;
    this.format = paramFormatWrapper;
    this.codecMaxValues = new CodecMaxValues(paramFormatWrapper.maxWidth, paramFormatWrapper.maxHeight, paramFormatWrapper.maxInputSize);
    this.codecName = TUtils.getCodeName(this.codec);
    this.adaptationMode = ReuseHelper.codecAdaptationWorkaroundMode(this.codecName);
    if (Build.VERSION.SDK_INT >= 18) {
      this.capabilities = this.codec.getCodecInfo().getCapabilitiesForType(paramFormatWrapper.sampleMimeType);
    }
    if ((this.capabilities != null) && (TUtils.isAdaptive(this.capabilities)))
    {
      bool1 = true;
      this.adaptive = bool1;
      if ((this.capabilities == null) || (!TUtils.isSecure(this.capabilities))) {
        break label225;
      }
    }
    label225:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.secure = bool1;
      return;
      bool1 = false;
      break;
    }
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
    if (LogUtils.isLogEnable()) {
      LogUtils.d("ReuseCodecWrapper", this + " checkSurfaceBinding size:" + mSurfaceMap.size() + " mSurfaceMap:" + mSurfaceMap);
    }
    ReuseCodecWrapper localReuseCodecWrapper;
    if (mSurfaceMap.containsKey(paramSurface))
    {
      localReuseCodecWrapper = (ReuseCodecWrapper)mSurfaceMap.get(paramSurface);
      if ((localReuseCodecWrapper == null) || (!localReuseCodecWrapper.isReleaseCalled())) {
        break label156;
      }
    }
    label156:
    for (boolean bool = true;; bool = false)
    {
      if (LogUtils.isLogEnable()) {
        LogUtils.e("ReuseCodecWrapper", this + ", surface:" + paramSurface + " has been used by " + localReuseCodecWrapper + " isReleaseCalled" + bool + ", ignore but we can release it...");
      }
      if (bool) {
        localReuseCodecWrapper.recycle();
      }
      return;
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
        StringBuilder localStringBuilder = new StringBuilder("\n########################## " + this + " dumpInputBuffer ###################");
        paramInt1 = 0;
        if (paramInt1 < 4)
        {
          localStringBuilder.append("\n");
          paramInt3 = 0;
          if (paramInt3 < 16)
          {
            localStringBuilder.append(" ");
            localStringBuilder.append(byte2HexString(Byte.valueOf(localByteBuffer.get(paramInt1 * 4 + paramInt2 + paramInt3))));
            paramInt3 += 1;
            continue;
          }
        }
        else
        {
          if (!LogUtils.isLogEnable()) {
            break;
          }
          LogUtils.v("ReuseCodecWrapper", localStringBuilder.toString());
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        LogUtils.e("ReuseCodecWrapper", "dumpInputBuffer error", localThrowable);
        return;
      }
      paramInt1 += 1;
    }
  }
  
  private void dumpSurfaceMap(String paramString)
  {
    LogUtils.i("ReuseCodecWrapper", this + "    " + paramString + "     dumpSurfaceMap:" + mSurfaceMap);
  }
  
  private void handleCoreAPIException(int paramInt, String paramString, Throwable paramThrowable)
  {
    handleCoreAPIException(paramInt, paramString, paramThrowable, false, this.mSurface);
  }
  
  private void handleCoreAPIException(int paramInt, String paramString, Throwable paramThrowable, boolean paramBoolean, Surface paramSurface)
  {
    this.mErrorHappened = true;
    String str;
    if (paramThrowable == null) {
      str = "";
    }
    for (;;)
    {
      paramString = paramString + " handleCoreAPIException exception:" + str;
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
        LogUtils.e("ReuseCodecWrapper", "hasReused:" + this.hasReused + "    errorCode:" + i + ", " + paramString, paramThrowable);
        releaseCodecWhenError(i);
        return;
        str = paramThrowable.getLocalizedMessage();
      }
      catch (JSONException paramSurface)
      {
        for (;;)
        {
          paramSurface.printStackTrace();
        }
      }
    }
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
      LogUtils.w("ReuseCodecWrapper", this + ", innerSetOutputSurface error surface:" + paramSurface + " is same, stack:" + Log.getStackTraceString(new Throwable()));
      return;
    }
    String str = null;
    if (LogUtils.isLogEnable())
    {
      str = this + " configure, call innerSetOutputSurface surface:" + paramSurface + "  decodeState:" + this.decodeState + " callByInner:" + paramBoolean;
      LogUtils.d("ReuseCodecWrapper", str);
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
      i = 0;
      if (!(localThrowable instanceof IllegalStateException)) {
        break label170;
      }
    }
    int i = 30000;
    for (;;)
    {
      handleCoreAPIException(i, str, localThrowable, true, paramSurface);
      throw localThrowable;
      label170:
      if ((localThrowable instanceof IllegalArgumentException)) {
        i = 30001;
      }
    }
  }
  
  private boolean isAlwaysTryAgain(int paramInt1, int paramInt2)
  {
    boolean bool = false;
    if (paramInt2 == -1)
    {
      int[] arrayOfInt = this.mDequeueInOutputTryAgainCount;
      arrayOfInt[paramInt1] += 1;
      if (this.mDequeueInOutputTryAgainCount[paramInt1] > 100) {
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
        SurfaceTexture localSurfaceTexture = ((PreloadSurface)localSurface).getSurfaceTexture();
        if ((localSurfaceTexture instanceof PreloadSurfaceTexture)) {
          this.mStoreToRelease.add(localSurfaceTexture);
        }
        if (LogUtils.isLogEnable()) {
          LogUtils.d("ReuseCodecWrapper", "markPreloadSurfaceTexture oldSurface:" + localSurface + " success");
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      LogUtils.e("ReuseCodecWrapper", "markPreloadSurfaceTexture oldSurface:" + localSurface + " failed", localThrowable);
    }
  }
  
  private void onReuseCodec()
  {
    this.mDequeueInOutputTryAgainCount[0] = 0;
    this.mDequeueInOutputTryAgainCount[1] = 0;
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
    switch (ReuseCodecWrapper.5.$SwitchMap$com$tencent$tmediacodec$reuse$ReuseHelper$ReuseType[this.reuseType.ordinal()])
    {
    case 4: 
    default: 
      return;
    case 1: 
      LogUtils.w("ReuseCodecWrapper", "queueInputBufferForAdaptation error for KEEP_CODEC_RESULT_NO");
      return;
    case 2: 
      processInputBufferWithReConfig(paramInt1, paramInt2, paramInt3, paramLong, paramInt4);
      return;
    }
    this.codec.queueInputBuffer(paramInt1, paramInt2, paramInt3, paramLong, paramInt4);
  }
  
  private void realConfigure(@NonNull MediaFormat paramMediaFormat, @Nullable Surface paramSurface, int paramInt, @Nullable MediaDescrambler paramMediaDescrambler)
  {
    String str = null;
    if (LogUtils.isLogEnable())
    {
      str = this + ", configure mediaFormat:" + paramMediaFormat + " surface:" + paramSurface + " flags:" + paramInt + " descrambler:" + paramMediaDescrambler + " state:" + this.state + " mHasConfigureCalled：" + this.mHasConfigureCalled;
      LogUtils.d("ReuseCodecWrapper", str);
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
      paramInt = 0;
      if (!(paramMediaFormat instanceof MediaCodec.CodecException)) {
        break label150;
      }
    }
    paramInt = 10002;
    for (;;)
    {
      handleCoreAPIException(paramInt, str, paramMediaFormat, true, paramSurface);
      throw paramMediaFormat;
      label150:
      if ((paramMediaFormat instanceof IllegalStateException)) {
        paramInt = 10000;
      } else if ((paramMediaFormat instanceof MediaCodec.CryptoException)) {
        paramInt = 10001;
      }
    }
  }
  
  private void realConfigure(@NonNull MediaFormat paramMediaFormat, @Nullable Surface paramSurface, @Nullable MediaCrypto paramMediaCrypto, int paramInt)
  {
    Object localObject2 = null;
    String str = null;
    Object localObject1 = localObject2;
    try
    {
      if (LogUtils.isLogEnable())
      {
        localObject1 = localObject2;
        str = this + ", realConfigure mediaFormat:" + paramMediaFormat + " surface:" + paramSurface + " crypto:" + paramMediaCrypto + " flags:" + paramInt + " state:" + this.state + " mHasConfigureCalled：" + this.mHasConfigureCalled;
        localObject1 = str;
        LogUtils.d("ReuseCodecWrapper", str);
      }
      localObject1 = str;
      this.codec.configure(paramMediaFormat, paramSurface, paramMediaCrypto, paramInt);
      localObject1 = str;
      setSurface(paramSurface);
      localObject1 = str;
      this.state = ReuseCodecWrapper.CodecState.Configured;
      return;
    }
    catch (Throwable paramMediaFormat)
    {
      paramInt = 0;
      if (!(paramMediaFormat instanceof IllegalStateException)) {
        break label180;
      }
    }
    paramInt = 10000;
    for (;;)
    {
      handleCoreAPIException(paramInt, (String)localObject1, paramMediaFormat, true, paramSurface);
      throw paramMediaFormat;
      label180:
      if ((paramMediaFormat instanceof MediaCodec.CryptoException)) {
        paramInt = 10001;
      }
    }
  }
  
  private void releaseCodecWhenError(int paramInt)
  {
    if (paramInt < 40000) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        LogUtils.e("ReuseCodecWrapper", this + "    releaseCodecWhenError, errorCode:" + paramInt);
        release();
      }
      return;
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
    if (LogUtils.isLogEnable()) {
      LogUtils.d("ReuseCodecWrapper", this + ", releaseStoreSurfaceTexture mStoreToRelease:" + this.mStoreToRelease);
    }
    ArrayList localArrayList;
    if (!this.mStoreToRelease.isEmpty())
    {
      localArrayList = new ArrayList(this.mStoreToRelease);
      this.mStoreToRelease.clear();
      if (paramBoolean) {
        ThreadManager.execute(new ReuseCodecWrapper.3(this, localArrayList));
      }
    }
    else
    {
      return;
    }
    releaseSurfaceTexture(localArrayList);
  }
  
  private final void releaseSurfaceTexture(List<SurfaceTexture> paramList)
  {
    if (LogUtils.isLogEnable()) {
      LogUtils.d("ReuseCodecWrapper", this + ", releaseSurfaceTexture toReleaseSet:" + paramList);
    }
    LinkedHashSet localLinkedHashSet = new LinkedHashSet();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      SurfaceTexture localSurfaceTexture = (SurfaceTexture)paramList.next();
      HookManager.realReleaseSurfaceTexture(localSurfaceTexture);
      localLinkedHashSet.add(localSurfaceTexture.toString());
    }
    removeSurfaceBinding(localLinkedHashSet);
  }
  
  private final void removeStoreSurfaceTextureFromToReleaseSet(String paramString)
  {
    if (LogUtils.isLogEnable()) {
      LogUtils.d("ReuseCodecWrapper", this + ", removeStoreSurfaceTexture nameSurfaceTexture:" + paramString);
    }
    Iterator localIterator = this.mStoreToRelease.iterator();
    while (localIterator.hasNext()) {
      if (TextUtils.equals(localIterator.next().toString(), paramString)) {
        localIterator.remove();
      }
    }
  }
  
  private void removeSurfaceBinding(Set paramSet)
  {
    removeSurfaceBinding(paramSet, Collections.emptySet());
  }
  
  private void removeSurfaceBinding(Set paramSet1, Set paramSet2)
  {
    if (LogUtils.isLogEnable()) {
      LogUtils.d("ReuseCodecWrapper", this + ", removeSurfaceBinding toReleaseNameSet:" + paramSet1 + " toReleaseCodecSet:" + paramSet2);
    }
    Iterator localIterator = mSurfaceMap.entrySet().iterator();
    label147:
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      String str = TUtils.getSurfaceTextureName((Surface)localEntry.getKey());
      if ((paramSet1.contains(str)) || (paramSet2.contains(localEntry.getValue()))) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label147;
        }
        localIterator.remove();
        onSurfaceTextureUnbinding(str);
        break;
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
    if (LogUtils.isLogEnable()) {
      LogUtils.i("ReuseCodecWrapper", this + ", oldSurface:" + this.mSurface + " CodecWrapperSetSurface surface:" + paramSurface);
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
    Object localObject;
    if ((!this.mHasAlwaysTryAgainError) && (isAlwaysTryAgain(paramInt1, paramInt2)))
    {
      this.mHasAlwaysTryAgainError = true;
      StringBuilder localStringBuilder = new StringBuilder().append(this).append(", trackDecodeApi state:").append(this.state).append("  surfaceState:");
      if (this.mSurface == null) {
        break label95;
      }
      localObject = Boolean.valueOf(this.mSurface.isValid());
      localObject = localObject;
      if (paramInt1 != 0) {
        break label100;
      }
      handleCoreAPIException(40002, (String)localObject, null);
    }
    label95:
    label100:
    while (paramInt1 != 1)
    {
      return;
      localObject = null;
      break;
    }
    handleCoreAPIException(60002, (String)localObject, null);
  }
  
  public void attachThread()
  {
    long l = Thread.currentThread().getId();
    if (this.mThreadIdHistory.contains(Long.valueOf(l))) {}
    do
    {
      return;
      this.mThreadId = l;
      this.mThreadIdHistory.add(Long.valueOf(this.mThreadId));
    } while (this.mThreadIdHistory.size() <= 100);
    this.mThreadIdHistory.remove(0);
  }
  
  @NonNull
  public abstract ReuseHelper.ReuseType canReuse(@NonNull FormatWrapper paramFormatWrapper);
  
  @TargetApi(26)
  public void configure(@NonNull MediaFormat paramMediaFormat, @Nullable Surface paramSurface, int paramInt, @Nullable MediaDescrambler paramMediaDescrambler)
  {
    if (isNotMyThread()) {
      LogUtils.w("ReuseCodecWrapper", "ignore call method configure for isNotMyThread");
    }
    do
    {
      return;
      this.mHasConfigureCalled = true;
      try
      {
        this.mReleaseCalled = false;
        if (this.state == ReuseCodecWrapper.CodecState.Uninitialized)
        {
          realConfigure(paramMediaFormat, paramSurface, paramInt, paramMediaDescrambler);
          return;
        }
      }
      catch (Throwable paramMediaFormat)
      {
        throw paramMediaFormat;
      }
    } while (paramSurface == null);
    onReuseCodec();
    innerSetOutputSurface(paramSurface);
  }
  
  public void configure(@NonNull MediaFormat paramMediaFormat, @Nullable Surface paramSurface, @Nullable MediaCrypto paramMediaCrypto, int paramInt)
  {
    if (isNotMyThread()) {
      LogUtils.w("ReuseCodecWrapper", "ignore call method configure for isNotMyThread");
    }
    do
    {
      return;
      this.mHasConfigureCalled = true;
      try
      {
        this.mReleaseCalled = false;
        if (this.state == ReuseCodecWrapper.CodecState.Uninitialized)
        {
          realConfigure(paramMediaFormat, paramSurface, paramMediaCrypto, paramInt);
          return;
        }
      }
      catch (Throwable paramMediaFormat)
      {
        throw paramMediaFormat;
      }
    } while (paramSurface == null);
    onReuseCodec();
    innerSetOutputSurface(paramSurface);
  }
  
  public int dequeueInputBuffer(long paramLong)
  {
    int i = 0;
    if (isNotMyThread())
    {
      LogUtils.w("ReuseCodecWrapper", "ignore call method dequeueInputBuffer for isNotMyThread");
      return -1;
    }
    Object localObject2 = null;
    String str = null;
    Object localObject1 = localObject2;
    try
    {
      int j = this.codec.dequeueInputBuffer(paramLong);
      localObject1 = localObject2;
      if (LogUtils.isLogEnable())
      {
        localObject1 = localObject2;
        str = this + ", dequeueInputBuffer state:" + this.state + " decodeState:" + this.decodeState + " , result=" + j;
        localObject1 = str;
        LogUtils.v("ReuseCodecWrapper", str);
      }
      localObject1 = str;
      this.decodeState = ReuseCodecWrapper.DecodeState.DequeueIn;
      localObject1 = str;
      this.state = ReuseCodecWrapper.CodecState.Running;
      localObject1 = str;
      trackDecodeApi(0, j);
      return j;
    }
    catch (Throwable localThrowable)
    {
      if (!(localThrowable instanceof IllegalStateException)) {
        break label179;
      }
    }
    i = 40000;
    for (;;)
    {
      handleCoreAPIException(i, (String)localObject1, localThrowable);
      throw localThrowable;
      label179:
      if ((localThrowable instanceof IllegalArgumentException)) {
        i = 40001;
      }
    }
  }
  
  public int dequeueOutputBuffer(@NonNull MediaCodec.BufferInfo paramBufferInfo, long paramLong)
  {
    if (isNotMyThread())
    {
      LogUtils.w("ReuseCodecWrapper", "ignore call method dequeueOutputBuffer for isNotMyThread");
      return -1;
    }
    Object localObject = null;
    try
    {
      i = this.codec.dequeueOutputBuffer(paramBufferInfo, paramLong);
      String str;
      if (LogUtils.isLogEnable())
      {
        str = this + ", dequeueOutputBuffer outIndex:" + i;
        localObject = str;
        paramBufferInfo = str;
      }
      try
      {
        if ((this instanceof VideoCodecWrapper))
        {
          paramBufferInfo = str;
          LogUtils.v("ReuseCodecWrapper", str);
          localObject = str;
        }
        paramBufferInfo = localObject;
        this.mHoldBufferOutIndex.add(Integer.valueOf(i));
        paramBufferInfo = localObject;
        this.decodeState = ReuseCodecWrapper.DecodeState.DequeueOut;
        paramBufferInfo = localObject;
        trackDecodeApi(1, i);
        return i;
      }
      catch (Throwable localThrowable1) {}
    }
    catch (Throwable localThrowable2)
    {
      for (;;)
      {
        int i;
        paramBufferInfo = null;
      }
    }
    i = 0;
    if ((Build.VERSION.SDK_INT >= 21) && ((localThrowable1 instanceof MediaCodec.CodecException))) {
      i = 60001;
    }
    for (;;)
    {
      handleCoreAPIException(i, paramBufferInfo, localThrowable1);
      throw localThrowable1;
      if ((localThrowable1 instanceof IllegalStateException)) {
        i = 60000;
      }
    }
  }
  
  public void flush()
  {
    if (isNotMyThread()) {
      LogUtils.w("ReuseCodecWrapper", "call method flush for isNotMyThread...");
    }
    Object localObject2 = null;
    try
    {
      Object localObject1;
      if (LogUtils.isLogEnable())
      {
        localObject2 = this + ", flush state:" + this.state;
        localObject1 = localObject2;
      }
      i = 0;
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        LogUtils.d("ReuseCodecWrapper", (String)localObject2);
        localObject1 = localObject2;
        this.codec.flush();
        localObject1 = localObject2;
        this.state = ReuseCodecWrapper.CodecState.Flushed;
        return;
      }
      catch (Throwable localThrowable2)
      {
        for (;;)
        {
          int i;
          Object localObject3 = localThrowable1;
        }
      }
      localThrowable1 = localThrowable1;
      localObject3 = null;
      localObject2 = localThrowable1;
    }
    if ((Build.VERSION.SDK_INT >= 21) && ((localObject2 instanceof MediaCodec.CodecException))) {
      i = 90001;
    }
    for (;;)
    {
      handleCoreAPIException(i, (String)localObject3, (Throwable)localObject2);
      throw ((Throwable)localObject2);
      if ((localObject2 instanceof IllegalStateException)) {
        i = 90000;
      }
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
    if (this.state != ReuseCodecWrapper.CodecState.Flushed) {
      flush();
    }
    this.hasReused = true;
  }
  
  public void queueInputBuffer(int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4)
  {
    if (isNotMyThread())
    {
      LogUtils.w("ReuseCodecWrapper", "ignore call method queueInputBuffer for isNotMyThread");
      return;
    }
    String str;
    if (LogUtils.isLogEnable())
    {
      str = this + ", queueInputBuffer index:" + paramInt1 + " offset:" + paramInt2 + " size:" + paramInt3 + " presentationTimeUs:" + paramLong + ' ' + "flags:" + paramInt4 + " state:" + this.state + " decodeState:" + this.decodeState;
      LogUtils.v("ReuseCodecWrapper", str);
    }
    for (;;)
    {
      try
      {
        if (!this.hasReused) {
          break label190;
        }
        queueInputBufferForAdaptation(paramInt1, paramInt2, paramInt3, paramLong, paramInt4);
        this.decodeState = ReuseCodecWrapper.DecodeState.QueueIn;
        return;
      }
      catch (Throwable localThrowable)
      {
        paramInt1 = 0;
        if (Build.VERSION.SDK_INT < 21) {
          break label207;
        }
      }
      if ((localThrowable instanceof MediaCodec.CodecException)) {
        paramInt1 = 50001;
      }
      for (;;)
      {
        handleCoreAPIException(paramInt1, str, localThrowable);
        throw localThrowable;
        label190:
        this.codec.queueInputBuffer(paramInt1, paramInt2, paramInt3, paramLong, paramInt4);
        break;
        label207:
        if ((localThrowable instanceof IllegalStateException)) {
          paramInt1 = 50000;
        } else if ((localThrowable instanceof MediaCodec.CryptoException)) {
          paramInt1 = 50002;
        }
      }
      str = null;
    }
  }
  
  public final void recycle()
  {
    if (LogUtils.isLogEnable()) {
      LogUtils.d("ReuseCodecWrapper", this + ", recycle isRecycled:" + this.isRecycled + " ...... stack:" + Log.getStackTraceString(new Throwable()));
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
    if (LogUtils.isLogEnable()) {
      LogUtils.d("ReuseCodecWrapper", this + " call release mHoldBufferOutIndex:" + this.mHoldBufferOutIndex + " mReleaseCalled:" + this.mReleaseCalled + " stack:" + Log.getStackTraceString(new Throwable()));
    }
    this.mReleaseCalled = true;
    this.mHasConfigureCalled = false;
    if (isNeedKeep())
    {
      flush();
      TCodecManager.getInstance().recycleCodecFromRunning(this);
      return;
    }
    if (LogUtils.isLogEnable()) {
      LogUtils.w("ReuseCodecWrapper", "Don't not keep the codec, release it ..., mErrorHappened:" + this.mErrorHappened);
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
      LogUtils.w("ReuseCodecWrapper", "ignore call method releaseOutputBuffer for isNotMyThread");
      return;
    }
    Object localObject = null;
    if (LogUtils.isLogEnable())
    {
      String str = this + ", releaseOutputBuffer API21" + paramInt;
      localObject = str;
      if ((this instanceof VideoCodecWrapper))
      {
        LogUtils.v("ReuseCodecWrapper", str);
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
      if (Build.VERSION.SDK_INT < 21) {
        break label138;
      }
    }
    if ((localThrowable instanceof MediaCodec.CodecException)) {
      paramInt = 70002;
    }
    for (;;)
    {
      handleCoreAPIException(paramInt, localObject, localThrowable);
      throw localThrowable;
      label138:
      if ((localThrowable instanceof IllegalStateException)) {
        paramInt = 70001;
      }
    }
  }
  
  public void releaseOutputBuffer(int paramInt, boolean paramBoolean)
  {
    if (isNotMyThread())
    {
      LogUtils.w("ReuseCodecWrapper", "ignore call method releaseOutputBuffer for isNotMyThread");
      return;
    }
    String str;
    if (LogUtils.isLogEnable())
    {
      str = this + ", releaseOutputBuffer render:" + paramBoolean;
      LogUtils.v("ReuseCodecWrapper", str);
    }
    for (;;)
    {
      try
      {
        this.mHoldBufferOutIndex.remove(Integer.valueOf(paramInt));
        this.codec.releaseOutputBuffer(paramInt, paramBoolean);
        this.decodeState = ReuseCodecWrapper.DecodeState.ReleaseOut;
        return;
      }
      catch (Throwable localThrowable)
      {
        if (this.state != ReuseCodecWrapper.CodecState.Flushed) {
          LogUtils.w("ReuseCodecWrapper", this + ", releaseOutputBuffer failed, ignore e:", localThrowable);
        }
        paramInt = 0;
        if (Build.VERSION.SDK_INT < 21) {
          break label154;
        }
      }
      if ((localThrowable instanceof MediaCodec.CodecException)) {
        paramInt = 70002;
      }
      for (;;)
      {
        handleCoreAPIException(paramInt, str, localThrowable);
        break;
        label154:
        if ((localThrowable instanceof IllegalStateException)) {
          paramInt = 70001;
        }
      }
      str = null;
    }
  }
  
  @TargetApi(21)
  public void reset()
  {
    Object localObject2 = null;
    try
    {
      Object localObject1;
      if (LogUtils.isLogEnable())
      {
        localObject2 = this + ", callMsg state:" + this.state;
        localObject1 = localObject2;
      }
      i = 0;
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        LogUtils.d("ReuseCodecWrapper", (String)localObject2);
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
      catch (Throwable localThrowable2)
      {
        for (;;)
        {
          int i;
          Object localObject3 = localThrowable1;
        }
      }
      localThrowable1 = localThrowable1;
      localObject3 = null;
      localObject2 = localThrowable1;
    }
    if ((localObject2 instanceof MediaCodec.CodecException)) {
      i = 80001;
    }
    for (;;)
    {
      handleCoreAPIException(i, (String)localObject3, (Throwable)localObject2);
      throw ((Throwable)localObject2);
      if ((localObject2 instanceof IllegalStateException)) {
        i = 80000;
      }
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
    if (this.state != ReuseCodecWrapper.CodecState.Configured) {
      LogUtils.d("ReuseCodecWrapper", "start ignore:" + this.state);
    }
    for (;;)
    {
      return;
      String str2 = null;
      try
      {
        if (LogUtils.isLogEnable())
        {
          str2 = this + ", start state:" + this.state;
          str1 = str2;
        }
        try
        {
          LogUtils.d("ReuseCodecWrapper", str2);
          str1 = str2;
          if (this.state == ReuseCodecWrapper.CodecState.Configured)
          {
            str1 = str2;
            this.codec.start();
            str1 = str2;
            this.state = ReuseCodecWrapper.CodecState.Running;
            return;
          }
        }
        catch (Throwable localThrowable1) {}
      }
      catch (Throwable localThrowable2)
      {
        for (;;)
        {
          int i;
          String str1 = null;
        }
      }
    }
    i = 0;
    if ((Build.VERSION.SDK_INT >= 21) && ((localThrowable1 instanceof MediaCodec.CodecException))) {
      i = 20001;
    }
    for (;;)
    {
      handleCoreAPIException(i, str1, localThrowable1);
      throw localThrowable1;
      if ((localThrowable1 instanceof IllegalStateException)) {
        i = 20000;
      }
    }
  }
  
  public void stop()
  {
    if (LogUtils.isLogEnable()) {
      LogUtils.d("ReuseCodecWrapper", this + ", stop");
    }
    if (!isNeedKeep())
    {
      if (LogUtils.isLogEnable()) {
        LogUtils.d("ReuseCodecWrapper", this + ", codec real stop");
      }
      this.codec.stop();
      this.state = ReuseCodecWrapper.CodecState.Uninitialized;
    }
  }
  
  @NonNull
  public String toString()
  {
    return super.toString() + " mReleaseCalled:" + this.mReleaseCalled + " isRecycled:" + this.isRecycled;
  }
  
  public void trackCantReuse()
  {
    this.mCantReuseCount += 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmediacodec.codec.ReuseCodecWrapper
 * JD-Core Version:    0.7.0.1
 */