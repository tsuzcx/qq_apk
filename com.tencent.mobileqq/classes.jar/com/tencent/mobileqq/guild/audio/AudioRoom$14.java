package com.tencent.mobileqq.guild.audio;

import com.tencent.mobileqq.guild.audio.data.UserInfoList;
import com.tencent.mobileqq.qqguildsdk.callback.IResultCallback;
import com.tencent.qphone.base.util.QLog;

class AudioRoom$14
  implements IResultCallback
{
  AudioRoom$14(AudioRoom paramAudioRoom, String paramString, boolean paramBoolean, IResultCallback paramIResultCallback) {}
  
  public void onResult(int paramInt, String paramString)
  {
    if (paramInt == 0)
    {
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("setUserVoicelessToMe success, tinyId[");
        paramString.append(this.a);
        paramString.append("], bVoiceless[");
        paramString.append(this.b);
        paramString.append("], inRoom[");
        paramString.append(this.d.c());
        paramString.append("]");
        QLog.i("AudioRoom", 2, paramString.toString());
      }
      if (this.d.c())
      {
        AudioRoom.c(this.d).a(this.a, this.b);
        paramString = AudioRoom.b(this.d).a(this.a);
        if (paramString != null)
        {
          paramString.o = this.b;
          AudioRoom.b(this.d, "setUserVoicelessToMe");
        }
      }
      else
      {
        paramString = AudioRoom.e(this.d).a(this.a);
        if (paramString != null)
        {
          paramString.o = this.b;
          AudioRoom.d(this.d, "setUserVoicelessToMe");
        }
      }
    }
    else
    {
      this.c.onResult(paramInt, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.audio.AudioRoom.14
 * JD-Core Version:    0.7.0.1
 */