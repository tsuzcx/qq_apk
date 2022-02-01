package com.tencent.mobileqq.nearby.now.view;

import android.support.annotation.IntRange;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.mobileqq.nearby.now.view.logic.IVideoInfoListener;
import com.tencent.mobileqq.nearby.now.view.player.IVideoView;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;

@QAPI(process={"all"})
@QRouteFactory(singleton=false)
public abstract interface IVideoPlayerView
  extends QRouteApi
{
  public abstract IVideoView createVideoView();
  
  public abstract long getCurrentPosition();
  
  public abstract long getDownloadOffset();
  
  public abstract long getDuration();
  
  public abstract long getFileSize();
  
  public abstract int getPlayerType();
  
  public abstract String getmLastUrl();
  
  public abstract int getmPlayerType();
  
  public abstract void hideDownloadProgress();
  
  public abstract void initWidgetView(RelativeLayout paramRelativeLayout);
  
  public abstract boolean isPlaying();
  
  public abstract boolean isVideoCached();
  
  public abstract void pause();
  
  public abstract void play(RelativeLayout paramRelativeLayout, VideoData paramVideoData, Object paramObject);
  
  public abstract void play(VideoData paramVideoData);
  
  public abstract boolean restart();
  
  public abstract void resume();
  
  public abstract void seekTo(@IntRange(from=0L) long paramLong);
  
  public abstract void setCoverVisibility(int paramInt);
  
  public abstract void setOnVideoInfoListener(IVideoInfoListener paramIVideoInfoListener);
  
  public abstract void setProgressCallbackInterval(long paramLong);
  
  public abstract void setShowLoadingWhenLoadingCoverListener(IVideoPlayerView.ShowLoadingWhenLoadingCoverListener paramShowLoadingWhenLoadingCoverListener);
  
  public abstract void setVideoPlayViewVisibility(int paramInt);
  
  public abstract void setmLastUrl(String paramString);
  
  public abstract void setmPlayerType(int paramInt);
  
  public abstract void stopPlayback(boolean paramBoolean);
  
  public abstract void suspend();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.IVideoPlayerView
 * JD-Core Version:    0.7.0.1
 */