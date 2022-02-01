package com.tencent.sharp.jni;

import com.tencent.qphone.base.util.QLog;
import java.util.TimerTask;

class TraeMediaPlayer$2
  extends TimerTask
{
  TraeMediaPlayer$2(TraeMediaPlayer paramTraeMediaPlayer, long paramLong) {}
  
  public void run()
  {
    if (TraeMediaPlayer.a(this.this$0) != null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("TraeMediaPlay", 1, "playRing, onCompletion, seq[" + this.a + "]");
      }
      if (TraeMediaPlayer.a(this.this$0) != null) {
        TraeMediaPlayer.a(this.this$0).a(this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.sharp.jni.TraeMediaPlayer.2
 * JD-Core Version:    0.7.0.1
 */