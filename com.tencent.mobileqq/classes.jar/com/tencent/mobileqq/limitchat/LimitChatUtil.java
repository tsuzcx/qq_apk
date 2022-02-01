package com.tencent.mobileqq.limitchat;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.ArkAppSSO;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.ExtendFriendUserInfo;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForLimitChatTopic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.extendfriend.Constants;
import com.tencent.mobileqq.extendfriend.ExtendFriendManager;
import com.tencent.mobileqq.extendfriend.bean.ChatFriendInfo;
import com.tencent.mobileqq.extendfriend.bean.MatchInfo;
import com.tencent.mobileqq.extendfriend.bean.PersonalTag;
import com.tencent.mobileqq.extendfriend.bean.SchoolInfo;
import com.tencent.mobileqq.extendfriend.config.ExpandConfigManager;
import com.tencent.mobileqq.extendfriend.ipc.ExpandFlutterIPCClient;
import com.tencent.mobileqq.extendfriend.limitchat.ExpandFriendChatUtil;
import com.tencent.mobileqq.extendfriend.limitchat.ExtendFriendLimitChatManager;
import com.tencent.mobileqq.extendfriend.limitchat.ExtendFriendVoiceMatchLoadingFragment;
import com.tencent.mobileqq.extendfriend.utils.ExpandReportUtils;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.relationx.icebreaking.IceBreakingMng;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.util.MessageRecordUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LimitChatUtil
{
  public static final Long a = Long.valueOf(5L);
  
  public static int a(AppInterface paramAppInterface)
  {
    int j = 0;
    int i;
    if ((paramAppInterface instanceof QQAppInterface))
    {
      if (QLog.isColorLevel()) {
        QLog.d("LimitChatUtil", 2, "getLimitChatState in mainprocess");
      }
      paramAppInterface = (ExtendFriendLimitChatManager)paramAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_LIMIT_CHAT_MANAGER);
      if (paramAppInterface == null) {
        break label97;
      }
      i = paramAppInterface.a();
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LimitChatUtil", 2, "getLimitChatState :" + i);
      }
      return i;
      i = j;
      if (QLog.isColorLevel())
      {
        QLog.d("LimitChatUtil", 2, "getLimitChatState in otherprocess,ERROR");
        i = j;
        continue;
        label97:
        i = 0;
      }
    }
  }
  
  public static long a(QQAppInterface paramQQAppInterface, MatchInfo paramMatchInfo, long paramLong, int paramInt)
  {
    return a(paramQQAppInterface, paramMatchInfo, paramLong, paramInt, 1044);
  }
  
  public static long a(QQAppInterface paramQQAppInterface, MatchInfo paramMatchInfo, long paramLong, int paramInt1, int paramInt2)
  {
    if ((paramQQAppInterface == null) || (paramMatchInfo == null)) {
      return -1L;
    }
    Object localObject1 = paramQQAppInterface.getMessageFacade().a(paramMatchInfo.jdField_b_of_type_JavaLangString, paramInt2);
    Object localObject2 = ((List)localObject1).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      ChatMessage localChatMessage = (ChatMessage)((Iterator)localObject2).next();
      if (ExpandFriendChatUtil.b(localChatMessage)) {
        return localChatMessage.time;
      }
    }
    int i = -4023;
    if (paramInt1 != 1)
    {
      paramInt1 = i;
      if (paramInt2 != 1045) {}
    }
    else
    {
      paramInt1 = -4024;
    }
    localObject2 = (MessageForLimitChatTopic)MessageRecordFactory.a(paramInt1);
    if ((localObject1 != null) && (!((List)localObject1).isEmpty())) {}
    for (long l = ((ChatMessage)((List)localObject1).get(((List)localObject1).size() - 1)).shmsgseq + 1L;; l = Math.abs(new Random().nextInt()))
    {
      paramLong -= 5L;
      ((MessageForLimitChatTopic)localObject2).init(paramQQAppInterface.getCurrentAccountUin(), paramMatchInfo.jdField_b_of_type_JavaLangString, paramQQAppInterface.getCurrentAccountUin(), paramMatchInfo.c, paramLong, paramInt1, paramInt2, l);
      ((MessageForLimitChatTopic)localObject2).isread = true;
      ((MessageForLimitChatTopic)localObject2).shmsgseq = l;
      localObject1 = new JSONObject();
      a((JSONObject)localObject1, paramMatchInfo);
      ((MessageForLimitChatTopic)localObject2).saveExtInfoToExtStr("match_chat_msg_data_key", ((JSONObject)localObject1).toString());
      if (QLog.isDevelopLevel()) {
        QLog.i("LimitChatUtil", 4, String.format(Locale.getDefault(), "addTopicMessage in seq %s  time %s", new Object[] { Long.valueOf(l), Long.valueOf(paramLong) }));
      }
      if (!MessageHandlerUtils.a(paramQQAppInterface, (MessageRecord)localObject2, false)) {
        paramQQAppInterface.getMessageFacade().a((MessageRecord)localObject2, ((MessageForLimitChatTopic)localObject2).selfuin);
      }
      if (QLog.isDevelopLevel()) {
        QLog.i("LimitChatUtil", 4, String.format(Locale.getDefault(), "addTopicMessage in 2", new Object[0]));
      }
      return System.currentTimeMillis();
    }
  }
  
  private static Intent a(Context paramContext, String paramString1, String paramString2, Long paramLong, String paramString3, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LimitChatUtil", 2, "makeIntent, uin:" + paramString1 + " nick:" + paramString2 + " timestamp:" + paramLong + " topic:" + paramString3);
    }
    paramContext = new Intent(paramContext, ChatActivity.class);
    paramContext.putExtra("uin", paramString1);
    paramContext.putExtra("uinname", paramString2);
    paramContext.putExtra("uintype", 1044);
    if (paramInt == 0) {
      paramContext.putExtra("entrance", 21);
    }
    for (;;)
    {
      paramContext.putExtra("key_limitchat_auto_open", true);
      paramString1 = new Bundle();
      paramString1.putInt("key_limitchat_from_type", paramInt);
      paramContext.putExtras(paramString1);
      return paramContext;
      paramContext.putExtra("entrance", 20);
    }
  }
  
  public static MessageForArkApp a(QQAppInterface paramQQAppInterface, String paramString, long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject)
  {
    MessageForArkApp localMessageForArkApp = (MessageForArkApp)MessageRecordFactory.a(paramInt2);
    ArkAppMessage localArkAppMessage = new ArkAppMessage();
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    JSONObject localJSONObject3 = new JSONObject();
    JSONObject localJSONObject4 = new JSONObject();
    try
    {
      localJSONObject1.put("type", "normal");
      localJSONObject1.put("showSender", 0);
      localJSONObject1.put("hintWidth", Constants.jdField_a_of_type_Int);
      localJSONObject1.put("hintHeight", 96);
      localJSONObject3.put("manage_test_plan", ExpandReportUtils.a());
      localJSONObject4.put("matchUin", Long.parseLong(paramString));
      localJSONObject4.put("localData", paramObject.toString());
      localJSONObject4.put("defaultReportParams", localJSONObject3.toString());
      localJSONObject2.put("metadata", localJSONObject4);
      localArkAppMessage.appId = "com.tencent.mobileqq.expandfriend";
      localArkAppMessage.appName = "com.tencent.mobileqq.expandfriend";
      localArkAppMessage.appDesc = "手机QQ校园扩列的mini资料卡动态化下发";
      localArkAppMessage.appView = "qq_expand_mini_profile_ark";
      localArkAppMessage.appMinVersion = "1.0.0.0";
      localArkAppMessage.config = localJSONObject1.toString();
      localArkAppMessage.metaList = localJSONObject2.toString();
      localMessageForArkApp.init(paramQQAppInterface.getCurrentAccountUin(), paramString, paramQQAppInterface.getCurrentAccountUin(), "mini profile ark message", paramLong2, paramInt2, paramInt1, paramLong1);
      localMessageForArkApp.ark_app_message = localArkAppMessage;
      localMessageForArkApp.frienduin = paramString;
      localMessageForArkApp.mNeedTimeStamp = false;
      localMessageForArkApp.isread = true;
      localMessageForArkApp.shmsgseq = paramLong1;
      localMessageForArkApp.getBytes();
      localMessageForArkApp.parse();
      return localMessageForArkApp;
    }
    catch (Exception paramObject)
    {
      for (;;)
      {
        QLog.e("LimitChatUtil", 1, "ArkMiniProfileCardMessage mateData error" + paramObject);
      }
    }
  }
  
  public static String a(AppInterface paramAppInterface)
  {
    if ((paramAppInterface instanceof QQAppInterface))
    {
      if (QLog.isColorLevel()) {
        QLog.d("LimitChatUtil", 2, "getLimitChatUin in mainprocess");
      }
      paramAppInterface = (ExtendFriendLimitChatManager)paramAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_LIMIT_CHAT_MANAGER);
      if (paramAppInterface == null) {
        break label98;
      }
      paramAppInterface = paramAppInterface.a();
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LimitChatUtil", 2, "getLimitChatUin :" + paramAppInterface);
      }
      return paramAppInterface;
      if (QLog.isColorLevel()) {
        QLog.d("LimitChatUtil", 2, "getLimitChatState in otherprocess");
      }
      paramAppInterface = "";
      continue;
      label98:
      paramAppInterface = null;
    }
  }
  
  public static void a(Activity paramActivity, MatchInfo paramMatchInfo, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    String str1 = paramMatchInfo.jdField_b_of_type_JavaLangString;
    String str2 = paramMatchInfo.c;
    paramString = a(paramActivity, str1, paramString, Long.valueOf(paramMatchInfo.jdField_a_of_type_Long), str2, paramInt3);
    paramString.putExtra("need_check_apollo_dress_up", true);
    switch (paramMatchInfo.jdField_b_of_type_Int)
    {
    default: 
      paramInt3 = 5;
    }
    for (;;)
    {
      paramString.putExtra("key_limitchat_enter_type", paramInt3);
      paramString.putExtra("key_limitchat_match_sex_type", paramInt1);
      paramString.putExtra("key_limitchat_match_purpose", paramInt2);
      paramActivity.startActivity(paramString);
      return;
      paramInt3 = 4;
      continue;
      paramInt3 = 3;
      continue;
      paramInt3 = 7;
    }
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LimitChatUtil", 2, "startAddFriendActivity " + paramString1 + " " + paramString2 + " " + paramString3);
    }
    paramString3 = ((ExtendFriendManager)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).a(paramString1, false);
    int i = 8;
    if (paramString3 != null) {
      i = ExtendFriendUserInfo.fromTypeToSubID(paramString3.fromType);
    }
    if ((paramContext instanceof Activity))
    {
      paramContext = (Activity)paramContext;
      paramString1 = AddFriendLogicActivity.a(paramContext, 1, paramString1, null, 3094, i, paramString2, null, null, paramContext.getResources().getString(2131690778), null);
      if (paramString1 != null) {
        paramString1.putExtra("entrance", 1);
      }
      paramContext.startActivityForResult(paramString1, 16002);
    }
  }
  
  public static void a(Context paramContext, HashMap<String, Object> paramHashMap)
  {
    try
    {
      i = Integer.parseInt((String)paramHashMap.get("gender"));
      paramContext = new Intent();
      paramContext.putExtra("intent_sex_key", i);
      PublicFragmentActivity.Launcher.a(paramContext, PublicFragmentActivity.class, ExtendFriendVoiceMatchLoadingFragment.class);
      return;
    }
    catch (NumberFormatException paramContext)
    {
      for (;;)
      {
        int i = 0;
      }
    }
  }
  
  public static void a(Uri paramUri, Map<String, Object> paramMap)
  {
    int i = 1;
    int n = 0;
    if ((paramUri == null) || (paramUri.getQueryParameter("toUin") == null) || (paramUri.getQueryParameter("fromPage") == null))
    {
      QLog.e("LimitChatUtil", 2, "flutterEnterLimitChatAIO, necessary arguments is null, will not jump to AIO ");
      return;
    }
    if ((paramMap == null) || (paramMap.get("sig") == null) || (paramUri.getQueryParameter("srcType") == null) || (paramUri.getQueryParameter("accostType") == null) || (paramUri.getQueryParameter("isPassive") == null) || (paramMap.get("chooseCondition") == null) || (paramMap.get("datingPurpose") == null)) {
      QLog.w("LimitChatUtil", 2, "flutterEnterLimitChatAIO, unnecessary arguments is null, will jump to AIO, but maybe cause exception");
    }
    int i1 = Integer.parseInt(paramUri.getQueryParameter("fromPage"));
    String str = paramUri.getQueryParameter("toUin");
    byte[] arrayOfByte;
    label170:
    int j;
    if (paramMap != null) {
      if (paramMap.get("sig") == null)
      {
        arrayOfByte = null;
        if (paramMap.get("chooseCondition") != null) {
          break label264;
        }
        if (paramMap.get("datingPurpose") != null) {
          break label283;
        }
        j = 0;
      }
    }
    for (;;)
    {
      label184:
      int k;
      label197:
      int m;
      if (paramUri.getQueryParameter("srcType") == null)
      {
        k = 3;
        if (paramUri.getQueryParameter("accostType") != null) {
          break label319;
        }
        m = 163;
        label212:
        if (paramUri.getQueryParameter("isPassive") != null) {
          break label334;
        }
      }
      for (;;)
      {
        ExpandFlutterIPCClient.a().a(str, i1, k, m, n, i, j, arrayOfByte);
        return;
        arrayOfByte = (byte[])paramMap.get("sig");
        break;
        label264:
        i = Integer.parseInt((String)paramMap.get("chooseCondition"));
        break label170;
        label283:
        j = Integer.parseInt((String)paramMap.get("datingPurpose"));
        break label184;
        k = Integer.parseInt(paramUri.getQueryParameter("srcType")) - 2;
        break label197;
        label319:
        m = Integer.parseInt(paramUri.getQueryParameter("accostType"));
        break label212;
        label334:
        n = Integer.parseInt(paramUri.getQueryParameter("isPassive"));
      }
      j = 0;
      i = 1;
      arrayOfByte = null;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Long paramLong, BusinessObserver paramBusinessObserver)
  {
    ArkAppSSO localArkAppSSO = ((ArkAppCenter)paramQQAppInterface.getManager(QQManagerFactory.ARK_APP_CENTER_MANAGER)).a();
    paramQQAppInterface = "";
    try
    {
      paramLong = new JSONObject().put("uin", paramLong).toString();
      paramQQAppInterface = paramLong;
    }
    catch (JSONException paramLong)
    {
      for (;;)
      {
        QLog.w("LimitChatUtil", 1, "preLoadDataForArkMiniProfileCard error" + paramLong);
      }
    }
    localArkAppSSO.a("QQExpand.UserInfo.GetMiniUserInfo", paramQQAppInterface, 30000, 30, paramBusinessObserver);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {}
    do
    {
      do
      {
        do
        {
          return;
          if (QLog.isColorLevel()) {
            QLog.d("LimitChatUtil", 2, "tryAddRecentUser begin");
          }
          paramQQAppInterface = paramQQAppInterface.getProxyManager().a();
        } while (paramQQAppInterface == null);
        if (!paramQQAppInterface.a(paramString)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("LimitChatUtil", 2, "tryAddRecentUser ,find rencentuser");
      return;
      paramString = paramQQAppInterface.a(paramString, 0);
      long l = NetConnInfoCenter.getServerTime();
      if (paramString.lastmsgtime < l) {
        paramString.lastmsgtime = l;
      }
      paramQQAppInterface.b(paramString);
    } while (!QLog.isColorLevel());
    QLog.d("LimitChatUtil", 2, "tryAddRecentUser end");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    Intent localIntent = new Intent(paramQQAppInterface.getApplicationContext(), ChatActivity.class);
    localIntent.putExtra("uin", paramString);
    localIntent.putExtra("uintype", paramInt);
    String str2 = ContactUtils.q(paramQQAppInterface, paramString);
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = ContactUtils.c(paramQQAppInterface, paramString, false);
    }
    localIntent.putExtra("uinname", str1);
    localIntent.putExtra("entrance", 20);
    localIntent.putExtra("key_limitchat_enter_type", 6);
    localIntent.setFlags(268435456);
    paramQQAppInterface.getApplicationContext().startActivity(localIntent);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, int paramInt2)
  {
    if (paramInt2 == 4) {
      ExpandFriendChatUtil.a(paramQQAppInterface, paramString, paramInt1, paramInt2, new LimitChatUtil.5(paramQQAppInterface, paramString, paramInt1));
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    Intent localIntent = new Intent(paramQQAppInterface.getApplicationContext(), ChatActivity.class);
    localIntent.putExtra("uin", paramString);
    String str2 = ContactUtils.q(paramQQAppInterface, paramString);
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = ContactUtils.c(paramQQAppInterface, paramString, false);
    }
    localIntent.putExtra("uinname", str1);
    if (paramInt4 == 163)
    {
      localIntent.putExtra("uintype", 1044);
      if (paramInt1 != 6) {
        break label223;
      }
      localIntent.putExtra("entrance", 20);
    }
    for (;;)
    {
      localIntent.putExtra("key_limitchat_auto_open", true);
      paramString = new Bundle();
      paramString.putInt("key_limitchat_from_type", 0);
      localIntent.putExtras(paramString);
      localIntent.putExtra("need_check_apollo_dress_up", true);
      localIntent.putExtra("key_limitchat_enter_type", paramInt2);
      localIntent.putExtra("key_is_passive", paramInt3);
      localIntent.putExtra("key_limitchat_match_sex_type", paramInt5);
      localIntent.putExtra("key_limitchat_match_purpose", paramInt6);
      localIntent.setFlags(268435456);
      paramQQAppInterface.getApplicationContext().startActivity(localIntent);
      return;
      if (paramInt4 != 166) {
        break;
      }
      localIntent.putExtra("uintype", 1045);
      break;
      label223:
      localIntent.putExtra("entrance", 21);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, String paramString4, int paramInt3, boolean paramBoolean, MessageRecord paramMessageRecord, int paramInt4)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LimitChatUtil", 2, String.format("addGrayTipsMessage frdUin:%s msg:%s ", new Object[] { paramString1, MessageRecordUtil.a(paramString3) }));
    }
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString1))) {}
    do
    {
      return;
      l = MessageCache.a();
      if ((paramBoolean) || (paramMessageRecord == null) || (!a(paramQQAppInterface, paramString1, paramInt2, paramMessageRecord))) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("LimitChatUtil", 2, String.format("addGrayTipsMessage last tip message is same", new Object[0]));
    return;
    if (QLog.isColorLevel()) {
      QLog.d("LimitChatUtil", 2, String.format("addGrayTipsMessage start add tip message", new Object[0]));
    }
    paramString1 = new UniteGrayTipParam(paramString1, paramQQAppInterface.getCurrentAccountUin(), paramString3, paramInt1, -5020, paramInt2, l);
    paramString1.c = paramString3;
    if (paramMessageRecord != null) {}
    for (long l = paramMessageRecord.shmsgseq;; l = Math.abs(new Random().nextInt()))
    {
      if (!TextUtils.isEmpty(paramString4))
      {
        paramMessageRecord = new Bundle();
        paramInt1 = paramString3.indexOf(paramString4);
        if (paramInt1 >= 0)
        {
          paramInt2 = paramString4.length();
          paramMessageRecord.putInt("key_action", paramInt3);
          paramMessageRecord.putString("textColor", "#40A0FF");
          paramMessageRecord.putString("key_action_DATA", paramString2);
          paramMessageRecord.putString("key_a_action_DATA", paramInt4 + "");
          paramString1.a(paramInt1, paramInt2 + paramInt1, paramMessageRecord);
        }
      }
      paramString2 = new MessageForUniteGrayTip();
      paramString2.initGrayTipMsg(paramQQAppInterface, paramString1);
      paramString2.isread = true;
      paramString2.shmsgseq = l;
      paramString2.mNeedTimeStamp = true;
      paramString2.updateUniteGrayTipMsgData(paramQQAppInterface);
      paramQQAppInterface.getMessageFacade().a(paramString2, paramQQAppInterface.getCurrentAccountUin());
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, int paramInt1, String paramString2, boolean paramBoolean, int paramInt2)
  {
    ExtendFriendManager localExtendFriendManager = (ExtendFriendManager)paramQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
    ExtendFriendUserInfo localExtendFriendUserInfo = localExtendFriendManager.a(paramString1, true);
    paramQQAppInterface = localExtendFriendUserInfo;
    if (localExtendFriendUserInfo == null) {
      paramQQAppInterface = new ExtendFriendUserInfo();
    }
    paramQQAppInterface.uin = paramString1;
    if (paramBoolean) {}
    for (paramString1 = "{}";; paramString1 = null)
    {
      paramQQAppInterface.miniProfileMsg = paramString1;
      paramQQAppInterface.tagID = paramInt1;
      paramQQAppInterface.tagName = paramString2;
      paramQQAppInterface.fromType = paramInt2;
      localExtendFriendManager.a(paramQQAppInterface);
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, int paramInt1, String paramString2, boolean paramBoolean1, int paramInt2, boolean paramBoolean2, int paramInt3)
  {
    ExtendFriendManager localExtendFriendManager = (ExtendFriendManager)paramQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
    ExtendFriendUserInfo localExtendFriendUserInfo = localExtendFriendManager.a(paramString1, true);
    paramQQAppInterface = localExtendFriendUserInfo;
    if (localExtendFriendUserInfo == null) {
      paramQQAppInterface = new ExtendFriendUserInfo();
    }
    paramQQAppInterface.uin = paramString1;
    if (paramBoolean1)
    {
      paramString1 = "{}";
      paramQQAppInterface.miniProfileMsg = paramString1;
      paramQQAppInterface.tagID = paramInt1;
      paramQQAppInterface.tagName = paramString2;
      paramQQAppInterface.distance = paramInt2;
      if ((!paramBoolean2) || (paramInt2 < 0)) {
        break label109;
      }
    }
    label109:
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      paramQQAppInterface.showDistanceHLight = paramBoolean1;
      paramQQAppInterface.fromType = paramInt3;
      localExtendFriendManager.a(paramQQAppInterface);
      return;
      paramString1 = null;
      break;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, boolean paramBoolean, @NonNull Object paramObject)
  {
    ThreadManager.getSubThreadHandler().post(new LimitChatUtil.4(paramQQAppInterface, paramString, paramBoolean, paramInt, paramObject));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean, int paramInt, Object paramObject)
  {
    if ((paramQQAppInterface == null) || (paramString == null)) {}
    List localList;
    do
    {
      return;
      localList = paramQQAppInterface.getMessageFacade().a(paramString, paramInt);
    } while (ExpandFriendChatUtil.a(localList));
    b(paramQQAppInterface, paramString);
    long l1 = ExpandFriendChatUtil.a(localList);
    long l2 = ExpandFriendChatUtil.b(localList);
    int j = -4025;
    int i = j;
    if (!paramBoolean)
    {
      paramBoolean = ((ExtendFriendManager)paramQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).a().e();
      if (paramInt != 1045)
      {
        i = j;
        if (!paramBoolean) {}
      }
      else
      {
        i = -4026;
      }
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("LimitChatUtil", 4, String.format(Locale.getDefault(), "addArkMiniProfileCard in seq %s  time %s", new Object[] { Long.valueOf(l1), Long.valueOf(l2) }));
    }
    paramString = a(paramQQAppInterface, paramString, l1, l2, paramInt, i, paramObject);
    paramQQAppInterface.getMessageFacade().a(paramString, paramQQAppInterface.getCurrentAccountUin());
  }
  
  public static void a(MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    ThreadManager.executeOnSubThread(new LimitChatUtil.3(paramQQAppInterface, paramMessageRecord));
  }
  
  private static void a(JSONObject paramJSONObject, MatchInfo paramMatchInfo)
  {
    JSONArray localJSONArray;
    Iterator localIterator;
    Object localObject;
    JSONObject localJSONObject;
    boolean bool;
    try
    {
      if (paramMatchInfo.c != null) {
        paramJSONObject.put("topic_msg", paramMatchInfo.c);
      }
      if (paramMatchInfo.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanChatFriendInfo != null)
      {
        if (paramMatchInfo.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanChatFriendInfo.jdField_b_of_type_JavaLangString != null) {
          paramJSONObject.put("age", paramMatchInfo.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanChatFriendInfo.jdField_b_of_type_JavaLangString);
        }
        paramJSONObject.put("gender", paramMatchInfo.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanChatFriendInfo.jdField_a_of_type_Int);
        paramJSONObject.put("matchTagId", paramMatchInfo.jdField_b_of_type_Int);
        paramJSONObject.put("matchTagName", paramMatchInfo.jdField_f_of_type_JavaLangString);
        if (paramMatchInfo.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanChatFriendInfo.c != null) {
          paramJSONObject.put("constellation", paramMatchInfo.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanChatFriendInfo.c);
        }
        if (paramMatchInfo.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanChatFriendInfo.e != null) {
          paramJSONObject.put("school", paramMatchInfo.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanChatFriendInfo.e);
        }
        if (paramMatchInfo.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanChatFriendInfo.jdField_f_of_type_JavaLangString != null) {
          paramJSONObject.put("company", paramMatchInfo.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanChatFriendInfo.jdField_f_of_type_JavaLangString);
        }
        if (paramMatchInfo.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanChatFriendInfo.d != null) {
          paramJSONObject.put("city", paramMatchInfo.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanChatFriendInfo.d);
        }
        if (paramMatchInfo.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanChatFriendInfo.g != null) {
          paramJSONObject.put("declaration", paramMatchInfo.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanChatFriendInfo.g);
        }
        if (paramMatchInfo.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanChatFriendInfo.h != null) {
          paramJSONObject.put("voiceUrl", paramMatchInfo.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanChatFriendInfo.h);
        }
        paramJSONObject.put("voiceDuration", paramMatchInfo.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanChatFriendInfo.jdField_b_of_type_Int);
        if (paramMatchInfo.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanChatFriendInfo.i != null) {
          paramJSONObject.put("signWords", paramMatchInfo.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanChatFriendInfo.i);
        }
        if (paramMatchInfo.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanChatFriendInfo.jdField_a_of_type_JavaUtilArrayList != null)
        {
          localJSONArray = new JSONArray();
          localIterator = paramMatchInfo.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanChatFriendInfo.jdField_a_of_type_JavaUtilArrayList.iterator();
          for (;;)
          {
            if (!localIterator.hasNext()) {
              break label432;
            }
            localObject = (PersonalTag)localIterator.next();
            if (((PersonalTag)localObject).jdField_a_of_type_JavaLangString != null)
            {
              localJSONObject = new JSONObject();
              localJSONObject.put("tagName", ((PersonalTag)localObject).jdField_a_of_type_JavaLangString);
              if (((PersonalTag)localObject).jdField_a_of_type_Int == 0) {
                break;
              }
              bool = true;
              localJSONObject.put("tagSame", bool);
              localJSONArray.put(localJSONObject);
            }
          }
        }
      }
      else
      {
        return;
      }
    }
    catch (JSONException paramJSONObject)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("LimitChatUtil", 4, "initProfileJSON " + paramJSONObject);
      }
    }
    label432:
    do
    {
      bool = false;
      break;
      if (localJSONArray.length() > 0) {
        paramJSONObject.put("personalTags", localJSONArray);
      }
      paramJSONObject.put("popular", paramMatchInfo.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanChatFriendInfo.jdField_a_of_type_Long);
      if (paramMatchInfo.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanChatFriendInfo.jdField_b_of_type_JavaUtilArrayList != null)
      {
        localJSONArray = new JSONArray();
        localIterator = paramMatchInfo.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanChatFriendInfo.jdField_b_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext())
        {
          localObject = (SchoolInfo)localIterator.next();
          if (((SchoolInfo)localObject).jdField_a_of_type_JavaLangString != null)
          {
            localJSONObject = new JSONObject();
            localJSONObject.put("shcool_name", ((SchoolInfo)localObject).jdField_a_of_type_JavaLangString);
            localJSONObject.put("shcool_state", ((SchoolInfo)localObject).jdField_a_of_type_Long);
            localJSONArray.put(localJSONObject);
          }
        }
        if (localJSONArray.length() > 0) {
          paramJSONObject.put("shcoolInfos", localJSONArray);
        }
      }
    } while (paramMatchInfo.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanChatFriendInfo.jdField_f_of_type_Int < 0);
    paramJSONObject.put("distance", paramMatchInfo.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanChatFriendInfo.jdField_f_of_type_Int);
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt == 3342337) || (paramInt == 3342338) || (paramInt == 3342339) || (paramInt == 459802) || (paramInt == 459803) || (paramInt == 459817);
  }
  
  @Deprecated
  public static boolean a(SessionInfo paramSessionInfo)
  {
    if (paramSessionInfo == null) {
      return false;
    }
    return c(paramSessionInfo.jdField_a_of_type_Int);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    if ((paramQQAppInterface == null) || (paramMessageRecord == null) || (TextUtils.isEmpty(paramMessageRecord.frienduin))) {}
    String str;
    boolean bool;
    do
    {
      return false;
      int i = a(paramQQAppInterface);
      str = a(paramQQAppInterface);
      if (QLog.isColorLevel()) {
        QLog.d("LimitChatUtil", 2, "checkInterceptMessage, current state:" + i + " uin:" + str);
      }
      bool = ExpandFriendChatUtil.a(paramQQAppInterface);
      if (QLog.isColorLevel()) {
        QLog.d("LimitChatUtil", 2, "checkInterceptMessage showEntry = " + bool);
      }
    } while ((paramMessageRecord.frienduin.equals(str)) && (bool));
    if (QLog.isColorLevel()) {
      QLog.d("LimitChatUtil", 2, "checkInterceptMessage, intercept");
    }
    c(paramQQAppInterface, paramMessageRecord.frienduin);
    return true;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    if (paramQQAppInterface != null)
    {
      Object localObject = paramQQAppInterface.getMessageFacade().a(paramString, paramInt, null);
      if ((localObject != null) && (!((List)localObject).isEmpty()))
      {
        Collections.sort((List)localObject, new LimitChatUtil.2());
        localObject = (MessageRecord)((List)localObject).get(((List)localObject).size() - 1);
        if ((localObject instanceof MessageForLimitChatTopic))
        {
          if (QLog.isDevelopLevel()) {
            QLog.i("LimitChatUtil", 4, "clearLastTopicMessage done:" + ((MessageRecord)localObject).msgseq);
          }
          paramQQAppInterface.getMessageFacade().b(paramString, paramInt, ((MessageRecord)localObject).uniseq);
          return true;
        }
      }
    }
    return false;
  }
  
  private static boolean a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, MessageRecord paramMessageRecord)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {}
    while ((paramMessageRecord == null) || (!(paramMessageRecord instanceof MessageForUniteGrayTip)) || (((MessageForUniteGrayTip)paramMessageRecord).tipParam.jdField_b_of_type_Int != paramInt)) {
      return false;
    }
    return true;
  }
  
  public static boolean a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {}
    while (!b(paramMessageRecord.istroop)) {
      return false;
    }
    return true;
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString)
  {
    ((IceBreakingMng)paramQQAppInterface.getManager(QQManagerFactory.ICE_BREAKING_MNG)).a(paramString);
  }
  
  public static boolean b(int paramInt)
  {
    return (1044 == paramInt) || (1045 == paramInt);
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    if ((paramQQAppInterface == null) || (paramMessageRecord == null) || (TextUtils.isEmpty(paramMessageRecord.frienduin))) {}
    boolean bool;
    do
    {
      return false;
      bool = ExpandFriendChatUtil.a(paramQQAppInterface);
      if (QLog.isColorLevel()) {
        QLog.d("LimitChatUtil", 2, "checkInterceptMatchMessage showEntry = " + bool);
      }
    } while (bool);
    if (QLog.isColorLevel()) {
      QLog.d("LimitChatUtil", 2, "checkInterceptMatchMessage, intercept");
    }
    c(paramQQAppInterface, paramMessageRecord.frienduin);
    return true;
  }
  
  @Deprecated
  public static boolean b(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {}
    while (!c(paramMessageRecord.istroop)) {
      return false;
    }
    return true;
  }
  
  public static void c(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LimitChatUtil", 2, "getLimitChatState in mainprocess");
    }
    LimitChatDamon.a().a(paramQQAppInterface, paramString);
  }
  
  @Deprecated
  public static boolean c(int paramInt)
  {
    return 1037 == paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.limitchat.LimitChatUtil
 * JD-Core Version:    0.7.0.1
 */