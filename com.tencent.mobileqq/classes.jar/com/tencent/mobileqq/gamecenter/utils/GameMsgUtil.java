package com.tencent.mobileqq.gamecenter.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetail;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.gamecenter.wadl.api.IQQGameReportService;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.msgbox.api.ITempMsgBoxManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ConversationInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService;
import com.tencent.mobileqq.gamecenter.api.ITempApi;
import com.tencent.mobileqq.gamecenter.data.GameDelSessionDataHelper;
import com.tencent.mobileqq.gamecenter.message.TinyInfo;
import com.tencent.mobileqq.gamecenter.msgInfo.GameBasicInfo;
import com.tencent.mobileqq.gamecenter.msgInfo.GameCenterSessionInfo;
import com.tencent.mobileqq.gamecenter.msgInfo.GameDetailInfo;
import com.tencent.mobileqq.gamecenter.msgInfo.GameSwitchConfig;
import com.tencent.mobileqq.gamecenter.msgInfo.GameUserInfo;
import com.tencent.mobileqq.gamecenter.protocols.GameCenterUnissoHandler;
import com.tencent.mobileqq.gamecenter.util.RoleIdUtil;
import com.tencent.mobileqq.msg.api.IConversationFacade;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;

public class GameMsgUtil
{
  public static String a;
  public static boolean a;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(GameCenterUnissoHandler.b);
    localStringBuilder.append("GameMsgUtil");
    jdField_a_of_type_JavaLangString = localStringBuilder.toString();
    jdField_a_of_type_Boolean = false;
  }
  
  public static long a(AppInterface paramAppInterface)
  {
    SharedPreferences localSharedPreferences = paramAppInterface.getApplication().getSharedPreferences("game_center_sp", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sp_top_last_time");
    localStringBuilder.append(paramAppInterface.getCurrentAccountUin());
    return localSharedPreferences.getLong(localStringBuilder.toString(), 0L);
  }
  
  public static long a(String paramString)
  {
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("game_center_sp", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sp_last_game_session_clicked");
    localStringBuilder.append(paramString);
    return localSharedPreferences.getLong(localStringBuilder.toString(), 0L);
  }
  
  public static long a(String paramString1, String paramString2)
  {
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("game_center_sp", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString2);
    localStringBuilder.append(paramString1);
    return localSharedPreferences.getLong(localStringBuilder.toString(), 0L);
  }
  
  public static Bitmap a(Message paramMessage, AppInterface paramAppInterface)
  {
    StringBuilder localStringBuilder1 = null;
    if (paramAppInterface == null) {
      return null;
    }
    paramMessage = RoleIdUtil.b(paramMessage);
    if (QLog.isColorLevel())
    {
      localObject = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("[getGameRoleBitmap],roleId:");
      localStringBuilder2.append(paramMessage);
      localStringBuilder2.append(" thread column = ");
      boolean bool;
      if (Looper.getMainLooper() == Looper.myLooper()) {
        bool = true;
      } else {
        bool = false;
      }
      localStringBuilder2.append(bool);
      QLog.d((String)localObject, 2, localStringBuilder2.toString());
    }
    long l1 = SystemClock.elapsedRealtime();
    Object localObject = (IGameMsgManagerService)paramAppInterface.getRuntimeService(IGameMsgManagerService.class, "");
    if (localObject == null) {
      return null;
    }
    localObject = ((IGameMsgManagerService)localObject).findGameUserInfo(paramMessage);
    if (localObject == null)
    {
      paramAppInterface = jdField_a_of_type_JavaLangString;
      localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("getGameRoleBitmap usrInfo is null, roleId:");
      localStringBuilder1.append(paramMessage);
      QLog.w(paramAppInterface, 1, localStringBuilder1.toString());
      return null;
    }
    if (TextUtils.isEmpty(((GameUserInfo)localObject).mFaceUrl))
    {
      paramAppInterface = jdField_a_of_type_JavaLangString;
      localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append(" getGameRoleBitmap faceurl is null, roleId:");
      localStringBuilder1.append(paramMessage);
      QLog.w(paramAppInterface, 1, localStringBuilder1.toString());
      return null;
    }
    paramMessage = AbsDownloader.getFile(((GameUserInfo)localObject).mFaceUrl);
    if ((paramMessage != null) && (paramMessage.exists()))
    {
      paramAppInterface = BitmapFactory.decodeFile(paramMessage.getAbsolutePath());
      paramMessage = paramAppInterface;
      if (QLog.isColorLevel())
      {
        paramMessage = jdField_a_of_type_JavaLangString;
        localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("getGameRoleBitmap is called!.decode from file");
        localStringBuilder1.append(paramAppInterface);
        QLog.d(paramMessage, 2, localStringBuilder1.toString());
        paramMessage = paramAppInterface;
      }
    }
    else
    {
      paramMessage = paramAppInterface.getApplication().getResources().getDrawable(2130840405);
      paramAppInterface = URLDrawable.URLDrawableOptions.obtain();
      paramAppInterface.mFailedDrawable = paramMessage;
      paramAppInterface.mLoadingDrawable = paramMessage;
      try
      {
        paramMessage = URLDrawable.getDrawable(new URL(((GameUserInfo)localObject).mFaceUrl), paramAppInterface);
        try
        {
          paramMessage.setTag(URLDrawableDecodeHandler.a(100, 100, 6));
          paramMessage.setDecodeHandler(URLDrawableDecodeHandler.a);
          paramAppInterface = paramMessage;
        }
        catch (MalformedURLException paramAppInterface) {}
        paramAppInterface.printStackTrace();
      }
      catch (MalformedURLException paramAppInterface)
      {
        paramMessage = null;
      }
      paramAppInterface = paramMessage;
      paramMessage = localStringBuilder1;
      if (paramAppInterface != null)
      {
        paramAppInterface = paramAppInterface.getCurrDrawable();
        if (QLog.isColorLevel())
        {
          paramMessage = jdField_a_of_type_JavaLangString;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("getGameRoleBitmap is called!.");
          ((StringBuilder)localObject).append(paramAppInterface.getClass().getSimpleName());
          QLog.d(paramMessage, 2, ((StringBuilder)localObject).toString());
        }
        paramMessage = localStringBuilder1;
        if ((paramAppInterface instanceof BitmapDrawable))
        {
          paramAppInterface = ((BitmapDrawable)paramAppInterface).getBitmap();
          paramMessage = paramAppInterface;
          if (QLog.isColorLevel())
          {
            paramMessage = jdField_a_of_type_JavaLangString;
            localStringBuilder1 = new StringBuilder();
            localStringBuilder1.append("getGameRoleBitmap is called!. bitmap = ");
            localStringBuilder1.append(paramAppInterface);
            QLog.d(paramMessage, 2, localStringBuilder1.toString());
            paramMessage = paramAppInterface;
          }
        }
      }
    }
    long l2 = SystemClock.elapsedRealtime();
    if (QLog.isColorLevel())
    {
      paramAppInterface = jdField_a_of_type_JavaLangString;
      localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("getGameRoleBitmap is called!. total cost = ");
      localStringBuilder1.append(l2 - l1);
      QLog.d(paramAppInterface, 2, localStringBuilder1.toString());
    }
    return paramMessage;
  }
  
  public static Drawable a(AppInterface paramAppInterface, String paramString)
  {
    try
    {
      Drawable localDrawable = BaseApplication.getContext().getResources().getDrawable(2130840321);
      paramString = a(paramAppInterface, paramString);
      if (paramString != null)
      {
        paramString = RoleIdUtil.b(paramString);
        paramAppInterface = a(BaseApplication.getContext(), paramAppInterface, paramString);
        if (paramAppInterface != null) {
          return paramAppInterface;
        }
      }
      return localDrawable;
    }
    catch (Throwable paramAppInterface)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, paramAppInterface.getMessage());
    }
    return BaseApplication.getContext().getResources().getDrawable(2130840321);
  }
  
  public static AppInterface a()
  {
    return (AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null);
  }
  
  public static URLDrawable a(Context paramContext, AppInterface paramAppInterface, String paramString)
  {
    Object localObject = null;
    if (paramAppInterface == null) {
      return null;
    }
    paramAppInterface = ((IGameMsgManagerService)paramAppInterface.getRuntimeService(IGameMsgManagerService.class, "")).findGameUserInfo(paramString);
    if (paramAppInterface == null)
    {
      paramContext = jdField_a_of_type_JavaLangString;
      paramAppInterface = new StringBuilder();
      paramAppInterface.append("usrInfo is null, roleId:");
      paramAppInterface.append(paramString);
      QLog.w(paramContext, 1, paramAppInterface.toString());
      return null;
    }
    if (TextUtils.isEmpty(paramAppInterface.mFaceUrl))
    {
      paramContext = jdField_a_of_type_JavaLangString;
      paramAppInterface = new StringBuilder();
      paramAppInterface.append("faceurl is null, roleId:");
      paramAppInterface.append(paramString);
      QLog.w(paramContext, 1, paramAppInterface.toString());
      return null;
    }
    Drawable localDrawable = paramContext.getResources().getDrawable(2130840321);
    paramString = URLDrawable.URLDrawableOptions.obtain();
    paramString.mFailedDrawable = localDrawable;
    paramString.mLoadingDrawable = localDrawable;
    paramString.mRequestWidth = CommUtils.a(60.0F, paramContext.getResources());
    paramString.mRequestHeight = CommUtils.a(60.0F, paramContext.getResources());
    paramContext = localObject;
    try
    {
      paramAppInterface = URLDrawable.getDrawable(new URL(paramAppInterface.mFaceUrl), paramString);
      paramContext = paramAppInterface;
      paramAppInterface.setTag(URLDrawableDecodeHandler.a(100, 100, 6));
      paramContext = paramAppInterface;
      paramAppInterface.setDecodeHandler(URLDrawableDecodeHandler.a);
      return paramAppInterface;
    }
    catch (MalformedURLException paramAppInterface)
    {
      paramAppInterface.printStackTrace();
    }
    return paramContext;
  }
  
  public static MessageRecord a(AppInterface paramAppInterface, String paramString)
  {
    if (paramAppInterface != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return null;
      }
      paramAppInterface = (IMessageFacade)paramAppInterface.getRuntimeService(IMessageFacade.class, "");
      if (paramAppInterface == null) {
        return null;
      }
      paramAppInterface = paramAppInterface.getAllMessages(paramString, 10007, new int[] { -1000 }, 10);
      if (paramAppInterface != null)
      {
        if (paramAppInterface.size() == 0) {
          return null;
        }
        return (MessageRecord)paramAppInterface.get(paramAppInterface.size() - 1);
      }
    }
    return null;
  }
  
  public static CharSequence a(AppInterface paramAppInterface, RecentBaseData paramRecentBaseData, CharSequence paramCharSequence)
  {
    if (paramAppInterface != null) {
      if (paramRecentBaseData == null) {
        return paramCharSequence;
      }
    }
    try
    {
      IMessageFacade localIMessageFacade = (IMessageFacade)paramAppInterface.getRuntimeService(IMessageFacade.class, "");
      if (localIMessageFacade == null) {
        return null;
      }
      paramAppInterface = a(paramAppInterface, localIMessageFacade.getLastMessage(paramRecentBaseData.getRecentUserUin(), paramRecentBaseData.getRecentUserType()), paramCharSequence);
      return paramAppInterface;
    }
    catch (Throwable paramAppInterface) {}
    return paramCharSequence;
    return paramCharSequence;
  }
  
  public static String a(int paramInt)
  {
    if (paramInt > 99) {
      return "99+";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append("");
    return localStringBuilder.toString();
  }
  
  public static String a(long paramLong)
  {
    Object localObject = Calendar.getInstance();
    ((Calendar)localObject).set(((Calendar)localObject).get(1), ((Calendar)localObject).get(2), ((Calendar)localObject).get(5) - 1, 0, 0, 0);
    long l = ((Calendar)localObject).getTime().getTime();
    if (a(paramLong))
    {
      localObject = new Date(paramLong);
      return new SimpleDateFormat("HH:mm").format((Date)localObject);
    }
    if (paramLong > l) {
      return "昨天";
    }
    if (paramLong > l - 518400000L) {
      return "两天前";
    }
    if (paramLong > l - 2505600000L) {
      return "一周前";
    }
    return "一月前";
  }
  
  public static String a(AppInterface paramAppInterface, MessageRecord paramMessageRecord, CharSequence paramCharSequence)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(BaseApplication.getContext().getString(2131692793));
    ((StringBuilder)localObject).append(paramCharSequence);
    paramCharSequence = ((StringBuilder)localObject).toString();
    if (paramAppInterface == null) {
      return paramCharSequence;
    }
    paramMessageRecord = a(paramAppInterface, paramMessageRecord.frienduin);
    if (paramMessageRecord == null) {
      return paramCharSequence;
    }
    paramMessageRecord = RoleIdUtil.a(paramMessageRecord);
    if (TextUtils.isEmpty(paramMessageRecord)) {
      return paramCharSequence;
    }
    localObject = (IGameMsgManagerService)paramAppInterface.getRuntimeService(IGameMsgManagerService.class, "");
    if (localObject == null) {
      return paramCharSequence;
    }
    paramMessageRecord = ((IGameMsgManagerService)localObject).getSingleGameDetail(paramMessageRecord);
    if (paramMessageRecord == null) {
      return paramCharSequence;
    }
    localObject = ((IGameMsgManagerService)localObject).findGameSwitchConfig(paramMessageRecord.c);
    if (localObject != null)
    {
      if (((GameSwitchConfig)localObject).mSyncSwitch == 1) {
        return paramCharSequence;
      }
      paramCharSequence = new StringBuilder();
      paramCharSequence.append(paramAppInterface.getApplication().getString(2131692794));
      paramCharSequence.append(paramMessageRecord.i);
      return paramCharSequence.toString();
    }
    return paramCharSequence;
  }
  
  public static String a(MessageRecord paramMessageRecord, AppInterface paramAppInterface)
  {
    if ((paramMessageRecord != null) && (paramAppInterface != null))
    {
      Object localObject = RoleIdUtil.b(paramMessageRecord);
      IGameMsgManagerService localIGameMsgManagerService = (IGameMsgManagerService)paramAppInterface.getRuntimeService(IGameMsgManagerService.class, "");
      if (localIGameMsgManagerService == null) {
        return null;
      }
      localObject = localIGameMsgManagerService.findGameUserInfo((String)localObject);
      if ((localObject != null) && (!TextUtils.isEmpty(((GameUserInfo)localObject).mNickInGame))) {
        return ((GameUserInfo)localObject).mNickInGame;
      }
      paramMessageRecord = new TinyInfo(paramMessageRecord.getExtInfoFromExtStr("ext_key_game_msg_info"));
      if (!TextUtils.isEmpty(paramMessageRecord.nickName)) {
        return paramMessageRecord.nickName;
      }
    }
    return paramAppInterface.getApplication().getResources().getString(2131692790);
  }
  
  public static String a(String paramString, AppInterface paramAppInterface)
  {
    if (paramAppInterface == null) {
      return "";
    }
    Object localObject = ((IConversationFacade)paramAppInterface.getRuntimeService(IConversationFacade.class, "")).getConversationInfo(paramString, 10007);
    if ((localObject != null) && (((ConversationInfo)localObject).tinyInfo != null))
    {
      IGameMsgManagerService localIGameMsgManagerService = (IGameMsgManagerService)paramAppInterface.getRuntimeService(IGameMsgManagerService.class, "");
      if (localIGameMsgManagerService == null) {
        return null;
      }
      localObject = localIGameMsgManagerService.findGameUserInfo(((ConversationInfo)localObject).tinyInfo.fromRoleId);
      if ((localObject != null) && (!TextUtils.isEmpty(((GameUserInfo)localObject).mNickInGame))) {
        return ((GameUserInfo)localObject).mNickInGame;
      }
      localObject = (IMessageFacade)paramAppInterface.getRuntimeService(IMessageFacade.class, "");
      if (localObject == null) {
        return "";
      }
      paramString = ((IMessageFacade)localObject).getLastMessage(paramString, 10007);
      if (paramString != null)
      {
        paramString = new TinyInfo(paramString.getExtInfoFromExtStr("ext_key_game_msg_info"));
        if (!TextUtils.isEmpty(paramString.nickName)) {
          return paramString.nickName;
        }
      }
    }
    return paramAppInterface.getApplication().getResources().getString(2131692790);
  }
  
  public static void a(int paramInt1, int paramInt2)
  {
    String str = b(paramInt1);
    ReportController.b(null, "dc00898", "", "", str, str, paramInt2, 0, "", "", "", "");
  }
  
  public static void a(Context paramContext, GameCenterSessionInfo paramGameCenterSessionInfo, String paramString)
  {
    if (paramContext == null) {
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[openGameMsgSessionPage],from:");
      localStringBuilder.append(paramString);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    Object localObject = a();
    if (localObject == null) {
      return;
    }
    if (a(paramContext, paramString)) {
      return;
    }
    paramString = (IGameMsgManagerService)((AppInterface)localObject).getRuntimeService(IGameMsgManagerService.class, "");
    if (paramString == null) {
      return;
    }
    localObject = paramString.getGameMsgListUrl();
    paramString = (String)localObject;
    if (paramGameCenterSessionInfo != null)
    {
      paramString = (String)localObject;
      if (paramGameCenterSessionInfo.a() == 0)
      {
        paramString = new StringBuilder();
        paramString.append((String)localObject);
        paramString.append("&&gameId=");
        paramString.append(paramGameCenterSessionInfo.e());
        paramString.append("&gameName=");
        paramString.append(paramGameCenterSessionInfo.f());
        paramString.append("&sessionId=");
        paramString.append(paramGameCenterSessionInfo.d());
        paramString.append("&requestCount=");
        paramString.append(paramGameCenterSessionInfo.b());
        paramString = paramString.toString();
      }
    }
    paramContext = new ActivityURIRequest(paramContext, "/base/activity/GameCenterActivity");
    paramContext.extra().putString("url", paramString);
    paramContext.extra().putString("big_brother_source_key", "biz_src_zf_games");
    paramContext.extra().putInt("game_msg_open_aio_from", 2);
    paramContext.extra().putLong("startOpenPageTime", System.currentTimeMillis());
    paramContext.setFlags(268435456);
    QRoute.startUri(paramContext, null);
  }
  
  public static void a(Context paramContext, GameCenterSessionInfo paramGameCenterSessionInfo, String paramString1, String paramString2)
  {
    if (paramContext == null) {
      return;
    }
    if (QLog.isColorLevel())
    {
      String str = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[openGameMsgSessionPageFromToolProcess],from:");
      localStringBuilder.append(paramString1);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if (a(paramContext, paramString1)) {
      return;
    }
    paramString1 = paramString2;
    if (paramGameCenterSessionInfo != null)
    {
      paramString1 = paramString2;
      if (paramGameCenterSessionInfo.a() == 0)
      {
        paramString1 = new StringBuilder();
        paramString1.append(paramString2);
        paramString1.append("&&gameId=");
        paramString1.append(paramGameCenterSessionInfo.e());
        paramString1.append("&gameName=");
        paramString1.append(paramGameCenterSessionInfo.f());
        paramString1.append("&sessionId=");
        paramString1.append(paramGameCenterSessionInfo.d());
        paramString1.append("&requestCount=");
        paramString1.append(paramGameCenterSessionInfo.b());
        paramString1 = paramString1.toString();
      }
    }
    paramContext = new ActivityURIRequest(paramContext, "/base/activity/GameCenterActivity");
    paramContext.extra().putString("url", paramString1);
    paramContext.extra().putString("big_brother_source_key", "biz_src_zf_games");
    paramContext.extra().putInt("game_msg_open_aio_from", 2);
    paramContext.extra().putLong("startOpenPageTime", System.currentTimeMillis());
    paramContext.setFlags(268435456);
    QRoute.startUri(paramContext, null);
  }
  
  public static void a(Context paramContext, GameDetailInfo paramGameDetailInfo)
  {
    QLog.i(jdField_a_of_type_JavaLangString, 1, "[startGame]");
    if (paramGameDetailInfo == null)
    {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "fail to start game, detailInfo is null.");
      return;
    }
    Object localObject1 = jdField_a_of_type_JavaLangString;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("appId:");
    ((StringBuilder)localObject2).append(paramGameDetailInfo.c);
    QLog.i((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    localObject2 = paramGameDetailInfo.l;
    localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = GameBasicInfo.getDefaultGameLaunchUrl(paramGameDetailInfo.c);
    }
    paramContext = new ActivityURIRequest(paramContext, "/base/browser");
    paramContext.extra().putString("url", (String)localObject1);
    QRoute.startUri(paramContext, null);
  }
  
  public static void a(Context paramContext, String paramString)
  {
    if (paramContext == null) {
      return;
    }
    if (QLog.isColorLevel())
    {
      String str = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[openGameMsgSettingPage],from:");
      localStringBuilder.append(paramString);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    paramString = a();
    if (paramString == null) {
      return;
    }
    paramString = (IGameMsgManagerService)paramString.getRuntimeService(IGameMsgManagerService.class, "");
    if (paramString == null) {
      return;
    }
    paramString = paramString.getGameMsgSettingUrl();
    paramContext = new ActivityURIRequest(paramContext, "/base/activity/GameCenterActivity");
    paramContext.extra().putString("url", paramString);
    paramContext.extra().putString("big_brother_source_key", "biz_src_zf_games");
    paramContext.extra().putLong("startOpenPageTime", System.currentTimeMillis());
    paramContext.setFlags(268435456);
    QRoute.startUri(paramContext, null);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    a(paramContext, paramString1, paramString2, paramString3, 0);
  }
  
  private static void a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    String str = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[enterGameMsgChatPie], convertUin:");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(",fRoleId:");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(",mRoleId:");
    localStringBuilder.append(paramString3);
    localStringBuilder.append(", clickFrom = ");
    localStringBuilder.append(paramInt);
    QLog.i(str, 1, localStringBuilder.toString());
    paramContext = new ActivityURIRequest(paramContext, "/base/activity/ChatActivity");
    paramContext.extra().putString("uin", paramString1);
    paramContext.extra().putString("game_msg_friend_role_id", paramString2);
    paramContext.extra().putString("game_msg_my_role_id", paramString3);
    paramContext.extra().putInt("uintype", 10007);
    paramContext.extra().putInt("game_msg_enter_from", paramInt);
    paramContext.extra().putInt("game_msg_open_aio_from", 1);
    paramContext.setFlags(268435456);
    QRoute.startUri(paramContext, null);
  }
  
  public static void a(AppInterface paramAppInterface)
  {
    ThreadManager.getSubThreadHandler().post(new GameMsgUtil.2(paramAppInterface));
  }
  
  public static void a(AppInterface paramAppInterface, int paramInt, String paramString)
  {
    if (paramAppInterface != null)
    {
      if (paramInt != 10007) {
        return;
      }
      ThreadManager.getSubThreadHandler().post(new GameMsgUtil.4(paramAppInterface, paramString));
    }
  }
  
  public static void a(AppInterface paramAppInterface, Context paramContext, String paramString)
  {
    if (paramAppInterface != null) {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "enterGameMsgChatPie is called.");
        }
        ConversationInfo localConversationInfo = ((IConversationFacade)paramAppInterface.getRuntimeService(IConversationFacade.class, "")).getTinyConvInfo(paramString, 10007);
        if (localConversationInfo != null)
        {
          String str1 = localConversationInfo.tinyInfo.fromRoleId;
          String str2 = localConversationInfo.tinyInfo.toRoleId;
          Object localObject = (IGameMsgManagerService)paramAppInterface.getRuntimeService(IGameMsgManagerService.class, "");
          if (localObject == null) {
            return;
          }
          GameCenterSessionInfo localGameCenterSessionInfo = ((IGameMsgManagerService)localObject).getSessionInfoByUin(paramString);
          localObject = localGameCenterSessionInfo;
          if (localGameCenterSessionInfo == null) {
            localObject = new GameCenterSessionInfo();
          }
          ((GameCenterSessionInfo)localObject).e(paramString);
          ((GameCenterSessionInfo)localObject).d(str1);
          ((GameCenterSessionInfo)localObject).b(str2);
          ((GameCenterSessionInfo)localObject).c(localConversationInfo.tinyInfo.fromTinyId);
          ((GameCenterSessionInfo)localObject).d(localConversationInfo.tinyInfo.toTinyId);
          a(paramContext, (GameCenterSessionInfo)localObject, "src2");
          a(paramAppInterface, paramString, 10004, 1);
          return;
        }
      }
      catch (Exception paramAppInterface)
      {
        paramAppInterface.printStackTrace();
      }
    }
  }
  
  public static void a(AppInterface paramAppInterface, MessageRecord paramMessageRecord, String paramString)
  {
    ThreadManager.getSubThreadHandler().post(new GameMsgUtil.3(paramAppInterface, paramMessageRecord, paramString));
  }
  
  public static void a(AppInterface paramAppInterface, Object paramObject)
  {
    if (paramAppInterface == null) {
      return;
    }
    paramObject = (ITempMsgBoxManager)paramAppInterface.getRuntimeService(ITempMsgBoxManager.class, "");
    if (paramObject == null) {
      return;
    }
    paramObject = paramObject.getMsgBoxRecentUsers();
    if ((paramObject != null) && (!paramObject.isEmpty()))
    {
      paramObject = (RecentUser)paramObject.get(0);
      if (paramObject != null)
      {
        if (paramObject.getType() != 10007) {
          return;
        }
        ThreadManager.getSubThreadHandler().post(new GameMsgUtil.1(paramAppInterface, paramObject));
      }
      return;
    }
    QLog.e(jdField_a_of_type_JavaLangString, 1, "reportClickMsgBox: msgBoxRecentUsers.isEmpty()");
  }
  
  public static void a(AppInterface paramAppInterface, String paramString, int paramInt1, int paramInt2)
  {
    if (paramAppInterface == null) {
      return;
    }
    String str = b(paramInt1);
    try
    {
      paramAppInterface = (IMessageFacade)paramAppInterface.getRuntimeService(IMessageFacade.class, "");
      if (paramAppInterface == null) {
        return;
      }
      paramAppInterface = paramAppInterface.getLastMessage(paramString, 10007);
      boolean bool = QLog.isColorLevel();
      if (bool)
      {
        paramString = jdField_a_of_type_JavaLangString;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("report called with: key = [");
        localStringBuilder.append(str);
        localStringBuilder.append("], from = [");
        localStringBuilder.append(paramInt1);
        localStringBuilder.append("], fromType = [");
        localStringBuilder.append(paramInt2);
        localStringBuilder.append("]");
        QLog.d(paramString, 2, localStringBuilder.toString());
      }
      if (paramAppInterface == null)
      {
        paramAppInterface = jdField_a_of_type_JavaLangString;
        paramString = new StringBuilder();
        paramString.append("report called with: conversationInfo null. key = [");
        paramString.append(str);
        paramString.append("], from = [");
        paramString.append(paramInt1);
        paramString.append("], fromType = [");
        paramString.append(paramInt2);
        paramString.append("]");
        QLog.d(paramAppInterface, 1, paramString.toString());
        return;
      }
      paramString = paramAppInterface.getExtInfoFromExtStr("ext_key_game_msg_info");
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      long l = new TinyInfo(paramString, paramAppInterface.isSend()).gameAppId;
      try
      {
        ReportController.b(null, "dc00898", "", "", str, str, paramInt2, 0, String.valueOf(l), "", "", "");
        return;
      }
      catch (Exception paramAppInterface) {}
      paramString = jdField_a_of_type_JavaLangString;
    }
    catch (Exception paramAppInterface) {}
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("report called with:  key = [");
    localStringBuilder.append(str);
    localStringBuilder.append("], fromType = [");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("], fromType = [");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("]");
    QLog.e(paramString, 1, localStringBuilder.toString(), paramAppInterface);
  }
  
  public static void a(String paramString)
  {
    GameDelSessionDataHelper.a(paramString);
  }
  
  public static void a(String paramString, long paramLong)
  {
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("game_center_sp", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sp_top_clean_time");
    localStringBuilder.append(paramString);
    paramString = localStringBuilder.toString();
    localSharedPreferences.edit().putLong(paramString, paramLong).commit();
  }
  
  public static void a(String paramString1, String paramString2, long paramLong)
  {
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("game_center_sp", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString2);
    localStringBuilder.append(paramString1);
    paramString1 = localStringBuilder.toString();
    localSharedPreferences.edit().putLong(paramString1, paramLong).commit();
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10)
  {
    a(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8, paramString9, paramString10, "", "");
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11)
  {
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      JSONArray localJSONArray = new JSONArray();
      JSONObject localJSONObject2 = new JSONObject();
      JSONObject localJSONObject3 = new JSONObject();
      localJSONObject3.put("sq_ver", "8.7.0");
      localJSONObject3.put("device_type", Build.BRAND);
      localJSONObject3.put("domain", "1");
      localJSONObject3.put("gameappid", paramString1);
      localJSONObject3.put("ext12", paramString3);
      localJSONObject3.put("ext11", paramString2);
      localJSONObject3.put("ext1", paramString5);
      localJSONObject3.put("oper_moudle", paramString4);
      localJSONObject3.put("oper_id", paramString6);
      localJSONObject3.put("ext2", paramString8);
      localJSONObject3.put("ext4", paramString7);
      localJSONObject3.put("ext6", paramString9);
      localJSONObject3.put("ext8", paramString10);
      localJSONObject3.put("tianji_report_str", paramString11);
      localJSONObject2.put("data", localJSONObject3);
      localJSONObject2.put("dc_id", "dc00087");
      localJSONArray.put(localJSONObject2);
      localJSONObject1.put("report_list", localJSONArray);
      ((IQQGameReportService)QRoute.api(IQQGameReportService.class)).report(localJSONObject1, 0);
      return;
    }
    catch (Exception paramString1)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, paramString1.getMessage());
    }
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12)
  {
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      JSONArray localJSONArray = new JSONArray();
      JSONObject localJSONObject2 = new JSONObject();
      JSONObject localJSONObject3 = new JSONObject();
      localJSONObject3.put("sq_ver", "8.7.0");
      localJSONObject3.put("device_type", Build.BRAND);
      localJSONObject3.put("domain", "1");
      localJSONObject3.put("gameappid", paramString1);
      localJSONObject3.put("ext12", paramString3);
      localJSONObject3.put("ext11", paramString2);
      localJSONObject3.put("ext1", paramString5);
      localJSONObject3.put("oper_moudle", paramString4);
      localJSONObject3.put("oper_id", paramString6);
      localJSONObject3.put("ext2", paramString7);
      localJSONObject3.put("ext3", paramString8);
      localJSONObject3.put("ext4", paramString9);
      localJSONObject3.put("ext6", paramString10);
      localJSONObject3.put("ext7", paramString11);
      localJSONObject3.put("ext8", paramString12);
      localJSONObject2.put("data", localJSONObject3);
      localJSONObject2.put("dc_id", "dc00087");
      localJSONArray.put(localJSONObject2);
      localJSONObject1.put("report_list", localJSONArray);
      ((IQQGameReportService)QRoute.api(IQQGameReportService.class)).report(localJSONObject1, 0);
      return;
    }
    catch (Exception paramString1)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, paramString1.getMessage());
    }
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13)
  {
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      JSONArray localJSONArray = new JSONArray();
      JSONObject localJSONObject2 = new JSONObject();
      JSONObject localJSONObject3 = new JSONObject();
      localJSONObject3.put("sq_ver", "8.7.0");
      localJSONObject3.put("device_type", Build.BRAND);
      localJSONObject3.put("domain", "1");
      localJSONObject3.put("gameappid", paramString1);
      localJSONObject3.put("ext12", paramString3);
      localJSONObject3.put("ext11", paramString2);
      localJSONObject3.put("ext1", paramString5);
      localJSONObject3.put("oper_moudle", paramString4);
      localJSONObject3.put("oper_id", paramString6);
      localJSONObject3.put("ext2", paramString7);
      localJSONObject3.put("ext3", paramString8);
      localJSONObject3.put("ext4", paramString9);
      localJSONObject3.put("ext6", paramString10);
      localJSONObject3.put("ext7", paramString11);
      localJSONObject3.put("ext8", paramString12);
      localJSONObject3.put("tianji_report_str", paramString13);
      localJSONObject2.put("data", localJSONObject3);
      localJSONObject2.put("dc_id", "dc00087");
      localJSONArray.put(localJSONObject2);
      localJSONObject1.put("report_list", localJSONArray);
      ((IQQGameReportService)QRoute.api(IQQGameReportService.class)).report(localJSONObject1, 0);
      return;
    }
    catch (Exception paramString1)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, paramString1.getMessage());
    }
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14)
  {
    try
    {
      paramString11 = new JSONObject();
      JSONArray localJSONArray = new JSONArray();
      JSONObject localJSONObject1 = new JSONObject();
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("sq_ver", "8.7.0");
      localJSONObject2.put("device_type", Build.BRAND);
      localJSONObject2.put("domain", "1");
      localJSONObject2.put("gameappid", paramString1);
      localJSONObject2.put("ext12", paramString3);
      localJSONObject2.put("ext11", paramString2);
      localJSONObject2.put("ext1", paramString5);
      localJSONObject2.put("oper_moudle", paramString4);
      localJSONObject2.put("oper_id", paramString6);
      localJSONObject2.put("logic_id", paramString7);
      localJSONObject2.put("ext2", paramString8);
      localJSONObject2.put("ext3", paramString9);
      localJSONObject2.put("ext4", paramString10);
      localJSONObject2.put("ext6", paramString7);
      localJSONObject2.put("ext10", paramString12);
      localJSONObject2.put("ext11", paramString13);
      localJSONObject2.put("ext24", paramString14);
      localJSONObject1.put("data", localJSONObject2);
      localJSONObject1.put("dc_id", "dc00087");
      localJSONArray.put(localJSONObject1);
      paramString11.put("report_list", localJSONArray);
      ((IQQGameReportService)QRoute.api(IQQGameReportService.class)).report(paramString11, 0);
      return;
    }
    catch (Exception paramString1)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, paramString1.getMessage());
    }
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("game_center_sp", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sp_game_session_shown");
    localStringBuilder.append(paramString);
    paramString = localStringBuilder.toString();
    localSharedPreferences.edit().putBoolean(paramString, paramBoolean).commit();
  }
  
  public static boolean a(long paramLong)
  {
    return a(paramLong, "yyyy-MM-dd");
  }
  
  private static boolean a(long paramLong, String paramString)
  {
    Date localDate = new Date(paramLong);
    paramString = new SimpleDateFormat(paramString);
    return paramString.format(localDate).equals(paramString.format(new Date()));
  }
  
  private static boolean a(Context paramContext, String paramString)
  {
    if (paramContext == null) {
      return false;
    }
    if (!((ITempApi)QRoute.api(ITempApi.class)).getHippySwitch())
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "hippy switch is off, ail to open by hippy");
      return false;
    }
    try
    {
      QLog.i(jdField_a_of_type_JavaLangString, 1, "openGameMsgSessionPageByHippy runs.");
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("https://speed.gamecenter.qq.com/pushgame/v1/home-spa/msg?_wv=18950115&_wwv=393&page=msg&adtag=");
      ((StringBuilder)localObject).append(paramString);
      localObject = ((StringBuilder)localObject).toString();
      ((ITempApi)QRoute.api(ITempApi.class)).openQQGameCenterByHippy(paramContext, (String)localObject, paramString);
      return true;
    }
    catch (Throwable paramContext) {}
    return false;
  }
  
  public static boolean a(AppInterface paramAppInterface)
  {
    boolean bool = false;
    if (paramAppInterface == null) {
      return false;
    }
    IPublicAccountDetail localIPublicAccountDetail = ((IPublicAccountDataManager)paramAppInterface.getRuntimeService(IPublicAccountDataManager.class, "all")).findAccountDetailInfo("2747277822");
    if (localIPublicAccountDetail == null)
    {
      ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).sendDetailInfoRequest(paramAppInterface, paramAppInterface.getApplication(), "2747277822");
      return false;
    }
    if (localIPublicAccountDetail.getFollowType() == 1) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean a(AppInterface paramAppInterface, int paramInt)
  {
    return (paramInt == 10007) && (!((IGameMsgManagerService)paramAppInterface.getRuntimeService(IGameMsgManagerService.class, "")).isGameMsgShowInBoxFormTabConfig());
  }
  
  public static boolean a(AppInterface paramAppInterface, Message paramMessage, int paramInt, MsgSummary paramMsgSummary)
  {
    if ((paramAppInterface != null) && (paramMessage != null))
    {
      if (paramMsgSummary == null) {
        return false;
      }
      if (paramInt == 10007)
      {
        IGameMsgManagerService localIGameMsgManagerService = (IGameMsgManagerService)paramAppInterface.getRuntimeService(IGameMsgManagerService.class, "");
        if (localIGameMsgManagerService == null) {
          return false;
        }
        paramAppInterface = a(paramAppInterface, paramMessage.frienduin);
        if (paramAppInterface == null) {
          return false;
        }
        paramAppInterface = localIGameMsgManagerService.getSingleGameDetail(RoleIdUtil.a(paramAppInterface));
        if (paramAppInterface != null)
        {
          paramMessage = new StringBuilder();
          paramMessage.append("[");
          paramMessage.append(paramAppInterface.i);
          paramMessage.append("]");
          paramMsgSummary.prefixOfContent = paramMessage.toString();
        }
        return true;
      }
    }
    return false;
  }
  
  public static boolean a(AppInterface paramAppInterface, String paramString)
  {
    paramAppInterface = a(paramAppInterface, paramString);
    boolean bool = false;
    if (paramAppInterface == null) {
      return false;
    }
    if (new TinyInfo(paramAppInterface.getExtInfoFromExtStr("ext_key_game_msg_info")).redpointSwitch == 1) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean a(MessageRecord paramMessageRecord)
  {
    boolean bool;
    if ((paramMessageRecord != null) && ((!TextUtils.isEmpty(paramMessageRecord.msg)) || (paramMessageRecord.time != 0L))) {
      bool = true;
    } else {
      bool = false;
    }
    if (QLog.isColorLevel())
    {
      paramMessageRecord = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[checkMesssageIsValid] ret = ");
      localStringBuilder.append(bool);
      QLog.d(paramMessageRecord, 2, localStringBuilder.toString());
    }
    return bool;
  }
  
  public static boolean a(String paramString)
  {
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("game_center_sp", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sp_game_session_shown");
    localStringBuilder.append(paramString);
    return localSharedPreferences.getBoolean(localStringBuilder.toString(), true);
  }
  
  private static String b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 10006: 
      return "0X800AD3D";
    case 10005: 
      return "0X800AD3E";
    case 10004: 
      return "0X800AD3F";
    case 10003: 
      return "0X800AD40";
    case 10002: 
      return "0X800AD41";
    }
    return "0X800AD42";
  }
  
  public static void b(String paramString, long paramLong)
  {
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("game_center_sp", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sp_last_game_session_clicked");
    localStringBuilder.append(paramString);
    paramString = localStringBuilder.toString();
    localSharedPreferences.edit().putLong(paramString, paramLong).commit();
  }
  
  public static void b(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10)
  {
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      JSONArray localJSONArray = new JSONArray();
      JSONObject localJSONObject2 = new JSONObject();
      JSONObject localJSONObject3 = new JSONObject();
      localJSONObject3.put("sq_ver", "8.7.0");
      localJSONObject3.put("device_type", Build.BRAND);
      localJSONObject3.put("domain", "1");
      localJSONObject3.put("gameappid", paramString1);
      localJSONObject3.put("ext12", paramString3);
      localJSONObject3.put("ext11", paramString2);
      localJSONObject3.put("ext1", paramString5);
      localJSONObject3.put("oper_moudle", paramString4);
      localJSONObject3.put("oper_id", paramString6);
      localJSONObject3.put("ext2", paramString8);
      localJSONObject3.put("ext4", paramString7);
      localJSONObject3.put("ext6", paramString9);
      localJSONObject3.put("ext8", paramString10);
      localJSONObject2.put("data", localJSONObject3);
      localJSONObject2.put("dc_id", "dc00087");
      localJSONArray.put(localJSONObject2);
      localJSONObject1.put("report_list", localJSONArray);
      ((IQQGameReportService)QRoute.api(IQQGameReportService.class)).report(localJSONObject1, 0);
      return;
    }
    catch (Exception paramString1)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, paramString1.getMessage());
    }
  }
  
  public static void b(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13)
  {
    a(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8, paramString9, paramString10, paramString11, paramString12, paramString13, "");
  }
  
  public static void b(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14)
  {
    try
    {
      paramString11 = new JSONObject();
      JSONArray localJSONArray = new JSONArray();
      JSONObject localJSONObject1 = new JSONObject();
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("sq_ver", "8.7.0");
      localJSONObject2.put("device_type", Build.BRAND);
      localJSONObject2.put("domain", "1");
      localJSONObject2.put("gameappid", paramString1);
      localJSONObject2.put("ext12", paramString3);
      localJSONObject2.put("ext11", paramString2);
      localJSONObject2.put("ext1", paramString5);
      localJSONObject2.put("oper_moudle", paramString4);
      localJSONObject2.put("oper_id", paramString6);
      localJSONObject2.put("logic_id", paramString7);
      localJSONObject2.put("ext2", paramString8);
      localJSONObject2.put("ext3", paramString9);
      localJSONObject2.put("ext4", paramString10);
      localJSONObject2.put("ext6", paramString7);
      localJSONObject2.put("ext10", paramString12);
      localJSONObject2.put("ext11", paramString13);
      localJSONObject2.put("tianji_report_str", paramString14);
      localJSONObject1.put("data", localJSONObject2);
      localJSONObject1.put("dc_id", "dc00087");
      localJSONArray.put(localJSONObject1);
      paramString11.put("report_list", localJSONArray);
      ((IQQGameReportService)QRoute.api(IQQGameReportService.class)).report(paramString11, 0);
      return;
    }
    catch (Exception paramString1)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, paramString1.getMessage());
    }
  }
  
  public static void b(String paramString, boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("game_center_sp", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sp_aio_game_entry_shown");
    localStringBuilder.append(paramString);
    paramString = localStringBuilder.toString();
    localSharedPreferences.edit().putBoolean(paramString, paramBoolean).commit();
  }
  
  public static boolean b(String paramString)
  {
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("game_center_sp", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sp_aio_game_entry_shown");
    localStringBuilder.append(paramString);
    return localSharedPreferences.getBoolean(localStringBuilder.toString(), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.utils.GameMsgUtil
 * JD-Core Version:    0.7.0.1
 */