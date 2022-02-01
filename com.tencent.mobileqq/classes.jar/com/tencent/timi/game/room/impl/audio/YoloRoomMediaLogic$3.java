package com.tencent.timi.game.room.impl.audio;

import androidx.lifecycle.Observer;
import com.tencent.timi.game.room.api.YoloRoomInterface.YoloRoomAudioListener;
import com.tencent.timi.game.trtc.roomservice.voiceroom.info.RoomState;

class YoloRoomMediaLogic$3
  implements Observer<RoomState>
{
  YoloRoomMediaLogic$3(YoloRoomMediaLogic paramYoloRoomMediaLogic) {}
  
  public void a(RoomState paramRoomState)
  {
    if (YoloRoomMediaLogic.d(this.a) != null) {
      YoloRoomMediaLogic.d(this.a).a(paramRoomState);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.room.impl.audio.YoloRoomMediaLogic.3
 * JD-Core Version:    0.7.0.1
 */