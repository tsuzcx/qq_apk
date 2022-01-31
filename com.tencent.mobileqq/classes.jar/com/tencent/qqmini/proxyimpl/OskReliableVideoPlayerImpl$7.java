package com.tencent.qqmini.proxyimpl;

import bgnm;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IMediaPlayer.OnErrorListener;

class OskReliableVideoPlayerImpl$7
  implements IMediaPlayer.OnErrorListener
{
  OskReliableVideoPlayerImpl$7(OskReliableVideoPlayerImpl paramOskReliableVideoPlayerImpl, bgnm parambgnm) {}
  
  public boolean onError(IMediaPlayer paramIMediaPlayer, int paramInt1, int paramInt2)
  {
    if (this.val$var1 != null) {
      return this.val$var1.a(this.this$0, paramInt1, paramInt2);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.OskReliableVideoPlayerImpl.7
 * JD-Core Version:    0.7.0.1
 */