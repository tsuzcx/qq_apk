package com.tencent.mobileqq.guild.client;

import android.os.Handler;
import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.guild.profilecard.main.ShowToastModel;
import com.tencent.mobileqq.guild.util.SingleLiveEvent;
import com.tencent.mobileqq.qqguildsdk.callback.IBindAppRoleCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProRoleInfo;
import com.tencent.qphone.base.util.QLog;

class GuildClientAuthorizationAbstractViewModel$3
  implements IBindAppRoleCallback
{
  GuildClientAuthorizationAbstractViewModel$3(GuildClientAuthorizationAbstractViewModel paramGuildClientAuthorizationAbstractViewModel, IGProRoleInfo paramIGProRoleInfo) {}
  
  public void a(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2)
  {
    if (paramInt1 != 0)
    {
      GuildClientAuthorizationAbstractViewModel.a(this.b).postValue(ShowToastModel.a(paramInt1, paramString1));
      QLog.e("GuildClientAuthorizationViewModel", 1, String.format("bindAppRole network error, errorCode: %d, errorMessage: %s", new Object[] { Integer.valueOf(paramInt1), paramString1 }));
      return;
    }
    QLog.i("GuildClientAuthorizationViewModel", 1, "requestBindClientRole success：");
    this.b.h();
    GuildClientAuthorizationAbstractViewModel.a(this.b).postValue(ShowToastModel.a(0, ""));
    GuildClientAuthorizationAbstractViewModel.d(this.b).postValue(new GuildClientManageViewModel.RoleInfo(true, this.a.getRoleName(), paramString3));
    GuildClientAuthorizationAbstractViewModel.e(this.b).postDelayed(new GuildClientAuthorizationAbstractViewModel.3.1(this), 2000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.client.GuildClientAuthorizationAbstractViewModel.3
 * JD-Core Version:    0.7.0.1
 */