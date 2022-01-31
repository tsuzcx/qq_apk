package com.tencent.oskplayer.player;

import com.tencent.oskplayer.model.SegmentVideoInfo.StreamInfo;
import tv.danmaku.ijk.media.player.IMediaPlayer;

public abstract interface ISegmentMediaPlayer
  extends IMediaPlayer
{
  public abstract String getCurrentProxySegmentUrl();
  
  public abstract String getCurrentSegmentUrl();
  
  public abstract int getSegmentCount();
  
  public abstract void setDataSource(SegmentVideoInfo.StreamInfo paramStreamInfo);
  
  public abstract void setDataSource(SegmentVideoInfo.StreamInfo paramStreamInfo, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.oskplayer.player.ISegmentMediaPlayer
 * JD-Core Version:    0.7.0.1
 */