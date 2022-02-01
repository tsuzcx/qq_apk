package com.tencent.oskplayer.player;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ext.mediaplayer.MediaPlayerInterface.AudioEventListener;
import tv.danmaku.ijk.media.player.IMediaPlayer.AudioEventListener;

class OskExoMediaPlayer$9
  implements MediaPlayerInterface.AudioEventListener
{
  OskExoMediaPlayer$9(OskExoMediaPlayer paramOskExoMediaPlayer, IMediaPlayer.AudioEventListener paramAudioEventListener) {}
  
  public void onRenderAudioData(byte[] paramArrayOfByte, Format paramFormat)
  {
    this.val$listener.onRenderAudioData(paramArrayOfByte, paramFormat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.oskplayer.player.OskExoMediaPlayer.9
 * JD-Core Version:    0.7.0.1
 */