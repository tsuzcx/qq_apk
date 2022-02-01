package com.tencent.tmediacodec;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaDescrambler;
import android.media.MediaFormat;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.Surface;
import com.tencent.tmediacodec.codec.AudioCodecWrapper;
import com.tencent.tmediacodec.codec.CodecWrapper;
import com.tencent.tmediacodec.codec.DirectCodecWrapper;
import com.tencent.tmediacodec.codec.FormatWrapper;
import com.tencent.tmediacodec.codec.ReuseCodecWrapper;
import com.tencent.tmediacodec.codec.VideoCodecWrapper;
import com.tencent.tmediacodec.pools.CodecWrapperManager;
import com.tencent.tmediacodec.preload.PreloadCodecManager;
import com.tencent.tmediacodec.reuse.ReuseHelper;
import com.tencent.tmediacodec.reuse.ReuseHelper.ReuseType;
import com.tencent.tmediacodec.reuse.ReusePolicy;
import com.tencent.tmediacodec.util.ILogProxy;
import com.tencent.tmediacodec.util.LogUtils;
import com.tencent.tmediacodec.util.TUtils;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;

public final class TCodecManager
{
  public static final String TAG = "TCodecManager";
  private static TCodecManager mInstance = new TCodecManager();
  private static boolean mIsDebugVersion = false;
  private final CodecWrapperManager mAudioCodecManager = new CodecWrapperManager();
  private final HashMap<TMediaCodec, CodecWrapper> mCodecMap = new HashMap();
  private boolean mConfigMethodCalled;
  private boolean mGlobalReuseEnable = true;
  private final PreloadCodecManager mPreloadCodecManager = new PreloadCodecManager();
  private ReusePolicy mReusePolicy = ReusePolicy.DEFAULT;
  private final CodecWrapperManager mVideoCodecManager = new CodecWrapperManager();
  
  private void changeToReuseDisable()
  {
    this.mVideoCodecManager.clearAndReleaseAll();
    this.mAudioCodecManager.clearAndReleaseAll();
  }
  
  private CodecWrapper createDirectCodecWrapper(MediaFormat paramMediaFormat, TMediaCodec paramTMediaCodec)
  {
    if (LogUtils.isLogEnable()) {
      LogUtils.d("TCodecManager", "createDirectCodecWrapper mediaFormat:" + paramMediaFormat + " createBy:" + paramTMediaCodec.getCreateBy() + " nameOrType:" + paramTMediaCodec.getNameOrType());
    }
    if (paramTMediaCodec.getCreateBy() == TMediaCodec.CreateBy.CreateByName) {
      return new DirectCodecWrapper(MediaCodec.createByCodecName(paramTMediaCodec.getNameOrType()));
    }
    return new DirectCodecWrapper(MediaCodec.createDecoderByType(paramTMediaCodec.getNameOrType()));
  }
  
  private CodecWrapper createNewReuseCodecWrapper(MediaFormat paramMediaFormat, TMediaCodec paramTMediaCodec)
  {
    if (LogUtils.isLogEnable()) {
      LogUtils.d("TCodecManager", "createNewReuseCodecWrapper mediaFormat:" + paramMediaFormat + " createBy:" + paramTMediaCodec.getCreateBy() + " nameOrType:" + paramTMediaCodec.getNameOrType());
    }
    String str = paramMediaFormat.getString("mime");
    FormatWrapper localFormatWrapper = FormatWrapper.create(paramMediaFormat);
    ReuseHelper.initFormatWrapper(localFormatWrapper, paramMediaFormat);
    if (paramTMediaCodec.getCreateBy() == TMediaCodec.CreateBy.CreateByName) {
      return ReuseCodecWrapper.create(MediaCodec.createByCodecName(paramTMediaCodec.getNameOrType()), str, localFormatWrapper);
    }
    return ReuseCodecWrapper.create(MediaCodec.createDecoderByType(str), str, localFormatWrapper);
  }
  
  private CodecWrapper getCodec(MediaFormat paramMediaFormat, TMediaCodec paramTMediaCodec, Surface paramSurface)
  {
    boolean bool3 = isGlobalReuseEnable();
    boolean bool4 = paramTMediaCodec.isReuseEnable();
    boolean bool5 = paramTMediaCodec.isVideo();
    boolean bool1;
    if ((bool3) && (bool4))
    {
      bool1 = true;
      if (TUtils.codecNeedsSetOutputSurfaceWorkaround()) {
        break label226;
      }
    }
    label226:
    for (boolean bool2 = true;; bool2 = false)
    {
      if (LogUtils.isLogEnable()) {
        LogUtils.d("TCodecManager", "getCodec isVideo:" + bool5 + " reuseEnable:" + bool1 + ' ' + "globalReuseEnable:" + bool3 + " mediaCodecReuseEnable:" + bool4 + " canUseSetOutputSurfaceAPI:" + bool2 + " ,surface:" + paramSurface);
      }
      if ((bool1) && (bool5) && (bool2) && (paramSurface != null)) {
        break label232;
      }
      paramTMediaCodec.isReUsed = false;
      if (LogUtils.isLogEnable()) {
        LogUtils.d("TCodecManager", "getCodec return DirectCodecWrapper for mediaFormat:" + paramMediaFormat + " globalReuseEnable:" + bool3 + ' ' + "mediaCodecReuseEnable:" + bool4 + " surface:" + paramSurface);
      }
      return createDirectCodecWrapper(paramMediaFormat, paramTMediaCodec);
      bool1 = false;
      break;
    }
    label232:
    Object localObject = FormatWrapper.create(paramMediaFormat);
    paramSurface = obtainCodecWrapper(bool5, (FormatWrapper)localObject);
    if (paramSurface != null)
    {
      localObject = paramSurface.setCanReuseType((FormatWrapper)localObject);
      if ((localObject == ReuseHelper.ReuseType.KEEP_CODEC_RESULT_YES_WITHOUT_RECONFIGURATION) || (localObject == ReuseHelper.ReuseType.KEEP_CODEC_RESULT_YES_WITH_RECONFIGURATION))
      {
        if (LogUtils.isLogEnable()) {
          LogUtils.d("TCodecManager", "getCodec reuse, isVideo:" + bool5 + " reuseType:" + localObject);
        }
        paramSurface.attachThread();
        paramSurface.prepareToReUse();
        paramTMediaCodec.isReUsed = true;
        return paramSurface;
      }
      if ((localObject == ReuseHelper.ReuseType.KEEP_CODEC_RESULT_NO) && (LogUtils.isLogEnable())) {
        LogUtils.w("TCodecManager", "getCodec not reuse, isVideo:" + bool5 + " reuseType:" + localObject);
      }
    }
    if (LogUtils.isLogEnable()) {
      LogUtils.d("TCodecManager", "getCodec not reuse, for can't find reUseAble CodecWrapper. isVideo:" + bool5);
    }
    paramTMediaCodec.isReUsed = false;
    paramMediaFormat = createNewReuseCodecWrapper(paramMediaFormat, paramTMediaCodec);
    paramMediaFormat.attachThread();
    this.mCodecMap.put(paramTMediaCodec, paramMediaFormat);
    return paramMediaFormat;
  }
  
  public static TCodecManager getInstance()
  {
    return mInstance;
  }
  
  public static void init() {}
  
  public static final boolean isDebug()
  {
    return mIsDebugVersion;
  }
  
  private CodecWrapper obtainCodecWrapper(boolean paramBoolean, FormatWrapper paramFormatWrapper)
  {
    if (paramBoolean) {
      return this.mVideoCodecManager.obtainCodecWrapper(paramFormatWrapper);
    }
    return this.mAudioCodecManager.obtainCodecWrapper(paramFormatWrapper);
  }
  
  private void onCodecRunning(CodecWrapper paramCodecWrapper)
  {
    if (isGlobalReuseEnable())
    {
      if (!(paramCodecWrapper instanceof VideoCodecWrapper)) {
        break label26;
      }
      this.mVideoCodecManager.transToRunning((ReuseCodecWrapper)paramCodecWrapper);
    }
    label26:
    while (!(paramCodecWrapper instanceof AudioCodecWrapper)) {
      return;
    }
    this.mAudioCodecManager.transToRunning((ReuseCodecWrapper)paramCodecWrapper);
  }
  
  public static final void setIsDebug(boolean paramBoolean)
  {
    mIsDebugVersion = paramBoolean;
  }
  
  @TargetApi(26)
  @NonNull
  public final CodecWrapper configure(@NonNull MediaFormat paramMediaFormat, @Nullable Surface paramSurface, int paramInt, @Nullable MediaDescrambler paramMediaDescrambler, @NonNull TMediaCodec paramTMediaCodec)
  {
    if (LogUtils.isLogEnable()) {
      LogUtils.d("TCodecManager", "configureStart videoPoolInfo:" + this.mVideoCodecManager.getDumpInfo() + ", audioPoolInfo:" + this.mAudioCodecManager.getDumpInfo());
    }
    this.mConfigMethodCalled = true;
    CodecWrapper localCodecWrapper = getCodec(paramMediaFormat, paramTMediaCodec, paramSurface);
    localCodecWrapper.setCodecCallback(paramTMediaCodec.getCodecCallback());
    onCodecRunning(localCodecWrapper);
    localCodecWrapper.configure(paramMediaFormat, paramSurface, paramInt, paramMediaDescrambler);
    if (LogUtils.isLogEnable()) {
      LogUtils.d("TCodecManager", "configureEnd   videoPoolInfo:" + this.mVideoCodecManager.getDumpInfo() + ", audioPoolInfo:" + this.mAudioCodecManager.getDumpInfo());
    }
    return localCodecWrapper;
  }
  
  @NonNull
  public final CodecWrapper configure(@NonNull MediaFormat paramMediaFormat, @Nullable Surface paramSurface, @Nullable MediaCrypto paramMediaCrypto, int paramInt, @NonNull TMediaCodec paramTMediaCodec)
  {
    if (LogUtils.isLogEnable()) {
      LogUtils.d("TCodecManager", "configureStart videoPoolInfo:" + this.mVideoCodecManager.getDumpInfo() + ", audioPoolInfo:" + this.mAudioCodecManager.getDumpInfo());
    }
    this.mConfigMethodCalled = true;
    CodecWrapper localCodecWrapper = getCodec(paramMediaFormat, paramTMediaCodec, paramSurface);
    onCodecRunning(localCodecWrapper);
    localCodecWrapper.setCodecCallback(paramTMediaCodec.getCodecCallback());
    localCodecWrapper.configure(paramMediaFormat, paramSurface, paramMediaCrypto, paramInt);
    if (LogUtils.isLogEnable()) {
      LogUtils.d("TCodecManager", "configureEnd   videoPoolInfo:" + this.mVideoCodecManager.getDumpInfo() + ", audioPoolInfo:" + this.mAudioCodecManager.getDumpInfo());
    }
    return localCodecWrapper;
  }
  
  @NonNull
  public final ReusePolicy getReusePolicy()
  {
    return this.mReusePolicy;
  }
  
  public final boolean isGlobalReuseEnable()
  {
    return this.mGlobalReuseEnable;
  }
  
  public final void preloadCodec(@NonNull String paramString1, @NonNull String paramString2)
  {
    LinkedHashSet localLinkedHashSet = new LinkedHashSet();
    if (PreloadCodecManager.isInvalideMimeType(paramString1)) {
      localLinkedHashSet.add(paramString1);
    }
    if (PreloadCodecManager.isInvalideMimeType(paramString2)) {
      localLinkedHashSet.add(paramString2);
    }
    if (LogUtils.isLogEnable()) {
      LogUtils.d("TCodecManager", "preloadCodec mimeTypeSet:" + localLinkedHashSet);
    }
    this.mPreloadCodecManager.preload(localLinkedHashSet);
  }
  
  public final void recycleCodecFromRunning(@NonNull CodecWrapper paramCodecWrapper)
  {
    if (isGlobalReuseEnable())
    {
      if (!(paramCodecWrapper instanceof VideoCodecWrapper)) {
        break label26;
      }
      this.mVideoCodecManager.transTokeep((ReuseCodecWrapper)paramCodecWrapper);
    }
    label26:
    while (!(paramCodecWrapper instanceof AudioCodecWrapper)) {
      return;
    }
    this.mAudioCodecManager.transTokeep((ReuseCodecWrapper)paramCodecWrapper);
  }
  
  public final void removeCodecFromRunningPool(@NonNull CodecWrapper paramCodecWrapper)
  {
    if (isGlobalReuseEnable())
    {
      if (!(paramCodecWrapper instanceof VideoCodecWrapper)) {
        break label26;
      }
      this.mVideoCodecManager.removeFromRunning((ReuseCodecWrapper)paramCodecWrapper);
    }
    label26:
    while (!(paramCodecWrapper instanceof AudioCodecWrapper)) {
      return;
    }
    this.mAudioCodecManager.removeFromRunning((ReuseCodecWrapper)paramCodecWrapper);
  }
  
  public final void setGlobalReuseEnable(boolean paramBoolean)
  {
    if (this.mGlobalReuseEnable != paramBoolean)
    {
      this.mGlobalReuseEnable = paramBoolean;
      if ((this.mConfigMethodCalled) && (!this.mGlobalReuseEnable)) {
        changeToReuseDisable();
      }
    }
  }
  
  public final void setLogEnable(boolean paramBoolean)
  {
    LogUtils.setLogEnable(paramBoolean);
  }
  
  public final void setLogLevel(int paramInt)
  {
    LogUtils.setLogLevel(paramInt);
  }
  
  public final void setLogProxy(@NonNull ILogProxy paramILogProxy)
  {
    LogUtils.setLogProxy(paramILogProxy);
  }
  
  public final void setReusePolicy(@NonNull ReusePolicy paramReusePolicy)
  {
    this.mReusePolicy = paramReusePolicy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmediacodec.TCodecManager
 * JD-Core Version:    0.7.0.1
 */