package com.tencent.mobileqq.kandian.glue.report;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.qphone.base.util.QLog;

final class RIJKanDianTabReport$5
  implements Runnable
{
  RIJKanDianTabReport$5(long paramLong) {}
  
  public void run()
  {
    PublicAccountReportUtils.a((QQAppInterface)ReadInJoyUtils.b(), "CliOper", "", "", "0X80066F7", "0X80066F7", 1, 1, Long.toString(this.a / 1000L), "", "", RIJTransMergeKanDianReport.c(), false);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("report ReadinjoyTabFrame use time: ");
      localStringBuilder.append(this.a / 1000L);
      QLog.d("Q.readinjoy.4tab", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.report.RIJKanDianTabReport.5
 * JD-Core Version:    0.7.0.1
 */