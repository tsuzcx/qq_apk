package com.tencent.mobileqq.nearby.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.NearbyFlowerManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.hotchat.app.HotChatHandler;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.service.message.MessageCacheItem;
import com.tencent.mobileqq.troop.utils.BizTroopUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;

public class HotChatUtil
{
  public static Drawable a(Resources paramResources, int paramInt)
  {
    if (paramInt == 0) {
      return BizTroopUtil.a(paramResources, paramResources.getColor(2131167002));
    }
    if (paramInt == 1) {
      return BizTroopUtil.a(paramResources, paramResources.getColor(2131167000));
    }
    return null;
  }
  
  public static String a(int paramInt)
  {
    String str = HotChatHandler.JOIN_HOT_CHAT_FAIL;
    if (paramInt != 2)
    {
      if (paramInt != 9)
      {
        if (paramInt != 4)
        {
          if (paramInt != 5) {
            return HotChatHandler.JOIN_HOT_CHAT_FAIL;
          }
          return HardCodeUtil.a(2131903574);
        }
        return HardCodeUtil.a(2131903573);
      }
      return HardCodeUtil.a(2131903576);
    }
    return HardCodeUtil.a(2131903575);
  }
  
  public static void a(Context paramContext, QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    if ((paramContext != null) && (paramQQAppInterface != null) && (paramString1 != null) && (paramString1.length() != 0) && (paramString2 != null))
    {
      if (paramString2.length() == 0) {
        return;
      }
      boolean bool = paramString2.equals(paramQQAppInterface.getCurrentAccountUin());
      int k = 0;
      Object localObject;
      if (!bool)
      {
        localObject = (FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
        if ((localObject != null) && (((FriendsManager)localObject).n(paramString2)))
        {
          j = 1;
          break label84;
        }
      }
      int j = 0;
      label84:
      HotChatManager localHotChatManager = paramQQAppInterface.getHotChatMng(false);
      paramQQAppInterface = null;
      if (localHotChatManager != null)
      {
        HotChatInfo localHotChatInfo = localHotChatManager.c(paramString1);
        localObject = localHotChatInfo;
        if (localHotChatInfo != null)
        {
          paramQQAppInterface = localHotChatInfo.troopCode;
          localObject = localHotChatInfo;
        }
      }
      else
      {
        localObject = null;
      }
      int i = k;
      if (localHotChatManager != null)
      {
        i = k;
        if (((HotChatInfo)localObject).isGameRoom) {
          i = 1;
        }
      }
      if ((!bool) && (j != 0))
      {
        paramString2 = new AllInOne(paramString2, 20);
        paramString2.pa = 20;
        paramString2.troopUin = paramString1;
        paramString2.troopCode = paramQQAppInterface;
        if (i != 0) {
          i = 113;
        } else {
          i = 4;
        }
        paramString2.profileEntryType = i;
        ProfileUtils.openProfileCard(paramContext, paramString2);
        return;
      }
      if ((localObject != null) && (((HotChatInfo)localObject).isBuLuoHotChat())) {
        j = 86;
      } else {
        j = 42;
      }
      paramContext = new AllInOne(paramString2, j);
      paramContext.profileEntryType = 33;
      paramContext.troopUin = paramString1;
      paramContext.troopCode = paramQQAppInterface;
      paramQQAppInterface = new Intent();
      paramQQAppInterface.putExtra("AllInOne", paramContext);
      if (bool) {
        j = 2;
      } else {
        j = 3;
      }
      paramQQAppInterface.putExtra("param_mode", j);
      if (i != 0) {
        paramQQAppInterface.putExtra("is_from_werewolves", true);
      }
      RouteUtils.a(BaseApplicationImpl.getContext(), paramQQAppInterface, "/nearby/people/profile");
    }
  }
  
  public static void a(TextView paramTextView, int paramInt)
  {
    if (paramTextView == null) {
      return;
    }
    Drawable localDrawable = a(BaseApplication.getContext().getResources(), paramInt);
    if (localDrawable != null) {
      paramTextView.setBackgroundDrawable(localDrawable);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString) {}
  
  public static void a(HotChatInfo paramHotChatInfo, QQAppInterface paramQQAppInterface, Activity paramActivity, int paramInt)
  {
    Intent localIntent = new Intent(paramActivity, QQBrowserActivity.class);
    localIntent.putExtra("url", URLUtil.a(URLUtil.a(URLUtil.a(URLUtil.a(URLUtil.a("https://nearby.qq.com/hot_chat/member_list.html?_wv=3&_bid=2581", "_wv", "3"), "_bid", "2581"), "gc", paramHotChatInfo.troopUin), "rid", paramHotChatInfo.uuid), "from", String.valueOf(0)));
    paramHotChatInfo = new Bundle();
    paramHotChatInfo.putBoolean("hide_left_button", true);
    localIntent.putExtras(paramHotChatInfo);
    paramActivity.startActivity(localIntent);
    if (paramInt == 0)
    {
      NearbyFlowerManager.a(paramQQAppInterface, "0X800638B");
      return;
    }
    if (paramInt == 1) {
      NearbyFlowerManager.a(paramQQAppInterface, "0X800638C");
    }
  }
  
  public static void a(MessageCacheItem paramMessageCacheItem, long paramLong, String paramString, int paramInt)
  {
    if ((paramInt != 1) && (paramInt != 2))
    {
      if (paramInt == 3)
      {
        bool = true;
        break label108;
      }
    }
    else
    {
      long l = paramMessageCacheItem.b(0, paramString);
      if (1L + l == paramLong)
      {
        bool = true;
        break label108;
      }
      if (QLog.isColorLevel()) {
        NearbyUtils.a("PttShow", new Object[] { "addLocalMaxMsgSeq", String.format("not continuous seq local:%d    msgseq:%d    from:%d", new Object[] { Long.valueOf(l), Long.valueOf(paramLong), Integer.valueOf(paramInt) }) });
      }
    }
    boolean bool = false;
    label108:
    if (bool) {
      paramMessageCacheItem.a(0, paramString, paramLong, 1);
    }
    if (QLog.isColorLevel()) {
      NearbyUtils.a("PttShow", new Object[] { "addLocalMaxMsgSeq", String.format("needUpdateLocal:%b    from:%d     msgSeq:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt), Long.valueOf(paramLong) }) });
    }
  }
  
  public static boolean a(int paramInt, String paramString)
  {
    if (paramInt == 1) {
      return ((HotChatManager)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(QQManagerFactory.HOT_CHAT_MANAGER)).b(paramString);
    }
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, RecentUser paramRecentUser)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramQQAppInterface != null)
    {
      bool1 = bool2;
      if (paramRecentUser != null)
      {
        bool1 = bool2;
        if (paramRecentUser.getType() == 1)
        {
          if (TextUtils.isEmpty(paramRecentUser.uin)) {
            return false;
          }
          if ((paramRecentUser.lFlag & 1L) == 0L)
          {
            paramQQAppInterface = paramQQAppInterface.getHotChatMng(false);
            if ((paramQQAppInterface != null) && (paramQQAppInterface.b(paramRecentUser.uin))) {
              paramRecentUser.lFlag |= 1L;
            }
          }
          bool1 = bool2;
          if ((paramRecentUser.lFlag & 1L) == 1L) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public static boolean a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord.istroop == 1) {
      return ((HotChatManager)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(QQManagerFactory.HOT_CHAT_MANAGER)).b(paramMessageRecord.frienduin);
    }
    return false;
  }
  
  public static boolean b(int paramInt)
  {
    return (paramInt == 1281) || (paramInt == 1287);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.api.HotChatUtil
 * JD-Core Version:    0.7.0.1
 */