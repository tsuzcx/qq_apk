package com.tencent.mobileqq.guild.privatechannel.data;

import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.qqguildsdk.callback.IGetUserInfoCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class GuildPrivateAddViewModel$2$1
  implements IGetUserInfoCallback
{
  GuildPrivateAddViewModel$2$1(GuildPrivateAddViewModel.2 param2, String paramString) {}
  
  public void onGetUserInfo(int paramInt, String paramString, List<IGProUserInfo> paramList, List<String> paramList1)
  {
    if (GuildPrivateAddViewModel.a(this.b.a)) {
      return;
    }
    if (paramInt == 0)
    {
      GuildPrivateAddViewModel.d(this.b.a).postValue(paramList);
      return;
    }
    paramList = new StringBuilder();
    paramList.append(paramString);
    paramList.append(this.a);
    QLog.i("GuildPrivateAddViewModel", 2, paramList.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.privatechannel.data.GuildPrivateAddViewModel.2.1
 * JD-Core Version:    0.7.0.1
 */