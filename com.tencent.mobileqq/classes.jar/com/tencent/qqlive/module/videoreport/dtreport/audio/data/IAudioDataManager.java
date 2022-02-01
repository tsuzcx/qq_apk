package com.tencent.qqlive.module.videoreport.dtreport.audio.data;

public abstract interface IAudioDataManager
{
  public abstract void bindAudioInfo(Object paramObject, AudioEntity paramAudioEntity);
  
  public abstract AudioEntity getAudioInfo(Object paramObject);
  
  public abstract boolean isForeground(Object paramObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.audio.data.IAudioDataManager
 * JD-Core Version:    0.7.0.1
 */