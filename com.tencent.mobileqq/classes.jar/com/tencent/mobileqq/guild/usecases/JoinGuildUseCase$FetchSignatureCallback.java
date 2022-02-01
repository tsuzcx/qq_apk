package com.tencent.mobileqq.guild.usecases;

import com.tencent.mobileqq.guild.source.QQGuildJumpSource;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.callback.IFetchInviteInfoCallback;
import com.tencent.mobileqq.qqguildsdk.data.GuildSourceId;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.data.IGuildInviteInfo;
import com.tencent.qphone.base.util.QLog;

class JoinGuildUseCase$FetchSignatureCallback
  implements IFetchInviteInfoCallback
{
  private JoinGuildUseCase$FetchSignatureCallback(JoinGuildUseCase paramJoinGuildUseCase) {}
  
  public void a(int paramInt, String paramString, IGuildInviteInfo paramIGuildInviteInfo, IGProSecurityResult paramIGProSecurityResult)
  {
    if (JoinGuildUseCase.a(this.a, paramInt, paramString, paramIGProSecurityResult)) {
      return;
    }
    JoinGuildUseCase.a(this.a, paramIGuildInviteInfo.a());
    paramString = paramIGuildInviteInfo.f();
    paramIGuildInviteInfo = new StringBuilder();
    paramIGuildInviteInfo.append("JoinGuildSource: ");
    paramIGuildInviteInfo.append(QQGuildJumpSource.a());
    paramIGuildInviteInfo.append(" - ");
    paramIGuildInviteInfo.append(QQGuildJumpSource.b());
    paramIGuildInviteInfo.append(" - ");
    paramIGuildInviteInfo.append(QQGuildJumpSource.c());
    QLog.i("QQGuildJumpSource", 1, paramIGuildInviteInfo.toString());
    JoinGuildUseCase.d(this.a).addGuild(JoinGuildUseCase.a(this.a), new GuildSourceId(QQGuildJumpSource.a(), QQGuildJumpSource.b(), QQGuildJumpSource.c()), paramString, JoinGuildUseCase.c(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.usecases.JoinGuildUseCase.FetchSignatureCallback
 * JD-Core Version:    0.7.0.1
 */