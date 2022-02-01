package com.tencent.mobileqq.gamecenter.data;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.gamecenter.message.GameMsgManager;
import com.tencent.mobileqq.gamecenter.message.TinyIdCache;
import com.tencent.mobileqq.gamecenter.message.TinyInfo;
import com.tencent.mobileqq.gamecenter.protocol.GameCenterUnissoHandler;
import com.tencent.mobileqq.musicpendant.Base64;
import com.tencent.mobileqq.service.message.MessageCache;

public class GameQQPlayerUtil
{
  public static final String a;
  public TinyInfo a;
  public byte[] a;
  public String b;
  
  static
  {
    jdField_a_of_type_JavaLangString = GameCenterUnissoHandler.jdField_a_of_type_JavaLangString + "GameQQPlayerUtil";
  }
  
  public GameQQPlayerUtil()
  {
    this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageTinyInfo = new TinyInfo();
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramQQAppInterface == null)
    {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "[getMsgExtraString] fails, app is null");
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 0, "[getMsgExtraString], friendUin:" + paramString);
    }
    paramQQAppInterface = ((GameMsgManager)paramQQAppInterface.getManager(QQManagerFactory.GAME_CENTER_MSG_MANAGER)).a;
    if (paramQQAppInterface == null) {
      return null;
    }
    if (!paramQQAppInterface.a(paramString))
    {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "NOT same aio.");
      return null;
    }
    paramQQAppInterface = paramQQAppInterface.jdField_a_of_type_ComTencentMobileqqGamecenterMessageTinyInfo;
    if (paramQQAppInterface == null) {
      return null;
    }
    return paramQQAppInterface.toJsonStr();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, long paramLong, String paramString7, String paramString8, int paramInt1, int paramInt2)
  {
    if (paramQQAppInterface == null) {}
    try
    {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "[openGameMsgAIO] fails, app is null.");
      return;
    }
    catch (Throwable paramQQAppInterface)
    {
      GameQQPlayerUtil localGameQQPlayerUtil;
      String str;
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[openGameMsgAIO] " + paramQQAppInterface.getMessage());
      return;
    }
    localGameQQPlayerUtil = ((GameMsgManager)paramQQAppInterface.getManager(QQManagerFactory.GAME_CENTER_MSG_MANAGER)).a;
    str = paramQQAppInterface.getTinyIdCache().a(paramString8, paramString7);
    localGameQQPlayerUtil.b = str;
    localGameQQPlayerUtil.a(paramQQAppInterface, paramString1, paramString2, paramString3, paramString4, paramString6, paramLong, paramString7, paramString8, paramInt1);
    paramQQAppInterface = new Intent(paramContext, ChatActivity.class);
    paramQQAppInterface.putExtra("uin", str);
    paramQQAppInterface.putExtra("game_msg_friend_role_id", paramString3);
    paramQQAppInterface.putExtra("game_msg_my_role_id", paramString1);
    paramQQAppInterface.putExtra("game_msg_top_gray_text", paramString5);
    paramQQAppInterface.putExtra("uintype", 10007);
    if (paramInt2 == 1000) {
      paramQQAppInterface.putExtra("game_msg_open_aio_from", 4);
    }
    for (;;)
    {
      paramQQAppInterface.addFlags(268435456);
      QLog.i(jdField_a_of_type_JavaLangString, 1, "[openGameMsgAIO],convertUin:" + str + ",topGrayText:" + paramString5);
      paramContext.startActivity(paramQQAppInterface);
      return;
      paramQQAppInterface.putExtra("game_msg_open_aio_from", 3);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong, String paramString6, String paramString7, int paramInt)
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
      this.jdField_a_of_type_ArrayOfByte = Base64.a(paramString5);
      paramQQAppInterface.getMsgCache().d(this.b, paramQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ArrayOfByte);
      if (QLog.isColorLevel())
      {
        paramQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageTinyInfo.toString();
        QLog.d(jdField_a_of_type_JavaLangString, 0, "[setTinyInfo] " + paramQQAppInterface + ",");
      }
      return;
    }
    catch (Throwable paramQQAppInterface)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, paramQQAppInterface.getMessage());
    }
  }
  
  public boolean a(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (paramString.equals(this.b));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.data.GameQQPlayerUtil
 * JD-Core Version:    0.7.0.1
 */