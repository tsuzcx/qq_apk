package com.tencent.tavkit.component;

import android.support.annotation.NonNull;
import com.tencent.tav.core.AssetExportSession;
import com.tencent.tav.core.AssetExportSession.ErrorInterceptor;
import com.tencent.tav.core.AssetExportSession.ExportCallbackHandler;
import com.tencent.tav.core.ExportConfig;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tavkit.composition.TAVComposition;
import com.tencent.tavkit.composition.TAVSource;
import com.tencent.tavkit.composition.builder.TAVCompositionBuilder;
import java.io.File;
import java.io.IOException;
import org.jetbrains.annotations.NotNull;

public class TAVExportSession
{
  private AssetExportSession.ExportCallbackHandler callbackHandler;
  private AssetExportSession exportSession;
  private final String mTAG;
  
  public TAVExportSession(TAVComposition paramTAVComposition, @NotNull ExportConfig paramExportConfig)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("TAVExporterSession@");
    ((StringBuilder)localObject).append(Integer.toHexString(hashCode()));
    this.mTAG = ((StringBuilder)localObject).toString();
    localObject = new TAVCompositionBuilder(paramTAVComposition).buildSource();
    this.exportSession = new AssetExportSession(((TAVSource)localObject).getAsset(), paramExportConfig);
    this.exportSession.setTimeRange(new CMTimeRange(CMTime.CMTimeZero, paramTAVComposition.getDuration()));
    this.exportSession.setAudioMix(((TAVSource)localObject).getAudioMix());
    this.exportSession.setVideoComposition(((TAVSource)localObject).getVideoComposition());
    paramTAVComposition = newOutputFile(paramExportConfig.getOutputFilePath());
    this.exportSession.setOutputFilePath(paramTAVComposition.getAbsolutePath());
    this.exportSession.setOutputFileType("mp4");
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
  
  public void setCallbackHandler(AssetExportSession.ExportCallbackHandler paramExportCallbackHandler)
  {
    this.callbackHandler = paramExportCallbackHandler;
  }
  
  public void setErrorInterceptor(AssetExportSession.ErrorInterceptor paramErrorInterceptor)
  {
    this.exportSession.setErrorInterceptor(paramErrorInterceptor);
  }
  
  public void start()
  {
    if (this.exportSession.getStatus() != null) {
      return;
    }
    this.exportSession.exportAsynchronouslyWithCompletionHandler(this.callbackHandler);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavkit.component.TAVExportSession
 * JD-Core Version:    0.7.0.1
 */