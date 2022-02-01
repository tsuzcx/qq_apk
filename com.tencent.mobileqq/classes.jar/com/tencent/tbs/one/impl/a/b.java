package com.tencent.tbs.one.impl.a;

import java.io.File;

public abstract class b<T>
  extends a<T>
{
  final File b;
  final long c;
  j d;
  
  public b(File paramFile)
  {
    this.b = paramFile;
    this.c = 10000L;
  }
  
  private void d()
  {
    j localj = this.d;
    if (localj != null) {
      localj.a();
    }
  }
  
  protected final void a()
  {
    m.d(new b.1(this));
  }
  
  public void a(int paramInt, String paramString, Throwable paramThrowable)
  {
    d();
    super.a(paramInt, paramString, paramThrowable);
  }
  
  public abstract void a(Exception paramException);
  
  public void a(T paramT)
  {
    d();
    super.a(paramT);
  }
  
  public abstract void c();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tbs.one.impl.a.b
 * JD-Core Version:    0.7.0.1
 */