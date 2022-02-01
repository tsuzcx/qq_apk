package com.tencent.mobileqq.guild.audio;

import com.tencent.mobileqq.qqguildsdk.callback.IResultWithSecurityCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.qphone.base.util.QLog;

class AudioRoom$9
  implements IResultWithSecurityCallback
{
  AudioRoom$9(AudioRoom paramAudioRoom) {}
  
  public void a(int paramInt, String paramString, IGProSecurityResult paramIGProSecurityResult)
  {
    if (paramInt != 0)
    {
      paramIGProSecurityResult = new StringBuilder();
      paramIGProSecurityResult.append("exitAudioChannel failed result:");
      paramIGProSecurityResult.append(paramInt);
      paramIGProSecurityResult.append(", errMsg:");
      paramIGProSecurityResult.append(paramString);
      QLog.e("AudioRoom", 1, paramIGProSecurityResult.toString());
      return;
    }
    QLog.i("AudioRoom", 1, "exitAudioChannel success.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.audio.AudioRoom.9
 * JD-Core Version:    0.7.0.1
 */