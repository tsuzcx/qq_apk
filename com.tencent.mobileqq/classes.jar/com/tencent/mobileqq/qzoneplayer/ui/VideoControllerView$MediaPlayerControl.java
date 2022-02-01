package com.tencent.mobileqq.qzoneplayer.ui;

public abstract interface VideoControllerView$MediaPlayerControl
{
  public abstract boolean canPausePlay();
  
  public abstract boolean canSeekBackward();
  
  public abstract boolean canSeekForward();
  
  public abstract boolean enableToggleFullScreen();
  
  public abstract boolean enableToggleLandscape();
  
  public abstract int getBufferPercentage();
  
  public abstract int getCurrentPosition();
  
  public abstract int getDuration();
  
  public abstract String getVideoUriWithUuid();
  
  public abstract void hideTopBar();
  
  public abstract boolean isFullScreen();
  
  public abstract boolean isLandscape();
  
  public abstract boolean isLoading();
  
  public abstract boolean isPlayComplete();
  
  public abstract boolean isPlaying();
  
  public abstract void pause();
  
  public abstract void seekTo(int paramInt);
  
  public abstract void setRate(float paramFloat);
  
  public abstract void start();
  
  public abstract String time2str(int paramInt);
  
  public abstract void toggleFullScreen();
  
  public abstract void toggleLandscape();
  
  public abstract void updatePlayPauseButton();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qzoneplayer.ui.VideoControllerView.MediaPlayerControl
 * JD-Core Version:    0.7.0.1
 */