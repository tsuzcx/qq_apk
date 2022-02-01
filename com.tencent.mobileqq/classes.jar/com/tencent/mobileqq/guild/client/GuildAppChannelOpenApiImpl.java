package com.tencent.mobileqq.guild.client;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.Frame;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.api.IGuildAppChannelOpenApi;
import com.tencent.mobileqq.guild.api.IGuildTempApi;
import com.tencent.mobileqq.guild.api.ILaunchGuildChatPieApi;
import com.tencent.mobileqq.guild.api.LaunchGuildChatPieParam;
import com.tencent.mobileqq.guild.main.data.QQGuildChannelApp;
import com.tencent.mobileqq.guild.mainframe.IGuildMainFrame;
import com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi;
import com.tencent.mobileqq.guild.mainframe.attachcontainer.GuildAttachContainerController;
import com.tencent.mobileqq.guild.util.QQGuildUtil;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.appchannel.IAppChnnPreInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.qphone.base.util.QLog;

public class GuildAppChannelOpenApiImpl
  implements IGuildAppChannelOpenApi
{
  public static GuildClientParams a(QQGuildChannelApp paramQQGuildChannelApp)
  {
    if ((paramQQGuildChannelApp != null) && (paramQQGuildChannelApp.c() != null) && (paramQQGuildChannelApp.a() != null)) {
      return new GuildClientParams().d(paramQQGuildChannelApp.b()).e(paramQQGuildChannelApp.a().getChannelUin()).b((int)paramQQGuildChannelApp.c().c()).f(paramQQGuildChannelApp.a().getChannelName()).j(paramQQGuildChannelApp.c().d()).e();
    }
    QLog.w("GuildAppChannelOpenHelper", 1, "openLastAppChannelSilent failed");
    return null;
  }
  
  public static IGuildMainFrame a()
  {
    Frame localFrame = ((IGuildTempApi)QRoute.api(IGuildTempApi.class)).obtainGuildMainFrame();
    if ((localFrame instanceof IGuildMainFrame)) {
      return (IGuildMainFrame)localFrame;
    }
    return null;
  }
  
  public static void a(Context paramContext, GuildClientParams paramGuildClientParams)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("showAppChannelAsFragment guildId=");
    localStringBuilder.append(paramGuildClientParams.f());
    localStringBuilder.append(" appid=");
    localStringBuilder.append(paramGuildClientParams.n());
    QLog.d("GuildAppChannelOpenHelper", 1, localStringBuilder.toString());
    if (a(paramGuildClientParams.n()))
    {
      b(paramContext, paramGuildClientParams);
      return;
    }
    if (b(paramGuildClientParams.n()))
    {
      a(paramGuildClientParams);
      return;
    }
    QQGuildUtil.c(paramContext.getString(2131917763));
  }
  
  public static void a(QBaseActivity paramQBaseActivity, String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.w("GuildAppChannelOpenHelper", 1, "openAppChannelByJumpAction but jumpUrl is empty");
      return;
    }
    if ((paramQBaseActivity.getAppRuntime() instanceof BaseQQAppInterface))
    {
      paramQBaseActivity = JumpParser.a((BaseQQAppInterface)paramQBaseActivity.getAppRuntime(), paramQBaseActivity, paramString);
      if (paramQBaseActivity != null) {
        paramQBaseActivity.a();
      }
    }
  }
  
  public static void a(GuildClientParams paramGuildClientParams)
  {
    IGuildMainFrame localIGuildMainFrame = a();
    if (localIGuildMainFrame == null) {
      return;
    }
    boolean bool;
    if (paramGuildClientParams.j() != 3) {
      bool = true;
    } else {
      bool = false;
    }
    paramGuildClientParams.a(bool);
    localIGuildMainFrame.m().a(GuildAttachContainerController.g, paramGuildClientParams);
    localIGuildMainFrame.m().e(false);
  }
  
  public static boolean a(int paramInt)
  {
    return paramInt == 1000001;
  }
  
  private static boolean a(QBaseActivity paramQBaseActivity, GuildClientParams paramGuildClientParams, boolean paramBoolean, Bundle paramBundle)
  {
    if (((IGuildTempApi)QRoute.api(IGuildTempApi.class)).isChatFragmentShowing(paramQBaseActivity))
    {
      QLog.w("GuildAppChannelOpenHelper", 1, "openAppChannelChatFragmentSilent but other aio is open!!");
      return false;
    }
    Uri localUri = Uri.parse(paramGuildClientParams.k().toLowerCase());
    paramBundle.putString("roomtype", localUri.getQueryParameter("roomtype"));
    paramBundle.putString("entryscene", localUri.getQueryParameter("entryscene"));
    paramBundle.putString("channel_info", localUri.getQueryParameter("channel_info"));
    paramBundle.putString("jump_info", localUri.getQueryParameter("jump_info"));
    paramBundle = new LaunchGuildChatPieParam().a(paramGuildClientParams.f()).b(paramGuildClientParams.g()).a(paramGuildClientParams.n()).c(paramGuildClientParams.m()).a(paramBundle).a(paramBoolean).c(paramBoolean ^ true).b(paramBoolean ^ true).b(1).b();
    if (QLog.isColorLevel()) {
      QLog.d("GuildAppChannelOpenHelper", 1, new Object[] { "openAppChannelChatFragmentSilent ", paramBundle });
    }
    paramGuildClientParams = ((IGuildTempApi)QRoute.api(IGuildTempApi.class)).getMainFragment(paramQBaseActivity);
    paramQBaseActivity = ((ILaunchGuildChatPieApi)QRoute.api(ILaunchGuildChatPieApi.class)).getGuildChatPieIntent(paramQBaseActivity, paramBundle);
    ((IGuildMainFrameApi)QRoute.api(IGuildMainFrameApi.class)).openGuildAttachContainer(paramGuildClientParams, GuildAttachContainerController.c, paramQBaseActivity);
    return true;
  }
  
  public static boolean a(QBaseActivity paramQBaseActivity, QQGuildChannelApp paramQQGuildChannelApp, boolean paramBoolean, Bundle paramBundle)
  {
    paramQQGuildChannelApp = a(paramQQGuildChannelApp);
    if ((paramQQGuildChannelApp != null) && (!TextUtils.isEmpty(paramQQGuildChannelApp.f())) && (!TextUtils.isEmpty(paramQQGuildChannelApp.g())) && (paramQQGuildChannelApp.n() != 0) && (!TextUtils.isEmpty(paramQQGuildChannelApp.k())))
    {
      if (a(paramQQGuildChannelApp.n())) {
        return a(paramQBaseActivity, paramQQGuildChannelApp, paramBoolean, paramBundle);
      }
      if (b(paramQQGuildChannelApp.n())) {
        return b(paramQQGuildChannelApp);
      }
      return false;
    }
    QLog.w("GuildAppChannelOpenHelper", 1, "openLastAppChannelSilent failed");
    return false;
  }
  
  private static void b(Context paramContext, GuildClientParams paramGuildClientParams)
  {
    Uri localUri = Uri.parse(paramGuildClientParams.k().toLowerCase());
    paramGuildClientParams.o().putString("roomtype", localUri.getQueryParameter("roomtype"));
    paramGuildClientParams.o().putString("entryscene", localUri.getQueryParameter("entryscene"));
    paramGuildClientParams.o().putString("channel_info", localUri.getQueryParameter("channel_info"));
    paramGuildClientParams.o().putString("jump_info", localUri.getQueryParameter("jump_info"));
    paramGuildClientParams = new LaunchGuildChatPieParam().a(paramGuildClientParams.f()).b(paramGuildClientParams.g()).c(paramGuildClientParams.m()).a(paramGuildClientParams.n()).a(paramGuildClientParams.o()).b(false).c(false).e(paramGuildClientParams.o().getBoolean("disableReuse")).b(3).b();
    ((ILaunchGuildChatPieApi)QRoute.api(ILaunchGuildChatPieApi.class)).launchGuildChatPie(paramContext, paramGuildClientParams);
  }
  
  public static boolean b(int paramInt)
  {
    return paramInt == 1000000;
  }
  
  private static boolean b(GuildClientParams paramGuildClientParams)
  {
    IGuildMainFrame localIGuildMainFrame = a();
    if (localIGuildMainFrame == null) {
      return false;
    }
    localIGuildMainFrame.m().a(GuildAttachContainerController.g, paramGuildClientParams);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.client.GuildAppChannelOpenApiImpl
 * JD-Core Version:    0.7.0.1
 */