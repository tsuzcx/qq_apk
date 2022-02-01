package com.tencent.mobileqq.utils;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;

final class AudioUtil$8
  implements MediaPlayer.OnCompletionListener
{
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    if (AudioUtil.b() == 0)
    {
      paramMediaPlayer = this.a;
      if (paramMediaPlayer != null)
      {
        paramMediaPlayer.onCompletion(AudioUtil.a);
        return;
      }
      AudioUtil.a();
      return;
    }
    AudioUtil.c();
    AudioUtil.a.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.AudioUtil.8
 * JD-Core Version:    0.7.0.1
 */