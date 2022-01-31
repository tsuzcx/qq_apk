package com.tencent.mobileqq.msf.core.net.b;

import android.os.Handler;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class l
  extends Handler
{
  l(k paramk) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    paramMessage = (String)paramMessage.obj;
    QLog.d("WifiDetector", 1, "WIFI detect delayed try!");
    k.a(this.a, paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.b.l
 * JD-Core Version:    0.7.0.1
 */