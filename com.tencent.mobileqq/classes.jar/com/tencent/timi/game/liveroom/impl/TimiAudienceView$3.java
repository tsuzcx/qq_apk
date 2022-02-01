package com.tencent.timi.game.liveroom.impl;

import com.tencent.mobileqq.qqlive.api.room.ILiveRoomOperation;
import com.tencent.timi.game.component.qqlive.api.ITgLiveRoomService;
import com.tencent.timi.game.liveroom.impl.live.widget.LiveRoomDisplayView.LiveViewListener;
import com.tencent.timi.game.router.ServiceCenter;
import org.jetbrains.annotations.NotNull;

class TimiAudienceView$3
  implements LiveRoomDisplayView.LiveViewListener
{
  TimiAudienceView$3(TimiAudienceView paramTimiAudienceView) {}
  
  public void a() {}
  
  public void a(@NotNull String paramString)
  {
    ILiveRoomOperation localILiveRoomOperation = ((ITgLiveRoomService)ServiceCenter.a(ITgLiveRoomService.class)).k(TimiAudienceView.b(this.a));
    if (localILiveRoomOperation != null) {
      localILiveRoomOperation.sendMessage(paramString, null, new TimiAudienceView.3.1(this));
    }
  }
  
  public void a(boolean paramBoolean)
  {
    TimiAudienceView.a(this.a, paramBoolean);
  }
  
  public void b(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.TimiAudienceView.3
 * JD-Core Version:    0.7.0.1
 */