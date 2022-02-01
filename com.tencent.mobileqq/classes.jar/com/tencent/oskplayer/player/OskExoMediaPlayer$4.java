package com.tencent.oskplayer.player;

import com.google.android.exoplayer2.ext.mediaplayer.MediaPlayerInterface;
import com.google.android.exoplayer2.ext.mediaplayer.MediaPlayerInterface.OnBufferingUpdateListener;
import tv.danmaku.ijk.media.player.IMediaPlayer.OnBufferingUpdateListener;

class OskExoMediaPlayer$4
  implements MediaPlayerInterface.OnBufferingUpdateListener
{
  OskExoMediaPlayer$4(OskExoMediaPlayer paramOskExoMediaPlayer, IMediaPlayer.OnBufferingUpdateListener paramOnBufferingUpdateListener) {}
  
  public void onBufferingUpdate(MediaPlayerInterface paramMediaPlayerInterface, int paramInt)
  {
    this.val$listener.onBufferingUpdate(this.this$0, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.oskplayer.player.OskExoMediaPlayer.4
 * JD-Core Version:    0.7.0.1
 */