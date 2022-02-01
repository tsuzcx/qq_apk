package com.tencent.mobileqq.guild.live.livemanager.audience;

import com.tencent.mobileqq.guild.live.livemanager.repo.QQGuildLiveRoomUiData;
import com.tencent.mobileqq.qqlive.callback.room.audience.EnterAudienceRoomCallback;
import com.tencent.mobileqq.qqlive.data.room.LiveAnchorInfo;
import com.tencent.mobileqq.qqlive.data.room.LiveInfo;
import com.tencent.qphone.base.util.QLog;

class QQGuildLiveAudienceRoomMgr$1
  implements EnterAudienceRoomCallback
{
  QQGuildLiveAudienceRoomMgr$1(QQGuildLiveAudienceRoomMgr paramQQGuildLiveAudienceRoomMgr, long paramLong) {}
  
  public void onFailed(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("enterRoom fail code ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" msg ");
    localStringBuilder.append(paramString);
    QLog.d("QGL.QQGuildLiveAudienceRoomMgr", 1, localStringBuilder.toString());
    QQGuildLiveRoomUiData.a().b(Boolean.valueOf(false));
    this.b.b();
  }
  
  public void onSuccess(LiveInfo paramLiveInfo)
  {
    QLog.d("QGL.QQGuildLiveAudienceRoomMgr", 1, "enterRoom suc.");
    if (QQGuildLiveAudienceRoomMgr.a(this.b) == null)
    {
      QLog.d("QGL.QQGuildLiveAudienceRoomMgr", 1, "enterRoom mLiveAudienceRoom == null, ignore callback.");
      return;
    }
    QQGuildLiveRoomUiData.a().b(Boolean.valueOf(true));
    if ((paramLiveInfo != null) && (paramLiveInfo.anchorInfo != null))
    {
      QQGuildLiveAudienceRoomMgr.a(this.b, paramLiveInfo.anchorInfo.uid);
      paramLiveInfo = new StringBuilder();
      paramLiveInfo.append("enterRoom mLiveAnchorUid:");
      paramLiveInfo.append(QQGuildLiveAudienceRoomMgr.b(this.b));
      QLog.d("QGL.QQGuildLiveAudienceRoomMgr", 1, paramLiveInfo.toString());
    }
    QQGuildLiveAudienceRoomMgr.b(this.b, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.live.livemanager.audience.QQGuildLiveAudienceRoomMgr.1
 * JD-Core Version:    0.7.0.1
 */