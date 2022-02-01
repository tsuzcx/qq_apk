package com.tencent.mobileqq.widget;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.BlockingQueue;

class QQToast$ToastHandler
  extends Handler
{
  static final int MSG_SHOW_TOAST = 1;
  private static final int TOAST_INTERVAL = 100;
  private long mShowingToastEndTs = 0L;
  
  private QQToast$ToastHandler(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  private void scheduleNextToast(long paramLong)
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
  
  private void showToastImmediately(QQToast.ShowToastMessage paramShowToastMessage)
  {
    paramShowToastMessage = paramShowToastMessage.getToast();
    long l2 = 0L;
    long l1;
    int i;
    if (paramShowToastMessage != null)
    {
      paramShowToastMessage.show();
      if (QQToast.access$300(paramShowToastMessage) == 0) {
        l1 = 2000L;
      } else {
        l1 = 3500L;
      }
      this.mShowingToastEndTs = (System.currentTimeMillis() + l1);
      i = 1;
    }
    else
    {
      i = 0;
      l1 = 0L;
    }
    if (!QQToast.access$200().isEmpty())
    {
      if (i != 0) {
        l2 = 100L + l1;
      }
      scheduleNextToast(l2);
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
    long l2 = this.mShowingToastEndTs;
    if (l1 > l2 + 100L)
    {
      paramMessage = (QQToast.ShowToastMessage)QQToast.access$200().poll();
      if (paramMessage != null)
      {
        showToastImmediately(paramMessage);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQToast", 2, "MSG_SHOW_TOAST but no message to show");
      }
    }
    else
    {
      scheduleNextToast(l2 - l1 + 100L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.QQToast.ToastHandler
 * JD-Core Version:    0.7.0.1
 */