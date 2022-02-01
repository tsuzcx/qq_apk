package com.tencent.mobileqq.guild.live.livemanager.anchor;

import com.tencent.mobileqq.guild.live.livemanager.GuildLiveRoomListenerHandler;
import com.tencent.mobileqq.qqlive.api.anchor.room.IQQLiveAnchorRoom;
import com.tencent.mobileqq.qqlive.callback.room.audience.ExitRoomCallback;
import com.tencent.qphone.base.util.QLog;

class QQGuildLiveAnchorRoomMgr$2
  implements ExitRoomCallback
{
  QQGuildLiveAnchorRoomMgr$2(QQGuildLiveAnchorRoomMgr paramQQGuildLiveAnchorRoomMgr, boolean paramBoolean, IQQLiveAnchorRoom paramIQQLiveAnchorRoom) {}
  
  public void onComplete(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("anchorExitRoom onComplete code:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" msg:");
    localStringBuilder.append(paramString);
    QLog.i("QGL.QQGuildLiveAnchorRoomMgr", 1, localStringBuilder.toString());
    if (this.a) {
      GuildLiveRoomListenerHandler.b(this.b);
    }
    this.b.destroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.live.livemanager.anchor.QQGuildLiveAnchorRoomMgr.2
 * JD-Core Version:    0.7.0.1
 */