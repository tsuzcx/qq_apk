package com.tencent.timi.game.component.chat.message;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"}, k=3, mv={1, 1, 16})
final class BaseMessageView$positionOnTouchListener$1
  implements View.OnTouchListener
{
  BaseMessageView$positionOnTouchListener$1(BaseMessageView paramBaseMessageView) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    paramView = this.a;
    Intrinsics.checkExpressionValueIsNotNull(paramMotionEvent, "event");
    BaseMessageView.a(paramView, (int)paramMotionEvent.getRawX());
    BaseMessageView.b(this.a, (int)paramMotionEvent.getRawY());
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.chat.message.BaseMessageView.positionOnTouchListener.1
 * JD-Core Version:    0.7.0.1
 */