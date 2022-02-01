package com.tencent.sharp.jni;

import bkxc;
import bkxd;
import com.tencent.qphone.base.util.QLog;
import java.util.TimerTask;

public class TraeMediaPlayer$2
  extends TimerTask
{
  public TraeMediaPlayer$2(bkxc parambkxc, long paramLong) {}
  
  public void run()
  {
    if (bkxc.a(this.this$0) != null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("TraeMediaPlay", 1, "playRing, onCompletion, seq[" + this.a + "]");
      }
      if (bkxc.a(this.this$0) != null) {
        bkxc.a(this.this$0).a(this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.sharp.jni.TraeMediaPlayer.2
 * JD-Core Version:    0.7.0.1
 */