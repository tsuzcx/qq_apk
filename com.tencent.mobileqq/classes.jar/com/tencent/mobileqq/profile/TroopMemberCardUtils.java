package com.tencent.mobileqq.profile;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberCard;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.troop.data.TroopRankConfig;
import com.tencent.mobileqq.troop.data.TroopRankConfig.TroopRankItem;
import com.tencent.mobileqq.troop.utils.HWTroopUtils;
import com.tencent.mobileqq.troop.utils.TroopLinkManager;
import com.tencent.mobileqq.troop.utils.TroopLinkManager.LinkParams;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class TroopMemberCardUtils
{
  public static int a(TroopInfo paramTroopInfo, String paramString)
  {
    int j = 1;
    int i = j;
    if (paramTroopInfo != null)
    {
      if ((paramTroopInfo.troopowneruin == null) || (!paramTroopInfo.troopowneruin.equalsIgnoreCase(paramString))) {
        break label30;
      }
      i = 3;
    }
    label30:
    do
    {
      do
      {
        return i;
        i = j;
      } while (paramTroopInfo.Administrator == null);
      i = j;
    } while (!paramTroopInfo.Administrator.contains(paramString));
    return 2;
  }
  
  public static Intent a(Intent paramIntent, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    String str1 = null;
    TroopLinkManager localTroopLinkManager = TroopLinkManager.a();
    String str2;
    if (paramString1 == "100")
    {
      str2 = localTroopLinkManager.a("troop_level");
      str1 = "membercard";
    }
    for (;;)
    {
      TroopLinkManager.LinkParams localLinkParams;
      if (!TextUtils.isEmpty(str2))
      {
        localLinkParams = new TroopLinkManager.LinkParams();
        localLinkParams.jdField_a_of_type_JavaLangString = paramString3;
        localLinkParams.b = paramString4;
        localLinkParams.e = paramString5;
        localLinkParams.c = str1;
        localLinkParams.d = paramString1;
      }
      for (paramString1 = localTroopLinkManager.a(str2, localLinkParams);; paramString1 = String.format("http://web.qun.qq.com/cgi-bin/misc/dynamic_url?gc=%1$s&uin=%2$s&from=%3$s&type=%4$s&nick=%5$s", new Object[] { paramString3, paramString4, str1, paramString1, paramString5 }))
      {
        paramIntent.putExtra("url", paramString1);
        paramIntent.putExtra("uin", paramString2);
        paramIntent.putExtra("portraitOnly", true);
        paramIntent.putExtra("hide_more_button", true);
        paramIntent.putExtra("hide_operation_bar", true);
        return paramIntent;
        if (paramString1 != "102") {
          break label187;
        }
        str2 = localTroopLinkManager.a("troop_level_setting");
        str1 = "setting";
        break;
      }
      label187:
      str2 = null;
    }
  }
  
  public static Intent a(QQAppInterface paramQQAppInterface, Intent paramIntent)
  {
    if ((paramQQAppInterface == null) || (paramIntent == null)) {
      return null;
    }
    String str = paramIntent.getStringExtra("memberUin");
    if (TextUtils.isEmpty(str)) {
      return null;
    }
    Friends localFriends = ((FriendsManager)paramQQAppInterface.getManager(50)).c(str);
    if ((localFriends != null) && (localFriends.isFriend()))
    {
      paramQQAppInterface = new ProfileActivity.AllInOne(str, 1);
      paramQQAppInterface.h = localFriends.name;
      paramQQAppInterface.i = localFriends.remark;
    }
    for (;;)
    {
      paramIntent.putExtra("AllInOne", paramQQAppInterface);
      return paramIntent;
      paramQQAppInterface = new ProfileActivity.AllInOne(str, 21);
    }
  }
  
  public static String a(int paramInt)
  {
    String str = "";
    if (paramInt == 3) {
      str = "0";
    }
    do
    {
      return str;
      if (paramInt == 2) {
        return "1";
      }
    } while (paramInt != 1);
    return "2";
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, Card paramCard)
  {
    for (;;)
    {
      try
      {
        if (TextUtils.equals(paramString2, paramQQAppInterface.getCurrentAccountUin()))
        {
          paramQQAppInterface = paramQQAppInterface.getCurrentNickname();
          paramString1 = paramQQAppInterface;
          if (TextUtils.isEmpty(paramQQAppInterface)) {
            paramString1 = paramString2;
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("troop_member_card", 2, "getNickName, nick=" + paramString1);
          break;
        }
        Object localObject = (FriendsManager)paramQQAppInterface.getManager(50);
        paramQQAppInterface = (TroopManager)paramQQAppInterface.getManager(51);
        localObject = ((FriendsManager)localObject).a(paramString2);
        TroopMemberInfo localTroopMemberInfo = paramQQAppInterface.b(paramString1, paramString2);
        if (localObject == null) {
          break label322;
        }
        if (((Friends)localObject).isFriend())
        {
          paramString1 = ((Friends)localObject).remark;
          paramQQAppInterface = paramString1;
          if (TextUtils.isEmpty(paramString1)) {
            paramQQAppInterface = ((Friends)localObject).name;
          }
          paramString1 = paramQQAppInterface;
          if (QLog.isColorLevel())
          {
            QLog.i("troop_member_card", 2, "getNickName, Friends!=null, remark=" + ((Friends)localObject).remark + " name=" + ((Friends)localObject).name);
            paramString1 = paramQQAppInterface;
          }
          localObject = paramString1;
          if (TextUtils.isEmpty(paramString1))
          {
            localObject = paramString1;
            if (localTroopMemberInfo != null)
            {
              paramQQAppInterface = localTroopMemberInfo.friendnick;
              localObject = paramQQAppInterface;
              if (QLog.isColorLevel())
              {
                QLog.i("troop_member_card", 2, "getNickName, TroopMemberInfo!=null, friendnick=" + localTroopMemberInfo.friendnick);
                localObject = paramQQAppInterface;
              }
            }
          }
          paramQQAppInterface = (QQAppInterface)localObject;
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            continue;
          }
          paramQQAppInterface = (QQAppInterface)localObject;
          if (paramCard == null) {
            continue;
          }
          paramString1 = paramCard.strNick;
          paramQQAppInterface = paramString1;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.i("troop_member_card", 2, "getNickName, mFriendCard!=null, strNick=" + paramCard.strNick);
          paramQQAppInterface = paramString1;
          continue;
        }
        paramString1 = "";
      }
      catch (Exception paramQQAppInterface)
      {
        return paramString2;
      }
      continue;
      label322:
      paramString1 = "";
    }
    return paramString1;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    a(paramQQAppInterface, paramContext, paramString1, paramString2, paramInt1, paramInt2, null);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2, Bundle paramBundle)
  {
    Object localObject = ((FriendsManager)paramQQAppInterface.getManager(50)).c(paramString2);
    if ((localObject != null) && (((Friends)localObject).isFriend()))
    {
      paramQQAppInterface = new ProfileActivity.AllInOne(paramString2, 1);
      paramQQAppInterface.h = ((Friends)localObject).name;
      paramQQAppInterface.i = ((Friends)localObject).remark;
    }
    for (;;)
    {
      localObject = new Intent(paramContext, FriendProfileCardActivity.class);
      ((Intent)localObject).putExtra("AllInOne", paramQQAppInterface);
      ((Intent)localObject).putExtra("troopUin", paramString1);
      ((Intent)localObject).putExtra("memberUin", paramString2);
      ((Intent)localObject).putExtra("fromFlag", paramInt1);
      if (paramBundle != null) {
        ((Intent)localObject).putExtras(paramBundle);
      }
      if (!(paramContext instanceof Activity)) {
        break;
      }
      ((Activity)paramContext).startActivityForResult((Intent)localObject, paramInt2);
      return;
      paramQQAppInterface = new ProfileActivity.AllInOne(paramString2, 21);
    }
    paramContext.startActivity((Intent)localObject);
  }
  
  public static boolean a(TroopInfo paramTroopInfo, TroopMemberCard paramTroopMemberCard, TextView paramTextView)
  {
    if ((paramTroopInfo == null) || (paramTroopMemberCard == null) || (paramTextView == null)) {}
    label27:
    label38:
    label49:
    label310:
    for (;;)
    {
      return false;
      boolean bool1;
      boolean bool2;
      boolean bool3;
      boolean bool5;
      String str;
      int i;
      if (!TextUtils.isEmpty(paramTroopMemberCard.mUniqueTitle))
      {
        bool1 = true;
        if (paramTroopMemberCard.memberRole != 3) {
          break label144;
        }
        bool2 = true;
        if (paramTroopMemberCard.memberRole != 2) {
          break label150;
        }
        bool3 = true;
        boolean bool4 = paramTroopInfo.isQidianPrivateTroop();
        bool5 = paramTroopInfo.isHomeworkTroop();
        if (!bool4) {
          break label156;
        }
        paramTroopInfo = TroopRankConfig.a().a(bool2, bool3);
        if (paramTroopInfo == null) {
          break label303;
        }
        str = paramTroopInfo.jdField_a_of_type_JavaLangString;
        i = paramTroopInfo.b;
      }
      for (;;)
      {
        if (TextUtils.isEmpty(str)) {
          break label310;
        }
        paramTextView.setText(" " + str + " ");
        TroopRankConfig.a(paramTextView, i);
        return true;
        bool1 = false;
        break label27;
        bool2 = false;
        break label38;
        bool3 = false;
        break label49;
        if ((bool5) && (!HWTroopUtils.a(paramTroopMemberCard.titleId))) {
          break;
        }
        TroopRankConfig.TroopRankItem localTroopRankItem = TroopRankConfig.a().a(paramTroopMemberCard.titleId, bool1, bool2, bool3);
        if (localTroopRankItem != null)
        {
          str = localTroopRankItem.jdField_a_of_type_JavaLangString;
          int j = localTroopRankItem.b;
          if (localTroopRankItem.jdField_a_of_type_Int == 302) {
            str = paramTroopMemberCard.mUniqueTitle;
          }
          i = j;
          if (localTroopRankItem.jdField_a_of_type_Int == 315)
          {
            str = (String)paramTroopInfo.getTroopLevelMap().get(Integer.valueOf(paramTroopMemberCard.realLevel));
            i = j;
          }
        }
        else if (paramTroopMemberCard.titleId == 315)
        {
          str = (String)paramTroopInfo.getTroopLevelMap().get(Integer.valueOf(paramTroopMemberCard.realLevel));
          i = Color.parseColor("#8EBDF9");
        }
        else
        {
          str = "";
          i = 0;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.profile.TroopMemberCardUtils
 * JD-Core Version:    0.7.0.1
 */