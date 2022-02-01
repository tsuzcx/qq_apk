package com.tencent.mtt.supportui.views.recyclerview;

import android.view.VelocityTracker;

class RecyclerViewBase$4
  implements Runnable
{
  RecyclerViewBase$4(RecyclerViewBase paramRecyclerViewBase) {}
  
  public void run()
  {
    if (RecyclerViewBase.access$000(this.this$0))
    {
      RecyclerViewBase.access$002(this.this$0, false);
      if (RecyclerViewBase.access$100(this.this$0) != 0) {
        break label37;
      }
      this.this$0.stopScroll();
    }
    label37:
    do
    {
      do
      {
        return;
      } while ((RecyclerViewBase.access$100(this.this$0) != 2) || (this.this$0.mVelocityTracker == null));
      this.this$0.mVelocityTracker.computeCurrentVelocity(1000, this.this$0.mMaxFlingVelocity);
    } while (Math.abs(this.this$0.mVelocityTracker.getYVelocity()) >= this.this$0.mMaxFlingVelocity * 2 / 3);
    this.this$0.stopScroll();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.4
 * JD-Core Version:    0.7.0.1
 */