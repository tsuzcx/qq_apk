package com.tencent.tbs.one.impl.a.a;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

public final class e
  extends d
{
  private AtomicInteger b = new AtomicInteger();
  private Executor c;
  private boolean d;
  private List<c> e = new ArrayList();
  
  public e(Executor paramExecutor)
  {
    this.c = paramExecutor;
  }
  
  public final void a()
  {
    this.b.incrementAndGet();
  }
  
  public final void a(c paramc)
  {
    paramc.b = this;
    this.d = true;
    paramc.a();
    int i = 0;
    this.d = false;
    paramc = (c[])this.e.toArray(new c[0]);
    this.e.clear();
    int j = paramc.length;
    while (i < j)
    {
      Runnable localRunnable = paramc[i];
      this.c.execute(localRunnable);
      i += 1;
    }
  }
  
  public final void b()
  {
    if ((this.b.decrementAndGet() <= 0) && (this.a != null)) {
      this.a.a();
    }
  }
  
  public final void b(c paramc)
  {
    if (this.d)
    {
      this.e.add(paramc);
      return;
    }
    this.c.execute(paramc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.a.a.e
 * JD-Core Version:    0.7.0.1
 */