package com.tencent.timi.game.trtc.roomservice.voiceroom;

import com.tencent.timi.game.trtc.roomservice.RoomParam;

class TRTCRoom$10
  extends RoomCloudListener
{
  TRTCRoom$10(TRTCRoom paramTRTCRoom1, TRTCRoom paramTRTCRoom2, RoomParam paramRoomParam)
  {
    super(paramTRTCRoom2, paramRoomParam);
  }
  
  public void onEnterRoom(long paramLong)
  {
    TRTCRoom.a(this.a);
    TRTCRoom.c(this.a);
    TRTCRoom.e(this.a);
    super.onEnterRoom(paramLong);
    TRTCRoom.b(this.a);
  }
  
  public void onRemoteUserEnterRoom(String paramString)
  {
    super.onRemoteUserEnterRoom(paramString);
    TRTCRoom.b(this.a);
  }
  
  public void onRemoteUserLeaveRoom(String paramString, int paramInt)
  {
    super.onRemoteUserLeaveRoom(paramString, paramInt);
    TRTCRoom.b(this.a);
  }
  
  public void onUserAudioAvailable(String paramString, boolean paramBoolean)
  {
    super.onUserAudioAvailable(paramString, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.trtc.roomservice.voiceroom.TRTCRoom.10
 * JD-Core Version:    0.7.0.1
 */