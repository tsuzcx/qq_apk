package com.tencent.mobileqq.guild.audio;

import com.tencent.mobileqq.qqguildsdk.callback.IResultWithSecurityCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.qphone.base.util.QLog;

class AudioRoom$7$1$1$1
  implements IResultWithSecurityCallback
{
  AudioRoom$7$1$1$1(AudioRoom.7.1.1 param1) {}
  
  public void a(int paramInt, String paramString, IGProSecurityResult paramIGProSecurityResult)
  {
    if (paramInt != 0)
    {
      paramIGProSecurityResult = new StringBuilder();
      paramIGProSecurityResult.append("exitAudioChannel when trtc enterRoom failed and its failed result:");
      paramIGProSecurityResult.append(paramInt);
      paramIGProSecurityResult.append(", errMsg:");
      paramIGProSecurityResult.append(paramString);
      QLog.e("AudioRoom", 1, paramIGProSecurityResult.toString());
      return;
    }
    QLog.i("AudioRoom", 1, "exitAudioChannel success when trtc enterRoom failed.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.audio.AudioRoom.7.1.1.1
 * JD-Core Version:    0.7.0.1
 */