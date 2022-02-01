package com.tencent.mobileqq.qqlive.player;

public abstract interface PlayerStatusChangeListener
{
  public abstract void onBufferEnd();
  
  public abstract void onComplete();
  
  public abstract void onError(int paramInt);
  
  public abstract void onFirstFrameRender();
  
  public abstract void onPause();
  
  public abstract void onPrepared();
  
  public abstract void onSeekComplete();
  
  public abstract void onStart();
  
  public abstract void onStartBuffer();
  
  public abstract void onStop();
  
  public abstract void onVideoSizeChanged(int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.player.PlayerStatusChangeListener
 * JD-Core Version:    0.7.0.1
 */