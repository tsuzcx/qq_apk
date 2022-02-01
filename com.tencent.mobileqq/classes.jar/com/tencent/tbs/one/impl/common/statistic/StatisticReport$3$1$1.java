package com.tencent.tbs.one.impl.common.statistic;

import com.tencent.tbs.one.impl.base.Logging;
import com.tencent.tbs.one.impl.base.ProgressiveCallback;

class StatisticReport$3$1$1
  extends ProgressiveCallback<Integer>
{
  StatisticReport$3$1$1(StatisticReport.3.1 param1) {}
  
  public void onCompleted(Integer paramInteger)
  {
    Logging.d("Log files uploaded, response code: %d", new Object[] { paramInteger });
    StatisticReport.access$000(this.this$1.this$0.val$context);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.common.statistic.StatisticReport.3.1.1
 * JD-Core Version:    0.7.0.1
 */