package com.tencent.mobileqq.guild.client;

import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.guild.profilecard.main.ShowToastModel;
import com.tencent.mobileqq.guild.util.SingleLiveEvent;
import com.tencent.mobileqq.qqguildsdk.callback.ISetGuildClientIdCallback;
import com.tencent.qphone.base.util.QLog;

class GuildClientTitleDisplaySettingViewModel$2
  implements ISetGuildClientIdCallback
{
  GuildClientTitleDisplaySettingViewModel$2(GuildClientTitleDisplaySettingViewModel paramGuildClientTitleDisplaySettingViewModel) {}
  
  public void a(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    if (paramInt != 0)
    {
      GuildClientTitleDisplaySettingViewModel.a(this.a).setValue(ShowToastModel.a(-952358, paramString1));
      QLog.e("GuildClientTitleDisplaySettingViewModel", 1, String.format("requestClientInfoList network error, errorCode: %d, errorMessage: %s", new Object[] { Integer.valueOf(paramInt), paramString1 }));
    }
    else
    {
      GuildClientTitleDisplaySettingViewModel.b(this.a, paramString3);
    }
    paramString1 = GuildClientTitleDisplaySettingViewModel.d(this.a);
    paramString2 = this.a;
    paramString1.setValue(GuildClientTitleDisplaySettingViewModel.a(paramString2, GuildClientTitleDisplaySettingViewModel.c(paramString2)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.client.GuildClientTitleDisplaySettingViewModel.2
 * JD-Core Version:    0.7.0.1
 */