package com.tencent.mobileqq.msf.core.push;

import android.os.Handler;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class d
  extends Handler
{
  d(c paramc) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 10000) {
      return;
    }
    if (!"0".equals(c.a(this.a)))
    {
      QLog.d("PCActiveEchoManager", 1, "autoEcho");
      c.b(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.push.d
 * JD-Core Version:    0.7.0.1
 */