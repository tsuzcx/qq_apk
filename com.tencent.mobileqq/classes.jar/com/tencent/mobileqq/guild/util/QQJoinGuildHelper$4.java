package com.tencent.mobileqq.guild.util;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.guild.mainframe.joinchannel.JoinChannelViewModel.JoinChannelParams;
import com.tencent.mobileqq.qqguildsdk.callback.IResultWithSecurityCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

final class QQJoinGuildHelper$4
  implements IResultWithSecurityCallback
{
  QQJoinGuildHelper$4(String paramString, AppRuntime paramAppRuntime, Context paramContext, Bundle paramBundle, JoinChannelViewModel.JoinChannelParams paramJoinChannelParams) {}
  
  public void a(int paramInt, String paramString, IGProSecurityResult paramIGProSecurityResult)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramIGProSecurityResult);
    localStringBuilder.append("，channelId：");
    localStringBuilder.append(this.a);
    QLog.d("QQJoinGuildHelper", 1, new Object[] { "addGuild, result=", Integer.valueOf(paramInt), ", errMsg=", paramString, ",security:", localStringBuilder.toString() });
    if (QQJoinGuildHelper.a(paramInt, paramIGProSecurityResult))
    {
      if ((!TextUtils.isEmpty(this.a)) && (!this.a.equals("0")))
      {
        QQJoinGuildHelper.a(this.b, this.c, this.e.a, this.a, this.d);
        return;
      }
      QQGuildUtil.a(this.b, this.c, this.d, false, this.e.a);
      return;
    }
    if (QQJoinGuildHelper.a(paramIGProSecurityResult))
    {
      QQJoinGuildHelper.a(this.c, paramIGProSecurityResult);
      return;
    }
    QQGuildUtil.a(this.c, paramInt, BaseApplication.getContext().getString(2131890217), paramIGProSecurityResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.util.QQJoinGuildHelper.4
 * JD-Core Version:    0.7.0.1
 */