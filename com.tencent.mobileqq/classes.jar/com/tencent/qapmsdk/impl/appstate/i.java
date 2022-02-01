package com.tencent.qapmsdk.impl.appstate;

import com.tencent.qapmsdk.impl.g.b;
import com.tencent.qapmsdk.impl.instrumentation.a;

public class i
  extends d
{
  public a b = new a();
  public a c = new a();
  public a d = new a();
  
  public i(String paramString)
  {
    super(paramString);
  }
  
  public void b(String paramString1, String paramString2)
  {
    if (this.b.a()) {
      super.a(paramString1, paramString2);
    }
  }
  
  public void c(String paramString)
  {
    if (this.b.a()) {
      super.a(paramString);
    }
  }
  
  public void c(String paramString1, String paramString2)
  {
    if (this.b.a()) {
      super.a(paramString1, paramString2);
    }
  }
  
  public void d()
  {
    if (this.b.a()) {
      super.a();
    }
  }
  
  public void d(String paramString)
  {
    if (this.c.a()) {
      super.b(paramString);
    }
  }
  
  public void e()
  {
    if (this.b.a()) {
      super.a();
    }
  }
  
  public void f()
  {
    if (this.c.a()) {
      super.b();
    }
  }
  
  public void g()
  {
    if (this.d.a())
    {
      j localj = super.c();
      if ((!b.e()) && (localj != null)) {
        localj.a(this.a.b());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.appstate.i
 * JD-Core Version:    0.7.0.1
 */