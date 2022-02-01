package com.tencent.timi.game.room.impl.tgpa;

import com.tencent.timi.game.room.impl.YoloRoomList;

class YoloRoomTGPALogic$1$4
  implements Runnable
{
  YoloRoomTGPALogic$1$4(YoloRoomTGPALogic.1 param1, float paramFloat) {}
  
  public void run()
  {
    YoloRoomList localYoloRoomList = YoloRoomList.a();
    int i;
    if (this.a >= 100.0F) {
      i = 0;
    } else {
      i = 1;
    }
    localYoloRoomList.a(false, YoloRoomTGPALogic.a(i, (int)this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.room.impl.tgpa.YoloRoomTGPALogic.1.4
 * JD-Core Version:    0.7.0.1
 */