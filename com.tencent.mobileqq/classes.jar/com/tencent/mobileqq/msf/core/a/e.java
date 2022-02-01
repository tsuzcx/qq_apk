package com.tencent.mobileqq.msf.core.a;

import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.aj;
import com.tencent.mobileqq.msf.core.i;
import com.tencent.mobileqq.msf.core.i.a;
import com.tencent.msf.service.protocol.serverconfig.a;
import com.tencent.msf.service.protocol.serverconfig.l;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.concurrent.LinkedBlockingDeque;

class e
  extends Thread
{
  e(d paramd, String paramString1, String paramString2, i.a parama)
  {
    super(paramString1);
  }
  
  public void run()
  {
    try
    {
      Object localObject1 = (a)c.a(this.c.c).take();
      if (QLog.isColorLevel()) {
        QLog.i("MSF.C.SsoListManager", 2, "zip file start");
      }
      localObject1 = i.a(((a)localObject1).b.a, ((a)localObject1).b.b, ((a)localObject1).b.c, ((a)localObject1).b.d, ((a)localObject1).c.a, ((a)localObject1).c.b, ((a)localObject1).c.c, ((a)localObject1).c.d, this.a, this.b);
      if (QLog.isColorLevel()) {
        QLog.i("MSF.C.SsoListManager", 2, "zip file finish");
      }
      localObject1 = new File((String)localObject1);
      boolean bool = ((File)localObject1).exists();
      if (bool)
      {
        try
        {
          if (QLog.isColorLevel()) {
            QLog.i("MSF.C.SsoListManager", 2, "report file start");
          }
          i.a(this.c.c.n.sender.k(), (File)localObject1, this.a, this.b);
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
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.w("MSF.C.SsoListManager", 2, "handle report log error " + localException1, localException1);
        }
        if (c.a(this.c.c).isEmpty())
        {
          c.a(this.c.c, null);
          return;
          if (QLog.isColorLevel()) {
            QLog.w("MSF.C.SsoListManager", 2, "zip file not existed.");
          }
        }
      }
    }
    finally
    {
      if (c.a(this.c.c).isEmpty())
      {
        c.a(this.c.c, null);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.a.e
 * JD-Core Version:    0.7.0.1
 */