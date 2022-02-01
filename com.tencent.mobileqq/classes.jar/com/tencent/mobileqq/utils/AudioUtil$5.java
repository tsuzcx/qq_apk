package com.tencent.mobileqq.utils;

import android.media.MediaPlayer.OnCompletionListener;

final class AudioUtil$5
  implements Runnable
{
  AudioUtil$5(MediaPlayer.OnCompletionListener paramOnCompletionListener) {}
  
  public void run()
  {
    this.a.onCompletion(AudioUtil.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.AudioUtil.5
 * JD-Core Version:    0.7.0.1
 */