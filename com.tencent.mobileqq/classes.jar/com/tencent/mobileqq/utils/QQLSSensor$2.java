package com.tencent.mobileqq.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class QQLSSensor$2
  extends Handler
{
  QQLSSensor$2(QQLSSensor paramQQLSSensor, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    synchronized (this.a)
    {
      if (QQLSSensor.a(this.a) != null) {
        QQLSSensor.a(this.a).a(QQLSSensor.a(this.a));
      }
      while (!QLog.isDevelopLevel())
      {
        super.handleMessage(paramMessage);
        return;
      }
      QLog.d("QQLSActivity", 4, "QQLSSensor handler callback=null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQLSSensor.2
 * JD-Core Version:    0.7.0.1
 */