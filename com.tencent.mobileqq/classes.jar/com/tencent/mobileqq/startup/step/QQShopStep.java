package com.tencent.mobileqq.startup.step;

import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.ecshop.ad.IEcshopAdHandler;
import com.tencent.qphone.base.util.QLog;

public class QQShopStep
  extends AsyncStep
{
  protected int doStep()
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQShopStep", 2, "StepServiceAsync call!");
    }
    IEcshopAdHandler localIEcshopAdHandler = (IEcshopAdHandler)this.mAutomator.k.getBusinessHandler(BusinessHandlerFactory.ESHOP_AD_HANDLER);
    localIEcshopAdHandler.a(true, System.currentTimeMillis());
    localIEcshopAdHandler.a(null, null, false, null, 33);
    return super.doStep();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.QQShopStep
 * JD-Core Version:    0.7.0.1
 */