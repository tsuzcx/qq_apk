package com.tencent.mobileqq.guild.joinguild;

import com.tencent.mobileqq.qqguildsdk.callback.IResultWithSecurityCallback;
import com.tencent.mobileqq.qqguildsdk.data.AddGuildOption;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;

class JoinGuildCheckOptionLogic$3
  implements IResultWithSecurityCallback
{
  JoinGuildCheckOptionLogic$3(JoinGuildCheckOptionLogic paramJoinGuildCheckOptionLogic, JoinGuildCheckOptionLogic.INextStepAction paramINextStepAction) {}
  
  public void a(int paramInt, String paramString, IGProSecurityResult paramIGProSecurityResult)
  {
    this.a.a(JoinGuildCheckOptionLogic.a(this.b), JoinGuildCheckOptionLogic.e(this.b).a, paramInt, paramString, paramIGProSecurityResult, JoinGuildCheckOptionLogic.b(this.b), JoinGuildCheckOptionLogic.c(this.b), JoinGuildCheckOptionLogic.d(this.b));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.joinguild.JoinGuildCheckOptionLogic.3
 * JD-Core Version:    0.7.0.1
 */