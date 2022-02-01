package com.tencent.mobileqq.guild.profilecard.audio;

import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.guild.data.profilecard.GuildBaseProfileData;
import com.tencent.mobileqq.guild.util.SingleLiveEvent;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserProfileInfo;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.qphone.base.util.QLog;

class GuildProfileAudioViewModel$2
  extends GPServiceObserver
{
  GuildProfileAudioViewModel$2(GuildProfileAudioViewModel paramGuildProfileAudioViewModel) {}
  
  protected void a(int paramInt, String paramString1, String paramString2, String paramString3, IGProUserProfileInfo paramIGProUserProfileInfo)
  {
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder();
      paramString1.append("onUserProfileInfoUpdate info: ");
      paramString1.append(paramIGProUserProfileInfo);
      QLog.i("GuildProfileAudioViewModel", 1, paramString1.toString());
    }
    if (paramInt == 0)
    {
      GuildProfileAudioViewModel.a(this.a).setValue(Integer.valueOf(paramIGProUserProfileInfo.d()));
      GuildProfileAudioViewModel.a(this.a, paramIGProUserProfileInfo);
    }
  }
  
  protected void a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("GuildProfileAudioViewModel", 1, String.format("guildId: %s, chnnUin: %s, operatorTinyId: %s, tinyId: %s", new Object[] { paramString1, paramString2, paramString3, paramString4 }));
    }
    if (paramString1.equals(GuildProfileAudioViewModel.b(this.a).a())) {
      GuildProfileAudioViewModel.c(this.a).setValue(Boolean.valueOf(true));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.profilecard.audio.GuildProfileAudioViewModel.2
 * JD-Core Version:    0.7.0.1
 */