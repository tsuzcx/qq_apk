package com.tencent.mobileqq.msf.core;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.mobileqq.msf.core.a.a;
import com.tencent.qphone.base.util.QLog;

final class j
  extends Handler
{
  j(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
    } while ((i.d() > 0L) && (SystemClock.elapsedRealtime() - i.d() < a.q()));
    i.a(SystemClock.elapsedRealtime());
    QLog.d(i.b, 1, "clean and compress log");
    i.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.j
 * JD-Core Version:    0.7.0.1
 */