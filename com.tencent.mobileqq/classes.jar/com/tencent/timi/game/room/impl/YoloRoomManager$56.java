package com.tencent.timi.game.room.impl;

import com.tencent.timi.game.room.api.YoloRoomInterface.YoloRoomTgpaListener;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

class YoloRoomManager$56
  implements YoloRoomInterface.YoloRoomTgpaListener
{
  YoloRoomManager$56(YoloRoomManager paramYoloRoomManager) {}
  
  public void a()
  {
    Iterator localIterator = YoloRoomManager.t(this.a).iterator();
    while (localIterator.hasNext()) {
      ((YoloRoomInterface.YoloRoomTgpaListener)localIterator.next()).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.room.impl.YoloRoomManager.56
 * JD-Core Version:    0.7.0.1
 */