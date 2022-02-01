package com.tencent.mobileqq.guild.api.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.api.IQQGuildClientAuthApi;
import com.tencent.mobileqq.guild.client.ClientAuthorizationHelper;
import com.tencent.mobileqq.guild.client.GuildClientParams;
import com.tencent.mobileqq.guild.config.QQGuildConfigBean;
import com.tencent.mobileqq.guild.util.QQGuildSPUtils;
import com.tencent.mobileqq.guild.util.QQGuildUtil;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class QQGuildClientAuthApiImpl
  implements IQQGuildClientAuthApi
{
  public static final String TAG = "QQGuildAppAuthApiImpl";
  
  private void checkClientAuthorizationForAIOPlus(QBaseActivity paramQBaseActivity, GuildClientParams paramGuildClientParams)
  {
    String str = generateJumpUrl(paramQBaseActivity, paramGuildClientParams);
    if (!TextUtils.isEmpty(str))
    {
      paramGuildClientParams.j(str);
      ClientAuthorizationHelper.a(paramQBaseActivity, paramGuildClientParams);
    }
  }
  
  private void checkShowClientGuideAuthDialog(QBaseActivity paramQBaseActivity, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGuildAppAuthApiImpl", 4, "checkShowAuthDialog start");
    }
    if (!QQGuildSPUtils.c(paramString1))
    {
      QQGuildSPUtils.d(paramString1);
      return;
    }
    if (QQGuildUtil.c().i) {
      return;
    }
    String str = getClientId(paramQBaseActivity, paramString1);
    if (TextUtils.isEmpty(str)) {
      return;
    }
    IGPSService localIGPSService = (IGPSService)paramQBaseActivity.getAppRuntime().getRuntimeService(IGPSService.class, "");
    paramString2 = localIGPSService.getChannelInfo(paramString2);
    if ((paramString2 != null) && (!TextUtils.isEmpty(str)) && (!TextUtils.equals("0", str)))
    {
      if (paramString2.getType() != 1) {
        return;
      }
      if (!getAppAuthFlag(str))
      {
        if (QQGuildSPUtils.f(str)) {
          return;
        }
        localIGPSService.getAppAuthorizationInfo(str, 2, new QQGuildClientAuthApiImpl.1(this, paramString1, paramQBaseActivity));
      }
    }
  }
  
  private String generateJumpUrl(QBaseActivity paramQBaseActivity, GuildClientParams paramGuildClientParams)
  {
    Object localObject = (IGPSService)paramQBaseActivity.getAppRuntime().getRuntimeService(IGPSService.class, "");
    paramQBaseActivity = ((IGPSService)localObject).getGuildInfo(paramGuildClientParams.f());
    paramGuildClientParams = ((IGPSService)localObject).getChannelInfo(paramGuildClientParams.g());
    if ((paramQBaseActivity != null) && (paramGuildClientParams != null))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("mqqapi://esports/team/create?guildid=");
      ((StringBuilder)localObject).append(paramQBaseActivity.getGuildID());
      ((StringBuilder)localObject).append("&channelname=");
      ((StringBuilder)localObject).append(paramGuildClientParams.getChannelName());
      ((StringBuilder)localObject).append("&channelid=");
      ((StringBuilder)localObject).append(paramGuildClientParams.getChannelUin());
      return ((StringBuilder)localObject).toString();
    }
    QLog.w("QQGuildAppAuthApiImpl", 1, "generateJumpUrl guildInfo or channelInfo is null");
    return "";
  }
  
  private boolean getAppAuthFlag(String paramString)
  {
    return QQGuildSPUtils.a(paramString);
  }
  
  private String getClientId(QBaseActivity paramQBaseActivity, String paramString)
  {
    paramQBaseActivity = ((IGPSService)paramQBaseActivity.getAppRuntime().getRuntimeService(IGPSService.class, "")).getGuildInfo(paramString);
    if (paramQBaseActivity == null)
    {
      QLog.w("QQGuildAppAuthApiImpl", 1, "checkShowAuthDialog guildInfo is null");
      return "";
    }
    return paramQBaseActivity.getClientId();
  }
  
  public void clientAuthorizationForAIOPlus(QBaseActivity paramQBaseActivity, GuildClientParams paramGuildClientParams)
  {
    checkClientAuthorizationForAIOPlus(paramQBaseActivity, paramGuildClientParams);
  }
  
  public void clientAuthorizationForArk(QBaseActivity paramQBaseActivity, GuildClientParams paramGuildClientParams)
  {
    ClientAuthorizationHelper.a(paramQBaseActivity, paramGuildClientParams);
  }
  
  public void showClientGuideAuthDialog(QBaseActivity paramQBaseActivity, String paramString1, String paramString2)
  {
    checkShowClientGuideAuthDialog(paramQBaseActivity, paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.api.impl.QQGuildClientAuthApiImpl
 * JD-Core Version:    0.7.0.1
 */