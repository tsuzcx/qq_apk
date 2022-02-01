package com.tencent.mobileqq.qqexpand.chat.utils;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.LocaleManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ark.ArkAppCenterUtil;
import com.tencent.mobileqq.ark.IArkAppSSO;
import com.tencent.mobileqq.ark.api.IArkService;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.extendfriend.utils.ExtendFriendCardUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qqexpand.bean.chat.ExpandFriendData;
import com.tencent.mobileqq.qqexpand.manager.ExtendFriendLimitChatManager;
import com.tencent.mobileqq.qqexpand.manager.IExpandManager;
import com.tencent.mobileqq.qqexpand.manager.config.LimitChatOnPlusConfProcessor;
import com.tencent.mobileqq.qqexpand.manager.config.limitChatOnPlusConfBean;
import com.tencent.mobileqq.qqexpand.network.IExpandCmdHandler;
import com.tencent.mobileqq.qqexpand.network.IExpandHandler;
import com.tencent.mobileqq.qqexpand.utils.IExpandReportUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.qqexpand.entrance.entrance.Entrance.EntranceGetReq;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class ExpandChatUtil
{
  public static final int a = ArkAppCenterUtil.d - BaseChatItemLayout.s - BaseChatItemLayout.t;
  
  public static int a(BaseQQAppInterface paramBaseQQAppInterface, String paramString)
  {
    paramBaseQQAppInterface = a(paramBaseQQAppInterface);
    int i = 0;
    if (paramBaseQQAppInterface != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sp_match_chat_gray_section_");
      localStringBuilder.append(paramString);
      i = paramBaseQQAppInterface.getInt(localStringBuilder.toString(), 0);
    }
    return i;
  }
  
  public static SharedPreferences a(AppInterface paramAppInterface)
  {
    if (paramAppInterface == null)
    {
      QLog.e("ExpandFriendChatUtil", 2, "get sp by app is null");
      return null;
    }
    paramAppInterface = paramAppInterface.getCurrentUin();
    if ((paramAppInterface != null) && (!TextUtils.isEmpty(paramAppInterface)))
    {
      BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sp_for_extendfriend_limit_chat");
      localStringBuilder.append(paramAppInterface);
      return localBaseApplication.getSharedPreferences(localStringBuilder.toString(), 0);
    }
    QLog.e("ExpandFriendChatUtil", 2, "get sp by uin is null");
    return null;
  }
  
  public static SharedPreferences a(BaseQQAppInterface paramBaseQQAppInterface)
  {
    if (paramBaseQQAppInterface == null)
    {
      QLog.e("ExpandFriendChatUtil", 2, "get sp by app is null");
      return null;
    }
    paramBaseQQAppInterface = paramBaseQQAppInterface.getCurrentUin();
    if ((paramBaseQQAppInterface != null) && (!TextUtils.isEmpty(paramBaseQQAppInterface)))
    {
      BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sp_for_extendfriend_match_chat");
      localStringBuilder.append(paramBaseQQAppInterface);
      return localBaseApplication.getSharedPreferences(localStringBuilder.toString(), 0);
    }
    QLog.e("ExpandFriendChatUtil", 2, "get matchSp is null");
    return null;
  }
  
  private static MessageForArkApp a(QQAppInterface paramQQAppInterface, String paramString, long paramLong, int paramInt, Object paramObject)
  {
    Object localObject1 = new JSONObject();
    JSONObject localJSONObject1 = new JSONObject();
    Object localObject2 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    try
    {
      ((JSONObject)localObject1).put("type", "normal");
      ((JSONObject)localObject1).put("showSender", 0);
      ((JSONObject)localObject1).put("hintWidth", a);
      ((JSONObject)localObject1).put("hintHeight", 60);
      IExpandReportUtils localIExpandReportUtils = (IExpandReportUtils)QRoute.api(IExpandReportUtils.class);
      try
      {
        ((JSONObject)localObject2).put("manage_test_plan", localIExpandReportUtils.getManageTestPlanParams(paramQQAppInterface));
        localJSONObject2.put("matchUin", Long.parseLong(paramString));
        localJSONObject2.put("localData", paramObject.toString());
        localJSONObject2.put("defaultReportParams", ((JSONObject)localObject2).toString());
        localJSONObject2.put("msgSeq", paramLong);
        localJSONObject1.put("metadata", localJSONObject2);
      }
      catch (Exception paramObject) {}
      localObject2 = new StringBuilder();
    }
    catch (Exception paramObject) {}
    ((StringBuilder)localObject2).append("initIcebreakerTopicMessage mateData error");
    ((StringBuilder)localObject2).append(paramObject);
    QLog.e("ExpandFriendChatUtil", 1, ((StringBuilder)localObject2).toString());
    paramObject = new ArkAppMessage();
    paramObject.appId = "com.tencent.mobileqq.expandfriend.breakicetopic";
    paramObject.appName = "com.tencent.mobileqq.expandfriend.breakicetopic";
    paramObject.appDesc = "手机QQ校园扩列破冰话题";
    paramObject.appView = "expand_icebreak_topic";
    paramObject.appMinVersion = "1.0.0.0";
    paramObject.config = ((JSONObject)localObject1).toString();
    paramObject.metaList = localJSONObject1.toString();
    long l = System.currentTimeMillis() / 1000L;
    localObject1 = (MessageForArkApp)MessageRecordFactory.a(-4027);
    ((MessageForArkApp)localObject1).init(paramQQAppInterface.getCurrentAccountUin(), paramString, paramQQAppInterface.getCurrentAccountUin(), "mini profile ark message", l, -4027, paramInt, paramLong);
    if (QLog.isDevelopLevel()) {
      QLog.i("ExpandFriendChatUtil", 4, String.format(Locale.getDefault(), "insertIcebreakerTopic in seq %s  time %s", new Object[] { Long.valueOf(paramLong), Long.valueOf(l) }));
    }
    ((MessageForArkApp)localObject1).ark_app_message = paramObject;
    ((MessageForArkApp)localObject1).frienduin = paramString;
    ((MessageForArkApp)localObject1).mNeedTimeStamp = false;
    ((MessageForArkApp)localObject1).isread = true;
    ((MessageForArkApp)localObject1).shmsgseq = paramLong;
    ((MessageForArkApp)localObject1).getBytes();
    ((MessageForArkApp)localObject1).parse();
    return localObject1;
  }
  
  public static void a(BaseQQAppInterface paramBaseQQAppInterface, ExpandFriendData paramExpandFriendData)
  {
    paramBaseQQAppInterface = (ExtendFriendLimitChatManager)paramBaseQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_LIMIT_CHAT_MANAGER);
    if (paramBaseQQAppInterface != null) {
      paramBaseQQAppInterface.a(paramExpandFriendData);
    }
  }
  
  public static void a(BaseQQAppInterface paramBaseQQAppInterface, String paramString, int paramInt)
  {
    paramBaseQQAppInterface = a(paramBaseQQAppInterface);
    if (paramBaseQQAppInterface != null)
    {
      paramBaseQQAppInterface = paramBaseQQAppInterface.edit();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sp_match_chat_gray_section_");
      localStringBuilder.append(paramString);
      paramBaseQQAppInterface.putInt(localStringBuilder.toString(), paramInt).commit();
    }
  }
  
  public static void a(BaseQQAppInterface paramBaseQQAppInterface, String paramString, int paramInt1, int paramInt2, BusinessObserver paramBusinessObserver)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.w("ExpandFriendChatUtil", 1, "showIcebreakerTopic but matchUin is empty");
      return;
    }
    if ((paramInt2 > 100) && (paramInt2 < 200)) {
      return;
    }
    if (!(paramBaseQQAppInterface instanceof QQAppInterface)) {
      return;
    }
    paramBaseQQAppInterface = (QQAppInterface)paramBaseQQAppInterface;
    boolean bool1 = a(paramBaseQQAppInterface, paramString, paramInt1);
    boolean bool2 = c(paramBaseQQAppInterface, paramString);
    if (!bool1)
    {
      if (bool2) {
        return;
      }
      if (a(paramBaseQQAppInterface, paramString))
      {
        a(paramBaseQQAppInterface, Long.valueOf(Long.parseLong(paramString)), paramBusinessObserver);
        b(paramBaseQQAppInterface, paramString);
      }
    }
  }
  
  public static void a(BaseQQAppInterface paramBaseQQAppInterface, String paramString, int paramInt, Object paramObject)
  {
    ThreadManager.getSubThreadHandler().post(new ExpandChatUtil.3(paramBaseQQAppInterface, paramString, paramInt, paramObject));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Long paramLong, BusinessObserver paramBusinessObserver)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    IArkAppSSO localIArkAppSSO = ((IArkService)paramQQAppInterface.getRuntimeService(IArkService.class)).getSSO();
    try
    {
      paramQQAppInterface = new JSONObject().put("match_uin", paramLong).toString();
    }
    catch (JSONException paramQQAppInterface)
    {
      paramLong = new StringBuilder();
      paramLong.append("preLoadDataForIcebreakerTopic error");
      paramLong.append(paramQQAppInterface);
      QLog.w("ExpandFriendChatUtil", 1, paramLong.toString());
      paramQQAppInterface = "";
    }
    localIArkAppSSO.a("QQExpand.Prompt.GetIceBreakingTopic", paramQQAppInterface, 30000, 31, paramBusinessObserver);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    paramQQAppInterface = a(paramQQAppInterface);
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.edit();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sp_match_chat_algorithm_id");
      localStringBuilder.append(paramString1);
      paramQQAppInterface.putString(localStringBuilder.toString(), paramString2).commit();
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    int j = 1;
    if (paramQQAppInterface == null)
    {
      QLog.e("ExpandFriendChatUtil", 1, "checkAndUpdateExpandContactsEntrance app == null");
      return;
    }
    int i = j;
    if (!paramBoolean) {
      if (ExtendFriendCardUtils.c(paramQQAppInterface)) {
        i = j;
      } else {
        i = 0;
      }
    }
    if (i != 0) {
      c(paramQQAppInterface);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean, long paramLong1, int paramInt, String paramString, long paramLong2)
  {
    if (paramQQAppInterface == null)
    {
      QLog.e("ExpandFriendChatUtil", 2, "ExtendFriendLimitChat getLimitChatOnPlusExpireTime: app is null ");
      return;
    }
    SharedPreferences localSharedPreferences = a(paramQQAppInterface);
    if (localSharedPreferences != null)
    {
      String str = paramString;
      if (paramString == null) {
        str = "";
      }
      localSharedPreferences.edit().putBoolean("sp_limit_chat_on_plus_panel_be_show", paramBoolean).apply();
      localSharedPreferences.edit().putLong("sp_limit_chat_on_plus_panel_chat_time", paramLong1).apply();
      localSharedPreferences.edit().putInt("sp_limit_chat_on_plus_panel_left_count", paramInt).apply();
      localSharedPreferences.edit().putString("sp_limit_chat_on_plus_panel_name", str).apply();
      localSharedPreferences.edit().putLong("sp_limit_chat_on_plus_panel_expire_time", paramLong2).apply();
      long l = NetConnInfoCenter.getServerTime();
      localSharedPreferences.edit().putLong("sp_limit_chat_on_plus_panel_update_time", l).apply();
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("ExtendFriendLimitChat setShowLimitChatOnPlus  bShow: ");
        paramString.append(paramBoolean);
        paramString.append(" chatTime:");
        paramString.append(paramLong1);
        paramString.append(" leftCount:");
        paramString.append(paramInt);
        paramString.append(" funcName: ");
        paramString.append(str);
        paramString.append(" expireTime : ");
        paramString.append(paramLong2);
        paramString.append(" nowTime: ");
        paramString.append(l);
        QLog.i("ExpandFriendChatUtil", 2, paramString.toString());
      }
      if (paramBoolean) {
        ((IExpandManager)paramQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).a(paramQQAppInterface);
      }
    }
    else
    {
      QLog.e("ExpandFriendChatUtil", 2, "ExtendFriendLimitChat setShowLimitChatOnPlus on null sp");
    }
  }
  
  public static void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("ExpandFriendChatUtil", 2, "reportInSubThread UIN EMPTY");
      return;
    }
    ThreadManager.getSubThreadHandler().post(new ExpandChatUtil.2(paramString));
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = a(paramQQAppInterface);
    boolean bool2 = true;
    if (paramQQAppInterface == null) {
      return true;
    }
    if (LocaleManager.c())
    {
      QLog.i("ExpandFriendChatUtil", 2, "getLimitChatOnPlusExpireTime: by change local langauage");
      return true;
    }
    QLog.d("ExpandFriendChatUtil", 2, "getLimitChatOnPlusExpireTime: not ! by change local langauage");
    long l1 = paramQQAppInterface.getLong("sp_limit_chat_on_plus_panel_expire_time", 10L);
    long l2 = paramQQAppInterface.getLong("sp_limit_chat_on_plus_panel_update_time", 0L);
    long l3 = NetConnInfoCenter.getServerTime();
    long l4 = l3 - l2;
    boolean bool1 = bool2;
    if (l4 < l1)
    {
      bool1 = bool2;
      if (l4 > 0L) {
        bool1 = false;
      }
    }
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("getLimitChatOnPlusExpireTime: ");
      paramQQAppInterface.append(l1);
      paramQQAppInterface.append(" update :");
      paramQQAppInterface.append(l2);
      paramQQAppInterface.append(" now：");
      paramQQAppInterface.append(l3);
      paramQQAppInterface.append(" needUpdate：");
      paramQQAppInterface.append(bool1);
      QLog.d("ExpandFriendChatUtil", 2, paramQQAppInterface.toString());
    }
    return bool1;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    return ExpandFriendData.getHasEnterAIO(paramQQAppInterface, paramString);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    return paramQQAppInterface.getConversationFacade().a(paramString, paramInt) > 0;
  }
  
  public static boolean a(MessageRecord paramMessageRecord)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramMessageRecord != null) {
      if ((paramMessageRecord.msgtype != -4023) && (paramMessageRecord.msgtype != -4024) && (paramMessageRecord.msgtype != -4025))
      {
        bool1 = bool2;
        if (paramMessageRecord.msgtype != -4026) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean a(List<ChatMessage> paramList)
  {
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        if (a((ChatMessage)paramList.next())) {
          return true;
        }
      }
    }
    return false;
  }
  
  public static long b(List<ChatMessage> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      return ((ChatMessage)paramList.get(paramList.size() - 1)).shmsgseq + 1L;
    }
    return Math.abs(new Random().nextInt());
  }
  
  public static String b(BaseQQAppInterface paramBaseQQAppInterface, String paramString)
  {
    SharedPreferences localSharedPreferences = a(paramBaseQQAppInterface);
    paramBaseQQAppInterface = "0";
    if (localSharedPreferences != null)
    {
      paramBaseQQAppInterface = new StringBuilder();
      paramBaseQQAppInterface.append("sp_match_chat_algorithm_id");
      paramBaseQQAppInterface.append(paramString);
      paramBaseQQAppInterface = localSharedPreferences.getString(paramBaseQQAppInterface.toString(), "0");
    }
    return paramBaseQQAppInterface;
  }
  
  public static void b(BaseQQAppInterface paramBaseQQAppInterface, String paramString, int paramInt, Object paramObject)
  {
    if ((paramBaseQQAppInterface != null) && (!TextUtils.isEmpty(paramString)))
    {
      if (!(paramBaseQQAppInterface instanceof QQAppInterface))
      {
        QLog.w("ExpandFriendChatUtil", 1, "app not instanceof QQAppInterface");
        return;
      }
      QQAppInterface localQQAppInterface = (QQAppInterface)paramBaseQQAppInterface;
      paramString = a(localQQAppInterface, paramString, b(localQQAppInterface.getMessageFacade().o(paramString, paramInt)), paramInt, paramObject);
      localQQAppInterface.getMessageFacade().a(paramString, paramBaseQQAppInterface.getCurrentAccountUin());
      return;
    }
    QLog.w("ExpandFriendChatUtil", 1, "insertIcebreakerTopic but matchUin or app is empty");
  }
  
  public static void b(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null)
    {
      QLog.e("ExpandFriendChatUtil", 2, "ExtendFriendLimitChat checkAndUpdateLimiteChatSetting app null");
      return;
    }
    if (a(paramQQAppInterface))
    {
      paramQQAppInterface = (IExpandHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER);
      if (paramQQAppInterface != null)
      {
        paramQQAppInterface.a(true);
        return;
      }
      QLog.e("ExpandFriendChatUtil", 2, "ExtendFriendLimitChat handler null");
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString)
  {
    ThreadManager.getSubThreadHandler().post(new ExpandChatUtil.5(paramQQAppInterface, paramString));
  }
  
  public static boolean b(AppInterface paramAppInterface)
  {
    SharedPreferences localSharedPreferences = a(paramAppInterface);
    boolean bool2 = false;
    if (localSharedPreferences == null) {
      return false;
    }
    boolean bool1 = bool2;
    if (localSharedPreferences.getBoolean("sp_limit_chat_on_plus_panel_be_show", false))
    {
      bool1 = bool2;
      if (!ExtendFriendCardUtils.a(paramAppInterface)) {
        bool1 = true;
      }
    }
    if (QLog.isColorLevel())
    {
      paramAppInterface = new StringBuilder();
      paramAppInterface.append("needShowLimitChatOnPlus: ");
      paramAppInterface.append(bool1);
      QLog.d("ExpandFriendChatUtil", 2, paramAppInterface.toString());
    }
    return bool1;
  }
  
  public static boolean b(BaseQQAppInterface paramBaseQQAppInterface)
  {
    limitChatOnPlusConfBean locallimitChatOnPlusConfBean = LimitChatOnPlusConfProcessor.a();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (locallimitChatOnPlusConfBean != null)
    {
      bool1 = bool2;
      if (locallimitChatOnPlusConfBean.a())
      {
        bool1 = bool2;
        if (b(paramBaseQQAppInterface))
        {
          bool1 = bool2;
          if (locallimitChatOnPlusConfBean.b())
          {
            bool1 = bool2;
            if (!StudyModeManager.h()) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public static long c(List<ChatMessage> paramList)
  {
    long l1;
    if ((paramList != null) && (!paramList.isEmpty())) {
      l1 = ((ChatMessage)paramList.get(0)).time;
    }
    for (long l2 = LimitChatUtil.a.longValue();; l2 = LimitChatUtil.a.longValue())
    {
      return l1 - l2;
      l1 = System.currentTimeMillis() / 1000L;
    }
  }
  
  public static String c(AppInterface paramAppInterface)
  {
    paramAppInterface = a(paramAppInterface);
    if (paramAppInterface == null) {
      return "";
    }
    paramAppInterface = paramAppInterface.getString("sp_limit_chat_on_plus_panel_name", "");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getLimitChatOnPlusName: ");
      localStringBuilder.append(paramAppInterface);
      QLog.d("ExpandFriendChatUtil", 2, localStringBuilder.toString());
    }
    return paramAppInterface;
  }
  
  public static void c(BaseQQAppInterface paramBaseQQAppInterface)
  {
    paramBaseQQAppInterface = a(paramBaseQQAppInterface);
    if (paramBaseQQAppInterface != null) {
      paramBaseQQAppInterface.edit().clear().commit();
    }
  }
  
  public static void c(BaseQQAppInterface paramBaseQQAppInterface, String paramString)
  {
    ThreadManager.getSubThreadHandler().post(new ExpandChatUtil.4(paramBaseQQAppInterface, paramString));
  }
  
  private static void c(QQAppInterface paramQQAppInterface)
  {
    Entrance.EntranceGetReq localEntranceGetReq = new Entrance.EntranceGetReq();
    localEntranceGetReq.uin.set(paramQQAppInterface.getLongAccountUin());
    ((IExpandCmdHandler)QRoute.api(IExpandCmdHandler.class)).sendSSORequest(paramQQAppInterface, "trpc.qqexpand.entrance.svc.get", localEntranceGetReq.toByteArray(), new ExpandChatUtil.1(paramQQAppInterface));
  }
  
  public static boolean c(QQAppInterface paramQQAppInterface, String paramString)
  {
    return ExpandFriendData.getHasShowIcebreakerTopic(paramQQAppInterface, paramString);
  }
  
  public static ExpandFriendData d(BaseQQAppInterface paramBaseQQAppInterface, String paramString)
  {
    if ((paramBaseQQAppInterface != null) && (!TextUtils.isEmpty(paramString)))
    {
      paramBaseQQAppInterface = (ExtendFriendLimitChatManager)paramBaseQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_LIMIT_CHAT_MANAGER);
      if (paramBaseQQAppInterface != null)
      {
        ExpandFriendData localExpandFriendData = paramBaseQQAppInterface.a(paramString, true);
        paramBaseQQAppInterface = localExpandFriendData;
        if (localExpandFriendData == null) {
          paramBaseQQAppInterface = new ExpandFriendData(paramString);
        }
        return paramBaseQQAppInterface;
      }
      QLog.w("ExpandFriendChatUtil", 1, "getInstance error get ExtendFriendLimitChatManager failed");
      return null;
    }
    QLog.w("ExpandFriendChatUtil", 1, "getInstance error app or matchUin is invalid");
    return null;
  }
  
  public static boolean d(AppInterface paramAppInterface)
  {
    limitChatOnPlusConfBean locallimitChatOnPlusConfBean = LimitChatOnPlusConfProcessor.a();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (locallimitChatOnPlusConfBean != null)
    {
      bool1 = bool2;
      if (locallimitChatOnPlusConfBean.a())
      {
        bool1 = bool2;
        if (b(paramAppInterface))
        {
          bool1 = bool2;
          if (!locallimitChatOnPlusConfBean.b())
          {
            bool1 = bool2;
            if (!StudyModeManager.h()) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.chat.utils.ExpandChatUtil
 * JD-Core Version:    0.7.0.1
 */