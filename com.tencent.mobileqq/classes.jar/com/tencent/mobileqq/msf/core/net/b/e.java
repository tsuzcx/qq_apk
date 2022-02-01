package com.tencent.mobileqq.msf.core.net.b;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class e
  extends Handler
{
  e(d paramd, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 10000) {
      return;
    }
    this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.b.e
 * JD-Core Version:    0.7.0.1
 */