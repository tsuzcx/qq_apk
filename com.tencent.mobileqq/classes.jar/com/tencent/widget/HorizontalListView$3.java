package com.tencent.widget;

import bftl;

class HorizontalListView$3
  implements Runnable
{
  HorizontalListView$3(HorizontalListView paramHorizontalListView) {}
  
  public void run()
  {
    if ((this.this$0.mTouchMode != -1) || (HorizontalListView.access$300(this.this$0) != -1)) {}
    do
    {
      do
      {
        return;
      } while (!this.this$0.mScroller.a());
      if (HorizontalListView.DEBUG) {
        this.this$0.log("mFlingRunnable", new Object[] { Integer.valueOf(this.this$0.mTouchMode) });
      }
    } while (!this.this$0.mScroller.a(this.this$0.getScrollX() + this.this$0.mNextX, this.this$0.getScrollY(), this.this$0.mNextX, this.this$0.mNextX, 0, 0));
    this.this$0.mTouchMode = 6;
    if (HorizontalListView.DEBUG) {
      this.this$0.log("mFlingRunnable", new Object[] { "TOUCH_MODE_OVERFLING" });
    }
    this.this$0.setCurrentScrollState(4099);
    this.this$0.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.widget.HorizontalListView.3
 * JD-Core Version:    0.7.0.1
 */