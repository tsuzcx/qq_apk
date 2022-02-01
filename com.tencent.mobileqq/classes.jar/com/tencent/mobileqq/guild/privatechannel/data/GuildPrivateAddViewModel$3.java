package com.tencent.mobileqq.guild.privatechannel.data;

import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.guild.util.QQGuildUtil;
import com.tencent.mobileqq.qqguildsdk.callback.IGetInvisibleMemberListCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.List;

class GuildPrivateAddViewModel$3
  implements IGetInvisibleMemberListCallback
{
  GuildPrivateAddViewModel$3(GuildPrivateAddViewModel paramGuildPrivateAddViewModel) {}
  
  public void a(int paramInt, String paramString, boolean paramBoolean, List<IGProUserInfo> paramList)
  {
    if (GuildPrivateAddViewModel.a(this.a)) {
      return;
    }
    GuildPrivateAddViewModel.a(this.a, false);
    GuildPrivateAddViewModel.b(this.a, false);
    if (paramInt != 0)
    {
      paramList = BaseApplication.getContext();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(BaseApplication.getContext().getString(2131890532));
      localStringBuilder.append(":");
      localStringBuilder.append(paramString);
      QQGuildUtil.a(paramList, 2, localStringBuilder.toString());
      GuildPrivateAddViewModel.d(this.a).postValue(null);
      return;
    }
    GuildPrivateAddViewModel.c(this.a, paramBoolean);
    GuildPrivateAddViewModel.d(this.a).postValue(paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.privatechannel.data.GuildPrivateAddViewModel.3
 * JD-Core Version:    0.7.0.1
 */