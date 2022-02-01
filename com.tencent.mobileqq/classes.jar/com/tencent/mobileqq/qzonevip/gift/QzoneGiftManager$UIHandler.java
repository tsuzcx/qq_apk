package com.tencent.mobileqq.qzonevip.gift;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class QzoneGiftManager$UIHandler
  extends Handler
{
  public QzoneGiftManager$UIHandler(QzoneGiftManager paramQzoneGiftManager, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    try
    {
      switch (paramMessage.what)
      {
      case 1: 
        QzoneGiftManager.a(this.a);
        return;
      }
    }
    catch (Exception paramMessage)
    {
      paramMessage.printStackTrace();
      QLog.e("QzoneGiftManager", 1, "handleMessage exception = " + paramMessage.getMessage());
      return;
    }
    QzoneGiftManager.b(this.a);
    return;
    QzoneGiftManager.c(this.a);
    return;
    QzoneGiftManager.d(this.a);
    return;
    QzoneGiftManager.e(this.a);
    return;
    QzoneGiftManager.f(this.a);
    return;
    QzoneGiftManager.g(this.a);
    return;
    QzoneGiftManager.h(this.a);
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qzonevip.gift.QzoneGiftManager.UIHandler
 * JD-Core Version:    0.7.0.1
 */