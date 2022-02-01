package com.tencent.mobileqq.troop.blocktroop;

import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.core.GetUnreadMsgNumCallback;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.ConversationInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qphone.base.util.QLog;

public class TroopUnreadMsgNumCallback
  implements GetUnreadMsgNumCallback
{
  public int a(String paramString, StringBuilder paramStringBuilder, AppInterface paramAppInterface)
  {
    return 0;
  }
  
  public boolean a(ConversationInfo paramConversationInfo)
  {
    return false;
  }
  
  public boolean a(ConversationInfo paramConversationInfo, boolean[] paramArrayOfBoolean, AppInterface paramAppInterface)
  {
    if (paramConversationInfo.type == 1)
    {
      paramAppInterface = (QQAppInterface)paramAppInterface;
      if (paramAppInterface == null) {
        return false;
      }
      Object localObject = paramAppInterface.getProxyManager().a().b(paramConversationInfo.uin, paramConversationInfo.type);
      if ((localObject != null) && ((((RecentUser)localObject).lFlag & 1L) != 0L))
      {
        localObject = paramAppInterface.getHotChatMng(true);
        if ((localObject != null) && (!((HotChatManager)localObject).b(paramConversationInfo.uin)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("TroopBlockUnreadMsgNumCallback", 2, "getUnreadMsgsNum invalide hotchat!");
          }
          paramArrayOfBoolean[0] = true;
          return true;
        }
      }
      if (TroopBlockUtils.a(paramAppInterface, paramConversationInfo.uin))
      {
        paramArrayOfBoolean[0] = true;
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.blocktroop.TroopUnreadMsgNumCallback
 * JD-Core Version:    0.7.0.1
 */