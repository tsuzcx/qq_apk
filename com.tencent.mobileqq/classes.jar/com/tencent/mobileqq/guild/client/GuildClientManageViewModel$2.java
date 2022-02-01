package com.tencent.mobileqq.guild.client;

import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.qqguildsdk.callback.IGetClientInfoListCallback;
import com.tencent.mobileqq.qqguildsdk.data.IClientInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class GuildClientManageViewModel$2
  implements IGetClientInfoListCallback
{
  GuildClientManageViewModel$2(GuildClientManageViewModel paramGuildClientManageViewModel) {}
  
  public void a(int paramInt1, String paramString, int paramInt2, List<IClientInfo> paramList)
  {
    if ((paramInt1 == 0) && (!paramList.isEmpty()))
    {
      GuildClientManageViewModel.b(this.a).setValue(new GuildClientManageViewModel.ClientInfo(((IClientInfo)paramList.get(0)).a(), ((IClientInfo)paramList.get(0)).b()));
      return;
    }
    QLog.e("GuildClientManageViewModel", 1, String.format("requestClientInfoList network error, errorCode: %d, errorMessage: %s", new Object[] { Integer.valueOf(paramInt1), paramString }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.client.GuildClientManageViewModel.2
 * JD-Core Version:    0.7.0.1
 */