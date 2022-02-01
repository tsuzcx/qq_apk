package com.tencent.tav.core;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.tav.asset.Asset;
import com.tencent.tav.asset.MetadataItem;
import com.tencent.tav.core.compositing.VideoCompositing;
import com.tencent.tav.core.composition.VideoComposition;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.EncoderWriter.OutputConfig;
import com.tencent.tav.decoder.RenderContextParams;
import com.tencent.tav.decoder.logger.Logger;
import java.util.List;

public class AssetExportSession
{
  public static final String TAG = "AssetExportSession";
  boolean appliesPreferredTrackTransform = false;
  Asset asset;
  AssetExtension assetExtension;
  @Nullable
  private AudioMix audioMix;
  @Nullable
  private AssetExportSession.ErrorInterceptor errorInterceptor;
  @NonNull
  private ExportConfig exportConfig;
  @Nullable
  ExportErrorStatus exportErrorStatus;
  private AssetExportThread exportThread;
  private List<MetadataItem> metadata;
  String outputFilePath;
  String outputFileType = "mp4";
  private String presetName;
  float progress;
  private RenderContextParams renderContextParams;
  int retryIndex = 0;
  private boolean revertMode = false;
  AssetExportSession.AssetExportSessionStatus status;
  private List<String> supportedFileTypes;
  CMTimeRange timeRange;
  VideoCompositing videoCompositing;
  @Nullable
  VideoComposition videoComposition;
  
  public AssetExportSession(@NonNull Asset paramAsset, ExportConfig paramExportConfig)
  {
    this(paramAsset, paramExportConfig, new AssetExtension("export"));
  }
  
  public AssetExportSession(@NonNull Asset paramAsset, ExportConfig paramExportConfig, AssetExtension paramAssetExtension)
  {
    this.asset = paramAsset;
    this.assetExtension = paramAssetExtension;
    if (paramExportConfig != null)
    {
      paramAssetExtension = paramExportConfig;
      if (paramExportConfig.available()) {}
    }
    else
    {
      Logger.e("AssetExportSession", "AssetExportSession: encodeOption 不合法");
      paramAssetExtension = new ExportConfig((int)paramAsset.getNaturalSize().width, (int)paramAsset.getNaturalSize().height);
    }
    this.exportConfig = paramAssetExtension;
  }
  
  @Deprecated
  public AssetExportSession(@NonNull Asset paramAsset, EncoderWriter.OutputConfig paramOutputConfig)
  {
    this(paramAsset, new ExportConfig(paramOutputConfig), new AssetExtension("export"));
  }
  
  private void interceptHandlerCallback(AssetExportSession paramAssetExportSession, AssetExportSession.ExportCallbackHandler paramExportCallbackHandler)
  {
    if (paramAssetExportSession.getStatus() == AssetExportSession.AssetExportSessionStatus.AssetExportSessionStatusFailed)
    {
      AssetExportSession.ErrorInterceptor localErrorInterceptor = this.errorInterceptor;
      if ((localErrorInterceptor != null) && (localErrorInterceptor.a(paramAssetExportSession, this.retryIndex)))
      {
        this.retryIndex += 1;
        exportAsynchronouslyWithCompletionHandler(paramExportCallbackHandler);
        return;
      }
    }
    paramExportCallbackHandler.handlerCallback(paramAssetExportSession);
  }
  
  public void cancelExport()
  {
    AssetExportThread localAssetExportThread = this.exportThread;
    if (localAssetExportThread != null) {
      localAssetExportThread.cancel();
    }
    this.errorInterceptor = null;
  }
  
  public void exportAsynchronouslyWithCompletionHandler(AssetExportSession.ExportCallbackHandler paramExportCallbackHandler)
  {
    Object localObject = this.videoComposition;
    if (localObject != null) {
      this.videoCompositing = ((VideoComposition)localObject).getCustomVideoCompositor();
    }
    localObject = this.exportThread;
    if (localObject != null) {
      ((AssetExportThread)localObject).removeCallback();
    }
    this.exportThread = new AssetExportThread(this, new AssetExportSession.1(this, paramExportCallbackHandler), this.audioMix, this.exportConfig);
    this.exportThread.setRenderContextParams(this.renderContextParams);
    this.exportThread.startExport();
  }
  
  public Asset getAsset()
  {
    return this.asset;
  }
  
  @Nullable
  public AudioMix getAudioMix()
  {
    return this.audioMix;
  }
  
  public int getErrCode()
  {
    ExportErrorStatus localExportErrorStatus = this.exportErrorStatus;
    if (localExportErrorStatus != null) {
      return localExportErrorStatus.code;
    }
    return 0;
  }
  
  @NonNull
  public ExportConfig getExportConfig()
  {
    return this.exportConfig;
  }
  
  @Nullable
  public ExportErrorStatus getExportErrorStatus()
  {
    return this.exportErrorStatus;
  }
  
  public List<MetadataItem> getMetadata()
  {
    return this.metadata;
  }
  
  public String getOutputFilePath()
  {
    return this.outputFilePath;
  }
  
  public String getOutputFileType()
  {
    return this.outputFileType;
  }
  
  public String getPresetName()
  {
    return this.presetName;
  }
  
  public float getProgress()
  {
    return this.progress;
  }
  
  public RenderContextParams getRenderContextParams()
  {
    return this.renderContextParams;
  }
  
  public int getRetryIndex()
  {
    return this.retryIndex;
  }
  
  public AssetExportSession.AssetExportSessionStatus getStatus()
  {
    return this.status;
  }
  
  public List<String> getSupportedFileTypes()
  {
    return this.supportedFileTypes;
  }
  
  public Throwable getThrowable()
  {
    ExportErrorStatus localExportErrorStatus = this.exportErrorStatus;
    if (localExportErrorStatus != null) {
      return localExportErrorStatus.throwable;
    }
    return null;
  }
  
  public CMTimeRange getTimeRange()
  {
    return this.timeRange;
  }
  
  public VideoComposition getVideoComposition()
  {
    return this.videoComposition;
  }
  
  public boolean isRevertMode()
  {
    return this.revertMode;
  }
  
  void release()
  {
    AudioMix localAudioMix = this.audioMix;
    if (localAudioMix != null)
    {
      localAudioMix.release();
      this.audioMix = null;
    }
  }
  
  public void setAppliesPreferredTrackTransform(boolean paramBoolean)
  {
    this.appliesPreferredTrackTransform = paramBoolean;
  }
  
  public void setAudioMix(AudioMix paramAudioMix)
  {
    this.audioMix = paramAudioMix;
  }
  
  public void setErrorInterceptor(@Nullable AssetExportSession.ErrorInterceptor paramErrorInterceptor)
  {
    this.errorInterceptor = paramErrorInterceptor;
  }
  
  public void setExportConfig(@NonNull ExportConfig paramExportConfig)
  {
    this.exportConfig = paramExportConfig;
  }
  
  public void setMetadata(List<MetadataItem> paramList)
  {
    this.metadata = paramList;
  }
  
  public void setOutputFilePath(String paramString)
  {
    this.outputFilePath = paramString;
  }
  
  public void setOutputFileType(String paramString)
  {
    this.outputFileType = paramString;
  }
  
  public void setRenderContextParams(RenderContextParams paramRenderContextParams)
  {
    this.renderContextParams = paramRenderContextParams;
    AssetExportThread localAssetExportThread = this.exportThread;
    if (localAssetExportThread != null) {
      localAssetExportThread.setRenderContextParams(paramRenderContextParams);
    }
  }
  
  public void setRevertMode(boolean paramBoolean)
  {
    this.revertMode = paramBoolean;
  }
  
  public void setTimeRange(CMTimeRange paramCMTimeRange)
  {
    this.timeRange = paramCMTimeRange;
  }
  
  public void setVideoComposition(@Nullable VideoComposition paramVideoComposition)
  {
    this.videoComposition = paramVideoComposition;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tav.core.AssetExportSession
 * JD-Core Version:    0.7.0.1
 */