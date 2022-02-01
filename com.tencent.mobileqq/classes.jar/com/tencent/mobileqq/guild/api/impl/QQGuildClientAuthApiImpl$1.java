package com.tencent.mobileqq.guild.api.impl;

import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.client.GuildAIOClientAuthorizationDialogFragment;
import com.tencent.mobileqq.guild.client.GuildClientAuthDialogParams;
import com.tencent.mobileqq.guild.client.GuildClientParams;
import com.tencent.mobileqq.qqguildsdk.callback.IGetAppAuthorizationInfoCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProPopupConfigInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProRoleInfo;
import com.tencent.qphone.base.util.QLog;

class QQGuildClientAuthApiImpl$1
  implements IGetAppAuthorizationInfoCallback
{
  QQGuildClientAuthApiImpl$1(QQGuildClientAuthApiImpl paramQQGuildClientAuthApiImpl, String paramString, QBaseActivity paramQBaseActivity) {}
  
  public void a(int paramInt1, String paramString1, String paramString2, int paramInt2, boolean paramBoolean, IGProPopupConfigInfo paramIGProPopupConfigInfo, IGProRoleInfo paramIGProRoleInfo)
  {
    if (paramInt1 != 0)
    {
      paramString2 = new StringBuilder();
      paramString2.append("onGetAppAuthorizationInfo failed result=");
      paramString2.append(paramInt1);
      paramString2.append(" error=");
      paramString2.append(paramString1);
      QLog.w("QQGuildAppAuthApiImpl", 1, paramString2.toString());
      return;
    }
    if ((!paramBoolean) && (paramIGProPopupConfigInfo != null))
    {
      paramString1 = (GuildClientAuthDialogParams)new GuildClientAuthDialogParams().a(paramIGProPopupConfigInfo.a()).b(paramIGProPopupConfigInfo.b()).c(paramIGProPopupConfigInfo.c()).g(paramString2).d(this.a).a(2).e();
      GuildAIOClientAuthorizationDialogFragment.a(this.b, paramString1);
      return;
    }
    paramString2 = new StringBuilder();
    paramString2.append("onGetAppAuthorizationInfo failed result=");
    paramString2.append(paramInt1);
    paramString2.append(" error=");
    paramString2.append(paramString1);
    QLog.w("QQGuildAppAuthApiImpl", 1, paramString2.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.api.impl.QQGuildClientAuthApiImpl.1
 * JD-Core Version:    0.7.0.1
 */