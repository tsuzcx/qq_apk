package com.tencent.timi.game.room.impl.doublecheck;

import com.tencent.timi.game.utils.ThreadPool;
import java.util.TimerTask;

class RoomGameDoubleCheckDialog$4
  extends TimerTask
{
  RoomGameDoubleCheckDialog$4(RoomGameDoubleCheckDialog paramRoomGameDoubleCheckDialog) {}
  
  public void run()
  {
    ThreadPool.a(new RoomGameDoubleCheckDialog.4.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.room.impl.doublecheck.RoomGameDoubleCheckDialog.4
 * JD-Core Version:    0.7.0.1
 */