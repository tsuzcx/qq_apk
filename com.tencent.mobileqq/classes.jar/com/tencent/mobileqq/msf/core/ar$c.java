package com.tencent.mobileqq.msf.core;

import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

public class ar$c
  implements Runnable
{
  public final AtomicBoolean a = new AtomicBoolean(false);
  
  public ar$c(ar paramar) {}
  
  public void run()
  {
    if (this.b.i.c > 0L)
    {
      this.b.i.e = (System.currentTimeMillis() - this.b.i.c);
      if (QLog.isColorLevel()) {
        QLog.d("WeaknetNew", 2, "CheckConnTimer conn cost=" + this.b.i.e + " oldReason=" + Integer.toHexString(ar.a(this.b)));
      }
      ar.a(this.b, 1);
      ar.b(this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.ar.c
 * JD-Core Version:    0.7.0.1
 */