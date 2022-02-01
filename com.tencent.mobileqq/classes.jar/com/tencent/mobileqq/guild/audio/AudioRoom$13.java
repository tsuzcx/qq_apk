package com.tencent.mobileqq.guild.audio;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.guild.audio.data.LocalUserInfo;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import java.util.TimerTask;

class AudioRoom$13
  extends TimerTask
{
  AudioRoom$13(AudioRoom paramAudioRoom) {}
  
  public void run()
  {
    ((IGPSService)AudioRoom.f(this.this$0).getRuntimeService(IGPSService.class, "")).fetchAudioChannelUserList(AudioRoom.a(this.this$0).a, AudioRoom.a(this.this$0).b, new AudioRoom.13.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.audio.AudioRoom.13
 * JD-Core Version:    0.7.0.1
 */