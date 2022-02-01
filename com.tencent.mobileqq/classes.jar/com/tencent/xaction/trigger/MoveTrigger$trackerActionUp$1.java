package com.tencent.xaction.trigger;

import android.view.View;
import com.tencent.xaction.trigger.helper.CurrentState;
import com.tencent.xaction.trigger.touch.VelocityTrackerHelper.ScrollCallback;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/xaction/trigger/MoveTrigger$trackerActionUp$1", "Lcom/tencent/xaction/trigger/touch/VelocityTrackerHelper$ScrollCallback;", "computeScroll", "", "isEnd", "", "x", "", "y", "onVelocity", "xVelocity", "", "yVelocity", "XActionCore_release"}, k=1, mv={1, 1, 16})
public final class MoveTrigger$trackerActionUp$1
  implements VelocityTrackerHelper.ScrollCallback
{
  MoveTrigger$trackerActionUp$1(View paramView1, View paramView2) {}
  
  public void a(float paramFloat1, float paramFloat2) {}
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentXactionTriggerMoveTrigger.updateStatus(this.jdField_a_of_type_AndroidViewView, "moveup");
      return;
    }
    MoveTrigger localMoveTrigger = this.jdField_a_of_type_ComTencentXactionTriggerMoveTrigger;
    View localView = this.b;
    float f1 = localMoveTrigger.getState().getLastX();
    float f2 = paramInt1;
    float f3 = this.jdField_a_of_type_ComTencentXactionTriggerMoveTrigger.getState().getLastY();
    float f4 = paramInt2;
    MoveTrigger.access$actionMove(localMoveTrigger, localView, f1 - f2, f3 - f4);
    this.jdField_a_of_type_ComTencentXactionTriggerMoveTrigger.getState().setLastX(f2);
    this.jdField_a_of_type_ComTencentXactionTriggerMoveTrigger.getState().setLastY(f4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.xaction.trigger.MoveTrigger.trackerActionUp.1
 * JD-Core Version:    0.7.0.1
 */