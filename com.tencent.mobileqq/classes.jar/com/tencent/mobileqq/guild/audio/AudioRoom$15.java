package com.tencent.mobileqq.guild.audio;

import com.tencent.mobileqq.guild.audio.data.UserInfoList;
import com.tencent.mobileqq.qqguildsdk.callback.IResultCallback;
import com.tencent.qphone.base.util.QLog;

class AudioRoom$15
  implements IResultCallback
{
  AudioRoom$15(AudioRoom paramAudioRoom, String paramString1, String paramString2, String paramString3, boolean paramBoolean, IResultCallback paramIResultCallback) {}
  
  public void onResult(int paramInt, String paramString)
  {
    if (paramInt == 0)
    {
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("setUserMuteSeatInGuild success, guildId[");
        paramString.append(this.a);
        paramString.append("], channelId[");
        paramString.append(this.b);
        paramString.append("], tinyId[");
        paramString.append(this.c);
        paramString.append("], bMute[");
        paramString.append(this.d);
        paramString.append("], inRoom[");
        paramString.append(this.f.c());
        paramString.append("]");
        QLog.i("AudioRoom", 2, paramString.toString());
      }
      if (this.f.c())
      {
        paramString = AudioRoom.b(this.f).a(this.c);
        if (paramString != null)
        {
          paramString.p = this.d;
          AudioRoom.b(this.f, "setUserMuteSeatInGuild");
        }
      }
      else
      {
        paramString = AudioRoom.e(this.f).a(this.c);
        if (paramString != null)
        {
          paramString.p = this.d;
          AudioRoom.d(this.f, "setUserMuteSeatInGuild");
        }
      }
    }
    else
    {
      this.e.onResult(paramInt, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.audio.AudioRoom.15
 * JD-Core Version:    0.7.0.1
 */