package com.tencent.mobileqq.msf.core;

import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

public class ap$c
  implements Runnable
{
  public final AtomicBoolean a = new AtomicBoolean(false);
  
  public ap$c(ap paramap) {}
  
  public void run()
  {
    if (this.b.i.c > 0L)
    {
      this.b.i.e = (System.currentTimeMillis() - this.b.i.c);
      if (QLog.isColorLevel()) {
        QLog.d("WeaknetNew", 2, "CheckConnTimer conn cost=" + this.b.i.e + " oldReason=" + Integer.toHexString(ap.a(this.b)));
      }
      ap.a(this.b, 1);
      ap.b(this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.ap.c
 * JD-Core Version:    0.7.0.1
 */