package com.tencent.xaction.trigger;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "v", "Landroid/view/View;", "motionEvent", "Landroid/view/MotionEvent;", "onTouch"}, k=3, mv={1, 1, 16})
final class CardFlipTrigger$monitor$1
  implements View.OnTouchListener
{
  CardFlipTrigger$monitor$1(CardFlipTrigger paramCardFlipTrigger) {}
  
  public final boolean onTouch(@NotNull View paramView, @NotNull MotionEvent paramMotionEvent)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "v");
    Intrinsics.checkParameterIsNotNull(paramMotionEvent, "motionEvent");
    return CardFlipTrigger.a(this.a, paramView, paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xaction.trigger.CardFlipTrigger.monitor.1
 * JD-Core Version:    0.7.0.1
 */