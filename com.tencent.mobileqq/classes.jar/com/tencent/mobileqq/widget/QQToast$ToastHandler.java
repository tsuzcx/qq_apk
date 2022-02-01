package com.tencent.mobileqq.widget;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.BlockingQueue;

class QQToast$ToastHandler
  extends Handler
{
  private long a = 0L;
  
  private QQToast$ToastHandler(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  private void a(long paramLong)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("scheduleNextToast to ");
      localStringBuilder.append(paramLong);
      QLog.d("QQToast", 2, localStringBuilder.toString());
    }
    removeMessages(1);
    sendEmptyMessageDelayed(1, paramLong);
  }
  
  private void a(QQToast.ShowToastMessage paramShowToastMessage)
  {
    paramShowToastMessage = paramShowToastMessage.a();
    long l2 = 0L;
    long l1;
    int i;
    if (paramShowToastMessage != null)
    {
      paramShowToastMessage.a();
      if (QQToast.a(paramShowToastMessage) == 0) {
        l1 = 2000L;
      } else {
        l1 = 3500L;
      }
      this.a = (System.currentTimeMillis() + l1);
      i = 1;
    }
    else
    {
      i = 0;
      l1 = 0L;
    }
    if (!QQToast.a().isEmpty())
    {
      if (i != 0) {
        l2 = 100L + l1;
      }
      a(l2);
    }
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 1) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQToast", 2, "MSG_SHOW_TOAST received");
    }
    long l1 = System.currentTimeMillis();
    long l2 = this.a;
    if (l1 > l2 + 100L)
    {
      paramMessage = (QQToast.ShowToastMessage)QQToast.a().poll();
      if (paramMessage != null)
      {
        a(paramMessage);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQToast", 2, "MSG_SHOW_TOAST but no message to show");
      }
    }
    else
    {
      a(l2 - l1 + 100L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.QQToast.ToastHandler
 * JD-Core Version:    0.7.0.1
 */