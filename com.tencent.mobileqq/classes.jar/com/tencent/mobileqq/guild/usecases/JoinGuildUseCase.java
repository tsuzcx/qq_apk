package com.tencent.mobileqq.guild.usecases;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.guild.error.GuildError;
import com.tencent.mobileqq.guild.source.QQGuildJumpSource;
import com.tencent.mobileqq.guild.util.QQGuildUtil;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.GuildSourceId;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;

public class JoinGuildUseCase
{
  private final IGPSService a;
  private final String b;
  private final String c;
  private final JoinGuildUseCase.ResultCallback d;
  private final int e;
  private final JoinGuildUseCase.AddGuildCallback f = new JoinGuildUseCase.AddGuildCallback(this, null);
  private final JoinGuildUseCase.FetchSignatureCallback g = new JoinGuildUseCase.FetchSignatureCallback(this, null);
  private String h;
  
  private JoinGuildUseCase(String paramString1, String paramString2, String paramString3, int paramInt, JoinGuildUseCase.ResultCallback paramResultCallback)
  {
    this.h = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.e = paramInt;
    this.d = paramResultCallback;
    this.a = ((IGPSService)QQGuildUtil.a(IGPSService.class, ""));
  }
  
  private void a()
  {
    if (!TextUtils.isEmpty(this.b))
    {
      this.a.fetchGuildInfoByInviteCode(this.b, this.g);
      return;
    }
    if ((!TextUtils.isEmpty(this.h)) && (!TextUtils.isEmpty(this.c)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("JoinGuildSource: ");
      localStringBuilder.append(QQGuildJumpSource.a());
      localStringBuilder.append(" - ");
      localStringBuilder.append(QQGuildJumpSource.b());
      localStringBuilder.append(" - ");
      localStringBuilder.append(QQGuildJumpSource.c());
      QLog.i("QQGuildJumpSource", 1, localStringBuilder.toString());
      this.a.addGuild(this.h, new GuildSourceId(QQGuildJumpSource.a(), QQGuildJumpSource.b(), QQGuildJumpSource.c()), this.c, this.f);
      return;
    }
    throw new NullPointerException(String.format(Locale.getDefault(), "invite: %s, guildId: %s, signature: %s", new Object[] { this.b, this.h, this.c }));
  }
  
  public static void a(@NonNull String paramString, int paramInt, @NonNull JoinGuildUseCase.ResultCallback paramResultCallback)
  {
    new JoinGuildUseCase(null, paramString, null, paramInt, paramResultCallback).a();
  }
  
  public static void a(@NonNull String paramString1, @NonNull String paramString2, int paramInt, @NonNull JoinGuildUseCase.ResultCallback paramResultCallback)
  {
    new JoinGuildUseCase(paramString1, null, paramString2, paramInt, paramResultCallback).a();
  }
  
  private boolean a(int paramInt, String paramString, IGProSecurityResult paramIGProSecurityResult)
  {
    paramIGProSecurityResult = GuildError.a(paramInt, paramString, paramIGProSecurityResult);
    if (!paramIGProSecurityResult.a())
    {
      QLog.w("JoinGuildUseCase", 1, String.format(Locale.getDefault(), "dispatchError, errorCode=%s message=%s", new Object[] { Integer.valueOf(paramInt), paramString }));
      this.d.a(paramIGProSecurityResult, this.h);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.usecases.JoinGuildUseCase
 * JD-Core Version:    0.7.0.1
 */