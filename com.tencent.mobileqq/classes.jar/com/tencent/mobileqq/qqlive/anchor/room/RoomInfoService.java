package com.tencent.mobileqq.qqlive.anchor.room;

import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.callback.room.audience.RoomInfoListener;
import com.tencent.mobileqq.qqlive.push.api.IQQLiveRoomPushService;
import com.tencent.mobileqq.qqlive.push.api.PushReceiver;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

class RoomInfoService
{
  private List<RoomInfoListener> a = new CopyOnWriteArrayList();
  private PushReceiver b;
  
  void a()
  {
    PushReceiver localPushReceiver = this.b;
    if (localPushReceiver != null) {
      localPushReceiver.a();
    }
  }
  
  void a(IQQLiveSDK paramIQQLiveSDK)
  {
    this.b = ((IQQLiveRoomPushService)paramIQQLiveSDK.getExtModule("roomPush")).a();
    this.b.a(213, new RoomInfoService.1(this));
  }
  
  void a(RoomInfoListener paramRoomInfoListener)
  {
    if (!this.a.contains(paramRoomInfoListener)) {
      this.a.add(paramRoomInfoListener);
    }
  }
  
  void b(RoomInfoListener paramRoomInfoListener)
  {
    this.a.remove(paramRoomInfoListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.anchor.room.RoomInfoService
 * JD-Core Version:    0.7.0.1
 */