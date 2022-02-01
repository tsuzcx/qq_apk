package com.tencent.timi.game.room.impl;

import com.tencent.timi.game.room.api.YoloRoomInterface.YoloRoomMediaEnvCheckCallback;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

class YoloRoomManager$57
  implements YoloRoomInterface.YoloRoomMediaEnvCheckCallback
{
  YoloRoomManager$57(YoloRoomManager paramYoloRoomManager) {}
  
  public void a(boolean paramBoolean)
  {
    Iterator localIterator = YoloRoomManager.u(this.a).iterator();
    while (localIterator.hasNext()) {
      ((YoloRoomInterface.YoloRoomMediaEnvCheckCallback)localIterator.next()).a(paramBoolean);
    }
    YoloRoomManager.u(this.a).clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.room.impl.YoloRoomManager.57
 * JD-Core Version:    0.7.0.1
 */