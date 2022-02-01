package com.tencent.mobileqq.guild.profilecard.main;

import com.tencent.mobileqq.qqguildsdk.data.IGProUserProfileInfo;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.qphone.base.util.QLog;

class GuildProfileHeaderViewModel$2
  extends GPServiceObserver
{
  GuildProfileHeaderViewModel$2(GuildProfileHeaderViewModel paramGuildProfileHeaderViewModel) {}
  
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
      QLog.i("GuildProfileHeaderViewModel", 1, paramString2.toString());
    }
    if (paramInt == 0)
    {
      GuildProfileHeaderViewModel.a(this.a, paramIGProUserProfileInfo);
      GuildProfileHeaderViewModel.b(this.a, paramIGProUserProfileInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.profilecard.main.GuildProfileHeaderViewModel.2
 * JD-Core Version:    0.7.0.1
 */