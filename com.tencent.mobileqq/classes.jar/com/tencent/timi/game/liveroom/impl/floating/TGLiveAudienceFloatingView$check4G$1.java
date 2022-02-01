package com.tencent.timi.game.liveroom.impl.floating;

import android.content.Context;
import com.tencent.mobileqq.qqlive.api.room.ILiveTPPlayerRoom;
import com.tencent.timi.game.component.qqlive.api.ITgLiveRoomService;
import com.tencent.timi.game.live.impl.WifiOr4GStateHolder;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.utils.ThreadPool;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class TGLiveAudienceFloatingView$check4G$1
  implements Runnable
{
  TGLiveAudienceFloatingView$check4G$1(TGLiveAudienceFloatingView paramTGLiveAudienceFloatingView) {}
  
  public final void run()
  {
    Object localObject1 = WifiOr4GStateHolder.a;
    Object localObject2 = this.this$0.getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "context");
    if (!((WifiOr4GStateHolder)localObject1).a((Context)localObject2))
    {
      ThreadPool.a((Runnable)new TGLiveAudienceFloatingView.check4G.1.1(this), 300L);
      return;
    }
    TGLiveAudienceFloatingView.a(this.this$0, false);
    localObject2 = ((ITgLiveRoomService)ServiceCenter.a(ITgLiveRoomService.class)).b(0L);
    localObject1 = localObject2;
    if (!(localObject2 instanceof ILiveTPPlayerRoom)) {
      localObject1 = null;
    }
    localObject1 = (ILiveTPPlayerRoom)localObject1;
    if (localObject1 != null) {
      ((ILiveTPPlayerRoom)localObject1).play();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.floating.TGLiveAudienceFloatingView.check4G.1
 * JD-Core Version:    0.7.0.1
 */