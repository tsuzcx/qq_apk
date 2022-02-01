package com.tencent.mobileqq.guild.live.livemanager.audience;

import com.tencent.mobileqq.guild.live.livemanager.GuildLiveRoomListenerHandler;
import com.tencent.mobileqq.guild.live.livemanager.QQGuildLiveEventHelper;
import com.tencent.mobileqq.guild.live.livemanager.QQGuildLiveRoomCommMgr;
import com.tencent.mobileqq.guild.live.livemanager.repo.QQGuildLiveRoomUiData;
import com.tencent.mobileqq.guild.util.GuildAVPriorityManager;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.login.IQQLiveModuleLogin;
import com.tencent.mobileqq.qqlive.api.room.IAudienceRoom;
import com.tencent.mobileqq.qqlive.api.room.ITPPlayerVideoView;
import com.tencent.mobileqq.qqlive.data.room.EnterRoomInfo;
import com.tencent.mobileqq.qqlive.data.user.LiveUserInfo;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class QQGuildLiveAudienceRoomMgr
  implements IQQGuildLiveAudienceRoomMgr
{
  private static final QQGuildLiveAudienceRoomMgr a = new QQGuildLiveAudienceRoomMgr();
  private IAudienceRoom b;
  private long c;
  private long d;
  private long e;
  
  public static QQGuildLiveAudienceRoomMgr a()
  {
    return a;
  }
  
  private AppRuntime g()
  {
    return MobileQQ.sMobileQQ.peekAppRuntime();
  }
  
  private void h()
  {
    GuildLiveRoomListenerHandler.a(this.b);
  }
  
  private void i() {}
  
  public void a(long paramLong)
  {
    if (!GuildAVPriorityManager.a(g(), "频道直播", QQGuildLiveEventHelper.a()))
    {
      QLog.i("QGL.QQGuildLiveAudienceRoomMgr", 1, "requestAVFocus failure.");
      b();
      return;
    }
    if (!QQGuildLiveRoomCommMgr.a().b())
    {
      QLog.d("QGL.QQGuildLiveAudienceRoomMgr", 1, "audienceEnterRoom, live sdk not init suc.");
      return;
    }
    if (this.b != null)
    {
      QLog.d("QGL.QQGuildLiveAudienceRoomMgr", 1, "audienceEnterRoom, audience room had created, please check it.");
      return;
    }
    Object localObject = QQGuildLiveRoomCommMgr.a().c();
    this.d = ((IQQLiveSDK)localObject).getLoginModule().getUserInfo().uid;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("enterRoom mLiveSelfUid:");
    localStringBuilder.append(this.d);
    QLog.d("QGL.QQGuildLiveAudienceRoomMgr", 1, localStringBuilder.toString());
    this.b = ((IQQLiveSDK)localObject).createAudienceRoom();
    ((ITPPlayerVideoView)this.b.getDisplayView()).setXYAxis(0);
    QQGuildLiveRoomUiData.a().a(((ITPPlayerVideoView)this.b.getDisplayView()).getCurrentDisplayView());
    h();
    localObject = new EnterRoomInfo();
    ((EnterRoomInfo)localObject).setRoomId(paramLong);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("audienceEnterRoom start, roomId:");
    localStringBuilder.append(paramLong);
    QLog.d("QGL.QQGuildLiveAudienceRoomMgr", 1, localStringBuilder.toString());
    this.b.enterRoom((EnterRoomInfo)localObject, true, new QQGuildLiveAudienceRoomMgr.1(this, paramLong));
  }
  
  public void b()
  {
    QLog.d("QGL.QQGuildLiveAudienceRoomMgr", 1, "audienceExitRoom.");
    if (this.b != null)
    {
      i();
      this.b.exitRoom(null);
      this.b.destroy();
      this.b = null;
      this.c = 0L;
      this.d = 0L;
      this.e = 0L;
      QQGuildLiveRoomUiData.a().o();
    }
    GuildAVPriorityManager.a("频道观看直播");
  }
  
  public void c()
  {
    IAudienceRoom localIAudienceRoom = this.b;
    if (localIAudienceRoom != null) {
      GuildLiveRoomListenerHandler.b(localIAudienceRoom);
    }
    b();
  }
  
  public long d()
  {
    return this.d;
  }
  
  public long e()
  {
    return this.c;
  }
  
  public long f()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.live.livemanager.audience.QQGuildLiveAudienceRoomMgr
 * JD-Core Version:    0.7.0.1
 */