package com.tencent.widget;

class HorizontalListView$2
  implements Runnable
{
  HorizontalListView$2(HorizontalListView paramHorizontalListView, HorizontalListView.PerformClick paramPerformClick) {}
  
  public void run()
  {
    this.this$0.mTouchMode = -1;
    HorizontalListView.access$100(this.this$0);
    if (!this.this$0.mDataChanged) {
      this.a.run();
    }
    HorizontalListView.access$202(this.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.widget.HorizontalListView.2
 * JD-Core Version:    0.7.0.1
 */