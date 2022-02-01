package com.tencent.thumbplayer.adapter;

import com.tencent.thumbplayer.adapter.player.ITPPlayerBase;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnStateChangeListener;
import com.tencent.thumbplayer.adapter.player.TPUrlDataSource;
import com.tencent.thumbplayer.api.TPVideoInfo;
import com.tencent.thumbplayer.api.richmedia.ITPRichMediaSynchronizer;
import java.util.Map;

public abstract interface ITPPlayerAdapter
  extends ITPPlayerBase
{
  public abstract int getCurrentPlayClipNo();
  
  public abstract int getCurrentState();
  
  public abstract TPPlaybackInfo getPlaybackInfo();
  
  public abstract int getPlayerType();
  
  public abstract boolean isPlaying();
  
  public abstract void setDataSource(TPUrlDataSource paramTPUrlDataSource);
  
  public abstract void setDataSource(TPUrlDataSource paramTPUrlDataSource, Map<String, String> paramMap);
  
  public abstract void setOnPlayerStateChangeListener(ITPPlayerBaseListener.IOnStateChangeListener paramIOnStateChangeListener);
  
  public abstract void setRichMediaSynchronizer(ITPRichMediaSynchronizer paramITPRichMediaSynchronizer);
  
  public abstract void setVideoInfo(TPVideoInfo paramTPVideoInfo);
  
  public abstract void switchDefinition(TPUrlDataSource paramTPUrlDataSource, int paramInt, long paramLong);
  
  public abstract void switchDefinition(TPUrlDataSource paramTPUrlDataSource, Map<String, String> paramMap, int paramInt, long paramLong);
  
  public abstract void updateVideoInfo(TPVideoInfo paramTPVideoInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.adapter.ITPPlayerAdapter
 * JD-Core Version:    0.7.0.1
 */