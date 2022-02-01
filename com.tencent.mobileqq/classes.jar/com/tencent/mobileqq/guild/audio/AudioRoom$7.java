package com.tencent.mobileqq.guild.audio;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.guild.audio.data.AudioRoomError;
import com.tencent.mobileqq.guild.util.GuildAVPriorityManager;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.qphone.base.util.QLog;

class AudioRoom$7
  implements ITRTCAudioRoom.ITRTCAudioRoomCallback
{
  AudioRoom$7(AudioRoom paramAudioRoom, AudioRoom.IEnterRoomCallback paramIEnterRoomCallback, IGProChannelInfo paramIGProChannelInfo) {}
  
  public void a(int paramInt, String paramString)
  {
    if (paramInt != 0)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("trtc prepare failed with code:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", msg:");
      localStringBuilder.append(paramString);
      QLog.e("AudioRoom", 1, localStringBuilder.toString());
      GuildAVPriorityManager.a("频道通话");
      this.a.a(false, paramString);
      AudioRoomError.a(0);
      return;
    }
    QLog.i("AudioRoom", 1, "enterRoom 2");
    AudioRoom.a(this.c, true);
    ((IGPSService)AudioRoom.f(this.c).getRuntimeService(IGPSService.class, "")).addAudioChannel(this.b.getGuildId(), this.b.getChannelUin(), "1", new AudioRoom.7.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.audio.AudioRoom.7
 * JD-Core Version:    0.7.0.1
 */