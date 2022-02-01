package com.tencent.mobileqq.startup.step;

import com.tencent.biz.richframework.delegate.impl.RFApplication;
import com.tencent.mobileqq.qcircle.api.IQCircleClassApi;
import com.tencent.mobileqq.qroute.QRoute;

public class QCircleInitStep
  extends Step
{
  protected boolean doStep()
  {
    RFApplication.setApplicationDelegate(((IQCircleClassApi)QRoute.api(IQCircleClassApi.class)).getQCircleApplicationDelegateClass());
    return super.doStep();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.QCircleInitStep
 * JD-Core Version:    0.7.0.1
 */