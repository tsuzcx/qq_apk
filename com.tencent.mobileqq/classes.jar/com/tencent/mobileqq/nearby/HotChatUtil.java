package com.tencent.mobileqq.nearby;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.NearbyFlowerManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.service.message.MessageCacheItem;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;

public class HotChatUtil
{
  public static Drawable a(Resources paramResources, int paramInt)
  {
    Drawable localDrawable = null;
    if (paramInt == 0) {
      localDrawable = TroopUtils.a(paramResources, paramResources.getColor(2131493732));
    }
    while (paramInt != 1) {
      return localDrawable;
    }
    return TroopUtils.a(paramResources, paramResources.getColor(2131493733));
  }
  
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    case 3: 
    case 6: 
    case 7: 
    case 8: 
    default: 
      return "加入热聊失败，请稍后再试。";
    case 2: 
      return "该热聊不存在，换个热聊试试吧。";
    case 4: 
      return "你的帐号近期有不良记录，暂时无法加入热聊。";
    case 5: 
      return "该热聊已经满员，换个热聊试试吧。";
    }
    return "你已被移出本热聊房间，无法加入。";
  }
  
  public static void a(Context paramContext, QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    Object localObject2 = null;
    int k = 0;
    if ((paramContext == null) || (paramQQAppInterface == null) || (paramString1 == null) || (paramString1.length() == 0) || (paramString2 == null) || (paramString2.length() == 0)) {
      return;
    }
    boolean bool = paramString2.equals(paramQQAppInterface.getCurrentAccountUin());
    Object localObject1;
    int i;
    if (!bool)
    {
      localObject1 = (FriendsManager)paramQQAppInterface.getManager(50);
      if ((localObject1 != null) && (((FriendsManager)localObject1).b(paramString2))) {
        i = 1;
      }
    }
    for (;;)
    {
      HotChatManager localHotChatManager = paramQQAppInterface.a(false);
      if (localHotChatManager != null)
      {
        HotChatInfo localHotChatInfo = localHotChatManager.a(paramString1);
        localObject1 = localHotChatInfo;
        paramQQAppInterface = localObject2;
        if (localHotChatInfo != null)
        {
          paramQQAppInterface = localHotChatInfo.troopCode;
          localObject1 = localHotChatInfo;
        }
      }
      for (;;)
      {
        int j = k;
        if (localHotChatManager != null)
        {
          j = k;
          if (((HotChatInfo)localObject1).isGameRoom) {
            j = 1;
          }
        }
        if ((bool) || (i == 0))
        {
          if ((localObject1 != null) && (((HotChatInfo)localObject1).isBuLuoHotChat()))
          {
            i = 86;
            label173:
            paramString2 = new ProfileActivity.AllInOne(paramString2, i);
            paramString2.h = 33;
            paramString2.d = paramString1;
            paramString2.c = paramQQAppInterface;
            paramQQAppInterface = new Intent(paramContext, NearbyPeopleProfileActivity.class);
            paramQQAppInterface.putExtra("AllInOne", paramString2);
            if (!bool) {
              break label268;
            }
          }
          label268:
          for (i = 2;; i = 3)
          {
            paramQQAppInterface.putExtra("param_mode", i);
            if (j != 0) {
              paramQQAppInterface.putExtra("is_from_werewolves", true);
            }
            paramContext.startActivity(paramQQAppInterface);
            return;
            i = 0;
            break;
            i = 42;
            break label173;
          }
        }
        paramString2 = new ProfileActivity.AllInOne(paramString2, 20);
        paramString2.a = 20;
        paramString2.d = paramString1;
        paramString2.c = paramQQAppInterface;
        if (j != 0) {}
        for (i = 113;; i = 4)
        {
          paramString2.h = i;
          ProfileActivity.b(paramContext, paramString2);
          return;
        }
        localObject1 = null;
        paramQQAppInterface = localObject2;
      }
      i = 0;
    }
  }
  
  public static void a(TextView paramTextView, int paramInt)
  {
    if (paramTextView == null) {}
    Drawable localDrawable;
    do
    {
      return;
      localDrawable = a(BaseApplication.getContext().getResources(), paramInt);
    } while (localDrawable == null);
    paramTextView.setBackgroundDrawable(localDrawable);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString) {}
  
  public static void a(HotChatInfo paramHotChatInfo, QQAppInterface paramQQAppInterface, Activity paramActivity, int paramInt)
  {
    Intent localIntent = new Intent(paramActivity, QQBrowserActivity.class);
    localIntent.putExtra("url", URLUtil.a(URLUtil.a(URLUtil.a(URLUtil.a(URLUtil.a("http://nearby.qq.com/hot_chat/member_list.html?_wv=3&_bid=2581", "_wv", "3"), "_bid", "2581"), "gc", paramHotChatInfo.troopUin), "rid", paramHotChatInfo.uuid), "from", String.valueOf(0)));
    paramHotChatInfo = new Bundle();
    paramHotChatInfo.putBoolean("hide_left_button", true);
    localIntent.putExtras(paramHotChatInfo);
    paramActivity.startActivity(localIntent);
    if (paramInt == 0) {
      NearbyFlowerManager.a(paramQQAppInterface, "0X800638B");
    }
    while (paramInt != 1) {
      return;
    }
    NearbyFlowerManager.a(paramQQAppInterface, "0X800638C");
  }
  
  public static void a(MessageCacheItem paramMessageCacheItem, long paramLong, String paramString, int paramInt)
  {
    boolean bool;
    switch (paramInt)
    {
    default: 
      bool = false;
    }
    for (;;)
    {
      if (bool) {
        paramMessageCacheItem.a(0, paramString, paramLong, 1);
      }
      if (QLog.isColorLevel()) {
        NearbyUtils.a("PttShow", new Object[] { "addLocalMaxMsgSeq", String.format("needUpdateLocal:%b\tfrom:%d\t msgSeq:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt), Long.valueOf(paramLong) }) });
      }
      return;
      long l = paramMessageCacheItem.a(0, paramString);
      if (1L + l == paramLong)
      {
        bool = true;
      }
      else
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        NearbyUtils.a("PttShow", new Object[] { "addLocalMaxMsgSeq", String.format("not continuous seq local:%d\tmsgseq:%d\tfrom:%d", new Object[] { Long.valueOf(l), Long.valueOf(paramLong), Integer.valueOf(paramInt) }) });
        bool = false;
        continue;
        bool = true;
      }
    }
  }
  
  public static boolean a(int paramInt, String paramString)
  {
    if (paramInt == 1) {
      return ((HotChatManager)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(59)).b(paramString);
    }
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, RecentUser paramRecentUser)
  {
    boolean bool = true;
    if ((paramQQAppInterface == null) || (paramRecentUser == null) || (paramRecentUser.type != 1) || (TextUtils.isEmpty(paramRecentUser.uin))) {
      bool = false;
    }
    do
    {
      return bool;
      if ((paramRecentUser.lFlag & 1L) == 0L)
      {
        paramQQAppInterface = paramQQAppInterface.a(false);
        if ((paramQQAppInterface != null) && (paramQQAppInterface.b(paramRecentUser.uin))) {
          paramRecentUser.lFlag |= 1L;
        }
      }
    } while ((paramRecentUser.lFlag & 1L) == 1L);
    return false;
  }
  
  public static boolean a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord.istroop == 1) {
      return ((HotChatManager)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(59)).b(paramMessageRecord.frienduin);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.HotChatUtil
 * JD-Core Version:    0.7.0.1
 */