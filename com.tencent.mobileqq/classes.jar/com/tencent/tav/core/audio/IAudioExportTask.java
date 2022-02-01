package com.tencent.tav.core.audio;

public abstract interface IAudioExportTask
{
  public abstract void cancel();
  
  public abstract void setExportCallback(ExportCallback paramExportCallback);
  
  public abstract void start();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tav.core.audio.IAudioExportTask
 * JD-Core Version:    0.7.0.1
 */