package com.tencent.mobileqq.kandian.glue.businesshandler.engine;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.service.message.MessageRecordFactory;

class KandianSubscribeManager$4
  implements Runnable
{
  KandianSubscribeManager$4(KandianSubscribeManager paramKandianSubscribeManager, String paramString1, long paramLong, String paramString2) {}
  
  public void run()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)ReadInJoyUtils.b();
    if (localQQAppInterface == null) {
      return;
    }
    MessageRecord localMessageRecord2 = localQQAppInterface.getMessageFacade().r(AppConstants.KANDIAN_SUBSCRIBE_UIN, 1008);
    MessageRecord localMessageRecord1;
    if (localMessageRecord2 != null)
    {
      localMessageRecord1 = MessageRecordFactory.a(-1000);
      MessageRecord.copyMessageRecordBaseField(localMessageRecord1, localMessageRecord2);
      localMessageRecord1.msgtype = -1000;
    }
    else
    {
      localMessageRecord1 = MessageRecordFactory.a(-1000);
      localMessageRecord1.selfuin = localQQAppInterface.getCurrentAccountUin();
    }
    KandianSubscribeManager.a(localMessageRecord1, this.a, this.b, this.c);
    localQQAppInterface.getMessageFacade().a(localMessageRecord1, localQQAppInterface.getCurrentUin());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianSubscribeManager.4
 * JD-Core Version:    0.7.0.1
 */