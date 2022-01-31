package com.tencent.tavcut.exporter;

import android.support.annotation.NonNull;
import com.tencent.tav.asset.Asset;
import com.tencent.tav.core.AssetExportSession;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.EncoderWriter.OutputConfig;
import com.tencent.tav.decoder.RenderContextParams;
import com.tencent.tavcut.util.Logger;
import com.tencent.tavkit.composition.TAVComposition;
import com.tencent.tavkit.composition.TAVSource;
import com.tencent.tavkit.composition.builder.TAVCompositionBuilder;
import java.io.File;
import java.io.IOException;

public class MovieExporter
{
  public static final int ERROR_VIDEO_EXPORT_FAILED_CODE = -10000;
  public static final String IS_VIDEO_EXPORT = "is_video_export";
  private static final String TAG = "MovieExporter";
  public static final int VIDEO_EXPORT_HEIGHT = 1280;
  public static final int VIDEO_EXPORT_WIDTH = 720;
  private EncoderWriter.OutputConfig defaultOutputConfig = new EncoderWriter.OutputConfig();
  private MovieExporter.ExportListener exportListener;
  private AssetExportSession exportSession;
  private volatile boolean isCanceled;
  private volatile boolean isExporting;
  
  public MovieExporter()
  {
    this.defaultOutputConfig.VIDEO_TARGET_WIDTH = 720;
    this.defaultOutputConfig.VIDEO_TARGET_HEIGHT = 1280;
    this.defaultOutputConfig.VIDEO_FRAME_RATE = 30;
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
        Logger.e("MovieExporter", "export: ", paramString);
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
    EncoderWriter.OutputConfig localOutputConfig = paramOutputConfig;
    if (paramOutputConfig == null) {
      localOutputConfig = this.defaultOutputConfig;
    }
    paramOutputConfig = new TAVCompositionBuilder(paramTAVComposition).buildSource();
    Asset localAsset = paramOutputConfig.getAsset();
    this.exportSession = new AssetExportSession(localAsset, localOutputConfig);
    this.exportSession.setTimeRange(new CMTimeRange(CMTime.CMTimeZero, paramTAVComposition.getDuration()));
    this.exportSession.setAudioMix(paramOutputConfig.getAudioMix());
    Logger.i("MovieExporter", "export composition duration: " + localAsset.getDuration());
    paramTAVComposition = newOutputFile(paramString);
    this.exportSession.setOutputFilePath(paramTAVComposition.getAbsolutePath());
    this.exportSession.setOutputFileType("mp4");
    this.exportSession.setVideoComposition(paramOutputConfig.getVideoComposition());
    this.exportSession.exportAsynchronouslyWithCompletionHandler(new MovieExporter.1(this, paramString));
    paramTAVComposition = new RenderContextParams();
    paramTAVComposition.putParam("is_video_export", Boolean.valueOf(true));
    this.exportSession.setRenderContextParams(paramTAVComposition);
  }
  
  public boolean isExporting()
  {
    return this.isExporting;
  }
  
  public void setExportListener(MovieExporter.ExportListener paramExportListener)
  {
    this.exportListener = paramExportListener;
  }
  
  public void setOutputConfig(EncoderWriter.OutputConfig paramOutputConfig)
  {
    this.defaultOutputConfig = paramOutputConfig;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tavcut.exporter.MovieExporter
 * JD-Core Version:    0.7.0.1
 */