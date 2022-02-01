package com.tencent.mtt.supportui.views.recyclerview;

import java.util.ArrayList;

class RecyclerViewBase$1
  implements Runnable
{
  RecyclerViewBase$1(RecyclerViewBase paramRecyclerViewBase) {}
  
  public void run()
  {
    if (this.this$0.mPendingUpdates.isEmpty()) {
      this.this$0.setRecyclerViewTouchEnabled(true);
    }
    do
    {
      return;
      this.this$0.eatRequestLayout();
      this.this$0.updateChildViews();
      this.this$0.traversal(1991103);
      this.this$0.resumeRequestLayout(true);
    } while (this.this$0.mPostedAnimatorRunner);
    this.this$0.setRecyclerViewTouchEnabled(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.1
 * JD-Core Version:    0.7.0.1
 */