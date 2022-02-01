package com.tencent.mobileqq.guild.profilecard.game;

import com.tencent.mobileqq.qqguildsdk.data.IGProUserProfileInfo;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.qphone.base.util.QLog;

class GuildProfileGameViewModel$3
  extends GPServiceObserver
{
  GuildProfileGameViewModel$3(GuildProfileGameViewModel paramGuildProfileGameViewModel) {}
  
  protected void a(int paramInt, String paramString1, String paramString2, String paramString3, IGProUserProfileInfo paramIGProUserProfileInfo)
  {
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append("onUserProfileInfoUpdate result: ");
      paramString2.append(paramInt);
      paramString2.append("errMsg: ");
      paramString2.append(paramString1);
      paramString2.append("onUserProfileInfoUpdate info: ");
      paramString2.append(paramIGProUserProfileInfo);
      QLog.i("GuildProfileGameViewModel", 1, paramString2.toString());
    }
    if (paramInt == 0)
    {
      GuildProfileGameViewModel.a(this.a, paramIGProUserProfileInfo.n());
      GuildProfileGameViewModel.a(this.a, paramIGProUserProfileInfo.o());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.profilecard.game.GuildProfileGameViewModel.3
 * JD-Core Version:    0.7.0.1
 */