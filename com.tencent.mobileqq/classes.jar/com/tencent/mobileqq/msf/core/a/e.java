package com.tencent.mobileqq.msf.core.a;

import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.af;
import com.tencent.mobileqq.msf.core.h;
import com.tencent.mobileqq.msf.core.h.a;
import com.tencent.msf.service.protocol.serverconfig.a;
import com.tencent.msf.service.protocol.serverconfig.k;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.concurrent.LinkedBlockingDeque;

class e
  extends Thread
{
  e(d paramd, String paramString1, String paramString2, h.a parama)
  {
    super(paramString1);
  }
  
  public void run()
  {
    label300:
    d locald2;
    try
    {
      do
      {
        localObject1 = (a)d.a(this.c).take();
        if (QLog.isColorLevel()) {
          QLog.i("MSF.C.SsoListManager", 2, "zip file start");
        }
        localObject1 = h.a(((a)localObject1).b.a, ((a)localObject1).b.b, ((a)localObject1).b.c, ((a)localObject1).b.d, ((a)localObject1).c.a, ((a)localObject1).c.b, ((a)localObject1).c.c, ((a)localObject1).c.d, this.a, this.b);
        if (QLog.isColorLevel()) {
          QLog.i("MSF.C.SsoListManager", 2, "zip file finish");
        }
        localObject1 = new File((String)localObject1);
        boolean bool = ((File)localObject1).exists();
        if (!bool) {
          break label300;
        }
        try
        {
          if (QLog.isColorLevel()) {
            QLog.i("MSF.C.SsoListManager", 2, "report file start");
          }
          h.a(this.c.k.sender.j(), (File)localObject1, this.a, this.b);
          if (QLog.isColorLevel()) {
            QLog.i("MSF.C.SsoListManager", 2, "report file finish");
          }
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.w("MSF.C.SsoListManager", 2, "report log error " + localException2, localException2);
            }
          }
        }
        ((File)localObject1).deleteOnExit();
      } while (!d.a(this.c).isEmpty());
      Object localObject1 = this.c;
      d.a((d)localObject1, null);
      return;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.w("MSF.C.SsoListManager", 2, "handle report log error " + localException1, localException1);
        }
        if (d.a(this.c).isEmpty())
        {
          d locald1 = this.c;
          continue;
          if (QLog.isColorLevel()) {
            QLog.w("MSF.C.SsoListManager", 2, "zip file not existed.");
          }
        }
      }
    }
    finally
    {
      while (d.a(this.c).isEmpty()) {
        locald2 = this.c;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.a.e
 * JD-Core Version:    0.7.0.1
 */