package com.tencent.oskplayer.player;

import com.tencent.oskplayer.model.SegmentVideoInfo.StreamInfo;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.MediaPlayerProxy;

public class SegmentMediaPlayerProxy
  extends MediaPlayerProxy
  implements ISegmentMediaPlayer
{
  public SegmentMediaPlayerProxy(IMediaPlayer paramIMediaPlayer)
  {
    super(paramIMediaPlayer);
  }
  
  public String getCurrentProxySegmentUrl()
  {
    if ((this.mBackEndMediaPlayer instanceof ISegmentMediaPlayer)) {
      return ((ISegmentMediaPlayer)this.mBackEndMediaPlayer).getCurrentProxySegmentUrl();
    }
    throw new UnsupportedOperationException();
  }
  
  public String getCurrentSegmentUrl()
  {
    if ((this.mBackEndMediaPlayer instanceof ISegmentMediaPlayer)) {
      return ((ISegmentMediaPlayer)this.mBackEndMediaPlayer).getCurrentSegmentUrl();
    }
    throw new UnsupportedOperationException();
  }
  
  public int getSegmentCount()
  {
    if ((this.mBackEndMediaPlayer instanceof ISegmentMediaPlayer)) {
      return ((ISegmentMediaPlayer)this.mBackEndMediaPlayer).getSegmentCount();
    }
    throw new UnsupportedOperationException();
  }
  
  public void setDataSource(SegmentVideoInfo.StreamInfo paramStreamInfo)
  {
    if ((this.mBackEndMediaPlayer instanceof ISegmentMediaPlayer))
    {
      ((ISegmentMediaPlayer)this.mBackEndMediaPlayer).setDataSource(paramStreamInfo);
      return;
    }
    throw new UnsupportedOperationException();
  }
  
  public void setDataSource(SegmentVideoInfo.StreamInfo paramStreamInfo, int paramInt)
  {
    if ((this.mBackEndMediaPlayer instanceof ISegmentMediaPlayer))
    {
      ((ISegmentMediaPlayer)this.mBackEndMediaPlayer).setDataSource(paramStreamInfo, paramInt);
      return;
    }
    throw new UnsupportedOperationException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.oskplayer.player.SegmentMediaPlayerProxy
 * JD-Core Version:    0.7.0.1
 */