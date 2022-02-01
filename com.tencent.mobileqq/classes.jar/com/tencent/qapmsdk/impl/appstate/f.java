package com.tencent.qapmsdk.impl.appstate;

import com.tencent.qapmsdk.impl.instrumentation.g;
import com.tencent.qapmsdk.impl.instrumentation.l.b;

public class f
{
  public QAPMMonitorThreadLocal a;
  public j b;
  public l.b c;
  
  protected f(g paramg, long paramLong, l.b paramb)
  {
    this.b = a(paramg, paramLong, paramb);
    this.c = paramb;
    this.a = QAPMMonitorThreadLocal.getInstance();
  }
  
  public static f a(String paramString, long paramLong, l.b paramb)
  {
    return a(paramString, "", paramLong, paramb);
  }
  
  public static f a(String paramString1, String paramString2, long paramLong, l.b paramb)
  {
    g localg = new g();
    localg.g = paramString1;
    localg.h = paramString2;
    paramString1 = new f(localg, paramLong, paramb);
    paramString1.a().a(localg, Boolean.valueOf(true));
    return paramString1;
  }
  
  public static j a(g paramg, long paramLong, l.b paramb)
  {
    return new j(paramg, paramLong, paramb);
  }
  
  public QAPMMonitorThreadLocal a()
  {
    return this.a;
  }
  
  public void a(g paramg)
  {
    this.a.a(paramg, Boolean.valueOf(true));
  }
  
  public void a(boolean paramBoolean)
  {
    try
    {
      if (this.a.c() == null) {
        return;
      }
      this.a.pop(paramBoolean);
      return;
    }
    catch (Exception localException) {}
  }
  
  public j b()
  {
    if (this.b == null) {
      return null;
    }
    return this.b.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.appstate.f
 * JD-Core Version:    0.7.0.1
 */