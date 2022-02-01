package com.tencent.mobileqq.guild.privatechannel.data;

import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.qqguildsdk.callback.ISearchVisibleMemberListCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class GuildPrivateAddViewModel$5
  implements ISearchVisibleMemberListCallback
{
  GuildPrivateAddViewModel$5(GuildPrivateAddViewModel paramGuildPrivateAddViewModel) {}
  
  public void onSearchVisibleMemberList(int paramInt, String paramString, List<IGProUserInfo> paramList)
  {
    if (GuildPrivateAddViewModel.a(this.a)) {
      return;
    }
    if (paramInt != 0)
    {
      QLog.e("GuildPrivateAddViewModel", 1, paramString);
      return;
    }
    if ((paramList != null) && (paramList.size() > 0)) {
      GuildPrivateAddViewModel.g(this.a).postValue(paramList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.privatechannel.data.GuildPrivateAddViewModel.5
 * JD-Core Version:    0.7.0.1
 */