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
    if (i != 1) {
      if (i != 2) {
        if (i != 3) {
          if (i != 5) {
            if (i != 7) {
              if (i != 153) {
                if (i != 154) {
                  return false;
                }
              }
            }
          }
        }
      }
    }
    try
    {
      if (c.d())
      {
        paramMessage = new StringBuilder();
        paramMessage.append("reset mode in cycle, resume mode ");
        paramMessage.append(c.e());
        QLog.d("HwSocketAdaptor", 1, paramMessage.toString());
        c.b(false);
        c.c(c.e() + 1);
        a.k();
      }
      if (c.e() > com.tencent.mobileqq.msf.core.a.a.aO()) {
        break label367;
      }
      c.c.sendEmptyMessageDelayed(154, com.tencent.mobileqq.msf.core.a.a.aP());
      return false;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder;
      int j;
      break label317;
    }
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
    c.a(true);
    paramMessage = (String)paramMessage.obj;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("bastet Heartbeat:  ");
    localStringBuilder.append(paramMessage);
    QLog.d("HwSocketAdaptor", 1, localStringBuilder.toString());
    return false;
    QLog.d("HwSocketAdaptor", 1, "basetet heartbeat is not available");
    a.a("exception");
    c.c.removeMessages(153);
    return false;
    j = Integer.valueOf(paramMessage.arg1).intValue();
    paramMessage = new StringBuilder();
    paramMessage.append("bastet detect net quality event, level:");
    paramMessage.append(j);
    QLog.d("HwSocketAdaptor", 1, paramMessage.toString());
    return false;
    QLog.d("HwSocketAdaptor", 1, "bastet detect connection closed");
    return false;
    QLog.d("HwSocketAdaptor", 1, "bastet detect connection established");
    return false;
    label317:
    paramMessage = new StringBuilder();
    paramMessage.append("bastet handler process event ");
    paramMessage.append(i);
    paramMessage.append("failed ");
    paramMessage.append(localStringBuilder.toString());
    QLog.d("HwSocketAdaptor", 1, paramMessage.toString(), localStringBuilder);
    label367:
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.a.c.a
 * JD-Core Version:    0.7.0.1
 */