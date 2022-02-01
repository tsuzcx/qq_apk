package com.tencent.mobileqq.gamecenter.data;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService;
import com.tencent.mobileqq.gamecenter.api.ITempApi;
import com.tencent.mobileqq.gamecenter.api.impl.GameMsgManagerServiceImpl;
import com.tencent.mobileqq.gamecenter.message.TinyIdCache;
import com.tencent.mobileqq.gamecenter.message.TinyInfo;
import com.tencent.mobileqq.gamecenter.protocols.GameCenterUnissoHandler;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qphone.base.util.log.encrypt.Base64;
import mqq.app.AppRuntime;

public class GameQQPlayerUtils
{
  public static final String a;
  public TinyInfo b = new TinyInfo();
  public String c;
  public byte[] d;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(GameCenterUnissoHandler.b);
    localStringBuilder.append("GameQQPlayerUtil");
    a = localStringBuilder.toString();
  }
  
  public static String a(AppRuntime paramAppRuntime, String paramString)
  {
    if (paramAppRuntime == null)
    {
      QLog.w(a, 1, "[getMsgExtraString] fails, app is null");
      return null;
    }
    if (QLog.isColorLevel())
    {
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[getMsgExtraString], friendUin:");
      localStringBuilder.append(paramString);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    paramAppRuntime = ((GameMsgManagerServiceImpl)paramAppRuntime.getRuntimeService(IGameMsgManagerService.class, "")).mQQPlayerUtil;
    if (paramAppRuntime == null) {
      return null;
    }
    if (!paramAppRuntime.a(paramString))
    {
      QLog.w(a, 1, "NOT same aio.");
      return null;
    }
    paramAppRuntime = paramAppRuntime.b;
    if (paramAppRuntime == null) {
      return null;
    }
    return paramAppRuntime.toJsonStr();
  }
  
  public static void a(AppInterface paramAppInterface, Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, long paramLong, String paramString7, String paramString8, int paramInt1, int paramInt2)
  {
    if (paramAppInterface == null) {}
    try
    {
      QLog.w(a, 1, "[openGameMsgAIO] fails, app is null.");
      return;
    }
    catch (Throwable paramAppInterface)
    {
      GameQQPlayerUtils localGameQQPlayerUtils;
      String str;
      paramContext = a;
      paramString1 = new StringBuilder();
      paramString1.append("[openGameMsgAIO] ");
      paramString1.append(paramAppInterface.getMessage());
      QLog.e(paramContext, 1, paramString1.toString());
    }
    localGameQQPlayerUtils = ((GameMsgManagerServiceImpl)paramAppInterface.getRuntimeService(IGameMsgManagerService.class, "")).mQQPlayerUtil;
    str = ((IMessageFacade)paramAppInterface.getRuntimeService(IMessageFacade.class, "")).getTinyIdCache().a(paramString8, paramString7);
    localGameQQPlayerUtils.c = str;
    localGameQQPlayerUtils.a(paramAppInterface, paramString1, paramString2, paramString3, paramString4, paramString6, paramLong, paramString7, paramString8, paramInt1);
    paramAppInterface = a;
    paramString2 = new StringBuilder();
    paramString2.append("[openGameMsgAIO],convertUin:");
    paramString2.append(str);
    paramString2.append(",topGrayText:");
    paramString2.append(paramString5);
    QLog.i(paramAppInterface, 1, paramString2.toString());
    paramAppInterface = new ActivityURIRequest(paramContext, "/base/activity/ChatActivity");
    paramAppInterface.extra().putString("uin", str);
    paramAppInterface.extra().putString("game_msg_friend_role_id", paramString3);
    paramAppInterface.extra().putString("game_msg_my_role_id", paramString1);
    paramAppInterface.extra().putString("game_msg_top_gray_text", paramString5);
    paramAppInterface.extra().putInt("uintype", 10007);
    if (paramInt2 == 5) {
      paramAppInterface.extra().putInt("game_msg_open_aio_from", 5);
    } else if (paramInt2 == 1000) {
      paramAppInterface.extra().putInt("game_msg_open_aio_from", 4);
    } else {
      paramAppInterface.extra().putInt("game_msg_open_aio_from", 3);
    }
    paramAppInterface.setFlags(268435456);
    QRoute.startUri(paramAppInterface, null);
    return;
  }
  
  private void a(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong, String paramString6, String paramString7, int paramInt)
  {
    try
    {
      this.b.fromRoleId = paramString1;
      this.b.toRoleId = paramString3;
      this.b.fromOpenId = paramString2;
      this.b.toOpenId = paramString4;
      this.b.gameAppId = paramLong;
      this.b.fromTinyId = Long.parseLong(paramString6);
      this.b.toTinyId = Long.parseLong(paramString7);
      this.b.windowFlag = paramInt;
      this.d = Base64.decode(paramString5);
      ((ITempApi)QRoute.api(ITempApi.class)).addTinySessionKey(this.c, paramAppInterface.getCurrentAccountUin(), this.d);
      if (QLog.isColorLevel())
      {
        paramAppInterface = this.b.toString();
        paramString1 = a;
        paramString2 = new StringBuilder();
        paramString2.append("[setTinyInfo] ");
        paramString2.append(paramAppInterface);
        paramString2.append(",");
        QLog.d(paramString1, 2, paramString2.toString());
        return;
      }
    }
    catch (Throwable paramAppInterface)
    {
      QLog.e(a, 1, paramAppInterface.getMessage());
    }
  }
  
  private boolean a(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (paramString.equals(this.c));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.data.GameQQPlayerUtils
 * JD-Core Version:    0.7.0.1
 */