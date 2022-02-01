package com.tencent.timi.game.room.impl.audio;

import androidx.lifecycle.Observer;
import com.tencent.timi.game.room.api.YoloRoomInterface.YoloRoomAudioListener;
import com.tencent.timi.game.trtc.roomservice.voiceroom.info.RoomState;

class YoloRoomMediaLogic$5
  implements Observer<RoomState>
{
  public void a(RoomState paramRoomState)
  {
    if (YoloRoomMediaLogic.d(this.a) != null) {
      YoloRoomMediaLogic.d(this.a).b(paramRoomState);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.room.impl.audio.YoloRoomMediaLogic.5
 * JD-Core Version:    0.7.0.1
 */