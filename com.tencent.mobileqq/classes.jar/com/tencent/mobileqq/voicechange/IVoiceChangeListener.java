package com.tencent.mobileqq.voicechange;

public abstract interface IVoiceChangeListener
{
  public abstract void onError();
  
  public abstract void onPlayEnd();
  
  public abstract void onPlayStop();
  
  public abstract void onSlicePlayed(int paramInt1, int paramInt2, int paramInt3);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.voicechange.IVoiceChangeListener
 * JD-Core Version:    0.7.0.1
 */