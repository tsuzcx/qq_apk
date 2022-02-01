package com.tencent.widget;

class FastScroller$1
  implements Runnable
{
  FastScroller$1(FastScroller paramFastScroller) {}
  
  public void run()
  {
    int k;
    int j;
    int i;
    if (this.this$0.mList.mIsAttached)
    {
      this.this$0.beginDrag();
      k = this.this$0.mList.getHeight();
      j = (int)this.this$0.mInitialTouchY - this.this$0.mThumbH + 10;
      if (j >= 0) {
        break label100;
      }
      i = 0;
    }
    for (;;)
    {
      this.this$0.mThumbY = i;
      this.this$0.scrollTo(this.this$0.mThumbY / (k - this.this$0.mThumbH));
      this.this$0.mPendingDrag = false;
      return;
      label100:
      i = j;
      if (this.this$0.mThumbH + j > k) {
        i = k - this.this$0.mThumbH;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.widget.FastScroller.1
 * JD-Core Version:    0.7.0.1
 */