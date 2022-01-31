package com.tencent.upload.e.a;

import java.util.concurrent.Future;

public class c
{
  public static final a a = new b(null);
  private final b b;
  
  public c()
  {
    this(4, 8);
  }
  
  public c(int paramInt1, int paramInt2)
  {
    this.b = d.a(paramInt1, paramInt2, "thread-pool");
  }
  
  public c(int paramInt1, int paramInt2, String paramString)
  {
    this.b = d.a(paramInt1, paramInt2, paramString);
  }
  
  public b a()
  {
    return this.b;
  }
  
  public Future<?> a(Runnable paramRunnable)
  {
    return this.b.submit(paramRunnable);
  }
  
  public static abstract interface a {}
  
  private static class b
    implements c.a
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.upload.e.a.c
 * JD-Core Version:    0.7.0.1
 */