package com.tencent.qapmsdk.impl.appstate;

import com.tencent.qapmsdk.impl.instrumentation.QAPMAppInstrumentation;
import com.tencent.qapmsdk.impl.instrumentation.f;
import com.tencent.qapmsdk.impl.instrumentation.k.a;
import com.tencent.qapmsdk.impl.instrumentation.k.b;

public class c
{
  protected d a = new d();
  
  public void a()
  {
    if (d()) {
      this.a.c();
    }
  }
  
  public void a(String paramString)
  {
    if (d()) {
      this.a.a(new f(paramString + "#onStart", k.a.a.a()));
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (d())
    {
      this.a.a(paramString1, 500L, k.b.c);
      this.a.a(new f(paramString1 + paramString2, k.a.a.a()));
    }
  }
  
  public void b()
  {
    if (d()) {
      this.a.c();
    }
  }
  
  public void b(String paramString)
  {
    if (d()) {
      this.a.a(new f(paramString + "#onResume", k.a.a.a()));
    }
  }
  
  public h c()
  {
    if (!d()) {
      return null;
    }
    this.a.c();
    return this.a.a();
  }
  
  protected boolean d()
  {
    return (com.tencent.qapmsdk.impl.g.b.c) && (b.a) && (!QAPMAppInstrumentation.isAppInBackground);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.appstate.c
 * JD-Core Version:    0.7.0.1
 */