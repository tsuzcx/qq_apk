package com.tencent.mobileqq.guild.audio;

import com.tencent.mobileqq.guild.audio.data.AudioRoomError;
import com.tencent.mobileqq.guild.audio.data.LocalUserInfo;
import com.tencent.mobileqq.guild.audio.data.UserInfo;
import com.tencent.mobileqq.guild.audio.data.UserInfoList;
import com.tencent.mobileqq.qqguildsdk.callback.IFetchAudioChannelUserListCallback;
import com.tencent.mobileqq.qqguildsdk.data.IAudioChannelMemberInfos;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class AudioRoom$6
  implements IFetchAudioChannelUserListCallback
{
  AudioRoom$6(AudioRoom paramAudioRoom) {}
  
  public void a(int paramInt, String paramString, IAudioChannelMemberInfos paramIAudioChannelMemberInfos)
  {
    if (paramInt != 0)
    {
      paramIAudioChannelMemberInfos = new StringBuilder();
      paramIAudioChannelMemberInfos.append("preview onFetchAudioChannelUserList failed or channelMemberInfos null as result:");
      paramIAudioChannelMemberInfos.append(paramInt);
      paramIAudioChannelMemberInfos.append(", errMsg:");
      paramIAudioChannelMemberInfos.append(paramString);
      QLog.e("AudioRoom", 1, paramIAudioChannelMemberInfos.toString());
      AudioRoom.a(this.a, 1, AudioRoomError.a(1, paramInt, paramString), paramInt, paramString);
      return;
    }
    if (paramIAudioChannelMemberInfos == null)
    {
      AudioRoom.e(this.a).a.clear();
    }
    else
    {
      paramIAudioChannelMemberInfos = paramIAudioChannelMemberInfos.d();
      AudioRoom.d(this.a).a(paramIAudioChannelMemberInfos);
      UserInfo.a(paramIAudioChannelMemberInfos, AudioRoom.e(this.a).a);
      UserInfo.a(AudioRoom.e(this.a).a, true);
    }
    paramIAudioChannelMemberInfos = new StringBuilder();
    paramIAudioChannelMemberInfos.append("preview onFetchAudioChannelUserList result:");
    paramIAudioChannelMemberInfos.append(paramInt);
    paramIAudioChannelMemberInfos.append(", errMsg:");
    paramIAudioChannelMemberInfos.append(paramString);
    paramIAudioChannelMemberInfos.append(", userInfos:");
    paramIAudioChannelMemberInfos.append(AudioRoom.e(this.a).a);
    QLog.i("AudioRoom", 1, paramIAudioChannelMemberInfos.toString());
    AudioRoom.d(this.a, "onFetchAudioChannelUserList");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.audio.AudioRoom.6
 * JD-Core Version:    0.7.0.1
 */