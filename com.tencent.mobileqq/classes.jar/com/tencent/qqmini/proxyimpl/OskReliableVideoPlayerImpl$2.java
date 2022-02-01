package com.tencent.qqmini.proxyimpl;

import com.tencent.qqmini.sdk.launcher.core.widget.ReliableVideoPlayer.OnPreparedListener;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IMediaPlayer.OnPreparedListener;

class OskReliableVideoPlayerImpl$2
  implements IMediaPlayer.OnPreparedListener
{
  OskReliableVideoPlayerImpl$2(OskReliableVideoPlayerImpl paramOskReliableVideoPlayerImpl, ReliableVideoPlayer.OnPreparedListener paramOnPreparedListener) {}
  
  public void onPrepared(IMediaPlayer paramIMediaPlayer)
  {
    paramIMediaPlayer = this.a;
    if (paramIMediaPlayer != null) {
      paramIMediaPlayer.onPrepared(this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.OskReliableVideoPlayerImpl.2
 * JD-Core Version:    0.7.0.1
 */