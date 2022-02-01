package com.tencent.qg.sdk.video;

public abstract interface IMediaPlayer
{
  public abstract void create(long paramLong);
  
  public abstract void destroy();
  
  public abstract int getCurrentPosition();
  
  public abstract int getDuration();
  
  public abstract boolean isEnd();
  
  public abstract boolean isMuted();
  
  public abstract boolean isPlaying();
  
  public abstract void pause();
  
  public abstract void play(int paramInt1, int paramInt2, int paramInt3);
  
  public abstract void seekTo(int paramInt);
  
  public abstract void setLooping(boolean paramBoolean);
  
  public abstract void setMuted(boolean paramBoolean);
  
  public abstract void setSrc(String paramString);
  
  public abstract void setVolume(float paramFloat1, float paramFloat2);
  
  public abstract void stop();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qg.sdk.video.IMediaPlayer
 * JD-Core Version:    0.7.0.1
 */