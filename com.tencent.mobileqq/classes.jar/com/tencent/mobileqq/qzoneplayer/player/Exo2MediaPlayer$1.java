package com.tencent.mobileqq.qzoneplayer.player;

import com.google.android.exoplayer2.ext.mediaplayer.MediaPlayerInterface;
import com.google.android.exoplayer2.ext.mediaplayer.MediaPlayerInterface.OnLoopStartListener;
import tv.danmaku.ijk.media.player.IMediaPlayer.OnLoopStartListener;

class Exo2MediaPlayer$1
  implements MediaPlayerInterface.OnLoopStartListener
{
  Exo2MediaPlayer$1(Exo2MediaPlayer paramExo2MediaPlayer, IMediaPlayer.OnLoopStartListener paramOnLoopStartListener) {}
  
  public void onLoopStart(MediaPlayerInterface paramMediaPlayerInterface)
  {
    this.val$listener.onLoopStart(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qzoneplayer.player.Exo2MediaPlayer.1
 * JD-Core Version:    0.7.0.1
 */