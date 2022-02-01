package com.tencent.mobileqq.statistics;

import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.qphone.base.remote.ToServiceMsg;

class StatisticCollector$1
  implements Runnable
{
  StatisticCollector$1(StatisticCollector paramStatisticCollector, ToServiceMsg paramToServiceMsg) {}
  
  public void run()
  {
    MsfServiceSdk.get().sendMsg(this.val$rdmReportMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.StatisticCollector.1
 * JD-Core Version:    0.7.0.1
 */