package com.tencent.mobileqq.guild.audio;

import com.tencent.mobileqq.guild.audio.data.LocalUserInfo;
import com.tencent.mobileqq.qqguildsdk.callback.IResultWithSecurityCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.qphone.base.util.QLog;

class AudioRoom$12
  implements IResultWithSecurityCallback
{
  AudioRoom$12(AudioRoom paramAudioRoom, AudioRoom.IExitRoomCallback paramIExitRoomCallback) {}
  
  public void a(int paramInt, String paramString, IGProSecurityResult paramIGProSecurityResult)
  {
    boolean bool = true;
    if (paramInt != 0)
    {
      paramIGProSecurityResult = new StringBuilder();
      paramIGProSecurityResult.append("exitAudioChannel failed result:");
      paramIGProSecurityResult.append(paramInt);
      paramIGProSecurityResult.append(", errMsg:");
      paramIGProSecurityResult.append(paramString);
      paramIGProSecurityResult.append(", guildId:");
      paramIGProSecurityResult.append(AudioRoom.a(this.b).a);
      paramIGProSecurityResult.append(", channelId:");
      paramIGProSecurityResult.append(AudioRoom.a(this.b).b);
      QLog.e("AudioRoom", 1, paramIGProSecurityResult.toString());
    }
    else
    {
      QLog.i("AudioRoom", 1, "exitAudioChannel success.");
    }
    paramIGProSecurityResult = this.a;
    if (paramIGProSecurityResult != null)
    {
      if (paramInt == 0) {
        bool = false;
      }
      paramIGProSecurityResult.a(bool, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.audio.AudioRoom.12
 * JD-Core Version:    0.7.0.1
 */