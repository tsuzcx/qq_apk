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
  ExportErrorStatus exportErrorStatus;
  private AssetExportThread exportThread;
  private List<MetadataItem> metadata;
  EncoderWriter.OutputConfig outputConfig;
  String outputFilePath;
  String outputFileType = "mp4";
  private String presetName;
  float progress;
  private RenderContextParams renderContextParams;
  private boolean revertMode = false;
  AssetExportSession.AssetExportSessionStatus status;
  private List<String> supportedFileTypes;
  CMTimeRange timeRange;
  VideoCompositing videoCompositing;
  @Nullable
  VideoComposition videoComposition;
  
  public AssetExportSession(@NonNull Asset paramAsset, @Nullable EncoderWriter.OutputConfig paramOutputConfig)
  {
    this(paramAsset, paramOutputConfig, new AssetExtension("export"));
  }
  
  public AssetExportSession(@NonNull Asset paramAsset, @Nullable EncoderWriter.OutputConfig paramOutputConfig, AssetExtension paramAssetExtension)
  {
    this.asset = paramAsset;
    this.assetExtension = paramAssetExtension;
    paramAssetExtension = paramOutputConfig;
    if (paramOutputConfig == null)
    {
      paramAssetExtension = new EncoderWriter.OutputConfig();
      paramAssetExtension.VIDEO_TARGET_HEIGHT = ((int)paramAsset.getNaturalSize().height);
      paramAssetExtension.VIDEO_TARGET_WIDTH = ((int)paramAsset.getNaturalSize().width);
    }
    this.outputConfig = paramAssetExtension;
  }
  
  public void cancelExport()
  {
    if (this.exportThread != null) {
      this.exportThread.cancel();
    }
  }
  
  public void exportAsynchronouslyWithCompletionHandler(AssetExportSession.ExportCallbackHandler paramExportCallbackHandler)
  {
    this.exportThread = new AssetExportThread(this, paramExportCallbackHandler, this.audioMix);
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
    if (this.exportErrorStatus != null) {
      return this.exportErrorStatus.code;
    }
    return 0;
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
  
  public AssetExportSession.AssetExportSessionStatus getStatus()
  {
    return this.status;
  }
  
  public List<String> getSupportedFileTypes()
  {
    return this.supportedFileTypes;
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
    if (this.audioMix != null)
    {
      this.audioMix.release();
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
    if (this.exportThread != null) {
      this.exportThread.setRenderContextParams(paramRenderContextParams);
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
    if (paramVideoComposition != null) {
      this.videoCompositing = paramVideoComposition.getCustomVideoCompositor();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tav.core.AssetExportSession
 * JD-Core Version:    0.7.0.1
 */