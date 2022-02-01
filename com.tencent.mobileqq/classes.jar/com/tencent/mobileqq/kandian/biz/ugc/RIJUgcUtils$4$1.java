package com.tencent.mobileqq.kandian.biz.ugc;

import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.qroute.QRoute;

class RIJUgcUtils$4$1
  implements Runnable
{
  RIJUgcUtils$4$1(RIJUgcUtils.4 param4) {}
  
  public void run()
  {
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X800B4C4", "0X800B4C4", 0, 0, RIJQQAppInterfaceUtil.a(), "", "", "", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.RIJUgcUtils.4.1
 * JD-Core Version:    0.7.0.1
 */