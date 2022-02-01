package com.tencent.tbs.one.impl.common.statistic;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;

final class b$2
  implements Executor
{
  final ArrayDeque<Runnable> a = new ArrayDeque();
  Runnable b;
  
  final void a()
  {
    try
    {
      Runnable localRunnable = (Runnable)this.a.poll();
      this.b = localRunnable;
      if (localRunnable != null) {
        b.b().execute(this.b);
      }
      return;
    }
    finally {}
  }
  
  public final void execute(Runnable paramRunnable)
  {
    try
    {
      this.a.offer(new b.2.1(this, paramRunnable));
      if (this.b == null) {
        a();
      }
      return;
    }
    finally
    {
      paramRunnable = finally;
      throw paramRunnable;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tbs.one.impl.common.statistic.b.2
 * JD-Core Version:    0.7.0.1
 */