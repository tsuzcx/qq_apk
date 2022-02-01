package com.tencent.mobileqq.msf.core.push;

import android.os.Handler;
import android.os.Message;

class m
  extends Handler
{
  m(g paramg) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 20140416) {
      return;
    }
    this.a.p();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.push.m
 * JD-Core Version:    0.7.0.1
 */