package com.tencent.oskplayer.player;

import com.google.android.exoplayer2.ext.mediaplayer.MediaPlayerInterface;
import com.google.android.exoplayer2.ext.mediaplayer.MediaPlayerInterface.OnErrorListener;
import tv.danmaku.ijk.media.player.IMediaPlayer.OnErrorListener;

class OskExoMediaPlayer$7
  implements MediaPlayerInterface.OnErrorListener
{
  OskExoMediaPlayer$7(OskExoMediaPlayer paramOskExoMediaPlayer, IMediaPlayer.OnErrorListener paramOnErrorListener) {}
  
  public boolean onError(MediaPlayerInterface paramMediaPlayerInterface, int paramInt1, int paramInt2)
  {
    return this.val$listener.onError(this.this$0, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.oskplayer.player.OskExoMediaPlayer.7
 * JD-Core Version:    0.7.0.1
 */