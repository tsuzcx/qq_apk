package com.tencent.mobileqq.kandian.biz.account;

import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.qroute.QRoute;

class RIJUserLevelDialog$2
  implements Runnable
{
  RIJUserLevelDialog$2(RIJUserLevelDialog paramRIJUserLevelDialog, String paramString) {}
  
  public void run()
  {
    IPublicAccountReportUtils localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
    String str = this.a;
    localIPublicAccountReportUtils.publicAccountReportClickEvent(null, "", str, str, 0, 0, RIJQQAppInterfaceUtil.a(), "", "", "", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.account.RIJUserLevelDialog.2
 * JD-Core Version:    0.7.0.1
 */