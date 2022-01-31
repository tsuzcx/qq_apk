package com.tencent.qqmini.proxyimpl;

import bgnq;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IMediaPlayer.OnSeekCompleteListener;

class OskReliableVideoPlayerImpl$5
  implements IMediaPlayer.OnSeekCompleteListener
{
  OskReliableVideoPlayerImpl$5(OskReliableVideoPlayerImpl paramOskReliableVideoPlayerImpl, bgnq parambgnq) {}
  
  public void onSeekComplete(IMediaPlayer paramIMediaPlayer)
  {
    if (this.val$var1 != null) {
      this.val$var1.a(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.OskReliableVideoPlayerImpl.5
 * JD-Core Version:    0.7.0.1
 */