package com.tencent.mobileqq.guild.usecases;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.guild.error.GuildError;
import com.tencent.mobileqq.guild.util.QQGuildUtil;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.callback.IFetchInviteInfoCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.data.IGuildInviteInfo;

public class FetchGuildInfoUseCase
  implements IFetchInviteInfoCallback
{
  private final String a;
  private final FetchGuildInfoUseCase.ResultCallback b;
  
  public FetchGuildInfoUseCase(String paramString, FetchGuildInfoUseCase.ResultCallback paramResultCallback)
  {
    this.a = paramString;
    this.b = paramResultCallback;
  }
  
  public static void a(String paramString, @NonNull FetchGuildInfoUseCase.ResultCallback paramResultCallback)
  {
    new FetchGuildInfoUseCase(paramString, paramResultCallback).a();
  }
  
  public void a()
  {
    ((IGPSService)QQGuildUtil.a(IGPSService.class, "")).fetchGuildInfoByInviteCode(this.a, this);
  }
  
  public void a(int paramInt, String paramString, IGuildInviteInfo paramIGuildInviteInfo, IGProSecurityResult paramIGProSecurityResult)
  {
    paramString = GuildError.a(paramInt, paramString, paramIGProSecurityResult);
    if (paramInt != 0)
    {
      this.b.a(paramString, new FetchGuildInfoUseCase.GuildInfo());
      return;
    }
    paramIGProSecurityResult = paramIGuildInviteInfo.a();
    String str = paramIGuildInviteInfo.c();
    paramIGuildInviteInfo = paramIGuildInviteInfo.f();
    this.b.a(paramString, new FetchGuildInfoUseCase.GuildInfo(paramIGProSecurityResult, str, paramIGuildInviteInfo));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.usecases.FetchGuildInfoUseCase
 * JD-Core Version:    0.7.0.1
 */