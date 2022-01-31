package com.tencent.qqmini.proxyimpl;

import bgru;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IMediaPlayer.OnInfoListener;

class OskReliableVideoPlayerImpl$8
  implements IMediaPlayer.OnInfoListener
{
  OskReliableVideoPlayerImpl$8(OskReliableVideoPlayerImpl paramOskReliableVideoPlayerImpl, bgru parambgru) {}
  
  public boolean onInfo(IMediaPlayer paramIMediaPlayer, int paramInt1, int paramInt2)
  {
    if (this.val$var1 != null) {
      return this.val$var1.a(this.this$0, paramInt1, paramInt2);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.OskReliableVideoPlayerImpl.8
 * JD-Core Version:    0.7.0.1
 */