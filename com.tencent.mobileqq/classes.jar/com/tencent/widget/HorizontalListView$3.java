package com.tencent.widget;

class HorizontalListView$3
  implements Runnable
{
  HorizontalListView$3(HorizontalListView paramHorizontalListView) {}
  
  public void run()
  {
    if (this.this$0.mTouchMode == -1)
    {
      if (HorizontalListView.access$300(this.this$0) != -1) {
        return;
      }
      if (!this.this$0.mScroller.isFinished()) {
        return;
      }
      if (HorizontalListView.DEBUG)
      {
        localObject = this.this$0;
        ((HorizontalListView)localObject).log("mFlingRunnable", new Object[] { Integer.valueOf(((HorizontalListView)localObject).mTouchMode) });
      }
      Object localObject = this.this$0.mScroller;
      int i = this.this$0.getScrollX();
      if (((OverScroller)localObject).springBack(this.this$0.mNextX + i, this.this$0.getScrollY(), this.this$0.mNextX, this.this$0.mNextX, 0, 0))
      {
        this.this$0.mTouchMode = 6;
        if (HorizontalListView.DEBUG) {
          this.this$0.log("mFlingRunnable", new Object[] { "TOUCH_MODE_OVERFLING" });
        }
        this.this$0.setCurrentScrollState(4099);
        this.this$0.invalidate();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.HorizontalListView.3
 * JD-Core Version:    0.7.0.1
 */