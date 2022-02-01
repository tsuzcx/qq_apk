package com.tencent.timi.game.room.impl;

import com.tencent.timi.game.room.api.YoloRoomInterface.YoloRoomAudioListener;
import com.tencent.timi.game.trtc.roomservice.voiceroom.info.RoomState;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

class YoloRoomManager$51
  implements YoloRoomInterface.YoloRoomAudioListener
{
  YoloRoomManager$51(YoloRoomManager paramYoloRoomManager) {}
  
  public void a(RoomState paramRoomState)
  {
    Iterator localIterator = YoloRoomManager.q(this.a).iterator();
    while (localIterator.hasNext()) {
      ((YoloRoomInterface.YoloRoomAudioListener)localIterator.next()).a(paramRoomState);
    }
  }
  
  public void a(ConcurrentHashMap<String, Integer> paramConcurrentHashMap)
  {
    Iterator localIterator = YoloRoomManager.q(this.a).iterator();
    while (localIterator.hasNext()) {
      ((YoloRoomInterface.YoloRoomAudioListener)localIterator.next()).a(paramConcurrentHashMap);
    }
  }
  
  public void b(RoomState paramRoomState)
  {
    Iterator localIterator = YoloRoomManager.q(this.a).iterator();
    while (localIterator.hasNext()) {
      ((YoloRoomInterface.YoloRoomAudioListener)localIterator.next()).b(paramRoomState);
    }
  }
  
  public void b(ConcurrentHashMap<String, Integer> paramConcurrentHashMap)
  {
    Iterator localIterator = YoloRoomManager.q(this.a).iterator();
    while (localIterator.hasNext()) {
      ((YoloRoomInterface.YoloRoomAudioListener)localIterator.next()).b(paramConcurrentHashMap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.room.impl.YoloRoomManager.51
 * JD-Core Version:    0.7.0.1
 */