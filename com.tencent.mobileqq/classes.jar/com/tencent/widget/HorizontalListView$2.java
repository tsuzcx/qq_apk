package com.tencent.widget;

class HorizontalListView$2
  implements Runnable
{
  HorizontalListView$2(HorizontalListView paramHorizontalListView, HorizontalListView.PerformClick paramPerformClick) {}
  
  public void run()
  {
    HorizontalListView localHorizontalListView = this.this$0;
    localHorizontalListView.mTouchMode = -1;
    HorizontalListView.access$100(localHorizontalListView);
    if (!this.this$0.mDataChanged) {
      this.val$performClick.run();
    }
    HorizontalListView.access$202(this.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.HorizontalListView.2
 * JD-Core Version:    0.7.0.1
 */