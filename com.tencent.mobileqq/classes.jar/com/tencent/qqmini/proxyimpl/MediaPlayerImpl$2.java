package com.tencent.qqmini.proxyimpl;

import tv.danmaku.ijk.media.player.IMediaPlayer;

class MediaPlayerImpl$2
  implements tv.danmaku.ijk.media.player.IMediaPlayer.OnCompletionListener
{
  MediaPlayerImpl$2(MediaPlayerImpl paramMediaPlayerImpl, com.tencent.qqmini.sdk.core.proxy.IMediaPlayer.OnCompletionListener paramOnCompletionListener) {}
  
  public void onCompletion(IMediaPlayer paramIMediaPlayer)
  {
    this.val$listener.onCompletion(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.MediaPlayerImpl.2
 * JD-Core Version:    0.7.0.1
 */