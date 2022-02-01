package com.tencent.mobileqq.troop.navigatebar;

import android.support.annotation.Nullable;
import com.tencent.mobileqq.activity.recent.msg.AbstructRecentUserMsg;
import com.tencent.mobileqq.activity.recent.msg.RecentUserManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.nearby.api.INearbyFlowerUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.data.MessageInfo;
import com.tencent.mobileqq.troop.data.MessageNavInfo;
import com.tencent.mobileqq.troop.data.TroopAioAgent.Message;
import com.tencent.qphone.base.util.QLog;

public class TroopAioMsgNavigateUpdateMsgInfoUtil
{
  private static int a(int paramInt, MessageRecord paramMessageRecord)
  {
    boolean bool = ((INearbyFlowerUtil)QRoute.api(INearbyFlowerUtil.class)).isNearbyFlowerMsg(paramMessageRecord);
    int j = -1;
    int i;
    if (paramInt != 26)
    {
      i = 0;
    }
    else
    {
      if ((paramMessageRecord.msgtype == -2035) || (paramMessageRecord.msgtype == -2038) || (bool))
      {
        if (!bool) {
          break label95;
        }
        if ((paramMessageRecord instanceof MessageForStructing))
        {
          i = ((INearbyFlowerUtil)QRoute.api(INearbyFlowerUtil.class)).getFlowerCount((MessageForStructing)paramMessageRecord);
          break label110;
        }
      }
      label95:
      while (!(paramMessageRecord instanceof MessageForDeliverGiftTips))
      {
        i = -1;
        break;
      }
      i = ((MessageForDeliverGiftTips)paramMessageRecord).giftCount;
    }
    label110:
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getFlowersCounts, bizType = ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", isNearbyFlowerMsg = ");
      localStringBuilder.append(bool);
      localStringBuilder.append(", msgType = ");
      paramInt = j;
      if (paramMessageRecord != null) {
        paramInt = paramMessageRecord.msgtype;
      }
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", flowersCount = ");
      localStringBuilder.append(i);
      QLog.d("Navigate.UpdateMsgInfoUtil", 2, localStringBuilder.toString());
    }
    return i;
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
    int i;
    if (paramBoolean) {
      i = 1;
    } else {
      i = 3000;
    }
    return TroopAioNavigateBarManager.a(paramString, i);
  }
  
  private static void a(QQAppInterface paramQQAppInterface, String paramString, MessageInfo paramMessageInfo, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    int j = paramMessageInfo.a(paramBoolean);
    int i = a(j, paramMessageRecord);
    if (((!paramBoolean) && (!MessageNavInfo.a(j))) || (i == -1))
    {
      if (QLog.isColorLevel())
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("isTroop = ");
        paramQQAppInterface.append(paramBoolean);
        paramQQAppInterface.append(", bizType = ");
        paramQQAppInterface.append(j);
        paramQQAppInterface.append(", flowers = ");
        paramQQAppInterface.append(i);
        paramQQAppInterface.append(", troopCode = ");
        paramQQAppInterface.append(paramString);
        paramQQAppInterface.append(", isTroop = ");
        paramQQAppInterface.append(paramBoolean);
        QLog.d("Navigate.UpdateMsgInfoUtil", 2, paramQQAppInterface.toString());
      }
      return;
    }
    paramString = a(paramString, paramBoolean);
    j = NavConstants.b(j);
    if (j != 102) {
      paramMessageRecord = null;
    }
    long l = TroopAioAgent.Message.a(j, paramMessageInfo.a.a, paramMessageInfo.a.b);
    ((TroopAioNavigateBarManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_AIO_NAVIGATE_BAR)).a(paramString, j, paramMessageInfo.a.a, l, "", i, paramMessageRecord);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.navigatebar.TroopAioMsgNavigateUpdateMsgInfoUtil
 * JD-Core Version:    0.7.0.1
 */