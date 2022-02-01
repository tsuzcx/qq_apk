package com.tencent.timi.game.room.impl;

import com.tencent.timi.game.room.api.YoloRoomInterface.YoloRoomLifecycleListener;
import com.tencent.timi.game.utils.Logger;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

class YoloRoomList$1
  implements YoloRoomInterface.YoloRoomLifecycleListener
{
  YoloRoomList$1(YoloRoomList paramYoloRoomList) {}
  
  public void a(long paramLong, int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onEnterRoom ");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append(" - ");
    ((StringBuilder)localObject).append(paramInt);
    Logger.a("YoloRoomList", ((StringBuilder)localObject).toString());
    localObject = YoloRoomList.a(this.a).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((YoloRoomInterface.YoloRoomLifecycleListener)((Iterator)localObject).next()).a(paramLong, paramInt);
    }
  }
  
  public void b(long paramLong, int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onExitRoom ");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append(" - ");
    ((StringBuilder)localObject).append(paramInt);
    Logger.a("YoloRoomList", ((StringBuilder)localObject).toString());
    localObject = YoloRoomList.a(this.a).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((YoloRoomInterface.YoloRoomLifecycleListener)((Iterator)localObject).next()).b(paramLong, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.room.impl.YoloRoomList.1
 * JD-Core Version:    0.7.0.1
 */