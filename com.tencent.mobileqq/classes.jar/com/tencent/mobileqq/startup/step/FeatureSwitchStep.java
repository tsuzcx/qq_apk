package com.tencent.mobileqq.startup.step;

import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class FeatureSwitchStep
  extends AsyncStep
{
  protected int doStep()
  {
    ((IFeatureRuntimeService)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IFeatureRuntimeService.class, "all")).initSdk(MobileQQ.sMobileQQ);
    return super.doStep();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.FeatureSwitchStep
 * JD-Core Version:    0.7.0.1
 */