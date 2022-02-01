package com.tencent.mobileqq.startup.step;

import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.config.QConReqExtraInfo;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.utils.abtest.ABTestController;
import com.tencent.mobileqq.utils.abtest.ABTestUtil;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class TABSDKInit
  extends AsyncStep
{
  protected int doStep()
  {
    Object localObject;
    if (QConfigManager.a().a(742))
    {
      ABTestUtil.a("QQInitHandler", "start pull ExpList from TABSDKInitSTEP");
      ABTestController.a().a();
      localObject = new ArrayList();
      ((ArrayList)localObject).add(new QConReqExtraInfo(742, true));
      QConfigManager.a((ArrayList)localObject);
    }
    else
    {
      ABTestUtil.a("QQInitHandler", "ExpMgrListProcessor inject error, init from TABSDKInitSTEP");
      localObject = MobileQQ.sMobileQQ.waitAppRuntime(null);
      ABTestController.a().a();
      ABTestController.a().a(MobileQQ.sMobileQQ, ((AppRuntime)localObject).getAccount());
    }
    return super.doStep();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.TABSDKInit
 * JD-Core Version:    0.7.0.1
 */