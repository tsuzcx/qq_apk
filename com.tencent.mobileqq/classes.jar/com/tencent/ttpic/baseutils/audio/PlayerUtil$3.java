package com.tencent.ttpic.baseutils.audio;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnSeekCompleteListener;

final class PlayerUtil$3
  implements MediaPlayer.OnSeekCompleteListener
{
  public void onSeekComplete(MediaPlayer paramMediaPlayer)
  {
    ((PlayerUtil.Player)paramMediaPlayer).start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.baseutils.audio.PlayerUtil.3
 * JD-Core Version:    0.7.0.1
 */