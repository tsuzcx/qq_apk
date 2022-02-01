package com.tencent.xaction.trigger.touch;

import android.os.Build.VERSION;
import android.view.View;
import android.widget.Scroller;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref.ObjectRef;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class VelocityTrackerHelper$nextInvalidate$1
  implements Runnable
{
  VelocityTrackerHelper$nextInvalidate$1(VelocityTrackerHelper paramVelocityTrackerHelper, VelocityTrackerHelper.ScrollCallback paramScrollCallback, View paramView, Ref.ObjectRef paramObjectRef) {}
  
  public final void run()
  {
    if (VelocityTrackerHelper.a(this.this$0))
    {
      int i = VelocityTrackerHelper.a(this.this$0).getCurrX();
      int j = VelocityTrackerHelper.a(this.this$0).getCurrY();
      this.jdField_a_of_type_ComTencentXactionTriggerTouchVelocityTrackerHelper$ScrollCallback.a(false, i, j);
      if (Build.VERSION.SDK_INT >= 16) {
        this.jdField_a_of_type_AndroidViewView.postOnAnimation((Runnable)this.jdField_a_of_type_KotlinJvmInternalRef$ObjectRef.element);
      }
      return;
    }
    this.jdField_a_of_type_ComTencentXactionTriggerTouchVelocityTrackerHelper$ScrollCallback.a(true, VelocityTrackerHelper.a(this.this$0).getCurrX(), VelocityTrackerHelper.a(this.this$0).getCurrY());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.xaction.trigger.touch.VelocityTrackerHelper.nextInvalidate.1
 * JD-Core Version:    0.7.0.1
 */