package com.tencent.trackrecordlib.e;

import android.os.PowerManager;
import com.tencent.trackrecordlib.core.c;

class b$1
  implements Runnable
{
  b$1(b paramb) {}
  
  public void run()
  {
    while (!b.a(this.a)) {
      try
      {
        if ((!b.b(this.a).isScreenOn()) && (b.c(this.a)))
        {
          c.a().c();
          b.a(this.a, false);
        }
        if ((b.b(this.a).isScreenOn()) && (!b.c(this.a)))
        {
          c.a().c();
          b.a(this.a, true);
        }
        Thread.sleep(1000L);
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.trackrecordlib.e.b.1
 * JD-Core Version:    0.7.0.1
 */