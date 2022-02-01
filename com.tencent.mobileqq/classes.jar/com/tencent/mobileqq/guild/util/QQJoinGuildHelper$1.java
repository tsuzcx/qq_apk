package com.tencent.mobileqq.guild.util;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.guild.joinguild.JoinGuildCheckOptionLogic.INextStepAction;
import com.tencent.mobileqq.guild.mainframe.joinchannel.JoinChannelViewModel.JoinChannelParams;
import com.tencent.mobileqq.guild.source.QQGuildJumpSource;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.callback.IResultWithSecurityCallback;
import com.tencent.mobileqq.qqguildsdk.data.GuildSourceId;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

final class QQJoinGuildHelper$1
  implements JoinGuildCheckOptionLogic.INextStepAction
{
  QQJoinGuildHelper$1(String paramString1, AppRuntime paramAppRuntime, String paramString2, IResultWithSecurityCallback paramIResultWithSecurityCallback) {}
  
  public void a(Context paramContext, int paramInt1, int paramInt2, String paramString1, IGProSecurityResult paramIGProSecurityResult, JoinChannelViewModel.JoinChannelParams paramJoinChannelParams, String paramString2, Bundle paramBundle)
  {
    this.d.a(paramInt2, paramString1, paramIGProSecurityResult);
  }
  
  public void a(JoinChannelViewModel.JoinChannelParams paramJoinChannelParams, String paramString, Bundle paramBundle, IResultWithSecurityCallback paramIResultWithSecurityCallback)
  {
    QLog.d("QQJoinGuildHelper", 1, new Object[] { "doAddGuild, guildId=", this.a });
    paramJoinChannelParams = (IGPSService)this.b.getRuntimeService(IGPSService.class, "");
    paramString = new StringBuilder();
    paramString.append("JoinGuildSource: ");
    paramString.append(QQGuildJumpSource.a());
    paramString.append(" - ");
    paramString.append(QQGuildJumpSource.b());
    paramString.append(" - ");
    paramString.append(QQGuildJumpSource.c());
    QLog.i("QQGuildJumpSource", 1, paramString.toString());
    paramJoinChannelParams.addGuild(this.a, new GuildSourceId(QQGuildJumpSource.a(), QQGuildJumpSource.b(), QQGuildJumpSource.c()), this.c, new QQJoinGuildHelper.1.1(this, paramIResultWithSecurityCallback));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.util.QQJoinGuildHelper.1
 * JD-Core Version:    0.7.0.1
 */