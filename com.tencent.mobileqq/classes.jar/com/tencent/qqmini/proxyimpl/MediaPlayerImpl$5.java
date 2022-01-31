package com.tencent.qqmini.proxyimpl;

import tv.danmaku.ijk.media.player.IMediaPlayer;

class MediaPlayerImpl$5
  implements tv.danmaku.ijk.media.player.IMediaPlayer.OnVideoSizeChangedListener
{
  MediaPlayerImpl$5(MediaPlayerImpl paramMediaPlayerImpl, com.tencent.qqmini.sdk.core.proxy.IMediaPlayer.OnVideoSizeChangedListener paramOnVideoSizeChangedListener) {}
  
  public void onVideoSizeChanged(IMediaPlayer paramIMediaPlayer, int paramInt1, int paramInt2)
  {
    this.val$listener.onVideoSizeChanged(this.this$0, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.MediaPlayerImpl.5
 * JD-Core Version:    0.7.0.1
 */