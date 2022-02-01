package com.tencent.xaction.trigger;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.xaction.api.IDecorView;
import com.tencent.xaction.api.IView;
import com.tencent.xaction.trigger.helper.CurrentState;
import com.tencent.xaction.trigger.touch.VelocityTrackerHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "v", "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", "onTouch"}, k=3, mv={1, 1, 16})
final class MoveTrigger$monitor$1
  implements View.OnTouchListener
{
  MoveTrigger$monitor$1(MoveTrigger paramMoveTrigger, IView paramIView, View paramView) {}
  
  public final boolean onTouch(@NotNull View paramView, @NotNull MotionEvent paramMotionEvent)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "v");
    Intrinsics.checkParameterIsNotNull(paramMotionEvent, "event");
    Object localObject;
    if (this.a.getVts() > 0.0F)
    {
      localObject = this.a.getTrackerHelper();
      if (localObject != null) {
        ((VelocityTrackerHelper)localObject).a(paramMotionEvent);
      }
    }
    float f1 = paramMotionEvent.getRawX();
    float f2 = paramMotionEvent.getRawY();
    this.a.getState().setCx(f1);
    this.a.getState().setCy(f2);
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2) {
          return true;
        }
        this.a.getState().setDx(f1 - this.a.getState().getLastX());
        this.a.getState().setDy(f2 - this.a.getState().getLastY());
        this.a.getState().setMovedX(f1 - this.a.getState().getLastDownX());
        this.a.getState().setMovedY(f2 - this.a.getState().getLastDownY());
        paramMotionEvent = this.a;
        localObject = this.b.getDecor().b();
        if (localObject == null) {
          Intrinsics.throwNpe();
        }
        paramMotionEvent.updateProgress((View)localObject, "move");
        paramMotionEvent = this.a;
        MoveTrigger.access$actionMove(paramMotionEvent, paramView, paramMotionEvent.getState().getDx(), this.a.getState().getDy());
        this.a.getState().setLastX(f1);
        this.a.getState().setLastY(f2);
        return true;
      }
      MoveTrigger.access$trackerActionUp(this.a, this.c, paramView);
      return true;
    }
    if (this.a.getVts() > 0.0F)
    {
      paramView = this.a.getTrackerHelper();
      if (paramView != null) {
        paramView.b();
      }
    }
    this.a.getState().setLastDownX(f1);
    this.a.getState().setLastDownY(f2);
    this.a.getState().setLastX(f1);
    this.a.getState().setLastY(f2);
    paramView = this.a;
    paramMotionEvent = this.b.getDecor().b();
    if (paramMotionEvent == null) {
      Intrinsics.throwNpe();
    }
    paramView.updateStatus(paramMotionEvent, "movedown");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xaction.trigger.MoveTrigger.monitor.1
 * JD-Core Version:    0.7.0.1
 */