package com.tencent.mobileqq.guild.privatechannel.data;

import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.guild.util.QQGuildUtil;
import com.tencent.mobileqq.qqguildsdk.callback.IGetVisibleMemberListCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.List;

class GuildPrivateDeleteViewModel$3
  implements IGetVisibleMemberListCallback
{
  GuildPrivateDeleteViewModel$3(GuildPrivateDeleteViewModel paramGuildPrivateDeleteViewModel) {}
  
  public void a(int paramInt1, String paramString, int paramInt2, boolean paramBoolean, List<IGProUserInfo> paramList)
  {
    if (GuildPrivateDeleteViewModel.a(this.a)) {
      return;
    }
    GuildPrivateDeleteViewModel.a(this.a, false);
    GuildPrivateDeleteViewModel.b(this.a, false);
    if (paramInt1 != 0)
    {
      paramList = BaseApplication.getContext();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(BaseApplication.getContext().getString(2131890532));
      localStringBuilder.append(":");
      localStringBuilder.append(paramString);
      QQGuildUtil.a(paramList, 2, localStringBuilder.toString());
      GuildPrivateDeleteViewModel.d(this.a).postValue(null);
      return;
    }
    GuildPrivateDeleteViewModel.c(this.a, paramBoolean);
    GuildPrivateDeleteViewModel.d(this.a).postValue(paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.privatechannel.data.GuildPrivateDeleteViewModel.3
 * JD-Core Version:    0.7.0.1
 */