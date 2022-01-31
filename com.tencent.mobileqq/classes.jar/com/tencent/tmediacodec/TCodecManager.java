package com.tencent.tmediacodec;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaDescrambler;
import android.media.MediaFormat;
import android.view.Surface;
import com.tencent.tmediacodec.codec.AudioCodecWrapper;
import com.tencent.tmediacodec.codec.CodecWrapper;
import com.tencent.tmediacodec.codec.DirectCodecWrapper;
import com.tencent.tmediacodec.codec.FormatWrapper;
import com.tencent.tmediacodec.codec.FormatWrapper.Companion;
import com.tencent.tmediacodec.codec.ReuseCodecWrapper;
import com.tencent.tmediacodec.codec.ReuseCodecWrapper.Companion;
import com.tencent.tmediacodec.codec.VideoCodecWrapper;
import com.tencent.tmediacodec.pools.CodecWrapperManager;
import com.tencent.tmediacodec.preload.PreloadCodecManager;
import com.tencent.tmediacodec.preload.PreloadCodecManager.Companion;
import com.tencent.tmediacodec.reuse.ReuseHelper;
import com.tencent.tmediacodec.reuse.ReuseHelper.ReuseType;
import com.tencent.tmediacodec.reuse.ReusePolicy;
import com.tencent.tmediacodec.reuse.ReusePolicy.Companion;
import com.tencent.tmediacodec.util.ILogProxy;
import com.tencent.tmediacodec.util.LogUtils;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tmediacodec/TCodecManager;", "", "()V", "mAudioCodecManager", "Lcom/tencent/tmediacodec/pools/CodecWrapperManager;", "mCodecMap", "Ljava/util/HashMap;", "Lcom/tencent/tmediacodec/TMediaCodec;", "Lcom/tencent/tmediacodec/codec/CodecWrapper;", "Lkotlin/collections/HashMap;", "mConfigMethodCalled", "", "mContext", "Landroid/content/Context;", "mIsInited", "mPreloadCodecManager", "Lcom/tencent/tmediacodec/preload/PreloadCodecManager;", "mReuseEnable", "mReusePolicy", "Lcom/tencent/tmediacodec/reuse/ReusePolicy;", "mVideoCodecManager", "changeToReuseDisable", "", "configure", "format", "Landroid/media/MediaFormat;", "surface", "Landroid/view/Surface;", "crypto", "Landroid/media/MediaCrypto;", "flags", "", "tMediaCodec", "descrambler", "Landroid/media/MediaDescrambler;", "createDirectCodecWrapper", "mediaFormat", "createNewCodecWrapper", "getCodec", "getContext", "getReusePolicy", "init", "context", "isEnable", "obtainCodecWrapper", "isVideo", "Lcom/tencent/tmediacodec/codec/FormatWrapper;", "onCodecRunning", "codecWrapper", "preloadCodec", "firstSampleMimeType", "", "secondSampleMimeType", "recycleCodecFromRunning", "removeCodecFromRunningPool", "setLogEnable", "enable", "setLogLevel", "level", "setLogProxy", "logProxy", "Lcom/tencent/tmediacodec/util/ILogProxy;", "setReuseEnable", "setReusePolicy", "reusePolicy", "Companion", "tmediacodec_lib_debug"}, k=1, mv={1, 1, 15})
public final class TCodecManager
{
  public static final TCodecManager.Companion Companion = new TCodecManager.Companion(null);
  @NotNull
  public static final String TAG = "TCodecManager";
  @NotNull
  private static final Lazy instance$delegate = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0)TCodecManager.Companion.instance.2.INSTANCE);
  private final CodecWrapperManager mAudioCodecManager = new CodecWrapperManager();
  private final HashMap<TMediaCodec, CodecWrapper> mCodecMap = new HashMap();
  private boolean mConfigMethodCalled;
  private Context mContext;
  private boolean mIsInited;
  private final PreloadCodecManager mPreloadCodecManager = new PreloadCodecManager();
  private boolean mReuseEnable = true;
  private ReusePolicy mReusePolicy = ReusePolicy.Companion.getDEFAULT();
  private final CodecWrapperManager mVideoCodecManager = new CodecWrapperManager();
  
  private final void changeToReuseDisable()
  {
    this.mVideoCodecManager.clearAndReleaseAll();
    this.mAudioCodecManager.clearAndReleaseAll();
  }
  
  private final CodecWrapper createDirectCodecWrapper(MediaFormat paramMediaFormat)
  {
    LogUtils.INSTANCE.d("TCodecManager", "createNewCodecWrapper mediaFormat:" + paramMediaFormat);
    paramMediaFormat = MediaCodec.createDecoderByType(paramMediaFormat.getString("mime"));
    Intrinsics.checkExpressionValueIsNotNull(paramMediaFormat, "MediaCodec.createDecoderByType(mineType)");
    return (CodecWrapper)new DirectCodecWrapper(paramMediaFormat);
  }
  
  private final CodecWrapper createNewCodecWrapper(MediaFormat paramMediaFormat)
  {
    LogUtils.INSTANCE.d("TCodecManager", "createNewCodecWrapper mediaFormat:" + paramMediaFormat);
    String str = paramMediaFormat.getString("mime");
    FormatWrapper localFormatWrapper = FormatWrapper.Companion.create(paramMediaFormat);
    ReuseHelper.INSTANCE.initFormatWrapper(localFormatWrapper, paramMediaFormat);
    paramMediaFormat = ReuseCodecWrapper.Companion;
    MediaCodec localMediaCodec = MediaCodec.createDecoderByType(str);
    Intrinsics.checkExpressionValueIsNotNull(localMediaCodec, "MediaCodec.createDecoder…   mineType\n            )");
    Intrinsics.checkExpressionValueIsNotNull(str, "mineType");
    return paramMediaFormat.create(localMediaCodec, str, localFormatWrapper);
  }
  
  private final CodecWrapper getCodec(MediaFormat paramMediaFormat, TMediaCodec paramTMediaCodec, Surface paramSurface)
  {
    if ((!isEnable()) || (paramSurface == null))
    {
      paramTMediaCodec.setReUsed$tmediacodec_lib_debug(false);
      return createDirectCodecWrapper(paramMediaFormat);
    }
    boolean bool = paramTMediaCodec.isVideo();
    Object localObject = FormatWrapper.Companion.create(paramMediaFormat);
    paramSurface = obtainCodecWrapper(bool, (FormatWrapper)localObject);
    if (paramSurface != null)
    {
      localObject = paramSurface.setCanReuseType((FormatWrapper)localObject);
      if ((localObject == ReuseHelper.ReuseType.KEEP_CODEC_RESULT_YES_WITHOUT_RECONFIGURATION) || (localObject == ReuseHelper.ReuseType.KEEP_CODEC_RESULT_YES_WITH_RECONFIGURATION))
      {
        LogUtils.INSTANCE.d("TCodecManager", "getMediaCodec reuse, isVideo:" + bool + " reuseType:" + localObject);
        paramSurface.prepareToReUse();
        paramTMediaCodec.setReUsed$tmediacodec_lib_debug(true);
        return paramSurface;
      }
      if (localObject == ReuseHelper.ReuseType.KEEP_CODEC_RESULT_NO) {
        LogUtils.w$default(LogUtils.INSTANCE, "TCodecManager", "getMediaCodec not reuse, isVideo:" + bool + " reuseType:" + localObject, null, 4, null);
      }
    }
    paramTMediaCodec.setReUsed$tmediacodec_lib_debug(false);
    paramMediaFormat = createNewCodecWrapper(paramMediaFormat);
    ((Map)this.mCodecMap).put(paramTMediaCodec, paramMediaFormat);
    return paramMediaFormat;
  }
  
  private final CodecWrapper obtainCodecWrapper(boolean paramBoolean, FormatWrapper paramFormatWrapper)
  {
    if (paramBoolean) {
      return (CodecWrapper)this.mVideoCodecManager.obtainCodecWrapper(paramFormatWrapper);
    }
    return (CodecWrapper)this.mAudioCodecManager.obtainCodecWrapper(paramFormatWrapper);
  }
  
  private final void onCodecRunning(CodecWrapper paramCodecWrapper)
  {
    if (!isEnable()) {}
    do
    {
      return;
      if ((paramCodecWrapper instanceof VideoCodecWrapper))
      {
        this.mVideoCodecManager.transToRunning((ReuseCodecWrapper)paramCodecWrapper);
        return;
      }
    } while (!(paramCodecWrapper instanceof AudioCodecWrapper));
    this.mAudioCodecManager.transToRunning((ReuseCodecWrapper)paramCodecWrapper);
  }
  
  @TargetApi(26)
  @NotNull
  public final CodecWrapper configure(@NotNull MediaFormat paramMediaFormat, @Nullable Surface paramSurface, int paramInt, @Nullable MediaDescrambler paramMediaDescrambler, @NotNull TMediaCodec paramTMediaCodec)
  {
    Intrinsics.checkParameterIsNotNull(paramMediaFormat, "format");
    Intrinsics.checkParameterIsNotNull(paramTMediaCodec, "tMediaCodec");
    LogUtils.INSTANCE.d("TCodecManager", "configureStart videoPoolInfo:" + this.mVideoCodecManager.getDumpInfo() + ", audioPoolInfo:" + this.mAudioCodecManager.getDumpInfo());
    this.mConfigMethodCalled = true;
    paramTMediaCodec = getCodec(paramMediaFormat, paramTMediaCodec, paramSurface);
    onCodecRunning(paramTMediaCodec);
    paramTMediaCodec.configure(paramMediaFormat, paramSurface, paramInt, paramMediaDescrambler);
    LogUtils.INSTANCE.d("TCodecManager", "configureEnd   videoPoolInfo:" + this.mVideoCodecManager.getDumpInfo() + ", audioPoolInfo:" + this.mAudioCodecManager.getDumpInfo());
    return paramTMediaCodec;
  }
  
  @NotNull
  public final CodecWrapper configure(@NotNull MediaFormat paramMediaFormat, @Nullable Surface paramSurface, @Nullable MediaCrypto paramMediaCrypto, int paramInt, @NotNull TMediaCodec paramTMediaCodec)
  {
    Intrinsics.checkParameterIsNotNull(paramMediaFormat, "format");
    Intrinsics.checkParameterIsNotNull(paramTMediaCodec, "tMediaCodec");
    LogUtils.INSTANCE.d("TCodecManager", "configureStart videoPoolInfo:" + this.mVideoCodecManager.getDumpInfo() + ", audioPoolInfo:" + this.mAudioCodecManager.getDumpInfo());
    this.mConfigMethodCalled = true;
    paramTMediaCodec = getCodec(paramMediaFormat, paramTMediaCodec, paramSurface);
    onCodecRunning(paramTMediaCodec);
    paramTMediaCodec.configure(paramMediaFormat, paramSurface, paramMediaCrypto, paramInt);
    LogUtils.INSTANCE.d("TCodecManager", "configureEnd   videoPoolInfo:" + this.mVideoCodecManager.getDumpInfo() + ", audioPoolInfo:" + this.mAudioCodecManager.getDumpInfo());
    return paramTMediaCodec;
  }
  
  @NotNull
  public final Context getContext()
  {
    Context localContext = this.mContext;
    if (localContext == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mContext");
    }
    return localContext;
  }
  
  @NotNull
  public final ReusePolicy getReusePolicy()
  {
    return this.mReusePolicy;
  }
  
  public final void init(@NotNull Context paramContext)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    this.mContext = paramContext;
    this.mIsInited = true;
  }
  
  public final boolean isEnable()
  {
    return this.mReuseEnable;
  }
  
  public final void preloadCodec(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "firstSampleMimeType");
    Intrinsics.checkParameterIsNotNull(paramString2, "secondSampleMimeType");
    Set localSet = (Set)new LinkedHashSet();
    if (PreloadCodecManager.Companion.isInvalideMimeType(paramString1)) {
      localSet.add(paramString1);
    }
    if (PreloadCodecManager.Companion.isInvalideMimeType(paramString2)) {
      localSet.add(paramString2);
    }
    LogUtils.INSTANCE.d("TCodecManager", "preloadCodec mimeTypeSet:" + localSet);
    this.mPreloadCodecManager.preload(localSet);
  }
  
  public final void recycleCodecFromRunning(@NotNull CodecWrapper paramCodecWrapper)
  {
    Intrinsics.checkParameterIsNotNull(paramCodecWrapper, "codecWrapper");
    if (!isEnable()) {}
    do
    {
      return;
      if ((paramCodecWrapper instanceof VideoCodecWrapper))
      {
        this.mVideoCodecManager.transTokeep((ReuseCodecWrapper)paramCodecWrapper);
        return;
      }
    } while (!(paramCodecWrapper instanceof AudioCodecWrapper));
    this.mAudioCodecManager.transTokeep((ReuseCodecWrapper)paramCodecWrapper);
  }
  
  public final void removeCodecFromRunningPool(@NotNull CodecWrapper paramCodecWrapper)
  {
    Intrinsics.checkParameterIsNotNull(paramCodecWrapper, "codecWrapper");
    if (!isEnable()) {}
    do
    {
      return;
      if ((paramCodecWrapper instanceof VideoCodecWrapper))
      {
        this.mVideoCodecManager.removeFromRunning((ReuseCodecWrapper)paramCodecWrapper);
        return;
      }
    } while (!(paramCodecWrapper instanceof AudioCodecWrapper));
    this.mAudioCodecManager.removeFromRunning((ReuseCodecWrapper)paramCodecWrapper);
  }
  
  public final void setLogEnable(boolean paramBoolean)
  {
    LogUtils.INSTANCE.setLogEnable(paramBoolean);
  }
  
  public final void setLogLevel(int paramInt)
  {
    LogUtils.INSTANCE.setLogLevel(paramInt);
  }
  
  public final void setLogProxy(@NotNull ILogProxy paramILogProxy)
  {
    Intrinsics.checkParameterIsNotNull(paramILogProxy, "logProxy");
    LogUtils.INSTANCE.setLogProxy(paramILogProxy);
  }
  
  public final void setReuseEnable(boolean paramBoolean)
  {
    if (this.mReuseEnable == paramBoolean) {}
    do
    {
      return;
      this.mReuseEnable = paramBoolean;
    } while ((!this.mConfigMethodCalled) || (this.mReuseEnable));
    changeToReuseDisable();
  }
  
  public final void setReusePolicy(@NotNull ReusePolicy paramReusePolicy)
  {
    Intrinsics.checkParameterIsNotNull(paramReusePolicy, "reusePolicy");
    this.mReusePolicy = paramReusePolicy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmediacodec.TCodecManager
 * JD-Core Version:    0.7.0.1
 */