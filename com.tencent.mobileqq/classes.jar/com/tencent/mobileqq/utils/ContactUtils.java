package com.tencent.mobileqq.utils;

import abgm;
import absz;
import ajlh;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.os.Bundle;
import android.text.TextUtils;
import ansj;
import ansk;
import ansn;
import anso;
import antp;
import anty;
import anvk;
import anvx;
import aoan;
import aoep;
import awyz;
import bghs;
import bgyx;
import bhbv;
import bhbx;
import bhdf;
import bhgf;
import bhmz;
import bjxa;
import com.tencent.av.gaudio.AVPhoneUserInfo;
import com.tencent.av.gaudio.AVPhoneUserInfo.TelInfo;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.AccountDetail;
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
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.Constants.PropertiesKey;
import mqq.app.MobileQQ;
import mtq;
import org.jetbrains.annotations.NotNull;

public class ContactUtils
{
  public static final int BIND_PATH_ADDPAGE_CONTACT = 6;
  public static final int BIND_PATH_CONTACT_TAB = 5;
  public static final int BIND_PATH_GUIDE_PAGE = 2;
  public static final int BIND_PATH_NET_BUSINESS_HALL = 7;
  public static final int BIND_PATH_SETTING_PRIVACY = 4;
  public static final int BIND_PATH_SETTING_UNITY = 3;
  public static final int BIND_PATH_UNITY_REMATCH = 1;
  public static final int BIND_PATH_WELCOME_PAGE = 8;
  private static final int CLIENT_TYPE_IPHONE = 0;
  public static final int CLIENT_TYPE_NONE = 3;
  private static final int CLIENT_TYPE_NORMAL_MOBILE = 1;
  private static final int CLIENT_TYPE_PC = 2;
  private static final int ENTRY_CIRCLE_LIST = 5;
  public static final int ENTRY_DISCUSSION_LIST = 2;
  public static final int ENTRY_FRIEND_LIST = 0;
  public static final int ENTRY_FRIEND_RECOMMEND_LIST = 4;
  public static final int ENTRY_PHONE_CONTACT_LIST = 3;
  public static final int ENTRY_PUBLIC_ACCOUNT = 8;
  public static final int ENTRY_TMP_DSCS = 7;
  public static final int ENTRY_TMP_TROOP = 6;
  public static final int ENTRY_TROOP_MEMBER_LIST = 1;
  public static final int ENTRY_UNKNOWN = -1;
  public static final long FLAG_NAME_LOCAL_MASK = 536870912L;
  public static final int FLAG_NAME_RENAMED = 0;
  public static final long FLAG_NAME_SERVER_MASK = 64L;
  public static final int FLAG_NAME_UNRENAMED = 1;
  public static final int INVALID_VALUE = -1;
  public static String KEY_TROOP_MEM_NICK_UPDATE_TARGET = "troop_mem_nick_update_target";
  public static String KEY_UNI_SEQ = "uni_seq";
  public static final int POS_AIO_TITLE = 3;
  public static final int POS_LIST = 0;
  public static final int STATUS_AWAY = 1;
  public static final int STATUS_BUSY = 2;
  public static final int STATUS_DO_NOT_DISTURB = 7;
  public static final int STATUS_INVISIBLE = 6;
  public static final int STATUS_OFFLINE = 0;
  public static final int STATUS_ONLINE = 4;
  public static final int STATUS_PC_ONLINE = 5;
  public static final int STATUS_PUSH = 8;
  public static final int STATUS_Q_ME = 3;
  private static final int STATUS_TYPE_AWAY = 2;
  private static final int STATUS_TYPE_BUSY = 1;
  private static final int STATUS_TYPE_OFFLINE_BASE = 20;
  private static final int STATUS_TYPE_ONLINE = 0;
  private static final String TAG = "ContactUtils";
  public static int VALUE_EXTRA_UPDATE_TARGET_GAP_GRAY_MSG;
  public static int VALUE_EXTRA_UPDATE_TARGET_REVOKED_GRAY_MSG;
  public static int VALUE_NO_EXTRA_UPDATE_TARGET = -1;
  public static Paint sPaint = new Paint();
  public static String sRequestBindPathTag;
  private static String unrenamedNamesReg;
  
  static
  {
    VALUE_EXTRA_UPDATE_TARGET_REVOKED_GRAY_MSG = 1;
    VALUE_EXTRA_UPDATE_TARGET_GAP_GRAY_MSG = 2;
  }
  
  public static void addUinByPhoneNum(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString1.equals("")) || (paramString2 == null) || (paramString2.equals(""))) {
      return;
    }
    ((awyz)paramQQAppInterface.getManager(QQManagerFactory.CONTACT_MANAGER)).c(paramString1, paramString2);
  }
  
  public static void clearRequestPathKey()
  {
    sRequestBindPathTag = null;
  }
  
  private static int countByByte(String paramString)
  {
    byte[] arrayOfByte = new byte[0];
    try
    {
      paramString = paramString.getBytes("utf-8");
      return paramString.length;
    }
    catch (UnsupportedEncodingException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        paramString = arrayOfByte;
      }
    }
  }
  
  public static String getAccountNickName(QQAppInterface paramQQAppInterface, String paramString)
  {
    Object localObject = null;
    if (paramString == null) {
      paramString = null;
    }
    label92:
    label95:
    for (;;)
    {
      return paramString;
      String str = paramQQAppInterface.getApplication().getProperty(Constants.PropertiesKey.nickName.toString() + paramString);
      if (TextUtils.isEmpty(str))
      {
        paramQQAppInterface = (anvk)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
        if (paramQQAppInterface == null)
        {
          paramQQAppInterface = localObject;
          if (paramQQAppInterface == null) {
            break label92;
          }
        }
      }
      for (paramQQAppInterface = paramQQAppInterface.name;; paramQQAppInterface = str)
      {
        if (TextUtils.isEmpty(paramQQAppInterface)) {
          break label95;
        }
        return paramQQAppInterface;
        paramQQAppInterface = paramQQAppInterface.e(paramString);
        break;
      }
    }
  }
  
  public static String getBuddyName(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean)
  {
    Object localObject;
    if ((paramString == null) || ("".equals(paramString))) {
      localObject = "";
    }
    String str;
    label190:
    label199:
    label208:
    label211:
    do
    {
      return localObject;
      anvk localanvk = (anvk)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
      if (localanvk != null)
      {
        localObject = localanvk.e(paramString);
        if (localObject != null)
        {
          if (!((Friends)localObject).isFriend()) {
            break label199;
          }
          if ((((Friends)localObject).remark == null) || ("".equals(((Friends)localObject).remark))) {
            break label190;
          }
          str = ((Friends)localObject).remark;
        }
      }
      for (;;)
      {
        localObject = str;
        if (isValideName(str, paramString)) {
          break;
        }
        str = getFriendNick(paramQQAppInterface, paramString);
        localObject = str;
        if (isValideName(str, paramString)) {
          break;
        }
        if ((localanvk == null) || (isValideName(str, paramString))) {
          break label208;
        }
        localObject = localanvk.b(paramString);
        if (localObject == null) {
          break label208;
        }
        str = ((Card)localObject).strNick;
        localObject = str;
        if (!isValideName(str, paramString)) {
          break label211;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ContactUtils", 2, StringUtil.makeLogMsg(new Object[] { "getBuddyName()", paramString, Boolean.valueOf(paramBoolean) }));
        }
        return str;
        str = ((Friends)localObject).name;
        continue;
        str = ((Friends)localObject).name;
      }
      localObject = str;
      if (isValideName((String)localObject, paramString)) {
        break;
      }
      localObject = (aoan)paramQQAppInterface.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER);
      if (localObject == null) {
        break;
      }
      localObject = ((aoan)localObject).c(paramString);
      if (localObject == null) {
        break;
      }
      str = ((PublicAccountInfo)localObject).name;
      if (!isValideName(str, paramString)) {
        break;
      }
      localObject = str;
    } while (!QLog.isColorLevel());
    QLog.d("ContactUtils", 2, StringUtil.makeLogMsg(new Object[] { "getBuddyName()", paramString, Boolean.valueOf(paramBoolean) }));
    return str;
    if (paramBoolean) {
      ((ansj)paramQQAppInterface.getManager(QQManagerFactory.CONTACT_FACADE)).a().b(paramString);
    }
    return paramString;
  }
  
  public static String getBuddyNickName(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean)
  {
    if ((paramString == null) || ("".equals(paramString))) {
      localObject1 = "";
    }
    do
    {
      return localObject1;
      localObject1 = paramString;
    } while (paramQQAppInterface == null);
    Object localObject1 = (anvk)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    if (localObject1 != null)
    {
      Object localObject2 = ((anvk)localObject1).e(paramString);
      if (localObject2 != null)
      {
        localObject2 = ((Friends)localObject2).name;
        if (localObject2 != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ContactUtils", 2, StringUtil.makeLogMsg(new Object[] { "FriendEntity getBuddyNickName()", paramString, Boolean.valueOf(paramBoolean) }));
          }
          return localObject2;
        }
      }
    }
    if (localObject1 != null) {}
    for (localObject1 = ((anvk)localObject1).b(paramString);; localObject1 = null)
    {
      if (localObject1 != null)
      {
        localObject1 = ((Card)localObject1).strNick;
        if (localObject1 != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ContactUtils", 2, StringUtil.makeLogMsg(new Object[] { "FriendCard getBuddyNickName()", paramString, Boolean.valueOf(paramBoolean) }));
          }
          return localObject1;
        }
      }
      if (paramBoolean) {
        ((ansj)paramQQAppInterface.getManager(QQManagerFactory.CONTACT_FACADE)).a().b(paramString);
      }
      localObject1 = paramString;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ContactUtils", 2, StringUtil.makeLogMsg(new Object[] { "getBuddyNickName()", paramString, Boolean.valueOf(paramBoolean) }));
      return paramString;
    }
  }
  
  private static String getCombinedStr(int paramInt, String paramString1, String paramString2)
  {
    String str;
    if (paramInt <= 0)
    {
      str = "";
      return str;
    }
    if (paramString1 != null) {}
    for (;;)
    {
      str = paramString1;
      if (TextUtils.isEmpty(paramString2)) {
        break;
      }
      StringBuilder localStringBuilder = new StringBuilder().append(paramString1);
      if (paramString1.length() != 0) {}
      for (str = "、";; str = "")
      {
        str = str + paramString2;
        if (countByByte(str) > paramInt) {
          break;
        }
        return str;
      }
      str = paramString2;
      if (paramString1.length() != 0) {
        str = "、" + paramString2;
      }
      int j = countByByte(paramString1);
      paramString2 = new StringBuilder();
      int i = 0;
      while (i < str.length())
      {
        int k = str.codePointAt(i);
        int m = Character.charCount(k);
        i += m;
        paramString2.appendCodePoint(k);
        if (countByByte(paramString2.toString()) > paramInt - j) {
          paramString2.delete(paramString2.length() - m, paramString2.length());
        }
      }
      paramString2 = paramString2.toString();
      str = paramString1;
      if (paramString2.equals("、")) {
        break;
      }
      return paramString1 + paramString2;
      paramString1 = "";
    }
  }
  
  public static String getDateNickName(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramString == null) || ("".equals(paramString)))
    {
      localObject = "";
      return localObject;
    }
    if (TextUtils.equals(paramString, AppConstants.MSG_BOX_DAREN_ASSISTANT_UIN)) {
      return BaseApplicationImpl.getContext().getString(2131694130);
    }
    if (TextUtils.equals(paramString, AppConstants.MSG_BOX_YANZHI_UIN)) {
      return BaseApplicationImpl.getContext().getString(2131694135);
    }
    long l = 0L;
    Object localObject = ((anvk)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(paramString);
    String str;
    if (localObject != null)
    {
      str = ((DateNickNameInfo)localObject).nickName;
      l = ((DateNickNameInfo)localObject).lastUpdateTime;
    }
    for (;;)
    {
      if (str != null)
      {
        localObject = str;
        if (Math.abs(System.currentTimeMillis() - l) < 86400000L) {
          break;
        }
      }
      if (str == null) {
        str = "";
      }
      for (;;)
      {
        ((ansj)paramQQAppInterface.getManager(QQManagerFactory.CONTACT_FACADE)).a().c(paramString);
        return str;
      }
      str = null;
    }
  }
  
  private static String getDiscussionCombinedName(QQAppInterface paramQQAppInterface, String paramString, Map<String, DiscussionMemberInfo> paramMap)
  {
    Object localObject = "";
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString)) || (paramMap == null) || (paramMap.size() == 0))
    {
      paramString = (String)localObject;
      if (QLog.isColorLevel())
      {
        QLog.i("ContactUtils", 2, " === getDiscussionCombinedName app is null or ownerUin is null or members is null or members size is 0 ====");
        paramString = (String)localObject;
      }
      return paramString;
    }
    localObject = new ansn(paramQQAppInterface, paramString, paramQQAppInterface.getCurrentAccountUin());
    ArrayList localArrayList = new ArrayList(paramMap.values());
    for (paramString = "";; paramString = paramMap)
    {
      if (localArrayList.size() <= 0) {
        return paramString;
      }
      paramMap = (DiscussionMemberInfo)Collections.min(localArrayList, (Comparator)localObject);
      localArrayList.remove(paramMap);
      paramMap = getCombinedStr(48, paramString, getDiscussionMemberName(paramMap, paramQQAppInterface));
      paramString = paramMap;
      if (paramMap.length() >= 47) {
        break;
      }
    }
    return paramString;
  }
  
  public static String getDiscussionMemberName(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    Friends localFriends = ((anvk)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(paramString2);
    if ((localFriends == null) || (!localFriends.isFriend()))
    {
      paramQQAppInterface = ((antp)paramQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER)).a(paramString1, paramString2);
      if (paramQQAppInterface == null) {
        break label77;
      }
      paramQQAppInterface = paramQQAppInterface.inteRemark;
    }
    for (;;)
    {
      if ((paramQQAppInterface == null) || (paramQQAppInterface.trim().length() == 0))
      {
        return paramString2;
        paramQQAppInterface = localFriends.name;
      }
      else
      {
        return paramQQAppInterface;
        label77:
        paramQQAppInterface = "";
      }
    }
  }
  
  public static String getDiscussionMemberName(DiscussionMemberInfo paramDiscussionMemberInfo, QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = ((anvk)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(paramDiscussionMemberInfo.memberUin);
    if ((paramQQAppInterface != null) && (paramQQAppInterface.isFriend())) {}
    for (Object localObject = paramQQAppInterface.getFriendNick();; localObject = paramDiscussionMemberInfo.inteRemark)
    {
      paramQQAppInterface = (QQAppInterface)localObject;
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        paramQQAppInterface = paramDiscussionMemberInfo.memberName;
      }
      localObject = paramQQAppInterface;
      if (TextUtils.isEmpty(paramQQAppInterface)) {
        localObject = paramDiscussionMemberInfo.memberUin;
      }
      return localObject;
    }
  }
  
  public static String getDiscussionMemberShowName(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    anvk localanvk = (anvk)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    Object localObject1 = (antp)paramQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER);
    if (paramString2 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ContactUtils", 2, "getDiscussionMemberShowName uin is null");
      }
      paramQQAppInterface = "";
      return paramQQAppInterface;
    }
    Object localObject2 = ((antp)localObject1).a(paramString1);
    if ((localObject2 != null) && (((DiscussionInfo)localObject2).isDiscussHrMeeting())) {}
    for (boolean bool = true;; bool = false)
    {
      localObject2 = localanvk.b(paramString2);
      if ((localObject2 != null) && (((Friends)localObject2).isFriend()) && (!bool))
      {
        if (!TextUtils.isEmpty(((Friends)localObject2).remark)) {
          return ((Friends)localObject2).remark;
        }
        if (!TextUtils.isEmpty(((Friends)localObject2).name)) {
          return ((Friends)localObject2).name;
        }
        paramQQAppInterface = paramString2;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ContactUtils", 2, "getDiscussionMemberShowName is friend but no name.");
        return paramString2;
      }
      localObject1 = ((antp)localObject1).a(paramString1);
      if (localObject1 != null)
      {
        localObject2 = (DiscussionMemberInfo)((Map)localObject1).get(paramString2);
        if (localObject2 != null)
        {
          localObject1 = ((DiscussionMemberInfo)localObject2).inteRemark;
          localObject2 = ((DiscussionMemberInfo)localObject2).memberName;
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            if (QLog.isDevelopLevel()) {
              QLog.w("ContactUtils", 1, "getDiscussionMemberShowName, discussionShowName[" + bhbx.a((String)localObject1) + "], discussionUin[" + paramString1 + "], memberUin[" + paramString2 + "], bIsDiscHrMeeting[" + bool + "]");
            }
            if (localObject1 != null)
            {
              paramString1 = (String)localObject1;
              if (((String)localObject1).trim().length() != 0) {}
            }
            else
            {
              if (!bool) {
                break label321;
              }
              paramString1 = bhgf.a();
            }
          }
        }
      }
      for (;;)
      {
        return paramString1;
        localObject1 = localObject2;
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          break;
        }
        localObject1 = null;
        break;
        label321:
        paramString1 = localanvk.e(paramString2);
        if (paramString1 != null)
        {
          paramString1 = paramString1.name;
        }
        else
        {
          ((FriendListHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getFriendInfo(paramString2, false);
          paramString1 = paramString2;
        }
      }
    }
  }
  
  public static String getDiscussionMemberShowName(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, MessageRecord paramMessageRecord)
  {
    String str = null;
    if (paramMessageRecord != null) {
      str = paramMessageRecord.getExtInfoFromExtStr("troop_msg_nickname");
    }
    paramMessageRecord = str;
    if (TextUtils.isEmpty(str)) {
      paramMessageRecord = getDiscussionMemberShowName(paramQQAppInterface, paramString1, paramString2);
    }
    return paramMessageRecord;
  }
  
  public static String getDiscussionName(Context paramContext, DiscussionInfo paramDiscussionInfo)
  {
    String str = "";
    if (paramDiscussionInfo != null) {
      str = paramDiscussionInfo.discussionName;
    }
    if (str != null)
    {
      paramDiscussionInfo = str;
      if (str.length() != 0) {}
    }
    else
    {
      paramDiscussionInfo = paramContext.getResources().getString(2131691722);
    }
    return paramDiscussionInfo;
  }
  
  public static String getDiscussionName(QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
  {
    paramQQAppInterface = (antp)paramQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER);
    if (paramQQAppInterface != null) {}
    for (paramQQAppInterface = paramQQAppInterface.a(paramString);; paramQQAppInterface = null) {
      return getDiscussionName(paramContext, paramQQAppInterface);
    }
  }
  
  public static String getDiscussionNameCanNull(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = ((antp)paramQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER)).a(paramString);
    if ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramQQAppInterface.discussionName))) {
      return paramQQAppInterface.discussionName;
    }
    return null;
  }
  
  public static String getDiscussionNameDefaultUin(QQAppInterface paramQQAppInterface, String paramString)
  {
    DiscussionInfo localDiscussionInfo = ((antp)paramQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER)).a(paramString);
    paramQQAppInterface = paramString;
    if (localDiscussionInfo != null)
    {
      paramQQAppInterface = paramString;
      if (!TextUtils.isEmpty(localDiscussionInfo.discussionName)) {
        paramQQAppInterface = localDiscussionInfo.discussionName;
      }
    }
    return paramQQAppInterface;
  }
  
  public static String getDisplayName(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    Object localObject = (ansj)paramQQAppInterface.getManager(QQManagerFactory.CONTACT_FACADE);
    antp localantp = (antp)paramQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER);
    localObject = (anvk)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    TroopManager localTroopManager = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    if ((localObject != null) && (paramInt1 != 1) && (paramInt1 != 7) && (paramInt1 != 6) && (paramInt1 != 2) && (paramInt1 != 5)) {}
    for (localObject = ((anvk)localObject).e(paramString1);; localObject = null)
    {
      switch (paramInt1)
      {
      case 5: 
      default: 
        if ((localObject != null) && (!TextUtils.isEmpty(((Friends)localObject).name))) {
          paramQQAppInterface = ((Friends)localObject).name;
        }
        break;
      }
      for (;;)
      {
        if (TextUtils.isEmpty(paramQQAppInterface))
        {
          return paramString1;
          paramQQAppInterface = getDisplayNameForEntryFriendList(paramInt2, paramString1, (Friends)localObject, ((awyz)paramQQAppInterface.getManager(QQManagerFactory.CONTACT_MANAGER)).a(paramString1));
          continue;
          paramQQAppInterface = getNickName(paramQQAppInterface, paramString1, 1008);
          continue;
          switch (paramInt2)
          {
          case 1: 
          case 2: 
          default: 
            paramQQAppInterface = paramString1;
            break;
          case 0: 
          case 3: 
            paramQQAppInterface = localTroopManager.a(paramString2, paramString1);
            continue;
            paramQQAppInterface = getDiscussionMemberShowName(paramQQAppInterface, paramString2, paramString1);
            continue;
            paramQQAppInterface = getDisplayNameForEntryPhoneContactList(paramInt2, paramString1, (Friends)localObject, ((awyz)paramQQAppInterface.getManager(QQManagerFactory.CONTACT_MANAGER)).a(paramString1));
            continue;
            paramQQAppInterface = getDisplayNameForEntryFriendRecommendList(paramInt2, paramString1, (Friends)localObject, ((awyz)paramQQAppInterface.getManager(QQManagerFactory.CONTACT_MANAGER)).a(paramString1));
            continue;
            paramQQAppInterface = getDiscussionName(paramQQAppInterface.getApp(), localantp.a(paramString1));
            continue;
            paramQQAppInterface = localTroopManager.b(paramString1);
            if (paramQQAppInterface == null) {
              break label364;
            }
            paramQQAppInterface = paramQQAppInterface.getTroopName();
            break;
          }
        }
        else
        {
          return paramQQAppInterface;
          label364:
          paramQQAppInterface = null;
        }
      }
    }
  }
  
  private static String getDisplayNameForEntryFriendList(int paramInt, String paramString, Friends paramFriends, PhoneContact paramPhoneContact)
  {
    switch (paramInt)
    {
    case 1: 
    case 2: 
    default: 
      return "";
    }
    if (paramFriends != null)
    {
      if (!TextUtils.isEmpty(paramFriends.remark)) {
        return paramFriends.remark;
      }
      return paramFriends.name;
    }
    return paramString;
  }
  
  private static String getDisplayNameForEntryFriendRecommendList(int paramInt, String paramString, Friends paramFriends, PhoneContact paramPhoneContact)
  {
    switch (paramInt)
    {
    case 1: 
    case 2: 
    default: 
      return "";
    }
    if ((paramFriends != null) && (paramFriends.isFriend()))
    {
      if (!TextUtils.isEmpty(paramFriends.remark)) {
        return paramFriends.remark;
      }
      return paramFriends.name;
    }
    if (paramPhoneContact != null) {
      return paramPhoneContact.name;
    }
    if ((paramFriends != null) && (!TextUtils.isEmpty(paramFriends.name))) {
      return paramFriends.name;
    }
    return paramString;
  }
  
  private static String getDisplayNameForEntryPhoneContactList(int paramInt, String paramString, Friends paramFriends, PhoneContact paramPhoneContact)
  {
    String str;
    switch (paramInt)
    {
    case 1: 
    case 2: 
    default: 
      str = "";
    }
    do
    {
      do
      {
        do
        {
          return str;
          str = paramString;
        } while (paramPhoneContact == null);
        return paramPhoneContact.name;
        if ((paramFriends != null) && (paramFriends.isFriend()))
        {
          if (!TextUtils.isEmpty(paramFriends.remark)) {}
          for (paramString = paramFriends.remark;; paramString = paramFriends.name) {
            return paramString;
          }
        }
        if (paramPhoneContact != null) {
          return paramPhoneContact.name;
        }
        str = paramString;
      } while (paramFriends == null);
      str = paramString;
    } while (TextUtils.isEmpty(paramFriends.name));
    return paramFriends.name;
  }
  
  public static int getEntry(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return -1;
    case 0: 
    case 1005: 
    case 1023: 
    case 1025: 
      return 0;
    case 1008: 
    case 1024: 
      return 8;
    case 3: 
    case 4: 
    case 1006: 
      return 3;
    case 2: 
    case 1000: 
    case 1020: 
      return 1;
    case 1001: 
    case 1002: 
    case 1003: 
    case 1009: 
    case 10002: 
    case 10004: 
      return 4;
    case 1021: 
      return 5;
    case 1004: 
      return 2;
    case 1: 
      return 6;
    }
    return 7;
  }
  
  public static String getFitString(String paramString, float paramFloat)
  {
    String str = paramString;
    int i;
    int j;
    if (getTextHRatio(paramString) > paramFloat)
    {
      i = Math.max(0, (int)(paramFloat - 3.0F));
      j = i;
    }
    for (;;)
    {
      if ((i >= paramString.length()) || (getTextHRatio(paramString.substring(0, i) + "…") > paramFloat))
      {
        str = paramString.substring(0, j) + "…";
        return str;
      }
      j = i;
      i += 1;
    }
  }
  
  @NotNull
  public static String getFriendDisplayName(QQAppInterface paramQQAppInterface, String paramString)
  {
    Friends localFriends = ((anvk)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).e(paramString);
    paramQQAppInterface = (awyz)paramQQAppInterface.getManager(QQManagerFactory.CONTACT_MANAGER);
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.a(paramString);
      if (paramQQAppInterface == null) {}
    }
    for (paramQQAppInterface = paramQQAppInterface.name;; paramQQAppInterface = null)
    {
      if (localFriends != null) {
        paramString = getFriendName(localFriends, paramQQAppInterface);
      }
      return paramString;
    }
  }
  
  public static String getFriendDisplayName2(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramString = ((anvk)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).e(paramString);
    paramQQAppInterface = (awyz)paramQQAppInterface.getManager(QQManagerFactory.CONTACT_MANAGER);
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.a("");
      if (paramQQAppInterface == null) {}
    }
    for (paramQQAppInterface = paramQQAppInterface.name;; paramQQAppInterface = null)
    {
      if (paramString != null) {
        return getFriendName2(paramString, paramQQAppInterface);
      }
      return "";
    }
  }
  
  @NotNull
  public static String getFriendDisplayNameJustCache(QQAppInterface paramQQAppInterface, String paramString)
  {
    Friends localFriends = ((anvk)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).c(paramString);
    paramQQAppInterface = (awyz)paramQQAppInterface.getManager(QQManagerFactory.CONTACT_MANAGER);
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.a(paramString);
      if (paramQQAppInterface == null) {}
    }
    for (paramQQAppInterface = paramQQAppInterface.name;; paramQQAppInterface = null)
    {
      if (localFriends != null) {
        paramString = getFriendName(localFriends, paramQQAppInterface);
      }
      return paramString;
    }
  }
  
  public static String getFriendName(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = ((anvk)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).e(paramString);
    if (paramQQAppInterface != null) {
      paramString = paramQQAppInterface.getFriendName();
    }
    return paramString;
  }
  
  @Deprecated
  public static String getFriendName(Friends paramFriends)
  {
    return paramFriends.getFriendNickWithAlias();
  }
  
  private static String getFriendName(Friends paramFriends, String paramString)
  {
    String str;
    if ((paramFriends.remark != null) && (paramFriends.remark.length() > 0)) {
      str = paramFriends.remark;
    }
    do
    {
      return str;
      if (paramString == null) {
        break;
      }
      str = paramString;
    } while (paramString.length() > 0);
    if ((paramFriends.name != null) && (paramFriends.name.length() > 0)) {
      return paramFriends.name;
    }
    return paramFriends.uin;
  }
  
  private static String getFriendName2(Friends paramFriends, String paramString)
  {
    String str;
    if ((paramFriends.remark != null) && (paramFriends.remark.length() > 0)) {
      str = paramFriends.remark;
    }
    do
    {
      return str;
      if (paramString == null) {
        break;
      }
      str = paramString;
    } while (paramString.length() > 0);
    if ((paramFriends.name != null) && (paramFriends.name.length() > 0)) {
      return paramFriends.name;
    }
    return "";
  }
  
  public static String getFriendNameCheckFriends(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      paramQQAppInterface = "";
    }
    Friends localFriends;
    do
    {
      do
      {
        do
        {
          return paramQQAppInterface;
          localFriends = ((anvk)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(paramString);
          paramQQAppInterface = paramString;
        } while (localFriends == null);
        paramQQAppInterface = paramString;
      } while (!localFriends.isFriend());
      if (!TextUtils.isEmpty(localFriends.remark)) {
        return localFriends.remark;
      }
      paramQQAppInterface = paramString;
    } while (TextUtils.isEmpty(localFriends.name));
    return localFriends.name;
  }
  
  public static String getFriendNick(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = ((anvk)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).e(paramString);
    if (paramQQAppInterface != null) {
      paramString = paramQQAppInterface.getFriendNick();
    }
    return paramString;
  }
  
  public static String getFriendNickName(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = (anvk)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    Object localObject = paramQQAppInterface.e(paramString);
    if ((localObject != null) && (!TextUtils.isEmpty(((Friends)localObject).name))) {
      paramQQAppInterface = ((Friends)localObject).name;
    }
    do
    {
      do
      {
        return paramQQAppInterface;
        localObject = paramQQAppInterface.b(paramString);
        paramQQAppInterface = paramString;
      } while (localObject == null);
      paramQQAppInterface = paramString;
    } while (TextUtils.isEmpty(((Card)localObject).strNick));
    return ((Card)localObject).strNick;
  }
  
  public static String getFriendShowName(QQAppInterface paramQQAppInterface, String paramString)
  {
    Friends localFriends = ((anvk)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).e(paramString);
    paramQQAppInterface = (awyz)paramQQAppInterface.getManager(QQManagerFactory.CONTACT_MANAGER);
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.a(paramString);
      if (paramQQAppInterface == null) {}
    }
    for (paramQQAppInterface = paramQQAppInterface.name;; paramQQAppInterface = null)
    {
      if (localFriends != null)
      {
        if ((localFriends.remark != null) && (localFriends.remark.length() > 0)) {
          paramString = localFriends.remark;
        }
      }
      else {
        return paramString;
      }
      if ((localFriends.name != null) && (localFriends.name.length() > 0)) {
        return localFriends.name;
      }
      if ((paramQQAppInterface != null) && (paramQQAppInterface.length() > 0)) {
        return paramQQAppInterface;
      }
      return localFriends.uin;
    }
  }
  
  public static int getFriendStatus(int paramInt1, int paramInt2)
  {
    int i = 4;
    switch (paramInt1)
    {
    default: 
      paramInt1 = 0;
      if ((paramInt2 == 69378) || (paramInt2 == 73474) || (paramInt2 == 73730)) {
        i = 0;
      }
      break;
    }
    while ((paramInt1 != 0) && (paramInt1 != 1) && (paramInt1 != 2) && (paramInt1 != 7) && (paramInt1 != 6) && (paramInt1 != 3) && (paramInt1 != 4) && (ajlh.a().a(paramInt2)))
    {
      return i;
      paramInt1 = 8;
      break;
      paramInt1 = 4;
      break;
      paramInt1 = 0;
      break;
      paramInt1 = 1;
      break;
      paramInt1 = 0;
      break;
      paramInt1 = 2;
      break;
      paramInt1 = 3;
      break;
      paramInt1 = 7;
      break;
      paramInt1 = 4;
      break;
      paramInt1 = 0;
      break;
    }
    return paramInt1;
  }
  
  public static int getFriendStatus(Friends paramFriends)
  {
    switch (getFriendStatus(paramFriends.detalStatusFlag, paramFriends.iTermType))
    {
    case 5: 
    case 6: 
    default: 
      return (int)paramFriends.getLastLoginType() + 20;
    case 1: 
      return 2;
    case 2: 
    case 7: 
      return 1;
    }
    return 0;
  }
  
  public static int getFriendTermType(Friends paramFriends, QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = (FriendListHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
    int i = getFriendStatus(paramFriends.detalStatusFlag, paramFriends.iTermType);
    if ((i != 0) && (i != 6))
    {
      ajlh localajlh = ajlh.a();
      if (1 == localajlh.a(paramFriends.iTermType, 0))
      {
        if (paramQQAppInterface.getShowPcOnlineIconConfig()) {
          return 2;
        }
        return 3;
      }
      if (2 == localajlh.a(paramFriends.iTermType, 0)) {
        return 1;
      }
      if (3 == localajlh.a(paramFriends.iTermType, 0)) {
        return 0;
      }
      if (paramQQAppInterface.getShowPcOnlineIconConfig()) {
        return 2;
      }
      return 3;
    }
    if (paramFriends.showLoginClient == 1L) {
      return 2;
    }
    if (paramFriends.showLoginClient == 3L) {
      return 0;
    }
    if (paramFriends.showLoginClient == 2L) {
      return 1;
    }
    return 3;
  }
  
  public static String getGrayBarShowName(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    Friends localFriends = ((anvk)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(paramString2);
    if ((localFriends != null) && (!TextUtils.isEmpty(localFriends.remark))) {
      paramString2 = localFriends.remark;
    }
    TroopMemberInfo localTroopMemberInfo;
    do
    {
      do
      {
        return paramString2;
        localTroopMemberInfo = ((TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(paramString1, paramString2);
        if (localTroopMemberInfo == null) {
          break label153;
        }
        if (!TextUtils.isEmpty(localTroopMemberInfo.troopnick)) {
          return localTroopMemberInfo.troopnick;
        }
        if ((localFriends != null) && (!TextUtils.isEmpty(localFriends.name))) {
          return localFriends.name;
        }
        if (!paramString2.equals(paramQQAppInterface.getCurrentAccountUin())) {
          break;
        }
      } while (TextUtils.isEmpty(localTroopMemberInfo.friendnick));
      return localTroopMemberInfo.friendnick;
      if (!TextUtils.isEmpty(localTroopMemberInfo.autoremark)) {
        return localTroopMemberInfo.autoremark;
      }
    } while (TextUtils.isEmpty(localTroopMemberInfo.friendnick));
    return localTroopMemberInfo.friendnick;
    label153:
    ((aoep)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).a(Long.parseLong(paramString1), Long.parseLong(paramString2));
    return paramString2;
  }
  
  public static ContactUtils.NameInfo getGrayBarShowNameInCache(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    Friends localFriends = ((anvk)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(paramString2);
    if ((localFriends != null) && (!TextUtils.isEmpty(localFriends.remark))) {
      return new ContactUtils.NameInfo(localFriends.remark, false);
    }
    paramString1 = ((TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).a(paramString1, paramString2);
    boolean bool;
    if (paramString1 != null) {
      if (!TextUtils.isEmpty(paramString1.troopnick))
      {
        paramString2 = paramString1.troopnick;
        bool = false;
      }
    }
    for (;;)
    {
      return new ContactUtils.NameInfo(paramString2, bool);
      if ((localFriends != null) && (!TextUtils.isEmpty(localFriends.name)))
      {
        paramString2 = localFriends.name;
        bool = false;
      }
      else
      {
        if (paramString2.equals(paramQQAppInterface.getCurrentAccountUin()))
        {
          if (!TextUtils.isEmpty(paramString1.friendnick))
          {
            paramString2 = paramString1.friendnick;
            bool = false;
          }
        }
        else
        {
          if (!TextUtils.isEmpty(paramString1.autoremark))
          {
            paramString2 = paramString1.autoremark;
            bool = false;
            continue;
          }
          if (!TextUtils.isEmpty(paramString1.friendnick))
          {
            paramString2 = paramString1.friendnick;
            bool = false;
            continue;
            bool = true;
            continue;
          }
        }
        bool = false;
      }
    }
  }
  
  public static String getHeadTextFirst(String paramString)
  {
    return paramString.substring(0, 1);
  }
  
  public static String getHeaderText(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    return paramString.trim().substring(0, 1).toUpperCase();
  }
  
  public static String getMemberDisplaynameByIstroop(QQAppInterface paramQQAppInterface, int paramInt, String paramString1, String paramString2)
  {
    String str = "";
    if (paramInt == 1) {
      str = getTroopMemberNameWithoutRemark(paramQQAppInterface, paramString1, paramString2);
    }
    while (paramInt != 3000) {
      return str;
    }
    return getDiscussionMemberShowName(paramQQAppInterface, paramString1, paramString2);
  }
  
  public static String getNetDescription(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "2G网络";
    case 1: 
      return "WIFI网络";
    case 2: 
      return "2G网络";
    case 3: 
      return "3G网络";
    case 4: 
      return "4G网络";
    case 12: 
      return "5G网络";
    case 5: 
      return anvx.a(2131702071);
    case 6: 
      return anvx.a(2131702073);
    case 7: 
      return anvx.a(2131702075);
    case 8: 
      return anvx.a(2131702074);
    case 9: 
      return anvx.a(2131702077);
    case 100: 
      return "iPhone在线";
    case 101: 
      return anvx.a(2131702072);
    }
    return "TIM在线";
  }
  
  public static int getNetIconTypeResId(int paramInt)
  {
    switch (paramInt)
    {
    case 2: 
    default: 
      return 2130850584;
    case 1: 
      return 2130850606;
    case 3: 
      return 2130850585;
    case 4: 
      return 2130850586;
    case 5: 
      return 2130850601;
    case 6: 
      return 2130850599;
    case 7: 
      return 2130850604;
    case 8: 
      return 2130850588;
    case 9: 
      return 2130850591;
    case 100: 
      return 2130850594;
    }
    return 2130850597;
  }
  
  public static String getNetOnlineStatus(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "2G在线";
    case 1: 
      return "WiFi在线";
    case 2: 
      return "2G在线";
    case 3: 
      return "3G在线";
    case 4: 
      return "4G在线";
    case 12: 
      return "5G在线";
    case 5: 
      return anvx.a(2131702070);
    case 6: 
      return anvx.a(2131702081);
    case 7: 
      return anvx.a(2131702076);
    case 8: 
      return "BMW QQ在线";
    case 9: 
      return "车载QQ在线";
    case 100: 
      return "iPhone在线";
    case 101: 
      return anvx.a(2131702078);
    case 10: 
      return "TIM在线";
    }
    return anvx.a(2131702080);
  }
  
  public static String getNick(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    String str;
    if (paramInt == 1) {
      str = getTroopNameByID(paramQQAppInterface, paramString);
    }
    do
    {
      return str;
      if (3000 == paramInt) {
        return getDiscussionNameDefaultUin(paramQQAppInterface, paramString);
      }
      if (paramInt == 0) {
        break;
      }
      str = paramString;
    } while (1024 != paramInt);
    return getFriendNick(paramQQAppInterface, paramString);
  }
  
  public static String getNickName(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    Object localObject1 = (antp)paramQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER);
    localObject1 = (anvk)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    Object localObject2 = (aoan)paramQQAppInterface.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER);
    if (paramInt == 1) {
      paramQQAppInterface = getTroopNameByID(paramQQAppInterface, paramString);
    }
    do
    {
      do
      {
        return paramQQAppInterface;
        if (3000 == paramInt) {
          return getDiscussionName(paramQQAppInterface, paramQQAppInterface.getApp(), paramString);
        }
        if ((1008 != paramInt) && (1024 != paramInt)) {
          break;
        }
        if (bjxa.b(paramQQAppInterface, paramString)) {
          return bjxa.a(paramQQAppInterface, paramString);
        }
        localObject1 = ((aoan)localObject2).b(paramString);
        if ((localObject1 != null) && (((PublicAccountInfo)localObject1).name != null)) {
          return ((PublicAccountInfo)localObject1).name;
        }
        localObject1 = ((aoan)localObject2).a(paramString);
        if ((localObject1 != null) && (((AccountDetail)localObject1).name != null)) {
          return ((AccountDetail)localObject1).name;
        }
        localObject1 = ((anty)paramQQAppInterface.getManager(QQManagerFactory.EQQ_DETAIL_DATA_MANAGER)).a(paramString);
        paramQQAppInterface = paramString;
      } while (localObject1 == null);
      paramQQAppInterface = paramString;
    } while (((EqqDetail)localObject1).name == null);
    return ((EqqDetail)localObject1).name;
    if (paramInt == 1006)
    {
      paramQQAppInterface = (awyz)paramQQAppInterface.getManager(QQManagerFactory.CONTACT_MANAGER);
      localObject2 = paramQQAppInterface.c(paramString);
      if (localObject2 != null) {
        return ((PhoneContact)localObject2).name;
      }
      localObject2 = paramQQAppInterface.a(paramString);
      if (localObject2 == null) {
        break label301;
      }
      paramQQAppInterface = ((anvk)localObject1).e((String)localObject2);
      if (paramQQAppInterface == null) {
        break label301;
      }
    }
    label301:
    for (localObject1 = getFriendName(paramQQAppInterface);; localObject1 = null)
    {
      paramQQAppInterface = paramString;
      if (localObject1 == null) {
        break;
      }
      paramQQAppInterface = paramString;
      if (((String)localObject1).equals(localObject2)) {
        break;
      }
      return localObject1;
      if ((paramInt == 9500) || (paramInt == 9501)) {
        return absz.a(((abgm)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER)).a(Long.parseLong(paramString)));
      }
      return getFriendNick(paramQQAppInterface, paramString);
    }
  }
  
  public static String getNicknameInSession(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, boolean paramBoolean, String paramString)
  {
    try
    {
      switch (paramSessionInfo.curType)
      {
      }
      String str;
      for (;;)
      {
        if (paramBoolean)
        {
          return paramQQAppInterface.getCurrentNickname();
          return getDisplayName(paramQQAppInterface, paramString, paramSessionInfo.curFriendUin, 1, 0);
          return getDiscussionMemberShowName(paramQQAppInterface, paramSessionInfo.curFriendUin, paramString);
        }
        str = paramSessionInfo.curFriendNick;
        if (str == null) {}
      }
      return str;
    }
    catch (Exception paramQQAppInterface)
    {
      try
      {
        if (str.length() != 0) {
          break label107;
        }
        paramQQAppInterface = getDisplayName(paramQQAppInterface, paramSessionInfo.curFriendUin, "", 0, 0);
        return paramQQAppInterface;
      }
      catch (Exception paramQQAppInterface)
      {
        return str;
      }
      paramQQAppInterface = paramQQAppInterface;
      return paramString;
    }
  }
  
  public static String getPhoneContactFaceText(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return "";
    }
    int m = paramString.length();
    int k = 0;
    int j = 0;
    char c = '\000';
    while (k < m)
    {
      int i = paramString.charAt(k);
      if (k == 0) {
        c = i;
      }
      if (k == 1) {
        j = i;
      }
      if ((i >= 19968) && (i <= 40869)) {
        return String.valueOf(i);
      }
      k += 1;
    }
    if ((c >= '!') && (c <= '~'))
    {
      if ((j >= 33) && (j <= 126)) {
        return String.valueOf(new char[] { c, j });
      }
      return String.valueOf(c);
    }
    return "?";
  }
  
  public static String getPhoneNumByUin(QQAppInterface paramQQAppInterface, String paramString)
  {
    return ((awyz)paramQQAppInterface.getManager(QQManagerFactory.CONTACT_MANAGER)).b(paramString);
  }
  
  public static String getPhoneNumFirst(String paramString)
  {
    String str;
    if (TextUtils.isEmpty(paramString)) {
      str = "";
    }
    do
    {
      return str;
      str = paramString;
    } while (paramString.length() < 3);
    return paramString.substring(0, 3);
  }
  
  public static String getPstnDiscussionName(QQAppInterface paramQQAppInterface, String paramString)
  {
    int j = 0;
    int i = 1;
    Object localObject2 = (antp)paramQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER);
    if (localObject2 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ContactUtils", 2, " ===getPstnDiscussionName dm is null ====");
      }
      localObject2 = "";
      return localObject2;
    }
    Object localObject1 = ((antp)localObject2).a(paramString);
    if (localObject1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ContactUtils", 2, " ===getPstnDiscussionName info is null ====");
      }
      i = 0;
    }
    if ((i != 0) && (((DiscussionInfo)localObject1).hasRenamed())) {
      return getDiscussionName(BaseApplicationImpl.getContext(), (DiscussionInfo)localObject1);
    }
    localObject2 = ((antp)localObject2).a(paramString);
    if (i != 0) {}
    for (localObject1 = getDiscussionCombinedName(paramQQAppInterface, ((DiscussionInfo)localObject1).ownerUin, (Map)localObject2);; localObject1 = "")
    {
      localObject2 = localObject1;
      if (((String)localObject1).length() >= 47) {
        break;
      }
      Object localObject3 = (awyz)paramQQAppInterface.getManager(QQManagerFactory.CONTACT_MANAGER);
      List localList = mtq.a(paramQQAppInterface, paramString, 3000);
      localObject2 = localObject1;
      if (localList == null) {
        break;
      }
      localObject2 = localObject1;
      if (localList.size() == 0) {
        break;
      }
      ArrayList localArrayList = new ArrayList();
      i = j;
      if (i < localList.size())
      {
        localObject2 = ((AVPhoneUserInfo)localList.get(i)).telInfo.mobile;
        paramString = ((awyz)localObject3).b((String)localObject2);
        paramQQAppInterface = "?";
        if (paramString != null) {
          if (!TextUtils.isEmpty(paramString.name))
          {
            paramString = paramString.name;
            paramQQAppInterface = paramString;
            if (paramString.equals(localObject2)) {
              paramQQAppInterface = getPhoneNumFirst(paramString);
            }
          }
        }
        for (;;)
        {
          localArrayList.add(paramQQAppInterface);
          i += 1;
          break;
          if (!TextUtils.isEmpty(paramString.mobileNo))
          {
            paramQQAppInterface = getPhoneNumFirst(paramString.mobileNo);
            continue;
            paramQQAppInterface = getPhoneNumFirst((String)localObject2);
          }
        }
      }
      localObject3 = new anso();
      paramQQAppInterface = (QQAppInterface)localObject1;
      if (localArrayList != null)
      {
        paramQQAppInterface = (QQAppInterface)localObject1;
        if (localArrayList.size() > 0)
        {
          paramQQAppInterface = (QQAppInterface)localObject1;
          if (QLog.isColorLevel())
          {
            QLog.i("ContactUtils", 2, " ===getPstnDiscussionName phoneNames: " + localArrayList.toString());
            paramQQAppInterface = (QQAppInterface)localObject1;
          }
        }
      }
      do
      {
        localObject2 = paramQQAppInterface;
        if (localArrayList.size() <= 0) {
          break;
        }
        paramString = (String)Collections.min(localArrayList, (Comparator)localObject3);
        localArrayList.remove(paramString);
        paramString = getCombinedStr(48, paramQQAppInterface, paramString);
        paramQQAppInterface = paramString;
      } while (paramString.length() < 47);
      return paramString;
    }
  }
  
  public static String getReplySenderNick(QQAppInterface paramQQAppInterface, int paramInt, String paramString1, String paramString2)
  {
    if (paramInt == 3000) {
      return getDiscussionMemberShowName(paramQQAppInterface, paramString1, paramString2);
    }
    if (paramInt == 1)
    {
      paramString1 = getTroopMemberNameWithoutRemark(paramQQAppInterface, paramString1, paramString2);
      if (TextUtils.isEmpty(paramString1))
      {
        ((FriendListHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getFriendInfo(paramString2, false);
        return paramString2;
      }
      return paramString1;
    }
    return getReplyShowName(paramQQAppInterface, paramString2);
  }
  
  public static String getReplyShowName(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (TextUtils.equals(paramString, paramQQAppInterface.getCurrentAccountUin()))
    {
      localObject = ((anvk)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).e(paramString);
      if (localObject != null)
      {
        if (!TextUtils.isEmpty(((Friends)localObject).name)) {
          paramString = ((Friends)localObject).name;
        }
        return paramString;
      }
      ((FriendListHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getFriendInfo(paramString, false);
      return paramString;
    }
    Object localObject = getFriendShowName(paramQQAppInterface, paramString);
    if (((String)localObject).equals(paramString)) {
      ((FriendListHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getFriendInfo(paramString, false);
    }
    return localObject;
  }
  
  public static String getRequestPathKey()
  {
    return sRequestBindPathTag;
  }
  
  public static String getSelfDiscussionMemberName(QQAppInterface paramQQAppInterface, DiscussionMemberInfo paramDiscussionMemberInfo)
  {
    String str1 = paramDiscussionMemberInfo.memberUin;
    if (!TextUtils.isEmpty(paramDiscussionMemberInfo.inteRemark)) {}
    for (str1 = paramDiscussionMemberInfo.inteRemark;; str1 = paramDiscussionMemberInfo.memberName)
    {
      String str2 = str1;
      if (TextUtils.isEmpty(str1)) {
        str2 = getFriendNickName(paramQQAppInterface, paramDiscussionMemberInfo.memberUin);
      }
      return str2;
    }
  }
  
  public static String getSelfNetWorkType()
  {
    switch ()
    {
    case 5: 
    default: 
      return "";
    case 2: 
      return " - 2G";
    case 3: 
      return " - 3G";
    case 4: 
      return " - 4G";
    case 6: 
      return " - 5G";
    }
    return " - WiFi";
  }
  
  public static String getStatusName(Friends paramFriends)
  {
    Object localObject2 = null;
    int i = getFriendStatus(paramFriends.detalStatusFlag, paramFriends.iTermType);
    Object localObject1 = localObject2;
    if (i == 4)
    {
      localObject1 = localObject2;
      if (!isInvisibleFriendNetworkStatus(paramFriends)) {
        localObject1 = getStatusNamePlusNetWorkType(paramFriends.getNetWorkType());
      }
    }
    String str = paramFriends.strTermDesc;
    localObject2 = str;
    if (i == 4)
    {
      localObject2 = str;
      if (bhmz.a(paramFriends.customOnlineStatusType))
      {
        localObject2 = str;
        if (!TextUtils.isEmpty(paramFriends.customOnlineStatus)) {
          localObject2 = paramFriends.customOnlineStatus;
        }
      }
    }
    if ((localObject1 != null) && (!TextUtils.isEmpty((CharSequence)localObject2))) {
      return (String)localObject2 + (String)localObject1;
    }
    return localObject2;
  }
  
  public static String getStatusName(PhoneContact paramPhoneContact)
  {
    String str2 = paramPhoneContact.strTermDesc;
    String str1 = str2;
    if (getFriendStatus(paramPhoneContact.detalStatusFlag, paramPhoneContact.iTermType) == 4)
    {
      str1 = str2;
      if (!TextUtils.isEmpty(str2))
      {
        str1 = str2;
        if (!isInvisibleContactNetworkStatus(paramPhoneContact)) {
          str1 = str2 + getStatusNamePlusNetWorkType(paramPhoneContact.getNetWorkType());
        }
      }
    }
    return str1;
  }
  
  public static String getStatusNamePlusNetWorkType(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 2: 
      return " - 2G";
    case 3: 
      return " - 3G";
    case 4: 
      return " - 4G";
    case 5: 
      return " - 5G";
    }
    return " - WiFi";
  }
  
  public static String getStatusString(Context paramContext, int paramInt)
  {
    int i = 4;
    switch (paramInt)
    {
    case 95: 
    case 100: 
    case 101: 
    default: 
      i = 0;
    }
    for (;;)
    {
      switch (i)
      {
      case 5: 
      case 6: 
      default: 
        return paramContext.getString(2131718976);
        i = 0;
        continue;
        i = 1;
        continue;
        i = 0;
        continue;
        i = 2;
        continue;
        i = 3;
        continue;
        i = 7;
      }
    }
    return paramContext.getString(2131718967);
    return paramContext.getString(2131718969);
    return paramContext.getString(2131718977);
  }
  
  public static String getTeamworkAuthorzShowName(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    if (paramInt == 1) {
      return getTroopMemberNameWithoutRemark(paramQQAppInterface, paramString2, paramString1);
    }
    return getDiscussionMemberShowName(paramQQAppInterface, paramString2, paramString1);
  }
  
  public static float getTextHRatio(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      sPaint.setTextSize(36.0F);
      return sPaint.measureText(paramString) / 36.0F;
    }
    return 1.0F;
  }
  
  public static String getTroopMemberColorNick(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    if (paramQQAppInterface == null) {
      return "";
    }
    paramQQAppInterface = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ContactUtils", 2, "getTroopMemberNick uin is null");
      }
      return "";
    }
    paramQQAppInterface = paramQQAppInterface.b(paramString1, paramString2);
    if ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramQQAppInterface.troopColorNick))) {
      return paramQQAppInterface.troopColorNick;
    }
    return "";
  }
  
  public static int getTroopMemberColorNickId(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    if (paramQQAppInterface == null) {}
    do
    {
      return 0;
      paramQQAppInterface = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
      if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ContactUtils", 2, "getTroopMemberNick uin is null");
    return 0;
    paramQQAppInterface = paramQQAppInterface.b(paramString1, paramString2);
    if ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramQQAppInterface.troopColorNick))) {}
    for (int i = paramQQAppInterface.troopColorNickId;; i = 0) {
      return i;
    }
  }
  
  public static String getTroopMemberName(QQAppInterface paramQQAppInterface, TroopMemberInfo paramTroopMemberInfo)
  {
    if (paramTroopMemberInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ContactUtils", 2, "getTroopMemberNamexxx uin is null");
      }
      return "";
    }
    return getTroopMemberName(paramQQAppInterface, paramTroopMemberInfo.troopuin, paramTroopMemberInfo.memberuin);
  }
  
  public static String getTroopMemberName(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    return getTroopMemberName(paramQQAppInterface, paramString1, paramString2, false);
  }
  
  public static String getTroopMemberName(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, boolean paramBoolean)
  {
    Object localObject1 = (anvk)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    TroopManager localTroopManager = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ContactUtils", 2, "getTroopMemberName uin is null");
      }
      localObject1 = "";
      return localObject1;
    }
    Friends localFriends = ((anvk)localObject1).b(paramString2);
    TroopMemberInfo localTroopMemberInfo = localTroopManager.b(paramString1, paramString2);
    if ((localTroopMemberInfo != null) && (paramBoolean) && (!TextUtils.isEmpty(localTroopMemberInfo.troopColorNick))) {
      localObject1 = localTroopMemberInfo.troopColorNick;
    }
    for (;;)
    {
      label104:
      Object localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject2 = localObject1;
        if (bghs.b(paramQQAppInterface, paramString2))
        {
          localObject2 = localObject1;
          if (localFriends != null)
          {
            localObject2 = localObject1;
            if (localFriends.isFriend())
            {
              localObject2 = localObject1;
              if (localTroopMemberInfo != null) {
                if (TextUtils.isEmpty(localTroopMemberInfo.autoremark)) {
                  break label378;
                }
              }
            }
          }
        }
      }
      label378:
      for (localObject2 = localTroopMemberInfo.autoremark;; localObject2 = localTroopMemberInfo.friendnick)
      {
        paramQQAppInterface = (QQAppInterface)localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          paramQQAppInterface = paramString2;
        }
        localObject1 = paramQQAppInterface;
        if (paramQQAppInterface == null) {
          break;
        }
        localObject1 = paramQQAppInterface;
        if (!paramQQAppInterface.equals(paramString2)) {
          break;
        }
        paramString1 = localTroopManager.b(paramString1);
        localObject1 = paramQQAppInterface;
        if (paramString1 == null) {
          break;
        }
        localObject1 = paramQQAppInterface;
        if (!paramString1.isQidianPrivateTroop()) {
          break;
        }
        return TroopInfo.QIDIAN_TROOP_MEMBER_DEF_NICK;
        if ((localTroopMemberInfo != null) && (!paramBoolean) && (!TextUtils.isEmpty(localTroopMemberInfo.troopnick)))
        {
          localObject1 = localTroopMemberInfo.troopnick;
          break label104;
        }
        if ((localFriends != null) && (localFriends.isFriend()) && (!TextUtils.isEmpty(localFriends.remark)))
        {
          localObject1 = localFriends.remark;
          break label104;
        }
        if ((localFriends != null) && (localFriends.isFriend()))
        {
          localObject1 = localFriends.name;
          break label104;
        }
        if (localTroopMemberInfo == null) {
          break label388;
        }
        if (paramString2.equals(paramQQAppInterface.getCurrentAccountUin()))
        {
          localObject1 = paramQQAppInterface.getCurrentNickname();
          break label104;
        }
        if (!TextUtils.isEmpty(localTroopMemberInfo.autoremark))
        {
          localObject1 = localTroopMemberInfo.autoremark;
          break label104;
        }
        localObject1 = localTroopMemberInfo.friendnick;
        break label104;
      }
      label388:
      localObject1 = null;
    }
  }
  
  public static void getTroopMemberNameAsync(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, ContactUtils.OnGetTroopMemberNameCallback paramOnGetTroopMemberNameCallback)
  {
    ThreadManager.post(new ContactUtils.1(paramQQAppInterface, paramString1, paramString2, paramOnGetTroopMemberNameCallback), 5, null, false);
  }
  
  public static String getTroopMemberNameFromCache(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, boolean paramBoolean)
  {
    Object localObject = (anvk)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    TroopManager localTroopManager = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ContactUtils", 2, "getTroopMemberNameFromCache uin is null");
      }
      paramQQAppInterface = "";
      return paramQQAppInterface;
    }
    localObject = ((anvk)localObject).a(paramString2);
    TroopMemberInfo localTroopMemberInfo = localTroopManager.a(paramString1, paramString2);
    if ((localTroopMemberInfo != null) && (paramBoolean) && (!TextUtils.isEmpty(localTroopMemberInfo.troopColorNick))) {
      paramQQAppInterface = localTroopMemberInfo.troopColorNick;
    }
    for (;;)
    {
      localObject = paramQQAppInterface;
      if (TextUtils.isEmpty(paramQQAppInterface)) {
        localObject = paramString2;
      }
      paramQQAppInterface = (QQAppInterface)localObject;
      if (localObject == null) {
        break;
      }
      paramQQAppInterface = (QQAppInterface)localObject;
      if (!((String)localObject).equals(paramString2)) {
        break;
      }
      paramString1 = localTroopManager.b(paramString1);
      paramQQAppInterface = (QQAppInterface)localObject;
      if (paramString1 == null) {
        break;
      }
      paramQQAppInterface = (QQAppInterface)localObject;
      if (!paramString1.isQidianPrivateTroop()) {
        break;
      }
      return TroopInfo.QIDIAN_TROOP_MEMBER_DEF_NICK;
      if ((localTroopMemberInfo != null) && (!paramBoolean) && (!TextUtils.isEmpty(localTroopMemberInfo.troopnick))) {
        paramQQAppInterface = localTroopMemberInfo.troopnick;
      } else if ((localObject != null) && (((Friends)localObject).isFriend()) && (!TextUtils.isEmpty(((Friends)localObject).remark))) {
        paramQQAppInterface = ((Friends)localObject).remark;
      } else if ((localObject != null) && (((Friends)localObject).isFriend())) {
        paramQQAppInterface = ((Friends)localObject).name;
      } else if (localTroopMemberInfo != null)
      {
        if (paramString2.equals(paramQQAppInterface.getCurrentAccountUin())) {
          paramQQAppInterface = paramQQAppInterface.getCurrentNickname();
        } else if (!TextUtils.isEmpty(localTroopMemberInfo.autoremark)) {
          paramQQAppInterface = localTroopMemberInfo.autoremark;
        } else {
          paramQQAppInterface = localTroopMemberInfo.friendnick;
        }
      }
      else {
        paramQQAppInterface = null;
      }
    }
  }
  
  public static String getTroopMemberNameInUI(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    Object localObject = (anvk)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    TroopManager localTroopManager = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ContactUtils", 2, "getTroopMemberName uin is null");
      }
      localObject = "";
      return localObject;
    }
    localObject = ((anvk)localObject).a(paramString2);
    TroopMemberInfo localTroopMemberInfo = localTroopManager.a(paramString1, paramString2);
    if ((localTroopMemberInfo != null) && (!TextUtils.isEmpty(localTroopMemberInfo.troopnick))) {
      paramQQAppInterface = localTroopMemberInfo.troopnick;
    }
    for (;;)
    {
      localObject = paramQQAppInterface;
      if (paramQQAppInterface == null) {
        break;
      }
      localObject = paramQQAppInterface;
      if (!paramQQAppInterface.equals(paramString2)) {
        break;
      }
      paramString1 = localTroopManager.a(paramString1);
      localObject = paramQQAppInterface;
      if (paramString1 == null) {
        break;
      }
      localObject = paramQQAppInterface;
      if (!paramString1.isQidianPrivateTroop()) {
        break;
      }
      return TroopInfo.QIDIAN_TROOP_MEMBER_DEF_NICK;
      if ((localObject != null) && (((Friends)localObject).isFriend()) && (!TextUtils.isEmpty(((Friends)localObject).remark))) {
        paramQQAppInterface = ((Friends)localObject).remark;
      } else if ((localObject != null) && (((Friends)localObject).isFriend())) {
        paramQQAppInterface = ((Friends)localObject).name;
      } else if (localTroopMemberInfo != null)
      {
        if (paramString2.equals(paramQQAppInterface.getCurrentAccountUin())) {
          paramQQAppInterface = paramQQAppInterface.getCurrentNickname();
        } else if (!TextUtils.isEmpty(localTroopMemberInfo.autoremark)) {
          paramQQAppInterface = localTroopMemberInfo.autoremark;
        } else {
          paramQQAppInterface = localTroopMemberInfo.friendnick;
        }
      }
      else {
        paramQQAppInterface = null;
      }
    }
  }
  
  public static String getTroopMemberNameRemarkFirst(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    Friends localFriends = ((anvk)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(paramString2);
    if ((localFriends != null) && (localFriends.isFriend()) && (!TextUtils.isEmpty(localFriends.remark))) {
      return localFriends.remark;
    }
    return getTroopMemberName(paramQQAppInterface, paramString1, paramString2);
  }
  
  public static String getTroopMemberNameWithoutRemark(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    return getTroopMemberNameWithoutRemark(paramQQAppInterface, paramString1, paramString2, false);
  }
  
  public static String getTroopMemberNameWithoutRemark(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, boolean paramBoolean)
  {
    TroopManager localTroopManager = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ContactUtils", 2, "getTroopMemberNameWithoutRemark uin is null");
      }
      return "";
    }
    TroopMemberInfo localTroopMemberInfo = localTroopManager.b(paramString1, paramString2);
    paramQQAppInterface = ((anvk)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(paramString2);
    if ((localTroopMemberInfo != null) && (paramBoolean) && (!TextUtils.isEmpty(localTroopMemberInfo.troopColorNick))) {
      paramQQAppInterface = localTroopMemberInfo.troopColorNick;
    }
    for (;;)
    {
      if ((paramQQAppInterface != null) && (paramQQAppInterface.equals(paramString2)))
      {
        paramString1 = localTroopManager.b(paramString1);
        if ((paramString1 != null) && (paramString1.isQidianPrivateTroop()))
        {
          return TroopInfo.QIDIAN_TROOP_MEMBER_DEF_NICK;
          if ((localTroopMemberInfo != null) && (!paramBoolean) && (!TextUtils.isEmpty(localTroopMemberInfo.troopnick)))
          {
            paramQQAppInterface = localTroopMemberInfo.troopnick;
            continue;
          }
          if ((paramQQAppInterface != null) && (paramQQAppInterface.isFriend()))
          {
            paramQQAppInterface = paramQQAppInterface.name;
            continue;
          }
          if ((localTroopMemberInfo == null) || (TextUtils.isEmpty(localTroopMemberInfo.friendnick))) {
            break label203;
          }
          paramQQAppInterface = localTroopMemberInfo.friendnick;
          continue;
        }
      }
      return paramQQAppInterface;
      label203:
      paramQQAppInterface = "";
    }
  }
  
  public static String getTroopMemberNick(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    if (paramQQAppInterface == null) {
      return "";
    }
    paramQQAppInterface = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ContactUtils", 2, "getTroopMemberNick uin is null");
      }
      return "";
    }
    paramQQAppInterface = paramQQAppInterface.b(paramString1, paramString2);
    if ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramQQAppInterface.troopnick))) {
      return paramQQAppInterface.troopnick;
    }
    return "";
  }
  
  public static String getTroopMemberNickByTroopCode(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    paramQQAppInterface = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    paramString2 = paramQQAppInterface.c(paramString2);
    if (paramString2 == null) {
      return paramString1;
    }
    return paramQQAppInterface.a(paramString2, paramString1);
  }
  
  public static String getTroopName(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean)
  {
    if ((paramString == null) || ("".equals(paramString))) {
      paramQQAppInterface = "";
    }
    do
    {
      return paramQQAppInterface;
      localObject1 = getNick(paramQQAppInterface, paramString, 1);
      if (!isValideName((String)localObject1, paramString)) {
        break;
      }
      paramQQAppInterface = (QQAppInterface)localObject1;
    } while (!QLog.isColorLevel());
    QLog.d("ContactUtils", 2, StringUtil.makeLogMsg(new Object[] { "getTroopName()", paramString, Boolean.valueOf(paramBoolean) }));
    return localObject1;
    Object localObject1 = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    Object localObject2 = (TroopInfo)((EntityManager)localObject1).find(TroopInfo.class, paramString);
    ((EntityManager)localObject1).close();
    if (localObject2 != null) {}
    for (localObject2 = ((TroopInfo)localObject2).getTroopName();; localObject2 = null)
    {
      localObject1 = localObject2;
      if (!isValideName((String)localObject2)) {
        localObject1 = bhbv.a(paramQQAppInterface.getApp(), paramString);
      }
      localObject2 = localObject1;
      if (!isValideName((String)localObject1))
      {
        if (paramBoolean) {
          ((ansj)paramQQAppInterface.getManager(QQManagerFactory.CONTACT_FACADE)).a().a(paramString);
        }
        localObject2 = paramString;
      }
      paramQQAppInterface = (QQAppInterface)localObject2;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ContactUtils", 2, StringUtil.makeLogMsg(new Object[] { "getTroopName()", paramString, Boolean.valueOf(paramBoolean) }));
      return localObject2;
    }
  }
  
  public static String getTroopNameByID(QQAppInterface paramQQAppInterface, String paramString)
  {
    Object localObject = ((HotChatManager)paramQQAppInterface.getManager(QQManagerFactory.HOT_CHAT_MANAGER)).a(paramString);
    if (localObject != null) {
      paramQQAppInterface = ((HotChatInfo)localObject).name + anvx.a(2131702079);
    }
    do
    {
      do
      {
        return paramQQAppInterface;
        localObject = ((TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(paramString);
        paramQQAppInterface = paramString;
      } while (localObject == null);
      paramQQAppInterface = paramString;
    } while (((TroopInfo)localObject).getTroopName() == null);
    return ((TroopInfo)localObject).getTroopName();
  }
  
  public static String getTroopNickName(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, boolean paramBoolean, Bundle paramBundle)
  {
    if ((paramString1 == null) || ("".equals(paramString1)) || (paramString2 == null) || ("".equals(paramString2)) || (paramString3 == null) || ("".equals(paramString3)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ContactUtils", 2, StringUtil.makeLogMsg(new Object[] { "getTroopNickName()", paramString1, paramString2, paramString3, Boolean.valueOf(paramBoolean), paramBundle }));
      }
      localObject1 = "";
    }
    boolean bool;
    do
    {
      return localObject1;
      localObject1 = getTroopMemberName(paramQQAppInterface, paramString2, paramString1);
      bool = isValideName((String)localObject1, paramString1);
      if (QLog.isColorLevel()) {
        QLog.d("ContactUtils", 2, StringUtil.makeLogMsg(new Object[] { "getTroopNickName()", paramString1, paramString2, paramString3, Boolean.valueOf(paramBoolean), localObject1 }));
      }
    } while (bool);
    TroopMemberInfo localTroopMemberInfo = bhdf.a().a(paramQQAppInterface, paramString2, paramString1);
    Object localObject2;
    if (localTroopMemberInfo != null)
    {
      localObject2 = localTroopMemberInfo.troopnick;
      localObject1 = localObject2;
      if (isValideName((String)localObject2)) {}
    }
    for (Object localObject1 = localTroopMemberInfo.friendnick;; localObject1 = null)
    {
      localObject2 = localObject1;
      if (!isValideName((String)localObject1))
      {
        if (paramBoolean) {
          ((ansj)paramQQAppInterface.getManager(QQManagerFactory.CONTACT_FACADE)).a().a(paramString1, paramString2, paramString3, paramBundle);
        }
        localObject2 = paramString1;
      }
      localObject1 = localObject2;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ContactUtils", 2, StringUtil.makeLogMsg(new Object[] { "getTroopNickName()", paramString1, paramString2, paramString3, Boolean.valueOf(paramBoolean), localObject2 }));
      return localObject2;
    }
  }
  
  public static String getTroopNickNameByTroopCode(QQAppInterface paramQQAppInterface, String paramString)
  {
    String str = ((TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).c(paramString);
    if (str == null) {
      return paramString;
    }
    return getNickName(paramQQAppInterface, str, 1);
  }
  
  public static String getUinByPhoneNum(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = (awyz)paramQQAppInterface.getManager(QQManagerFactory.CONTACT_MANAGER);
    if (paramQQAppInterface != null) {
      return paramQQAppInterface.a(paramString);
    }
    return "";
  }
  
  public static boolean hasCustomOnlineStatusName(Friends paramFriends)
  {
    if (paramFriends == null) {}
    while ((getFriendStatus(paramFriends.detalStatusFlag, paramFriends.iTermType) != 4) || (!bhmz.a(paramFriends.customOnlineStatusType)) || (TextUtils.isEmpty(paramFriends.customOnlineStatus))) {
      return false;
    }
    return true;
  }
  
  public static boolean isContainChinese(String paramString)
  {
    return Pattern.compile("[\\u4E00-\\u9FA5]+").matcher(paramString).find();
  }
  
  public static boolean isDiscussionMeeting(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = ((antp)paramQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER)).a(paramString);
    if (paramQQAppInterface != null) {
      return paramQQAppInterface.isDiscussHrMeeting();
    }
    return false;
  }
  
  public static boolean isInvisibleContactNetworkStatus(PhoneContact paramPhoneContact)
  {
    return (paramPhoneContact.iTermType == 0) && (paramPhoneContact.eNetworkType == 0);
  }
  
  public static boolean isInvisibleFriendNetworkStatus(Friends paramFriends)
  {
    return ((paramFriends.iTermType == 0) && (paramFriends.eNetwork == 0)) || ((getFriendStatus(paramFriends.detalStatusFlag, paramFriends.iTermType) == 0) && (!TextUtils.isEmpty(paramFriends.strTermDesc)) && (paramFriends.strTermDesc.contains("TIM")));
  }
  
  public static boolean isNeedDiscussionNameOrCompareName(QQAppInterface paramQQAppInterface, DiscussionInfo paramDiscussionInfo)
  {
    return (isNeedRenamedDisName(paramQQAppInterface, paramDiscussionInfo)) || (paramDiscussionInfo.mCompareSpell == null) || (paramDiscussionInfo.mCompareSpell.length() == 0);
  }
  
  public static boolean isNeedRenamedDisName(QQAppInterface paramQQAppInterface, long paramLong, String paramString)
  {
    if (unrenamedNamesReg == null) {
      unrenamedNamesReg = paramQQAppInterface.getApp().getString(2131719789);
    }
    return (((0x40 & paramLong) >>> 6 == 1L) && ((0x20000000 & paramLong) >>> 29 == 1L)) || (paramString == null) || (paramString.matches(unrenamedNamesReg)) || (paramString.length() == 0);
  }
  
  public static boolean isNeedRenamedDisName(QQAppInterface paramQQAppInterface, DiscussionInfo paramDiscussionInfo)
  {
    return isNeedRenamedDisName(paramQQAppInterface, paramDiscussionInfo.DiscussionFlag, paramDiscussionInfo.discussionName);
  }
  
  private static boolean isSpace(String paramString)
  {
    if (paramString != null)
    {
      int i = 0;
      while (i < paramString.length())
      {
        if (!Character.isSpaceChar(paramString.charAt(i))) {
          return false;
        }
        i += 1;
      }
    }
    return true;
  }
  
  private static boolean isValideName(String paramString)
  {
    return (paramString != null) && (!"".equals(paramString));
  }
  
  public static boolean isValideName(String paramString1, String paramString2)
  {
    return (isValideName(paramString1)) && (!paramString1.equals(paramString2)) && (paramString2 != null);
  }
  
  public static void setBindPath(int paramInt)
  {
    String str = null;
    switch (paramInt)
    {
    }
    for (;;)
    {
      sRequestBindPathTag = str;
      return;
      str = "0X80068AA";
      continue;
      str = "0X80068AB";
      continue;
      str = "0X80068AC";
      continue;
      str = "0X80068AD";
      continue;
      str = "0X80068AE";
      continue;
      str = "0X80068AF";
      continue;
      str = "0X80068B0";
      continue;
      str = "0X80068B1";
    }
  }
  
  private static boolean setDiscussionName(QQAppInterface paramQQAppInterface, String paramString, DiscussionInfo paramDiscussionInfo, Map<String, DiscussionMemberInfo> paramMap)
  {
    if ((paramDiscussionInfo == null) || (paramMap == null) || (paramMap.size() == 0)) {
      return false;
    }
    paramDiscussionInfo.discussionName = getDiscussionCombinedName(paramQQAppInterface, paramDiscussionInfo.ownerUin, paramMap);
    return true;
  }
  
  public static String setDiscussionNameAndCompareName(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, long paramLong, String paramString3, Map<String, DiscussionMemberInfo> paramMap)
  {
    if (((0x40 & paramLong) >>> 6 == 1L) && ((paramLong & 0x20000000) != 536870912L) && ((paramMap == null) || (paramMap.size() == 0))) {
      if (QLog.isColorLevel()) {
        QLog.d("ContactUtils", 2, "setDiscussionNameAndCompareName, info is null. disUin=" + paramString1);
      }
    }
    while (!isNeedRenamedDisName(paramQQAppInterface, paramLong, paramString3)) {
      return paramString3;
    }
    return getDiscussionCombinedName(paramQQAppInterface, paramString2, paramMap);
  }
  
  public static boolean setDiscussionNameAndCompareName(QQAppInterface paramQQAppInterface, String paramString, DiscussionInfo paramDiscussionInfo, Map<String, DiscussionMemberInfo> paramMap, boolean paramBoolean)
  {
    if (paramDiscussionInfo == null) {
      if (QLog.isColorLevel()) {
        QLog.d("ContactUtils", 2, "setDiscussionNameAndCompareName, info is null. disUin=" + paramString);
      }
    }
    for (;;)
    {
      return false;
      if (QLog.isColorLevel()) {
        QLog.d("ContactUtils", 2, "setDiscussionNameAndCompareName, Flag =" + paramDiscussionInfo.DiscussionFlag + " disUin=" + paramString);
      }
      if ((!paramDiscussionInfo.hasRenamed()) && ((paramDiscussionInfo.DiscussionFlag & 0x20000000) >>> 29 == 1L) && ((paramMap == null) || (paramMap.size() == 0)))
      {
        if (QLog.isColorLevel())
        {
          QLog.d("ContactUtils", 2, "setDiscussionNameAndCompareName no need disUin=" + paramString);
          return false;
        }
      }
      else
      {
        if (isNeedRenamedDisName(paramQQAppInterface, paramDiscussionInfo)) {}
        for (boolean bool = setDiscussionName(paramQQAppInterface, paramString, paramDiscussionInfo, paramMap); (paramBoolean) || (bool) || (paramDiscussionInfo.mCompareSpell == null) || (paramDiscussionInfo.mCompareSpell.length() == 0); bool = false)
        {
          ansk.a(paramDiscussionInfo);
          paramDiscussionInfo.DiscussionFlag &= 0xDFFFFFFF;
          return true;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.ContactUtils
 * JD-Core Version:    0.7.0.1
 */