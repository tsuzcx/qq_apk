package com.tencent.mobileqq.service.message;

import com.tencent.imcore.message.MsgProxyUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class FriendShieldUtils
{
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    int j = 0;
    String str1 = paramQQAppInterface.getCurrentAccountUin();
    String str2 = HardCodeUtil.a(2131706677);
    long l = MessageCache.a();
    MessageRecord localMessageRecord = MessageRecordFactory.a(-2012);
    localMessageRecord.init(str1, paramString, str1, str2, l, 0, 0, l);
    localMessageRecord.msgtype = -2012;
    localMessageRecord.isread = true;
    paramString = paramQQAppInterface.getMessageFacade().b(paramString, 0);
    int i = j;
    if (paramString != null)
    {
      i = j;
      if (paramString.size() > 0)
      {
        i = j;
        if (MsgProxyUtils.a((MessageRecord)paramString.get(paramString.size() - 1), localMessageRecord, false))
        {
          if (QLog.isColorLevel()) {
            QLog.w("MessageUtils", 2, "inserShieldTipsForFriends filtered!");
          }
          i = 1;
        }
      }
    }
    if (i == 0) {
      paramQQAppInterface.getMessageFacade().a(localMessageRecord, str1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.FriendShieldUtils
 * JD-Core Version:    0.7.0.1
 */