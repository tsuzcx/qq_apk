package com.tencent.mobileqq.nearby.now.view;

public abstract interface IVideoPlayerView$VideoInfoListener
{
  public abstract void onComplete();
  
  public abstract void onCoverComplete(int paramInt1, int paramInt2, boolean paramBoolean);
  
  public abstract void onDoingStartPlayback();
  
  public abstract void onDoingStopPlayback();
  
  public abstract void onPlayProgress(int paramInt);
  
  public abstract void onStartPlaying();
  
  public abstract void onStartPrepareVideo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.IVideoPlayerView.VideoInfoListener
 * JD-Core Version:    0.7.0.1
 */