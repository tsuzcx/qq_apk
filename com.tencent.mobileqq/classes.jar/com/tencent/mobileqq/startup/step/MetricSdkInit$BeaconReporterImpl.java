package com.tencent.mobileqq.startup.step;

import com.google.gson.Gson;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.tfm.metrics.api.MetricsLogBean;
import com.tencent.tfm.metrics.api.Reporter;
import java.util.HashMap;
import mqq.app.AppRuntime;

public class MetricSdkInit$BeaconReporterImpl
  implements Reporter
{
  private Gson a = new Gson();
  private StatisticCollector b;
  private String c;
  
  public MetricSdkInit$BeaconReporterImpl(BaseApplicationImpl paramBaseApplicationImpl)
  {
    this.b = StatisticCollector.getInstance(paramBaseApplicationImpl);
    this.c = paramBaseApplicationImpl.getRuntime().getAccount();
  }
  
  public void report(MetricsLogBean paramMetricsLogBean)
  {
    HashMap localHashMap = new HashMap();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a.toJson(paramMetricsLogBean));
    localStringBuilder.append(";");
    localHashMap.put("monitor", localStringBuilder.toString());
    this.b.collectPerformance(this.c, "rqd_tfm_metrics", true, 0L, 0L, localHashMap, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.MetricSdkInit.BeaconReporterImpl
 * JD-Core Version:    0.7.0.1
 */