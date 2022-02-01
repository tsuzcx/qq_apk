package com.tencent.mobileqq.guild.live.livemanager;

import com.tencent.mobileqq.qqlive.callback.room.audience.GetRoomInfoCallback;
import com.tencent.mobileqq.qqlive.data.room.realtime.LiveRealTimeInfo;
import com.tencent.qphone.base.util.QLog;

final class GuildLiveRoomListenerHandler$5
  implements GetRoomInfoCallback
{
  public void a(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getRoomRealTimeInfo fail. code=");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" msg=");
    localStringBuilder.append(paramString);
    QLog.e("QGL.GuildLiveRoomListenerHandler", 1, localStringBuilder.toString());
  }
  
  public void a(LiveRealTimeInfo paramLiveRealTimeInfo)
  {
    QLog.i("QGL.GuildLiveRoomListenerHandler", 1, "getRoomRealTimeInfo suc.");
    if (QQGuildLiveRoomCommMgr.a().b()) {
      GuildLiveRoomListenerHandler.a(paramLiveRealTimeInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.live.livemanager.GuildLiveRoomListenerHandler.5
 * JD-Core Version:    0.7.0.1
 */