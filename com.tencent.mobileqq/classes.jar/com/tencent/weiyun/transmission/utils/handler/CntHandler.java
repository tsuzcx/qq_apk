package com.tencent.weiyun.transmission.utils.handler;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;

public class CntHandler
  extends Handler
{
  private DispatchCallback mCallback;
  
  public CntHandler(Looper paramLooper, Handler.Callback paramCallback, DispatchCallback paramDispatchCallback)
  {
    super(paramLooper, paramCallback);
    this.mCallback = paramDispatchCallback;
  }
  
  public CntHandler(Looper paramLooper, DispatchCallback paramDispatchCallback)
  {
    super(paramLooper);
    this.mCallback = paramDispatchCallback;
  }
  
  public void dispatchMessage(Message paramMessage)
  {
    super.dispatchMessage(paramMessage);
    DispatchCallback localDispatchCallback = this.mCallback;
    if (localDispatchCallback != null) {
      localDispatchCallback.dispatchMsgFinished(paramMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.weiyun.transmission.utils.handler.CntHandler
 * JD-Core Version:    0.7.0.1
 */