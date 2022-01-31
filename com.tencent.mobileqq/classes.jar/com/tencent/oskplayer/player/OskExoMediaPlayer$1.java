package com.tencent.oskplayer.player;

import com.google.android.exoplayer2.ext.mediaplayer.MediaPlayerInterface;
import com.google.android.exoplayer2.ext.mediaplayer.MediaPlayerInterface.OnPreparedListener;
import tv.danmaku.ijk.media.player.IMediaPlayer.OnPreparedListener;

class OskExoMediaPlayer$1
  implements MediaPlayerInterface.OnPreparedListener
{
  OskExoMediaPlayer$1(OskExoMediaPlayer paramOskExoMediaPlayer, IMediaPlayer.OnPreparedListener paramOnPreparedListener) {}
  
  public void onPrepared(MediaPlayerInterface paramMediaPlayerInterface)
  {
    this.val$listener.onPrepared(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.oskplayer.player.OskExoMediaPlayer.1
 * JD-Core Version:    0.7.0.1
 */