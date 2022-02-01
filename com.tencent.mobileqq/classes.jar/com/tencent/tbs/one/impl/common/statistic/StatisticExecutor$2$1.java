package com.tencent.tbs.one.impl.common.statistic;

class StatisticExecutor$2$1
  implements Runnable
{
  StatisticExecutor$2$1(StatisticExecutor.2 param2, Runnable paramRunnable) {}
  
  public void run()
  {
    try
    {
      this.val$r.run();
      return;
    }
    finally
    {
      this.this$0.scheduleNext();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.common.statistic.StatisticExecutor.2.1
 * JD-Core Version:    0.7.0.1
 */