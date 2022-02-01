package com.tencent.timi.game.component.qqlive.impl.common;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.qqlive.api.room.ILiveRoom;
import com.tencent.mobileqq.qqlive.api.room.ILiveTPPlayerRoom;
import com.tencent.mobileqq.qqlive.callback.gift.ReceiveGiftMessageListener;
import com.tencent.mobileqq.qqlive.callback.room.RoomAudienceInfoListener;
import com.tencent.mobileqq.qqlive.callback.room.audience.AudienceRoomPlayerListener;
import com.tencent.mobileqq.qqlive.callback.room.audience.LiveRoomStatusListener;
import com.tencent.mobileqq.qqlive.data.gift.GiftMessage;
import com.tencent.qphone.base.util.QLog;

public class TgLiveRoomListenerHandler
{
  private static TgLiveRoomListenerHandler a;
  private final LiveRoomStatusListener b = new TgLiveRoomListenerHandler.1(this);
  private final RoomAudienceInfoListener c = new TgLiveRoomListenerHandler.2(this);
  private final ReceiveGiftMessageListener d = new TgLiveRoomListenerHandler.3(this);
  private final AudienceRoomPlayerListener e = new TgLiveRoomListenerHandler.4(this);
  private final ILiveRoom f;
  
  public TgLiveRoomListenerHandler(@NonNull ILiveRoom paramILiveRoom)
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
        a = new TgLiveRoomListenerHandler(paramILiveRoom);
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
      QLog.i("TgLiveTag_TgLiveRoomListenerHandler", 1, "giftMessage == null");
      return;
    }
    TgLiveRoomUIData.a().a(paramGiftMessage);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.qqlive.impl.common.TgLiveRoomListenerHandler
 * JD-Core Version:    0.7.0.1
 */