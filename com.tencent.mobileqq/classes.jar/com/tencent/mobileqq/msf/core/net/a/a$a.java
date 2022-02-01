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
    paramMessage = a.a;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("recv msg event ");
    ((StringBuilder)localObject).append(i);
    QLog.d(paramMessage, 1, ((StringBuilder)localObject).toString());
    switch (i)
    {
    default: 
      return false;
    }
    try
    {
      if ((a.o() != 2) && (a.o() != 1)) {
        break label538;
      }
      QLog.d(a.a, 1, "start to report adaptor event");
      try
      {
        a.h();
        return false;
      }
      catch (Exception paramMessage)
      {
        QLog.d(a.a, 1, "failed to report", paramMessage);
        return false;
      }
      if ((a.o() != 2) && (a.o() != 1)) {
        break label538;
      }
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
      if (a.o() != 2) {
        break label538;
      }
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
        paramMessage = a.a;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("test heartbeat response limit ");
        ((StringBuilder)localObject).append(a.u());
        QLog.d(paramMessage, 1, ((StringBuilder)localObject).toString());
        a.a(0);
        a.t().set(false);
        return false;
      }
      QLog.d(a.a, 1, "test heartbeat response succ");
      return false;
    }
    catch (Exception paramMessage)
    {
      localObject = a.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("process action ");
      localStringBuilder.append(i);
      localStringBuilder.append(" failed ");
      localStringBuilder.append(paramMessage.toString());
      QLog.d((String)localObject, 1, localStringBuilder.toString());
    }
    if (a.o() == 2)
    {
      paramMessage = a.a;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("test heartbeat count:");
      ((StringBuilder)localObject).append(a.p());
      ((StringBuilder)localObject).append(", fore:");
      ((StringBuilder)localObject).append(a.q());
      ((StringBuilder)localObject).append(", mobile:");
      ((StringBuilder)localObject).append(NetConnInfoCenter.isMobileConn());
      QLog.d(paramMessage, 1, ((StringBuilder)localObject).toString());
      if (((a.p() == 0) && (!a.q())) || ((a.r()) && (NetConnInfoCenter.isMobileConn())))
      {
        QLog.d(a.a, 1, "testing heartbeat response");
        if (b.a())
        {
          a.s().sendEmptyMessageDelayed(19, 35000L);
          return false;
        }
        a.a(0);
        a.t().set(false);
        QLog.d(a.a, 1, "encap heartbeat failed");
        return false;
      }
      a.a(0);
      a.t().set(false);
      if (!a.q())
      {
        a.s().sendEmptyMessageDelayed(18, com.tencent.mobileqq.msf.core.a.a.aM());
        return false;
      }
    }
    label538:
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.a.a.a
 * JD-Core Version:    0.7.0.1
 */