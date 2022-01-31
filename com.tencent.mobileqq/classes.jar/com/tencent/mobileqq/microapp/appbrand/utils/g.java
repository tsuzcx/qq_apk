package com.tencent.mobileqq.microapp.appbrand.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.qphone.base.util.QLog;

final class g
  extends Handler
{
  g(Looper paramLooper)
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
    } while ((MiniLogManager.access$000() > 0L) && (SystemClock.elapsedRealtime() - MiniLogManager.access$000() < 3600000L));
    MiniLogManager.access$002(SystemClock.elapsedRealtime());
    if (QLog.isColorLevel()) {
      QLog.d(MiniLogManager.access$100(), 1, "clean and compress log");
    }
    MiniLogManager.compressAndDeleteOldLog();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.appbrand.utils.g
 * JD-Core Version:    0.7.0.1
 */