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
    if (e())
    {
      e locale = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("#onStart");
      locale.a(new g(paramString, localStringBuilder.toString(), l.a.a.a()));
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (e())
    {
      this.a.a(paramString1, 500L, l.b.c);
      e locale = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append(paramString2);
      locale.a(new g(paramString1, localStringBuilder.toString(), l.a.a.a()));
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
    if (e())
    {
      e locale = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("#onResume");
      locale.a(new g(paramString, localStringBuilder.toString(), l.a.a.a()));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.appstate.c
 * JD-Core Version:    0.7.0.1
 */