package com.tencent.xaction.trigger.touch;

import android.os.Handler;
import android.widget.Scroller;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class VelocityTrackerHelper$nextInvalidate$1
  implements Runnable
{
  VelocityTrackerHelper$nextInvalidate$1(VelocityTrackerHelper paramVelocityTrackerHelper, VelocityTrackerHelper.ScrollCallback paramScrollCallback) {}
  
  public final void run()
  {
    if (VelocityTrackerHelper.a(this.this$0))
    {
      this.a.a(false, VelocityTrackerHelper.a(this.this$0).getCurrX(), VelocityTrackerHelper.a(this.this$0).getCurrY());
      VelocityTrackerHelper.a(this.this$0).post(VelocityTrackerHelper.a(this.this$0));
      return;
    }
    this.a.a(true, VelocityTrackerHelper.a(this.this$0).getCurrX(), VelocityTrackerHelper.a(this.this$0).getCurrY());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.xaction.trigger.touch.VelocityTrackerHelper.nextInvalidate.1
 * JD-Core Version:    0.7.0.1
 */