package com.tencent.mobileqq.widget;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;

class SlideDetectListView$1
  extends GestureDetector.SimpleOnGestureListener
{
  SlideDetectListView$1(SlideDetectListView paramSlideDetectListView) {}
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (!this.this$0.mCanSlide) {}
    do
    {
      return false;
      if ((paramFloat1 > 0.0F) && (Math.abs(paramFloat1) > Math.abs(paramFloat2) * 2.0F) && ((this.this$0.mScrollState == 0) || (this.this$0.mNotCheckStateWhenSlide)) && (!this.this$0.mHasSlide) && (Math.abs(paramFloat1) > this.this$0.mSlideSlop))
      {
        this.this$0.mMotionViewPosition = this.this$0.findMotionViewPosition(this.this$0.mDownY);
        this.this$0.mMotionView = this.this$0.findMotionView(this.this$0.mMotionViewPosition);
        if (this.this$0.mMotionView != null)
        {
          this.this$0.mHasSlide = true;
          this.this$0.setPressed(false);
          this.this$0.mMotionView.setPressed(false);
          if (SlideDetectListView.access$000(this.this$0) != null)
          {
            int i = this.this$0.mMotionViewPosition;
            int j = this.this$0.getHeaderViewsCount();
            SlideDetectListView.access$000(this.this$0).onSlideStarted(this.this$0, this.this$0.mMotionView, i - j);
          }
          this.this$0.mDownY = 0;
        }
        for (;;)
        {
          return true;
          this.this$0.mHasSlideBanner = true;
        }
      }
    } while (Math.abs(paramFloat1) <= Math.abs(paramFloat2) * 2.0F);
    this.this$0.mHasSlideBanner = true;
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.SlideDetectListView.1
 * JD-Core Version:    0.7.0.1
 */