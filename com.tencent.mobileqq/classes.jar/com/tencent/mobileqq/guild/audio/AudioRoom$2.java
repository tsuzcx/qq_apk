package com.tencent.mobileqq.guild.audio;

import com.tencent.mobileqq.guild.handler.QQGuildObserver;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.qphone.base.util.QLog;

class AudioRoom$2
  extends QQGuildObserver
{
  AudioRoom$2(AudioRoom paramAudioRoom) {}
  
  public void a(boolean paramBoolean, IGProChannelInfo paramIGProChannelInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onChannelDelete guild=");
    localStringBuilder.append(paramIGProChannelInfo.getGuildId());
    localStringBuilder.append(", channelId=");
    localStringBuilder.append(paramIGProChannelInfo.getChannelUin());
    QLog.i("QQGuildObserver", 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.audio.AudioRoom.2
 * JD-Core Version:    0.7.0.1
 */