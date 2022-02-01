package com.tencent.mobileqq.guild.live.livemanager;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.guild.live.livemanager.model.QQGuildEndLiveModel;
import com.tencent.mobileqq.guild.live.livemanager.model.QQGuildEndLiveModel.Builder;
import com.tencent.mobileqq.guild.live.livemanager.repo.QQGuildLiveRoomUiData;
import com.tencent.mobileqq.qqlive.api.room.ILiveRoom;
import com.tencent.mobileqq.qqlive.api.room.ILiveTPPlayerRoom;
import com.tencent.mobileqq.qqlive.callback.gift.ReceiveGiftMessageListener;
import com.tencent.mobileqq.qqlive.callback.room.RoomAudienceInfoListener;
import com.tencent.mobileqq.qqlive.callback.room.audience.AudienceRoomPlayerListener;
import com.tencent.mobileqq.qqlive.callback.room.audience.LiveRoomStatusListener;
import com.tencent.mobileqq.qqlive.data.gift.GiftMessage;
import com.tencent.mobileqq.qqlive.data.room.realtime.LiveRealTimeInfo;
import com.tencent.mobileqq.qqlive.data.room.realtime.MetricsType;
import com.tencent.mobileqq.qqlive.data.room.realtime.RealTimeData;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class GuildLiveRoomListenerHandler
{
  private static GuildLiveRoomListenerHandler a;
  private final LiveRoomStatusListener b = new GuildLiveRoomListenerHandler.1(this);
  private final RoomAudienceInfoListener c = new GuildLiveRoomListenerHandler.2(this);
  private final ReceiveGiftMessageListener d = new GuildLiveRoomListenerHandler.3(this);
  private final AudienceRoomPlayerListener e = new GuildLiveRoomListenerHandler.4(this);
  private final ILiveRoom f;
  
  public GuildLiveRoomListenerHandler(@NonNull ILiveRoom paramILiveRoom)
  {
    this.f = paramILiveRoom;
  }
  
  public static void a()
  {
    try
    {
      if (a != null)
      {
        a.c();
        a = null;
      }
      return;
    }
    finally {}
  }
  
  public static void a(ILiveRoom paramILiveRoom)
  {
    try
    {
      if (a == null)
      {
        a = new GuildLiveRoomListenerHandler(paramILiveRoom);
        a.b();
      }
      return;
    }
    finally {}
  }
  
  private void a(GiftMessage paramGiftMessage)
  {
    if (paramGiftMessage == null)
    {
      QLog.i("QGL.GuildLiveRoomListenerHandler", 1, "giftMessage == null");
      return;
    }
    QQGuildLiveRoomUiData.a().a(paramGiftMessage);
  }
  
  private void b()
  {
    this.f.registerAudienceInfoListener(this.c);
    this.f.registerReceiveGiftMessageListener(this.d);
    this.f.registerRoomStatusListener(this.b);
    ILiveRoom localILiveRoom = this.f;
    if ((localILiveRoom instanceof ILiveTPPlayerRoom)) {
      ((ILiveTPPlayerRoom)localILiveRoom).registerRoomPlayerListener(this.e);
    }
  }
  
  public static void b(@NonNull ILiveRoom paramILiveRoom)
  {
    QLog.i("QGL.GuildLiveRoomListenerHandler", 1, "getRealTimeInfoForEndLiveUI.");
    paramILiveRoom.getRoomRealTimeInfo(new GuildLiveRoomListenerHandler.5());
    QQGuildLiveEventHelper.a().b();
  }
  
  private static void b(LiveRealTimeInfo paramLiveRealTimeInfo)
  {
    if (paramLiveRealTimeInfo != null)
    {
      Object localObject = QQGuildEndLiveModel.a().f(paramLiveRealTimeInfo.anchorId).e(paramLiveRealTimeInfo.roomId);
      paramLiveRealTimeInfo = paramLiveRealTimeInfo.items.iterator();
      while (paramLiveRealTimeInfo.hasNext())
      {
        RealTimeData localRealTimeData = (RealTimeData)paramLiveRealTimeInfo.next();
        if (localRealTimeData.type == MetricsType.CUMULATIVE_UV) {
          ((QQGuildEndLiveModel.Builder)localObject).b(localRealTimeData.value);
        } else if (localRealTimeData.type == MetricsType.CUR_UV) {
          ((QQGuildEndLiveModel.Builder)localObject).c(localRealTimeData.value);
        } else if (localRealTimeData.type == MetricsType.NUM_OF_LIKE) {
          ((QQGuildEndLiveModel.Builder)localObject).d(localRealTimeData.value);
        } else if (localRealTimeData.type == MetricsType.TOTAL_LIVE_TIME) {
          ((QQGuildEndLiveModel.Builder)localObject).a(localRealTimeData.value);
        }
      }
      paramLiveRealTimeInfo = ((QQGuildEndLiveModel.Builder)localObject).a();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("mapRoomRealTimeInfo2EndLiveData,");
      ((StringBuilder)localObject).append(paramLiveRealTimeInfo.toString());
      QLog.i("QGL.GuildLiveRoomListenerHandler", 1, ((StringBuilder)localObject).toString());
      QQGuildLiveEventHelper.a().a(paramLiveRealTimeInfo);
    }
  }
  
  private void c()
  {
    this.f.unRegisterAudienceInfoListener(this.c);
    this.f.unRegisterReceiveGiftMessageListener(this.d);
    this.f.unRegisterRoomStatusListener(this.b);
    ILiveRoom localILiveRoom = this.f;
    if ((localILiveRoom instanceof ILiveTPPlayerRoom)) {
      ((ILiveTPPlayerRoom)localILiveRoom).unRegisterRoomPlayerListener(this.e);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.live.livemanager.GuildLiveRoomListenerHandler
 * JD-Core Version:    0.7.0.1
 */