package com.tencent.mobileqq.msf.core.c;

import com.tencent.mobileqq.msf.sdk.utils.a;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class d$a
  implements Runnable
{
  HashMap a = null;
  HashMap b = null;
  
  d$a(d paramd) {}
  
  public void run()
  {
    QLog.d("MSF.C.MonitorNetFlowStore", 1, "MonitorWriteDataThread Enter");
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.MonitorNetFlowStore", 1, "MonitorWriteDataThread avaialbeMemory=" + a.a() / 1024L + "k");
    }
    long l = System.currentTimeMillis();
    if (this.a == null) {
      this.a = new HashMap();
    }
    synchronized (d.a(this.c))
    {
      this.a.putAll(d.a(this.c));
      d.a(this.c).clear();
      if (this.b == null) {
        this.b = new HashMap();
      }
    }
    synchronized (d.b(this.c))
    {
      this.b.putAll(d.b(this.c));
      d.b(this.c).clear();
      d.a(this.c, this.a, this.b);
      this.a.clear();
      this.b.clear();
      d.a(this.c, System.currentTimeMillis());
      QLog.d("MSF.C.MonitorNetFlowStore", 1, "MonitorWriteDataThread End takeTimes=" + (System.currentTimeMillis() - l));
      return;
      localObject1 = finally;
      throw localObject1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.c.d.a
 * JD-Core Version:    0.7.0.1
 */