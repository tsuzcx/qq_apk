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
    if (this.jdField_a_of_type_ComTencentXactionTriggerMoveTrigger.getVts() > 0.0F)
    {
      localObject = this.jdField_a_of_type_ComTencentXactionTriggerMoveTrigger.getTrackerHelper();
      if (localObject != null) {
        ((VelocityTrackerHelper)localObject).a(paramMotionEvent);
      }
    }
    float f1 = paramMotionEvent.getRawX();
    float f2 = paramMotionEvent.getRawY();
    this.jdField_a_of_type_ComTencentXactionTriggerMoveTrigger.getState().setCx(f1);
    this.jdField_a_of_type_ComTencentXactionTriggerMoveTrigger.getState().setCy(f2);
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2) {
          return true;
        }
        this.jdField_a_of_type_ComTencentXactionTriggerMoveTrigger.getState().setDx(f1 - this.jdField_a_of_type_ComTencentXactionTriggerMoveTrigger.getState().getLastX());
        this.jdField_a_of_type_ComTencentXactionTriggerMoveTrigger.getState().setDy(f2 - this.jdField_a_of_type_ComTencentXactionTriggerMoveTrigger.getState().getLastY());
        this.jdField_a_of_type_ComTencentXactionTriggerMoveTrigger.getState().setMovedX(f1 - this.jdField_a_of_type_ComTencentXactionTriggerMoveTrigger.getState().getLastDownX());
        this.jdField_a_of_type_ComTencentXactionTriggerMoveTrigger.getState().setMovedY(f2 - this.jdField_a_of_type_ComTencentXactionTriggerMoveTrigger.getState().getLastDownY());
        paramMotionEvent = this.jdField_a_of_type_ComTencentXactionTriggerMoveTrigger;
        localObject = this.jdField_a_of_type_ComTencentXactionApiIView.getDecor().getProxy();
        if (localObject == null) {
          Intrinsics.throwNpe();
        }
        paramMotionEvent.updateProgress((View)localObject, "move");
        paramMotionEvent = this.jdField_a_of_type_ComTencentXactionTriggerMoveTrigger;
        MoveTrigger.access$actionMove(paramMotionEvent, paramView, paramMotionEvent.getState().getDx(), this.jdField_a_of_type_ComTencentXactionTriggerMoveTrigger.getState().getDy());
        this.jdField_a_of_type_ComTencentXactionTriggerMoveTrigger.getState().setLastX(f1);
        this.jdField_a_of_type_ComTencentXactionTriggerMoveTrigger.getState().setLastY(f2);
        return true;
      }
      MoveTrigger.access$trackerActionUp(this.jdField_a_of_type_ComTencentXactionTriggerMoveTrigger, this.jdField_a_of_type_AndroidViewView, paramView);
      return true;
    }
    if (this.jdField_a_of_type_ComTencentXactionTriggerMoveTrigger.getVts() > 0.0F)
    {
      paramView = this.jdField_a_of_type_ComTencentXactionTriggerMoveTrigger.getTrackerHelper();
      if (paramView != null) {
        paramView.a();
      }
    }
    this.jdField_a_of_type_ComTencentXactionTriggerMoveTrigger.getState().setLastDownX(f1);
    this.jdField_a_of_type_ComTencentXactionTriggerMoveTrigger.getState().setLastDownY(f2);
    this.jdField_a_of_type_ComTencentXactionTriggerMoveTrigger.getState().setLastX(f1);
    this.jdField_a_of_type_ComTencentXactionTriggerMoveTrigger.getState().setLastY(f2);
    paramView = this.jdField_a_of_type_ComTencentXactionTriggerMoveTrigger;
    paramMotionEvent = this.jdField_a_of_type_ComTencentXactionApiIView.getDecor().getProxy();
    if (paramMotionEvent == null) {
      Intrinsics.throwNpe();
    }
    paramView.updateStatus(paramMotionEvent, "movedown");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.xaction.trigger.MoveTrigger.monitor.1
 * JD-Core Version:    0.7.0.1
 */