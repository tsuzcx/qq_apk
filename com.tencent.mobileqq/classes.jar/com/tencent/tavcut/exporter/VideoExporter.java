package com.tencent.tavcut.exporter;

import com.tencent.tav.decoder.EncoderWriter.OutputConfig;
import com.tencent.tavkit.composition.TAVComposition;

public class VideoExporter
{
  private MovieExporter movieExporter;
  private TAVComposition tavComposition;
  private VideoExportConfig videoExportConfig;
  
  public void cancel()
  {
    if (this.movieExporter != null)
    {
      this.movieExporter.cancelExport();
      this.movieExporter = null;
    }
  }
  
  public void export(MovieExporter.ExportListener paramExportListener)
  {
    cancel();
    this.movieExporter = new MovieExporter();
    EncoderWriter.OutputConfig localOutputConfig = new EncoderWriter.OutputConfig();
    if ((this.videoExportConfig.getWidth() != -1) && (this.videoExportConfig.getHeight() != -1))
    {
      localOutputConfig.VIDEO_TARGET_WIDTH = this.videoExportConfig.getWidth();
      localOutputConfig.VIDEO_TARGET_HEIGHT = this.videoExportConfig.getHeight();
    }
    if (this.videoExportConfig.getBitRate() != -1) {
      localOutputConfig.VIDEO_BIT_RATE = this.videoExportConfig.getBitRate();
    }
    if (this.videoExportConfig.getFrameRate() != -1) {
      localOutputConfig.VIDEO_FRAME_RATE = this.videoExportConfig.getFrameRate();
    }
    this.movieExporter.setExportListener(paramExportListener);
    this.movieExporter.export(this.tavComposition, this.videoExportConfig.getOutputPath(), localOutputConfig);
  }
  
  public MovieExporter getMovieExporter()
  {
    return this.movieExporter;
  }
  
  public void setMovieExporter(MovieExporter paramMovieExporter)
  {
    this.movieExporter = paramMovieExporter;
  }
  
  public void setTavComposition(TAVComposition paramTAVComposition)
  {
    this.tavComposition = paramTAVComposition;
  }
  
  public void setVideoExportConfig(VideoExportConfig paramVideoExportConfig)
  {
    this.videoExportConfig = paramVideoExportConfig;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavcut.exporter.VideoExporter
 * JD-Core Version:    0.7.0.1
 */