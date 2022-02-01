package com.tencent.mtt.hippy.modules.nativemodules.audio;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;

class a$5
  implements MediaPlayer.OnPreparedListener
{
  a$5(a parama, MediaPlayer.OnPreparedListener paramOnPreparedListener) {}
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    a.c(this.b).onPrepared(paramMediaPlayer);
    this.a.onPrepared(paramMediaPlayer);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.hippy.modules.nativemodules.audio.a.5
 * JD-Core Version:    0.7.0.1
 */