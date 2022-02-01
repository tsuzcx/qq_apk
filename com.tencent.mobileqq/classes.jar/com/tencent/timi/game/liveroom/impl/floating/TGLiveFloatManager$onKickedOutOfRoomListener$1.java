package com.tencent.timi.game.liveroom.impl.floating;

import com.tencent.mobileqq.qqlive.data.room.BaseRoomInfo;
import com.tencent.mobileqq.qqlive.listener.supervision.OnKickedOutOfRoomListener;
import com.tencent.timi.game.component.qqlive.api.ITgLiveRoomService;
import com.tencent.timi.game.router.ServiceCenter;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onKickedOut"}, k=3, mv={1, 1, 16})
final class TGLiveFloatManager$onKickedOutOfRoomListener$1
  implements OnKickedOutOfRoomListener
{
  public static final 1 a = new 1();
  
  public final void a(String paramString)
  {
    paramString = (ITgLiveRoomService)ServiceCenter.a(ITgLiveRoomService.class);
    long l2 = 0L;
    long l1 = l2;
    if (paramString != null)
    {
      paramString = paramString.h(0L);
      l1 = l2;
      if (paramString != null) {
        l1 = paramString.getRoomId();
      }
    }
    TGLiveFloatManager.a.a(l1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.floating.TGLiveFloatManager.onKickedOutOfRoomListener.1
 * JD-Core Version:    0.7.0.1
 */