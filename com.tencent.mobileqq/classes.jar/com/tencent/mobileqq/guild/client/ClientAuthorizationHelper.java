package com.tencent.mobileqq.guild.client;

import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.api.IGuildTempApi;
import com.tencent.mobileqq.guild.util.QQGuildUtil;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProRoleInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class ClientAuthorizationHelper
{
  private static long a(long paramLong)
  {
    return paramLong / 1000L / 60L;
  }
  
  public static void a()
  {
    QQGuildUtil.a = System.currentTimeMillis();
  }
  
  public static void a(QBaseActivity paramQBaseActivity, GuildClientParams paramGuildClientParams)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleClientAuthorization params: ");
    localStringBuilder.append(paramGuildClientParams.toString());
    QLog.i("ClientAuthorizationUtils", 1, localStringBuilder.toString());
    if (b())
    {
      QLog.i("ClientAuthorizationUtils", 1, "handleClientAuthorization cacheValid");
      a(paramQBaseActivity, paramGuildClientParams, false);
      return;
    }
    ((IGPSService)paramQBaseActivity.getAppRuntime().getRuntimeService(IGPSService.class, "")).getAppAuthorizationInfo(paramGuildClientParams.h(), 1, new ClientAuthorizationHelper.1(paramQBaseActivity, paramGuildClientParams));
  }
  
  public static void a(QBaseActivity paramQBaseActivity, GuildClientParams paramGuildClientParams, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleBindSuccess sceneType: ");
    localStringBuilder.append(paramGuildClientParams.j());
    QLog.i("ClientAuthorizationUtils", 1, localStringBuilder.toString());
    if (paramGuildClientParams.j() == 4) {
      ((IGuildTempApi)QRoute.api(IGuildTempApi.class)).sendClientAuthSuccessToArk(paramGuildClientParams.i(), paramGuildClientParams.l());
    } else if (paramGuildClientParams.j() == 5) {
      GuildAppChannelOpenApiImpl.a(paramQBaseActivity, paramGuildClientParams.k());
    } else if (paramGuildClientParams.j() == 3) {
      GuildAppChannelOpenApiImpl.a(paramQBaseActivity, paramGuildClientParams);
    }
    if (paramBoolean) {
      a();
    }
  }
  
  private static void b(QBaseActivity paramQBaseActivity, GuildClientParams paramGuildClientParams, IGProRoleInfo paramIGProRoleInfo)
  {
    ((IGPSService)paramQBaseActivity.getAppRuntime().getRuntimeService(IGPSService.class, "")).bindAppRole(paramGuildClientParams.h(), paramIGProRoleInfo.getRoleId(), 1, new ClientAuthorizationHelper.3(paramQBaseActivity, paramGuildClientParams));
  }
  
  private static boolean b()
  {
    return a(System.currentTimeMillis() - QQGuildUtil.a) < 5L;
  }
  
  private static void c(QBaseActivity paramQBaseActivity, GuildClientParams paramGuildClientParams)
  {
    ((IGPSService)paramQBaseActivity.getAppRuntime().getRuntimeService(IGPSService.class, "")).getAppRoleList(paramGuildClientParams.h(), new ClientAuthorizationHelper.2(paramQBaseActivity, paramGuildClientParams));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.client.ClientAuthorizationHelper
 * JD-Core Version:    0.7.0.1
 */