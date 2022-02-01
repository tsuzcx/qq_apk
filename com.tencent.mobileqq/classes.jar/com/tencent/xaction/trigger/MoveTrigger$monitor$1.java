package com.tencent.xaction.trigger;

import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.xaction.api.IDecorView;
import com.tencent.xaction.api.IView;
import com.tencent.xaction.trigger.touch.VelocityTrackerHelper;
import com.tencent.xaction.trigger.touch.VelocityTrackerHelper.ScrollCallback;
import java.util.concurrent.atomic.AtomicInteger;
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
    Object localObject = this.jdField_a_of_type_ComTencentXactionTriggerMoveTrigger.getTrackerHelper();
    if (localObject != null) {
      ((VelocityTrackerHelper)localObject).a(paramMotionEvent);
    }
    int i = (int)paramMotionEvent.getX();
    int j = (int)paramMotionEvent.getY();
    switch (paramMotionEvent.getAction())
    {
    default: 
    case 0: 
    case 2: 
      do
      {
        return true;
        this.jdField_a_of_type_ComTencentXactionTriggerMoveTrigger.getLastEventX().set(i);
        this.jdField_a_of_type_ComTencentXactionTriggerMoveTrigger.getLastEventY().set(j);
        paramView = this.jdField_a_of_type_ComTencentXactionTriggerMoveTrigger;
        localObject = this.jdField_a_of_type_ComTencentXactionApiIView.a().a();
        if (localObject == null) {
          Intrinsics.throwNpe();
        }
        paramView.updateStatus((View)localObject, "movedown");
        this.jdField_a_of_type_ComTencentXactionTriggerMoveTrigger.getPointEvent().set(paramMotionEvent.getX(), paramMotionEvent.getY());
        return true;
      } while ((Math.abs(paramMotionEvent.getX() - this.jdField_a_of_type_ComTencentXactionTriggerMoveTrigger.getPointEvent().x) > 100) || (Math.abs(paramMotionEvent.getY() - this.jdField_a_of_type_ComTencentXactionTriggerMoveTrigger.getPointEvent().y) > 100));
      localObject = this.jdField_a_of_type_ComTencentXactionTriggerMoveTrigger.getMoveXY(i, j, paramView);
      float f1 = localObject[0];
      float f2 = localObject[1];
      MoveTrigger.access$actionMove(this.jdField_a_of_type_ComTencentXactionTriggerMoveTrigger, paramView, f1, f2);
      this.jdField_a_of_type_ComTencentXactionTriggerMoveTrigger.getPointEvent().set(paramMotionEvent.getX(), paramMotionEvent.getY());
      return true;
    }
    paramMotionEvent = this.jdField_a_of_type_ComTencentXactionTriggerMoveTrigger.getMoveXY(i, j, paramView);
    localObject = this.jdField_a_of_type_ComTencentXactionTriggerMoveTrigger.getTrackerHelper();
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    ((VelocityTrackerHelper)localObject).a(paramView, 0, 0, this.jdField_a_of_type_ComTencentXactionTriggerMoveTrigger.getVts(), (VelocityTrackerHelper.ScrollCallback)new MoveTrigger.monitor.1.1(this, paramView, paramMotionEvent));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.xaction.trigger.MoveTrigger.monitor.1
 * JD-Core Version:    0.7.0.1
 */