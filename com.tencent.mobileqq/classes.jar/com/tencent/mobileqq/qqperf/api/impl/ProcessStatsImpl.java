package com.tencent.mobileqq.qqperf.api.impl;

import com.tencent.mobileqq.qqperf.api.IProcessStats;
import com.tencent.qqperf.tools.ProcessStats;
import com.tencent.qqperf.tools.ProcessStats.Stats;

public class ProcessStatsImpl
  implements IProcessStats
{
  public double getCpuUsage()
  {
    return ProcessStats.a.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqperf.api.impl.ProcessStatsImpl
 * JD-Core Version:    0.7.0.1
 */