package com.tencent.mobileqq.soso.location;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

final class SosoInterface$1
  implements Handler.Callback
{
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      if (QLog.isColorLevel()) {
        QLog.i("SOSO.LBS", 2, "msg_stop_location.");
      }
      SosoInterface.access$000();
      SosoInterface.access$100();
      continue;
      if (SosoInterface.access$200().hasMessages(1001))
      {
        SosoInterface.access$200().removeMessages(1001);
        SosoInterface.access$200().sendEmptyMessageDelayed(1001, 3000L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.soso.location.SosoInterface.1
 * JD-Core Version:    0.7.0.1
 */