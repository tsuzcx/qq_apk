package com.tencent.mobileqq.guild.util;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.guild.joinguild.JoinGuildCheckOptionLogic.INextStepAction;
import com.tencent.mobileqq.guild.mainframe.joinchannel.JoinChannelViewModel;
import com.tencent.mobileqq.guild.mainframe.joinchannel.JoinChannelViewModel.JoinChannelParams;
import com.tencent.mobileqq.qqguildsdk.callback.IResultWithSecurityCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

final class QQJoinGuildHelper$2
  implements JoinGuildCheckOptionLogic.INextStepAction
{
  QQJoinGuildHelper$2(AppRuntime paramAppRuntime, Context paramContext) {}
  
  public void a(Context paramContext, int paramInt1, int paramInt2, String paramString1, IGProSecurityResult paramIGProSecurityResult, JoinChannelViewModel.JoinChannelParams paramJoinChannelParams, String paramString2, Bundle paramBundle)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("，channelId：");
      localStringBuilder.append(paramString2);
      QLog.d("QQJoinGuildHelper", 1, new Object[] { "handleJoinResult, result=", Integer.valueOf(paramInt2), ", errMsg=", paramString1, localStringBuilder.toString(), " addGuildOptionType=", Integer.valueOf(paramInt1) });
    }
    if (JoinChannelViewModel.a(paramInt2)) {
      return;
    }
    if (QQJoinGuildHelper.a(paramInt2, paramIGProSecurityResult))
    {
      if (paramInt1 != 5)
      {
        if (paramInt1 == 2) {
          return;
        }
        if ((!TextUtils.isEmpty(paramString2)) && (!paramString2.equals("0")))
        {
          QQJoinGuildHelper.a(this.a, paramContext, paramJoinChannelParams.a, paramString2, paramBundle);
          return;
        }
        QQGuildUtil.a(this.a, paramContext, paramBundle, false, paramJoinChannelParams.a);
      }
    }
    else
    {
      if (QQJoinGuildHelper.a(paramIGProSecurityResult))
      {
        QQJoinGuildHelper.a(paramContext, paramIGProSecurityResult);
        return;
      }
      QQGuildUtil.a(paramContext, paramInt2, BaseApplication.getContext().getString(2131890217), paramIGProSecurityResult);
    }
  }
  
  public void a(JoinChannelViewModel.JoinChannelParams paramJoinChannelParams, String paramString, Bundle paramBundle, IResultWithSecurityCallback paramIResultWithSecurityCallback)
  {
    QQJoinGuildHelper.a(this.a, this.b, paramJoinChannelParams, paramString, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.util.QQJoinGuildHelper.2
 * JD-Core Version:    0.7.0.1
 */