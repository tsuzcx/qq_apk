package com.tencent.mobileqq.msf.core.net.b;

import android.os.SystemClock;
import com.tencent.qphone.base.util.QLog;
import java.io.DataInputStream;
import java.util.concurrent.atomic.AtomicBoolean;

class f$a
  extends Thread
{
  private f$a(f paramf) {}
  
  public void run()
  {
    for (;;)
    {
      int j;
      try
      {
        DataInputStream localDataInputStream = new DataInputStream(f.e(this.a));
        i = 0;
        if ((f.c(this.a).get()) || (!f.a(this.a).get()))
        {
          if (i > 0) {
            break label215;
          }
          j = localDataInputStream.readInt() - 4;
          if (j <= 33)
          {
            this.a.a = true;
            this.a.d = (SystemClock.elapsedRealtime() - f.f(this.a));
            QLog.d("ReqAllFailSocket", 1, f.g(this.a) + " recv sso ping");
            i = j;
          }
        }
        else
        {
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        f.a(this.a, "readError");
        f.d(this.a);
      }
      int i = j;
      if (j == 62)
      {
        this.a.b = true;
        this.a.e = (SystemClock.elapsedRealtime() - f.f(this.a));
        QLog.d("ReqAllFailSocket", 1, f.g(this.a) + " recv heartbeat ping");
        i = j;
        continue;
        label215:
        localThrowable.readByte();
        i -= 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.b.f.a
 * JD-Core Version:    0.7.0.1
 */