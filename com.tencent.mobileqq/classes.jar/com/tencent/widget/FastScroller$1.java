package com.tencent.widget;

class FastScroller$1
  implements Runnable
{
  FastScroller$1(FastScroller paramFastScroller) {}
  
  public void run()
  {
    if (this.this$0.mList.mIsAttached)
    {
      this.this$0.beginDrag();
      int k = this.this$0.mList.getHeight();
      int j = (int)this.this$0.mInitialTouchY - this.this$0.mThumbH + 10;
      int i;
      if (j < 0)
      {
        i = 0;
      }
      else
      {
        i = j;
        if (this.this$0.mThumbH + j > k) {
          i = k - this.this$0.mThumbH;
        }
      }
      FastScroller localFastScroller = this.this$0;
      localFastScroller.mThumbY = i;
      localFastScroller.scrollTo(localFastScroller.mThumbY / (k - this.this$0.mThumbH));
    }
    this.this$0.mPendingDrag = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.FastScroller.1
 * JD-Core Version:    0.7.0.1
 */