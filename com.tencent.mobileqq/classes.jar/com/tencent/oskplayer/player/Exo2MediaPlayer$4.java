package com.tencent.oskplayer.player;

import com.google.android.exoplayer2.ext.mediaplayer.MediaPlayerInterface;
import com.google.android.exoplayer2.ext.mediaplayer.MediaPlayerInterface.OnBufferingUpdateListener;
import tv.danmaku.ijk.media.player.IMediaPlayer.OnBufferingUpdateListener;

class Exo2MediaPlayer$4
  implements MediaPlayerInterface.OnBufferingUpdateListener
{
  Exo2MediaPlayer$4(Exo2MediaPlayer paramExo2MediaPlayer, IMediaPlayer.OnBufferingUpdateListener paramOnBufferingUpdateListener) {}
  
  public void onBufferingUpdate(MediaPlayerInterface paramMediaPlayerInterface, int paramInt)
  {
    this.val$onBufferingUpdateListener.onBufferingUpdate(this.this$0, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.oskplayer.player.Exo2MediaPlayer.4
 * JD-Core Version:    0.7.0.1
 */