package com.tencent.mobileqq.guild.client;

import android.os.Handler;
import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.guild.profilecard.main.ShowToastModel;
import com.tencent.mobileqq.guild.util.SingleLiveEvent;
import com.tencent.mobileqq.qqguildsdk.callback.IBindAppRoleCallback;
import com.tencent.qphone.base.util.QLog;

class GuildClientSelectRoleViewModel$1
  implements IBindAppRoleCallback
{
  GuildClientSelectRoleViewModel$1(GuildClientSelectRoleViewModel paramGuildClientSelectRoleViewModel, GuildClientRoleInfo.RoleInfo paramRoleInfo) {}
  
  public void a(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2)
  {
    if (paramInt1 != 0)
    {
      this.b.a.postValue(ShowToastModel.a(paramInt1, paramString1));
      QLog.e("GuildClientSelectRoleViewModel", 1, String.format("bindAppRole network error, errorCode: %d, errorMessage: %s", new Object[] { Integer.valueOf(paramInt1), paramString1 }));
      return;
    }
    QLog.i("GuildClientSelectRoleViewModel", 1, "requestBindClientRole success");
    this.b.a.postValue(ShowToastModel.a(0, ""));
    GuildClientSelectRoleViewModel.a(this.b).postValue(new GuildClientManageViewModel.RoleInfo(true, this.a.b(), paramString3));
    GuildClientSelectRoleViewModel.b(this.b).postDelayed(new GuildClientSelectRoleViewModel.1.1(this), 2000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.client.GuildClientSelectRoleViewModel.1
 * JD-Core Version:    0.7.0.1
 */