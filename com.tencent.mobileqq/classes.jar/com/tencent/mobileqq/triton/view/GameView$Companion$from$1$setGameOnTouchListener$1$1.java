package com.tencent.mobileqq.triton.view;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"}, k=3, mv={1, 1, 16})
final class GameView$Companion$from$1$setGameOnTouchListener$1$1
  implements View.OnTouchListener
{
  GameView$Companion$from$1$setGameOnTouchListener$1$1(Function1 paramFunction1) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    paramView = this.$it;
    Intrinsics.checkExpressionValueIsNotNull(paramMotionEvent, "event");
    return ((Boolean)paramView.invoke(paramMotionEvent)).booleanValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.triton.view.GameView.Companion.from.1.setGameOnTouchListener.1.1
 * JD-Core Version:    0.7.0.1
 */