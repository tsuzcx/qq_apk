package com.tencent.qphone.base.util.log.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.mobileqq.msf.core.a.a;
import com.tencent.qphone.base.util.QLog;

final class c
  extends Handler
{
  c(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 10000) {
      return;
    }
    if ((b.d() <= 0L) || (SystemClock.elapsedRealtime() - b.d() >= a.q()))
    {
      b.a(SystemClock.elapsedRealtime());
      QLog.d(b.f, 1, "clean and compress log");
      b.e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qphone.base.util.log.a.c
 * JD-Core Version:    0.7.0.1
 */