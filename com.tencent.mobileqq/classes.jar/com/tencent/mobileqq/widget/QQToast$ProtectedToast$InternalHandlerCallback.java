package com.tencent.mobileqq.widget;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;

class QQToast$ProtectedToast$InternalHandlerCallback
  implements Handler.Callback
{
  private final Handler mHandler;
  
  public QQToast$ProtectedToast$InternalHandlerCallback(QQToast.ProtectedToast paramProtectedToast, Handler paramHandler)
  {
    this.mHandler = paramHandler;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    try
    {
      this.mHandler.handleMessage(paramMessage);
    }
    catch (Throwable paramMessage)
    {
      paramMessage.printStackTrace();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.QQToast.ProtectedToast.InternalHandlerCallback
 * JD-Core Version:    0.7.0.1
 */