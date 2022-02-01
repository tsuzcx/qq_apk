package com.tencent.mobileqq.triton.audio;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;

class b$e
  implements MediaPlayer.OnBufferingUpdateListener
{
  b$e(b paramb) {}
  
  public void onBufferingUpdate(MediaPlayer paramMediaPlayer, int paramInt)
  {
    int i = this.a.getDuration();
    b.a(this.a, i * paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.audio.b.e
 * JD-Core Version:    0.7.0.1
 */