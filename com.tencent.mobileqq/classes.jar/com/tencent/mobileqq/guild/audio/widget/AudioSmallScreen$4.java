package com.tencent.mobileqq.guild.audio.widget;

import com.tencent.mobileqq.guild.audio.AudioRoomObserver;
import com.tencent.mobileqq.guild.audio.data.LocalUserInfo;
import com.tencent.mobileqq.guild.audio.data.UserInfo;
import com.tencent.mobileqq.guild.audio.data.UserInfoList;
import com.tencent.mobileqq.guild.window.GuildFloatWindowUtils;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class AudioSmallScreen$4
  extends AudioRoomObserver
{
  AudioSmallScreen$4(AudioSmallScreen paramAudioSmallScreen) {}
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    paramString3 = new StringBuilder();
    paramString3.append("onExit guildId=");
    paramString3.append(paramString1);
    paramString3.append(", roomId=");
    paramString3.append(paramString2);
    QLog.i("AudioSmallScreen", 1, paramString3.toString());
    if (paramString1.equals(AudioSmallScreen.b(this.a).getGuildId()))
    {
      if (!paramString2.equals(AudioSmallScreen.b(this.a).getChannelUin())) {
        return;
      }
      GuildFloatWindowUtils.a();
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, LocalUserInfo paramLocalUserInfo, UserInfoList paramUserInfoList)
  {
    if (paramString2.equals(AudioSmallScreen.b(this.a).getGuildId()))
    {
      if (!paramString3.equals(AudioSmallScreen.b(this.a).getChannelUin())) {
        return;
      }
      if (QLog.isColorLevel())
      {
        paramString2 = new StringBuilder();
        paramString2.append("onUserDataUpdate from[");
        paramString2.append(paramString1);
        paramString2.append("], ");
        paramString2.append(paramLocalUserInfo);
        QLog.i("AudioSmallScreen", 2, paramString2.toString());
      }
      if ((paramLocalUserInfo.c) && (paramUserInfoList.a.size() == 0)) {
        return;
      }
      int i = 0;
      paramString1 = paramUserInfoList.a.iterator();
      while (paramString1.hasNext()) {
        i = Math.max(i, ((UserInfo)paramString1.next()).n);
      }
      AudioSmallScreen.a(this.a, paramLocalUserInfo, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.audio.widget.AudioSmallScreen.4
 * JD-Core Version:    0.7.0.1
 */