package com.tencent.qapmsdk.impl.appstate;

import com.tencent.qapmsdk.impl.g.b;
import com.tencent.qapmsdk.impl.instrumentation.QAPMAppInstrumentation;
import com.tencent.qapmsdk.impl.instrumentation.g;
import com.tencent.qapmsdk.impl.instrumentation.l.a;
import com.tencent.qapmsdk.impl.instrumentation.l.b;

public class d
{
  e a = new e();
  
  d(String paramString)
  {
    this.a.a(paramString, 500L, l.b.d);
  }
  
  private void b(String paramString1, String paramString2)
  {
    if (b.d())
    {
      this.a.a(new g("QAPM_APPLAUNCH", paramString1 + paramString2, l.a.a.a()));
      return;
    }
    if (b.e())
    {
      this.a.a(new g(QAPMAppInstrumentation.activityTrace.f(), paramString1 + paramString2, l.a.a.a()));
      return;
    }
    this.a.a(new g(paramString1, paramString1 + paramString2, l.a.a.a()));
  }
  
  private boolean d()
  {
    return b.g;
  }
  
  void a()
  {
    if (d()) {
      this.a.c();
    }
  }
  
  void a(String paramString)
  {
    if (!d()) {
      return;
    }
    b(paramString, "#onStart");
  }
  
  void a(String paramString1, String paramString2)
  {
    if (!d()) {
      return;
    }
    b(paramString1, paramString2);
  }
  
  void b()
  {
    if (d()) {
      this.a.c();
    }
  }
  
  void b(String paramString)
  {
    if (!d()) {
      return;
    }
    b(paramString, "#onResume");
  }
  
  j c()
  {
    if (!d()) {
      return null;
    }
    this.a.c();
    return this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.appstate.d
 * JD-Core Version:    0.7.0.1
 */