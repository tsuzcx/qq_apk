package com.tencent.mobileqq.service.message;

import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.MsgProxyUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class FriendShieldUtils
{
  public static void a(AppInterface paramAppInterface, String paramString)
  {
    String str1 = paramAppInterface.getCurrentAccountUin();
    String str2 = HardCodeUtil.a(2131706699);
    long l = MessageCache.a();
    MessageRecord localMessageRecord = MessageRecordFactory.a(-2012);
    localMessageRecord.init(str1, paramString, str1, str2, l, 0, 0, l);
    localMessageRecord.msgtype = -2012;
    int j = 1;
    localMessageRecord.isread = true;
    paramString = ((IMessageFacade)paramAppInterface.getRuntimeService(IMessageFacade.class, "")).getMsgList(paramString, 0);
    int i;
    if ((paramString != null) && (paramString.size() > 0) && (MsgProxyUtils.a((MessageRecord)paramString.get(paramString.size() - 1), localMessageRecord, false)))
    {
      i = j;
      if (QLog.isColorLevel())
      {
        QLog.w("MessageUtils", 2, "inserShieldTipsForFriends filtered!");
        i = j;
      }
    }
    else
    {
      i = 0;
    }
    if (i == 0) {
      ((IMessageFacade)paramAppInterface.getRuntimeService(IMessageFacade.class, "")).addMessage(localMessageRecord, str1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.FriendShieldUtils
 * JD-Core Version:    0.7.0.1
 */