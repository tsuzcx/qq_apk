package com.tencent.mobileqq.msf.core;

import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

public class ak$c
  implements Runnable
{
  public final AtomicBoolean a = new AtomicBoolean(false);
  
  public ak$c(ak paramak) {}
  
  public void run()
  {
    if (this.b.i.c > 0L)
    {
      this.b.i.e = (System.currentTimeMillis() - this.b.i.c);
      if (QLog.isColorLevel()) {
        QLog.d("WeaknetNew", 2, "CheckConnTimer conn cost=" + this.b.i.e + " oldReason=" + Integer.toHexString(ak.a(this.b)));
      }
      ak.a(this.b, 1);
      ak.b(this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.ak.c
 * JD-Core Version:    0.7.0.1
 */