package com.tencent.mobileqq.guild.client;

import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.guild.profilecard.main.ShowToastModel;
import com.tencent.mobileqq.guild.util.SingleLiveEvent;
import com.tencent.mobileqq.qqguildsdk.callback.IBindAppRoleCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProRoleInfo;
import com.tencent.qphone.base.util.QLog;

class GuildClientManageViewModel$4
  implements IBindAppRoleCallback
{
  GuildClientManageViewModel$4(GuildClientManageViewModel paramGuildClientManageViewModel, IGProRoleInfo paramIGProRoleInfo) {}
  
  public void a(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2)
  {
    if (paramInt1 != 0)
    {
      GuildClientManageViewModel.g(this.b).setValue(ShowToastModel.a(paramInt1, paramString1));
      QLog.e("GuildClientManageViewModel", 1, String.format("bindAppRole network error, errorCode: %d, errorMessage: %s", new Object[] { Integer.valueOf(paramInt1), paramString1 }));
      return;
    }
    GuildClientManageViewModel.c(this.b).setValue(new GuildClientManageViewModel.RoleInfo(true, this.a.getRoleName(), paramString3));
    this.b.k();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.client.GuildClientManageViewModel.4
 * JD-Core Version:    0.7.0.1
 */