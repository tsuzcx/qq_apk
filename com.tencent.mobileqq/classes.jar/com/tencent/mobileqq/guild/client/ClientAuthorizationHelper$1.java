package com.tencent.mobileqq.guild.client;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.util.QQGuildSPUtils;
import com.tencent.mobileqq.guild.util.QQGuildUtil;
import com.tencent.mobileqq.qqguildsdk.callback.IGetAppAuthorizationInfoCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProPopupConfigInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProRoleInfo;
import com.tencent.qphone.base.util.QLog;

final class ClientAuthorizationHelper$1
  implements IGetAppAuthorizationInfoCallback
{
  ClientAuthorizationHelper$1(QBaseActivity paramQBaseActivity, GuildClientParams paramGuildClientParams) {}
  
  public void a(int paramInt1, String paramString1, String paramString2, int paramInt2, boolean paramBoolean, IGProPopupConfigInfo paramIGProPopupConfigInfo, IGProRoleInfo paramIGProRoleInfo)
  {
    if (paramInt1 != 0)
    {
      QQGuildUtil.c(this.a.getString(2131890522));
      QLog.e("ClientAuthorizationUtils", 1, String.format("getAppAuthorizationInfo network error, errorCode: %d, errorMessage: %s", new Object[] { Integer.valueOf(paramInt1), paramString1 }));
      return;
    }
    QLog.i("ClientAuthorizationUtils", 1, "getAppAuthorizationInfo success");
    if ((!QQGuildSPUtils.f(paramString2)) && (!paramBoolean) && (paramIGProPopupConfigInfo != null))
    {
      paramString1 = new GuildClientAuthDialogParams(this.b).a(paramIGProPopupConfigInfo.a()).b(paramIGProPopupConfigInfo.b()).d();
      GuildClientAuthorizationDialogFragment.a(this.a, null, paramString1);
      return;
    }
    if ((paramIGProRoleInfo != null) && (!TextUtils.isEmpty(paramIGProRoleInfo.getRoleId())) && (paramIGProRoleInfo.getIsBind()))
    {
      ClientAuthorizationHelper.a(this.a, this.b, true);
      return;
    }
    ClientAuthorizationHelper.b(this.a, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.client.ClientAuthorizationHelper.1
 * JD-Core Version:    0.7.0.1
 */