package com.tencent.mobileqq.msf.core.c;

import com.tencent.mobileqq.msf.sdk.utils.a;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class e$a
  implements Runnable
{
  HashMap a = null;
  HashMap b = null;
  
  e$a(e parame) {}
  
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
    synchronized (e.a(this.c))
    {
      this.a.putAll(e.a(this.c));
      e.a(this.c).clear();
      if (this.b == null) {
        this.b = new HashMap();
      }
    }
    synchronized (e.b(this.c))
    {
      this.b.putAll(e.b(this.c));
      e.b(this.c).clear();
      e.a(this.c, this.a, this.b);
      this.a.clear();
      this.b.clear();
      e.a(this.c, System.currentTimeMillis());
      QLog.d("MSF.C.MonitorNetFlowStore", 1, "MonitorWriteDataThread End takeTimes=" + (System.currentTimeMillis() - l));
      return;
      localObject1 = finally;
      throw localObject1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.c.e.a
 * JD-Core Version:    0.7.0.1
 */