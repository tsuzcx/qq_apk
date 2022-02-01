package com.tencent.xaction.trigger;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.xaction.trigger.gesture.GestureRecognizer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "v", "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", "onTouch"}, k=3, mv={1, 1, 16})
final class GestureTrigger$monitor$2
  implements View.OnTouchListener
{
  GestureTrigger$monitor$2(GestureTrigger paramGestureTrigger) {}
  
  public final boolean onTouch(@NotNull View paramView, @NotNull MotionEvent paramMotionEvent)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "v");
    Intrinsics.checkParameterIsNotNull(paramMotionEvent, "event");
    paramView = GestureTrigger.access$getGestureRecognizer$p(this.a);
    if (paramView != null) {
      paramView.a(paramMotionEvent);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xaction.trigger.GestureTrigger.monitor.2
 * JD-Core Version:    0.7.0.1
 */