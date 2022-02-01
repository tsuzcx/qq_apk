package com.tencent.xaction.trigger;

import android.view.View;
import com.tencent.xaction.trigger.touch.VelocityTrackerHelper.ScrollCallback;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/xaction/trigger/MoveTrigger$monitor$1$1", "Lcom/tencent/xaction/trigger/touch/VelocityTrackerHelper$ScrollCallback;", "computeScroll", "", "isEnd", "", "x", "", "y", "XActionEngine_release"}, k=1, mv={1, 1, 16})
public final class MoveTrigger$monitor$1$1
  implements VelocityTrackerHelper.ScrollCallback
{
  MoveTrigger$monitor$1$1(View paramView, float[] paramArrayOfFloat) {}
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentXactionTriggerMoveTrigger$monitor$1.jdField_a_of_type_ComTencentXactionTriggerMoveTrigger.updateStatus(this.jdField_a_of_type_ComTencentXactionTriggerMoveTrigger$monitor$1.jdField_a_of_type_AndroidViewView, "moveup");
      return;
    }
    MoveTrigger.access$actionMove(this.jdField_a_of_type_ComTencentXactionTriggerMoveTrigger$monitor$1.jdField_a_of_type_ComTencentXactionTriggerMoveTrigger, this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_ArrayOfFloat[0] - paramInt1, this.jdField_a_of_type_ArrayOfFloat[1] - paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.xaction.trigger.MoveTrigger.monitor.1.1
 * JD-Core Version:    0.7.0.1
 */