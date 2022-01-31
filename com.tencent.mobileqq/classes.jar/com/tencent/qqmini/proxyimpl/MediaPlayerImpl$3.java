package com.tencent.qqmini.proxyimpl;

import tv.danmaku.ijk.media.player.IMediaPlayer;

class MediaPlayerImpl$3
  implements tv.danmaku.ijk.media.player.IMediaPlayer.OnBufferingUpdateListener
{
  MediaPlayerImpl$3(MediaPlayerImpl paramMediaPlayerImpl, com.tencent.qqmini.sdk.core.proxy.IMediaPlayer.OnBufferingUpdateListener paramOnBufferingUpdateListener) {}
  
  public void onBufferingUpdate(IMediaPlayer paramIMediaPlayer, int paramInt)
  {
    this.val$listener.onBufferingUpdate(this.this$0, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.MediaPlayerImpl.3
 * JD-Core Version:    0.7.0.1
 */