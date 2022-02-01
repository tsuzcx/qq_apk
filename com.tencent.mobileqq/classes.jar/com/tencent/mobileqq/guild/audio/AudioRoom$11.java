package com.tencent.mobileqq.guild.audio;

import com.tencent.qphone.base.util.QLog;

class AudioRoom$11
  implements ITRTCAudioRoom.ITRTCAudioRoomCallback
{
  AudioRoom$11(AudioRoom paramAudioRoom) {}
  
  public void a(int paramInt, String paramString)
  {
    if (paramInt != 0)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("trtc exitRoom failed result:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", errMsg:");
      localStringBuilder.append(paramString);
      QLog.e("AudioRoom", 1, localStringBuilder.toString());
      return;
    }
    QLog.i("AudioRoom", 1, "trtc exitRoom success.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.audio.AudioRoom.11
 * JD-Core Version:    0.7.0.1
 */