package com.tencent.tmediacodec;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaDescrambler;
import android.media.MediaFormat;
import android.os.Build.VERSION;
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
  private static boolean mIsLeakFiexed = true;
  private boolean mAllowKeepPool = true;
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
    if (LogUtils.isLogEnable())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("createDirectCodecWrapper mediaFormat:");
      localStringBuilder.append(paramMediaFormat);
      localStringBuilder.append(" createBy:");
      localStringBuilder.append(paramTMediaCodec.getCreateBy());
      localStringBuilder.append(" nameOrType:");
      localStringBuilder.append(paramTMediaCodec.getNameOrType());
      LogUtils.d("TCodecManager", localStringBuilder.toString());
    }
    if (paramTMediaCodec.getCreateBy() == TMediaCodec.CreateBy.CreateByName) {
      return new DirectCodecWrapper(MediaCodec.createByCodecName(paramTMediaCodec.getNameOrType()));
    }
    return new DirectCodecWrapper(MediaCodec.createDecoderByType(paramTMediaCodec.getNameOrType()));
  }
  
  private CodecWrapper createNewReuseCodecWrapper(MediaFormat paramMediaFormat, TMediaCodec paramTMediaCodec)
  {
    if (LogUtils.isLogEnable())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("createNewReuseCodecWrapper mediaFormat:");
      ((StringBuilder)localObject).append(paramMediaFormat);
      ((StringBuilder)localObject).append(" createBy:");
      ((StringBuilder)localObject).append(paramTMediaCodec.getCreateBy());
      ((StringBuilder)localObject).append(" nameOrType:");
      ((StringBuilder)localObject).append(paramTMediaCodec.getNameOrType());
      LogUtils.d("TCodecManager", ((StringBuilder)localObject).toString());
    }
    Object localObject = paramMediaFormat.getString("mime");
    FormatWrapper localFormatWrapper = FormatWrapper.create(paramMediaFormat);
    ReuseHelper.initFormatWrapper(localFormatWrapper, paramMediaFormat);
    if (paramTMediaCodec.getCreateBy() == TMediaCodec.CreateBy.CreateByName) {
      return ReuseCodecWrapper.create(MediaCodec.createByCodecName(paramTMediaCodec.getNameOrType()), (String)localObject, localFormatWrapper);
    }
    return ReuseCodecWrapper.create(MediaCodec.createDecoderByType((String)localObject), (String)localObject, localFormatWrapper);
  }
  
  private CodecWrapper getCodec(MediaFormat paramMediaFormat, TMediaCodec paramTMediaCodec, Surface paramSurface)
  {
    boolean bool = paramTMediaCodec.isVideo();
    if (LogUtils.isLogEnable())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getCodec isVideo:");
      ((StringBuilder)localObject).append(bool);
      ((StringBuilder)localObject).append(" codecFinalReuseEnable:");
      ((StringBuilder)localObject).append(paramTMediaCodec.codecFinalReuseEnable);
      LogUtils.d("TCodecManager", ((StringBuilder)localObject).toString());
    }
    if (!paramTMediaCodec.codecFinalReuseEnable)
    {
      paramTMediaCodec.isReUsed = false;
      if (LogUtils.isLogEnable())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getCodec return DirectCodecWrapper for mediaFormat:");
        ((StringBuilder)localObject).append(paramMediaFormat);
        ((StringBuilder)localObject).append(" codecFinalReuseEnable:");
        ((StringBuilder)localObject).append(false);
        ((StringBuilder)localObject).append(" surface:");
        ((StringBuilder)localObject).append(paramSurface);
        LogUtils.d("TCodecManager", ((StringBuilder)localObject).toString());
      }
      return createDirectCodecWrapper(paramMediaFormat, paramTMediaCodec);
    }
    Object localObject = FormatWrapper.create(paramMediaFormat);
    paramSurface = obtainCodecWrapper(bool, (FormatWrapper)localObject);
    FormatWrapper.dumpCsdArray(((FormatWrapper)localObject).initializationData);
    if (paramSurface != null)
    {
      localObject = paramSurface.setCanReuseType((FormatWrapper)localObject);
      if ((localObject != ReuseHelper.ReuseType.KEEP_CODEC_RESULT_YES_WITHOUT_RECONFIGURATION) && (localObject != ReuseHelper.ReuseType.KEEP_CODEC_RESULT_YES_WITH_RECONFIGURATION))
      {
        if ((localObject == ReuseHelper.ReuseType.KEEP_CODEC_RESULT_NO) && (LogUtils.isLogEnable()))
        {
          paramSurface = new StringBuilder();
          paramSurface.append("getCodec not reuse, isVideo:");
          paramSurface.append(bool);
          paramSurface.append(" reuseType:");
          paramSurface.append(localObject);
          LogUtils.w("TCodecManager", paramSurface.toString());
        }
      }
      else
      {
        if (LogUtils.isLogEnable())
        {
          paramMediaFormat = new StringBuilder();
          paramMediaFormat.append("getCodec reuse, isVideo:");
          paramMediaFormat.append(bool);
          paramMediaFormat.append(" reuseType:");
          paramMediaFormat.append(localObject);
          LogUtils.d("TCodecManager", paramMediaFormat.toString());
        }
        paramSurface.attachThread();
        paramSurface.prepareToReUse();
        paramTMediaCodec.isReUsed = true;
        return paramSurface;
      }
    }
    if (LogUtils.isLogEnable())
    {
      paramSurface = new StringBuilder();
      paramSurface.append("getCodec not reuse, for can't find reUseAble CodecWrapper. isVideo:");
      paramSurface.append(bool);
      LogUtils.d("TCodecManager", paramSurface.toString());
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
  
  public static final boolean isLeakFixed()
  {
    return mIsLeakFiexed;
  }
  
  private CodecWrapper obtainCodecWrapper(boolean paramBoolean, FormatWrapper paramFormatWrapper)
  {
    CodecWrapperManager localCodecWrapperManager;
    if (paramBoolean) {
      localCodecWrapperManager = this.mVideoCodecManager;
    } else {
      localCodecWrapperManager = this.mAudioCodecManager;
    }
    return localCodecWrapperManager.obtainCodecWrapper(paramFormatWrapper);
  }
  
  private void onCodecRunning(CodecWrapper paramCodecWrapper)
  {
    if (isGlobalReuseEnable())
    {
      if ((paramCodecWrapper instanceof VideoCodecWrapper))
      {
        this.mVideoCodecManager.transToRunning((ReuseCodecWrapper)paramCodecWrapper);
        return;
      }
      if ((paramCodecWrapper instanceof AudioCodecWrapper)) {
        this.mAudioCodecManager.transToRunning((ReuseCodecWrapper)paramCodecWrapper);
      }
    }
  }
  
  public static final void setIsDebug(boolean paramBoolean)
  {
    mIsDebugVersion = paramBoolean;
  }
  
  public static final void setLeakFixed(boolean paramBoolean)
  {
    mIsLeakFiexed = paramBoolean;
  }
  
  public final void clearAndReleaseKeepPool()
  {
    this.mAllowKeepPool = false;
    this.mVideoCodecManager.clearAndReleaseKeepPool();
    this.mAudioCodecManager.clearAndReleaseKeepPool();
  }
  
  @TargetApi(26)
  @NonNull
  public final CodecWrapper configure(@NonNull MediaFormat paramMediaFormat, @Nullable Surface paramSurface, int paramInt, @Nullable MediaDescrambler paramMediaDescrambler, @NonNull TMediaCodec paramTMediaCodec)
  {
    if (LogUtils.isLogEnable())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("configureStart videoPoolInfo:");
      ((StringBuilder)localObject).append(this.mVideoCodecManager.getDumpInfo());
      ((StringBuilder)localObject).append(", audioPoolInfo:");
      ((StringBuilder)localObject).append(this.mAudioCodecManager.getDumpInfo());
      LogUtils.d("TCodecManager", ((StringBuilder)localObject).toString());
    }
    this.mConfigMethodCalled = true;
    this.mAllowKeepPool = true;
    Object localObject = getCodec(paramMediaFormat, paramTMediaCodec, paramSurface);
    ((CodecWrapper)localObject).setCodecCallback(paramTMediaCodec.getCodecCallback());
    onCodecRunning((CodecWrapper)localObject);
    ((CodecWrapper)localObject).configure(paramMediaFormat, paramSurface, paramInt, paramMediaDescrambler);
    if (LogUtils.isLogEnable())
    {
      paramMediaFormat = new StringBuilder();
      paramMediaFormat.append("configureEnd   videoPoolInfo:");
      paramMediaFormat.append(this.mVideoCodecManager.getDumpInfo());
      paramMediaFormat.append(", audioPoolInfo:");
      paramMediaFormat.append(this.mAudioCodecManager.getDumpInfo());
      LogUtils.d("TCodecManager", paramMediaFormat.toString());
    }
    return localObject;
  }
  
  @NonNull
  public final CodecWrapper configure(@NonNull MediaFormat paramMediaFormat, @Nullable Surface paramSurface, @Nullable MediaCrypto paramMediaCrypto, int paramInt, @NonNull TMediaCodec paramTMediaCodec)
  {
    if (LogUtils.isLogEnable())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("configureStart videoPoolInfo:");
      ((StringBuilder)localObject).append(this.mVideoCodecManager.getDumpInfo());
      ((StringBuilder)localObject).append(", audioPoolInfo:");
      ((StringBuilder)localObject).append(this.mAudioCodecManager.getDumpInfo());
      LogUtils.d("TCodecManager", ((StringBuilder)localObject).toString());
    }
    this.mConfigMethodCalled = true;
    this.mAllowKeepPool = true;
    Object localObject = getCodec(paramMediaFormat, paramTMediaCodec, paramSurface);
    onCodecRunning((CodecWrapper)localObject);
    ((CodecWrapper)localObject).setCodecCallback(paramTMediaCodec.getCodecCallback());
    ((CodecWrapper)localObject).configure(paramMediaFormat, paramSurface, paramMediaCrypto, paramInt);
    if (LogUtils.isLogEnable())
    {
      paramMediaFormat = new StringBuilder();
      paramMediaFormat.append("configureEnd   videoPoolInfo:");
      paramMediaFormat.append(this.mVideoCodecManager.getDumpInfo());
      paramMediaFormat.append(", audioPoolInfo:");
      paramMediaFormat.append(this.mAudioCodecManager.getDumpInfo());
      LogUtils.d("TCodecManager", paramMediaFormat.toString());
    }
    return localObject;
  }
  
  @NonNull
  public final ReusePolicy getReusePolicy()
  {
    return this.mReusePolicy;
  }
  
  public final boolean isAllowKeepPool()
  {
    return this.mAllowKeepPool;
  }
  
  public final boolean isGlobalReuseEnable()
  {
    return this.mGlobalReuseEnable;
  }
  
  public final boolean isVideoKeepPoolFull()
  {
    return this.mVideoCodecManager.isKeepPoolFull();
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
    if (LogUtils.isLogEnable())
    {
      paramString1 = new StringBuilder();
      paramString1.append("preloadCodec mimeTypeSet:");
      paramString1.append(localLinkedHashSet);
      LogUtils.d("TCodecManager", paramString1.toString());
    }
    this.mPreloadCodecManager.preload(localLinkedHashSet);
  }
  
  public final void recycleCodecFromRunning(@NonNull CodecWrapper paramCodecWrapper)
  {
    if (isGlobalReuseEnable())
    {
      if ((paramCodecWrapper instanceof VideoCodecWrapper))
      {
        this.mVideoCodecManager.transTokeep((ReuseCodecWrapper)paramCodecWrapper);
        return;
      }
      if ((paramCodecWrapper instanceof AudioCodecWrapper)) {
        this.mAudioCodecManager.transTokeep((ReuseCodecWrapper)paramCodecWrapper);
      }
    }
  }
  
  public final void removeCodecFromRunningPool(@NonNull CodecWrapper paramCodecWrapper)
  {
    if (isGlobalReuseEnable())
    {
      if ((paramCodecWrapper instanceof VideoCodecWrapper))
      {
        this.mVideoCodecManager.removeFromRunning((ReuseCodecWrapper)paramCodecWrapper);
        return;
      }
      if ((paramCodecWrapper instanceof AudioCodecWrapper)) {
        this.mAudioCodecManager.removeFromRunning((ReuseCodecWrapper)paramCodecWrapper);
      }
    }
  }
  
  public boolean reuseEnable(TMediaCodec paramTMediaCodec, Surface paramSurface)
  {
    boolean bool3 = isGlobalReuseEnable();
    boolean bool4 = paramTMediaCodec.isReuseEnable();
    boolean bool5 = paramTMediaCodec.isVideo();
    boolean bool1;
    if ((bool3) && (bool4)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool2;
    if ((Build.VERSION.SDK_INT >= 23) && (!TUtils.codecNeedsSetOutputSurfaceWorkaround())) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    if (LogUtils.isLogEnable())
    {
      paramTMediaCodec = new StringBuilder();
      paramTMediaCodec.append("reuseEnable getCodec isVideo:");
      paramTMediaCodec.append(bool5);
      paramTMediaCodec.append(" reuseEnable:");
      paramTMediaCodec.append(bool1);
      paramTMediaCodec.append(' ');
      paramTMediaCodec.append("globalReuseEnable:");
      paramTMediaCodec.append(bool3);
      paramTMediaCodec.append(" mediaCodecReuseEnable:");
      paramTMediaCodec.append(bool4);
      paramTMediaCodec.append(" canUseSetOutputSurfaceAPI:");
      paramTMediaCodec.append(bool2);
      paramTMediaCodec.append(" ,surface:");
      paramTMediaCodec.append(paramSurface);
      LogUtils.d("TCodecManager", paramTMediaCodec.toString());
    }
    return (bool1) && (bool5) && (bool2) && (paramSurface != null);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tmediacodec.TCodecManager
 * JD-Core Version:    0.7.0.1
 */