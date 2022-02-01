package com.tencent.mobileqq.startup.step;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.utils.abtest.ABTestUtil;
import com.tencent.tfm.metrics.api.Metrics;
import com.tencent.tfm.metrics.api.MetricsApi;
import com.tencent.tfm.metrics.api.MetricsConfig;
import com.tencent.tfm.metrics.api.MetricsConfig.Builder;

public class MetricSdkInit
  extends AsyncStep
{
  private void a(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    if (paramBaseApplicationImpl == null) {
      return;
    }
    ABTestUtil.a("MetricsSDKInit", "metrics sdk init async..");
    paramString = new MetricSdkInit.BeaconReporterImpl(paramBaseApplicationImpl);
    paramString = MetricsConfig.builder().setReporter(paramString).setLogEnable(false).setChannel("1001").setReportInterval(5000L).build();
    MetricsApi.getDefault().start(paramBaseApplicationImpl, paramString);
  }
  
  protected int doStep()
  {
    a(BaseApplicationImpl.sApplication, "0S200MNJT807V3GE");
    return super.doStep();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.MetricSdkInit
 * JD-Core Version:    0.7.0.1
 */