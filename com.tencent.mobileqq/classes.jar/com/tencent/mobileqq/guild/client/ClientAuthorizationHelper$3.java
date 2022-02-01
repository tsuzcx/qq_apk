package com.tencent.mobileqq.guild.client;

import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.util.QQGuildUtil;
import com.tencent.mobileqq.qqguildsdk.callback.IBindAppRoleCallback;
import com.tencent.qphone.base.util.QLog;

final class ClientAuthorizationHelper$3
  implements IBindAppRoleCallback
{
  ClientAuthorizationHelper$3(QBaseActivity paramQBaseActivity, GuildClientParams paramGuildClientParams) {}
  
  public void a(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2)
  {
    if (paramInt1 != 0)
    {
      QQGuildUtil.c("网络错误");
      QLog.e("ClientAuthorizationUtils", 1, String.format("bindAppRole network error, errorCode: %d, errorMessage: %s", new Object[] { Integer.valueOf(paramInt1), paramString1 }));
      return;
    }
    QLog.i("ClientAuthorizationUtils", 1, "requestBindClientRole success");
    ClientAuthorizationHelper.a(this.a, this.b, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.client.ClientAuthorizationHelper.3
 * JD-Core Version:    0.7.0.1
 */