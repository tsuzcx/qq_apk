package com.tencent.mobileqq.profile;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.biz.webviewplugin.NewReportPlugin;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberCard;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.profilecard.api.IProfileCardApi;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.troop.data.TroopRankConfig;
import com.tencent.mobileqq.troop.data.TroopRankConfig.TroopRankItem;
import com.tencent.mobileqq.troop.homework.api.IHWTroopUtilsApi;
import com.tencent.mobileqq.troop.robot.api.IRobotUtilApi;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

public class TroopMemberCardUtils
{
  public static int a(TroopInfo paramTroopInfo, String paramString)
  {
    int j = 1;
    int i = j;
    if (paramTroopInfo != null)
    {
      if ((paramTroopInfo.troopowneruin != null) && (paramTroopInfo.troopowneruin.equalsIgnoreCase(paramString))) {
        return 3;
      }
      i = j;
      if (paramTroopInfo.Administrator != null)
      {
        i = j;
        if (paramTroopInfo.Administrator.contains(paramString)) {
          i = 2;
        }
      }
    }
    return i;
  }
  
  public static String a(int paramInt)
  {
    if (paramInt == 3) {
      return "0";
    }
    if (paramInt == 2) {
      return "1";
    }
    if (paramInt == 1) {
      return "2";
    }
    return "";
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, Card paramCard)
  {
    try
    {
      boolean bool = TextUtils.equals(paramString2, paramQQAppInterface.getCurrentAccountUin());
      if (bool)
      {
        paramQQAppInterface = paramQQAppInterface.getCurrentNickname();
      }
      else
      {
        Object localObject = (FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
        paramQQAppInterface = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
        Friends localFriends = ((FriendsManager)localObject).c(paramString2);
        localObject = paramQQAppInterface.g(paramString1, paramString2);
        paramQQAppInterface = "";
        paramString1 = paramQQAppInterface;
        if (localFriends != null)
        {
          paramString1 = paramQQAppInterface;
          if (localFriends.isFriend()) {
            paramString1 = localFriends.remark;
          }
          paramQQAppInterface = paramString1;
          if (TextUtils.isEmpty(paramString1)) {
            paramQQAppInterface = localFriends.name;
          }
          paramString1 = paramQQAppInterface;
          if (QLog.isColorLevel())
          {
            paramString1 = new StringBuilder();
            paramString1.append("getNickName, Friends!=null, remark=");
            paramString1.append(localFriends.remark);
            paramString1.append(" name=");
            paramString1.append(localFriends.name);
            QLog.i("troop_member_card", 2, paramString1.toString());
            paramString1 = paramQQAppInterface;
          }
        }
        paramQQAppInterface = paramString1;
        if (TextUtils.isEmpty(paramString1))
        {
          paramQQAppInterface = paramString1;
          if (localObject != null)
          {
            paramString1 = ((TroopMemberInfo)localObject).friendnick;
            paramQQAppInterface = paramString1;
            if (QLog.isColorLevel())
            {
              paramQQAppInterface = new StringBuilder();
              paramQQAppInterface.append("getNickName, TroopMemberInfo!=null, friendnick=");
              paramQQAppInterface.append(((TroopMemberInfo)localObject).friendnick);
              QLog.i("troop_member_card", 2, paramQQAppInterface.toString());
              paramQQAppInterface = paramString1;
            }
          }
        }
        if ((!TextUtils.isEmpty(paramQQAppInterface)) || (paramCard == null)) {
          break label355;
        }
        paramString1 = paramCard.strNick;
        paramQQAppInterface = paramString1;
        if (QLog.isColorLevel())
        {
          paramQQAppInterface = new StringBuilder();
          paramQQAppInterface.append("getNickName, mFriendCard!=null, strNick=");
          paramQQAppInterface.append(paramCard.strNick);
          QLog.i("troop_member_card", 2, paramQQAppInterface.toString());
          paramQQAppInterface = paramString1;
        }
      }
    }
    catch (Exception paramQQAppInterface)
    {
      label355:
      for (;;) {}
    }
    paramString1 = paramQQAppInterface;
    if (TextUtils.isEmpty(paramQQAppInterface)) {
      paramString1 = paramString2;
    }
    paramQQAppInterface = paramString1;
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("getNickName, nick=");
      paramQQAppInterface.append(paramString1);
      QLog.i("troop_member_card", 2, paramQQAppInterface.toString());
      return paramString1;
      paramQQAppInterface = paramString2;
    }
    return paramQQAppInterface;
  }
  
  public static void a(Context paramContext, QQAppInterface paramQQAppInterface, Intent paramIntent, int paramInt)
  {
    if ((paramContext != null) && (paramQQAppInterface != null))
    {
      if (paramIntent == null) {
        return;
      }
      String str2 = paramIntent.getStringExtra("memberUin");
      String str1 = paramIntent.getStringExtra("troopUin");
      if (TextUtils.isEmpty(str2)) {
        return;
      }
      Object localObject = ((FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).m(str2);
      TroopInfo localTroopInfo = ((TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).g(str1);
      AllInOne localAllInOne = null;
      paramQQAppInterface = null;
      if ((localObject != null) && (((Friends)localObject).isFriend()))
      {
        localAllInOne = new AllInOne(str2, 20);
        localAllInOne.nickname = ((Friends)localObject).name;
        localAllInOne.remark = ((Friends)localObject).remark;
        localAllInOne.troopCode = str1;
        if (localTroopInfo != null) {
          paramQQAppInterface = localTroopInfo.troopcode;
        }
        localAllInOne.troopUin = paramQQAppInterface;
        paramQQAppInterface = localAllInOne;
      }
      else
      {
        localObject = new AllInOne(str2, 21);
        ((AllInOne)localObject).troopCode = str1;
        paramQQAppInterface = localAllInOne;
        if (localTroopInfo != null) {
          paramQQAppInterface = localTroopInfo.troopcode;
        }
        ((AllInOne)localObject).troopUin = paramQQAppInterface;
        ((AllInOne)localObject).subSourceId = paramInt;
        paramQQAppInterface = (QQAppInterface)localObject;
      }
      paramQQAppInterface.reportExtra = NewReportPlugin.a(str1, 1);
      paramIntent.putExtra("AllInOne", paramQQAppInterface);
      paramContext.startActivity(paramIntent);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    if (((ITroopRobotService)paramQQAppInterface.getRuntimeService(ITroopRobotService.class, "all")).isRobotUin(paramString2))
    {
      ((IRobotUtilApi)QRoute.api(IRobotUtilApi.class)).openRobotProfileCard(paramContext, paramString1, paramString2);
      return;
    }
    a(paramQQAppInterface, paramContext, paramString1, paramString2, paramInt1, paramInt2, null);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2, Bundle paramBundle)
  {
    Friends localFriends = ((FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(paramString2);
    TroopInfo localTroopInfo = ((TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).a(paramString1, false, false);
    Object localObject = null;
    paramQQAppInterface = null;
    AllInOne localAllInOne;
    if ((localFriends != null) && (localFriends.isFriend()))
    {
      localAllInOne = new AllInOne(paramString2, 20);
      localAllInOne.nickname = localFriends.name;
      localAllInOne.remark = localFriends.remark;
      localAllInOne.troopCode = paramString1;
      if (localTroopInfo != null) {
        paramQQAppInterface = localTroopInfo.troopcode;
      }
      localAllInOne.troopUin = paramQQAppInterface;
      paramQQAppInterface = localAllInOne;
    }
    else
    {
      localAllInOne = new AllInOne(paramString2, 21);
      localAllInOne.troopCode = paramString1;
      paramQQAppInterface = localObject;
      if (localTroopInfo != null) {
        paramQQAppInterface = localTroopInfo.troopcode;
      }
      localAllInOne.troopUin = paramQQAppInterface;
      localAllInOne.subSourceId = 11;
      paramQQAppInterface = localAllInOne;
    }
    paramQQAppInterface.reportExtra = NewReportPlugin.a(paramString1, 1);
    paramQQAppInterface = ((IProfileCardApi)QRoute.api(IProfileCardApi.class)).getProfileCardIntentOnly(paramContext, paramQQAppInterface);
    paramQQAppInterface.putExtra("troopUin", paramString1);
    paramQQAppInterface.putExtra("memberUin", paramString2);
    paramQQAppInterface.putExtra("fromFlag", paramInt1);
    if (paramBundle != null) {
      paramQQAppInterface.putExtras(paramBundle);
    }
    if ((paramContext instanceof Activity))
    {
      ((Activity)paramContext).startActivityForResult(paramQQAppInterface, paramInt2);
      return;
    }
    paramQQAppInterface.setFlags(268435456);
    paramContext.startActivity(paramQQAppInterface);
  }
  
  public static boolean a(TroopInfo paramTroopInfo, TroopMemberCard paramTroopMemberCard, TextView paramTextView)
  {
    if ((paramTroopInfo != null) && (paramTroopMemberCard != null))
    {
      if (paramTextView == null) {
        return false;
      }
      boolean bool3 = TextUtils.isEmpty(paramTroopMemberCard.mUniqueTitle);
      boolean bool1;
      if (paramTroopMemberCard.memberRole == 3) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      boolean bool2;
      if (paramTroopMemberCard.memberRole == 2) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      boolean bool4 = paramTroopInfo.isQidianPrivateTroop();
      boolean bool5 = paramTroopInfo.isHomeworkTroop();
      String str = "";
      Object localObject;
      int i;
      if (bool4)
      {
        localObject = TroopRankConfig.a().a(bool1, bool2);
        if (localObject != null)
        {
          paramTroopMemberCard = ((TroopRankConfig.TroopRankItem)localObject).c;
          i = ((TroopRankConfig.TroopRankItem)localObject).b;
        }
        else
        {
          paramTroopMemberCard = "";
          i = 0;
        }
      }
      else
      {
        if ((bool5) && (!((IHWTroopUtilsApi)QRoute.api(IHWTroopUtilsApi.class)).hasHomeworkTroopIdentity(paramTroopMemberCard.titleId))) {
          return false;
        }
        TroopRankConfig.TroopRankItem localTroopRankItem = TroopRankConfig.a().a(paramTroopMemberCard.titleId, bool3 ^ true, bool1, bool2);
        if (localTroopRankItem != null)
        {
          localObject = localTroopRankItem.c;
          i = localTroopRankItem.b;
          if (localTroopRankItem.a == 302) {
            localObject = paramTroopMemberCard.mUniqueTitle;
          }
          if (localTroopRankItem.a == 315) {
            paramTroopMemberCard = (String)paramTroopInfo.getTroopLevelMap().get(Integer.valueOf(paramTroopMemberCard.realLevel));
          } else {
            paramTroopMemberCard = (TroopMemberCard)localObject;
          }
        }
        else if (paramTroopMemberCard.titleId == 315)
        {
          paramTroopMemberCard = (String)paramTroopInfo.getTroopLevelMap().get(Integer.valueOf(paramTroopMemberCard.realLevel));
          i = Color.parseColor("#8EBDF9");
        }
        else
        {
          paramTroopMemberCard = "";
          i = 0;
        }
      }
      int j;
      if (1 == paramTroopInfo.cGroupRankUserFlag) {
        j = 1;
      } else {
        j = 0;
      }
      if ((!SimpleUIUtil.e()) && (j != 0))
      {
        paramTroopInfo = paramTroopMemberCard;
      }
      else if (bool1)
      {
        paramTroopInfo = HardCodeUtil.a(2131917633);
      }
      else
      {
        paramTroopInfo = str;
        if (bool2) {
          paramTroopInfo = HardCodeUtil.a(2131917630);
        }
      }
      if (!TextUtils.isEmpty(paramTroopInfo))
      {
        paramTroopMemberCard = new StringBuilder();
        paramTroopMemberCard.append(" ");
        paramTroopMemberCard.append(paramTroopInfo);
        paramTroopMemberCard.append(" ");
        paramTextView.setText(paramTroopMemberCard.toString());
        TroopRankConfig.a(paramTextView, i);
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profile.TroopMemberCardUtils
 * JD-Core Version:    0.7.0.1
 */