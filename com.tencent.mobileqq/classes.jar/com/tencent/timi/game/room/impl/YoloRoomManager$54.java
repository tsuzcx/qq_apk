package com.tencent.timi.game.room.impl;

import com.tencent.timi.game.room.api.YoloRoomInterface.YoloRoomLifecycleListener;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

class YoloRoomManager$54
  implements YoloRoomInterface.YoloRoomLifecycleListener
{
  YoloRoomManager$54(YoloRoomManager paramYoloRoomManager) {}
  
  public void a(long paramLong, int paramInt)
  {
    Iterator localIterator = YoloRoomManager.s(this.a).iterator();
    while (localIterator.hasNext()) {
      ((YoloRoomInterface.YoloRoomLifecycleListener)localIterator.next()).a(paramLong, paramInt);
    }
  }
  
  public void b(long paramLong, int paramInt)
  {
    Iterator localIterator = YoloRoomManager.s(this.a).iterator();
    while (localIterator.hasNext()) {
      ((YoloRoomInterface.YoloRoomLifecycleListener)localIterator.next()).b(paramLong, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.room.impl.YoloRoomManager.54
 * JD-Core Version:    0.7.0.1
 */