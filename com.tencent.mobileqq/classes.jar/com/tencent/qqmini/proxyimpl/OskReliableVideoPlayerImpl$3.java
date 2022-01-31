package com.tencent.qqmini.proxyimpl;

import bgnl;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IMediaPlayer.OnCompletionListener;

class OskReliableVideoPlayerImpl$3
  implements IMediaPlayer.OnCompletionListener
{
  OskReliableVideoPlayerImpl$3(OskReliableVideoPlayerImpl paramOskReliableVideoPlayerImpl, bgnl parambgnl) {}
  
  public void onCompletion(IMediaPlayer paramIMediaPlayer)
  {
    if (this.val$var1 != null) {
      this.val$var1.a(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.OskReliableVideoPlayerImpl.3
 * JD-Core Version:    0.7.0.1
 */