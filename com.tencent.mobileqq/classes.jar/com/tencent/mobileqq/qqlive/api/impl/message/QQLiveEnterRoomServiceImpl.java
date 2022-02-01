package com.tencent.mobileqq.qqlive.api.impl.message;

import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.message.IQQLiveEnterRoomService;
import com.tencent.mobileqq.qqlive.api.room.ILiveRoom;
import com.tencent.mobileqq.qqlive.callback.room.RoomAudienceInfoListener;
import com.tencent.mobileqq.qqlive.data.message.LiveMessageData.SpeakerInfo;
import com.tencent.mobileqq.qqlive.data.room.BaseAnchorInfo;
import com.tencent.mobileqq.qqlive.data.room.RoomAudienceInfo;
import com.tencent.mobileqq.qqlive.push.api.IQQLiveRoomPushService;
import com.tencent.mobileqq.qqlive.push.api.PushReceiver;
import com.tencent.protobuf.newRoomsvrPushmsg.nano.PushUserEnterRoom;
import com.tencent.protobuf.newRoomsvrPushmsg.nano.UserInfo;
import com.tencent.protobuf.newRoomsvrPushmsg.nano.UserList;
import com.tencent.qphone.base.util.QLog;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

public class QQLiveEnterRoomServiceImpl
  implements IQQLiveEnterRoomService
{
  private static final String TAG = "QQLiveEnterRoomService";
  private static final int USER_ENTER_ROOM_CMD = 200;
  private static final int USER_JOIN_ROOM = 1;
  private ILiveRoom currentRoom = null;
  private PushReceiver enterRoomPushReceiver;
  private final CopyOnWriteArraySet<RoomAudienceInfoListener> enterRoomReceiveListenerSet = new CopyOnWriteArraySet();
  
  private void initEnterRoomPushListener(IQQLiveSDK paramIQQLiveSDK)
  {
    paramIQQLiveSDK = (IQQLiveRoomPushService)paramIQQLiveSDK.getExtModule("roomPush");
    if (paramIQQLiveSDK == null) {
      return;
    }
    this.enterRoomPushReceiver = paramIQQLiveSDK.a().a(200, new QQLiveEnterRoomServiceImpl.1(this));
  }
  
  private void notifyAudienceEnterRoom(ILiveRoom paramILiveRoom, PushUserEnterRoom paramPushUserEnterRoom, CopyOnWriteArraySet<RoomAudienceInfoListener> paramCopyOnWriteArraySet)
  {
    if ((paramILiveRoom != null) && (paramPushUserEnterRoom != null) && (paramCopyOnWriteArraySet != null))
    {
      if (paramPushUserEnterRoom.a == null) {
        return;
      }
      paramILiveRoom = paramILiveRoom.getAnchorInfo();
      if (paramILiveRoom == null) {
        return;
      }
      if (paramPushUserEnterRoom.a.a == paramILiveRoom.getAnchorUid()) {
        return;
      }
      paramILiveRoom = new LiveMessageData.SpeakerInfo();
      paramILiveRoom.mSpeakId = paramPushUserEnterRoom.a.a;
      paramILiveRoom.mSpeakerName = paramPushUserEnterRoom.a.f;
      paramILiveRoom.mLogo = new String(paramPushUserEnterRoom.a.i, Charset.forName("UTF-8"));
      paramILiveRoom.mClientType = paramPushUserEnterRoom.a.e;
      paramILiveRoom.mBusinessUid = paramPushUserEnterRoom.a.k;
      paramPushUserEnterRoom = paramCopyOnWriteArraySet.iterator();
      while (paramPushUserEnterRoom.hasNext()) {
        ((RoomAudienceInfoListener)paramPushUserEnterRoom.next()).a(paramILiveRoom);
      }
    }
  }
  
  private void notifyAudienceInfo(PushUserEnterRoom paramPushUserEnterRoom, CopyOnWriteArraySet<RoomAudienceInfoListener> paramCopyOnWriteArraySet)
  {
    if (paramPushUserEnterRoom != null)
    {
      if (paramCopyOnWriteArraySet == null) {
        return;
      }
      RoomAudienceInfo localRoomAudienceInfo = new RoomAudienceInfo();
      localRoomAudienceInfo.fakeTotalPeople = paramPushUserEnterRoom.j;
      if (paramPushUserEnterRoom.g != null) {
        localRoomAudienceInfo.userCount = paramPushUserEnterRoom.g.a;
      }
      paramPushUserEnterRoom = paramCopyOnWriteArraySet.iterator();
      while (paramPushUserEnterRoom.hasNext()) {
        ((RoomAudienceInfoListener)paramPushUserEnterRoom.next()).a(localRoomAudienceInfo);
      }
    }
  }
  
  public void addEnterRoomMessageListener(RoomAudienceInfoListener paramRoomAudienceInfoListener)
  {
    if (paramRoomAudienceInfoListener != null) {
      this.enterRoomReceiveListenerSet.add(paramRoomAudienceInfoListener);
    }
  }
  
  public void bindRoom(ILiveRoom paramILiveRoom)
  {
    this.currentRoom = paramILiveRoom;
  }
  
  public void delEnterRoomMessageListener(RoomAudienceInfoListener paramRoomAudienceInfoListener)
  {
    if (paramRoomAudienceInfoListener != null) {
      this.enterRoomReceiveListenerSet.remove(paramRoomAudienceInfoListener);
    }
  }
  
  public void destroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQLiveEnterRoomService", 4, "IQQLiveEnterRoomService destroy");
    }
    PushReceiver localPushReceiver = this.enterRoomPushReceiver;
    if (localPushReceiver != null) {
      localPushReceiver.a();
    }
    this.enterRoomReceiveListenerSet.clear();
  }
  
  public void init(IQQLiveSDK paramIQQLiveSDK)
  {
    if (paramIQQLiveSDK != null) {
      initEnterRoomPushListener(paramIQQLiveSDK);
    }
  }
  
  public void reset()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQLiveEnterRoomService", 4, "IQQLiveEnterRoomService reset");
    }
    PushReceiver localPushReceiver = this.enterRoomPushReceiver;
    if (localPushReceiver != null) {
      localPushReceiver.a();
    }
    this.enterRoomReceiveListenerSet.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.impl.message.QQLiveEnterRoomServiceImpl
 * JD-Core Version:    0.7.0.1
 */