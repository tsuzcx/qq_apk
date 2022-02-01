package com.tencent.mobileqq.structmsg;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;

class AbsStructMsgElement$1
  implements Runnable
{
  AbsStructMsgElement$1(AbsStructMsgElement paramAbsStructMsgElement1, AbsStructMsgElement paramAbsStructMsgElement2, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    long l = NetConnInfoCenter.getServerTime();
    int j = -1;
    int i = j;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsgElement.aa)) {}
    try
    {
      i = Integer.parseInt(this.this$0.aa);
      if (PublicAccountChatPie.a(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsgElement.ab, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
      {
        j = 1;
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsgElement.ab, "0X80055C7", "0X80055C7", i, 0, Long.toString(l), Long.toString(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsgElement.a), this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsgElement.c, Integer.toString(j), false);
        return;
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        i = j;
        continue;
        j = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.AbsStructMsgElement.1
 * JD-Core Version:    0.7.0.1
 */