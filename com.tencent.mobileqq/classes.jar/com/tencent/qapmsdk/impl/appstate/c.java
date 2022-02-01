package com.tencent.qapmsdk.impl.appstate;

import com.tencent.qapmsdk.impl.instrumentation.QAPMAppInstrumentation;
import com.tencent.qapmsdk.impl.instrumentation.g;
import com.tencent.qapmsdk.impl.instrumentation.l.a;
import com.tencent.qapmsdk.impl.instrumentation.l.b;

public class c
{
  protected e a = new e();
  
  public void a()
  {
    if (e()) {
      this.a.c();
    }
  }
  
  public void a(String paramString)
  {
    if (e()) {
      this.a.a(new g(paramString, paramString + "#onStart", l.a.a.a()));
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (e())
    {
      this.a.a(paramString1, 500L, l.b.c);
      this.a.a(new g(paramString1, paramString1 + paramString2, l.a.a.a()));
    }
  }
  
  public void b()
  {
    if (e()) {
      this.a.c();
    }
  }
  
  public void b(String paramString)
  {
    if (e()) {
      this.a.a(new g(paramString, paramString + "#onResume", l.a.a.a()));
    }
  }
  
  public void c()
  {
    if (e()) {
      this.a.c();
    }
  }
  
  public j d()
  {
    if (!e()) {
      return null;
    }
    return this.a.a();
  }
  
  protected boolean e()
  {
    return (com.tencent.qapmsdk.impl.g.b.g) && (b.a) && (!QAPMAppInstrumentation.isAppInBackground);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.appstate.c
 * JD-Core Version:    0.7.0.1
 */