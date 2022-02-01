package com.tencent.qqlive.module.videoreport.dtreport.time.audio;

public abstract interface IAudioSessionListener
{
  public abstract void audioEnd();
  
  public abstract void audioPause();
  
  public abstract void audioResume();
  
  public abstract void audioStart();
  
  public abstract void onBufferingEnd();
  
  public abstract void onBufferingStart();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.time.audio.IAudioSessionListener
 * JD-Core Version:    0.7.0.1
 */