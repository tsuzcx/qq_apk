package com.tencent.mobileqq.kandian.glue.report;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;

final class KandianDailyReportUtils$1
  implements Runnable
{
  KandianDailyReportUtils$1(MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    this.a.extLong = 0;
    this.b.getMessageFacade().a(this.a.frienduin, this.a.istroop, this.a.uniseq, "extLong", Integer.valueOf(this.a.extLong));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.report.KandianDailyReportUtils.1
 * JD-Core Version:    0.7.0.1
 */