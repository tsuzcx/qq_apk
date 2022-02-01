package com.tencent.mobileqq.guild.client;

import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.guild.profilecard.main.ShowToastModel;
import com.tencent.mobileqq.guild.util.SingleLiveEvent;
import com.tencent.mobileqq.qqguildsdk.callback.IGetAppAuthorizationInfoCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProPopupConfigInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProRoleInfo;
import com.tencent.qphone.base.util.QLog;

class GuildClientManageViewModel$3
  implements IGetAppAuthorizationInfoCallback
{
  GuildClientManageViewModel$3(GuildClientManageViewModel paramGuildClientManageViewModel) {}
  
  public void a(int paramInt1, String paramString1, String paramString2, int paramInt2, boolean paramBoolean, IGProPopupConfigInfo paramIGProPopupConfigInfo, IGProRoleInfo paramIGProRoleInfo)
  {
    if (paramInt1 != 0)
    {
      GuildClientManageViewModel.g(this.a).setValue(ShowToastModel.a(paramInt1, paramString1));
      QLog.e("GuildClientManageViewModel", 1, String.format("getAppAuthorizationInfo network error, errorCode: %d, errorMessage: %s", new Object[] { Integer.valueOf(paramInt1), paramString1 }));
      return;
    }
    if ((!paramBoolean) && (paramIGProPopupConfigInfo != null))
    {
      GuildClientManageViewModel.h(this.a).setValue(paramIGProPopupConfigInfo);
      return;
    }
    if ((paramIGProRoleInfo != null) && (!TextUtils.isEmpty(paramIGProRoleInfo.getRoleId())) && (paramIGProRoleInfo.getIsBind()))
    {
      GuildClientManageViewModel.c(this.a).setValue(new GuildClientManageViewModel.RoleInfo(true, paramIGProRoleInfo.getRoleName(), paramIGProRoleInfo.getRoleId()));
      return;
    }
    this.a.m();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.client.GuildClientManageViewModel.3
 * JD-Core Version:    0.7.0.1
 */