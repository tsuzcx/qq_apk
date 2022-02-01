package com.tencent.qcircle.tavcut.exporter;

import android.media.MediaMetadataRetriever;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import com.tencent.qcircle.tavcut.util.Logger;
import com.tencent.tav.asset.Asset;
import com.tencent.tav.asset.URLAsset;
import com.tencent.tav.core.AssetExportSession;
import com.tencent.tav.core.AssetExportSession.ErrorInterceptor;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.EncoderWriter.OutputConfig;
import com.tencent.tav.decoder.RenderContextParams;
import com.tencent.tavkit.composition.TAVClip;
import com.tencent.tavkit.composition.TAVComposition;
import com.tencent.tavkit.composition.TAVSource;
import com.tencent.tavkit.composition.builder.TAVCompositionBuilder;
import com.tencent.tavkit.composition.resource.TAVResource;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MovieExporter
{
  public static final int ERROR_VIDEO_EXPORT_FAILED_CODE = -10000;
  public static final String IS_VIDEO_EXPORT = "is_video_export";
  private static final String TAG = "MovieExporter";
  public static final int VIDEO_EXPORT_HEIGHT = 1280;
  public static final int VIDEO_EXPORT_WIDTH = 720;
  private AssetExportSession compressSession;
  private EncoderWriter.OutputConfig defaultOutputConfig = new EncoderWriter.OutputConfig();
  private AssetExportSession.ErrorInterceptor errorInterceptor;
  private MovieExporter.ExportListener exportListener;
  private AssetExportSession exportSession;
  private volatile boolean isCanceled;
  private volatile boolean isCompressCanceled;
  private volatile boolean isCompressing;
  private volatile boolean isExporting;
  private Handler mainHandler = new Handler(Looper.getMainLooper());
  
  public MovieExporter()
  {
    EncoderWriter.OutputConfig localOutputConfig = this.defaultOutputConfig;
    localOutputConfig.VIDEO_TARGET_WIDTH = 720;
    localOutputConfig.VIDEO_TARGET_HEIGHT = 1280;
    localOutputConfig.VIDEO_FRAME_RATE = 30;
  }
  
  private long getVideoDuration(String paramString)
  {
    MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
    localMediaMetadataRetriever.setDataSource(paramString);
    return Long.parseLong(localMediaMetadataRetriever.extractMetadata(9));
  }
  
  @NonNull
  private File newCompressOutputFile(String paramString)
  {
    paramString = new File(paramString);
    if (paramString.exists()) {
      return paramString;
    }
    try
    {
      if ((!paramString.getParentFile().exists()) && (!paramString.getParentFile().mkdirs())) {
        throw new RuntimeException("创建父路径失败");
      }
      if (paramString.createNewFile()) {
        return paramString;
      }
      throw new RuntimeException("创建输出文件失败");
    }
    catch (IOException paramString)
    {
      Logger.e("MovieExporter", "export: ", paramString);
      throw new RuntimeException("创建输出文件失败", paramString);
    }
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
      Logger.e("MovieExporter", "export: ", paramString);
      throw new RuntimeException("创建输出文件失败", paramString);
    }
  }
  
  public void cancelCompress()
  {
    AssetExportSession localAssetExportSession = this.compressSession;
    if (localAssetExportSession != null)
    {
      this.isCompressCanceled = true;
      localAssetExportSession.cancelExport();
    }
    this.isCompressing = false;
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
  
  public void compressVideo(String paramString, MovieExporter.VideoCompressListener paramVideoCompressListener)
  {
    if ((paramString != null) && (paramString.length() > 0))
    {
      compressVideo(paramString, paramString.replace(".", "_compress."), null, paramVideoCompressListener);
      return;
    }
    throw new RuntimeException("input path should not be empty");
  }
  
  public void compressVideo(String paramString1, String paramString2, MovieExporter.VideoCompressListener paramVideoCompressListener)
  {
    compressVideo(paramString1, paramString2, null, paramVideoCompressListener);
  }
  
  public void compressVideo(String paramString1, String paramString2, EncoderWriter.OutputConfig paramOutputConfig, MovieExporter.VideoCompressListener paramVideoCompressListener)
  {
    if ((paramString1 != null) && (paramString1.length() != 0))
    {
      Object localObject1 = new ArrayList();
      Object localObject2 = new TAVClip(new URLAsset(paramString1));
      long l = getVideoDuration(paramString1);
      ((TAVClip)localObject2).getResource().setSourceTimeRange(new CMTimeRange(new CMTime(0L), new CMTime((float)l / 1000.0F)));
      ((List)localObject1).add(localObject2);
      localObject1 = new TAVComposition((List)localObject1);
      paramString1 = paramOutputConfig;
      if (paramOutputConfig == null) {
        paramString1 = this.defaultOutputConfig;
      }
      paramOutputConfig = new TAVCompositionBuilder((TAVComposition)localObject1).buildSource();
      localObject2 = paramOutputConfig.getAsset();
      this.compressSession = new AssetExportSession((Asset)localObject2, paramString1);
      this.compressSession.setTimeRange(new CMTimeRange(CMTime.CMTimeZero, ((TAVComposition)localObject1).getDuration()));
      this.compressSession.setAudioMix(paramOutputConfig.getAudioMix());
      paramString1 = new StringBuilder();
      paramString1.append("export composition duration: ");
      paramString1.append(((Asset)localObject2).getDuration());
      Logger.i("MovieExporter", paramString1.toString());
      paramString1 = newCompressOutputFile(paramString2);
      this.compressSession.setOutputFilePath(paramString1.getAbsolutePath());
      this.compressSession.setOutputFileType("mp4");
      this.compressSession.setVideoComposition(paramOutputConfig.getVideoComposition());
      this.compressSession.setErrorInterceptor(this.errorInterceptor);
      this.compressSession.exportAsynchronouslyWithCompletionHandler(new MovieExporter.1(this, paramVideoCompressListener, paramString2));
      paramString1 = new RenderContextParams();
      paramString1.putParam("is_video_export", Boolean.valueOf(true));
      this.compressSession.setRenderContextParams(paramString1);
      return;
    }
    throw new RuntimeException("input path should not be empty");
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
    paramTAVComposition = new StringBuilder();
    paramTAVComposition.append("export composition duration: ");
    paramTAVComposition.append(localAsset.getDuration());
    Logger.i("MovieExporter", paramTAVComposition.toString());
    paramTAVComposition = newOutputFile(paramString);
    this.exportSession.setOutputFilePath(paramTAVComposition.getAbsolutePath());
    this.exportSession.setOutputFileType("mp4");
    this.exportSession.setVideoComposition(paramOutputConfig.getVideoComposition());
    this.exportSession.setErrorInterceptor(this.errorInterceptor);
    this.exportSession.exportAsynchronouslyWithCompletionHandler(new MovieExporter.2(this, paramString));
    paramTAVComposition = new RenderContextParams();
    paramTAVComposition.putParam("is_video_export", Boolean.valueOf(true));
    this.exportSession.setRenderContextParams(paramTAVComposition);
  }
  
  public boolean isExporting()
  {
    return this.isExporting;
  }
  
  public void setErrorInterceptor(AssetExportSession.ErrorInterceptor paramErrorInterceptor)
  {
    this.errorInterceptor = paramErrorInterceptor;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.tavcut.exporter.MovieExporter
 * JD-Core Version:    0.7.0.1
 */