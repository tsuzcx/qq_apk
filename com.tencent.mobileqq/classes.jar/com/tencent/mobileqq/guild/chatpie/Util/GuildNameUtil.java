package com.tencent.mobileqq.guild.chatpie.Util;

import android.text.TextUtils;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class GuildNameUtil
{
  public static String a(IGProUserInfo paramIGProUserInfo)
  {
    if (paramIGProUserInfo == null) {
      return "";
    }
    if (!TextUtils.isEmpty(paramIGProUserInfo.b())) {
      return paramIGProUserInfo.b();
    }
    if (!TextUtils.isEmpty(paramIGProUserInfo.c())) {
      return paramIGProUserInfo.c();
    }
    return paramIGProUserInfo.a();
  }
  
  public static String a(AppRuntime paramAppRuntime, String paramString1, String paramString2)
  {
    if (paramAppRuntime == null)
    {
      QLog.e("GuildNameUtil", 2, "app is null while getDisplayName");
      return "";
    }
    if ((!StringUtil.isEmpty(paramString1)) && (!StringUtil.isEmpty(paramString2)))
    {
      String str = paramString2;
      if (TextUtils.equals(paramAppRuntime.getCurrentAccountUin(), paramString2)) {
        str = ((IGPSService)paramAppRuntime.getRuntimeService(IGPSService.class, "")).getSelfTinyId();
      }
      paramString2 = (IGPSService)paramAppRuntime.getRuntimeService(IGPSService.class, "");
      paramAppRuntime = paramString2.getGuildMemberName(paramString1, str);
      if (TextUtils.isEmpty(paramAppRuntime)) {
        paramAppRuntime = paramString2.getGuildUserNick(str);
      }
      paramString1 = paramAppRuntime;
      if (TextUtils.isEmpty(paramAppRuntime)) {
        paramString1 = str;
      }
      return paramString1;
    }
    QLog.e("GuildNameUtil", 2, String.format("getDisplayName failed while guildId or tid is null", new Object[0]));
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.Util.GuildNameUtil
 * JD-Core Version:    0.7.0.1
 */