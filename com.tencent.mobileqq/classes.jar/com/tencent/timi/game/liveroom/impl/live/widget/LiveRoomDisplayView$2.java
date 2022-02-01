package com.tencent.timi.game.liveroom.impl.live.widget;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.tencent.timi.game.live.api.DanmakuChooserView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Boolean;)V"}, k=3, mv={1, 1, 16})
final class LiveRoomDisplayView$2<T>
  implements Observer<Boolean>
{
  LiveRoomDisplayView$2(LiveRoomDisplayView paramLiveRoomDisplayView) {}
  
  public final void a(Boolean paramBoolean)
  {
    if (!LiveRoomDisplayView.c(this.a)) {
      return;
    }
    ((DanmakuChooserView)this.a.a(2131431566)).a((LifecycleOwner)this.a, Intrinsics.areEqual(paramBoolean, Boolean.valueOf(true)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.live.widget.LiveRoomDisplayView.2
 * JD-Core Version:    0.7.0.1
 */