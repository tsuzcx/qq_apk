package com.tencent.timi.game.room.impl;

import com.tencent.timi.game.env.Env;
import com.tencent.timi.game.utils.Logger;
import com.tencent.timi.game.utils.ThreadPool;

class YoloRoomManager$41
  implements Runnable
{
  YoloRoomManager$41(YoloRoomManager paramYoloRoomManager) {}
  
  public void run()
  {
    try
    {
      long l = YoloRoomManager.i(this.this$0);
      if (l <= 0L) {
        return;
      }
      YoloRoomManager.j(this.this$0);
      return;
    }
    catch (Exception localException)
    {
      label23:
      break label23;
    }
    Logger.a("YoloRoomManager", "requestRunnable mRoomId ERROR", new Exception());
    if (Env.c()) {
      ThreadPool.a(new YoloRoomManager.41.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.room.impl.YoloRoomManager.41
 * JD-Core Version:    0.7.0.1
 */