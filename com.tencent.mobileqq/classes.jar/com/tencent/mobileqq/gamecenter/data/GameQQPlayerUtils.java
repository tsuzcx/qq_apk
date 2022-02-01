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

public class GameQQPlayerUtils
{
  public static final String a;
  public TinyInfo a;
  public byte[] a;
  public String b;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(GameCenterUnissoHandler.b);
    localStringBuilder.append("GameQQPlayerUtil");
    jdField_a_of_type_JavaLangString = localStringBuilder.toString();
  }
  
  public GameQQPlayerUtils()
  {
    this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageTinyInfo = new TinyInfo();
  }
  
  public static String a(AppInterface paramAppInterface, String paramString)
  {
    if (paramAppInterface == null)
    {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "[getMsgExtraString] fails, app is null");
      return null;
    }
    if (QLog.isColorLevel())
    {
      String str = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[getMsgExtraString], friendUin:");
      localStringBuilder.append(paramString);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    paramAppInterface = ((GameMsgManagerServiceImpl)paramAppInterface.getRuntimeService(IGameMsgManagerService.class, "")).mQQPlayerUtil;
    if (paramAppInterface == null) {
      return null;
    }
    if (!paramAppInterface.a(paramString))
    {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "NOT same aio.");
      return null;
    }
    paramAppInterface = paramAppInterface.jdField_a_of_type_ComTencentMobileqqGamecenterMessageTinyInfo;
    if (paramAppInterface == null) {
      return null;
    }
    return paramAppInterface.toJsonStr();
  }
  
  public static void a(AppInterface paramAppInterface, Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, long paramLong, String paramString7, String paramString8, int paramInt1, int paramInt2)
  {
    if (paramAppInterface == null) {}
    try
    {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "[openGameMsgAIO] fails, app is null.");
      return;
    }
    catch (Throwable paramAppInterface)
    {
      GameQQPlayerUtils localGameQQPlayerUtils;
      String str;
      paramContext = jdField_a_of_type_JavaLangString;
      paramString1 = new StringBuilder();
      paramString1.append("[openGameMsgAIO] ");
      paramString1.append(paramAppInterface.getMessage());
      QLog.e(paramContext, 1, paramString1.toString());
    }
    localGameQQPlayerUtils = ((GameMsgManagerServiceImpl)paramAppInterface.getRuntimeService(IGameMsgManagerService.class, "")).mQQPlayerUtil;
    str = ((IMessageFacade)paramAppInterface.getRuntimeService(IMessageFacade.class, "")).getTinyIdCache().a(paramString8, paramString7);
    localGameQQPlayerUtils.b = str;
    localGameQQPlayerUtils.a(paramAppInterface, paramString1, paramString2, paramString3, paramString4, paramString6, paramLong, paramString7, paramString8, paramInt1);
    paramAppInterface = jdField_a_of_type_JavaLangString;
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
    if (paramInt2 == 1000) {
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
      this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageTinyInfo.fromRoleId = paramString1;
      this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageTinyInfo.toRoleId = paramString3;
      this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageTinyInfo.fromOpenId = paramString2;
      this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageTinyInfo.toOpenId = paramString4;
      this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageTinyInfo.gameAppId = paramLong;
      this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageTinyInfo.fromTinyId = Long.parseLong(paramString6);
      this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageTinyInfo.toTinyId = Long.parseLong(paramString7);
      this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageTinyInfo.windowFlag = paramInt;
      this.jdField_a_of_type_ArrayOfByte = Base64.decode(paramString5);
      ((ITempApi)QRoute.api(ITempApi.class)).addTinySessionKey(this.b, paramAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ArrayOfByte);
      if (QLog.isColorLevel())
      {
        paramAppInterface = this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageTinyInfo.toString();
        paramString1 = jdField_a_of_type_JavaLangString;
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
      QLog.e(jdField_a_of_type_JavaLangString, 1, paramAppInterface.getMessage());
    }
  }
  
  private boolean a(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (paramString.equals(this.b));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.data.GameQQPlayerUtils
 * JD-Core Version:    0.7.0.1
 */