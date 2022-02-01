package com.tencent.mobileqq.qzoneplayer.player;

import com.google.android.exoplayer2.ext.mediaplayer.MediaPlayerInterface;
import com.google.android.exoplayer2.ext.mediaplayer.MediaPlayerInterface.OnCompletionListener;
import tv.danmaku.ijk.media.player.IMediaPlayer.OnCompletionListener;

class Exo2MediaPlayer$3
  implements MediaPlayerInterface.OnCompletionListener
{
  Exo2MediaPlayer$3(Exo2MediaPlayer paramExo2MediaPlayer, IMediaPlayer.OnCompletionListener paramOnCompletionListener) {}
  
  public void onCompletion(MediaPlayerInterface paramMediaPlayerInterface)
  {
    this.val$onCompletionListener.onCompletion(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qzoneplayer.player.Exo2MediaPlayer.3
 * JD-Core Version:    0.7.0.1
 */