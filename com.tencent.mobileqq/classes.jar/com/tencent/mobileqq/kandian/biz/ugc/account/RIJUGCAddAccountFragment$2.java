package com.tencent.mobileqq.kandian.biz.ugc.account;

import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;

final class RIJUGCAddAccountFragment$2
  implements Runnable
{
  public void run()
  {
    try
    {
      PublicAccountReportUtils.a(null, "CliOper", "", "", "0X800AF12", "0X800AF12", 0, 0, "", "", "", RIJTransMergeKanDianReport.g().addString("uin", RIJQQAppInterfaceUtil.d()).build(), false);
      return;
    }
    catch (JSONException localJSONException)
    {
      String str = RIJUGCAddAccountFragment.d();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[deliverTipsExposureReport] error, e = ");
      localStringBuilder.append(localJSONException);
      QLog.e(str, 1, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.account.RIJUGCAddAccountFragment.2
 * JD-Core Version:    0.7.0.1
 */