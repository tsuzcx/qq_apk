package com.tencent.timi.game.room.impl.doublecheck;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.room.impl.YoloRoomList;
import com.tencent.timi.game.room.impl.YoloRoomManager;

class RoomGameDoubleCheckDialog$2
  implements View.OnClickListener
{
  RoomGameDoubleCheckDialog$2(RoomGameDoubleCheckDialog paramRoomGameDoubleCheckDialog) {}
  
  public void onClick(View paramView)
  {
    YoloRoomManager localYoloRoomManager = YoloRoomList.a().b(RoomGameDoubleCheckDialog.a(this.a));
    if (localYoloRoomManager != null) {
      localYoloRoomManager.e(null);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.room.impl.doublecheck.RoomGameDoubleCheckDialog.2
 * JD-Core Version:    0.7.0.1
 */