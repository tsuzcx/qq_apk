package com.tencent.mobileqq.guild.client;

import android.text.TextUtils;
import com.tencent.mobileqq.guild.profilecard.main.ShowToastModel;
import com.tencent.mobileqq.guild.util.SingleLiveEvent;
import com.tencent.mobileqq.qqguildsdk.callback.IGetAppRoleListCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProRoleInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class GuildClientAuthorizationAbstractViewModel$2
  implements IGetAppRoleListCallback
{
  GuildClientAuthorizationAbstractViewModel$2(GuildClientAuthorizationAbstractViewModel paramGuildClientAuthorizationAbstractViewModel) {}
  
  public void a(int paramInt, String paramString1, String paramString2, List<IGProRoleInfo> paramList, String paramString3, String paramString4)
  {
    if (paramInt != 0)
    {
      GuildClientAuthorizationAbstractViewModel.a(this.a).postValue(ShowToastModel.a(paramInt, paramString1));
      QLog.e("GuildClientAuthorizationViewModel", 1, String.format("getAppRoleList network error, errorCode: %d, errorMessage: %s", new Object[] { Integer.valueOf(paramInt), paramString1 }));
      return;
    }
    QLog.d("GuildClientAuthorizationViewModel", 1, "requestClientRoleList success：");
    if ((paramList.isEmpty()) && (!TextUtils.isEmpty(paramString4)))
    {
      GuildClientAuthorizationAbstractViewModel.a(this.a).postValue(ShowToastModel.a(-952354, paramString4));
      return;
    }
    if (paramList.size() == 1)
    {
      this.a.a((IGProRoleInfo)paramList.get(0));
      return;
    }
    paramString1 = new GuildClientRoleInfo(paramList, paramString3);
    GuildClientAuthorizationAbstractViewModel.c(this.a).postValue(paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.client.GuildClientAuthorizationAbstractViewModel.2
 * JD-Core Version:    0.7.0.1
 */