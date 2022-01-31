package com.tencent.mobileqq.triton.audio;

import com.tencent.mobileqq.triton.sdk.audio.IAudioStateChangeListener;
import java.util.TimerTask;

class InnerAudioPlayer$8
  extends TimerTask
{
  InnerAudioPlayer$8(InnerAudioPlayer paramInnerAudioPlayer) {}
  
  public void run()
  {
    if ((this.this$0.getStateChangeListener() != null) && (!this.this$0.isPaused())) {
      this.this$0.getStateChangeListener().onTimeUpdate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.triton.audio.InnerAudioPlayer.8
 * JD-Core Version:    0.7.0.1
 */