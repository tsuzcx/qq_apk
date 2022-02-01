package com.tencent.tavkit.component;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
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
  private final String TAG;
  private EncoderWriter.OutputConfig defaultOutputConfig;
  private TAVExporter.ExportListener exportListener;
  private AssetExportSession exportSession;
  private volatile boolean isCanceled;
  private volatile boolean isExporting;
  
  public TAVExporter()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("GameTemplateExporter@");
    ((StringBuilder)localObject).append(Integer.toHexString(hashCode()));
    this.TAG = ((StringBuilder)localObject).toString();
    this.defaultOutputConfig = new EncoderWriter.OutputConfig();
    localObject = this.defaultOutputConfig;
    ((EncoderWriter.OutputConfig)localObject).VIDEO_TARGET_WIDTH = 720;
    ((EncoderWriter.OutputConfig)localObject).VIDEO_TARGET_HEIGHT = 1280;
    ((EncoderWriter.OutputConfig)localObject).VIDEO_FRAME_RATE = 25;
  }
  
  @NonNull
  private File newOutputFile(String paramString)
  {
    paramString = new File(paramString);
    if (paramString.exists()) {
      return paramString;
    }
    try
    {
      if (paramString.createNewFile()) {
        return paramString;
      }
      throw new RuntimeException("创建输出文件失败");
    }
    catch (IOException paramString)
    {
      Logger.e(this.TAG, "export: ", paramString);
      throw new RuntimeException("创建输出文件失败", paramString);
    }
  }
  
  public void cancelExport()
  {
    AssetExportSession localAssetExportSession = this.exportSession;
    if (localAssetExportSession != null)
    {
      this.isCanceled = true;
      localAssetExportSession.cancelExport();
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
    Object localObject = this.exportSession;
    if (localObject != null)
    {
      ((AssetExportSession)localObject).cancelExport();
      this.exportSession = null;
    }
    localObject = paramOutputConfig;
    if (paramOutputConfig == null) {
      localObject = this.defaultOutputConfig;
    }
    paramTAVComposition = new TAVCompositionBuilder(paramTAVComposition).buildSource();
    paramOutputConfig = paramTAVComposition.getAsset();
    this.exportSession = new AssetExportSession(paramOutputConfig, (EncoderWriter.OutputConfig)localObject);
    this.exportSession.setTimeRange(new CMTimeRange(CMTime.CMTimeZero, paramOutputConfig.getDuration()));
    this.exportSession.setAudioMix(paramTAVComposition.getAudioMix());
    localObject = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("export composition duration: ");
    localStringBuilder.append(paramOutputConfig.getDuration());
    Logger.i((String)localObject, localStringBuilder.toString());
    paramOutputConfig = newOutputFile(paramString);
    this.exportSession.setOutputFilePath(paramOutputConfig.getAbsolutePath());
    this.exportSession.setOutputFileType("mp4");
    this.exportSession.setVideoComposition(paramTAVComposition.getVideoComposition());
    this.exportSession.exportAsynchronouslyWithCompletionHandler(new TAVExporter.1(this, paramString));
  }
  
  @Nullable
  public AssetExportSession getExportSession()
  {
    return this.exportSession;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavkit.component.TAVExporter
 * JD-Core Version:    0.7.0.1
 */