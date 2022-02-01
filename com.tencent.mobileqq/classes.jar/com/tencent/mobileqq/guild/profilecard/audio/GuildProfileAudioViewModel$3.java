package com.tencent.mobileqq.guild.profilecard.audio;

import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.guild.audio.AudioRoomObserver;
import com.tencent.mobileqq.guild.audio.data.LocalUserInfo;
import com.tencent.mobileqq.guild.audio.data.UserInfo;
import com.tencent.mobileqq.guild.audio.data.UserInfoList;
import com.tencent.mobileqq.guild.util.SingleLiveEvent;
import com.tencent.qphone.base.util.QLog;

class GuildProfileAudioViewModel$3
  extends AudioRoomObserver
{
  GuildProfileAudioViewModel$3(GuildProfileAudioViewModel paramGuildProfileAudioViewModel) {}
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    GuildProfileAudioViewModel.c(this.a).setValue(Boolean.valueOf(true));
  }
  
  public void a(String paramString1, String paramString2, String paramString3, LocalUserInfo paramLocalUserInfo, UserInfoList paramUserInfoList)
  {
    if (GuildProfileAudioViewModel.d(this.a).getValue() == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("GuildProfileAudioViewModel", 2, "mChannelData.getValue() is null!");
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append("onUserDataUpdate from[");
      paramString2.append(paramString1);
      paramString2.append("], ");
      paramString2.append(paramLocalUserInfo);
      QLog.i("GuildProfileAudioViewModel", 2, paramString2.toString());
      if (((GuildAudioChannelData)GuildProfileAudioViewModel.d(this.a).getValue()).c() != paramLocalUserInfo.k)
      {
        paramString2 = new StringBuilder();
        paramString2.append("my user type change[");
        paramString2.append(((GuildAudioChannelData)GuildProfileAudioViewModel.d(this.a).getValue()).c());
        paramString2.append(" -> ");
        paramString2.append(paramLocalUserInfo.k);
        paramString2.append("]");
        QLog.i("GuildProfileAudioViewModel", 2, paramString2.toString());
      }
    }
    paramString2 = (GuildAudioChannelData)GuildProfileAudioViewModel.d(this.a).getValue();
    paramString3 = paramUserInfoList.a(paramString2.d());
    if (paramString3 == null)
    {
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append(paramString2.d());
        paramString1.append(" already exit!");
        QLog.d("GuildProfileAudioViewModel", 2, paramString1.toString());
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      paramUserInfoList = new StringBuilder();
      paramUserInfoList.append("onUserDataUpdate from[");
      paramUserInfoList.append(paramString1);
      paramUserInfoList.append("], ");
      paramUserInfoList.append(paramString3);
      QLog.i("GuildProfileAudioViewModel", 2, paramUserInfoList.toString());
      if ((paramString2.e() != paramString3.k) || (paramString2.f() != paramString3.o) || (paramString2.g() != paramString3.p))
      {
        paramString1 = new StringBuilder();
        paramString1.append("dst user profile change, userType[");
        paramString1.append(paramString2.e());
        paramString1.append(" -> ");
        paramString1.append(paramString3.k);
        paramString1.append("], muteToMe[");
        paramString1.append(paramString2.f());
        paramString1.append(" -> ");
        paramString1.append(paramString3.o);
        paramString1.append("], globalMute[");
        paramString1.append(paramString2.g());
        paramString1.append(" -> ");
        paramString1.append(paramString3.p);
        paramString1.append("]");
        QLog.i("GuildProfileAudioViewModel", 2, paramString1.toString());
      }
    }
    paramString2.a(paramLocalUserInfo.h);
    paramString2.a(paramLocalUserInfo.k);
    paramString2.b(paramString3.h);
    paramString2.b(paramString3.k);
    paramString2.a(paramString3.o);
    paramString2.b(paramString3.p);
    paramString2.c(((Integer)GuildProfileAudioViewModel.a(this.a).getValue()).intValue());
    GuildProfileAudioViewModel.d(this.a).setValue(paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.profilecard.audio.GuildProfileAudioViewModel.3
 * JD-Core Version:    0.7.0.1
 */