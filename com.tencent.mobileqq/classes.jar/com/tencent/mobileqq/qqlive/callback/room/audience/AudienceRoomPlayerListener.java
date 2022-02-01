package com.tencent.mobileqq.qqlive.callback.room.audience;

public abstract interface AudienceRoomPlayerListener
{
  public abstract void onError(int paramInt, String paramString);
  
  public abstract void onFirstFrameCome();
  
  public abstract void onPause();
  
  public abstract void onPlay();
  
  public abstract void onPlayCompleted();
  
  public abstract void onResume();
  
  public abstract void onStartBuffer();
  
  public abstract void onStopBuffer();
  
  public abstract void onVideoSizeChanged(int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.callback.room.audience.AudienceRoomPlayerListener
 * JD-Core Version:    0.7.0.1
 */