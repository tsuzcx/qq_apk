package com.tencent.mobileqq.guild.audio;

import com.tencent.av.utils.PhoneStatusMonitor;
import com.tencent.common.app.business.BaseQQAppInterface;

class AudioRoom$16
  implements Runnable
{
  AudioRoom$16(AudioRoom paramAudioRoom) {}
  
  public void run()
  {
    if (AudioRoom.f(this.this$0) != null)
    {
      AudioRoom localAudioRoom = this.this$0;
      AudioRoom.a(localAudioRoom, new PhoneStatusMonitor(AudioRoom.f(localAudioRoom).getApp(), new AudioRoom.16.1(this)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.audio.AudioRoom.16
 * JD-Core Version:    0.7.0.1
 */