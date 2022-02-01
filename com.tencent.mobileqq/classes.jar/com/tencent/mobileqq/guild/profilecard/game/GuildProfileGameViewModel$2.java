package com.tencent.mobileqq.guild.profilecard.game;

import com.tencent.mobileqq.qqguildsdk.callback.ILoadUserProfileInfoCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserProfileInfo;
import com.tencent.qphone.base.util.QLog;

class GuildProfileGameViewModel$2
  implements ILoadUserProfileInfoCallback
{
  GuildProfileGameViewModel$2(GuildProfileGameViewModel paramGuildProfileGameViewModel) {}
  
  public void onLoadUserProfileInfo(int paramInt, String paramString, IGProUserProfileInfo paramIGProUserProfileInfo)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onLoadUserProfileInfo result: ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("errMsg: ");
      localStringBuilder.append(paramString);
      localStringBuilder.append("onLoadUserProfileInfo info: ");
      localStringBuilder.append(paramIGProUserProfileInfo);
      QLog.i("GuildProfileGameViewModel", 1, localStringBuilder.toString());
    }
    if (paramInt == 0)
    {
      GuildProfileGameViewModel.a(this.a, paramIGProUserProfileInfo.n());
      GuildProfileGameViewModel.a(this.a, paramIGProUserProfileInfo.o());
    }
    GuildProfileGameViewModel.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.profilecard.game.GuildProfileGameViewModel.2
 * JD-Core Version:    0.7.0.1
 */