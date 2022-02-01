package com.tencent.mobileqq.msf.core;

import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

public class aq$c
  implements Runnable
{
  public final AtomicBoolean a = new AtomicBoolean(false);
  
  public aq$c(aq paramaq) {}
  
  public void run()
  {
    if (this.b.i.c > 0L)
    {
      this.b.i.e = (System.currentTimeMillis() - this.b.i.c);
      if (QLog.isColorLevel()) {
        QLog.d("WeaknetNew", 2, "CheckConnTimer conn cost=" + this.b.i.e + " oldReason=" + Integer.toHexString(aq.a(this.b)));
      }
      aq.a(this.b, 1);
      aq.b(this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.aq.c
 * JD-Core Version:    0.7.0.1
 */