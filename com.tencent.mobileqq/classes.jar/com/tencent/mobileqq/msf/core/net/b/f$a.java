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
    try
    {
      DataInputStream localDataInputStream = new DataInputStream(f.e(this.a));
      int i = 0;
      while ((f.c(this.a).get()) || (!f.a(this.a).get())) {
        if (i <= 0)
        {
          i = localDataInputStream.readInt();
          int j = i - 4;
          StringBuilder localStringBuilder;
          if (j <= 33)
          {
            this.a.a = true;
            this.a.d = (SystemClock.elapsedRealtime() - f.f(this.a));
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(f.g(this.a));
            localStringBuilder.append(" recv sso ping");
            QLog.d("ReqAllFailSocket", 1, localStringBuilder.toString());
            i = j;
          }
          else
          {
            i = j;
            if (j == 62)
            {
              this.a.b = true;
              this.a.e = (SystemClock.elapsedRealtime() - f.f(this.a));
              localStringBuilder = new StringBuilder();
              localStringBuilder.append(f.g(this.a));
              localStringBuilder.append(" recv heartbeat ping");
              QLog.d("ReqAllFailSocket", 1, localStringBuilder.toString());
              i = j;
            }
          }
        }
        else
        {
          localDataInputStream.readByte();
          i -= 1;
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      f.a(this.a, "readError");
      f.d(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.b.f.a
 * JD-Core Version:    0.7.0.1
 */