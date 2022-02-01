package com.tencent.mobileqq.msf.core.push;

import android.os.Handler;
import android.os.Message;

class h
  extends Handler
{
  h(g paramg) {}
  
  public void handleMessage(Message paramMessage)
  {
    try
    {
      if (paramMessage.what == 1)
      {
        boolean bool = ((Boolean)paramMessage.obj).booleanValue();
        this.a.a(bool);
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.push.h
 * JD-Core Version:    0.7.0.1
 */