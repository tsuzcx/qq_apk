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
    if (this.a == null) {
      return null;
    }
    return this.a.b();
  }
  
  public void a(g paramg)
  {
    if ((com.tencent.qapmsdk.impl.g.b.g) && (this.a != null)) {
      this.a.a(paramg);
    }
  }
  
  public void a(String paramString)
  {
    if ((com.tencent.qapmsdk.impl.g.b.g) && (this.a != null)) {}
  }
  
  public QAPMMonitorThreadLocal b()
  {
    return this.a.a();
  }
  
  public void b(g paramg)
  {
    if (this.a != null) {}
  }
  
  public void c()
  {
    if ((com.tencent.qapmsdk.impl.g.b.g) && (this.a != null)) {
      this.a.a(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.appstate.e
 * JD-Core Version:    0.7.0.1
 */