package com.tencent.oskplayer.player;

import com.google.android.exoplayer2.ext.mediaplayer.MediaPlayerInterface;
import com.google.android.exoplayer2.ext.mediaplayer.MediaPlayerInterface.OnVideoSizeChangedListener;
import tv.danmaku.ijk.media.player.IMediaPlayer.OnVideoSizeChangedListener;

class OskExoMediaPlayer$6
  implements MediaPlayerInterface.OnVideoSizeChangedListener
{
  OskExoMediaPlayer$6(OskExoMediaPlayer paramOskExoMediaPlayer, IMediaPlayer.OnVideoSizeChangedListener paramOnVideoSizeChangedListener) {}
  
  public void onVideoSizeChanged(MediaPlayerInterface paramMediaPlayerInterface, int paramInt1, int paramInt2)
  {
    this.val$listener.onVideoSizeChanged(this.this$0, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.oskplayer.player.OskExoMediaPlayer.6
 * JD-Core Version:    0.7.0.1
 */