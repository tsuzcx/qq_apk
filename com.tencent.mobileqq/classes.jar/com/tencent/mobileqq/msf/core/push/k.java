package com.tencent.mobileqq.msf.core.push;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;

class k
  implements MediaPlayer.OnCompletionListener
{
  k(g paramg) {}
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    paramMediaPlayer.release();
    this.a.aa = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.push.k
 * JD-Core Version:    0.7.0.1
 */