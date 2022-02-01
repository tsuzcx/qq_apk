package com.tencent.qapmsdk.impl.appstate;

import com.tencent.qapmsdk.impl.instrumentation.f;
import com.tencent.qapmsdk.impl.instrumentation.k.b;

public class e
{
  public QAPMMonitorThreadLocal a;
  public h b;
  public k.b c;
  
  protected e(f paramf, long paramLong, k.b paramb)
  {
    this.b = a(paramf, paramLong, paramb);
    this.c = paramb;
    this.a = QAPMMonitorThreadLocal.getInstance();
  }
  
  public static e a(String paramString, long paramLong, k.b paramb)
  {
    return a(paramString, "", paramLong, paramb);
  }
  
  public static e a(String paramString1, String paramString2, long paramLong, k.b paramb)
  {
    f localf = new f();
    localf.g = paramString1;
    localf.h = paramString2;
    paramString1 = new e(localf, paramLong, paramb);
    paramString1.a().a(localf, Boolean.valueOf(true));
    return paramString1;
  }
  
  public static h a(f paramf, long paramLong, k.b paramb)
  {
    return new h(paramf, paramLong, paramb);
  }
  
  public QAPMMonitorThreadLocal a()
  {
    return this.a;
  }
  
  public void a(f paramf)
  {
    this.a.a(paramf, Boolean.valueOf(true));
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
  
  public h b()
  {
    if (this.b == null) {
      return null;
    }
    return this.b.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.appstate.e
 * JD-Core Version:    0.7.0.1
 */