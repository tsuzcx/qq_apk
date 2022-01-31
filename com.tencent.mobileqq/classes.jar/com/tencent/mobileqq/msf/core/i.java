package com.tencent.mobileqq.msf.core;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.mobileqq.msf.core.a.a;
import com.tencent.qphone.base.util.QLog;

final class i
  extends Handler
{
  i(Looper paramLooper)
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
    } while ((h.d() > 0L) && (SystemClock.elapsedRealtime() - h.d() < a.q()));
    h.a(SystemClock.elapsedRealtime());
    QLog.d(h.b, 1, "clean and compress log");
    h.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.i
 * JD-Core Version:    0.7.0.1
 */