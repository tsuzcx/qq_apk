package com.tencent.mobileqq.shortvideo.util.videoconverter;

import android.os.Build.VERSION;
import java.io.File;

public class VideoConverter
{
  VideoConverter.VideoConverterImpl impl;
  
  public VideoConverter()
  {
    if (Build.VERSION.SDK_INT >= 18) {
      this.impl = new JBMR2VideoConverterImpl();
    }
  }
  
  public VideoConverter(VideoConverter.VideoConverterImpl paramVideoConverterImpl)
  {
    if (Build.VERSION.SDK_INT >= 18) {
      this.impl = paramVideoConverterImpl;
    }
  }
  
  public boolean cancel()
  {
    return (this.impl != null) && (this.impl.cancel());
  }
  
  public boolean start(File paramFile, VideoConverter.Processor paramProcessor, boolean paramBoolean)
  {
    if (this.impl != null) {
      return this.impl.start(paramFile, paramProcessor, paramBoolean);
    }
    return false;
  }
  
  public boolean stop()
  {
    if (this.impl != null) {
      return this.impl.stop();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.util.videoconverter.VideoConverter
 * JD-Core Version:    0.7.0.1
 */