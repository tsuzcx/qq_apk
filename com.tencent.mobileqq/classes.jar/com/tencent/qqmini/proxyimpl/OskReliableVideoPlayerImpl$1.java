package com.tencent.qqmini.proxyimpl;

import com.tencent.qqmini.sdk.launcher.core.widget.ReliableVideoPlayer.OnLoopStartListener;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IMediaPlayer.OnLoopStartListener;

class OskReliableVideoPlayerImpl$1
  implements IMediaPlayer.OnLoopStartListener
{
  OskReliableVideoPlayerImpl$1(OskReliableVideoPlayerImpl paramOskReliableVideoPlayerImpl, ReliableVideoPlayer.OnLoopStartListener paramOnLoopStartListener) {}
  
  public void onLoopStart(IMediaPlayer paramIMediaPlayer)
  {
    paramIMediaPlayer = this.a;
    if (paramIMediaPlayer != null) {
      paramIMediaPlayer.onLoopStart(this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.OskReliableVideoPlayerImpl.1
 * JD-Core Version:    0.7.0.1
 */