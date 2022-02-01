package com.tencent.mobileqq.kandian.biz.account;

import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.qroute.QRoute;

class RIJUserLevelDialog$1
  implements Runnable
{
  RIJUserLevelDialog$1(RIJUserLevelDialog paramRIJUserLevelDialog) {}
  
  public void run()
  {
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X800B4C1", "0X800B4C1", 0, 0, RIJQQAppInterfaceUtil.a(), "", "", "", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.account.RIJUserLevelDialog.1
 * JD-Core Version:    0.7.0.1
 */