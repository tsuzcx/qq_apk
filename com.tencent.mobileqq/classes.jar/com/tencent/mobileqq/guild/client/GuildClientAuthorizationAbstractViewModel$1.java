package com.tencent.mobileqq.guild.client;

import com.tencent.mobileqq.guild.profilecard.main.ShowToastModel;
import com.tencent.mobileqq.guild.util.QQGuildSPUtils;
import com.tencent.mobileqq.guild.util.SingleLiveEvent;
import com.tencent.mobileqq.qqguildsdk.callback.IAppAuthorizationCallback;
import com.tencent.qphone.base.util.QLog;

class GuildClientAuthorizationAbstractViewModel$1
  implements IAppAuthorizationCallback
{
  GuildClientAuthorizationAbstractViewModel$1(GuildClientAuthorizationAbstractViewModel paramGuildClientAuthorizationAbstractViewModel) {}
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    if (paramInt != 0)
    {
      GuildClientAuthorizationAbstractViewModel.a(this.a).postValue(ShowToastModel.a(paramInt, paramString1));
      QLog.e("GuildClientAuthorizationViewModel", 1, String.format("appAuthorization network error, errorCode: %d, errorMessage: %s", new Object[] { Integer.valueOf(paramInt), paramString1 }));
      return;
    }
    QLog.i("GuildClientAuthorizationViewModel", 1, "requestClientAuthorization success：");
    QQGuildSPUtils.e(paramString2);
    GuildClientAuthorizationAbstractViewModel.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.client.GuildClientAuthorizationAbstractViewModel.1
 * JD-Core Version:    0.7.0.1
 */