package com.tencent.mobileqq.utils;

import android.media.MediaPlayer.OnCompletionListener;
import bgkl;

public final class AudioUtil$7
  implements Runnable
{
  public AudioUtil$7(MediaPlayer.OnCompletionListener paramOnCompletionListener) {}
  
  public void run()
  {
    this.a.onCompletion(bgkl.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.AudioUtil.7
 * JD-Core Version:    0.7.0.1
 */