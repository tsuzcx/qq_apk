package com.tencent.mobileqq.triton.audio;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnMediaTimeDiscontinuityListener;
import android.media.MediaTimestamp;
import com.tencent.mobileqq.triton.sdk.audio.IAudioStateChangeListener;

class InnerAudioPlayer$1
  implements MediaPlayer.OnMediaTimeDiscontinuityListener
{
  InnerAudioPlayer$1(InnerAudioPlayer paramInnerAudioPlayer) {}
  
  public void onMediaTimeDiscontinuity(MediaPlayer paramMediaPlayer, MediaTimestamp paramMediaTimestamp)
  {
    if ((this.this$0.getStateChangeListener() != null) && (!this.this$0.isPaused())) {
      this.this$0.getStateChangeListener().onWaiting();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.triton.audio.InnerAudioPlayer.1
 * JD-Core Version:    0.7.0.1
 */