package com.tencent.ttpic.baseutils.audio;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnSeekCompleteListener;

final class PlayerUtil$4
  implements MediaPlayer.OnSeekCompleteListener
{
  public void onSeekComplete(MediaPlayer paramMediaPlayer)
  {
    ((PlayerUtil.Player)paramMediaPlayer).start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.baseutils.audio.PlayerUtil.4
 * JD-Core Version:    0.7.0.1
 */