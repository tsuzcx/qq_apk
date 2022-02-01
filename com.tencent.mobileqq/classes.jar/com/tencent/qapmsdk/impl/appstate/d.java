package com.tencent.qapmsdk.impl.appstate;

import com.tencent.qapmsdk.impl.g.b;
import com.tencent.qapmsdk.impl.instrumentation.a;
import com.tencent.qapmsdk.impl.instrumentation.f;
import com.tencent.qapmsdk.impl.instrumentation.k.b;

public class d
  implements a
{
  public e a;
  
  public e a(String paramString, long paramLong, k.b paramb)
  {
    this.a = e.a(paramString, paramLong, paramb);
    return this.a;
  }
  
  public h a()
  {
    if (this.a == null) {
      return null;
    }
    return this.a.b();
  }
  
  public void a(f paramf)
  {
    if ((b.c) && (this.a != null)) {
      this.a.a(paramf);
    }
  }
  
  public void a(String paramString)
  {
    if ((b.c) && (this.a != null)) {}
  }
  
  public QAPMMonitorThreadLocal b()
  {
    return this.a.a();
  }
  
  public void b(f paramf)
  {
    if (this.a != null) {}
  }
  
  public void c()
  {
    if ((b.c) && (this.a != null)) {
      this.a.a(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.appstate.d
 * JD-Core Version:    0.7.0.1
 */