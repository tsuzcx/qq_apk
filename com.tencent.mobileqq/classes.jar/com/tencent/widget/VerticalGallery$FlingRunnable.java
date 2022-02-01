package com.tencent.widget;

import android.widget.Scroller;

class VerticalGallery$FlingRunnable
  implements Runnable
{
  private int mLastFlingX;
  private int mLastFlingY;
  private Scroller mScroller;
  
  public VerticalGallery$FlingRunnable(VerticalGallery paramVerticalGallery)
  {
    this.mScroller = new Scroller(paramVerticalGallery.getContext());
  }
  
  private void endFling(boolean paramBoolean)
  {
    VerticalGallery.access$402(this.this$0, false);
    this.mScroller.forceFinished(true);
    if (paramBoolean) {
      this.this$0.scrollIntoSlots();
    }
    this.this$0.onEndFling();
  }
  
  private void startCommon()
  {
    this.this$0.removeCallbacks(this);
  }
  
  public void run()
  {
    if (VerticalGallery.access$300(this.this$0))
    {
      runVertical();
      return;
    }
    if (this.this$0.mItemCount == 0)
    {
      endFling(true);
      return;
    }
    VerticalGallery.access$602(this.this$0, false);
    Object localObject = this.mScroller;
    boolean bool = ((Scroller)localObject).computeScrollOffset();
    int j = ((Scroller)localObject).getCurrX();
    int i = this.mLastFlingX - j;
    if (i > 0)
    {
      localObject = this.this$0;
      VerticalGallery.access$702((VerticalGallery)localObject, ((VerticalGallery)localObject).mFirstPosition);
      i = Math.min(this.this$0.getWidth() - this.this$0.getPaddingLeft() - this.this$0.getPaddingRight() - 1, i);
    }
    else
    {
      int k = this.this$0.getChildCount();
      localObject = this.this$0;
      VerticalGallery.access$702((VerticalGallery)localObject, ((VerticalGallery)localObject).mFirstPosition + (k - 1));
      i = Math.max(-(this.this$0.getWidth() - this.this$0.getPaddingRight() - this.this$0.getPaddingLeft() - 1), i);
    }
    this.this$0.trackMotionScroll(i);
    if ((bool) && (!VerticalGallery.access$600(this.this$0)))
    {
      this.mLastFlingX = j;
      this.this$0.post(this);
      return;
    }
    endFling(true);
  }
  
  public void runVertical()
  {
    if (this.this$0.mItemCount == 0)
    {
      endFling(true);
      return;
    }
    VerticalGallery.access$602(this.this$0, false);
    Object localObject = this.mScroller;
    boolean bool = ((Scroller)localObject).computeScrollOffset();
    int j = ((Scroller)localObject).getCurrY();
    int i = this.mLastFlingY - j;
    if (i > 0)
    {
      localObject = this.this$0;
      VerticalGallery.access$702((VerticalGallery)localObject, ((VerticalGallery)localObject).mFirstPosition);
      i = Math.min(this.this$0.getHeight() - this.this$0.getPaddingTop() - this.this$0.getPaddingBottom() - 1, i);
    }
    else
    {
      int k = this.this$0.getChildCount();
      localObject = this.this$0;
      VerticalGallery.access$702((VerticalGallery)localObject, ((VerticalGallery)localObject).mFirstPosition + (k - 1));
      i = Math.max(-(this.this$0.getHeight() - this.this$0.getPaddingBottom() - this.this$0.getPaddingTop() - 1), i);
    }
    this.this$0.trackMotionScrollVertical(i);
    if ((bool) && (!VerticalGallery.access$600(this.this$0)))
    {
      this.mLastFlingY = j;
      this.this$0.post(this);
      return;
    }
    endFling(true);
  }
  
  public void startUsingDistance(int paramInt)
  {
    if (paramInt == 0) {
      return;
    }
    if (VerticalGallery.access$300(this.this$0))
    {
      startCommon();
      VerticalGallery.access$402(this.this$0, true);
      this.mLastFlingY = 0;
      this.mScroller.startScroll(0, 0, 0, -paramInt, VerticalGallery.access$500(this.this$0));
      this.this$0.post(this);
      return;
    }
    startCommon();
    VerticalGallery.access$402(this.this$0, true);
    this.mLastFlingX = 0;
    this.mScroller.startScroll(0, 0, -paramInt, 0, VerticalGallery.access$500(this.this$0));
    this.this$0.post(this);
  }
  
  public void startUsingVelocity(int paramInt)
  {
    if (paramInt == 0) {
      return;
    }
    startCommon();
    boolean bool = VerticalGallery.access$300(this.this$0);
    int i = 2147483647;
    if (bool)
    {
      if (paramInt < 0) {
        i = 2147483647;
      } else {
        i = 0;
      }
      this.mLastFlingY = i;
      this.mScroller.fling(0, i, 0, paramInt, 0, 2147483647, 0, 2147483647);
      this.this$0.post(this);
      return;
    }
    if (paramInt >= 0) {
      i = 0;
    }
    this.mLastFlingX = i;
    this.mScroller.fling(i, 0, paramInt, 0, 0, 2147483647, 0, 2147483647);
    this.this$0.post(this);
  }
  
  public void stop(boolean paramBoolean)
  {
    this.this$0.removeCallbacks(this);
    endFling(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.VerticalGallery.FlingRunnable
 * JD-Core Version:    0.7.0.1
 */