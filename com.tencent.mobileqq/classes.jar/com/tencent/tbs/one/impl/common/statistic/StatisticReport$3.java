package com.tencent.tbs.one.impl.common.statistic;

import android.content.Context;
import com.tencent.tbs.log.TBSLog;
import com.tencent.tbs.one.impl.base.Logging;

final class StatisticReport$3
  implements Runnable
{
  StatisticReport$3(Context paramContext) {}
  
  public void run()
  {
    Logging.d("Start packaging log files, log path: %s", new Object[] { TBSLog.getLogPath() });
    new LogPackingJob(TBSLog.getLogPath()).start(new StatisticReport.3.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.common.statistic.StatisticReport.3
 * JD-Core Version:    0.7.0.1
 */