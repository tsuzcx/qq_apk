package com.tencent.tavkit.component;

import android.support.annotation.NonNull;
import com.tencent.tav.asset.Asset;
import com.tencent.tav.core.AssetExportSession;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.EncoderWriter.OutputConfig;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tavkit.composition.TAVComposition;
import com.tencent.tavkit.composition.TAVSource;
import com.tencent.tavkit.composition.builder.TAVCompositionBuilder;
import java.io.File;
import java.io.IOException;

public class TAVExporter
{
  public static final int VIDEO_EXPORT_HEIGHT = 1280;
  public static final int VIDEO_EXPORT_WIDTH = 720;
  private final String TAG = "GameTemplateExporter@" + Integer.toHexString(hashCode());
  private EncoderWriter.OutputConfig defaultOutputConfig = new EncoderWriter.OutputConfig();
  private TAVExporter.ExportListener exportListener;
  private AssetExportSession exportSession;
  private volatile boolean isCanceled;
  private volatile boolean isExporting;
  
  public TAVExporter()
  {
    this.defaultOutputConfig.VIDEO_TARGET_WIDTH = 720;
    this.defaultOutputConfig.VIDEO_TARGET_HEIGHT = 1280;
    this.defaultOutputConfig.VIDEO_FRAME_RATE = 25;
  }
  
  @NonNull
  private File newOutputFile(String paramString)
  {
    paramString = new File(paramString);
    if (paramString.exists()) {}
    for (;;)
    {
      return paramString;
      try
      {
        if (paramString.createNewFile()) {
          continue;
        }
        throw new RuntimeException("创建输出文件失败");
      }
      catch (IOException paramString)
      {
        Logger.e(this.TAG, "export: ", paramString);
        throw new RuntimeException("创建输出文件失败", paramString);
      }
    }
  }
  
  public void cancelExport()
  {
    if (this.exportSession != null)
    {
      this.isCanceled = true;
      this.exportSession.cancelExport();
    }
    this.isExporting = false;
  }
  
  public void export(TAVComposition paramTAVComposition, String paramString)
  {
    export(paramTAVComposition, paramString, this.defaultOutputConfig);
  }
  
  public void export(TAVComposition paramTAVComposition, String paramString, EncoderWriter.OutputConfig paramOutputConfig)
  {
    if (paramTAVComposition == null) {
      return;
    }
    if (this.exportSession != null)
    {
      this.exportSession.cancelExport();
      this.exportSession = null;
    }
    EncoderWriter.OutputConfig localOutputConfig = paramOutputConfig;
    if (paramOutputConfig == null) {
      localOutputConfig = this.defaultOutputConfig;
    }
    paramTAVComposition = new TAVCompositionBuilder(paramTAVComposition);
    paramTAVComposition.setVideoTracksMerge(false);
    paramTAVComposition = paramTAVComposition.buildSource();
    paramOutputConfig = paramTAVComposition.getAsset();
    this.exportSession = new AssetExportSession(paramOutputConfig, localOutputConfig);
    this.exportSession.setTimeRange(new CMTimeRange(CMTime.CMTimeZero, paramOutputConfig.getDuration()));
    this.exportSession.setAudioMix(paramTAVComposition.getAudioMix());
    Logger.i(this.TAG, "export composition duration: " + paramOutputConfig.getDuration(), new Object[0]);
    paramOutputConfig = newOutputFile(paramString);
    this.exportSession.setOutputFilePath(paramOutputConfig.getAbsolutePath());
    this.exportSession.setOutputFileType("mp4");
    this.exportSession.setVideoComposition(paramTAVComposition.getVideoComposition());
    this.exportSession.exportAsynchronouslyWithCompletionHandler(new TAVExporter.1(this, paramString));
  }
  
  public boolean isExporting()
  {
    return this.isExporting;
  }
  
  public void setExportListener(TAVExporter.ExportListener paramExportListener)
  {
    this.exportListener = paramExportListener;
  }
  
  public void setOutputConfig(EncoderWriter.OutputConfig paramOutputConfig)
  {
    this.defaultOutputConfig = paramOutputConfig;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tavkit.component.TAVExporter
 * JD-Core Version:    0.7.0.1
 */