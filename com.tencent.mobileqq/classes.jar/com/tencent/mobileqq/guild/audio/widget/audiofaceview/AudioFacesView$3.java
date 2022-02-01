package com.tencent.mobileqq.guild.audio.widget.audiofaceview;

import com.tencent.mobileqq.guild.audio.AudioRoomObserver;
import com.tencent.mobileqq.guild.audio.data.LocalUserInfo;
import com.tencent.mobileqq.guild.audio.data.UserInfoList;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class AudioFacesView$3
  extends AudioRoomObserver
{
  AudioFacesView$3(AudioFacesView paramAudioFacesView) {}
  
  public void a(String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2, String paramString4)
  {
    if ((paramString1.equals(AudioFacesView.c(this.a).getGuildId())) && (!paramString2.equals(AudioFacesView.c(this.a).getChannelUin()))) {}
  }
  
  public void a(String paramString1, String paramString2, String paramString3, LocalUserInfo paramLocalUserInfo, UserInfoList paramUserInfoList)
  {
    if (paramString2.equals(AudioFacesView.c(this.a).getGuildId()))
    {
      if (!paramString3.equals(AudioFacesView.c(this.a).getChannelUin())) {
        return;
      }
      if (QLog.isColorLevel())
      {
        paramString2 = new StringBuilder();
        paramString2.append("onUserDataUpdate from[");
        paramString2.append(paramString1);
        paramString2.append("], ");
        paramString2.append(paramLocalUserInfo);
        paramString2.append(" userInfoList ");
        paramString2.append(paramUserInfoList.a);
        QLog.i("AudioFacesView", 2, paramString2.toString());
      }
      if ((paramLocalUserInfo.c) && (paramUserInfoList.a.size() == 0)) {
        return;
      }
      this.a.a(paramLocalUserInfo, paramUserInfoList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.audio.widget.audiofaceview.AudioFacesView.3
 * JD-Core Version:    0.7.0.1
 */