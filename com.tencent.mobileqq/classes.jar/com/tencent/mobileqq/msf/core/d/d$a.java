package com.tencent.mobileqq.msf.core.d;

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
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("MonitorWriteDataThread avaialbeMemory=");
      ((StringBuilder)???).append(a.a() / 1024L);
      ((StringBuilder)???).append("k");
      QLog.d("MSF.C.MonitorNetFlowStore", 1, ((StringBuilder)???).toString());
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
      synchronized (d.b(this.c))
      {
        this.b.putAll(d.b(this.c));
        d.b(this.c).clear();
        d.a(this.c, this.a, this.b);
        this.a.clear();
        this.b.clear();
        d.a(this.c, System.currentTimeMillis());
        ??? = new StringBuilder();
        ((StringBuilder)???).append("MonitorWriteDataThread End takeTimes=");
        ((StringBuilder)???).append(System.currentTimeMillis() - l);
        QLog.d("MSF.C.MonitorNetFlowStore", 1, ((StringBuilder)???).toString());
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.d.d.a
 * JD-Core Version:    0.7.0.1
 */