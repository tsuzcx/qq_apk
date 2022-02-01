package com.tencent.mobileqq.qqexpand.chat.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.gdtad.aditem.GdtAdUtil;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.QPublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.ark.ArkAppCenterUtil;
import com.tencent.mobileqq.ark.api.IArkService;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForLimitChatTopic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.extendfriend.utils.ExtendFriendCardUtils;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.leba.ILebaHelperService;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qqexpand.ExpandConstants;
import com.tencent.mobileqq.qqexpand.bean.chat.ChatFriendInfo;
import com.tencent.mobileqq.qqexpand.bean.chat.ExpandFriendData;
import com.tencent.mobileqq.qqexpand.bean.chat.SchoolInfo;
import com.tencent.mobileqq.qqexpand.bean.match.MatchInfo;
import com.tencent.mobileqq.qqexpand.bean.match.PersonalTag;
import com.tencent.mobileqq.qqexpand.bean.profile.ExpandUserInfo;
import com.tencent.mobileqq.qqexpand.chat.LimitChatDamon;
import com.tencent.mobileqq.qqexpand.ipc.ExpandFlutterIPCClient;
import com.tencent.mobileqq.qqexpand.manager.IExpandManager;
import com.tencent.mobileqq.qqexpand.network.IExpandCmdCallback;
import com.tencent.mobileqq.qqexpand.network.IExpandCmdHandler;
import com.tencent.mobileqq.qqexpand.utils.DateUtils;
import com.tencent.mobileqq.qqexpand.utils.IExpandReportUtils;
import com.tencent.mobileqq.qqexpand.widget.ExtendFriendCardOnHeadIconClick;
import com.tencent.mobileqq.qqexpand.widget.ExtendFriendCardOnHeadIconClick.LRUCache;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relationx.icebreaking.IceBreakingMng;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.qqexpand.userConfig.userConfig.UserConfig.ExpandEntranceOptions;
import com.tencent.trpcprotocol.qqexpand.userConfig.userConfig.UserConfig.GetOptionsReq;
import com.tencent.trpcprotocol.qqexpand.userConfig.userConfig.UserConfig.Options;
import com.tencent.trpcprotocol.qqexpand.userConfig.userConfig.UserConfig.SetOptionsReq;
import expand.common.AddMatchedRaletionReq;
import expand.common.MatchedInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGet;
import tencent.gdt.qq_ad_get.QQAdGet.ContextInfo;
import tencent.gdt.qq_ad_get.QQAdGet.PositionInfo;
import tencent.gdt.qq_ad_get.QQAdGet.PositionInfo.PositionExt;
import tencent.gdt.qq_ad_get.QQAdGet.PositionInfo.PositionExt.ShareInfo;
import tencent.gdt.qq_ad_get.QQAdGet.UserInfo;

public class LimitChatUtil
{
  public static final Long a = Long.valueOf(5L);
  public static final int b = ArkAppCenterUtil.d - BaseChatItemLayout.s - BaseChatItemLayout.t;
  
  private static int a(Uri paramUri)
  {
    if ((paramUri != null) && (paramUri.getQueryParameter("srcType") != null)) {
      return Integer.parseInt(paramUri.getQueryParameter("srcType")) - 2;
    }
    return 3;
  }
  
  private static int a(Uri paramUri, String paramString, int paramInt)
  {
    int i = paramInt;
    if (paramUri != null)
    {
      i = paramInt;
      if (paramUri.getQueryParameter(paramString) != null) {
        i = Integer.parseInt(paramUri.getQueryParameter(paramString));
      }
    }
    return i;
  }
  
  private static int a(Map<String, Object> paramMap, String paramString, int paramInt)
  {
    int i = paramInt;
    if (paramMap != null)
    {
      i = paramInt;
      if (paramMap.get(paramString) != null) {
        i = Integer.parseInt((String)paramMap.get(paramString));
      }
    }
    return i;
  }
  
  public static long a(BaseQQAppInterface paramBaseQQAppInterface, MatchInfo paramMatchInfo, long paramLong, int paramInt1, int paramInt2)
  {
    if (paramBaseQQAppInterface != null)
    {
      if (paramMatchInfo == null) {
        return -1L;
      }
      if (!(paramBaseQQAppInterface instanceof QQAppInterface)) {
        return -1L;
      }
      QQAppInterface localQQAppInterface = (QQAppInterface)paramBaseQQAppInterface;
      Object localObject1 = localQQAppInterface.getMessageFacade().o(paramMatchInfo.c, paramInt2);
      Object localObject2 = ((List)localObject1).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        ChatMessage localChatMessage = (ChatMessage)((Iterator)localObject2).next();
        if (ExpandChatUtil.a(localChatMessage)) {
          return localChatMessage.time;
        }
      }
      if ((paramInt1 != 1) && (paramInt2 != 1045)) {
        paramInt1 = -4023;
      } else {
        paramInt1 = -4024;
      }
      localObject2 = (MessageForLimitChatTopic)MessageRecordFactory.a(paramInt1);
      long l;
      if ((localObject1 != null) && (!((List)localObject1).isEmpty())) {
        l = ((ChatMessage)((List)localObject1).get(((List)localObject1).size() - 1)).shmsgseq + 1L;
      } else {
        l = Math.abs(new Random().nextInt());
      }
      paramLong -= 5L;
      ((MessageForLimitChatTopic)localObject2).init(paramBaseQQAppInterface.getCurrentAccountUin(), paramMatchInfo.c, paramBaseQQAppInterface.getCurrentAccountUin(), paramMatchInfo.d, paramLong, paramInt1, paramInt2, l);
      ((MessageForLimitChatTopic)localObject2).isread = true;
      ((MessageForLimitChatTopic)localObject2).shmsgseq = l;
      localObject1 = new JSONObject();
      a((JSONObject)localObject1, paramMatchInfo);
      ((MessageForLimitChatTopic)localObject2).saveExtInfoToExtStr("match_chat_msg_data_key", ((JSONObject)localObject1).toString());
      if (QLog.isDevelopLevel()) {
        QLog.i("LimitChatUtil", 4, String.format(Locale.getDefault(), "addTopicMessage in seq %s  time %s", new Object[] { Long.valueOf(l), Long.valueOf(paramLong) }));
      }
      if (!MessageHandlerUtils.a(paramBaseQQAppInterface, (MessageRecord)localObject2, false)) {
        localQQAppInterface.getMessageFacade().a((MessageRecord)localObject2, ((MessageForLimitChatTopic)localObject2).selfuin);
      }
      if (QLog.isDevelopLevel()) {
        QLog.i("LimitChatUtil", 4, String.format(Locale.getDefault(), "addTopicMessage in 2", new Object[0]));
      }
      return System.currentTimeMillis();
    }
    return -1L;
  }
  
  public static long a(QQAppInterface paramQQAppInterface, MatchInfo paramMatchInfo, long paramLong, int paramInt)
  {
    return a(paramQQAppInterface, paramMatchInfo, paramLong, paramInt, 1044);
  }
  
  private static Intent a(Context paramContext, String paramString1, String paramString2, Long paramLong, String paramString3, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("makeIntent, uin:");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(" nick:");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(" timestamp:");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(" topic:");
      localStringBuilder.append(paramString3);
      QLog.d("LimitChatUtil", 2, localStringBuilder.toString());
    }
    paramContext = new Intent(paramContext, ChatActivity.class);
    paramContext.putExtra("uin", paramString1);
    paramContext.putExtra("uinname", paramString2);
    paramContext.putExtra("uintype", 1044);
    if (paramInt == 0) {
      paramContext.putExtra("entrance", 21);
    } else {
      paramContext.putExtra("entrance", 20);
    }
    paramString1 = new Bundle();
    paramString1.putInt("key_limitchat_from_type", paramInt);
    paramContext.putExtras(paramString1);
    return paramContext;
  }
  
  public static MessageForArkApp a(QQAppInterface paramQQAppInterface, String paramString, long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject)
  {
    ArkAppMessage localArkAppMessage = new ArkAppMessage();
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    Object localObject = new JSONObject();
    JSONObject localJSONObject3 = new JSONObject();
    try
    {
      localJSONObject1.put("type", "normal");
      localJSONObject1.put("showSender", 0);
      localJSONObject1.put("hintWidth", b);
      localJSONObject1.put("hintHeight", 96);
      IExpandReportUtils localIExpandReportUtils = (IExpandReportUtils)QRoute.api(IExpandReportUtils.class);
      try
      {
        ((JSONObject)localObject).put("manage_test_plan", localIExpandReportUtils.getManageTestPlanParams(paramQQAppInterface));
        localJSONObject3.put("matchUin", Long.parseLong(paramString));
        localJSONObject3.put("localData", paramObject.toString());
        localJSONObject3.put("defaultReportParams", ((JSONObject)localObject).toString());
        localJSONObject2.put("metadata", localJSONObject3);
      }
      catch (Exception paramObject) {}
      localObject = new StringBuilder();
    }
    catch (Exception paramObject) {}
    ((StringBuilder)localObject).append("ArkMiniProfileCardMessage mateData error");
    ((StringBuilder)localObject).append(paramObject);
    QLog.e("LimitChatUtil", 1, ((StringBuilder)localObject).toString());
    localArkAppMessage.appId = "com.tencent.mobileqq.expandfriend";
    localArkAppMessage.appName = "com.tencent.mobileqq.expandfriend";
    localArkAppMessage.appDesc = "手机QQ校园扩列的mini资料卡动态化下发";
    localArkAppMessage.appView = "qq_expand_mini_profile_ark";
    localArkAppMessage.appMinVersion = "1.0.0.0";
    localArkAppMessage.config = localJSONObject1.toString();
    localArkAppMessage.metaList = localJSONObject2.toString();
    paramObject = (MessageForArkApp)MessageRecordFactory.a(paramInt2);
    paramObject.init(paramQQAppInterface.getCurrentAccountUin(), paramString, paramQQAppInterface.getCurrentAccountUin(), "mini profile ark message", paramLong2, paramInt2, paramInt1, paramLong1);
    paramObject.ark_app_message = localArkAppMessage;
    paramObject.frienduin = paramString;
    paramObject.mNeedTimeStamp = false;
    paramObject.isread = true;
    paramObject.shmsgseq = paramLong1;
    paramObject.getBytes();
    paramObject.parse();
    return paramObject;
  }
  
  private static UniteGrayTipParam a(AppInterface paramAppInterface, String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, String paramString4, int paramInt3)
  {
    long l = MessageCache.c();
    paramAppInterface = new UniteGrayTipParam(paramString1, paramAppInterface.getCurrentAccountUin(), paramString3, paramInt1, -5020, paramInt2, l);
    paramAppInterface.g = paramString3;
    if (!TextUtils.isEmpty(paramString4))
    {
      paramString1 = new Bundle();
      paramInt1 = paramString3.indexOf(paramString4);
      if (paramInt1 >= 0)
      {
        paramString1.putInt("key_action", paramInt3);
        paramString1.putString("textColor", "#40A0FF");
        paramString1.putString("key_action_DATA", paramString2);
        paramAppInterface.a(paramInt1, paramString4.length() + paramInt1, paramString1);
      }
    }
    return paramAppInterface;
  }
  
  public static String a()
  {
    String str2 = HardCodeUtil.a(2131896869);
    String str1 = str2;
    if (b().contains("extendSwitchText")) {
      str1 = b().getString("extendSwitchText", str2);
    }
    return str1;
  }
  
  public static String a(BaseQQAppInterface paramBaseQQAppInterface)
  {
    return ExpandChatUtil.c(paramBaseQQAppInterface);
  }
  
  public static String a(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      StringBuilder localStringBuilder;
      if (Long.parseLong(paramString1) < Long.parseLong(paramString2))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString1);
        localStringBuilder.append("_");
        localStringBuilder.append(paramString2);
        paramString1 = localStringBuilder;
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString2);
        localStringBuilder.append("_");
        localStringBuilder.append(paramString1);
        paramString1 = localStringBuilder;
      }
      return paramString1.toString();
    }
    return "";
  }
  
  public static qq_ad_get.QQAdGet a(long paramLong, String paramString, int paramInt1, int paramInt2)
  {
    return a(paramLong, paramString, paramInt1, paramInt2, 0L, 0L, 0, 0, 0, 0, null);
  }
  
  private static qq_ad_get.QQAdGet a(long paramLong1, String paramString1, int paramInt1, int paramInt2, long paramLong2, long paramLong3, int paramInt3, int paramInt4, int paramInt5, int paramInt6, String paramString2)
  {
    Object localObject1 = new qq_ad_get.QQAdGet.PositionInfo.PositionExt.ShareInfo();
    ((qq_ad_get.QQAdGet.PositionInfo.PositionExt.ShareInfo)localObject1).share_rate.set(paramInt6);
    ((qq_ad_get.QQAdGet.PositionInfo.PositionExt.ShareInfo)localObject1).share_check.set(GdtAdUtil.a(paramLong2, paramLong3, paramInt6));
    Object localObject2 = new qq_ad_get.QQAdGet.PositionInfo.PositionExt();
    ((qq_ad_get.QQAdGet.PositionInfo.PositionExt)localObject2).share_info.set((MessageMicro)localObject1);
    ((qq_ad_get.QQAdGet.PositionInfo.PositionExt)localObject2).deep_link_version.set(paramInt2);
    localObject1 = new qq_ad_get.QQAdGet.PositionInfo();
    ((qq_ad_get.QQAdGet.PositionInfo)localObject1).pos_id.set(paramString1);
    ((qq_ad_get.QQAdGet.PositionInfo)localObject1).ad_count.set(paramInt1);
    ((qq_ad_get.QQAdGet.PositionInfo)localObject1).pos_ext.set((MessageMicro)localObject2);
    paramString1 = new qq_ad_get.QQAdGet.ContextInfo();
    paramString1.public_id.set(paramLong2);
    paramString1.article_id.set(paramLong3);
    paramString1.tribe_tag.set(paramInt3);
    paramString1.tribe_id_tag.set(paramInt4);
    paramString1.source_from.set(paramInt5);
    localObject2 = new qq_ad_get.QQAdGet.UserInfo();
    ((qq_ad_get.QQAdGet.UserInfo)localObject2).qq.set(paramLong1);
    qq_ad_get.QQAdGet localQQAdGet = new qq_ad_get.QQAdGet();
    localQQAdGet.position_info.add((MessageMicro)localObject1);
    localQQAdGet.context_info.set(paramString1);
    localQQAdGet.user_info.set((MessageMicro)localObject2);
    localQQAdGet.gdt_cookie.set(paramString2);
    return localQQAdGet;
  }
  
  public static void a(Activity paramActivity, MatchInfo paramMatchInfo, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    String str1 = paramMatchInfo.c;
    String str2 = paramMatchInfo.d;
    paramString = a(paramActivity, str1, paramString, Long.valueOf(paramMatchInfo.e), str2, paramInt3);
    paramString.putExtra("need_check_apollo_dress_up", true);
    paramInt3 = paramMatchInfo.i;
    if (paramInt3 != 0)
    {
      if (paramInt3 != 1)
      {
        if (paramInt3 != 10000) {
          paramInt3 = 5;
        } else {
          paramInt3 = 7;
        }
      }
      else {
        paramInt3 = 3;
      }
    }
    else {
      paramInt3 = 4;
    }
    paramString.putExtra("key_limitchat_enter_type", paramInt3);
    paramString.putExtra("key_limitchat_match_sex_type", paramInt1);
    paramString.putExtra("key_limitchat_match_purpose", paramInt2);
    paramActivity.startActivity(paramString);
  }
  
  public static void a(Context paramContext, String paramString, int paramInt)
  {
    Object localObject = (AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null);
    FriendsManager localFriendsManager = (FriendsManager)((AppRuntime)localObject).getManager(QQManagerFactory.FRIENDS_MANAGER);
    if ((!paramString.equals(((AppRuntime)localObject).getCurrentUin())) && (localFriendsManager != null) && (localFriendsManager.n(paramString))) {
      return;
    }
    localObject = new Intent();
    ((Intent)localObject).putExtra("targetUin", paramString);
    ((Intent)localObject).putExtra("fromPage", paramInt);
    QPublicFragmentActivity.Launcher.a(paramContext, (Intent)localObject, QPublicTransFragmentActivity.class, ExtendFriendCardOnHeadIconClick.class);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("startAddFriendActivity ");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(paramString2);
      QLog.i("LimitChatUtil", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = ((IExpandManager)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).a(paramString1, false);
    int i;
    if (localObject != null) {
      i = ExpandUserInfo.fromTypeToSubID(((ExpandUserInfo)localObject).fromType);
    } else {
      i = 8;
    }
    if ((paramContext instanceof Activity))
    {
      paramContext = (Activity)paramContext;
      paramString1 = ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).startAddFriend(paramContext, 1, paramString1, null, 3094, i, paramString2, null, null, paramContext.getResources().getString(2131887625), null);
      if (paramString1 != null) {
        paramString1.putExtra("entrance", 1);
      }
      ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).launchAddFriendForResult(paramContext, paramString1, 16002);
    }
  }
  
  public static void a(Uri paramUri, Map<String, Object> paramMap)
  {
    if ((paramUri != null) && (paramUri.getQueryParameter("toUin") != null) && (paramUri.getQueryParameter("fromPage") != null))
    {
      int i = Integer.parseInt(paramUri.getQueryParameter("fromPage"));
      String str = paramUri.getQueryParameter("toUin");
      byte[] arrayOfByte = a(paramMap);
      int j = a(paramMap, "chooseCondition", 1);
      int k = a(paramUri, "matchSourceId", 0);
      int m = a(paramUri);
      int n = a(paramUri, "accostType", 163);
      int i1 = a(paramUri, "isPassive", 0);
      ExpandFlutterIPCClient.a().a(str, i, m, n, i1, j, k, arrayOfByte);
      return;
    }
    QLog.e("LimitChatUtil", 2, "flutterEnterLimitChatAIO, necessary arguments is null, will not jump to AIO ");
  }
  
  public static void a(AppInterface paramAppInterface, String paramString, int paramInt, boolean paramBoolean, @NonNull Object paramObject)
  {
    ThreadManager.getSubThreadHandler().post(new LimitChatUtil.3(paramAppInterface, paramString, paramBoolean, paramInt, paramObject));
  }
  
  public static void a(AppInterface paramAppInterface, String paramString, @NonNull Object paramObject)
  {
    ExtendFriendCardOnHeadIconClick.a.put(paramString, (String)paramObject);
    ExtendFriendCardOnHeadIconClick.b.put(paramString, Long.valueOf(System.currentTimeMillis()));
  }
  
  public static void a(BaseQQAppInterface paramBaseQQAppInterface, Long paramLong, BusinessObserver paramBusinessObserver)
  {
    if (paramBaseQQAppInterface != null)
    {
      if (paramBaseQQAppInterface.getRuntimeService(IArkService.class) == null) {
        return;
      }
      String str2;
      try
      {
        String str1 = new JSONObject().put("uin", paramLong).toString();
      }
      catch (JSONException localJSONException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("preLoadDataForAvatarProfileCard error");
        localStringBuilder.append(localJSONException);
        QLog.w("LimitChatUtil", 1, localStringBuilder.toString());
        str2 = "";
      }
      int i;
      if (paramLong.equals(Long.valueOf(Long.parseLong(paramBaseQQAppInterface.getCurrentUin())))) {
        i = 32;
      } else {
        i = 33;
      }
      ((IArkService)paramBaseQQAppInterface.getRuntimeService(IArkService.class)).sendAppMsg("QQExpand.UserInfo.GetMiniUserInfo", str2, 30000, i, paramBusinessObserver);
    }
  }
  
  public static void a(BaseQQAppInterface paramBaseQQAppInterface, Long paramLong, IExpandCmdCallback paramIExpandCmdCallback)
  {
    if (paramBaseQQAppInterface == null) {
      return;
    }
    UserConfig.GetOptionsReq localGetOptionsReq = new UserConfig.GetOptionsReq();
    localGetOptionsReq.optionIDs.add(Integer.valueOf(3));
    localGetOptionsReq.Uin.set(paramLong.longValue());
    ((IExpandCmdHandler)QRoute.api(IExpandCmdHandler.class)).sendSSORequest(paramBaseQQAppInterface, "QQExpand.UserConfig.GetOptions", localGetOptionsReq.toByteArray(), paramIExpandCmdCallback);
    if (QLog.isColorLevel())
    {
      paramBaseQQAppInterface = new StringBuilder();
      paramBaseQQAppInterface.append("cmd=QQExpand.UserConfig.GetOptions, req=");
      paramBaseQQAppInterface.append(localGetOptionsReq.toString());
      QLog.d("LimitChatUtil", 1, paramBaseQQAppInterface.toString());
    }
  }
  
  public static void a(BaseQQAppInterface paramBaseQQAppInterface, String paramString)
  {
    if ((paramBaseQQAppInterface instanceof QQAppInterface))
    {
      paramBaseQQAppInterface = ((QQAppInterface)paramBaseQQAppInterface).getRecentUserProxy();
      if (paramBaseQQAppInterface == null) {
        return;
      }
      paramString = paramBaseQQAppInterface.b(paramString, 0);
      long l = NetConnInfoCenter.getServerTime();
      if (paramString.lastmsgtime < l) {
        paramString.lastmsgtime = l;
      }
      paramBaseQQAppInterface.b(paramString);
      return;
    }
    QLog.w("LimitChatUtil", 1, "app not instanceof QQAppInterface");
  }
  
  public static void a(BaseQQAppInterface paramBaseQQAppInterface, String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, String paramString4, int paramInt3, MessageRecord paramMessageRecord)
  {
    if ((paramBaseQQAppInterface != null) && (!TextUtils.isEmpty(paramString1)))
    {
      if (TextUtils.isEmpty(paramString3)) {
        return;
      }
      if ((paramMessageRecord != null) && (a(paramBaseQQAppInterface, paramString1, paramInt2, paramMessageRecord)))
      {
        QLog.w("LimitChatUtil", 1, "addGrayTipsMessage last tip message is same");
        return;
      }
      paramString1 = a(paramBaseQQAppInterface, paramString1, paramInt1, paramString2, paramString3, paramInt2, paramString4, paramInt3);
      long l = b(paramMessageRecord);
      paramString2 = new MessageForUniteGrayTip();
      paramString2.initGrayTipMsg(paramBaseQQAppInterface, paramString1);
      paramString2.isread = true;
      paramString2.shmsgseq = l;
      paramString2.mNeedTimeStamp = true;
      paramString2.updateUniteGrayTipMsgData(paramBaseQQAppInterface);
      if ((paramBaseQQAppInterface instanceof QQAppInterface))
      {
        ((QQAppInterface)paramBaseQQAppInterface).getMessageFacade().a(paramString2, paramBaseQQAppInterface.getCurrentAccountUin());
        return;
      }
      QLog.w("LimitChatUtil", 1, "app not instanceof QQAppInterface");
    }
  }
  
  public static void a(BaseQQAppInterface paramBaseQQAppInterface, String paramString1, int paramInt1, String paramString2, boolean paramBoolean, int paramInt2)
  {
    IExpandManager localIExpandManager = (IExpandManager)paramBaseQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
    paramString2 = localIExpandManager.a(paramString1, true);
    paramBaseQQAppInterface = paramString2;
    if (paramString2 == null) {
      paramBaseQQAppInterface = new ExpandUserInfo();
    }
    paramBaseQQAppInterface.uin = paramString1;
    localIExpandManager.a(paramBaseQQAppInterface);
  }
  
  public static void a(BaseQQAppInterface paramBaseQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    AddMatchedRaletionReq localAddMatchedRaletionReq = new AddMatchedRaletionReq();
    localAddMatchedRaletionReq.UserInfo.set(new MatchedInfo());
    localAddMatchedRaletionReq.UserInfo.MatchedUin.set(Long.parseLong(paramString1));
    localAddMatchedRaletionReq.UserInfo.MatchSrcId.set(paramInt);
    localAddMatchedRaletionReq.MatchUserInfo.set(new MatchedInfo());
    localAddMatchedRaletionReq.MatchUserInfo.MatchedUin.set(Long.parseLong(paramString2));
    localAddMatchedRaletionReq.MatchUserInfo.MatchSrcId.set(paramInt);
    ((IExpandCmdHandler)QRoute.api(IExpandCmdHandler.class)).sendSSORequest(paramBaseQQAppInterface, "QQExpand.ExpandRelation.AddMatchedRaletion", localAddMatchedRaletionReq.toByteArray(), new LimitChatUtil.5());
  }
  
  public static void a(BaseQQAppInterface paramBaseQQAppInterface, boolean paramBoolean, IExpandCmdCallback paramIExpandCmdCallback)
  {
    if (paramBaseQQAppInterface == null) {
      return;
    }
    UserConfig.SetOptionsReq localSetOptionsReq = new UserConfig.SetOptionsReq();
    localSetOptionsReq.optionIDs.add(Integer.valueOf(3));
    localSetOptionsReq.options.expandEntranceOptions.IsAllowDisplayEntrance.set(paramBoolean);
    localSetOptionsReq.options.expandEntranceOptions.setHasFlag(true);
    localSetOptionsReq.options.setHasFlag(true);
    ((IExpandCmdHandler)QRoute.api(IExpandCmdHandler.class)).sendSSORequest(paramBaseQQAppInterface, "QQExpand.UserConfig.SetOptions", localSetOptionsReq.toByteArray(), paramIExpandCmdCallback);
    if (QLog.isColorLevel())
    {
      paramBaseQQAppInterface = new StringBuilder();
      paramBaseQQAppInterface.append("cmd=QQExpand.UserConfig.SetOptions, req=");
      paramBaseQQAppInterface.append(localSetOptionsReq.toString());
      QLog.d("LimitChatUtil", 1, paramBaseQQAppInterface.toString());
    }
  }
  
  public static void a(BaseQQAppInterface paramBaseQQAppInterface, boolean paramBoolean, String paramString, long paramLong)
  {
    SharedPreferences localSharedPreferences = b();
    Object localObject;
    if (!localSharedPreferences.contains(paramBaseQQAppInterface.getCurrentUin()))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("setup user_switch configs:");
        ((StringBuilder)localObject).append(paramBoolean);
        QLog.i("LimitChatUtil", 2, ((StringBuilder)localObject).toString());
      }
    }
    else if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("update user_switch configs:");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.i("LimitChatUtil", 2, ((StringBuilder)localObject).toString());
    }
    if (paramString != null)
    {
      localObject = paramString;
      if (!TextUtils.isEmpty(paramString)) {}
    }
    else
    {
      localObject = a();
    }
    localSharedPreferences.edit().putBoolean(paramBaseQQAppInterface.getCurrentUin(), paramBoolean).putLong(paramBaseQQAppInterface.getCurrentUin().concat("_ts"), paramLong).putString("extendSwitchText", (String)localObject).apply();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LimitChatUtil", 2, "getLimitChatState in mainprocess");
    }
    LimitChatDamon.a().a(paramQQAppInterface, paramString);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, int paramInt2)
  {
    Intent localIntent = new Intent(paramQQAppInterface.getApplicationContext(), ChatActivity.class);
    localIntent.putExtra("uin", paramString);
    localIntent.putExtra("uintype", paramInt1);
    localIntent.putExtra("entrance", 20);
    localIntent.putExtra("key_limitchat_enter_type", 6);
    localIntent.putExtra("key_limitchat_match_purpose", paramInt2);
    localIntent.putExtra("uinname", "");
    localIntent.setFlags(268435456);
    paramQQAppInterface.getApplicationContext().startActivity(localIntent);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    Intent localIntent = new Intent(paramQQAppInterface.getApplicationContext(), ChatActivity.class);
    localIntent.putExtra("uin", paramString);
    String str2 = ContactUtils.h(paramQQAppInterface, paramString);
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = ContactUtils.a(paramQQAppInterface, paramString, false);
    }
    localIntent.putExtra("uinname", str1);
    if (paramInt4 == 163) {
      localIntent.putExtra("uintype", 1044);
    } else if (paramInt4 == 166) {
      localIntent.putExtra("uintype", 1045);
    }
    if (paramInt1 == 6) {
      localIntent.putExtra("entrance", 20);
    } else {
      localIntent.putExtra("entrance", 21);
    }
    paramString = new Bundle();
    paramString.putInt("key_limitchat_from_type", 0);
    localIntent.putExtras(paramString);
    localIntent.putExtra("need_check_apollo_dress_up", true);
    localIntent.putExtra("key_limitchat_enter_type", paramInt2);
    localIntent.putExtra("key_limitchat_match_relation_source", paramInt7);
    localIntent.putExtra("key_is_passive", paramInt3);
    localIntent.putExtra("key_limitchat_match_sex_type", paramInt5);
    localIntent.putExtra("key_limitchat_match_purpose", paramInt6);
    localIntent.setFlags(268435456);
    paramQQAppInterface.getApplicationContext().startActivity(localIntent);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, int paramInt1, String paramString2, boolean paramBoolean1, int paramInt2, boolean paramBoolean2, int paramInt3)
  {
    IExpandManager localIExpandManager = (IExpandManager)paramQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
    paramString2 = localIExpandManager.a(paramString1, true);
    paramQQAppInterface = paramString2;
    if (paramString2 == null) {
      paramQQAppInterface = new ExpandUserInfo();
    }
    paramQQAppInterface.uin = paramString1;
    localIExpandManager.a(paramQQAppInterface);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean, int paramInt, Object paramObject)
  {
    if (paramQQAppInterface != null)
    {
      if (paramString == null) {
        return;
      }
      List localList = paramQQAppInterface.getMessageFacade().o(paramString, paramInt);
      if (ExpandChatUtil.a(localList)) {
        return;
      }
      c(paramQQAppInterface, paramString);
      if (a(paramObject)) {
        b(paramQQAppInterface, paramString);
      }
      long l1 = ExpandChatUtil.b(localList);
      long l2 = ExpandChatUtil.c(localList);
      if (!paramBoolean)
      {
        paramBoolean = ((IExpandManager)paramQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).ac();
        if ((paramInt == 1045) || (paramBoolean))
        {
          i = -4026;
          break label105;
        }
      }
      int i = -4025;
      label105:
      if (QLog.isDevelopLevel()) {
        QLog.i("LimitChatUtil", 4, String.format("addArkMiniProfileCard in seq %s  time %s", new Object[] { Long.valueOf(l1), Long.valueOf(l2) }));
      }
      paramString = a(paramQQAppInterface, paramString, l1, l2, paramInt, i, paramObject);
      paramQQAppInterface.getMessageFacade().a(paramString, paramQQAppInterface.getCurrentAccountUin());
    }
  }
  
  public static void a(MessageRecord paramMessageRecord, AppInterface paramAppInterface)
  {
    ThreadManager.executeOnSubThread(new LimitChatUtil.2((QQAppInterface)paramAppInterface, paramMessageRecord));
  }
  
  private static void a(JSONObject paramJSONObject, MatchInfo paramMatchInfo)
  {
    for (;;)
    {
      try
      {
        if (paramMatchInfo.d != null) {
          paramJSONObject.put("topic_msg", paramMatchInfo.d);
        }
        if (paramMatchInfo.k != null)
        {
          if (paramMatchInfo.k.b != null) {
            paramJSONObject.put("age", paramMatchInfo.k.b);
          }
          paramJSONObject.put("gender", paramMatchInfo.k.h);
          paramJSONObject.put("matchTagId", paramMatchInfo.i);
          paramJSONObject.put("matchTagName", paramMatchInfo.j);
          if (paramMatchInfo.k.c != null) {
            paramJSONObject.put("constellation", paramMatchInfo.k.c);
          }
          if (paramMatchInfo.k.e != null) {
            paramJSONObject.put("school", paramMatchInfo.k.e);
          }
          if (paramMatchInfo.k.g != null) {
            paramJSONObject.put("company", paramMatchInfo.k.g);
          }
          if (paramMatchInfo.k.d != null) {
            paramJSONObject.put("city", paramMatchInfo.k.d);
          }
          if (paramMatchInfo.k.i != null) {
            paramJSONObject.put("declaration", paramMatchInfo.k.i);
          }
          if (paramMatchInfo.k.j != null) {
            paramJSONObject.put("voiceUrl", paramMatchInfo.k.j);
          }
          paramJSONObject.put("voiceDuration", paramMatchInfo.k.k);
          if (paramMatchInfo.k.l != null) {
            paramJSONObject.put("signWords", paramMatchInfo.k.l);
          }
          JSONArray localJSONArray;
          Iterator localIterator;
          Object localObject;
          JSONObject localJSONObject;
          if (paramMatchInfo.k.f != null)
          {
            localJSONArray = new JSONArray();
            localIterator = paramMatchInfo.k.f.iterator();
            if (localIterator.hasNext())
            {
              localObject = (PersonalTag)localIterator.next();
              if (((PersonalTag)localObject).b == null) {
                continue;
              }
              localJSONObject = new JSONObject();
              localJSONObject.put("tagName", ((PersonalTag)localObject).b);
              if (((PersonalTag)localObject).a == 0) {
                break label616;
              }
              bool = true;
              localJSONObject.put("tagSame", bool);
              localJSONArray.put(localJSONObject);
              continue;
            }
            if (localJSONArray.length() > 0) {
              paramJSONObject.put("personalTags", localJSONArray);
            }
          }
          paramJSONObject.put("popular", paramMatchInfo.k.p);
          if (paramMatchInfo.k.q != null)
          {
            localJSONArray = new JSONArray();
            localIterator = paramMatchInfo.k.q.iterator();
            if (localIterator.hasNext())
            {
              localObject = (SchoolInfo)localIterator.next();
              if (((SchoolInfo)localObject).a == null) {
                continue;
              }
              localJSONObject = new JSONObject();
              localJSONObject.put("shcool_name", ((SchoolInfo)localObject).a);
              localJSONObject.put("shcool_state", ((SchoolInfo)localObject).c);
              localJSONArray.put(localJSONObject);
              continue;
            }
            if (localJSONArray.length() > 0) {
              paramJSONObject.put("shcoolInfos", localJSONArray);
            }
          }
          if (paramMatchInfo.k.r >= 0)
          {
            paramJSONObject.put("distance", paramMatchInfo.k.r);
            return;
          }
        }
      }
      catch (JSONException paramJSONObject)
      {
        if (QLog.isDevelopLevel())
        {
          paramMatchInfo = new StringBuilder();
          paramMatchInfo.append("initProfileJSON ");
          paramMatchInfo.append(paramJSONObject);
          QLog.i("LimitChatUtil", 4, paramMatchInfo.toString());
        }
      }
      return;
      label616:
      boolean bool = false;
    }
  }
  
  public static boolean a(int paramInt)
  {
    return (1044 == paramInt) || (1045 == paramInt);
  }
  
  public static boolean a(AppInterface paramAppInterface)
  {
    return ExpandChatUtil.d(paramAppInterface);
  }
  
  private static boolean a(AppInterface paramAppInterface, String paramString, int paramInt, MessageRecord paramMessageRecord)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramAppInterface != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return false;
      }
      if (paramMessageRecord == null) {
        return false;
      }
      if (!(paramMessageRecord instanceof MessageForUniteGrayTip)) {
        return false;
      }
      bool1 = bool2;
      if (((MessageForUniteGrayTip)paramMessageRecord).tipParam.i == paramInt) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean a(BaseQQAppInterface paramBaseQQAppInterface, MessageRecord paramMessageRecord)
  {
    boolean bool3 = false;
    boolean bool2 = bool3;
    if (paramBaseQQAppInterface != null)
    {
      bool2 = bool3;
      if (paramMessageRecord != null)
      {
        if (TextUtils.isEmpty(paramMessageRecord.frienduin)) {
          return false;
        }
        if (!(paramBaseQQAppInterface instanceof QQAppInterface)) {
          return false;
        }
        paramBaseQQAppInterface = (QQAppInterface)paramBaseQQAppInterface;
        boolean bool1;
        if ((!a(paramBaseQQAppInterface)) && (!ExtendFriendCardUtils.b(paramBaseQQAppInterface))) {
          bool1 = false;
        } else {
          bool1 = true;
        }
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("checkInterceptMatchMessage showEntry = ");
          localStringBuilder.append(bool1);
          QLog.d("LimitChatUtil", 2, localStringBuilder.toString());
        }
        bool2 = bool3;
        if (!bool1)
        {
          if (QLog.isColorLevel()) {
            QLog.d("LimitChatUtil", 2, "checkInterceptMatchMessage, intercept");
          }
          a(paramBaseQQAppInterface, paramMessageRecord.frienduin);
          bool2 = true;
        }
      }
    }
    return bool2;
  }
  
  private static boolean a(QQAppInterface paramQQAppInterface)
  {
    if (!ExpandChatUtil.b(paramQQAppInterface)) {
      return false;
    }
    return ((ILebaHelperService)paramQQAppInterface.getRuntimeService(ILebaHelperService.class, "")).isPluginOpen(7720L);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    if (paramQQAppInterface != null)
    {
      Object localObject = paramQQAppInterface.getMessageFacade().a(paramString, paramInt, null);
      if ((localObject != null) && (!((List)localObject).isEmpty()))
      {
        Collections.sort((List)localObject, new LimitChatUtil.1());
        localObject = (MessageRecord)((List)localObject).get(((List)localObject).size() - 1);
        if ((localObject instanceof MessageForLimitChatTopic))
        {
          if (QLog.isDevelopLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("clearLastTopicMessage done:");
            localStringBuilder.append(((MessageRecord)localObject).msgseq);
            QLog.i("LimitChatUtil", 4, localStringBuilder.toString());
          }
          paramQQAppInterface.getMessageFacade().h(paramString, paramInt, ((MessageRecord)localObject).uniseq);
          return true;
        }
      }
    }
    return false;
  }
  
  public static boolean a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      return false;
    }
    return a(paramMessageRecord.istroop);
  }
  
  private static boolean a(Object paramObject)
  {
    try
    {
      int i = new JSONObject((String)paramObject).getJSONObject("infos").getJSONObject("match_src").getInt("id");
      if (i == 5) {
        return true;
      }
    }
    catch (Exception paramObject)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isNotShowIceBreakingMng get matchSource error");
      localStringBuilder.append(paramObject);
      QLog.w("LimitChatUtil", 1, localStringBuilder.toString());
    }
    return false;
  }
  
  public static boolean a(List<MessageRecord> paramList)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return false;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)paramList.next();
        if ((!b(localMessageRecord.msgtype)) && (c(localMessageRecord.extraflag))) {
          return true;
        }
      }
    }
    return false;
  }
  
  private static byte[] a(Map<String, Object> paramMap)
  {
    if (paramMap == null)
    {
      QLog.w("LimitChatUtil", 2, "getSignature failed, urlParams is null!");
      return null;
    }
    Object localObject = paramMap.get("sig");
    if ((localObject != null) && (localObject.getClass().isArray())) {
      try
      {
        paramMap = (byte[])paramMap.get("sig");
        return paramMap;
      }
      catch (Throwable paramMap)
      {
        QLog.e("LimitChatUtil", 1, "getSignature failed!", paramMap);
      }
    }
    return null;
  }
  
  private static long b(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord != null) {
      return paramMessageRecord.shmsgseq + 1L;
    }
    return Math.abs(new Random().nextInt());
  }
  
  private static SharedPreferences b()
  {
    return BaseApplication.getContext().getSharedPreferences("extend_friend_entrance", 0);
  }
  
  public static void b(BaseQQAppInterface paramBaseQQAppInterface, Long paramLong, BusinessObserver paramBusinessObserver)
  {
    if (paramBaseQQAppInterface != null)
    {
      if (paramBaseQQAppInterface.getRuntimeService(IArkService.class) == null) {
        return;
      }
      try
      {
        paramLong = new JSONObject().put("uin", paramLong).toString();
      }
      catch (JSONException paramLong)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("preLoadDataForArkMiniProfileCard error");
        localStringBuilder.append(paramLong);
        QLog.w("LimitChatUtil", 1, localStringBuilder.toString());
        paramLong = "";
      }
      ((IArkService)paramBaseQQAppInterface.getRuntimeService(IArkService.class)).sendAppMsg("QQExpand.UserInfo.GetMiniUserInfo", paramLong, 30000, 30, paramBusinessObserver);
    }
  }
  
  private static void b(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = (IceBreakingMng)paramQQAppInterface.getManager(QQManagerFactory.ICE_BREAKING_MNG);
    paramQQAppInterface.b(paramString);
    paramQQAppInterface.d();
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, int paramInt2)
  {
    if (paramInt2 == 4) {
      ExpandChatUtil.a(paramQQAppInterface, paramString, paramInt1, paramInt2, new LimitChatUtil.4(paramQQAppInterface, paramString, paramInt1));
    }
  }
  
  public static boolean b(int paramInt)
  {
    int[][] arrayOfInt = ExpandConstants.b;
    int k = arrayOfInt.length;
    int i = 0;
    while (i < k)
    {
      int[] arrayOfInt1 = arrayOfInt[i];
      int m = arrayOfInt1.length;
      int j = 0;
      while (j < m)
      {
        if (arrayOfInt1[j] == paramInt) {
          return true;
        }
        j += 1;
      }
      i += 1;
    }
    return false;
  }
  
  public static boolean b(BaseQQAppInterface paramBaseQQAppInterface)
  {
    SharedPreferences localSharedPreferences = b();
    if (!localSharedPreferences.contains(paramBaseQQAppInterface.getCurrentUin()))
    {
      if (QLog.isColorLevel()) {
        QLog.e("LimitChatUtil", 2, "configs not upgraded yet");
      }
      d(paramBaseQQAppInterface);
      return true;
    }
    if (localSharedPreferences.contains(paramBaseQQAppInterface.getCurrentUin()))
    {
      if (!c(paramBaseQQAppInterface)) {
        d(paramBaseQQAppInterface);
      }
      return localSharedPreferences.getBoolean(paramBaseQQAppInterface.getCurrentUin(), true);
    }
    return false;
  }
  
  public static boolean b(BaseQQAppInterface paramBaseQQAppInterface, String paramString)
  {
    if ((paramBaseQQAppInterface != null) && (!TextUtils.isEmpty(paramString)))
    {
      if (!(paramBaseQQAppInterface instanceof QQAppInterface))
      {
        QLog.w("LimitChatUtil", 1, "app not instanceof QQAppInterface");
        return false;
      }
      paramBaseQQAppInterface = ((QQAppInterface)paramBaseQQAppInterface).getRecentUserProxy();
      if (paramBaseQQAppInterface == null)
      {
        QLog.w("LimitChatUtil", 1, "needAddFriendConversationNode error, recentUserProxy is null");
        return false;
      }
      if (paramBaseQQAppInterface.a(paramString))
      {
        QLog.w("LimitChatUtil", 1, "needAddFriendConversationNode false, already add friend conversation node");
        return false;
      }
      return true;
    }
    QLog.w("LimitChatUtil", 1, "needAddFriendConversationNode error, app or matchUin is null");
    return false;
  }
  
  public static boolean b(List<MessageRecord> paramList)
  {
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        if (ExpandChatUtil.a((MessageRecord)paramList.next())) {
          return true;
        }
      }
    }
    return false;
  }
  
  public static void c(BaseQQAppInterface paramBaseQQAppInterface, String paramString)
  {
    ((IceBreakingMng)paramBaseQQAppInterface.getManager(QQManagerFactory.ICE_BREAKING_MNG)).a(paramString);
  }
  
  public static boolean c(int paramInt)
  {
    return (paramInt != 32772) && (paramInt != 32768);
  }
  
  private static boolean c(BaseQQAppInterface paramBaseQQAppInterface)
  {
    long l = b().getLong(paramBaseQQAppInterface.getCurrentUin().concat("_ts"), 0L);
    return System.currentTimeMillis() - l < 0L;
  }
  
  private static void d(BaseQQAppInterface paramBaseQQAppInterface)
  {
    a(paramBaseQQAppInterface, Long.valueOf(paramBaseQQAppInterface.getCurrentUin()), new -..Lambda.LimitChatUtil.XZvVExz_x6FfEedIeq8sVHp0x2U(paramBaseQQAppInterface));
  }
  
  public static boolean d(BaseQQAppInterface paramBaseQQAppInterface, String paramString)
  {
    long l = ExpandFriendData.getAdvertiseDate(paramBaseQQAppInterface, paramString);
    return DateUtils.a.b(l);
  }
  
  public static void e(BaseQQAppInterface paramBaseQQAppInterface, String paramString)
  {
    ((IceBreakingMng)paramBaseQQAppInterface.getManager(QQManagerFactory.ICE_BREAKING_MNG)).n(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.chat.utils.LimitChatUtil
 * JD-Core Version:    0.7.0.1
 */