package com.tencent.qphone.base.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

class QLog$WriteHandler
  extends Handler
{
  public QLog$WriteHandler(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message arg1)
  {
    int i = ???.what;
    long l = 15000L;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i == 3) {
          break label104;
        }
        return;
      }
      if (QLog.access$500())
      {
        QLog.sWriteHandler.removeMessages(1);
        QLog.sWriteHandler.sendEmptyMessageDelayed(1, 1000L);
        return;
      }
      QLog.sWriteHandler.removeMessages(2);
      QLog.sWriteHandler.sendEmptyMessageDelayed(2, 1000L);
    }
    try
    {
      Log.d("QLog", "QLog init");
      QLog.initLogFile(System.currentTimeMillis());
      QLog.access$002(0);
      QLog.sWriteHandler.removeMessages(2);
      QLog.sWriteHandler.sendEmptyMessage(2);
      label104:
      if (QLog.access$000() > 0)
      {
        Log.d("QLog", "QLog clear logs");
        synchronized (QLog.access$200())
        {
          QLog.access$302(QLog.access$402(null));
          QLog.sWriteHandler.removeMessages(3);
          QLog.sWriteHandler.sendEmptyMessageDelayed(3, 15000L);
          return;
        }
      }
      int j;
      return;
    }
    catch (Throwable ???)
    {
      ???.printStackTrace();
      i = QLog.access$000();
      ??? = new StringBuilder();
      ???.append("QLog init");
      ???.append(i);
      ???.append(", ");
      ???.append(QLog.access$100()[i]);
      Log.d("QLog", ???.toString());
      QLog.sWriteHandler.removeMessages(1);
      QLog.sWriteHandler.sendEmptyMessageDelayed(1, QLog.access$100()[i] * 60000);
      QLog.sWriteHandler.removeMessages(3);
      ??? = QLog.sWriteHandler;
      if (QLog.access$000() == 0) {
        l = 62000L;
      }
      ???.sendEmptyMessageDelayed(3, l);
      j = i + 1;
      i = j;
      if (j >= QLog.access$100().length) {
        i = 1;
      }
      QLog.access$002(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qphone.base.util.QLog.WriteHandler
 * JD-Core Version:    0.7.0.1
 */