package com.tencent.tkd.topicsdk.widget.videocrop;

import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.widget.Scroller;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tkd/topicsdk/widget/videocrop/FramesProcessor$mGestureListener$1", "Landroid/view/GestureDetector$OnGestureListener;", "onDown", "", "e", "Landroid/view/MotionEvent;", "onFling", "e1", "e2", "velocityX", "", "velocityY", "onLongPress", "", "onScroll", "distanceX", "distanceY", "onShowPress", "onSingleTapUp", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class FramesProcessor$mGestureListener$1
  implements GestureDetector.OnGestureListener
{
  public boolean onDown(@NotNull MotionEvent paramMotionEvent)
  {
    Intrinsics.checkParameterIsNotNull(paramMotionEvent, "e");
    FramesProcessor.a(this.a).forceFinished(true);
    return true;
  }
  
  public boolean onFling(@NotNull MotionEvent arg1, @NotNull MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    Intrinsics.checkParameterIsNotNull(???, "e1");
    Intrinsics.checkParameterIsNotNull(paramMotionEvent2, "e2");
    synchronized (this.a)
    {
      FramesProcessor.a(this.a).fling((int)FramesProcessor.a(this.a), 0, (int)-paramFloat1, 0, (int)FramesProcessor.b(this.a), (int)FramesProcessor.c(this.a), 0, 0);
      paramMotionEvent2 = Unit.INSTANCE;
      FramesProcessor.b(this.a);
      return true;
    }
  }
  
  public void onLongPress(@NotNull MotionEvent paramMotionEvent)
  {
    Intrinsics.checkParameterIsNotNull(paramMotionEvent, "e");
  }
  
  public boolean onScroll(@NotNull MotionEvent arg1, @NotNull MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    Intrinsics.checkParameterIsNotNull(???, "e1");
    Intrinsics.checkParameterIsNotNull(paramMotionEvent2, "e2");
    synchronized (this.a)
    {
      paramMotionEvent2 = this.a;
      FramesProcessor.a(paramMotionEvent2, FramesProcessor.a(paramMotionEvent2) + paramFloat1);
      paramMotionEvent2 = Unit.INSTANCE;
      if (FramesProcessor.a(this.a) < FramesProcessor.b(this.a))
      {
        ??? = this.a;
        FramesProcessor.a(???, FramesProcessor.b(???));
      }
      if (FramesProcessor.a(this.a) > FramesProcessor.c(this.a))
      {
        ??? = this.a;
        FramesProcessor.a(???, FramesProcessor.c(???));
      }
      paramFloat1 = FramesProcessor.a(this.a);
      paramFloat2 = FramesProcessor.d(this.a);
      ??? = this.a;
      FramesProcessor.b(???, FramesProcessor.a(???));
      if (FramesProcessor.a(this.a, paramFloat1 - paramFloat2)) {
        return true;
      }
      FramesProcessor.a(this.a);
      ??? = FramesProcessor.a(this.a);
      if (??? != null) {
        ???.a(FramesProcessor.a(this.a), FramesProcessor.b(this.a));
      }
      this.a.a().invalidate();
      ??? = FramesProcessor.a(this.a);
      if (??? != null) {
        ???.a(FramesProcessor.a(this.a), -FramesProcessor.a(this.a), FramesProcessor.e(this.a) - FramesProcessor.a(this.a));
      }
      return true;
    }
  }
  
  public void onShowPress(@NotNull MotionEvent paramMotionEvent)
  {
    Intrinsics.checkParameterIsNotNull(paramMotionEvent, "e");
  }
  
  public boolean onSingleTapUp(@NotNull MotionEvent paramMotionEvent)
  {
    Intrinsics.checkParameterIsNotNull(paramMotionEvent, "e");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.widget.videocrop.FramesProcessor.mGestureListener.1
 * JD-Core Version:    0.7.0.1
 */