package com.tencent.mobileqq.utils;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;

final class AudioUtil$3
  implements MediaPlayer.OnCompletionListener
{
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    paramMediaPlayer.release();
    AudioUtil.a = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.AudioUtil.3
 * JD-Core Version:    0.7.0.1
 */