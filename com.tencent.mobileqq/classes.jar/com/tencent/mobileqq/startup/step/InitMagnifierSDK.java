package com.tencent.mobileqq.startup.step;

import com.tencent.mobileqq.app.PrivacyPolicyHelper;
import com.tencent.qqperf.MagnifierSDK;

public class InitMagnifierSDK
  extends Step
{
  protected boolean doStep()
  {
    if (PrivacyPolicyHelper.a()) {
      MagnifierSDK.a().a();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.InitMagnifierSDK
 * JD-Core Version:    0.7.0.1
 */