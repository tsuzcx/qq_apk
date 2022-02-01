package com.tencent.mobileqq.guild.client;

import android.text.TextUtils;
import com.tencent.mobileqq.guild.profilecard.main.ShowToastModel;
import com.tencent.mobileqq.guild.util.SingleLiveEvent;
import com.tencent.mobileqq.qqguildsdk.callback.IGetAppRoleListCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProRoleInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class GuildClientManageViewModel$5
  implements IGetAppRoleListCallback
{
  GuildClientManageViewModel$5(GuildClientManageViewModel paramGuildClientManageViewModel) {}
  
  public void a(int paramInt, String paramString1, String paramString2, List<IGProRoleInfo> paramList, String paramString3, String paramString4)
  {
    if (paramInt != 0)
    {
      GuildClientManageViewModel.g(this.a).setValue(ShowToastModel.a(paramInt, paramString1));
      QLog.e("GuildClientManageViewModel", 1, String.format("getAppRoleList network error, errorCode: %d, errorMessage: %s", new Object[] { Integer.valueOf(paramInt), paramString1 }));
      return;
    }
    if ((paramList.isEmpty()) && (!TextUtils.isEmpty(paramString4)))
    {
      GuildClientManageViewModel.g(this.a).setValue(ShowToastModel.a(-952354, paramString4));
      return;
    }
    if (paramList.size() == 1)
    {
      this.a.a((IGProRoleInfo)paramList.get(0));
      return;
    }
    paramString1 = new GuildClientRoleInfo(paramList, paramString3);
    GuildClientManageViewModel.i(this.a).setValue(paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.client.GuildClientManageViewModel.5
 * JD-Core Version:    0.7.0.1
 */