package com.tencent.mobileqq.mini.appbrand.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.qphone.base.util.QLog;

final class MiniLogManager$1
  extends Handler
{
  MiniLogManager$1(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 4) {
      return;
    }
    if ((MiniLogManager.access$000() <= 0L) || (SystemClock.elapsedRealtime() - MiniLogManager.access$000() >= 3600000L))
    {
      MiniLogManager.access$002(SystemClock.elapsedRealtime());
      if (QLog.isColorLevel()) {
        QLog.d(MiniLogManager.access$100(), 1, "clean and compress log");
      }
      MiniLogManager.compressAndDeleteOldLog();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.utils.MiniLogManager.1
 * JD-Core Version:    0.7.0.1
 */