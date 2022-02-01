package com.tencent.tbs.one.impl.common.statistic;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;

final class StatisticExecutor$2
  implements Executor
{
  Runnable mActive;
  final ArrayDeque<Runnable> mTasks = new ArrayDeque();
  
  public void execute(Runnable paramRunnable)
  {
    try
    {
      this.mTasks.offer(new StatisticExecutor.2.1(this, paramRunnable));
      if (this.mActive == null) {
        scheduleNext();
      }
      return;
    }
    finally
    {
      paramRunnable = finally;
      throw paramRunnable;
    }
  }
  
  void scheduleNext()
  {
    try
    {
      Runnable localRunnable = (Runnable)this.mTasks.poll();
      this.mActive = localRunnable;
      if (localRunnable != null) {
        StatisticExecutor.access$000().execute(this.mActive);
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.common.statistic.StatisticExecutor.2
 * JD-Core Version:    0.7.0.1
 */