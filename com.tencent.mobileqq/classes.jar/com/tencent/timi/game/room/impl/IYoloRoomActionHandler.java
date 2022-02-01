package com.tencent.timi.game.room.impl;

import com.tencent.timi.game.room.api.YoloRoomInterface.IYoloRoomListener;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomAction;

public abstract class IYoloRoomActionHandler
{
  protected YoloRoomManager a;
  protected YoloRoomInterface.IYoloRoomListener b;
  
  public IYoloRoomActionHandler(YoloRoomManager paramYoloRoomManager, YoloRoomInterface.IYoloRoomListener paramIYoloRoomListener)
  {
    this.a = paramYoloRoomManager;
    this.b = paramIYoloRoomListener;
  }
  
  protected abstract boolean a(int paramInt, YoloRoomOuterClass.YoloRoomAction paramYoloRoomAction);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.room.impl.IYoloRoomActionHandler
 * JD-Core Version:    0.7.0.1
 */