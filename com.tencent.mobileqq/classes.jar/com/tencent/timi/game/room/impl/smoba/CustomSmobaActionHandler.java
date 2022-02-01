package com.tencent.timi.game.room.impl.smoba;

import com.tencent.timi.game.room.api.YoloRoomInterface.IYoloRoomListener;
import com.tencent.timi.game.room.impl.IYoloRoomActionHandler;
import com.tencent.timi.game.room.impl.YoloRoomManager;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomAction;

public class CustomSmobaActionHandler
  extends IYoloRoomActionHandler
{
  public CustomSmobaActionHandler(YoloRoomManager paramYoloRoomManager, YoloRoomInterface.IYoloRoomListener paramIYoloRoomListener)
  {
    super(paramYoloRoomManager, paramIYoloRoomListener);
  }
  
  protected boolean a(int paramInt, YoloRoomOuterClass.YoloRoomAction paramYoloRoomAction)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (paramInt != 201)
    {
      bool1 = bool2;
      if (paramInt != 250)
      {
        bool1 = bool2;
        if (paramInt != 252)
        {
          bool1 = bool2;
          if (paramInt != 203)
          {
            bool1 = bool2;
            if (paramInt != 204) {
              bool1 = false;
            }
          }
        }
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.room.impl.smoba.CustomSmobaActionHandler
 * JD-Core Version:    0.7.0.1
 */