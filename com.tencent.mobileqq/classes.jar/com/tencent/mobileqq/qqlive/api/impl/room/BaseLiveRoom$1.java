package com.tencent.mobileqq.qqlive.api.impl.room;

import com.google.protobuf.nano.MessageNano;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.data.room.BaseRoomInfo;
import com.tencent.mobileqq.qqlive.sso.IQQLiveSsoModule;
import com.tencent.qqlive.pbexit_heart_list_room.nano.UserHeartBeatReq;

class BaseLiveRoom$1
  implements Runnable
{
  BaseLiveRoom$1(BaseLiveRoom paramBaseLiveRoom) {}
  
  public void run()
  {
    BaseRoomInfo localBaseRoomInfo = this.this$0.getRoomInfo();
    UserHeartBeatReq localUserHeartBeatReq = new UserHeartBeatReq();
    if (localBaseRoomInfo != null)
    {
      localUserHeartBeatReq.b = ((int)localBaseRoomInfo.getRoomId());
      localUserHeartBeatReq.a = ((int)localBaseRoomInfo.getRoomId());
    }
    ((IQQLiveSsoModule)this.this$0.liveSDK.getExtModule("sso_module")).a("trpc.qlive.ilive_room_broadcast_svr.RoomBroadcast", "UserHeartBeat", MessageNano.toByteArray(localUserHeartBeatReq), new BaseLiveRoom.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.impl.room.BaseLiveRoom.1
 * JD-Core Version:    0.7.0.1
 */