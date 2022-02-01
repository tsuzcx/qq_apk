package com.tencent.mobileqq.structmsg;

import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;

class StructMsgForImageShare$1$1
  implements Runnable
{
  StructMsgForImageShare$1$1(StructMsgForImageShare.1 param1, StructMsgForImageShare paramStructMsgForImageShare, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    long l = NetConnInfoCenter.getServerTime();
    PublicAccountChatPie.a(this.a.uin, this.b);
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.b, "CliOper", "", this.a.uin, "0X80055C7", "0X80055C7", 0, 0, Long.toString(l), Long.toString(this.a.msgId), this.a.mMsgAction, Integer.toString(this.a.mPromotionType), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.StructMsgForImageShare.1.1
 * JD-Core Version:    0.7.0.1
 */