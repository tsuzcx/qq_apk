package com.tencent.mobileqq.triton.audio;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;

class InnerAudioPlayer$12
  implements MediaPlayer.OnBufferingUpdateListener
{
  InnerAudioPlayer$12(InnerAudioPlayer paramInnerAudioPlayer) {}
  
  public void onBufferingUpdate(MediaPlayer paramMediaPlayer, int paramInt)
  {
    int i = this.this$0.getDuration();
    InnerAudioPlayer.access$102(this.this$0, i * paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.triton.audio.InnerAudioPlayer.12
 * JD-Core Version:    0.7.0.1
 */