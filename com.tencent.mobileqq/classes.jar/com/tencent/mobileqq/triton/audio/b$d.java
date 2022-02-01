package com.tencent.mobileqq.triton.audio;

import com.tencent.mobileqq.triton.sdk.audio.IAudioStateChangeListener;
import java.util.TimerTask;

class b$d
  extends TimerTask
{
  b$d(b paramb) {}
  
  public void run()
  {
    if ((this.a.getStateChangeListener() != null) && (!this.a.isPaused())) {
      this.a.getStateChangeListener().onTimeUpdate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.audio.b.d
 * JD-Core Version:    0.7.0.1
 */