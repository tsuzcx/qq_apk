package com.tribe.async.reactive;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tribe.async.utils.AssertUtils;

class UIThreadOffFunction$InnerHandler
  extends Handler
{
  public UIThreadOffFunction$InnerHandler(UIThreadOffFunction paramUIThreadOffFunction, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (!UIThreadOffFunction.access$000(this.this$0)) {
      return;
    }
    AssertUtils.checkNotNull(paramMessage.obj);
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      paramMessage = paramMessage.obj;
      this.this$0.notifyResult(paramMessage);
      return;
    }
    paramMessage = (Error)paramMessage.obj;
    this.this$0.notifyError(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tribe.async.reactive.UIThreadOffFunction.InnerHandler
 * JD-Core Version:    0.7.0.1
 */