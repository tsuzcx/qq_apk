package com.tencent.mobileqq.guild.privatechannel.data;

import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.guild.util.QQGuildUtil;
import com.tencent.mobileqq.qqguildsdk.callback.IResultWithSecurityCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;

class GuildPrivateDeleteViewModel$4
  implements IResultWithSecurityCallback
{
  GuildPrivateDeleteViewModel$4(GuildPrivateDeleteViewModel paramGuildPrivateDeleteViewModel, IResultWithSecurityCallback paramIResultWithSecurityCallback, String paramString) {}
  
  public void a(int paramInt, String paramString, IGProSecurityResult paramIGProSecurityResult)
  {
    if (GuildPrivateDeleteViewModel.a(this.c)) {
      return;
    }
    IResultWithSecurityCallback localIResultWithSecurityCallback = this.a;
    if (localIResultWithSecurityCallback != null) {
      localIResultWithSecurityCallback.a(paramInt, paramString, paramIGProSecurityResult);
    }
    if ((paramInt == 0) && (QQGuildUtil.a(paramIGProSecurityResult))) {
      GuildPrivateDeleteViewModel.f(this.c).postValue(this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.privatechannel.data.GuildPrivateDeleteViewModel.4
 * JD-Core Version:    0.7.0.1
 */