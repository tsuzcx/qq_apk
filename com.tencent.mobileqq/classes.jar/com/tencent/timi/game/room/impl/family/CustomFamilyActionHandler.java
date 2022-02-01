package com.tencent.timi.game.room.impl.family;

import com.tencent.timi.game.room.api.YoloRoomInterface.IYoloRoomListener;
import com.tencent.timi.game.room.impl.IYoloRoomActionHandler;
import com.tencent.timi.game.room.impl.YoloRoomManager;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomAction;

public class CustomFamilyActionHandler
  extends IYoloRoomActionHandler
{
  public CustomFamilyActionHandler(YoloRoomManager paramYoloRoomManager, YoloRoomInterface.IYoloRoomListener paramIYoloRoomListener)
  {
    super(paramYoloRoomManager, paramIYoloRoomListener);
  }
  
  protected boolean a(int paramInt, YoloRoomOuterClass.YoloRoomAction paramYoloRoomAction)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.room.impl.family.CustomFamilyActionHandler
 * JD-Core Version:    0.7.0.1
 */