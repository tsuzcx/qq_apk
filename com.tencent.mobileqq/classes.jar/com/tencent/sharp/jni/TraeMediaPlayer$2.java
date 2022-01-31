package com.tencent.sharp.jni;

import bfly;
import bflz;
import com.tencent.qphone.base.util.QLog;
import java.util.TimerTask;

public class TraeMediaPlayer$2
  extends TimerTask
{
  public TraeMediaPlayer$2(bfly parambfly, long paramLong) {}
  
  public void run()
  {
    if (bfly.a(this.this$0) != null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("TraeMediaPlay", 1, "playRing, onCompletion, seq[" + this.a + "]");
      }
      if (bfly.a(this.this$0) != null) {
        bfly.a(this.this$0).a(this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.sharp.jni.TraeMediaPlayer.2
 * JD-Core Version:    0.7.0.1
 */