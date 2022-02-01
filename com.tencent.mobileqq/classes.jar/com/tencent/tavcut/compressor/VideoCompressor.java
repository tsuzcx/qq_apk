package com.tencent.tavcut.compressor;

import com.tencent.tav.decoder.EncoderWriter.OutputConfig;

public class VideoCompressor
{
  public static final int VIDEO_EXPORT_HEIGHT = 1280;
  public static final int VIDEO_EXPORT_WIDTH = 720;
  
  private EncoderWriter.OutputConfig getDefaultOutputConfig()
  {
    EncoderWriter.OutputConfig localOutputConfig = new EncoderWriter.OutputConfig();
    localOutputConfig.VIDEO_TARGET_WIDTH = 720;
    localOutputConfig.VIDEO_TARGET_HEIGHT = 1280;
    localOutputConfig.VIDEO_FRAME_RATE = 30;
    return localOutputConfig;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavcut.compressor.VideoCompressor
 * JD-Core Version:    0.7.0.1
 */