package com.tencent.mobileqq.triton.audio;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnSeekCompleteListener;
import com.tencent.mobileqq.triton.sdk.audio.IAudioStateChangeListener;

class InnerAudioPlayer$13
  implements MediaPlayer.OnSeekCompleteListener
{
  InnerAudioPlayer$13(InnerAudioPlayer paramInnerAudioPlayer) {}
  
  public void onSeekComplete(MediaPlayer paramMediaPlayer)
  {
    if (this.this$0.getStateChangeListener() != null) {
      this.this$0.getStateChangeListener().onSeeked();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.triton.audio.InnerAudioPlayer.13
 * JD-Core Version:    0.7.0.1
 */