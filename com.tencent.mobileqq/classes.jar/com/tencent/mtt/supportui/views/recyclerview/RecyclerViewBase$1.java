package com.tencent.mtt.supportui.views.recyclerview;

import java.util.ArrayList;

class RecyclerViewBase$1
  implements Runnable
{
  RecyclerViewBase$1(RecyclerViewBase paramRecyclerViewBase) {}
  
  public void run()
  {
    if (this.this$0.mPendingUpdates.isEmpty())
    {
      this.this$0.setRecyclerViewTouchEnabled(true);
      return;
    }
    this.this$0.eatRequestLayout();
    this.this$0.updateChildViews();
    this.this$0.traversal(1991103);
    this.this$0.resumeRequestLayout(true);
    if (!this.this$0.mPostedAnimatorRunner) {
      this.this$0.setRecyclerViewTouchEnabled(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.1
 * JD-Core Version:    0.7.0.1
 */