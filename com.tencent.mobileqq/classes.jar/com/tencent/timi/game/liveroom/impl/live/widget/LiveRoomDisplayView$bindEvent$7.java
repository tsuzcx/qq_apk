package com.tencent.timi.game.liveroom.impl.live.widget;

import android.os.Handler;
import android.view.View;
import com.tencent.timi.game.live.api.IGameLiveView;
import com.tencent.timi.game.live.api.ILiveGestureListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/liveroom/impl/live/widget/LiveRoomDisplayView$bindEvent$7", "Lcom/tencent/timi/game/live/api/ILiveGestureListener;", "onDoubleTap", "", "onSingleTap", "onVolumeScroll", "", "expectVolume", "", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class LiveRoomDisplayView$bindEvent$7
  implements ILiveGestureListener
{
  public void a()
  {
    ((HorBottomControllerView)this.a.a(2131429626)).a();
    if (!LiveRoomDisplayView.g(this.a))
    {
      if (LiveRoomDisplayView.h(this.a))
      {
        LiveRoomDisplayView.i(this.a).removeCallbacks(LiveRoomDisplayView.j(this.a));
        LiveRoomDisplayView.k(this.a);
        return;
      }
      LiveRoomDisplayView.i(this.a).removeCallbacks(LiveRoomDisplayView.j(this.a));
      Object localObject1 = (BottomControllerView)this.a.a(2131429625);
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "bottomControllerView");
      Object localObject2;
      Object localObject3;
      if (((BottomControllerView)localObject1).getVisibility() == 0)
      {
        localObject1 = this.a;
        localObject2 = (TopControllerView)((LiveRoomDisplayView)localObject1).a(2131447704);
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "topControllerView");
        localObject2 = (View)localObject2;
        localObject3 = (BottomControllerView)this.a.a(2131429625);
        Intrinsics.checkExpressionValueIsNotNull(localObject3, "bottomControllerView");
        LiveRoomDisplayView.a((LiveRoomDisplayView)localObject1, (View)localObject2, (View)localObject3);
        localObject1 = (HorBottomControllerView)this.a.a(2131429626);
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "bottomControllerViewHor");
        ((HorBottomControllerView)localObject1).setTranslationY(0.0F);
      }
      else
      {
        localObject1 = this.a;
        localObject2 = (TopControllerView)((LiveRoomDisplayView)localObject1).a(2131447704);
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "topControllerView");
        localObject2 = (View)localObject2;
        localObject3 = (HorBottomControllerView)this.a.a(2131429626);
        Intrinsics.checkExpressionValueIsNotNull(localObject3, "bottomControllerViewHor");
        LiveRoomDisplayView.a((LiveRoomDisplayView)localObject1, (View)localObject2, (View)localObject3);
        localObject1 = (BottomControllerView)this.a.a(2131429625);
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "bottomControllerView");
        ((BottomControllerView)localObject1).setTranslationY(0.0F);
      }
      LiveRoomDisplayView.d(this.a);
    }
  }
  
  public boolean a(int paramInt)
  {
    if (LiveRoomDisplayView.l(this.a))
    {
      if (!LiveRoomDisplayView.m(this.a)) {
        return false;
      }
      if ((LiveRoomDisplayView.n(this.a)) && (paramInt > 0)) {
        LiveRoomDisplayView.o(this.a);
      } else if ((!LiveRoomDisplayView.n(this.a)) && (paramInt == 0)) {
        LiveRoomDisplayView.o(this.a);
      }
      LiveRoomDisplayView.a(this.a, paramInt);
      LiveRoomDisplayView.p(this.a).setLiveVolume(paramInt);
      VolumeView localVolumeView = (VolumeView)this.a.a(2131434165);
      if (localVolumeView != null) {
        localVolumeView.a(paramInt);
      }
      LiveRoomDisplayView.q(this.a);
    }
    return true;
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.live.widget.LiveRoomDisplayView.bindEvent.7
 * JD-Core Version:    0.7.0.1
 */