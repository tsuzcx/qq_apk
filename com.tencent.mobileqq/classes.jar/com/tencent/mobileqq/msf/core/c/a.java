package com.tencent.mobileqq.msf.core.c;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.d.j;
import com.tencent.mobileqq.msf.core.net.utils.h;
import com.tencent.mobileqq.msf.core.q;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import java.util.TreeMap;

public class a
  implements Handler.Callback
{
  public static final int a = 1;
  public static final int b = 2;
  public static final int c = 3;
  public static final float d = 0.85F;
  private static final String e = "MemoryCeilingMonitor";
  private static final int f = 10000;
  private static final int g = 30000;
  private Handler h;
  private long i = 10000L;
  private long j;
  private boolean k;
  
  public static a a()
  {
    return a.a.a();
  }
  
  private void a(long paramLong)
  {
    QLog.d("MemoryCeilingMonitor", 1, new Object[] { "[onLowMemory] memory: ", Long.valueOf(paramLong), ", free: ", Long.valueOf(Runtime.getRuntime().freeMemory()) });
    if (!this.k)
    {
      this.h.sendEmptyMessage(3);
      this.k = true;
    }
  }
  
  private void e()
  {
    QLog.d("MemoryCeilingMonitor", 1, "[handleMemoryCalculate]");
    if (h()) {
      a(this.j);
    }
    this.h.sendEmptyMessageDelayed(1, this.i);
  }
  
  private void f()
  {
    QLog.d("MemoryCeilingMonitor", 1, "[handleReportCeiling]");
    j localj = MsfCore.sCore.statReporter;
    if (localj != null)
    {
      TreeMap localTreeMap = new TreeMap();
      long l = Runtime.getRuntime().totalMemory();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(l);
      localStringBuilder.append("");
      localTreeMap.put("TotalMemory", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(Runtime.getRuntime().freeMemory());
      localStringBuilder.append("");
      localTreeMap.put("FreeMemory", localStringBuilder.toString());
      localj.a("MSF_MEM_Celling ", true, 0L, 0L, localTreeMap, false, false);
    }
  }
  
  private void g()
  {
    QLog.d("MemoryCeilingMonitor", 1, "[handleReportStart]");
    j localj = MsfCore.sCore.statReporter;
    if (localj != null) {
      localj.a("MSF_MEM_Start ", true, 0L, 0L, new TreeMap(), false, false);
    }
  }
  
  private boolean h()
  {
    this.j = (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory());
    return (float)this.j > (float)Runtime.getRuntime().maxMemory() * 0.85F;
  }
  
  public void b()
  {
    if (h.a(0, 100000) > 10) {
      return;
    }
    QLog.d("MemoryCeilingMonitor", 1, "[detect] start detect memory.");
    if (this.h == null)
    {
      this.h = new Handler(q.e().getLooper(), this);
      com.tencent.mobileqq.msf.core.net.c.a locala = MsfCore.sCore.getDeepSleepDetector();
      if (locala != null) {
        locala.a(new b(this));
      }
    }
    this.h.removeMessages(1);
    this.h.sendEmptyMessageDelayed(1, this.i);
  }
  
  public void c()
  {
    this.i = 10000L;
  }
  
  public void d()
  {
    this.i = 30000L;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int m = paramMessage.what;
    if (m == 1)
    {
      e();
      return true;
    }
    if (m == 3)
    {
      f();
      return true;
    }
    if (m == 2) {
      g();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.c.a
 * JD-Core Version:    0.7.0.1
 */