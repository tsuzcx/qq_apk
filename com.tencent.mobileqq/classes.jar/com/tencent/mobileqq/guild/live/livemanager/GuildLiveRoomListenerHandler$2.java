package com.tencent.mobileqq.guild.live.livemanager;

import com.tencent.mobileqq.guild.live.livemanager.repo.QQGuildLiveRoomUiData;
import com.tencent.mobileqq.qqlive.callback.room.RoomAudienceInfoListener;
import com.tencent.mobileqq.qqlive.data.message.LiveMessageData.SpeakerInfo;
import com.tencent.mobileqq.qqlive.data.room.RoomAudienceInfo;
import com.tencent.qphone.base.util.QLog;

class GuildLiveRoomListenerHandler$2
  implements RoomAudienceInfoListener
{
  GuildLiveRoomListenerHandler$2(GuildLiveRoomListenerHandler paramGuildLiveRoomListenerHandler) {}
  
  public void a(LiveMessageData.SpeakerInfo paramSpeakerInfo)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onAudienceEnterRoom, speakId=");
      localStringBuilder.append(paramSpeakerInfo.mSpeakId);
      localStringBuilder.append(" speakName=");
      localStringBuilder.append(paramSpeakerInfo.mSpeakerName);
      QLog.d("QGL.GuildLiveRoomListenerHandler", 1, localStringBuilder.toString());
    }
  }
  
  public void a(RoomAudienceInfo paramRoomAudienceInfo)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onRecAudienceInfo fakeTotalPeople=");
      localStringBuilder.append(paramRoomAudienceInfo.fakeTotalPeople);
      localStringBuilder.append(" userCount=");
      localStringBuilder.append(paramRoomAudienceInfo.userCount);
      QLog.d("QGL.GuildLiveRoomListenerHandler", 1, localStringBuilder.toString());
    }
    if (paramRoomAudienceInfo != null) {
      QQGuildLiveRoomUiData.a().a(paramRoomAudienceInfo.userCount);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.live.livemanager.GuildLiveRoomListenerHandler.2
 * JD-Core Version:    0.7.0.1
 */