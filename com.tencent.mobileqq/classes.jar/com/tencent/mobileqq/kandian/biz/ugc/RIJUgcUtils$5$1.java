package com.tencent.mobileqq.kandian.biz.ugc;

import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.qroute.QRoute;

class RIJUgcUtils$5$1
  implements Runnable
{
  RIJUgcUtils$5$1(RIJUgcUtils.5 param5) {}
  
  public void run()
  {
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X800B4C2", "0X800B4C2", 0, 0, RIJQQAppInterfaceUtil.a(), "", "", "", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.RIJUgcUtils.5.1
 * JD-Core Version:    0.7.0.1
 */