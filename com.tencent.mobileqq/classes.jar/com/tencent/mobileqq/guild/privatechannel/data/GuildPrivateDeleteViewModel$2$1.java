package com.tencent.mobileqq.guild.privatechannel.data;

import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.qqguildsdk.callback.IGetUserInfoCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class GuildPrivateDeleteViewModel$2$1
  implements IGetUserInfoCallback
{
  GuildPrivateDeleteViewModel$2$1(GuildPrivateDeleteViewModel.2 param2, String paramString) {}
  
  public void onGetUserInfo(int paramInt, String paramString, List<IGProUserInfo> paramList, List<String> paramList1)
  {
    if (paramInt == 0)
    {
      GuildPrivateDeleteViewModel.d(this.b.a).postValue(paramList);
      return;
    }
    paramList = new StringBuilder();
    paramList.append(paramString);
    paramList.append(this.a);
    QLog.i("GuildPrivateDeleteViewModel", 2, paramList.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.privatechannel.data.GuildPrivateDeleteViewModel.2.1
 * JD-Core Version:    0.7.0.1
 */