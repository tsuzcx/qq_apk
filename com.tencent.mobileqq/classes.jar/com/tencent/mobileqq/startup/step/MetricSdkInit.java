package com.tencent.mobileqq.startup.step;

import bcbw;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.abtest.ABTestController;
import com.tencent.mobileqq.app.automator.AsyncStep;
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
    ABTestController.a("MetricsSDKInit", "metrics sdk init async..");
    paramString = new bcbw(paramBaseApplicationImpl);
    paramString = MetricsConfig.builder().setReporter(paramString).setLogEnable(false).setChannel("1001").setReportInterval(5000L).build();
    MetricsApi.getDefault().start(paramBaseApplicationImpl, paramString);
  }
  
  public int a()
  {
    a(BaseApplicationImpl.sApplication, "0S200MNJT807V3GE");
    return super.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.MetricSdkInit
 * JD-Core Version:    0.7.0.1
 */