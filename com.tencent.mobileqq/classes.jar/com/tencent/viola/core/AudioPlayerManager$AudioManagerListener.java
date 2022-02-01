package com.tencent.viola.core;

public abstract interface AudioPlayerManager$AudioManagerListener
{
  public abstract void playBuffering();
  
  public abstract void playComplete();
  
  public abstract void playError(int paramInt1, int paramInt2);
  
  public abstract void playPaused();
  
  public abstract void playResume();
  
  public abstract void playStart();
  
  public abstract void playTimeChange(int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.viola.core.AudioPlayerManager.AudioManagerListener
 * JD-Core Version:    0.7.0.1
 */