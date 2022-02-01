package com.tencent.mobileqq.qqlive.api.impl.room;

import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.callback.room.audience.LiveRoomStatusListener;
import com.tencent.mobileqq.qqlive.push.api.IQQLiveRoomPushService;
import com.tencent.mobileqq.qqlive.push.api.PushReceiver;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.push.ProtocolVideoState.nano.RoomVideoStateBroadcast;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

class LiveRoomStatusService
{
  private static final String TAG = "AudienceRoomStatusModule";
  private final CopyOnWriteArrayList<LiveRoomStatusListener> roomInfoListeners = new CopyOnWriteArrayList();
  private PushReceiver statusReceiver;
  
  private void parseData(RoomVideoStateBroadcast paramRoomVideoStateBroadcast)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("AudienceRoomStatusService, parseData: ");
      ((StringBuilder)localObject).append(paramRoomVideoStateBroadcast.d);
      QLog.d("AudienceRoomStatusModule", 1, ((StringBuilder)localObject).toString());
    }
    int i = paramRoomVideoStateBroadcast.d;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3) {
            return;
          }
          paramRoomVideoStateBroadcast = this.roomInfoListeners.iterator();
          while (paramRoomVideoStateBroadcast.hasNext()) {
            ((LiveRoomStatusListener)paramRoomVideoStateBroadcast.next()).onRoomResume();
          }
        }
        paramRoomVideoStateBroadcast = this.roomInfoListeners.iterator();
        while (paramRoomVideoStateBroadcast.hasNext()) {
          ((LiveRoomStatusListener)paramRoomVideoStateBroadcast.next()).onRoomPause();
        }
      }
      paramRoomVideoStateBroadcast = this.roomInfoListeners.iterator();
      while (paramRoomVideoStateBroadcast.hasNext()) {
        ((LiveRoomStatusListener)paramRoomVideoStateBroadcast.next()).onRoomOpen();
      }
    }
    String str;
    if ((paramRoomVideoStateBroadcast.h == 10) && (paramRoomVideoStateBroadcast.i != null)) {
      try
      {
        localObject = new String(paramRoomVideoStateBroadcast.i);
      }
      catch (Throwable localThrowable)
      {
        QLog.e("AudienceRoomStatusModule", 1, "closeReason parse error", localThrowable);
      }
    } else {
      str = "";
    }
    Iterator localIterator = this.roomInfoListeners.iterator();
    while (localIterator.hasNext()) {
      ((LiveRoomStatusListener)localIterator.next()).onRoomClose(paramRoomVideoStateBroadcast.h, str);
    }
  }
  
  void destroy()
  {
    PushReceiver localPushReceiver = this.statusReceiver;
    if (localPushReceiver != null) {
      localPushReceiver.a();
    }
    this.roomInfoListeners.clear();
  }
  
  void init(IQQLiveSDK paramIQQLiveSDK)
  {
    this.statusReceiver = ((IQQLiveRoomPushService)paramIQQLiveSDK.getExtModule("roomPush")).a();
    this.statusReceiver.a(75, new LiveRoomStatusService.1(this));
  }
  
  void registerRoomInfoListener(LiveRoomStatusListener paramLiveRoomStatusListener)
  {
    if (!this.roomInfoListeners.contains(paramLiveRoomStatusListener)) {
      this.roomInfoListeners.add(paramLiveRoomStatusListener);
    }
  }
  
  void reset()
  {
    PushReceiver localPushReceiver = this.statusReceiver;
    if (localPushReceiver != null) {
      localPushReceiver.a();
    }
    this.roomInfoListeners.clear();
  }
  
  void unRegisterRoomInfoListener(LiveRoomStatusListener paramLiveRoomStatusListener)
  {
    this.roomInfoListeners.remove(paramLiveRoomStatusListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.impl.room.LiveRoomStatusService
 * JD-Core Version:    0.7.0.1
 */