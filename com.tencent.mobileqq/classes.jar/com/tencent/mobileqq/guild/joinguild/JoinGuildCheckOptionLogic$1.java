package com.tencent.mobileqq.guild.joinguild;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.mobileqq.qqguildsdk.callback.IResultWithSecurityCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.qphone.base.util.QLog;

class JoinGuildCheckOptionLogic$1
  implements IResultWithSecurityCallback
{
  JoinGuildCheckOptionLogic$1(JoinGuildCheckOptionLogic paramJoinGuildCheckOptionLogic, JoinGuildCheckOptionLogic.INextStepAction paramINextStepAction, IResultWithSecurityCallback paramIResultWithSecurityCallback) {}
  
  public void a(int paramInt, String paramString, IGProSecurityResult paramIGProSecurityResult)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("queryApplyAddGuildStatus result=");
      localStringBuilder.append(paramInt);
      QLog.i("JoinGuildLogic", 1, localStringBuilder.toString());
    }
    JoinGuildCheckOptionLogic.a(this.c, paramInt);
    if (paramInt == 0)
    {
      JoinGuildCheckOptionLogic.a(this.c, this.a, this.b);
      return;
    }
    if (paramInt == 22008)
    {
      paramString = this.c;
      JoinGuildCheckOptionLogic.a(paramString, this.b, paramInt, JoinGuildCheckOptionLogic.a(paramString).getResources().getString(2131890389), paramIGProSecurityResult);
      return;
    }
    JoinGuildCheckOptionLogic.a(this.c, this.b, paramInt, paramString, paramIGProSecurityResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.joinguild.JoinGuildCheckOptionLogic.1
 * JD-Core Version:    0.7.0.1
 */