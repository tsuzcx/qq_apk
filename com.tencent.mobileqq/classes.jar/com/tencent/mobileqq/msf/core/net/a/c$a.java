package com.tencent.mobileqq.msf.core.net.a;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class c$a
  extends HandlerThread
  implements Handler.Callback
{
  public c$a(String paramString)
  {
    super(paramString);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    switch (i)
    {
    }
    do
    {
      return false;
      try
      {
        QLog.d("HwSocketAdaptor", 1, "bastet detect connection closed");
        return false;
      }
      catch (Exception paramMessage)
      {
        QLog.d("HwSocketAdaptor", 1, "bastet handler process event " + i + "failed " + paramMessage.toString(), paramMessage);
        return false;
      }
      QLog.d("HwSocketAdaptor", 1, "bastet detect connection established");
      return false;
      int j = Integer.valueOf(paramMessage.arg1).intValue();
      QLog.d("HwSocketAdaptor", 1, "bastet detect net quality event, level:" + j);
      return false;
      c.a(true);
      paramMessage = (String)paramMessage.obj;
      QLog.d("HwSocketAdaptor", 1, "bastet Heartbeat:  " + paramMessage);
      return false;
      QLog.d("HwSocketAdaptor", 1, "basetet heartbeat is not available");
      a.a("exception");
      c.c.removeMessages(153);
      return false;
      if (!c.b())
      {
        QLog.d("HwSocketAdaptor", 1, "Heartbeat Log has not been reported, pause heartbeat");
        a.a("exception");
        c.b(c.c() + 1);
        return false;
      }
      c.a(false);
      c.c.sendEmptyMessageDelayed(153, 2700000L);
      return false;
      if (c.d())
      {
        QLog.d("HwSocketAdaptor", 1, "reset mode in cycle, resume mode " + c.e());
        c.b(false);
        c.c(c.e() + 1);
        a.k();
      }
    } while (c.e() > com.tencent.mobileqq.msf.core.a.a.aO());
    c.c.sendEmptyMessageDelayed(154, com.tencent.mobileqq.msf.core.a.a.aP());
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.a.c.a
 * JD-Core Version:    0.7.0.1
 */