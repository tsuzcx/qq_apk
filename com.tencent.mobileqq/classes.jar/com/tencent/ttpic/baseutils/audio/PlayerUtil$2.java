package com.tencent.ttpic.baseutils.audio;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;

final class PlayerUtil$2
  implements MediaPlayer.OnErrorListener
{
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    PlayerUtil.destroyPlayer((PlayerUtil.Player)paramMediaPlayer);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.baseutils.audio.PlayerUtil.2
 * JD-Core Version:    0.7.0.1
 */