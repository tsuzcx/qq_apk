package com.tencent.mobileqq.msf.sdk.utils;

import android.os.Handler;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

class c$a
  implements Runnable
{
  private int b;
  private int c;
  
  public c$a(c paramc, int paramInt1, int paramInt2)
  {
    this.b = paramInt1;
    this.c = paramInt2;
  }
  
  public void run()
  {
    if (this.b == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.D.MonitorSocket", 2, "taskRun keyHashCode is 0.");
      }
      return;
    }
    b localb;
    if (c.l == this.c) {
      localb = (b)c.o.remove(Integer.valueOf(this.b));
    }
    for (;;)
    {
      if (localb == null)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("MSF.D.MonitorSocket", 2, "taskRun dataFlowItem is null.,type:" + this.c + " ,keyhashCode:" + this.b);
        return;
        if (c.m != this.c) {
          break label255;
        }
        localb = (b)c.n.remove(Integer.valueOf(this.b));
        continue;
      }
      if ((localb.k > 0L) && (localb.l != null) && (System.currentTimeMillis() - localb.k < 3000L))
      {
        c.d().postDelayed(localb.l, 10000L);
        if (c.l == this.c)
        {
          c.o.put(Integer.valueOf(this.b), localb);
          return;
        }
        if (c.m != this.c) {
          break;
        }
        c.n.put(Integer.valueOf(this.b), localb);
        return;
      }
      c.a(this.a);
      localb.l = null;
      BaseApplication.monitor.insertData(localb);
      c.a(this.a, localb);
      return;
      label255:
      localb = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.utils.c.a
 * JD-Core Version:    0.7.0.1
 */