package com.tencent.qqmini.proxyimpl;

import bgnk;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IMediaPlayer.OnBufferingUpdateListener;

class OskReliableVideoPlayerImpl$4
  implements IMediaPlayer.OnBufferingUpdateListener
{
  OskReliableVideoPlayerImpl$4(OskReliableVideoPlayerImpl paramOskReliableVideoPlayerImpl, bgnk parambgnk) {}
  
  public void onBufferingUpdate(IMediaPlayer paramIMediaPlayer, int paramInt)
  {
    if (this.val$var1 != null) {
      this.val$var1.a(this.this$0, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.OskReliableVideoPlayerImpl.4
 * JD-Core Version:    0.7.0.1
 */