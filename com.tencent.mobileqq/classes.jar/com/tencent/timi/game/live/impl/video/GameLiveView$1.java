package com.tencent.timi.game.live.impl.video;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.timi.game.live.api.ILiveGestureListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/live/impl/video/GameLiveView$1", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "onContextClick", "", "e", "Landroid/view/MotionEvent;", "onDoubleTap", "onDown", "onScroll", "e1", "e2", "distanceX", "", "distanceY", "onSingleTapConfirmed", "onSingleTapUp", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class GameLiveView$1
  extends GestureDetector.SimpleOnGestureListener
{
  public boolean onContextClick(@NotNull MotionEvent paramMotionEvent)
  {
    Intrinsics.checkParameterIsNotNull(paramMotionEvent, "e");
    return true;
  }
  
  public boolean onDoubleTap(@NotNull MotionEvent paramMotionEvent)
  {
    Intrinsics.checkParameterIsNotNull(paramMotionEvent, "e");
    paramMotionEvent = this.a.getLiveGestureListener();
    if (paramMotionEvent != null) {
      paramMotionEvent.b();
    }
    return true;
  }
  
  public boolean onDown(@NotNull MotionEvent paramMotionEvent)
  {
    Intrinsics.checkParameterIsNotNull(paramMotionEvent, "e");
    this.a.setCurGestureStatus(0);
    return true;
  }
  
  public boolean onScroll(@NotNull MotionEvent paramMotionEvent1, @NotNull MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    Intrinsics.checkParameterIsNotNull(paramMotionEvent1, "e1");
    Intrinsics.checkParameterIsNotNull(paramMotionEvent2, "e2");
    int i = this.a.getCurGestureStatus();
    if (i != 0)
    {
      if (i != 1) {
        return true;
      }
      i = RangesKt.coerceAtMost(100, RangesKt.coerceAtLeast(0, (int)(paramFloat2 / (this.a.getHeight() / (GameLiveView.f(this.a) * 2)) + GameLiveView.g(this.a))));
      paramMotionEvent1 = this.a.getLiveGestureListener();
      if ((paramMotionEvent1 != null) && (paramMotionEvent1.a(i)))
      {
        GameLiveView.b(this.a, i);
        return true;
      }
    }
    else if (((Math.abs(paramFloat1) > GameLiveView.e(this.a)) || (Math.abs(paramFloat2) > GameLiveView.e(this.a))) && (Math.abs(paramFloat2) > Math.abs(paramFloat1)) && (paramMotionEvent1.getX() >= this.a.getWidth() / 2))
    {
      this.a.setCurGestureStatus(1);
    }
    return true;
  }
  
  public boolean onSingleTapConfirmed(@NotNull MotionEvent paramMotionEvent)
  {
    Intrinsics.checkParameterIsNotNull(paramMotionEvent, "e");
    paramMotionEvent = this.a.getLiveGestureListener();
    if (paramMotionEvent != null) {
      paramMotionEvent.a();
    }
    return true;
  }
  
  public boolean onSingleTapUp(@NotNull MotionEvent paramMotionEvent)
  {
    Intrinsics.checkParameterIsNotNull(paramMotionEvent, "e");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.live.impl.video.GameLiveView.1
 * JD-Core Version:    0.7.0.1
 */