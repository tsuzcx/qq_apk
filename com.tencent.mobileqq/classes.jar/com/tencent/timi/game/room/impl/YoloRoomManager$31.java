package com.tencent.timi.game.room.impl;

import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.timi.game.room.api.DoYoloRoomCmdResultListsner;
import com.tencent.timi.game.team.impl.event.TeamLaneEvent;
import com.tencent.timi.game.utils.IResultListener;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomCmdRsp;

class YoloRoomManager$31
  implements DoYoloRoomCmdResultListsner
{
  YoloRoomManager$31(YoloRoomManager paramYoloRoomManager, int paramInt, IResultListener paramIResultListener) {}
  
  public void a(int paramInt, String paramString, long paramLong, boolean paramBoolean)
  {
    IResultListener localIResultListener = this.b;
    if (localIResultListener != null) {
      localIResultListener.a(paramInt, paramString);
    }
  }
  
  public void a(YoloRoomOuterClass.YoloRoomCmdRsp paramYoloRoomCmdRsp, long paramLong, boolean paramBoolean)
  {
    if (!paramBoolean) {
      YoloRoomManager.f(this.c);
    }
    SimpleEventBus.getInstance().dispatchEvent(new TeamLaneEvent(this.a));
    IResultListener localIResultListener = this.b;
    if (localIResultListener != null) {
      localIResultListener.a(paramYoloRoomCmdRsp);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.room.impl.YoloRoomManager.31
 * JD-Core Version:    0.7.0.1
 */