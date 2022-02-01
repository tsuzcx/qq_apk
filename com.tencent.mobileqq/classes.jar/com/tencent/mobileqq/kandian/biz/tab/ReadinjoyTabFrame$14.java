package com.tencent.mobileqq.kandian.biz.tab;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

class ReadinjoyTabFrame$14
  implements Runnable
{
  public void run()
  {
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate((QQAppInterface)RIJQQAppInterfaceUtil.a(), "CliOper", "", "", "0X80066F7", "0X80066F7", 1, 1, Long.toString(this.a / 1000L), "", "", RIJTransMergeKanDianReport.b(), false);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("report ReadinjoyTabFrame use time: ");
      localStringBuilder.append(this.a / 1000L);
      QLog.d("Q.readinjoy.4tab", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.tab.ReadinjoyTabFrame.14
 * JD-Core Version:    0.7.0.1
 */