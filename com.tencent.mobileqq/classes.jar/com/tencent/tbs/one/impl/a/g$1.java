package com.tencent.tbs.one.impl.a;

final class g$1
  extends l<T>
{
  g$1(g paramg, boolean paramBoolean) {}
  
  public final void a(int paramInt1, int paramInt2)
  {
    this.b.a(paramInt2);
  }
  
  public final void a(int paramInt, String paramString, Throwable paramThrowable)
  {
    f.a(paramString, new Object[] { paramThrowable });
    if ((this.a) || (this.b.a))
    {
      this.b.a(paramInt, paramString, paramThrowable);
      return;
    }
    this.b.c();
  }
  
  public final void a(T paramT)
  {
    this.b.a(paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tbs.one.impl.a.g.1
 * JD-Core Version:    0.7.0.1
 */