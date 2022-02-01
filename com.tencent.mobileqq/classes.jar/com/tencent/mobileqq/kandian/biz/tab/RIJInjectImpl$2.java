package com.tencent.mobileqq.kandian.biz.tab;

import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.qroute.QRoute;

final class RIJInjectImpl$2
  implements Runnable
{
  public void run()
  {
    try
    {
      ((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).reportKandianTabExposureFor81C3();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.tab.RIJInjectImpl.2
 * JD-Core Version:    0.7.0.1
 */