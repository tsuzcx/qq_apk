package com.tencent.mobileqq.statistics;

import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.qphone.base.remote.ToServiceMsg;

class StatisticCollector$2
  implements Runnable
{
  StatisticCollector$2(StatisticCollector paramStatisticCollector, ToServiceMsg paramToServiceMsg) {}
  
  public void run()
  {
    MsfServiceSdk.get().sendMsg(this.val$rdmReportMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.StatisticCollector.2
 * JD-Core Version:    0.7.0.1
 */