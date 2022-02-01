package com.tencent.mobileqq.shortvideo.util.videoconverter;

import java.io.File;

public abstract interface VideoConverter$VideoConverterImpl
{
  public abstract boolean cancel();
  
  public abstract boolean start(File paramFile, VideoConverter.Processor paramProcessor, boolean paramBoolean);
  
  public abstract boolean stop();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.util.videoconverter.VideoConverter.VideoConverterImpl
 * JD-Core Version:    0.7.0.1
 */