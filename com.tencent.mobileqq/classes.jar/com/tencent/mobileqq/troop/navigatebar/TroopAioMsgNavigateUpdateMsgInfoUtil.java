package com.tencent.mobileqq.troop.navigatebar;

import android.support.annotation.Nullable;
import com.tencent.mobileqq.activity.recent.msg.AbstructRecentUserMsg;
import com.tencent.mobileqq.activity.recent.msg.RecentUserManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.nearby.NearbyFlowerUtil;
import com.tencent.mobileqq.troop.data.MessageInfo;
import com.tencent.mobileqq.troop.data.MessageNavInfo;
import com.tencent.mobileqq.troop.data.TroopAioAgent.Message;
import com.tencent.qphone.base.util.QLog;

public class TroopAioMsgNavigateUpdateMsgInfoUtil
{
  private static int a(int paramInt, MessageRecord paramMessageRecord)
  {
    int j = -1;
    boolean bool = NearbyFlowerUtil.a(paramMessageRecord);
    int i;
    if (paramInt != 27) {
      i = 0;
    }
    for (;;)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder().append("getFlowersCounts, bizType = ").append(paramInt).append(", isNearbyFlowerMsg = ").append(bool).append(", msgType = ");
        paramInt = j;
        if (paramMessageRecord != null) {
          paramInt = paramMessageRecord.msgtype;
        }
        QLog.d("Navigate.UpdateMsgInfoUtil", 2, paramInt + ", flowersCount = " + i);
      }
      return i;
      if ((paramMessageRecord.msgtype != -2035) && (paramMessageRecord.msgtype != -2038) && (!bool))
      {
        i = -1;
      }
      else
      {
        if (bool)
        {
          if ((paramMessageRecord instanceof MessageForStructing)) {
            i = NearbyFlowerUtil.a((MessageForStructing)paramMessageRecord);
          }
        }
        else
        {
          if ((paramMessageRecord instanceof MessageForDeliverGiftTips))
          {
            i = ((MessageForDeliverGiftTips)paramMessageRecord).giftCount;
            continue;
          }
          i = -1;
          continue;
        }
        i = -1;
      }
    }
  }
  
  @Nullable
  private static Object a(QQAppInterface paramQQAppInterface, MessageInfo paramMessageInfo, Object paramObject, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    int i = paramMessageInfo.a(paramBoolean);
    if ((!paramBoolean) && (!MessageNavInfo.a(i))) {
      return null;
    }
    AbstructRecentUserMsg localAbstructRecentUserMsg = ((RecentUserManager)paramQQAppInterface.getManager(QQManagerFactory.RECENT_USER)).a(i);
    if (localAbstructRecentUserMsg != null) {
      return localAbstructRecentUserMsg.a(i, paramMessageInfo, paramObject, paramMessageRecord, paramQQAppInterface);
    }
    return null;
  }
  
  @Nullable
  public static Object a(QQAppInterface paramQQAppInterface, String paramString, MessageInfo paramMessageInfo, Object paramObject, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    a(paramQQAppInterface, paramString, paramMessageInfo, paramMessageRecord, paramBoolean);
    return a(paramQQAppInterface, paramMessageInfo, paramObject, paramMessageRecord, paramBoolean);
  }
  
  private static String a(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 3000) {
      return TroopAioNavigateBarManager.a(paramString, i);
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, String paramString, MessageInfo paramMessageInfo, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    int j = paramMessageInfo.a(paramBoolean);
    int i = a(j, paramMessageRecord);
    if (((!paramBoolean) && (!MessageNavInfo.a(j))) || (i == -1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Navigate.UpdateMsgInfoUtil", 2, "isTroop = " + paramBoolean + ", bizType = " + j + ", flowers = " + i + ", troopCode = " + paramString + ", isTroop = " + paramBoolean);
      }
      return;
    }
    String str = a(paramString, paramBoolean);
    j = NavConstants.b(j);
    paramString = null;
    if (j == 102) {
      paramString = paramMessageRecord;
    }
    long l = TroopAioAgent.Message.a(j, paramMessageInfo.a.a, paramMessageInfo.a.b);
    ((TroopAioNavigateBarManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_AIO_NAVIGATE_BAR)).a(str, j, paramMessageInfo.a.a, l, "", i, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.navigatebar.TroopAioMsgNavigateUpdateMsgInfoUtil
 * JD-Core Version:    0.7.0.1
 */