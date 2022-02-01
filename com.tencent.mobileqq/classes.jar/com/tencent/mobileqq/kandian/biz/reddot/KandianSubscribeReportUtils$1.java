package com.tencent.mobileqq.kandian.biz.reddot;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;

final class KandianSubscribeReportUtils$1
  implements Runnable
{
  KandianSubscribeReportUtils$1(MessageRecord paramMessageRecord) {}
  
  public void run()
  {
    this.a.extLong = 0;
    ((QQAppInterface)ReadInJoyUtils.b()).getMessageFacade().a(this.a.frienduin, this.a.istroop, this.a.uniseq, "extLong", Integer.valueOf(this.a.extLong));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.reddot.KandianSubscribeReportUtils.1
 * JD-Core Version:    0.7.0.1
 */