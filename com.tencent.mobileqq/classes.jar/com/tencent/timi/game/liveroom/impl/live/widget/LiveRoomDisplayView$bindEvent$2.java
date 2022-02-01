package com.tencent.timi.game.liveroom.impl.live.widget;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/liveroom/impl/live/widget/LiveRoomDisplayView$bindEvent$2", "Lcom/tencent/timi/game/liveroom/impl/live/widget/ILiveMsgEven;", "onText", "", "text", "", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class LiveRoomDisplayView$bindEvent$2
  implements ILiveMsgEven
{
  public void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "text");
    LiveRoomDisplayView.LiveViewListener localLiveViewListener = LiveRoomDisplayView.b(this.a);
    if (localLiveViewListener != null) {
      localLiveViewListener.a(paramString);
    }
    ((HorBottomControllerView)this.a.a(2131429626)).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.live.widget.LiveRoomDisplayView.bindEvent.2
 * JD-Core Version:    0.7.0.1
 */