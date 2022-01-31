package com.tencent.mobileqq.msf.core.net.a;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

class a$a
  extends HandlerThread
  implements Handler.Callback
{
  public a$a(a parama, String paramString)
  {
    super(paramString);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    QLog.d(a.a, 1, "recv msg event " + i);
    switch (i)
    {
    }
    label240:
    do
    {
      do
      {
        do
        {
          do
          {
            for (;;)
            {
              return false;
              try
              {
                if (a.o() == 2)
                {
                  QLog.d(a.a, 1, "test heartbeat count:" + a.p() + ", fore:" + a.q() + ", mobile:" + NetConnInfoCenter.isMobileConn());
                  if (((a.p() != 0) || (a.q())) && ((!a.r()) || (!NetConnInfoCenter.isMobileConn()))) {
                    break label240;
                  }
                  QLog.d(a.a, 1, "testing heartbeat response");
                  if (b.a())
                  {
                    a.s().sendEmptyMessageDelayed(19, 35000L);
                    return false;
                  }
                }
              }
              catch (Exception paramMessage)
              {
                QLog.d(a.a, 1, "process action " + i + " failed " + paramMessage.toString());
                return false;
              }
            }
            a.a(0);
            a.t().set(false);
            QLog.d(a.a, 1, "encap heartbeat failed");
            return false;
            a.a(0);
            a.t().set(false);
          } while (a.q());
          a.s().sendEmptyMessageDelayed(18, com.tencent.mobileqq.msf.core.a.a.aM());
          return false;
        } while (a.o() != 2);
        if (b.b())
        {
          QLog.d(a.a, 1, "test heartbeat response failed");
          a.b(a.u() + 1);
          if (a.u() <= com.tencent.mobileqq.msf.core.a.a.aR())
          {
            QLog.d(a.a, 1, "test heartbeat retry");
            a.s().sendEmptyMessageDelayed(18, 30000L);
            return false;
          }
          QLog.d(a.a, 1, "test heartbeat response limit " + a.u());
          a.a(0);
          a.t().set(false);
          return false;
        }
        QLog.d(a.a, 1, "test heartbeat response succ");
        return false;
      } while ((a.o() != 2) && (a.o() != 1));
      QLog.d(a.a, 1, "start to report adaptor event");
      try
      {
        a.h();
        a.i();
        a.s().sendEmptyMessageDelayed(20, 72000000L);
        a.a(true);
        return false;
      }
      catch (Exception paramMessage)
      {
        QLog.d(a.a, 1, "failed to report", paramMessage);
        return false;
      }
    } while ((a.o() != 2) && (a.o() != 1));
    QLog.d(a.a, 1, "start to report adaptor event");
    try
    {
      a.h();
      return false;
    }
    catch (Exception paramMessage)
    {
      QLog.d(a.a, 1, "failed to report", paramMessage);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.a.a.a
 * JD-Core Version:    0.7.0.1
 */