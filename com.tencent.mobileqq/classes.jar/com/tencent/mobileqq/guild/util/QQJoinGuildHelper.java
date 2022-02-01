package com.tencent.mobileqq.guild.util;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.guild.api.ILaunchGuildChatPieApi;
import com.tencent.mobileqq.guild.joinguild.JoinGuildCheckOptionLogic;
import com.tencent.mobileqq.guild.joinguild.JoinGuildCheckOptionLogic.INextStepAction;
import com.tencent.mobileqq.guild.mainframe.joinchannel.JoinChannelViewModel.JoinChannelParams;
import com.tencent.mobileqq.guild.source.QQGuildJumpSource;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.callback.IResultWithSecurityCallback;
import com.tencent.mobileqq.qqguildsdk.data.GuildSourceId;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.AppRuntime;

public class QQJoinGuildHelper
{
  private static void a(AppRuntime paramAppRuntime, Context paramContext, @NonNull JoinChannelViewModel.JoinChannelParams paramJoinChannelParams, @Nullable String paramString, Bundle paramBundle, JoinGuildCheckOptionLogic.INextStepAction paramINextStepAction, @NonNull IResultWithSecurityCallback paramIResultWithSecurityCallback)
  {
    new JoinGuildCheckOptionLogic(paramAppRuntime, paramContext, paramJoinChannelParams, paramString, paramBundle).a(paramINextStepAction, paramIResultWithSecurityCallback);
  }
  
  public static void a(AppRuntime paramAppRuntime, Context paramContext, String paramString1, String paramString2, int paramInt, @NonNull IResultWithSecurityCallback paramIResultWithSecurityCallback)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(", from=");
    ((StringBuilder)localObject).append(paramInt);
    QLog.d("QQJoinGuildHelper", 1, new Object[] { "addGuild, guildId=", paramString1, ((StringBuilder)localObject).toString() });
    localObject = new JoinChannelViewModel.JoinChannelParams();
    ((JoinChannelViewModel.JoinChannelParams)localObject).a = paramString1;
    ((JoinChannelViewModel.JoinChannelParams)localObject).c = paramInt;
    ((JoinChannelViewModel.JoinChannelParams)localObject).b = paramString2;
    a(paramAppRuntime, paramContext, (JoinChannelViewModel.JoinChannelParams)localObject, null, null, new QQJoinGuildHelper.1(paramString1, paramAppRuntime, paramString2, paramIResultWithSecurityCallback), paramIResultWithSecurityCallback);
  }
  
  public static void a(AppRuntime paramAppRuntime, Context paramContext, String paramString1, String paramString2, int paramInt, @Nullable String paramString3, Bundle paramBundle)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(", channelId：");
    ((StringBuilder)localObject).append(paramString3);
    QLog.d("QQJoinGuildHelper", 1, new Object[] { "addGuildAndJump2AIO, guildId=", paramString1, ((StringBuilder)localObject).toString() });
    localObject = new JoinChannelViewModel.JoinChannelParams();
    ((JoinChannelViewModel.JoinChannelParams)localObject).a = paramString1;
    ((JoinChannelViewModel.JoinChannelParams)localObject).c = paramInt;
    ((JoinChannelViewModel.JoinChannelParams)localObject).b = paramString2;
    a(paramAppRuntime, paramContext, (JoinChannelViewModel.JoinChannelParams)localObject, paramString3, paramBundle, new QQJoinGuildHelper.2(paramAppRuntime, paramContext), new QQJoinGuildHelper.3());
  }
  
  public static boolean a(int paramInt, IGProSecurityResult paramIGProSecurityResult)
  {
    return (QQGuildUtil.a(paramIGProSecurityResult)) && ((paramInt == 0) || (paramInt == 22004));
  }
  
  public static boolean a(IGProSecurityResult paramIGProSecurityResult)
  {
    return (paramIGProSecurityResult != null) && (paramIGProSecurityResult.a() == 102L);
  }
  
  private static void b(Context paramContext, IGProSecurityResult paramIGProSecurityResult)
  {
    paramContext = DialogUtil.a(paramContext, 230).setTitle("帐号实名认证").setMessage("为了满足相关法律法规的网络实名制要求，请提供真实信息进行实名认证。").setPositiveButton(2131892267, new QQJoinGuildHelper.6(paramIGProSecurityResult, paramContext)).setNegativeButton(2131887648, new QQJoinGuildHelper.5());
    paramContext.setCancelable(true);
    paramContext.setCanceledOnTouchOutside(true);
    paramContext.show();
  }
  
  private static void b(AppRuntime paramAppRuntime, Context paramContext, JoinChannelViewModel.JoinChannelParams paramJoinChannelParams, String paramString, Bundle paramBundle)
  {
    Object localObject = paramJoinChannelParams.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(", channelId：");
    localStringBuilder.append(paramString);
    QLog.d("QQJoinGuildHelper", 1, new Object[] { "doAddGuildAndJump2AIO, guildId=", localObject, localStringBuilder.toString() });
    localObject = (IGPSService)paramAppRuntime.getRuntimeService(IGPSService.class, "");
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("JoinGuildSource: ");
    localStringBuilder.append(QQGuildJumpSource.a());
    localStringBuilder.append(" - ");
    localStringBuilder.append(QQGuildJumpSource.b());
    localStringBuilder.append(" - ");
    localStringBuilder.append(QQGuildJumpSource.c());
    QLog.i("QQGuildJumpSource", 1, localStringBuilder.toString());
    ((IGPSService)localObject).addGuild(paramJoinChannelParams.a, new GuildSourceId(QQGuildJumpSource.a(), QQGuildJumpSource.b(), QQGuildJumpSource.c()), paramJoinChannelParams.b, new QQJoinGuildHelper.4(paramString, paramAppRuntime, paramContext, paramBundle, paramJoinChannelParams));
  }
  
  private static void b(AppRuntime paramAppRuntime, Context paramContext, String paramString1, String paramString2, Bundle paramBundle)
  {
    paramContext = (IGPSService)paramAppRuntime.getRuntimeService(IGPSService.class, "");
    paramBundle = paramContext.getGuildInfo(paramString1);
    List localList = paramContext.getChannelList(paramString1);
    int i;
    if ((!TextUtils.isEmpty(paramString2)) && (paramContext.getChannelInfo(paramString2) == null)) {
      i = 0;
    } else {
      i = 1;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("openGuild channelInfoList size:");
    if (localList == null) {
      paramAppRuntime = "null";
    } else {
      paramAppRuntime = Integer.valueOf(localList.size());
    }
    localStringBuilder.append(paramAppRuntime);
    localStringBuilder.append(",channelId:");
    localStringBuilder.append(paramString2);
    QLog.i("QQJoinGuildHelper", 1, localStringBuilder.toString());
    if ((paramBundle != null) && (localList != null) && (localList.size() != 0) && (i != 0))
    {
      ((ILaunchGuildChatPieApi)QRoute.api(ILaunchGuildChatPieApi.class)).launchAudioChatPie(BaseApplication.getContext(), paramContext.getGuildInfo(paramString1), paramContext.getChannelInfo(paramString2), true);
      return;
    }
    paramContext.fetchGuildInfo(paramString1, new QQJoinGuildHelper.7(paramContext, paramString1, paramString2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.util.QQJoinGuildHelper
 * JD-Core Version:    0.7.0.1
 */