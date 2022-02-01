package com.tencent.timi.game.liveroom.impl.floating;

import com.tencent.mobileqq.qqlive.api.room.ILiveRoom;
import com.tencent.mobileqq.qqlive.api.room.ILiveTPPlayerRoom;
import com.tencent.timi.game.component.qqlive.api.ITgLiveRoomService;
import com.tencent.timi.game.router.ServiceCenter;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class TGLiveAudienceFloatingView$5$onNetMobile2Wifi$1
  implements Runnable
{
  TGLiveAudienceFloatingView$5$onNetMobile2Wifi$1(TGLiveAudienceFloatingView.5 param5) {}
  
  public final void run()
  {
    ILiveRoom localILiveRoom = ((ITgLiveRoomService)ServiceCenter.a(ITgLiveRoomService.class)).b(0L);
    Object localObject = localILiveRoom;
    if (!(localILiveRoom instanceof ILiveTPPlayerRoom)) {
      localObject = null;
    }
    localObject = (ILiveTPPlayerRoom)localObject;
    if (localObject != null) {
      ((ILiveTPPlayerRoom)localObject).play();
    }
    TGLiveAudienceFloatingView.a(this.this$0.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.floating.TGLiveAudienceFloatingView.5.onNetMobile2Wifi.1
 * JD-Core Version:    0.7.0.1
 */