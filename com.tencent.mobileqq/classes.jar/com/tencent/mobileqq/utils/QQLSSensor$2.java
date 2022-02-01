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
        QQLSSensor.a(this.a).a(QQLSSensor.d(this.a));
      } else if (QLog.isDevelopLevel()) {
        QLog.d("QQLSActivity", 4, "QQLSSensor handler callback=null");
      }
      super.handleMessage(paramMessage);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQLSSensor.2
 * JD-Core Version:    0.7.0.1
 */