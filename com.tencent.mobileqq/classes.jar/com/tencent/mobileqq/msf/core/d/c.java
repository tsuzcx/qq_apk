package com.tencent.mobileqq.msf.core.d;

import android.os.Handler;
import android.os.Message;

class c
  extends Handler
{
  c(a parama) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 10001) {
      return;
    }
    a.d(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.d.c
 * JD-Core Version:    0.7.0.1
 */