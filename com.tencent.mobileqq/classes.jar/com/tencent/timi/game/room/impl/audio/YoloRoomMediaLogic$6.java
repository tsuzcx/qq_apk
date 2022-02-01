package com.tencent.timi.game.room.impl.audio;

import androidx.lifecycle.Observer;
import com.tencent.timi.game.room.api.YoloRoomInterface.YoloRoomAudioListener;
import java.util.concurrent.ConcurrentHashMap;

class YoloRoomMediaLogic$6
  implements Observer<ConcurrentHashMap<String, Integer>>
{
  public void a(ConcurrentHashMap<String, Integer> paramConcurrentHashMap)
  {
    if (YoloRoomMediaLogic.d(this.a) != null) {
      YoloRoomMediaLogic.d(this.a).b(paramConcurrentHashMap);
    }
    if ((paramConcurrentHashMap != null) && (paramConcurrentHashMap.size() > 0)) {
      YoloRoomMediaLogic.f(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.room.impl.audio.YoloRoomMediaLogic.6
 * JD-Core Version:    0.7.0.1
 */