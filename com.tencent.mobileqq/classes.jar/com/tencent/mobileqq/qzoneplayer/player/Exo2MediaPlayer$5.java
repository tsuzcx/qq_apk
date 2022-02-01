package com.tencent.mobileqq.qzoneplayer.player;

import com.google.android.exoplayer2.ext.mediaplayer.MediaPlayerInterface;
import com.google.android.exoplayer2.ext.mediaplayer.MediaPlayerInterface.OnSeekCompleteListener;
import tv.danmaku.ijk.media.player.IMediaPlayer.OnSeekCompleteListener;

class Exo2MediaPlayer$5
  implements MediaPlayerInterface.OnSeekCompleteListener
{
  Exo2MediaPlayer$5(Exo2MediaPlayer paramExo2MediaPlayer, IMediaPlayer.OnSeekCompleteListener paramOnSeekCompleteListener) {}
  
  public void onSeekComplete(MediaPlayerInterface paramMediaPlayerInterface)
  {
    this.val$onSeekCompleteListener.onSeekComplete(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qzoneplayer.player.Exo2MediaPlayer.5
 * JD-Core Version:    0.7.0.1
 */