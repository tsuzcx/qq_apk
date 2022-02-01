package com.tencent.timi.game.component.qqlive.impl.anchor;

import com.tencent.mobileqq.qqlive.api.anchor.room.IQQLiveAnchorRoom;
import com.tencent.mobileqq.qqlive.data.room.realtime.LiveRealTimeInfo;
import com.tencent.timi.game.utils.IResultListener;

class TgLiveAnchorRoomManager$2$1
  implements IResultListener<LiveRealTimeInfo>
{
  TgLiveAnchorRoomManager$2$1(TgLiveAnchorRoomManager.2 param2) {}
  
  public void a(int paramInt, String paramString)
  {
    this.a.b.a(paramInt, paramString);
    this.a.c.destroy();
  }
  
  public void a(LiveRealTimeInfo paramLiveRealTimeInfo)
  {
    this.a.b.a(paramLiveRealTimeInfo);
    this.a.c.destroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.qqlive.impl.anchor.TgLiveAnchorRoomManager.2.1
 * JD-Core Version:    0.7.0.1
 */