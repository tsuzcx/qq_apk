package com.tencent.qqmini.proxyimpl;

import tv.danmaku.ijk.media.player.IMediaPlayer;

class MediaPlayerImpl$7
  implements tv.danmaku.ijk.media.player.IMediaPlayer.OnInfoListener
{
  MediaPlayerImpl$7(MediaPlayerImpl paramMediaPlayerImpl, com.tencent.qqmini.sdk.core.proxy.IMediaPlayer.OnInfoListener paramOnInfoListener) {}
  
  public boolean onInfo(IMediaPlayer paramIMediaPlayer, int paramInt1, int paramInt2)
  {
    return this.val$listener.onInfo(this.this$0, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.MediaPlayerImpl.7
 * JD-Core Version:    0.7.0.1
 */