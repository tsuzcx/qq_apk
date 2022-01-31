package com.tencent.tvkbeacon.core.a;

import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

final class b$c<V>
{
  private FutureTask<?> a;
  private final Runnable b;
  private final long c;
  private final long d;
  private final TimeUnit e;
  
  public b$c(FutureTask<V> paramFutureTask, Runnable paramRunnable, long paramLong1, long paramLong2, TimeUnit paramTimeUnit)
  {
    this.a = paramFutureTask;
    this.b = paramRunnable;
    this.c = paramLong1;
    this.d = paramLong2;
    this.e = paramTimeUnit;
  }
  
  public final boolean a()
  {
    return this.a.isCancelled();
  }
  
  public final boolean a(boolean paramBoolean)
  {
    return this.a.cancel(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tvkbeacon.core.a.b.c
 * JD-Core Version:    0.7.0.1
 */