package com.tencent.mobileqq.extendfriend.limitchat;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.LocaleManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.ArkAppSSO;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForLimitChatTopic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.extendfriend.Constants;
import com.tencent.mobileqq.extendfriend.ExtendFriendManager;
import com.tencent.mobileqq.extendfriend.bean.ExpandFriendData;
import com.tencent.mobileqq.extendfriend.network.ExtendFriendHandler;
import com.tencent.mobileqq.extendfriend.utils.ExpandReportUtils;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.limitchat.LimitChatUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class ExpandFriendChatUtil
{
  public static int a(QQAppInterface paramQQAppInterface, String paramString)
  {
    int i = 0;
    paramQQAppInterface = b(paramQQAppInterface);
    if (paramQQAppInterface != null) {
      i = paramQQAppInterface.getInt("sp_match_chat_gray_section_" + paramString, 0);
    }
    return i;
  }
  
  public static long a(List<ChatMessage> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      return ((ChatMessage)paramList.get(paramList.size() - 1)).shmsgseq + 1L;
    }
    return Math.abs(new Random().nextInt());
  }
  
  public static SharedPreferences a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null)
    {
      QLog.e("ExpandFriendChatUtil", 2, "get sp by app is null");
      return null;
    }
    paramQQAppInterface = paramQQAppInterface.getCurrentUin();
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramQQAppInterface)))
    {
      QLog.e("ExpandFriendChatUtil", 2, "get sp by uin is null");
      return null;
    }
    return BaseApplicationImpl.getContext().getSharedPreferences("sp_for_extendfriend_limit_chat" + paramQQAppInterface, 0);
  }
  
  private static MessageForArkApp a(QQAppInterface paramQQAppInterface, String paramString, long paramLong, int paramInt, Object paramObject)
  {
    MessageForArkApp localMessageForArkApp = (MessageForArkApp)MessageRecordFactory.a(-4027);
    ArkAppMessage localArkAppMessage = new ArkAppMessage();
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    JSONObject localJSONObject3 = new JSONObject();
    JSONObject localJSONObject4 = new JSONObject();
    try
    {
      localJSONObject1.put("type", "normal");
      localJSONObject1.put("showSender", 0);
      localJSONObject1.put("hintWidth", Constants.a);
      localJSONObject1.put("hintHeight", 60);
      localJSONObject3.put("manage_test_plan", ExpandReportUtils.a());
      localJSONObject4.put("matchUin", Long.parseLong(paramString));
      localJSONObject4.put("localData", paramObject.toString());
      localJSONObject4.put("defaultReportParams", localJSONObject3.toString());
      localJSONObject4.put("msgSeq", paramLong);
      localJSONObject2.put("metadata", localJSONObject4);
      localArkAppMessage.appId = "com.tencent.mobileqq.expandfriend.breakicetopic";
      localArkAppMessage.appName = "com.tencent.mobileqq.expandfriend.breakicetopic";
      localArkAppMessage.appDesc = "手机QQ校园扩列破冰话题";
      localArkAppMessage.appView = "expand_icebreak_topic";
      localArkAppMessage.appMinVersion = "1.0.0.0";
      localArkAppMessage.config = localJSONObject1.toString();
      localArkAppMessage.metaList = localJSONObject2.toString();
      long l = System.currentTimeMillis() / 1000L;
      localMessageForArkApp.init(paramQQAppInterface.getCurrentAccountUin(), paramString, paramQQAppInterface.getCurrentAccountUin(), "mini profile ark message", l, -4027, paramInt, paramLong);
      if (QLog.isDevelopLevel()) {
        QLog.i("ExpandFriendChatUtil", 4, String.format(Locale.getDefault(), "insertIcebreakerTopic in seq %s  time %s", new Object[] { Long.valueOf(paramLong), Long.valueOf(l) }));
      }
      localMessageForArkApp.ark_app_message = localArkAppMessage;
      localMessageForArkApp.frienduin = paramString;
      localMessageForArkApp.mNeedTimeStamp = false;
      localMessageForArkApp.isread = true;
      localMessageForArkApp.shmsgseq = paramLong;
      localMessageForArkApp.getBytes();
      localMessageForArkApp.parse();
      return localMessageForArkApp;
    }
    catch (Exception paramObject)
    {
      for (;;)
      {
        QLog.e("ExpandFriendChatUtil", 1, "initIcebreakerTopicMessage mateData error" + paramObject);
      }
    }
  }
  
  public static String a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = a(paramQQAppInterface);
    if (paramQQAppInterface == null) {
      paramQQAppInterface = "";
    }
    String str;
    do
    {
      return paramQQAppInterface;
      str = paramQQAppInterface.getString("sp_limit_chat_on_plus_panel_name", "");
      paramQQAppInterface = str;
    } while (!QLog.isColorLevel());
    QLog.d("ExpandFriendChatUtil", 2, "getLimitChatOnPlusName: " + str);
    return str;
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString)
  {
    String str = "0";
    SharedPreferences localSharedPreferences = b(paramQQAppInterface);
    paramQQAppInterface = str;
    if (localSharedPreferences != null) {
      paramQQAppInterface = localSharedPreferences.getString("sp_match_chat_algorithm_id" + paramString, "0");
    }
    return paramQQAppInterface;
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      QLog.e("ExpandFriendChatUtil", 2, "ExtendFriendLimitChat checkAndUpdateLimiteChatSetting app null");
    }
    while (!b(paramQQAppInterface)) {
      return;
    }
    paramQQAppInterface = (ExtendFriendHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER);
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface.a(true);
      return;
    }
    QLog.e("ExpandFriendChatUtil", 2, "ExtendFriendLimitChat handler null");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Long paramLong, BusinessObserver paramBusinessObserver)
  {
    ArkAppSSO localArkAppSSO = ((ArkAppCenter)paramQQAppInterface.getManager(QQManagerFactory.ARK_APP_CENTER_MANAGER)).a();
    paramQQAppInterface = "";
    try
    {
      paramLong = new JSONObject().put("match_uin", paramLong).toString();
      paramQQAppInterface = paramLong;
    }
    catch (JSONException paramLong)
    {
      for (;;)
      {
        QLog.w("ExpandFriendChatUtil", 1, "preLoadDataForIcebreakerTopic error" + paramLong);
      }
    }
    localArkAppSSO.a("QQExpand.Prompt.GetIceBreakingTopic", paramQQAppInterface, 30000, 31, paramBusinessObserver);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    ThreadManager.getSubThreadHandler().post(new ExpandFriendChatUtil.3(paramQQAppInterface, paramString));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    paramQQAppInterface = b(paramQQAppInterface);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.edit().putInt("sp_match_chat_gray_section_" + paramString, paramInt).commit();
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, int paramInt2, BusinessObserver paramBusinessObserver)
  {
    if (!((ExtendFriendManager)paramQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).f()) {}
    boolean bool1;
    boolean bool2;
    do
    {
      do
      {
        return;
        if (TextUtils.isEmpty(paramString))
        {
          QLog.w("ExpandFriendChatUtil", 1, "showIcebreakerTopic but matchUin is empty");
          return;
        }
      } while ((paramInt2 > 100) && (paramInt2 < 200));
      bool1 = a(paramQQAppInterface, paramString, paramInt1);
      bool2 = b(paramQQAppInterface, paramString);
    } while ((bool1) || (bool2) || ((!a(paramQQAppInterface, paramString)) && (paramInt2 != 4)));
    a(paramQQAppInterface, Long.valueOf(Long.parseLong(paramString)), paramBusinessObserver);
    b(paramQQAppInterface, paramString);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, Object paramObject)
  {
    ThreadManager.getSubThreadHandler().post(new ExpandFriendChatUtil.2(paramQQAppInterface, paramString, paramInt, paramObject));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    paramQQAppInterface = b(paramQQAppInterface);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.edit().putString("sp_match_chat_algorithm_id" + paramString1, paramString2).commit();
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean, long paramLong1, int paramInt, String paramString, long paramLong2)
  {
    if (paramQQAppInterface == null) {
      QLog.e("ExpandFriendChatUtil", 2, "ExtendFriendLimitChat getLimitChatOnPlusExpireTime: app is null ");
    }
    do
    {
      return;
      SharedPreferences localSharedPreferences = a(paramQQAppInterface);
      if (localSharedPreferences == null) {
        break;
      }
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
      if (QLog.isColorLevel()) {
        QLog.i("ExpandFriendChatUtil", 2, "ExtendFriendLimitChat setShowLimitChatOnPlus  bShow: " + paramBoolean + " chatTime:" + paramLong1 + " leftCount:" + paramInt + " funcName: " + str + " expireTime : " + paramLong2 + " nowTime: " + l);
      }
    } while (!paramBoolean);
    ((ExtendFriendManager)paramQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).a(paramQQAppInterface);
    return;
    QLog.e("ExpandFriendChatUtil", 2, "ExtendFriendLimitChat setShowLimitChatOnPlus on null sp");
  }
  
  public static void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("ExpandFriendChatUtil", 2, "reportInSubThread UIN EMPTY");
      return;
    }
    ThreadManager.getSubThreadHandler().post(new ExpandFriendChatUtil.1(paramString));
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    boolean bool1 = false;
    paramQQAppInterface = a(paramQQAppInterface);
    if (paramQQAppInterface == null) {}
    boolean bool2;
    do
    {
      return bool1;
      bool2 = paramQQAppInterface.getBoolean("sp_limit_chat_on_plus_panel_be_show", false);
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    QLog.d("ExpandFriendChatUtil", 2, "needShowLimitChatOnPlus: " + bool2);
    return bool2;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    try
    {
      boolean bool = ((Boolean)ExpandFriendData.getAttribute(paramQQAppInterface, paramString, 1)).booleanValue();
      return bool;
    }
    catch (Exception paramQQAppInterface)
    {
      QLog.w("ExpandFriendChatUtil", 1, "getHasEnterAIO error" + paramQQAppInterface);
    }
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    return paramQQAppInterface.getConversationFacade().a(paramString, paramInt) > 0;
  }
  
  public static boolean a(MessageRecord paramMessageRecord)
  {
    return ((paramMessageRecord instanceof MessageForUniteGrayTip)) || ((paramMessageRecord instanceof MessageForLimitChatTopic)) || ((paramMessageRecord instanceof MessageForArkApp));
  }
  
  public static boolean a(List<ChatMessage> paramList)
  {
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        if (b((ChatMessage)paramList.next())) {
          return true;
        }
      }
    }
    return false;
  }
  
  public static long b(List<ChatMessage> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      return ((ChatMessage)paramList.get(0)).time - LimitChatUtil.a.longValue();
    }
    return System.currentTimeMillis() / 1000L - LimitChatUtil.a.longValue();
  }
  
  public static SharedPreferences b(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null)
    {
      QLog.e("ExpandFriendChatUtil", 2, "get sp by app is null");
      return null;
    }
    paramQQAppInterface = paramQQAppInterface.getCurrentUin();
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramQQAppInterface)))
    {
      QLog.e("ExpandFriendChatUtil", 2, "get matchSp is null");
      return null;
    }
    return BaseApplicationImpl.getContext().getSharedPreferences("sp_for_extendfriend_match_chat" + paramQQAppInterface, 0);
  }
  
  public static void b(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = b(paramQQAppInterface);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.edit().clear().commit();
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString)
  {
    ThreadManager.getSubThreadHandler().post(new ExpandFriendChatUtil.4(paramQQAppInterface, paramString));
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString, int paramInt, Object paramObject)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString)))
    {
      QLog.w("ExpandFriendChatUtil", 1, "insertIcebreakerTopic but matchUin or app is empty");
      return;
    }
    paramString = a(paramQQAppInterface, paramString, a(paramQQAppInterface.getMessageFacade().a(paramString, paramInt)), paramInt, paramObject);
    paramQQAppInterface.getMessageFacade().a(paramString, paramQQAppInterface.getCurrentAccountUin());
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    paramQQAppInterface = a(paramQQAppInterface);
    if (paramQQAppInterface == null) {
      bool2 = bool1;
    }
    long l1;
    long l2;
    long l3;
    do
    {
      return bool2;
      if (LocaleManager.c())
      {
        QLog.i("ExpandFriendChatUtil", 2, "getLimitChatOnPlusExpireTime: by change local langauage");
        return true;
      }
      QLog.d("ExpandFriendChatUtil", 2, "getLimitChatOnPlusExpireTime: not ! by change local langauage");
      l1 = paramQQAppInterface.getLong("sp_limit_chat_on_plus_panel_expire_time", 10L);
      l2 = paramQQAppInterface.getLong("sp_limit_chat_on_plus_panel_update_time", 0L);
      l3 = NetConnInfoCenter.getServerTime();
      long l4 = l3 - l2;
      bool1 = bool2;
      if (l4 < l1)
      {
        bool1 = bool2;
        if (l4 > 0L) {
          bool1 = false;
        }
      }
      bool2 = bool1;
    } while (!QLog.isColorLevel());
    QLog.d("ExpandFriendChatUtil", 2, "getLimitChatOnPlusExpireTime: " + l1 + " update :" + l2 + " now：" + l3 + " needUpdate：" + bool1);
    return bool1;
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, String paramString)
  {
    try
    {
      boolean bool = ((Boolean)ExpandFriendData.getAttribute(paramQQAppInterface, paramString, 2)).booleanValue();
      return bool;
    }
    catch (Exception paramQQAppInterface)
    {
      QLog.w("ExpandFriendChatUtil", 1, "getHasEnterAIO error" + paramQQAppInterface);
    }
    return false;
  }
  
  public static boolean b(MessageRecord paramMessageRecord)
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
  
  public static boolean c(QQAppInterface paramQQAppInterface)
  {
    boolean bool2 = false;
    limitChatOnPlusConfBean locallimitChatOnPlusConfBean = LimitChatOnPlusConfProcessor.a();
    boolean bool1 = bool2;
    if (locallimitChatOnPlusConfBean != null)
    {
      bool1 = bool2;
      if (locallimitChatOnPlusConfBean.a())
      {
        bool1 = bool2;
        if (a(paramQQAppInterface))
        {
          bool1 = bool2;
          if (!locallimitChatOnPlusConfBean.b())
          {
            bool1 = bool2;
            if (!StudyModeManager.a()) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public static boolean d(QQAppInterface paramQQAppInterface)
  {
    boolean bool2 = false;
    limitChatOnPlusConfBean locallimitChatOnPlusConfBean = LimitChatOnPlusConfProcessor.a();
    boolean bool1 = bool2;
    if (locallimitChatOnPlusConfBean != null)
    {
      bool1 = bool2;
      if (locallimitChatOnPlusConfBean.a())
      {
        bool1 = bool2;
        if (a(paramQQAppInterface))
        {
          bool1 = bool2;
          if (locallimitChatOnPlusConfBean.b())
          {
            bool1 = bool2;
            if (!StudyModeManager.a()) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.limitchat.ExpandFriendChatUtil
 * JD-Core Version:    0.7.0.1
 */