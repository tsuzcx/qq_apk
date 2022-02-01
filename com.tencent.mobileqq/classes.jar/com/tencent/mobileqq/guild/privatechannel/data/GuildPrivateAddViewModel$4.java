package com.tencent.mobileqq.guild.privatechannel.data;

import com.tencent.mobileqq.qqguildsdk.callback.IResultWithSecurityCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;

class GuildPrivateAddViewModel$4
  implements IResultWithSecurityCallback
{
  GuildPrivateAddViewModel$4(GuildPrivateAddViewModel paramGuildPrivateAddViewModel, IResultWithSecurityCallback paramIResultWithSecurityCallback) {}
  
  public void a(int paramInt, String paramString, IGProSecurityResult paramIGProSecurityResult)
  {
    if (GuildPrivateAddViewModel.a(this.b)) {
      return;
    }
    IResultWithSecurityCallback localIResultWithSecurityCallback = this.a;
    if (localIResultWithSecurityCallback != null) {
      localIResultWithSecurityCallback.a(paramInt, paramString, paramIGProSecurityResult);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.privatechannel.data.GuildPrivateAddViewModel.4
 * JD-Core Version:    0.7.0.1
 */