package com.tencent.mobileqq.guild.usecases;

import com.tencent.mobileqq.guild.error.GuildError;
import com.tencent.mobileqq.qqguildsdk.callback.IResultWithSecurityCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;

class JoinGuildUseCase$AddGuildCallback
  implements IResultWithSecurityCallback
{
  private JoinGuildUseCase$AddGuildCallback(JoinGuildUseCase paramJoinGuildUseCase) {}
  
  public void a(int paramInt, String paramString, IGProSecurityResult paramIGProSecurityResult)
  {
    if (JoinGuildUseCase.a(this.a, paramInt, paramString, paramIGProSecurityResult)) {
      return;
    }
    JoinGuildUseCase.b(this.a).a(GuildError.a(paramString), JoinGuildUseCase.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.usecases.JoinGuildUseCase.AddGuildCallback
 * JD-Core Version:    0.7.0.1
 */