package com.tencent.mobileqq.msf.core;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.mobileqq.msf.core.net.b;
import com.tencent.mobileqq.msf.core.net.l;
import com.tencent.mobileqq.msf.core.quicksend.f;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.LinkedBlockingQueue;

class g$b
  extends Handler
{
  public g$b(g paramg, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 2: 
      do
      {
        do
        {
          return;
          if (!g.a(this.a)) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("LightTcpSender", 2, "Network is exit " + this.a.b);
        return;
        if (this.a.a()) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("LightTcpSender", 2, "Network is closed " + this.a.b);
      return;
      while ((!g.a(this.a)) && (this.a.e.size() > 0))
      {
        ToServiceMsg localToServiceMsg = (ToServiceMsg)this.a.e.poll();
        if (localToServiceMsg != null)
        {
          f localf = new f();
          localf.b = SystemClock.elapsedRealtime();
          localf.j = localf.b;
          localf.g = localf.b;
          String str2 = g.a(this.a, localToServiceMsg);
          String str1 = "";
          paramMessage = str1;
          if (localToServiceMsg.getAttributes().containsKey("connIDC"))
          {
            paramMessage = str1;
            if (localToServiceMsg.getAttributes().get("connIDC") != null)
            {
              str1 = (String)localToServiceMsg.getAttributes().get("connIDC");
              paramMessage = str1;
              if (QLog.isColorLevel())
              {
                QLog.d("LightTcpSender", 2, "sleectConnect ssoSeq:" + localToServiceMsg.getRequestSsoSeq() + " connIDC: " + str1);
                paramMessage = str1;
              }
            }
          }
          if ((g.b(this.a)) || (g.a(this.a, localToServiceMsg, localf, str2, paramMessage)))
          {
            g.a(this.a, localf, localToServiceMsg);
            if (!g.b(this.a)) {
              this.a.a.c();
            }
          }
        }
      }
    }
    try
    {
      this.a.e.clear();
      this.a.a.c();
      this.a.a.d();
      paramMessage = g.c(this.a);
    }
    catch (Exception paramMessage)
    {
      for (;;)
      {
        QLog.i("LightTcpSender", 1, paramMessage.getMessage(), paramMessage);
        paramMessage.printStackTrace();
        paramMessage = g.c(this.a);
      }
    }
    finally
    {
      l.c(g.c(this.a));
    }
    l.c(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.g.b
 * JD-Core Version:    0.7.0.1
 */