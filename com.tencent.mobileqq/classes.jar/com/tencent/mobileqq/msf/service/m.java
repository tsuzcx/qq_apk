package com.tencent.mobileqq.msf.service;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class m
  extends Handler
{
  m(MsfService paramMsfService, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 10500) {
      l.a(this.a.mUIHandler);
    }
    super.handleMessage(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msf.service.m
 * JD-Core Version:    0.7.0.1
 */