package com.tencent.tmediacodec.codec;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCrypto;
import android.media.MediaDescrambler;
import android.media.MediaFormat;
import android.os.Build.VERSION;
import android.util.Log;
import android.view.Surface;
import com.tencent.tmediacodec.TCodecManager;
import com.tencent.tmediacodec.TCodecManager.Companion;
import com.tencent.tmediacodec.callback.CodecCallback;
import com.tencent.tmediacodec.hook.HookManager;
import com.tencent.tmediacodec.hook.SurfaceCallback;
import com.tencent.tmediacodec.reuse.ReuseHelper;
import com.tencent.tmediacodec.reuse.ReuseHelper.AdaptationWorkaroundMode;
import com.tencent.tmediacodec.reuse.ReuseHelper.ReuseType;
import com.tencent.tmediacodec.util.LogUtils;
import com.tencent.tmediacodec.util.TUtils;
import com.tencent.tmediacodec.util.ThreadManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tmediacodec/codec/ReuseCodecWrapper;", "Lcom/tencent/tmediacodec/codec/CodecWrapper;", "codec", "Landroid/media/MediaCodec;", "format", "Lcom/tencent/tmediacodec/codec/FormatWrapper;", "(Landroid/media/MediaCodec;Lcom/tencent/tmediacodec/codec/FormatWrapper;)V", "adaptationMode", "Lcom/tencent/tmediacodec/reuse/ReuseHelper$AdaptationWorkaroundMode;", "adaptive", "", "getAdaptive", "()Z", "setAdaptive", "(Z)V", "callback", "Lcom/tencent/tmediacodec/callback/CodecCallback;", "getCallback", "()Lcom/tencent/tmediacodec/callback/CodecCallback;", "setCallback", "(Lcom/tencent/tmediacodec/callback/CodecCallback;)V", "capabilities", "Landroid/media/MediaCodecInfo$CodecCapabilities;", "getCapabilities", "()Landroid/media/MediaCodecInfo$CodecCapabilities;", "setCapabilities", "(Landroid/media/MediaCodecInfo$CodecCapabilities;)V", "getCodec", "()Landroid/media/MediaCodec;", "codecMaxValues", "Lcom/tencent/tmediacodec/codec/CodecMaxValues;", "getCodecMaxValues", "()Lcom/tencent/tmediacodec/codec/CodecMaxValues;", "codecName", "", "<set-?>", "Lcom/tencent/tmediacodec/codec/ReuseCodecWrapper$DecodeState;", "decodeState", "getDecodeState", "()Lcom/tencent/tmediacodec/codec/ReuseCodecWrapper$DecodeState;", "getFormat", "()Lcom/tencent/tmediacodec/codec/FormatWrapper;", "hasReused", "getHasReused", "setHasReused", "isNotMyThread", "mHasConfigureCalled", "mHoldBufferOutIndex", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "mStoreToRelease", "", "Landroid/graphics/SurfaceTexture;", "mSurface", "Landroid/view/Surface;", "getMSurface", "()Landroid/view/Surface;", "setMSurface", "(Landroid/view/Surface;)V", "mSurfaceTextureName", "mThreadId", "", "nThreadIdHistory", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "reuseType", "Lcom/tencent/tmediacodec/reuse/ReuseHelper$ReuseType;", "getReuseType", "()Lcom/tencent/tmediacodec/reuse/ReuseHelper$ReuseType;", "setReuseType", "(Lcom/tencent/tmediacodec/reuse/ReuseHelper$ReuseType;)V", "secure", "getSecure", "setSecure", "Lcom/tencent/tmediacodec/codec/ReuseCodecWrapper$CodecState;", "state", "getState", "()Lcom/tencent/tmediacodec/codec/ReuseCodecWrapper$CodecState;", "attachThread", "", "canReuse", "newFormat", "configure", "Landroid/media/MediaFormat;", "surface", "crypto", "Landroid/media/MediaCrypto;", "flags", "descrambler", "Landroid/media/MediaDescrambler;", "dequeueInputBuffer", "timeoutUs", "dequeueOutputBuffer", "info", "Landroid/media/MediaCodec$BufferInfo;", "flush", "getMediaCodec", "handleCoreAPIException", "callMsg", "e", "", "innerSetOutputSurface", "callByInner", "isNeedKeep", "prepareToReUse", "processInputBufferWithReConfig", "index", "offset", "size", "presentationTimeUs", "queueInputBuffer", "queueInputBufferForAdaptation", "recycle", "release", "releaseOutputBuffer", "render", "renderTimestampNs", "releaseStoreSurfaceTexture", "async", "releaseSurfaceTexture", "toReleaseSet", "", "releaseUnHandleBufferIndexs", "reset", "setCanReuseType", "setCodecCallback", "codecCallback", "setOutputSurface", "setSurface", "start", "stop", "CodecState", "Companion", "DecodeState", "tmediacodec_lib_debug"}, k=1, mv={1, 1, 15})
public abstract class ReuseCodecWrapper
  implements CodecWrapper
{
  public static final ReuseCodecWrapper.Companion Companion = new ReuseCodecWrapper.Companion(null);
  @NotNull
  public static final String TAG = "ReuseCodecWrapper";
  private final ReuseHelper.AdaptationWorkaroundMode adaptationMode;
  private boolean adaptive;
  @Nullable
  private CodecCallback callback;
  @Nullable
  private MediaCodecInfo.CodecCapabilities capabilities;
  @NotNull
  private final MediaCodec codec;
  @NotNull
  private final CodecMaxValues codecMaxValues;
  private final String codecName;
  @NotNull
  private ReuseCodecWrapper.DecodeState decodeState;
  @NotNull
  private final FormatWrapper format;
  private boolean hasReused;
  private boolean mHasConfigureCalled;
  private final HashSet<Integer> mHoldBufferOutIndex;
  private final Set<SurfaceTexture> mStoreToRelease;
  @Nullable
  private Surface mSurface;
  private String mSurfaceTextureName;
  private long mThreadId;
  private final ArrayList<Long> nThreadIdHistory;
  @NotNull
  private ReuseHelper.ReuseType reuseType;
  private boolean secure;
  @NotNull
  private ReuseCodecWrapper.CodecState state;
  
  public ReuseCodecWrapper(@NotNull MediaCodec paramMediaCodec, @NotNull FormatWrapper paramFormatWrapper)
  {
    this.codec = paramMediaCodec;
    this.format = paramFormatWrapper;
    this.state = ReuseCodecWrapper.CodecState.Uninitialized;
    this.decodeState = ReuseCodecWrapper.DecodeState.Started;
    this.mSurfaceTextureName = "";
    this.codecMaxValues = new CodecMaxValues(this.format.getMaxWidth(), this.format.getMaxHeight(), this.format.getMaxInputSize());
    this.codecName = TUtils.INSTANCE.getCodeName(this.codec);
    this.adaptationMode = ReuseHelper.INSTANCE.codecAdaptationWorkaroundMode(this.codecName);
    this.mHoldBufferOutIndex = new HashSet();
    this.nThreadIdHistory = new ArrayList();
    this.reuseType = ReuseHelper.ReuseType.KEEP_CODEC_RESULT_NO;
    this.mStoreToRelease = ((Set)new LinkedHashSet());
    if (Build.VERSION.SDK_INT >= 18) {
      this.capabilities = this.codec.getCodecInfo().getCapabilitiesForType(this.format.getSampleMimeType());
    }
    paramMediaCodec = this.capabilities;
    if (paramMediaCodec != null)
    {
      if ((this.capabilities == null) || (!TUtils.INSTANCE.isAdaptive(paramMediaCodec))) {
        break label240;
      }
      bool1 = true;
      this.adaptive = bool1;
      if ((this.capabilities == null) || (!TUtils.INSTANCE.isSecure(paramMediaCodec))) {
        break label245;
      }
    }
    label240:
    label245:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.secure = bool1;
      return;
      bool1 = false;
      break;
    }
  }
  
  private final void attachThread()
  {
    Thread localThread = Thread.currentThread();
    Intrinsics.checkExpressionValueIsNotNull(localThread, "Thread.currentThread()");
    long l = localThread.getId();
    if (this.nThreadIdHistory.contains(Long.valueOf(l))) {
      return;
    }
    this.mThreadId = l;
    this.nThreadIdHistory.add(Long.valueOf(this.mThreadId));
  }
  
  private final void handleCoreAPIException(String paramString, Throwable paramThrowable)
  {
    paramString = paramString + " exception:\n";
    CodecCallback localCodecCallback = this.callback;
    if (localCodecCallback != null) {
      localCodecCallback.onReuseCodecAPIException(paramString, paramThrowable);
    }
    LogUtils.INSTANCE.e("ReuseCodecWrapper", paramString, paramThrowable);
  }
  
  @TargetApi(23)
  private final void innerSetOutputSurface(Surface paramSurface, boolean paramBoolean)
  {
    String str = this + ", call innerSetOutputSurface surface:" + paramSurface + "  decodeState:" + this.decodeState + " callByInner:" + paramBoolean;
    LogUtils.INSTANCE.d("ReuseCodecWrapper", str);
    try
    {
      this.codec.setOutputSurface(paramSurface);
      setSurface(paramSurface);
      releaseStoreSurfaceTexture$default(this, false, 1, null);
      return;
    }
    catch (Throwable paramSurface)
    {
      handleCoreAPIException(str, paramSurface);
      throw paramSurface;
    }
  }
  
  private final boolean isNotMyThread()
  {
    Thread localThread = Thread.currentThread();
    Intrinsics.checkExpressionValueIsNotNull(localThread, "Thread.currentThread()");
    return localThread.getId() != this.mThreadId;
  }
  
  private final void processInputBufferWithReConfig(int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4)
  {
    this.codec.queueInputBuffer(paramInt1, paramInt2, paramInt3, paramLong, paramInt4);
  }
  
  private final void queueInputBufferForAdaptation(int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4)
  {
    ReuseHelper.ReuseType localReuseType = this.reuseType;
    switch (ReuseCodecWrapper.WhenMappings.$EnumSwitchMapping$0[localReuseType.ordinal()])
    {
    default: 
      return;
    case 1: 
      LogUtils.w$default(LogUtils.INSTANCE, "ReuseCodecWrapper", "queueInputBufferForAdaptation error for KEEP_CODEC_RESULT_NO", null, 4, null);
      return;
    case 2: 
      processInputBufferWithReConfig(paramInt1, paramInt2, paramInt3, paramLong, paramInt4);
      return;
    }
    this.codec.queueInputBuffer(paramInt1, paramInt2, paramInt3, paramLong, paramInt4);
  }
  
  private final void releaseStoreSurfaceTexture(boolean paramBoolean)
  {
    LogUtils.INSTANCE.d("ReuseCodecWrapper", this + ", releaseStoreSurfaceTexture mStoreToRelease:" + this.mStoreToRelease);
    List localList = CollectionsKt.toList((Iterable)this.mStoreToRelease);
    this.mStoreToRelease.clear();
    if (paramBoolean)
    {
      ThreadManager.INSTANCE.execute((Runnable)new ReuseCodecWrapper.releaseStoreSurfaceTexture.1(this, localList));
      return;
    }
    releaseSurfaceTexture(localList);
  }
  
  private final void releaseSurfaceTexture(List<? extends SurfaceTexture> paramList)
  {
    LogUtils.INSTANCE.d("ReuseCodecWrapper", this + ", releaseSurfaceTexture toReleaseSet:" + paramList);
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext())
    {
      SurfaceTexture localSurfaceTexture = (SurfaceTexture)paramList.next();
      HookManager.INSTANCE.realReleaseSurfaceTexture(localSurfaceTexture);
    }
  }
  
  private final void releaseUnHandleBufferIndexs()
  {
    if ((this instanceof VideoCodecWrapper)) {
      LogUtils.w$default(LogUtils.INSTANCE, "ReuseCodecWrapper", "releaseUnHandleBufferIndexs " + this.mHoldBufferOutIndex + "  address:" + this, null, 4, null);
    }
    Iterator localIterator = new HashSet((Collection)this.mHoldBufferOutIndex).iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      if (Intrinsics.compare(localInteger.intValue(), 0) > 0) {
        try
        {
          Intrinsics.checkExpressionValueIsNotNull(localInteger, "index");
          releaseOutputBuffer(localInteger.intValue(), true);
        }
        catch (Throwable localThrowable) {}
      }
    }
    this.mHoldBufferOutIndex.clear();
  }
  
  private final void setSurface(Surface paramSurface)
  {
    HookManager.INSTANCE.unHookSurfaceCallback(this.mSurfaceTextureName);
    this.mSurface = paramSurface;
    if (paramSurface != null) {}
    for (String str = TUtils.INSTANCE.getSurfaceTextureName(paramSurface);; str = "")
    {
      this.mSurfaceTextureName = str;
      if (paramSurface != null) {
        HookManager.INSTANCE.hookSurfaceCallback(this.mSurfaceTextureName, (SurfaceCallback)new ReuseCodecWrapper.setSurface..inlined.also.lambda.1(this));
      }
      return;
    }
  }
  
  @NotNull
  public abstract ReuseHelper.ReuseType canReuse(@NotNull FormatWrapper paramFormatWrapper);
  
  @TargetApi(26)
  public void configure(@NotNull MediaFormat paramMediaFormat, @Nullable Surface paramSurface, int paramInt, @Nullable MediaDescrambler paramMediaDescrambler)
  {
    Intrinsics.checkParameterIsNotNull(paramMediaFormat, "format");
    String str = this + ", configure mediaFormat:" + paramMediaFormat + " surface:" + paramSurface + " flags:" + paramInt + " descrambler:" + paramMediaDescrambler + " state:" + this.state + " mHasConfigureCalled：" + this.mHasConfigureCalled;
    this.mHasConfigureCalled = true;
    try
    {
      LogUtils.INSTANCE.d("ReuseCodecWrapper", str);
      setSurface(paramSurface);
      if (this.state == ReuseCodecWrapper.CodecState.Uninitialized)
      {
        LogUtils.INSTANCE.i("ReuseCodecWrapper", this + ", real configure");
        this.codec.configure(paramMediaFormat, paramSurface, paramInt, paramMediaDescrambler);
        this.state = ReuseCodecWrapper.CodecState.Configured;
        return;
      }
      if (paramSurface != null)
      {
        innerSetOutputSurface$default(this, paramSurface, false, 2, null);
        return;
      }
    }
    catch (Throwable paramMediaFormat)
    {
      handleCoreAPIException(str, paramMediaFormat);
      throw paramMediaFormat;
    }
  }
  
  public void configure(@NotNull MediaFormat paramMediaFormat, @Nullable Surface paramSurface, @Nullable MediaCrypto paramMediaCrypto, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramMediaFormat, "format");
    String str = this + ", configure mediaFormat:" + paramMediaFormat + " surface:" + paramSurface + " crypto:" + paramMediaCrypto + " flags:" + paramInt + " state:" + this.state + " mHasConfigureCalled：" + this.mHasConfigureCalled;
    this.mHasConfigureCalled = true;
    try
    {
      LogUtils.INSTANCE.d("ReuseCodecWrapper", str);
      setSurface(paramSurface);
      if (this.state == ReuseCodecWrapper.CodecState.Uninitialized)
      {
        LogUtils.INSTANCE.i("ReuseCodecWrapper", this + ", real configure");
        this.codec.configure(paramMediaFormat, paramSurface, paramMediaCrypto, paramInt);
        this.state = ReuseCodecWrapper.CodecState.Configured;
        return;
      }
      if (paramSurface != null)
      {
        innerSetOutputSurface$default(this, paramSurface, false, 2, null);
        return;
      }
    }
    catch (Throwable paramMediaFormat)
    {
      handleCoreAPIException(str, paramMediaFormat);
      throw paramMediaFormat;
    }
  }
  
  public int dequeueInputBuffer(long paramLong)
  {
    attachThread();
    if (isNotMyThread())
    {
      LogUtils.w$default(LogUtils.INSTANCE, "ReuseCodecWrapper", "ignore call method dequeueInputBuffer for isNotMyThread", null, 4, null);
      return -1;
    }
    String str = this + ", dequeueInputBuffer state:" + this.state + " decodeState:" + this.decodeState;
    try
    {
      LogUtils.INSTANCE.v("ReuseCodecWrapper", str);
      int i = this.codec.dequeueInputBuffer(paramLong);
      this.decodeState = ReuseCodecWrapper.DecodeState.DequeueIn;
      this.state = ReuseCodecWrapper.CodecState.Running;
      return i;
    }
    catch (Throwable localThrowable)
    {
      handleCoreAPIException(str, localThrowable);
      throw localThrowable;
    }
  }
  
  public int dequeueOutputBuffer(@NotNull MediaCodec.BufferInfo paramBufferInfo, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramBufferInfo, "info");
    if (isNotMyThread())
    {
      LogUtils.w$default(LogUtils.INSTANCE, "ReuseCodecWrapper", "ignore call method dequeueOutputBuffer for isNotMyThread", null, 4, null);
      return -1;
    }
    String str = this + ", dequeueOutputBuffer";
    try
    {
      int i = this.codec.dequeueOutputBuffer(paramBufferInfo, paramLong);
      if ((this instanceof VideoCodecWrapper)) {
        LogUtils.INSTANCE.v("ReuseCodecWrapper", str + " outIndex:" + i);
      }
      this.mHoldBufferOutIndex.add(Integer.valueOf(i));
      this.decodeState = ReuseCodecWrapper.DecodeState.DequeueOut;
      return i;
    }
    catch (Throwable paramBufferInfo)
    {
      handleCoreAPIException(str, paramBufferInfo);
      throw paramBufferInfo;
    }
  }
  
  public void flush()
  {
    String str = this + ", flush state:" + this.state;
    try
    {
      LogUtils.INSTANCE.d("ReuseCodecWrapper", str);
      this.codec.flush();
      this.state = ReuseCodecWrapper.CodecState.Flushed;
      return;
    }
    catch (Throwable localThrowable)
    {
      handleCoreAPIException(str, localThrowable);
      throw localThrowable;
    }
  }
  
  public final boolean getAdaptive()
  {
    return this.adaptive;
  }
  
  @Nullable
  public final CodecCallback getCallback()
  {
    return this.callback;
  }
  
  @Nullable
  public final MediaCodecInfo.CodecCapabilities getCapabilities()
  {
    return this.capabilities;
  }
  
  @NotNull
  public final MediaCodec getCodec()
  {
    return this.codec;
  }
  
  @NotNull
  public final CodecMaxValues getCodecMaxValues()
  {
    return this.codecMaxValues;
  }
  
  @NotNull
  public final ReuseCodecWrapper.DecodeState getDecodeState()
  {
    return this.decodeState;
  }
  
  @NotNull
  public final FormatWrapper getFormat()
  {
    return this.format;
  }
  
  protected final boolean getHasReused()
  {
    return this.hasReused;
  }
  
  @Nullable
  protected final Surface getMSurface()
  {
    return this.mSurface;
  }
  
  @NotNull
  public MediaCodec getMediaCodec()
  {
    return this.codec;
  }
  
  @NotNull
  protected final ReuseHelper.ReuseType getReuseType()
  {
    return this.reuseType;
  }
  
  public final boolean getSecure()
  {
    return this.secure;
  }
  
  @NotNull
  public final ReuseCodecWrapper.CodecState getState()
  {
    return this.state;
  }
  
  public boolean isNeedKeep()
  {
    return TCodecManager.Companion.getInstance().isEnable();
  }
  
  public void prepareToReUse()
  {
    flush();
    releaseUnHandleBufferIndexs();
    this.hasReused = true;
  }
  
  public void queueInputBuffer(int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4)
  {
    if (isNotMyThread())
    {
      LogUtils.w$default(LogUtils.INSTANCE, "ReuseCodecWrapper", "ignore call method queueInputBuffer for isNotMyThread", null, 4, null);
      return;
    }
    String str = this + ", queueInputBuffer index:" + paramInt1 + " offset:" + paramInt2 + " size:" + paramInt3 + " presentationTimeUs:" + paramLong + ' ' + "flags:" + paramInt4 + " state:" + this.state + " decodeState:" + this.decodeState;
    LogUtils.INSTANCE.v("ReuseCodecWrapper", str);
    if (paramInt4 == 4) {}
    for (int i = 0;; i = paramInt4) {
      for (;;)
      {
        try
        {
          if (this.hasReused)
          {
            queueInputBufferForAdaptation(paramInt1, paramInt2, paramInt3, paramLong, i);
            Unit localUnit1 = Unit.INSTANCE;
            this.decodeState = ReuseCodecWrapper.DecodeState.QueueIn;
            return;
          }
        }
        catch (Throwable localThrowable)
        {
          handleCoreAPIException(str, localThrowable);
          throw localThrowable;
        }
        this.codec.queueInputBuffer(paramInt1, paramInt2, paramInt3, paramLong, paramInt4);
        Unit localUnit2 = Unit.INSTANCE;
      }
    }
  }
  
  public final void recycle()
  {
    LogUtils.INSTANCE.d("ReuseCodecWrapper", this + ", recycle ...... stack:" + Log.getStackTraceString(new Throwable()));
    this.mHasConfigureCalled = false;
    ThreadManager.INSTANCE.runOnSubThread((Function0)new ReuseCodecWrapper.recycle.1(this));
    this.state = ReuseCodecWrapper.CodecState.Uninitialized;
  }
  
  public void release()
  {
    LogUtils.INSTANCE.d("ReuseCodecWrapper", "call release mHoldBufferOutIndex:" + this.mHoldBufferOutIndex);
    this.mHasConfigureCalled = false;
    if (!isNeedKeep())
    {
      LogUtils.w$default(LogUtils.INSTANCE, "ReuseCodecWrapper", "Don't not keep the codec, release it ...", null, 4, null);
      TCodecManager.Companion.getInstance().removeCodecFromRunningPool((CodecWrapper)this);
      recycle();
      this.state = ReuseCodecWrapper.CodecState.Released;
      return;
    }
    TCodecManager.Companion.getInstance().recycleCodecFromRunning((CodecWrapper)this);
  }
  
  @TargetApi(21)
  public void releaseOutputBuffer(int paramInt, long paramLong)
  {
    if ((this instanceof VideoCodecWrapper)) {
      LogUtils.INSTANCE.v("ReuseCodecWrapper", "releaseOutputBuffer ...  " + paramInt);
    }
    this.mHoldBufferOutIndex.remove(Integer.valueOf(paramInt));
    this.codec.releaseOutputBuffer(paramInt, paramLong);
    this.decodeState = ReuseCodecWrapper.DecodeState.ReleaseOut;
  }
  
  public void releaseOutputBuffer(int paramInt, boolean paramBoolean)
  {
    if ((this instanceof VideoCodecWrapper)) {
      LogUtils.INSTANCE.v("ReuseCodecWrapper", "releaseOutputBuffer " + paramInt);
    }
    try
    {
      this.mHoldBufferOutIndex.remove(Integer.valueOf(paramInt));
      this.codec.releaseOutputBuffer(paramInt, paramBoolean);
      this.decodeState = ReuseCodecWrapper.DecodeState.ReleaseOut;
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        if (this.state != ReuseCodecWrapper.CodecState.Flushed) {
          LogUtils.INSTANCE.w("ReuseCodecWrapper", this + ", releaseOutputBuffer failed, ignore e:", localThrowable);
        }
      }
    }
  }
  
  @TargetApi(21)
  public void reset()
  {
    String str = this + ", callMsg state:" + this.state;
    try
    {
      LogUtils.INSTANCE.d("ReuseCodecWrapper", str);
      if (!isNeedKeep())
      {
        this.codec.reset();
        this.state = ReuseCodecWrapper.CodecState.Uninitialized;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      handleCoreAPIException(str, localThrowable);
      throw localThrowable;
    }
  }
  
  public final void setAdaptive(boolean paramBoolean)
  {
    this.adaptive = paramBoolean;
  }
  
  public final void setCallback(@Nullable CodecCallback paramCodecCallback)
  {
    this.callback = paramCodecCallback;
  }
  
  @NotNull
  public ReuseHelper.ReuseType setCanReuseType(@NotNull FormatWrapper paramFormatWrapper)
  {
    Intrinsics.checkParameterIsNotNull(paramFormatWrapper, "newFormat");
    this.reuseType = canReuse(paramFormatWrapper);
    return this.reuseType;
  }
  
  public final void setCapabilities(@Nullable MediaCodecInfo.CodecCapabilities paramCodecCapabilities)
  {
    this.capabilities = paramCodecCapabilities;
  }
  
  public void setCodecCallback(@Nullable CodecCallback paramCodecCallback)
  {
    this.callback = paramCodecCallback;
  }
  
  protected final void setHasReused(boolean paramBoolean)
  {
    this.hasReused = paramBoolean;
  }
  
  protected final void setMSurface(@Nullable Surface paramSurface)
  {
    this.mSurface = paramSurface;
  }
  
  @TargetApi(23)
  public void setOutputSurface(@NotNull Surface paramSurface)
  {
    Intrinsics.checkParameterIsNotNull(paramSurface, "surface");
    innerSetOutputSurface(paramSurface, false);
  }
  
  protected final void setReuseType(@NotNull ReuseHelper.ReuseType paramReuseType)
  {
    Intrinsics.checkParameterIsNotNull(paramReuseType, "<set-?>");
    this.reuseType = paramReuseType;
  }
  
  public final void setSecure(boolean paramBoolean)
  {
    this.secure = paramBoolean;
  }
  
  public void start()
  {
    String str = this + ", start state:" + this.state;
    try
    {
      LogUtils.INSTANCE.d("ReuseCodecWrapper", str);
      if (this.state == ReuseCodecWrapper.CodecState.Configured)
      {
        this.codec.start();
        this.state = ReuseCodecWrapper.CodecState.Running;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      handleCoreAPIException(str, localThrowable);
      throw localThrowable;
    }
  }
  
  public void stop()
  {
    if (!isNeedKeep())
    {
      this.codec.stop();
      this.state = ReuseCodecWrapper.CodecState.Uninitialized;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tmediacodec.codec.ReuseCodecWrapper
 * JD-Core Version:    0.7.0.1
 */