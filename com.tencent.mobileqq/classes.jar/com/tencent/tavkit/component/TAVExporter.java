package com.tencent.tavkit.component;

import android.support.annotation.NonNull;
import com.tencent.tav.asset.Asset;
import com.tencent.tav.core.AssetExportSession;
import com.tencent.tav.core.AssetExportSession.ErrorInterceptor;
import com.tencent.tav.core.ExportConfig;
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
  private static final int VIDEO_EXPORT_HEIGHT = 1280;
  private static final int VIDEO_EXPORT_WIDTH = 720;
  private static final int VIDEO_FRAME_RATE = 30;
  private boolean audioRevertMode;
  private final ExportConfig defaultOutputConfig;
  private AssetExportSession.ErrorInterceptor errorInterceptor;
  private TAVExporter.ExportListener exportListener;
  private AssetExportSession exportSession;
  private volatile boolean isCanceled;
  private volatile boolean isExporting;
  private final String mTAG;
  private boolean videoRevertMode;
  
  public TAVExporter()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GameTemplateExporter@");
    localStringBuilder.append(Integer.toHexString(hashCode()));
    this.mTAG = localStringBuilder.toString();
    this.videoRevertMode = false;
    this.audioRevertMode = false;
    this.defaultOutputConfig = new ExportConfig(720, 1280);
    this.defaultOutputConfig.setVideoFrameRate(30);
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
      Logger.e(this.mTAG, "export: ", paramString);
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
  
  public void export(TAVComposition paramTAVComposition, String paramString, ExportConfig paramExportConfig)
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
    localObject = paramExportConfig;
    if (paramExportConfig == null) {
      localObject = this.defaultOutputConfig;
    }
    paramExportConfig = new TAVCompositionBuilder(paramTAVComposition).buildSource();
    Asset localAsset = paramExportConfig.getAsset();
    this.exportSession = new AssetExportSession(localAsset, (ExportConfig)localObject);
    this.exportSession.setVideoRevertMode(this.videoRevertMode);
    this.exportSession.setAudioRevertModel(this.audioRevertMode);
    this.exportSession.setTimeRange(new CMTimeRange(CMTime.CMTimeZero, paramTAVComposition.getDuration()));
    this.exportSession.setAudioMix(paramExportConfig.getAudioMix());
    paramTAVComposition = this.mTAG;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("export composition duration: ");
    ((StringBuilder)localObject).append(localAsset.getDuration());
    Logger.i(paramTAVComposition, ((StringBuilder)localObject).toString());
    paramTAVComposition = newOutputFile(paramString);
    this.exportSession.setErrorInterceptor(this.errorInterceptor);
    this.exportSession.setOutputFilePath(paramTAVComposition.getAbsolutePath());
    this.exportSession.setOutputFileType("mp4");
    this.exportSession.setVideoComposition(paramExportConfig.getVideoComposition());
    this.exportSession.exportAsynchronouslyWithCompletionHandler(new TAVExporter.MyExportCallbackHandler(this, paramString));
    this.isExporting = true;
  }
  
  @Deprecated
  public void export(TAVComposition paramTAVComposition, String paramString, EncoderWriter.OutputConfig paramOutputConfig)
  {
    export(paramTAVComposition, paramString, new ExportConfig(paramOutputConfig));
  }
  
  public boolean isExporting()
  {
    return this.isExporting;
  }
  
  public void setAudioRevertMode(boolean paramBoolean)
  {
    this.audioRevertMode = paramBoolean;
  }
  
  public void setErrorInterceptor(AssetExportSession.ErrorInterceptor paramErrorInterceptor)
  {
    this.errorInterceptor = paramErrorInterceptor;
  }
  
  public void setExportListener(TAVExporter.ExportListener paramExportListener)
  {
    this.exportListener = paramExportListener;
  }
  
  @Deprecated
  public void setRevertMode(boolean paramBoolean)
  {
    this.videoRevertMode = paramBoolean;
  }
  
  public void setVideoRevertMode(boolean paramBoolean)
  {
    this.videoRevertMode = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavkit.component.TAVExporter
 * JD-Core Version:    0.7.0.1
 */