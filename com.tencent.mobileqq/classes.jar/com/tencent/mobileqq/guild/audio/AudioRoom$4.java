package com.tencent.mobileqq.guild.audio;

import com.tencent.mobileqq.guild.audio.data.LocalUserInfo;
import com.tencent.mobileqq.qqguildsdk.callback.IGetUserInfoCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class AudioRoom$4
  implements IGetUserInfoCallback
{
  AudioRoom$4(AudioRoom paramAudioRoom) {}
  
  public void onGetUserInfo(int paramInt, String paramString, List<IGProUserInfo> paramList, List<String> paramList1)
  {
    if (paramInt == 0)
    {
      AudioRoom.d(this.a).a((IGProUserInfo)paramList.get(0));
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("fetchUserInfo success, ");
        paramString.append(AudioRoom.d(this.a));
        QLog.w("AudioRoom", 2, paramString.toString());
      }
    }
    else if (QLog.isColorLevel())
    {
      paramList = new StringBuilder();
      paramList.append("fetchUserInfo failed, result[");
      paramList.append(paramInt);
      paramList.append("], msg[");
      paramList.append(paramString);
      paramList.append("]");
      QLog.w("AudioRoom", 2, paramList.toString());
    }
    this.a.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.audio.AudioRoom.4
 * JD-Core Version:    0.7.0.1
 */