package com.tencent.mobileqq.gamecenter.util;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.gamecenter.api.IGameQQPlayerUtilApi;
import com.tencent.mobileqq.gamecenter.message.TinyInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class RoleIdUtil
{
  public static TinyInfo a(AppInterface paramAppInterface, String paramString)
  {
    if (paramAppInterface == null) {
      return null;
    }
    for (;;)
    {
      try
      {
        MessageRecord localMessageRecord = ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).getLastGameMsg(paramAppInterface, paramString);
        if (localMessageRecord != null)
        {
          paramAppInterface = localMessageRecord.getExtInfoFromExtStr("ext_key_game_msg_info");
          if (!localMessageRecord.isSend())
          {
            bool = true;
            return new TinyInfo(paramAppInterface, bool);
          }
        }
        else
        {
          paramAppInterface = new TinyInfo(((IGameQQPlayerUtilApi)QRoute.api(IGameQQPlayerUtilApi.class)).getMsgExtraString(paramAppInterface, paramString));
          return paramAppInterface;
        }
      }
      catch (Exception paramAppInterface)
      {
        paramAppInterface.printStackTrace();
        return null;
      }
      boolean bool = false;
    }
  }
  
  public static String a(MessageRecord paramMessageRecord)
  {
    if (TextUtils.isEmpty(paramMessageRecord.getExtInfoFromExtStr("ext_key_game_msg_info"))) {
      c(paramMessageRecord);
    }
    TinyInfo localTinyInfo = new TinyInfo();
    localTinyInfo.parseFromMessageRecord(paramMessageRecord);
    if (paramMessageRecord.isSend()) {
      return localTinyInfo.fromRoleId;
    }
    return localTinyInfo.toRoleId;
  }
  
  public static void a(AppRuntime paramAppRuntime, MessageRecord paramMessageRecord, String paramString, int paramInt)
  {
    if (paramAppRuntime != null) {
      if (paramMessageRecord == null) {
        return;
      }
    }
    for (;;)
    {
      try
      {
        MessageRecord localMessageRecord = ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).getLastGameMsg(paramAppRuntime, paramString);
        if (localMessageRecord != null)
        {
          paramAppRuntime = localMessageRecord.getExtInfoFromExtStr("ext_key_game_msg_info");
          boolean bool2 = localMessageRecord.isSend();
          if (bool2) {
            break label178;
          }
          bool1 = true;
          paramAppRuntime = new TinyInfo(paramAppRuntime, bool1);
          paramMessageRecord.saveExtInfoToExtStr("ext_key_game_msg_info", paramAppRuntime.toJsonStr());
          if (QLog.isColorLevel())
          {
            paramMessageRecord = new StringBuilder();
            paramMessageRecord.append("bindTinyInfo is called, issend: ");
            paramMessageRecord.append(bool2);
            paramMessageRecord.append("tinyInfo :");
            paramMessageRecord.append(paramAppRuntime);
            QLog.d("RoleIdUtil", 2, paramMessageRecord.toString());
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("RoleIdUtil", 2, "bindTinyInfo is called, there is no last msg.");
          }
          paramAppRuntime = ((IGameQQPlayerUtilApi)QRoute.api(IGameQQPlayerUtilApi.class)).getMsgExtraString(paramAppRuntime, paramString);
          if (paramAppRuntime != null)
          {
            paramMessageRecord.saveExtInfoToExtStr("ext_key_game_msg_info", paramAppRuntime);
            return;
          }
        }
      }
      catch (Exception paramAppRuntime)
      {
        paramAppRuntime.printStackTrace();
      }
      return;
      label178:
      boolean bool1 = false;
    }
  }
  
  public static String b(MessageRecord paramMessageRecord)
  {
    if (TextUtils.isEmpty(paramMessageRecord.getExtInfoFromExtStr("ext_key_game_msg_info"))) {
      c(paramMessageRecord);
    }
    TinyInfo localTinyInfo = new TinyInfo();
    localTinyInfo.parseFromMessageRecord(paramMessageRecord);
    if (paramMessageRecord.isSend()) {
      return localTinyInfo.toRoleId;
    }
    return localTinyInfo.fromRoleId;
  }
  
  public static void c(MessageRecord paramMessageRecord)
  {
    a(MobileQQ.sMobileQQ.peekAppRuntime(), paramMessageRecord, paramMessageRecord.frienduin, paramMessageRecord.istroop);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.util.RoleIdUtil
 * JD-Core Version:    0.7.0.1
 */