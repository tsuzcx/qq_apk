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
    Object localObject;
    if (c.l == this.c) {
      localObject = (b)c.o.remove(Integer.valueOf(this.b));
    } else if (c.m == this.c) {
      localObject = (b)c.n.remove(Integer.valueOf(this.b));
    } else {
      localObject = null;
    }
    if (localObject == null)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("taskRun dataFlowItem is null.,type:");
        ((StringBuilder)localObject).append(this.c);
        ((StringBuilder)localObject).append(" ,keyhashCode:");
        ((StringBuilder)localObject).append(this.b);
        QLog.d("MSF.D.MonitorSocket", 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
    if ((((b)localObject).k > 0L) && (((b)localObject).l != null) && (System.currentTimeMillis() - ((b)localObject).k < 3000L))
    {
      c.d().postDelayed(((b)localObject).l, 10000L);
      if (c.l == this.c)
      {
        c.o.put(Integer.valueOf(this.b), localObject);
        return;
      }
      if (c.m == this.c) {
        c.n.put(Integer.valueOf(this.b), localObject);
      }
      return;
    }
    c.a(this.a);
    ((b)localObject).l = null;
    BaseApplication.monitor.insertData((b)localObject);
    c.a(this.a, (b)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.utils.c.a
 * JD-Core Version:    0.7.0.1
 */