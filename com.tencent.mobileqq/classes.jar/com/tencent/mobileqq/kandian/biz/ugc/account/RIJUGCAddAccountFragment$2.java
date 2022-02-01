package com.tencent.mobileqq.kandian.biz.ugc.account;

import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;

final class RIJUGCAddAccountFragment$2
  implements Runnable
{
  public void run()
  {
    try
    {
      String str1 = RIJTransMergeKanDianReport.a().addString("uin", RIJQQAppInterfaceUtil.a()).build();
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X800AF12", "0X800AF12", 0, 0, "", "", "", str1, false);
      return;
    }
    catch (JSONException localJSONException)
    {
      String str2 = RIJUGCAddAccountFragment.b();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[deliverTipsExposureReport] error, e = ");
      localStringBuilder.append(localJSONException);
      QLog.e(str2, 1, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.account.RIJUGCAddAccountFragment.2
 * JD-Core Version:    0.7.0.1
 */