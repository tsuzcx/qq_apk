package com.tencent.mobileqq.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetail;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.device.utils.SmartDeviceUtil;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.contacts.friend.FriendsUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.ContactFacade;
import com.tencent.mobileqq.app.ContactSorter;
import com.tencent.mobileqq.app.ContactSorter.NamePriorityComparator;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.EqqDetailDataManager;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.DateNickNameInfo;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.EqqDetail;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.friend.status.OnlineStatusIconHelper;
import com.tencent.mobileqq.friend.status.OnlineStatusUtils;
import com.tencent.mobileqq.onlinestatus.api.IOnLineStatueHelperApi;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopMemberNameService;
import com.tencent.mobileqq.troop.api.ITroopSystemMsgUtilApi;
import com.tencent.mobileqq.troop.api.handler.ITroopMemberCardHandler;
import com.tencent.mobileqq.troop.util.api.ITroopDBUtilsApi;
import com.tencent.mobileqq.util.FetchBuddyAndTroopNameHelper;
import com.tencent.mobileqq.util.MessageRecordUtil;
import com.tencent.mobileqq.vas.CustomOnlineStatusManager.Utils;
import com.tencent.qidian.QidianManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.AppRuntime;
import mqq.app.Constants.PropertiesKey;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

public class ContactUtils
{
  public static int a = -1;
  public static Paint a = new Paint();
  public static String a = "troop_mem_nick_update_target";
  public static int b = 1;
  public static String b = "uni_seq";
  public static int c = 2;
  public static String c;
  private static String d;
  
  public static float a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      a.setTextSize(36.0F);
      return a.measureText(paramString) / 36.0F;
    }
    return 1.0F;
  }
  
  public static int a(int paramInt)
  {
    int j = 3;
    int i;
    if (paramInt != 0) {
      if (paramInt != 1) {
        if (paramInt != 2)
        {
          i = j;
          if (paramInt == 3) {
            return i;
          }
          if (paramInt != 1008) {
            if (paramInt != 1009)
            {
              if (paramInt == 1020) {
                break label158;
              }
              if (paramInt != 1021) {
                if (paramInt != 3000)
                {
                  if ((paramInt == 10002) || (paramInt == 10004)) {
                    break label153;
                  }
                  i = j;
                }
              }
            }
          }
        }
      }
    }
    switch (paramInt)
    {
    default: 
      switch (paramInt)
      {
      default: 
        return -1;
      }
    case 1004: 
      return 2;
      return 7;
      return 5;
    case 1001: 
    case 1002: 
    case 1003: 
      return 4;
      return 8;
    case 1000: 
      return 1;
      return 6;
    case 1005: 
      label153:
      label158:
      i = 0;
    }
    return i;
  }
  
  public static int a(Friends paramFriends, QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = (FriendListHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
    int i = OnlineStatusUtils.a(paramFriends.detalStatusFlag, paramFriends.iTermType);
    if ((i != 0) && (i != 6))
    {
      OnlineStatusIconHelper localOnlineStatusIconHelper = OnlineStatusIconHelper.a();
      if (1 == localOnlineStatusIconHelper.a(paramFriends.iTermType, 0))
      {
        if (!paramQQAppInterface.getShowPcOnlineIconConfig()) {
          break label138;
        }
      }
      else
      {
        if (2 == localOnlineStatusIconHelper.a(paramFriends.iTermType, 0)) {
          return 1;
        }
        if (3 == localOnlineStatusIconHelper.a(paramFriends.iTermType, 0)) {
          break label123;
        }
        if (!paramQQAppInterface.getShowPcOnlineIconConfig()) {
          break label138;
        }
      }
    }
    else
    {
      if (paramFriends.showLoginClient != 1L) {
        break label112;
      }
    }
    return 2;
    label112:
    if (paramFriends.showLoginClient == 3L) {
      label123:
      return 0;
    }
    if (paramFriends.showLoginClient == 2L) {
      return 1;
    }
    label138:
    return 3;
  }
  
  private static int a(String paramString)
  {
    byte[] arrayOfByte = new byte[0];
    try
    {
      paramString = paramString.getBytes("utf-8");
    }
    catch (UnsupportedEncodingException paramString)
    {
      paramString.printStackTrace();
      paramString = arrayOfByte;
    }
    return paramString.length;
  }
  
  public static ContactUtils.NameInfo a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    Friends localFriends = ((FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(paramString2);
    boolean bool2 = false;
    if ((localFriends != null) && (!TextUtils.isEmpty(localFriends.remark))) {
      return new ContactUtils.NameInfo(localFriends.remark, false);
    }
    paramString1 = ((TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).a(paramString1, paramString2);
    boolean bool1;
    if (paramString1 != null)
    {
      if (!TextUtils.isEmpty(paramString1.troopnick))
      {
        paramString2 = paramString1.troopnick;
        bool1 = bool2;
      }
      else if ((localFriends != null) && (!TextUtils.isEmpty(localFriends.name)))
      {
        paramString2 = localFriends.name;
        bool1 = bool2;
      }
      else if (paramString2.equals(paramQQAppInterface.getCurrentAccountUin()))
      {
        bool1 = bool2;
        if (!TextUtils.isEmpty(paramString1.friendnick))
        {
          paramString2 = paramString1.friendnick;
          bool1 = bool2;
        }
      }
      else if (!TextUtils.isEmpty(paramString1.autoremark))
      {
        paramString2 = paramString1.autoremark;
        bool1 = bool2;
      }
      else
      {
        bool1 = bool2;
        if (!TextUtils.isEmpty(paramString1.friendnick))
        {
          paramString2 = paramString1.friendnick;
          bool1 = bool2;
        }
      }
    }
    else {
      bool1 = true;
    }
    return new ContactUtils.NameInfo(paramString2, bool1);
  }
  
  public static String a()
  {
    return c;
  }
  
  public static String a(int paramInt)
  {
    String str = "2G在线";
    if (paramInt != 100) {
      if (paramInt == 101) {}
    }
    switch (paramInt)
    {
    default: 
      return "2G在线";
    case 12: 
      return "5G在线";
    case 11: 
      return HardCodeUtil.a(2131702760);
    case 10: 
      return "TIM在线";
    case 9: 
      return "车载QQ在线";
    case 8: 
      return "BMW QQ在线";
    case 7: 
      return HardCodeUtil.a(2131702756);
    case 6: 
      return HardCodeUtil.a(2131702761);
    case 5: 
      return HardCodeUtil.a(2131702750);
    case 4: 
      return "4G在线";
    case 3: 
      return "3G在线";
    case 1: 
      return "WiFi在线";
      return HardCodeUtil.a(2131702758);
      str = "iPhone在线";
    }
    return str;
  }
  
  private static String a(int paramInt, String paramString, Friends paramFriends, PhoneContact paramPhoneContact)
  {
    if ((paramInt != 0) && (paramInt != 3)) {
      return "";
    }
    if (paramFriends != null) {
      if (!TextUtils.isEmpty(paramFriends.remark)) {
        paramString = paramFriends.remark;
      } else {
        paramString = paramFriends.name;
      }
    }
    return paramString;
  }
  
  private static String a(int paramInt, String paramString1, String paramString2)
  {
    Object localObject = "";
    if (paramInt <= 0) {
      return "";
    }
    if (paramString1 == null) {
      paramString1 = "";
    }
    if (TextUtils.isEmpty(paramString2)) {
      return paramString1;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    if (paramString1.length() != 0) {
      localObject = "、";
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(paramString2);
    localObject = localStringBuilder.toString();
    if (a((String)localObject) <= paramInt) {
      return localObject;
    }
    localObject = paramString2;
    if (paramString1.length() != 0)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("、");
      ((StringBuilder)localObject).append(paramString2);
      localObject = ((StringBuilder)localObject).toString();
    }
    int j = a(paramString1);
    paramString2 = new StringBuilder();
    int i = 0;
    while (i < ((String)localObject).length())
    {
      int k = ((String)localObject).codePointAt(i);
      int m = Character.charCount(k);
      i += m;
      paramString2.appendCodePoint(k);
      if (a(paramString2.toString()) > paramInt - j) {
        paramString2.delete(paramString2.length() - m, paramString2.length());
      }
    }
    localObject = paramString2.toString();
    paramString2 = paramString1;
    if (!((String)localObject).equals("、"))
    {
      paramString2 = new StringBuilder();
      paramString2.append(paramString1);
      paramString2.append((String)localObject);
      paramString2 = paramString2.toString();
    }
    return paramString2;
  }
  
  public static String a(Context paramContext, DiscussionInfo paramDiscussionInfo)
  {
    if (paramDiscussionInfo != null) {
      paramDiscussionInfo = paramDiscussionInfo.discussionName;
    } else {
      paramDiscussionInfo = "";
    }
    Object localObject;
    if (paramDiscussionInfo != null)
    {
      localObject = paramDiscussionInfo;
      if (paramDiscussionInfo.length() != 0) {}
    }
    else
    {
      localObject = paramContext.getResources().getString(2131691760);
    }
    return localObject;
  }
  
  public static String a(AppInterface paramAppInterface, String paramString)
  {
    DiscussionInfo localDiscussionInfo = ((DiscussionManager)paramAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER)).a(paramString);
    paramAppInterface = paramString;
    if (localDiscussionInfo != null)
    {
      paramAppInterface = paramString;
      if (!TextUtils.isEmpty(localDiscussionInfo.discussionName)) {
        paramAppInterface = localDiscussionInfo.discussionName;
      }
    }
    return paramAppInterface;
  }
  
  public static String a(AppInterface paramAppInterface, String paramString, int paramInt)
  {
    if (paramInt == 1) {
      return d(paramAppInterface, paramString);
    }
    if (3000 == paramInt) {
      return a(paramAppInterface, paramString);
    }
    String str;
    if (paramInt != 0)
    {
      str = paramString;
      if (1024 != paramInt) {}
    }
    else
    {
      str = a(paramAppInterface, paramString);
    }
    return str;
  }
  
  public static String a(AppInterface paramAppInterface, String paramString1, String paramString2)
  {
    Friends localFriends = ((FriendsManager)paramAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(paramString2);
    if ((localFriends != null) && (!TextUtils.isEmpty(localFriends.remark))) {
      return localFriends.remark;
    }
    TroopMemberInfo localTroopMemberInfo = ((TroopManager)paramAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(paramString1, paramString2);
    if (localTroopMemberInfo != null)
    {
      if (!TextUtils.isEmpty(localTroopMemberInfo.troopnick)) {
        return localTroopMemberInfo.troopnick;
      }
      if ((localFriends != null) && (!TextUtils.isEmpty(localFriends.name))) {
        return localFriends.name;
      }
      if (paramString2.equals(paramAppInterface.getCurrentAccountUin()))
      {
        if (!TextUtils.isEmpty(localTroopMemberInfo.friendnick)) {
          return localTroopMemberInfo.friendnick;
        }
      }
      else
      {
        if (!TextUtils.isEmpty(localTroopMemberInfo.autoremark)) {
          return localTroopMemberInfo.autoremark;
        }
        if (!TextUtils.isEmpty(localTroopMemberInfo.friendnick)) {
          return localTroopMemberInfo.friendnick;
        }
      }
    }
    else
    {
      ((ITroopMemberCardHandler)paramAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_MEMBER_CARD_HANDLER)).a(Long.parseLong(paramString1), Long.parseLong(paramString2));
    }
    return paramString2;
  }
  
  public static String a(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, boolean paramBoolean, Bundle paramBundle)
  {
    if ((paramString1 != null) && (!"".equals(paramString1)) && (paramString2 != null) && (!"".equals(paramString2)) && (paramString3 != null) && (!"".equals(paramString3)))
    {
      String str = b(paramAppInterface, paramString2, paramString1);
      boolean bool = a(str, paramString1);
      if (QLog.isColorLevel()) {
        QLog.d("ContactUtils", 2, StringUtil.a(new Object[] { "getTroopNickName()", paramString1, paramString2, paramString3, Boolean.valueOf(paramBoolean), str }));
      }
      if (bool) {
        return str;
      }
      Object localObject = ((ITroopDBUtilsApi)QRoute.api(ITroopDBUtilsApi.class)).getTroopMemberInfo(paramAppInterface, paramString2, paramString1);
      if (localObject != null)
      {
        str = ((TroopMemberInfo)localObject).troopnick;
        if (!b(str)) {
          str = ((TroopMemberInfo)localObject).friendnick;
        }
      }
      else
      {
        str = null;
      }
      localObject = str;
      if (!b(str))
      {
        if (paramBoolean) {
          ((ContactFacade)paramAppInterface.getManager(QQManagerFactory.CONTACT_FACADE)).a().a(paramString1, paramString2, paramString3, paramBundle);
        }
        localObject = paramString1;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ContactUtils", 2, StringUtil.a(new Object[] { "getTroopNickName()", paramString1, paramString2, paramString3, Boolean.valueOf(paramBoolean), localObject }));
      }
      return localObject;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ContactUtils", 2, StringUtil.a(new Object[] { "getTroopNickName()", paramString1, paramString2, paramString3, Boolean.valueOf(paramBoolean), paramBundle }));
    }
    return "";
  }
  
  public static String a(AppInterface paramAppInterface, String paramString, boolean paramBoolean)
  {
    if (paramString != null)
    {
      if ("".equals(paramString)) {
        return "";
      }
      Object localObject1 = a(paramAppInterface, paramString, 1);
      if (a((String)localObject1, paramString))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ContactUtils", 2, StringUtil.a(new Object[] { "getTroopDisplayName()", paramString, Boolean.valueOf(paramBoolean) }));
        }
        return localObject1;
      }
      localObject1 = paramAppInterface.getEntityManagerFactory().createEntityManager();
      Object localObject2 = (TroopInfo)((EntityManager)localObject1).find(TroopInfo.class, paramString);
      ((EntityManager)localObject1).close();
      if (localObject2 != null) {
        localObject2 = ((TroopInfo)localObject2).getTroopDisplayName();
      } else {
        localObject2 = null;
      }
      localObject1 = localObject2;
      if (!b((String)localObject2)) {
        localObject1 = ((ITroopSystemMsgUtilApi)QRoute.api(ITroopSystemMsgUtilApi.class)).getTroopNameFromSP(paramAppInterface.getApp(), paramString);
      }
      localObject2 = localObject1;
      if (!b((String)localObject1))
      {
        if (paramBoolean) {
          ((ContactFacade)paramAppInterface.getManager(QQManagerFactory.CONTACT_FACADE)).a().a(paramString);
        }
        localObject2 = paramString;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ContactUtils", 2, StringUtil.a(new Object[] { "getTroopDisplayName()", paramString, Boolean.valueOf(paramBoolean) }));
      }
      return localObject2;
    }
    return "";
  }
  
  public static String a(BaseQQAppInterface paramBaseQQAppInterface, int paramInt, String paramString1, String paramString2)
  {
    if (paramInt == 1) {
      return a(paramBaseQQAppInterface, paramString1, paramString2);
    }
    if (paramInt == 3000) {
      return a(paramBaseQQAppInterface, paramString1, paramString2);
    }
    return "";
  }
  
  public static String a(BaseQQAppInterface paramBaseQQAppInterface, String paramString1, String paramString2)
  {
    FriendsManager localFriendsManager = (FriendsManager)paramBaseQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    Object localObject1 = (DiscussionManager)paramBaseQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER);
    if (paramString2 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ContactUtils", 2, "getDiscussionMemberShowName uin is null");
      }
      return "";
    }
    Object localObject2 = ((DiscussionManager)localObject1).a(paramString1);
    boolean bool;
    if ((localObject2 != null) && (((DiscussionInfo)localObject2).isDiscussHrMeeting())) {
      bool = true;
    } else {
      bool = false;
    }
    localObject2 = localFriendsManager.b(paramString2);
    if ((localObject2 != null) && (((Friends)localObject2).isFriend()) && (!bool))
    {
      if (!TextUtils.isEmpty(((Friends)localObject2).remark)) {
        return ((Friends)localObject2).remark;
      }
      if (!TextUtils.isEmpty(((Friends)localObject2).name)) {
        return ((Friends)localObject2).name;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ContactUtils", 2, "getDiscussionMemberShowName is friend but no name.");
      }
      return paramString2;
    }
    localObject1 = ((DiscussionManager)localObject1).a(paramString1);
    if (localObject1 != null)
    {
      localObject2 = (DiscussionMemberInfo)((Map)localObject1).get(paramString2);
      if (localObject2 != null)
      {
        localObject1 = ((DiscussionMemberInfo)localObject2).inteRemark;
        localObject2 = ((DiscussionMemberInfo)localObject2).memberName;
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          break label226;
        }
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject1 = localObject2;
          break label226;
        }
      }
    }
    localObject1 = null;
    label226:
    if (QLog.isDevelopLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getDiscussionMemberShowName, discussionShowName[");
      ((StringBuilder)localObject2).append(MessageRecordUtil.a((String)localObject1));
      ((StringBuilder)localObject2).append("], discussionUin[");
      ((StringBuilder)localObject2).append(paramString1);
      ((StringBuilder)localObject2).append("], memberUin[");
      ((StringBuilder)localObject2).append(paramString2);
      ((StringBuilder)localObject2).append("], bIsDiscHrMeeting[");
      ((StringBuilder)localObject2).append(bool);
      ((StringBuilder)localObject2).append("]");
      QLog.w("ContactUtils", 1, ((StringBuilder)localObject2).toString());
    }
    if ((localObject1 != null) && (((String)localObject1).trim().length() != 0)) {
      return localObject1;
    }
    if (bool) {
      return QAVHrMeeting.a();
    }
    paramString1 = localFriendsManager.e(paramString2);
    if (paramString1 != null) {
      return paramString1.name;
    }
    ((FriendListHandler)paramBaseQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getFriendInfo(paramString2, false);
    return paramString2;
  }
  
  public static String a(QQAppInterface paramQQAppInterface, int paramInt, String paramString1, String paramString2)
  {
    if (paramInt == 3000) {
      return a(paramQQAppInterface, paramString1, paramString2);
    }
    if (paramInt == 1)
    {
      paramString1 = a(paramQQAppInterface, paramString1, paramString2);
      if (TextUtils.isEmpty(paramString1))
      {
        ((FriendListHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getFriendInfo(paramString2, false);
        return paramString2;
      }
      return paramString1;
    }
    return g(paramQQAppInterface, paramString2);
  }
  
  public static String a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
  {
    paramQQAppInterface = (DiscussionManager)paramQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER);
    if (paramQQAppInterface != null) {
      paramQQAppInterface = paramQQAppInterface.a(paramString);
    } else {
      paramQQAppInterface = null;
    }
    return a(paramContext, paramQQAppInterface);
  }
  
  public static String a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, boolean paramBoolean, String paramString)
  {
    String str1 = paramString;
    String str2;
    try
    {
      int i = paramSessionInfo.jdField_a_of_type_Int;
      if (i != 1)
      {
        if (i != 3000)
        {
          if (paramBoolean)
          {
            str1 = paramString;
            return paramQQAppInterface.getCurrentNickname();
          }
          str1 = paramString;
          paramString = paramSessionInfo.d;
          if (paramString != null)
          {
            str1 = paramString;
            str2 = paramString;
            if (paramString.length() != 0) {
              break label114;
            }
          }
          str1 = paramString;
          return a(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString, "", 0, 0);
        }
        else
        {
          str1 = paramString;
          return a(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString, paramString);
        }
      }
      else
      {
        str1 = paramString;
        paramQQAppInterface = a(paramQQAppInterface, paramString, paramSessionInfo.jdField_a_of_type_JavaLangString, 1, 0);
        return paramQQAppInterface;
      }
    }
    catch (Exception paramQQAppInterface)
    {
      str2 = str1;
    }
    label114:
    return str2;
  }
  
  public static String a(QQAppInterface paramQQAppInterface, DiscussionMemberInfo paramDiscussionMemberInfo)
  {
    String str1 = paramDiscussionMemberInfo.memberUin;
    if (!TextUtils.isEmpty(paramDiscussionMemberInfo.inteRemark)) {
      str1 = paramDiscussionMemberInfo.inteRemark;
    } else {
      str1 = paramDiscussionMemberInfo.memberName;
    }
    String str2 = str1;
    if (TextUtils.isEmpty(str1)) {
      str2 = c(paramQQAppInterface, paramDiscussionMemberInfo.memberUin);
    }
    return str2;
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = ((FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).e(paramString);
    if (paramQQAppInterface != null) {
      return paramQQAppInterface.getFriendName();
    }
    return paramString;
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    Object localObject1 = (DiscussionManager)paramQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER);
    Object localObject2 = (FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    localObject1 = (IPublicAccountDataManager)paramQQAppInterface.getRuntimeService(IPublicAccountDataManager.class, "all");
    if (paramInt == 1) {
      return d(paramQQAppInterface, paramString);
    }
    if (3000 == paramInt) {
      return a(paramQQAppInterface, paramQQAppInterface.getApp(), paramString);
    }
    if ((1008 != paramInt) && (1024 != paramInt))
    {
      if (paramInt == 1006)
      {
        paramQQAppInterface = (IPhoneContactService)paramQQAppInterface.getRuntimeService(IPhoneContactService.class, "");
        localObject1 = paramQQAppInterface.queryContactByCodeNumber(paramString);
        if (localObject1 != null) {
          return ((PhoneContact)localObject1).name;
        }
        String str = paramQQAppInterface.getUinByPhoneNum(paramString);
        localObject1 = null;
        paramQQAppInterface = (QQAppInterface)localObject1;
        if (str != null)
        {
          localObject2 = ((FriendsManager)localObject2).e(str);
          paramQQAppInterface = (QQAppInterface)localObject1;
          if (localObject2 != null) {
            paramQQAppInterface = a((Friends)localObject2);
          }
        }
        if (paramQQAppInterface != null)
        {
          if (paramQQAppInterface.equals(str)) {
            return paramString;
          }
          return paramQQAppInterface;
        }
      }
      else
      {
        if ((paramInt != 9500) && (paramInt != 9501)) {
          return a(paramQQAppInterface, paramString);
        }
        return SmartDeviceUtil.a(((SmartDeviceProxyMgr)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER)).a(Long.parseLong(paramString)));
      }
    }
    else
    {
      if (QidianManager.a(paramQQAppInterface, paramString)) {
        return QidianManager.a(paramQQAppInterface, paramString);
      }
      localObject2 = (PublicAccountInfo)((IPublicAccountDataManager)localObject1).findPublicAccountInfo(paramString);
      if ((localObject2 != null) && (((PublicAccountInfo)localObject2).name != null)) {
        return ((PublicAccountInfo)localObject2).name;
      }
      localObject1 = ((IPublicAccountDataManager)localObject1).findAccountDetailInfo(paramString);
      if ((localObject1 != null) && (((IPublicAccountDetail)localObject1).getName() != null)) {
        return ((IPublicAccountDetail)localObject1).getName();
      }
      paramQQAppInterface = ((EqqDetailDataManager)paramQQAppInterface.getManager(QQManagerFactory.EQQ_DETAIL_DATA_MANAGER)).a(paramString);
      if ((paramQQAppInterface != null) && (paramQQAppInterface.name != null)) {
        return paramQQAppInterface.name;
      }
    }
    return paramString;
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    Friends localFriends = ((FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(paramString2);
    if ((localFriends != null) && (localFriends.isFriend()))
    {
      paramQQAppInterface = localFriends.name;
    }
    else
    {
      paramQQAppInterface = ((DiscussionManager)paramQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER)).a(paramString1, paramString2);
      if (paramQQAppInterface != null) {
        paramQQAppInterface = paramQQAppInterface.inteRemark;
      } else {
        paramQQAppInterface = "";
      }
    }
    if (paramQQAppInterface != null)
    {
      paramString1 = paramQQAppInterface;
      if (paramQQAppInterface.trim().length() != 0) {}
    }
    else
    {
      paramString1 = paramString2;
    }
    return paramString1;
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    if (paramInt == 1) {
      return a(paramQQAppInterface, paramString2, paramString1);
    }
    return a(paramQQAppInterface, paramString2, paramString1);
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    Object localObject = (ContactFacade)paramQQAppInterface.getManager(QQManagerFactory.CONTACT_FACADE);
    DiscussionManager localDiscussionManager = (DiscussionManager)paramQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER);
    localObject = (FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    TroopManager localTroopManager = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    if ((localObject != null) && (paramInt1 != 1) && (paramInt1 != 7) && (paramInt1 != 6) && (paramInt1 != 2) && (paramInt1 != 5)) {
      localObject = ((FriendsManager)localObject).e(paramString1);
    } else {
      localObject = null;
    }
    switch (paramInt1)
    {
    case 5: 
    default: 
      if ((localObject != null) && (!TextUtils.isEmpty(((Friends)localObject).name))) {
        paramQQAppInterface = ((Friends)localObject).name;
      }
      break;
    case 8: 
      paramQQAppInterface = a(paramQQAppInterface, paramString1, 1008);
      break;
    case 7: 
      paramQQAppInterface = a(paramQQAppInterface.getApp(), localDiscussionManager.a(paramString1));
      break;
    case 6: 
      paramQQAppInterface = localTroopManager.b(paramString1);
      if (paramQQAppInterface != null) {
        paramQQAppInterface = paramQQAppInterface.getTroopDisplayName();
      }
      break;
    case 4: 
      paramQQAppInterface = c(paramInt2, paramString1, (Friends)localObject, ((IPhoneContactService)paramQQAppInterface.getRuntimeService(IPhoneContactService.class, "")).queryPhoneContactByUin(paramString1));
      break;
    case 3: 
      paramQQAppInterface = b(paramInt2, paramString1, (Friends)localObject, ((IPhoneContactService)paramQQAppInterface.getRuntimeService(IPhoneContactService.class, "")).queryPhoneContactByUin(paramString1));
      break;
    case 2: 
      paramQQAppInterface = a(paramQQAppInterface, paramString2, paramString1);
      break;
    case 1: 
      if ((paramInt2 != 0) && (paramInt2 != 3)) {
        paramQQAppInterface = paramString1;
      } else {
        paramQQAppInterface = localTroopManager.a(paramString2, paramString1);
      }
      break;
    case 0: 
      paramQQAppInterface = a(paramInt2, paramString1, (Friends)localObject, ((IPhoneContactService)paramQQAppInterface.getRuntimeService(IPhoneContactService.class, "")).queryPhoneContactByUin(paramString1));
      break;
    }
    paramQQAppInterface = null;
    paramString2 = paramQQAppInterface;
    if (TextUtils.isEmpty(paramQQAppInterface)) {
      paramString2 = paramString1;
    }
    return paramString2;
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, long paramLong, String paramString3, Map<String, DiscussionMemberInfo> paramMap)
  {
    if (((0x40 & paramLong) >>> 6 == 1L) && ((paramLong & 0x20000000) != 536870912L) && ((paramMap == null) || (paramMap.size() == 0)))
    {
      if (QLog.isColorLevel())
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("setDiscussionNameAndCompareName, info is null. disUin=");
        paramQQAppInterface.append(paramString1);
        QLog.d("ContactUtils", 2, paramQQAppInterface.toString());
      }
      return paramString3;
    }
    paramString1 = paramString3;
    if (a(paramQQAppInterface, paramLong, paramString3)) {
      paramString1 = a(paramQQAppInterface, paramString2, paramMap);
    }
    return paramString1;
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord != null) {
      paramMessageRecord = paramMessageRecord.getExtInfoFromExtStr("troop_msg_nickname");
    } else {
      paramMessageRecord = null;
    }
    Object localObject = paramMessageRecord;
    if (TextUtils.isEmpty(paramMessageRecord)) {
      localObject = a(paramQQAppInterface, paramString1, paramString2);
    }
    return localObject;
  }
  
  @Deprecated
  public static String a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, boolean paramBoolean)
  {
    return ((ITroopMemberNameService)paramQQAppInterface.getRuntimeService(ITroopMemberNameService.class, "")).getTroopMemberName(paramString1, paramString2, paramBoolean, false);
  }
  
  private static String a(QQAppInterface paramQQAppInterface, String paramString, Map<String, DiscussionMemberInfo> paramMap)
  {
    String str = "";
    if ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramString)) && (paramMap != null) && (paramMap.size() != 0))
    {
      ContactSorter.NamePriorityComparator localNamePriorityComparator = new ContactSorter.NamePriorityComparator(paramQQAppInterface, paramString, paramQQAppInterface.getCurrentAccountUin());
      ArrayList localArrayList = new ArrayList(paramMap.values());
      paramString = str;
      do
      {
        paramMap = paramString;
        if (localArrayList.size() <= 0) {
          break;
        }
        paramMap = (DiscussionMemberInfo)Collections.min(localArrayList, localNamePriorityComparator);
        localArrayList.remove(paramMap);
        paramMap = a(48, paramString, a(paramMap, paramQQAppInterface));
        paramString = paramMap;
      } while (paramMap.length() < 47);
      return paramMap;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ContactUtils", 2, " === getDiscussionCombinedName app is null or ownerUin is null or members is null or members size is 0 ====");
    }
    return "";
  }
  
  public static String a(DiscussionMemberInfo paramDiscussionMemberInfo, QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = ((FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(paramDiscussionMemberInfo.memberUin);
    if ((paramQQAppInterface != null) && (paramQQAppInterface.isFriend())) {
      localObject = paramQQAppInterface.getFriendNick();
    } else {
      localObject = paramDiscussionMemberInfo.inteRemark;
    }
    paramQQAppInterface = (QQAppInterface)localObject;
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      paramQQAppInterface = paramDiscussionMemberInfo.memberName;
    }
    Object localObject = paramQQAppInterface;
    if (TextUtils.isEmpty(paramQQAppInterface)) {
      localObject = paramDiscussionMemberInfo.memberUin;
    }
    return localObject;
  }
  
  @Deprecated
  public static String a(Friends paramFriends)
  {
    return paramFriends.getFriendNickWithAlias();
  }
  
  private static String a(Friends paramFriends, String paramString)
  {
    if ((paramFriends.remark != null) && (paramFriends.remark.length() > 0)) {
      return paramFriends.remark;
    }
    if ((paramString != null) && (paramString.length() > 0)) {
      return paramString;
    }
    if ((paramFriends.name != null) && (paramFriends.name.length() > 0)) {
      return paramFriends.name;
    }
    return paramFriends.uin;
  }
  
  public static String a(PhoneContact paramPhoneContact)
  {
    String str = paramPhoneContact.strTermDesc;
    if ((OnlineStatusUtils.a(paramPhoneContact.detalStatusFlag, paramPhoneContact.iTermType) == 4) && (!TextUtils.isEmpty(str)) && (!a(paramPhoneContact)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(((IOnLineStatueHelperApi)QRoute.api(IOnLineStatueHelperApi.class)).getStatusNamePlusNetWorkType(paramPhoneContact.getNetWorkType()));
      return localStringBuilder.toString();
    }
    return str;
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    return paramString.trim().substring(0, 1).toUpperCase();
  }
  
  public static String a(String paramString, float paramFloat)
  {
    Object localObject = paramString;
    if (a(paramString) > paramFloat)
    {
      int i = Math.max(0, (int)(paramFloat - 3.0F));
      int j = i;
      while (i < paramString.length())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString.substring(0, i));
        ((StringBuilder)localObject).append("…");
        if (a(((StringBuilder)localObject).toString()) > paramFloat) {
          break;
        }
        j = i;
        i += 1;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString.substring(0, j));
      ((StringBuilder)localObject).append("…");
      localObject = ((StringBuilder)localObject).toString();
    }
    return localObject;
  }
  
  public static String a(AppRuntime paramAppRuntime, String paramString)
  {
    paramAppRuntime = ((FriendsManager)paramAppRuntime.getManager(QQManagerFactory.FRIENDS_MANAGER)).e(paramString);
    if (paramAppRuntime != null) {
      return paramAppRuntime.getFriendNick();
    }
    return paramString;
  }
  
  @Deprecated
  public static String a(AppRuntime paramAppRuntime, String paramString1, String paramString2)
  {
    return ((ITroopMemberNameService)paramAppRuntime.getRuntimeService(ITroopMemberNameService.class, "")).getTroopMemberNameWithoutRemark(paramString1, paramString2);
  }
  
  public static String a(AppRuntime paramAppRuntime, String paramString, boolean paramBoolean)
  {
    if (paramString != null)
    {
      if ("".equals(paramString)) {
        return "";
      }
      Object localObject2 = (FriendsManager)paramAppRuntime.getManager(QQManagerFactory.FRIENDS_MANAGER);
      if (localObject2 != null)
      {
        localObject1 = ((FriendsManager)localObject2).e(paramString);
        if (localObject1 != null)
        {
          if (((Friends)localObject1).isFriend())
          {
            if ((((Friends)localObject1).remark != null) && (!"".equals(((Friends)localObject1).remark))) {
              localObject1 = ((Friends)localObject1).remark;
            } else {
              localObject1 = ((Friends)localObject1).name;
            }
          }
          else {
            localObject1 = ((Friends)localObject1).name;
          }
          if (a((String)localObject1, paramString)) {
            return localObject1;
          }
        }
      }
      String str = a(paramAppRuntime, paramString);
      if (a(str, paramString)) {
        return str;
      }
      Object localObject1 = str;
      if (localObject2 != null)
      {
        localObject1 = str;
        if (!a(str, paramString))
        {
          localObject2 = ((FriendsManager)localObject2).a(paramString);
          localObject1 = str;
          if (localObject2 != null)
          {
            str = ((Card)localObject2).strNick;
            localObject1 = str;
            if (a(str, paramString))
            {
              if (QLog.isColorLevel()) {
                QLog.d("ContactUtils", 2, StringUtil.a(new Object[] { "getBuddyName()", paramString, Boolean.valueOf(paramBoolean) }));
              }
              return str;
            }
          }
        }
      }
      if (!a((String)localObject1, paramString))
      {
        localObject1 = (IPublicAccountDataManager)paramAppRuntime.getRuntimeService(IPublicAccountDataManager.class, "all");
        if (localObject1 != null)
        {
          localObject1 = (PublicAccountInfo)((IPublicAccountDataManager)localObject1).findPublicAccountInfoCache(paramString);
          if (localObject1 != null)
          {
            localObject1 = ((PublicAccountInfo)localObject1).name;
            if (a((String)localObject1, paramString))
            {
              if (QLog.isColorLevel()) {
                QLog.d("ContactUtils", 2, StringUtil.a(new Object[] { "getBuddyName()", paramString, Boolean.valueOf(paramBoolean) }));
              }
              return localObject1;
            }
          }
        }
      }
      if (paramBoolean) {
        ((ContactFacade)paramAppRuntime.getManager(QQManagerFactory.CONTACT_FACADE)).a().b(paramString);
      }
      return paramString;
    }
    return "";
  }
  
  public static void a()
  {
    c = null;
  }
  
  public static void a(int paramInt)
  {
    String str;
    switch (paramInt)
    {
    default: 
      str = null;
      break;
    case 8: 
      str = "0X80068B1";
      break;
    case 7: 
      str = "0X80068B0";
      break;
    case 6: 
      str = "0X80068AF";
      break;
    case 5: 
      str = "0X80068AE";
      break;
    case 4: 
      str = "0X80068AD";
      break;
    case 3: 
      str = "0X80068AC";
      break;
    case 2: 
      str = "0X80068AB";
      break;
    case 1: 
      str = "0X80068AA";
    }
    c = str;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (!paramString1.equals("")) && (paramString2 != null))
    {
      if (paramString2.equals("")) {
        return;
      }
      ((IPhoneContactService)paramQQAppInterface.getRuntimeService(IPhoneContactService.class, "")).addUinByPhoneNum(paramString1, paramString2);
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, long paramLong, String paramString)
  {
    if (d == null) {
      d = paramQQAppInterface.getApp().getString(2131720098);
    }
    return (((0x40 & paramLong) >>> 6 == 1L) && ((paramLong & 0x20000000) >>> 29 == 1L)) || (paramString == null) || (paramString.matches(d)) || (paramString.length() == 0);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, DiscussionInfo paramDiscussionInfo)
  {
    return a(paramQQAppInterface, paramDiscussionInfo.DiscussionFlag, paramDiscussionInfo.discussionName);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = ((DiscussionManager)paramQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER)).a(paramString);
    if (paramQQAppInterface != null) {
      return paramQQAppInterface.isDiscussHrMeeting();
    }
    return false;
  }
  
  private static boolean a(QQAppInterface paramQQAppInterface, String paramString, DiscussionInfo paramDiscussionInfo, Map<String, DiscussionMemberInfo> paramMap)
  {
    if ((paramDiscussionInfo != null) && (paramMap != null) && (paramMap.size() != 0))
    {
      paramDiscussionInfo.discussionName = a(paramQQAppInterface, paramDiscussionInfo.ownerUin, paramMap);
      return true;
    }
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString, DiscussionInfo paramDiscussionInfo, Map<String, DiscussionMemberInfo> paramMap, boolean paramBoolean)
  {
    if (paramDiscussionInfo == null)
    {
      if (QLog.isColorLevel())
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("setDiscussionNameAndCompareName, info is null. disUin=");
        paramQQAppInterface.append(paramString);
        QLog.d("ContactUtils", 2, paramQQAppInterface.toString());
      }
      return false;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setDiscussionNameAndCompareName, Flag =");
      localStringBuilder.append(paramDiscussionInfo.DiscussionFlag);
      localStringBuilder.append(" disUin=");
      localStringBuilder.append(paramString);
      QLog.d("ContactUtils", 2, localStringBuilder.toString());
    }
    if ((!paramDiscussionInfo.hasRenamed()) && ((paramDiscussionInfo.DiscussionFlag & 0x20000000) >>> 29 == 1L) && ((paramMap == null) || (paramMap.size() == 0)))
    {
      if (QLog.isColorLevel())
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("setDiscussionNameAndCompareName no need disUin=");
        paramQQAppInterface.append(paramString);
        QLog.d("ContactUtils", 2, paramQQAppInterface.toString());
      }
      return false;
    }
    boolean bool;
    if (a(paramQQAppInterface, paramDiscussionInfo)) {
      bool = a(paramQQAppInterface, paramString, paramDiscussionInfo, paramMap);
    } else {
      bool = false;
    }
    if ((!paramBoolean) && (!bool) && (paramDiscussionInfo.mCompareSpell != null) && (paramDiscussionInfo.mCompareSpell.length() != 0)) {
      return false;
    }
    ContactSorter.a(paramDiscussionInfo);
    paramDiscussionInfo.DiscussionFlag &= 0xDFFFFFFF;
    return true;
  }
  
  public static boolean a(PhoneContact paramPhoneContact)
  {
    return (paramPhoneContact.iTermType == 0) && (paramPhoneContact.eNetworkType == 0);
  }
  
  public static boolean a(String paramString)
  {
    return Pattern.compile("[\\u4E00-\\u9FA5]+").matcher(paramString).find();
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    return (b(paramString1)) && (!paramString1.equals(paramString2)) && (paramString2 != null);
  }
  
  public static String b(int paramInt)
  {
    String str = "2G网络";
    if (paramInt != 12) {
      if (paramInt != 100) {
        if (paramInt == 101) {}
      }
    }
    switch (paramInt)
    {
    default: 
      return "2G网络";
    case 10: 
      return "TIM在线";
    case 9: 
      return HardCodeUtil.a(2131702757);
    case 8: 
      return HardCodeUtil.a(2131702754);
    case 7: 
      return HardCodeUtil.a(2131702755);
    case 6: 
      return HardCodeUtil.a(2131702753);
    case 5: 
      return HardCodeUtil.a(2131702751);
    case 4: 
      return "4G网络";
    case 3: 
      return "3G网络";
    case 1: 
      return "WIFI网络";
      return HardCodeUtil.a(2131702752);
      return "iPhone在线";
      str = "5G网络";
    }
    return str;
  }
  
  private static String b(int paramInt, String paramString, Friends paramFriends, PhoneContact paramPhoneContact)
  {
    String str;
    if (paramInt != 0)
    {
      if (paramInt != 3) {
        return "";
      }
      if ((paramFriends != null) && (paramFriends.isFriend()))
      {
        if (!TextUtils.isEmpty(paramFriends.remark)) {
          paramString = paramFriends.remark;
        } else {
          paramString = paramFriends.name;
        }
        return paramString;
      }
      if (paramPhoneContact != null) {
        return paramPhoneContact.name;
      }
      str = paramString;
      if (paramFriends != null)
      {
        str = paramString;
        if (!TextUtils.isEmpty(paramFriends.name)) {
          return paramFriends.name;
        }
      }
    }
    else
    {
      str = paramString;
      if (paramPhoneContact != null) {
        str = paramPhoneContact.name;
      }
    }
    return str;
  }
  
  public static String b(AppInterface paramAppInterface, String paramString)
  {
    paramAppInterface = (IPhoneContactService)paramAppInterface.getRuntimeService(IPhoneContactService.class, "");
    if (paramAppInterface != null) {
      return paramAppInterface.getUinByPhoneNum(paramString);
    }
    return "";
  }
  
  @Deprecated
  public static String b(AppInterface paramAppInterface, String paramString1, String paramString2)
  {
    return ((ITroopMemberNameService)paramAppInterface.getRuntimeService(ITroopMemberNameService.class, "")).getTroopMemberName(paramString1, paramString2);
  }
  
  public static String b(AppInterface paramAppInterface, String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    Object localObject = ((TroopManager)paramAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(paramString);
    if (localObject != null) {
      return ((TroopInfo)localObject).getNewTroopNameOrTroopName();
    }
    localObject = ((ITroopSystemMsgUtilApi)QRoute.api(ITroopSystemMsgUtilApi.class)).getTroopNameFromSP(paramAppInterface.getApp(), paramString);
    paramAppInterface = (AppInterface)localObject;
    if (!b((String)localObject)) {
      paramAppInterface = paramString;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ContactUtils", 2, StringUtil.a(new Object[] { "getNewTroopNameOrTroopName()", paramString, Boolean.valueOf(paramBoolean) }));
    }
    return paramAppInterface;
  }
  
  public static String b(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = ((DiscussionManager)paramQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER)).a(paramString);
    if ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramQQAppInterface.discussionName))) {
      return paramQQAppInterface.discussionName;
    }
    return null;
  }
  
  @Deprecated
  public static String b(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    return ((ITroopMemberNameService)paramQQAppInterface.getRuntimeService(ITroopMemberNameService.class, "")).getTroopMemberNameRemarkFirst(paramString1, paramString2);
  }
  
  public static String b(Friends paramFriends)
  {
    int i = OnlineStatusUtils.a(paramFriends.detalStatusFlag, paramFriends.iTermType);
    String str1;
    if ((i == 4) && (!OnlineStatusUtils.a(paramFriends)))
    {
      int j = FriendsUtils.a(paramFriends.eNetwork, paramFriends.iTermType, paramFriends.netTypeIconId);
      str1 = ((IOnLineStatueHelperApi)QRoute.api(IOnLineStatueHelperApi.class)).getStatusNamePlusNetWorkType(j);
    }
    else
    {
      str1 = null;
    }
    String str3 = paramFriends.strTermDesc;
    String str2 = str3;
    if (i == 4)
    {
      str2 = str3;
      if (CustomOnlineStatusManager.Utils.a(paramFriends.customOnlineStatusType))
      {
        str2 = str3;
        if (!TextUtils.isEmpty(paramFriends.customOnlineStatus)) {
          str2 = paramFriends.customOnlineStatus;
        }
      }
    }
    if ((str1 != null) && (!TextUtils.isEmpty(str2)))
    {
      paramFriends = new StringBuilder();
      paramFriends.append(str2);
      paramFriends.append(str1);
      return paramFriends.toString();
    }
    return str2;
  }
  
  private static String b(Friends paramFriends, String paramString)
  {
    if ((paramFriends.remark != null) && (paramFriends.remark.length() > 0)) {
      return paramFriends.remark;
    }
    if ((paramString != null) && (paramString.length() > 0)) {
      return paramString;
    }
    if ((paramFriends.name != null) && (paramFriends.name.length() > 0)) {
      return paramFriends.name;
    }
    return "";
  }
  
  public static String b(String paramString)
  {
    if ((paramString != null) && (paramString.length() != 0))
    {
      int m = paramString.length();
      int k = 0;
      char c1 = '\000';
      int j = 0;
      while (k < m)
      {
        int i = paramString.charAt(k);
        if (k == 0) {
          c1 = i;
        }
        if (k == 1) {
          j = i;
        }
        if ((i >= 19968) && (i <= 40869)) {
          return String.valueOf(i);
        }
        k += 1;
      }
      if ((c1 >= '!') && (c1 <= '~'))
      {
        if ((j >= 33) && (j <= 126)) {
          return String.valueOf(new char[] { c1, j });
        }
        return String.valueOf(c1);
      }
      return "?";
    }
    return "";
  }
  
  @Deprecated
  public static String b(AppRuntime paramAppRuntime, String paramString1, String paramString2)
  {
    return ((ITroopMemberNameService)paramAppRuntime.getRuntimeService(ITroopMemberNameService.class, "")).getTroopMemberNameInUI(paramString1, paramString2);
  }
  
  public static String b(AppRuntime paramAppRuntime, String paramString, boolean paramBoolean)
  {
    if (paramString != null)
    {
      if ("".equals(paramString)) {
        return "";
      }
      if (paramAppRuntime == null) {
        return paramString;
      }
      FriendsManager localFriendsManager = (FriendsManager)paramAppRuntime.getManager(QQManagerFactory.FRIENDS_MANAGER);
      if (localFriendsManager != null)
      {
        localObject = localFriendsManager.e(paramString);
        if (localObject != null)
        {
          localObject = ((Friends)localObject).name;
          if (localObject != null)
          {
            if (QLog.isColorLevel()) {
              QLog.d("ContactUtils", 2, StringUtil.a(new Object[] { "FriendEntity getBuddyNickName()", paramString, Boolean.valueOf(paramBoolean) }));
            }
            return localObject;
          }
        }
      }
      Object localObject = null;
      if (localFriendsManager != null) {
        localObject = localFriendsManager.a(paramString);
      }
      if (localObject != null)
      {
        localObject = ((Card)localObject).strNick;
        if (localObject != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ContactUtils", 2, StringUtil.a(new Object[] { "FriendCard getBuddyNickName()", paramString, Boolean.valueOf(paramBoolean) }));
          }
          return localObject;
        }
      }
      if (paramBoolean) {
        ((ContactFacade)paramAppRuntime.getManager(QQManagerFactory.CONTACT_FACADE)).a().b(paramString);
      }
      if (QLog.isColorLevel()) {
        QLog.d("ContactUtils", 2, StringUtil.a(new Object[] { "getBuddyNickName()", paramString, Boolean.valueOf(paramBoolean) }));
      }
      return paramString;
    }
    return "";
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, DiscussionInfo paramDiscussionInfo)
  {
    return (a(paramQQAppInterface, paramDiscussionInfo)) || (paramDiscussionInfo.mCompareSpell == null) || (paramDiscussionInfo.mCompareSpell.length() == 0);
  }
  
  private static boolean b(String paramString)
  {
    return (paramString != null) && (!"".equals(paramString));
  }
  
  private static String c(int paramInt, String paramString, Friends paramFriends, PhoneContact paramPhoneContact)
  {
    if ((paramInt != 0) && (paramInt != 3)) {
      return "";
    }
    if ((paramFriends != null) && (paramFriends.isFriend()))
    {
      if (!TextUtils.isEmpty(paramFriends.remark)) {
        paramString = paramFriends.remark;
      } else {
        paramString = paramFriends.name;
      }
      return paramString;
    }
    if (paramPhoneContact != null) {
      return paramPhoneContact.name;
    }
    paramPhoneContact = paramString;
    if (paramFriends != null)
    {
      paramPhoneContact = paramString;
      if (!TextUtils.isEmpty(paramFriends.name)) {
        paramPhoneContact = paramFriends.name;
      }
    }
    return paramPhoneContact;
  }
  
  public static String c(AppInterface paramAppInterface, String paramString)
  {
    return ((IPhoneContactService)paramAppInterface.getRuntimeService(IPhoneContactService.class, "")).getPhoneNumByUin(paramString);
  }
  
  @Deprecated
  public static String c(AppInterface paramAppInterface, String paramString1, String paramString2)
  {
    return ((ITroopMemberNameService)paramAppInterface.getRuntimeService(ITroopMemberNameService.class, "")).getTroopMemberNick(paramString1, paramString2);
  }
  
  public static String c(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = (FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    Object localObject = paramQQAppInterface.e(paramString);
    if ((localObject != null) && (!TextUtils.isEmpty(((Friends)localObject).name))) {
      return ((Friends)localObject).name;
    }
    localObject = paramQQAppInterface.a(paramString);
    paramQQAppInterface = paramString;
    if (localObject != null)
    {
      paramQQAppInterface = paramString;
      if (!TextUtils.isEmpty(((Card)localObject).strNick)) {
        paramQQAppInterface = ((Card)localObject).strNick;
      }
    }
    return paramQQAppInterface;
  }
  
  public static String d(AppInterface paramAppInterface, String paramString)
  {
    HotChatInfo localHotChatInfo = ((HotChatManager)paramAppInterface.getManager(QQManagerFactory.HOT_CHAT_MANAGER)).a(paramString);
    if (localHotChatInfo != null)
    {
      paramAppInterface = new StringBuilder();
      paramAppInterface.append(localHotChatInfo.name);
      paramAppInterface.append(HardCodeUtil.a(2131702759));
      return paramAppInterface.toString();
    }
    paramAppInterface = ((TroopManager)paramAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(paramString);
    if ((paramAppInterface != null) && (paramAppInterface.getTroopDisplayName() != null)) {
      return paramAppInterface.getTroopDisplayName();
    }
    return paramString;
  }
  
  @NotNull
  public static String d(QQAppInterface paramQQAppInterface, String paramString)
  {
    Friends localFriends = ((FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).e(paramString);
    paramQQAppInterface = (IPhoneContactService)paramQQAppInterface.getRuntimeService(IPhoneContactService.class, "");
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.queryPhoneContactByUin(paramString);
      if (paramQQAppInterface != null)
      {
        paramQQAppInterface = paramQQAppInterface.name;
        break label54;
      }
    }
    paramQQAppInterface = null;
    label54:
    if (localFriends != null) {
      paramString = a(localFriends, paramQQAppInterface);
    }
    return paramString;
  }
  
  public static String e(AppInterface paramAppInterface, String paramString)
  {
    Object localObject1 = null;
    if (paramString == null) {
      return null;
    }
    Object localObject2 = paramAppInterface.getApplication();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Constants.PropertiesKey.nickName.toString());
    localStringBuilder.append(paramString);
    localObject2 = ((MobileQQ)localObject2).getProperty(localStringBuilder.toString());
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      paramAppInterface = (FriendsManager)paramAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
      if (paramAppInterface == null) {
        paramAppInterface = (AppInterface)localObject1;
      } else {
        paramAppInterface = paramAppInterface.e(paramString);
      }
      if (paramAppInterface != null)
      {
        paramAppInterface = paramAppInterface.name;
        break label98;
      }
    }
    paramAppInterface = (AppInterface)localObject2;
    label98:
    localObject1 = paramAppInterface;
    if (TextUtils.isEmpty(paramAppInterface)) {
      localObject1 = paramString;
    }
    return localObject1;
  }
  
  @NotNull
  public static String e(QQAppInterface paramQQAppInterface, String paramString)
  {
    Friends localFriends = ((FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).c(paramString);
    paramQQAppInterface = (IPhoneContactService)paramQQAppInterface.getRuntimeService(IPhoneContactService.class, "");
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.queryPhoneContactByUin(paramString);
      if (paramQQAppInterface != null)
      {
        paramQQAppInterface = paramQQAppInterface.name;
        break label54;
      }
    }
    paramQQAppInterface = null;
    label54:
    if (localFriends != null) {
      paramString = a(localFriends, paramQQAppInterface);
    }
    return paramString;
  }
  
  public static String f(AppInterface paramAppInterface, String paramString)
  {
    Friends localFriends = ((FriendsManager)paramAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).e(paramString);
    paramAppInterface = (IPhoneContactService)paramAppInterface.getRuntimeService(IPhoneContactService.class, "");
    if (paramAppInterface != null)
    {
      paramAppInterface = paramAppInterface.queryPhoneContactByUin(paramString);
      if (paramAppInterface != null)
      {
        paramAppInterface = paramAppInterface.name;
        break label54;
      }
    }
    paramAppInterface = null;
    label54:
    if (localFriends != null)
    {
      if ((localFriends.remark != null) && (localFriends.remark.length() > 0)) {
        return localFriends.remark;
      }
      if ((localFriends.name != null) && (localFriends.name.length() > 0)) {
        return localFriends.name;
      }
      if ((paramAppInterface != null) && (paramAppInterface.length() > 0)) {
        return paramAppInterface;
      }
      paramString = localFriends.uin;
    }
    return paramString;
  }
  
  public static String f(QQAppInterface paramQQAppInterface, String paramString)
  {
    Friends localFriends = ((FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).e(paramString);
    paramString = "";
    paramQQAppInterface = (IPhoneContactService)paramQQAppInterface.getRuntimeService(IPhoneContactService.class, "");
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.queryPhoneContactByUin("");
      if (paramQQAppInterface != null)
      {
        paramQQAppInterface = paramQQAppInterface.name;
        break label58;
      }
    }
    paramQQAppInterface = null;
    label58:
    if (localFriends != null) {
      paramString = b(localFriends, paramQQAppInterface);
    }
    return paramString;
  }
  
  public static String g(AppInterface paramAppInterface, String paramString)
  {
    if (paramString != null)
    {
      if ("".equals(paramString)) {
        return "";
      }
      if (TextUtils.equals(paramString, AppConstants.MSG_BOX_DAREN_ASSISTANT_UIN)) {
        return BaseApplicationImpl.getContext().getString(2131694297);
      }
      if (TextUtils.equals(paramString, AppConstants.MSG_BOX_YANZHI_UIN)) {
        return BaseApplicationImpl.getContext().getString(2131694302);
      }
      String str = null;
      long l = 0L;
      Object localObject = ((FriendsManager)paramAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(paramString);
      if (localObject != null)
      {
        str = ((DateNickNameInfo)localObject).nickName;
        l = ((DateNickNameInfo)localObject).lastUpdateTime;
      }
      if (str != null)
      {
        localObject = str;
        if (Math.abs(System.currentTimeMillis() - l) < 86400000L) {}
      }
      else
      {
        localObject = str;
        if (str == null) {
          localObject = "";
        }
        ((ContactFacade)paramAppInterface.getManager(QQManagerFactory.CONTACT_FACADE)).a().c(paramString);
      }
      return localObject;
    }
    return "";
  }
  
  public static String g(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (TextUtils.equals(paramString, paramQQAppInterface.getCurrentAccountUin()))
    {
      localObject = ((FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).e(paramString);
      if (localObject != null)
      {
        if (!TextUtils.isEmpty(((Friends)localObject).name)) {
          return ((Friends)localObject).name;
        }
      }
      else {
        ((FriendListHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getFriendInfo(paramString, false);
      }
      return paramString;
    }
    Object localObject = f(paramQQAppInterface, paramString);
    if (((String)localObject).equals(paramString)) {
      ((FriendListHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getFriendInfo(paramString, false);
    }
    return localObject;
  }
  
  public static String h(QQAppInterface paramQQAppInterface, String paramString)
  {
    String str = ((TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).c(paramString);
    if (str == null) {
      return paramString;
    }
    return a(paramQQAppInterface, str, 1);
  }
  
  public static String i(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    Friends localFriends = ((FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(paramString);
    paramQQAppInterface = paramString;
    if (localFriends != null)
    {
      paramQQAppInterface = paramString;
      if (localFriends.isFriend())
      {
        if (!TextUtils.isEmpty(localFriends.remark)) {
          return localFriends.remark;
        }
        paramQQAppInterface = paramString;
        if (!TextUtils.isEmpty(localFriends.name)) {
          paramQQAppInterface = localFriends.name;
        }
      }
    }
    return paramQQAppInterface;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.ContactUtils
 * JD-Core Version:    0.7.0.1
 */