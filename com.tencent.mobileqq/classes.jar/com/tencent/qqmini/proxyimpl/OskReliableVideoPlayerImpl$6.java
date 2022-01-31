package com.tencent.qqmini.proxyimpl;

import bgnr;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IMediaPlayer.OnVideoSizeChangedListener;

class OskReliableVideoPlayerImpl$6
  implements IMediaPlayer.OnVideoSizeChangedListener
{
  OskReliableVideoPlayerImpl$6(OskReliableVideoPlayerImpl paramOskReliableVideoPlayerImpl, bgnr parambgnr) {}
  
  public void onVideoSizeChanged(IMediaPlayer paramIMediaPlayer, int paramInt1, int paramInt2)
  {
    if (this.val$var1 != null) {
      this.val$var1.a(this.this$0, paramInt1, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.OskReliableVideoPlayerImpl.6
 * JD-Core Version:    0.7.0.1
 */