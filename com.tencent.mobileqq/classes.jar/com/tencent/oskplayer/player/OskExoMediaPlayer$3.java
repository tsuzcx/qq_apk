package com.tencent.oskplayer.player;

import com.google.android.exoplayer2.ext.mediaplayer.MediaPlayerInterface;
import com.google.android.exoplayer2.ext.mediaplayer.MediaPlayerInterface.OnCompletionListener;
import tv.danmaku.ijk.media.player.IMediaPlayer.OnCompletionListener;

class OskExoMediaPlayer$3
  implements MediaPlayerInterface.OnCompletionListener
{
  OskExoMediaPlayer$3(OskExoMediaPlayer paramOskExoMediaPlayer, IMediaPlayer.OnCompletionListener paramOnCompletionListener) {}
  
  public void onCompletion(MediaPlayerInterface paramMediaPlayerInterface)
  {
    this.val$listener.onCompletion(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.oskplayer.player.OskExoMediaPlayer.3
 * JD-Core Version:    0.7.0.1
 */