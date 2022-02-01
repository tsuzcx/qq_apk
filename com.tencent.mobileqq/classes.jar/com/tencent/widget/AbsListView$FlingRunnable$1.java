package com.tencent.widget;

import android.annotation.TargetApi;
import android.view.VelocityTracker;
import bjse;
import com.tencent.util.VersionUtils;

class AbsListView$FlingRunnable$1
  implements Runnable
{
  AbsListView$FlingRunnable$1(AbsListView.FlingRunnable paramFlingRunnable) {}
  
  @TargetApi(8)
  public void run()
  {
    int i = AbsListView.access$1200(this.this$1.this$0);
    VelocityTracker localVelocityTracker = AbsListView.access$1300(this.this$1.this$0);
    bjse localbjse = AbsListView.FlingRunnable.access$1100(this.this$1);
    if ((localVelocityTracker == null) || (i == -1)) {
      return;
    }
    localVelocityTracker.computeCurrentVelocity(1000, AbsListView.access$1400(this.this$1.this$0));
    if (VersionUtils.isrFroyo()) {}
    for (float f = -localVelocityTracker.getYVelocity(i); (Math.abs(f) >= AbsListView.access$1500(this.this$1.this$0)) && (localbjse.a(0.0F, f)); f = -localVelocityTracker.getYVelocity())
    {
      this.this$1.this$0.postDelayed(this, 40L);
      return;
    }
    this.this$1.endFling();
    this.this$1.this$0.mTouchMode = 3;
    this.this$1.this$0.reportScrollStateChange(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.widget.AbsListView.FlingRunnable.1
 * JD-Core Version:    0.7.0.1
 */