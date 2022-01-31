package com.tencent.oskplayer.player;

import com.google.android.exoplayer2.ext.mediaplayer.MediaPlayerInterface;
import com.google.android.exoplayer2.ext.mediaplayer.MediaPlayerInterface.OnLoopStartListener;
import tv.danmaku.ijk.media.player.IMediaPlayer.OnLoopStartListener;

class OskExoMediaPlayer$2
  implements MediaPlayerInterface.OnLoopStartListener
{
  OskExoMediaPlayer$2(OskExoMediaPlayer paramOskExoMediaPlayer, IMediaPlayer.OnLoopStartListener paramOnLoopStartListener) {}
  
  public void onLoopStart(MediaPlayerInterface paramMediaPlayerInterface)
  {
    this.val$listener.onLoopStart(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.oskplayer.player.OskExoMediaPlayer.2
 * JD-Core Version:    0.7.0.1
 */