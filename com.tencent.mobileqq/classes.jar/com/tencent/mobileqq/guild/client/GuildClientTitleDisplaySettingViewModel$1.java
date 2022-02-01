package com.tencent.mobileqq.guild.client;

import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.guild.profilecard.main.ShowToastModel;
import com.tencent.mobileqq.guild.util.SingleLiveEvent;
import com.tencent.mobileqq.qqguildsdk.callback.IGetClientInfoListCallback;
import com.tencent.mobileqq.qqguildsdk.data.IClientInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class GuildClientTitleDisplaySettingViewModel$1
  implements IGetClientInfoListCallback
{
  GuildClientTitleDisplaySettingViewModel$1(GuildClientTitleDisplaySettingViewModel paramGuildClientTitleDisplaySettingViewModel) {}
  
  public void a(int paramInt1, String paramString, int paramInt2, List<IClientInfo> paramList)
  {
    if ((paramInt1 == 0) && (paramList != null))
    {
      if (!paramList.isEmpty())
      {
        GuildClientTitleDisplaySettingViewModel.b(this.a).setValue(paramList);
        paramString = GuildClientTitleDisplaySettingViewModel.d(this.a);
        paramList = this.a;
        paramString.setValue(GuildClientTitleDisplaySettingViewModel.a(paramList, GuildClientTitleDisplaySettingViewModel.c(paramList)));
      }
      return;
    }
    GuildClientTitleDisplaySettingViewModel.a(this.a).setValue(ShowToastModel.a(-952356, paramString));
    QLog.e("GuildClientTitleDisplaySettingViewModel", 1, String.format("requestClientInfoList network error, errorCode: %d, errorMessage: %s", new Object[] { Integer.valueOf(paramInt1), paramString }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.client.GuildClientTitleDisplaySettingViewModel.1
 * JD-Core Version:    0.7.0.1
 */