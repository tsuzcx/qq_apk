package com.tencent.mobileqq.videoplatform.api;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

public abstract interface IBaseVideoView
{
  public abstract void captureCurFrame(long paramLong, int paramInt1, int paramInt2);
  
  public abstract Drawable getCoverDrawable();
  
  public abstract ImageView getCoverImage();
  
  public abstract long getCurPlayingPos();
  
  public abstract long getVideoDurationMs();
  
  public abstract boolean isLocalPlay();
  
  public abstract boolean isMute();
  
  public abstract boolean isPlaying();
  
  public abstract void pause();
  
  public abstract void pauseDownload();
  
  public abstract void play();
  
  public abstract void releasePlayer(boolean paramBoolean);
  
  public abstract void resume();
  
  public abstract void resumeDownload();
  
  public abstract void seekTo(int paramInt);
  
  public abstract void setCoverDrawable(Drawable paramDrawable);
  
  public abstract void setID(long paramLong);
  
  public abstract void setMute(boolean paramBoolean);
  
  public abstract void setVideoParam(VideoPlayParam paramVideoPlayParam);
  
  public abstract void showCover(Drawable paramDrawable);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.videoplatform.api.IBaseVideoView
 * JD-Core Version:    0.7.0.1
 */