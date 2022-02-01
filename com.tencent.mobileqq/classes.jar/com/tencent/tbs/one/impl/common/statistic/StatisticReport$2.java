package com.tencent.tbs.one.impl.common.statistic;

import com.tencent.tbs.one.impl.base.Logging;
import com.tencent.tbs.one.impl.base.ProgressiveCallback;

class StatisticReport$2
  extends ProgressiveCallback<Integer>
{
  StatisticReport$2(StatisticReport paramStatisticReport) {}
  
  public void onCompleted(Integer paramInteger)
  {
    Logging.i("Statistic upload complete with http response code: %d", new Object[] { paramInteger });
  }
  
  public void onError(int paramInt, String paramString, Throwable paramThrowable)
  {
    Logging.e(paramString, new Object[] { paramThrowable });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.common.statistic.StatisticReport.2
 * JD-Core Version:    0.7.0.1
 */