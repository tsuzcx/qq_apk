package com.tencent.mobileqq.guild.api.impl;

import android.content.Context;
import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import com.tencent.mobileqq.guild.api.IGuildInfoUtilsApi;
import com.tencent.mobileqq.guild.live.livemanager.repo.QQGuildLiveRoomUiData;
import com.tencent.mobileqq.guild.util.QQGuildUtil;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import mqq.app.AppRuntime;

public class GuildInfoUtilsApiImpl
  implements IGuildInfoUtilsApi
{
  public boolean canTalkinChannel(AppRuntime paramAppRuntime, String paramString1, String paramString2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramAppRuntime != null)
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(paramString1))
      {
        if (TextUtils.isEmpty(paramString2)) {
          return false;
        }
        paramString2 = ((IGPSService)paramAppRuntime.getRuntimeService(IGPSService.class, "")).getChannelInfo(paramString2);
        if (paramString2 == null) {
          return false;
        }
        bool1 = isCreatorOrAdmin(paramAppRuntime, paramString1);
        boolean bool3 = ((Boolean)QQGuildLiveRoomUiData.a().b().getValue()).booleanValue();
        if (((paramString2.getBannedSpeak() == 1) || (paramString2.getTalkPermission() == 2)) && (!bool1))
        {
          bool1 = bool2;
          if (!bool3) {}
        }
        else
        {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public boolean checkSecurityValid(IGProSecurityResult paramIGProSecurityResult)
  {
    return QQGuildUtil.a(paramIGProSecurityResult);
  }
  
  public int getGuildSettingDrawable()
  {
    return 2130841007;
  }
  
  public boolean isCreatorOrAdmin(AppRuntime paramAppRuntime, String paramString)
  {
    if ((paramAppRuntime != null) && (!TextUtils.isEmpty(paramString))) {
      return QQGuildUtil.a(((IGPSService)paramAppRuntime.getRuntimeService(IGPSService.class, "")).getGuildInfo(paramString));
    }
    return false;
  }
  
  public boolean isHomePage(AppRuntime paramAppRuntime, String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramAppRuntime != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return false;
      }
      paramAppRuntime = ((IGPSService)paramAppRuntime.getRuntimeService(IGPSService.class, "")).getChannelInfo(paramString);
      if (paramAppRuntime == null) {
        return false;
      }
      bool1 = bool2;
      if (paramAppRuntime.getType() == 3) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void toastErrorAndSecurity(Context paramContext, int paramInt, String paramString, IGProSecurityResult paramIGProSecurityResult)
  {
    QQGuildUtil.a(paramContext, paramInt, paramString, paramIGProSecurityResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.api.impl.GuildInfoUtilsApiImpl
 * JD-Core Version:    0.7.0.1
 */