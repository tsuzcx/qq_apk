package com.tencent.thumbplayer.adapter;

import com.tencent.thumbplayer.adapter.player.ITPPlayerBase;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnStateChangeListener;
import com.tencent.thumbplayer.api.TPVideoInfo;

public abstract interface ITPPlayerAdapter
  extends ITPPlayerBase
{
  public abstract int getCurrentPlayClipNo();
  
  public abstract TPPlaybackInfo getPlaybackInfo();
  
  public abstract int getPlayerType();
  
  public abstract boolean isPlaying();
  
  public abstract void setOnPlayerStateChangeListener(ITPPlayerBaseListener.IOnStateChangeListener paramIOnStateChangeListener);
  
  public abstract void setVideoInfo(TPVideoInfo paramTPVideoInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.thumbplayer.adapter.ITPPlayerAdapter
 * JD-Core Version:    0.7.0.1
 */