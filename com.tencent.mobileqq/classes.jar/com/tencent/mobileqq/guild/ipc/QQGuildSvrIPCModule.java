package com.tencent.mobileqq.guild.ipc;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.api.IGuildOpenApi;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.api.IQQGuildService;
import com.tencent.mobileqq.guild.ipc.methods.FetchGuildInfoByInviteCodeMethod;
import com.tencent.mobileqq.guild.ipc.methods.IsShowGuildTabMethod;
import com.tencent.mobileqq.guild.ipc.methods.NavigateToGuildPageWithInvitedInfoMethod;
import com.tencent.mobileqq.guild.ipc.methods.OpenGuildAIOIpcMethod;
import com.tencent.mobileqq.guild.usecases.JoinGuildUseCase;
import com.tencent.mobileqq.guild.usecases.JoinGuildUseCase.ResultCallback;
import com.tencent.mobileqq.guild.util.QQGuildUtil;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class QQGuildSvrIPCModule
  extends QIPCModule
{
  private static volatile QQGuildSvrIPCModule a;
  private final IpcMethodHandler b = new IpcMethodHandler(new Class[] { FetchGuildInfoByInviteCodeMethod.class, IsShowGuildTabMethod.class, NavigateToGuildPageWithInvitedInfoMethod.class, OpenGuildAIOIpcMethod.class });
  
  public QQGuildSvrIPCModule(String paramString)
  {
    super(paramString);
  }
  
  public static Bundle a(int paramInt, String paramString, Object paramObject)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("errCode", paramInt);
    localBundle.putString("errMsg", paramString);
    if ((paramObject instanceof IGProSecurityResult))
    {
      paramString = (IGProSecurityResult)paramObject;
      localBundle.putLong("actionCode", paramString.a());
      localBundle.putString("strPrompt", paramString.b());
      localBundle.putString("strDetail", paramString.c());
    }
    return localBundle;
  }
  
  public static QQGuildSvrIPCModule a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new QQGuildSvrIPCModule("module_ipc_server_guild");
        }
      }
      finally {}
    }
    return a;
  }
  
  @NonNull
  private JoinGuildUseCase.ResultCallback a(int paramInt)
  {
    return new QQGuildSvrIPCModule.2(this, paramInt);
  }
  
  private EIPCResult a(Context paramContext, String paramString, int paramInt)
  {
    Context localContext = paramContext;
    if (paramContext == null) {
      localContext = QQGuildUtil.h();
    }
    ((IQQGuildRouterApi)QRoute.api(IQQGuildRouterApi.class)).setShowGuildTab(true);
    QQGuildUtil.a(localContext, paramString, paramInt);
    return EIPCResult.createSuccessResult(new Bundle());
  }
  
  private void a(int paramInt1, int paramInt2, String paramString)
  {
    callbackResult(paramInt1, EIPCResult.createSuccessResult(a(paramInt2, paramString, null)));
  }
  
  private void a(String paramString, int paramInt1, int paramInt2)
  {
    if (TextUtils.isEmpty(paramString))
    {
      a(paramInt2, -1, "empty inviteCode");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQGuildSvrIPCModule", 1, new Object[] { "addGuild inviteCode:", paramString, ", from:", Integer.valueOf(paramInt1) });
    }
    JoinGuildUseCase.a(paramString, paramInt1, a(paramInt2));
  }
  
  private void a(AppRuntime paramAppRuntime, int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    if ((paramAppRuntime != null) && (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      ((IQQGuildService)paramAppRuntime.getRuntimeService(IQQGuildService.class, "")).addGuild(paramAppRuntime.getApp().getBaseContext(), paramString1, paramString2, paramInt2, new QQGuildSvrIPCModule.1(this, paramString1, paramInt1));
      if (QLog.isColorLevel()) {
        QLog.d("QQGuildSvrIPCModule", 1, new Object[] { "addGuildInternal guildId:", paramString1, ", from:", Integer.valueOf(paramInt2) });
      }
      JoinGuildUseCase.a(paramString1, paramString2, paramInt2, a(paramInt1));
      return;
    }
    a(paramInt1, -1, "empty params key/joinSig");
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGuildSvrIPCModule", 2, new Object[] { "onCall action:", paramString, ", callbackId:", Integer.valueOf(paramInt) });
    }
    if (this.b.a(paramString)) {
      return this.b.a(this, paramString, paramBundle, paramInt);
    }
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if ("addGuild".equals(paramString))
    {
      a(paramBundle.getString("inviteCode"), paramBundle.getInt("from"), paramInt);
      return null;
    }
    if ("addGuildInternal".equals(paramString))
    {
      a(localAppRuntime, paramInt, paramBundle.getString("key"), paramBundle.getString("joinSig"), paramBundle.getInt("from"));
      return null;
    }
    if ("handleGuildOpenResult".equals(paramString))
    {
      ((IGuildOpenApi)localAppRuntime.getRuntimeService(IGuildOpenApi.class, "")).handleGuildOpenResult(paramBundle.getString("packageId"), paramBundle.getString("gamedata"));
      return null;
    }
    if ("handleEnterToTroop".equals(paramString))
    {
      ((IGuildOpenApi)localAppRuntime.getRuntimeService(IGuildOpenApi.class, "")).handleEnterToTroop(paramBundle.getString("packageId"), paramBundle.getString("troopUin"));
      return null;
    }
    if ("navigateToGuildPageWithInvitedInfo".equals(paramString)) {
      return a(QBaseActivity.sTopActivity, paramBundle.getString("inviteCode"), paramBundle.getInt("from"));
    }
    if ("syncIsShowGuildTab".equals(paramString))
    {
      boolean bool = ((IQQGuildRouterApi)QRoute.api(IQQGuildRouterApi.class)).isShowGuildTab();
      paramString = new Bundle();
      paramString.putBoolean("ret", bool);
      return EIPCResult.createSuccessResult(paramString);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.ipc.QQGuildSvrIPCModule
 * JD-Core Version:    0.7.0.1
 */