package com.tencent.timi.game.trtc.roomservice.voiceroom.info;

import androidx.lifecycle.LifecycleRegistry;
import com.tencent.timi.game.trtc.roomservice.RoomHandle;
import com.tencent.timi.game.trtc.roomservice.RoomParam;
import com.tencent.timi.game.trtc.roomservice.voiceroom.TRTCRoom;

public class SubRoomWrapper
{
  public TRTCRoom a;
  
  public SubRoomWrapper(SubRoomState paramSubRoomState, RoomHandle paramRoomHandle)
  {
    this.a = new TRTCRoom(new LifecycleRegistry(null), RoomParam.a(paramSubRoomState.c, paramSubRoomState.d), paramRoomHandle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.trtc.roomservice.voiceroom.info.SubRoomWrapper
 * JD-Core Version:    0.7.0.1
 */