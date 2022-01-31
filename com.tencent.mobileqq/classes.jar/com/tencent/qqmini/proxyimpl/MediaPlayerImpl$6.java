package com.tencent.qqmini.proxyimpl;

import tv.danmaku.ijk.media.player.IMediaPlayer;

class MediaPlayerImpl$6
  implements tv.danmaku.ijk.media.player.IMediaPlayer.OnErrorListener
{
  MediaPlayerImpl$6(MediaPlayerImpl paramMediaPlayerImpl, com.tencent.qqmini.sdk.core.proxy.IMediaPlayer.OnErrorListener paramOnErrorListener) {}
  
  public boolean onError(IMediaPlayer paramIMediaPlayer, int paramInt1, int paramInt2)
  {
    return this.val$listener.onError(this.this$0, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.MediaPlayerImpl.6
 * JD-Core Version:    0.7.0.1
 */