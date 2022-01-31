package com.tencent.mobileqq.triton.sdk.audio;

public abstract interface IAudioStateChangeListener
{
  public abstract void onCanPlay();
  
  public abstract void onEnded();
  
  public abstract void onError(int paramInt);
  
  public abstract void onPause();
  
  public abstract void onPlay();
  
  public abstract void onSeeked();
  
  public abstract void onSeeking();
  
  public abstract void onStop();
  
  public abstract void onTimeUpdate();
  
  public abstract void onWaiting();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.triton.sdk.audio.IAudioStateChangeListener
 * JD-Core Version:    0.7.0.1
 */