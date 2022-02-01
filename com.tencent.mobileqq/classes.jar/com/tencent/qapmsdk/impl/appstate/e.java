package com.tencent.qapmsdk.impl.appstate;

import com.tencent.qapmsdk.impl.instrumentation.g;
import com.tencent.qapmsdk.impl.instrumentation.l.b;

public class e
  implements com.tencent.qapmsdk.impl.instrumentation.b
{
  public f a;
  
  public f a(String paramString, long paramLong, l.b paramb)
  {
    this.a = f.a(paramString, paramLong, paramb);
    return this.a;
  }
  
  public j a()
  {
    f localf = this.a;
    if (localf == null) {
      return null;
    }
    return localf.b();
  }
  
  public void a(g paramg)
  {
    if (com.tencent.qapmsdk.impl.g.b.g)
    {
      f localf = this.a;
      if (localf != null) {
        localf.a(paramg);
      }
    }
  }
  
  public void a(String paramString)
  {
    if (com.tencent.qapmsdk.impl.g.b.g) {
      paramString = this.a;
    }
  }
  
  public QAPMMonitorThreadLocal b()
  {
    return this.a.a();
  }
  
  public void b(g paramg)
  {
    paramg = this.a;
  }
  
  public void c()
  {
    if (com.tencent.qapmsdk.impl.g.b.g)
    {
      f localf = this.a;
      if (localf != null) {
        localf.a(true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.appstate.e
 * JD-Core Version:    0.7.0.1
 */