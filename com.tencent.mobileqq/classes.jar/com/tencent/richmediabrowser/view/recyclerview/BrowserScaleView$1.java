package com.tencent.richmediabrowser.view.recyclerview;

import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.richmediabrowser.api.event.IBrowserItemClickEvent;
import com.tencent.richmediabrowser.presenter.MainBrowserPresenter;

class BrowserScaleView$1
  extends GestureDetector.SimpleOnGestureListener
{
  BrowserScaleView$1(BrowserScaleView paramBrowserScaleView) {}
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    if (!BrowserScaleView.access$000(this.this$0)) {
      return false;
    }
    if (BrowserScaleView.access$100(this.this$0) != null) {
      BrowserScaleView.access$100(this.this$0).onDoubleTap();
    }
    if (BrowserScaleView.access$200(this.this$0)) {
      return true;
    }
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if (BrowserScaleView.access$300(this.this$0) < BrowserScaleView.access$400(this.this$0))
    {
      paramMotionEvent = this.this$0;
      BrowserScaleView.access$500(paramMotionEvent, BrowserScaleView.access$400(paramMotionEvent), f1, f2);
      return true;
    }
    paramMotionEvent = this.this$0;
    BrowserScaleView.access$500(paramMotionEvent, BrowserScaleView.access$600(paramMotionEvent), f1, f2);
    return true;
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    if (BrowserScaleView.access$700(this.this$0) != null) {
      BrowserScaleView.access$700(this.this$0).onLongClickEvent();
    }
    super.onLongPress(paramMotionEvent);
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (paramFloat1 == 0.0F) {
      this.this$0.mScrollDirection = 0;
    } else if (paramFloat1 < 0.0F) {
      this.this$0.mScrollDirection = 1;
    } else {
      this.this$0.mScrollDirection = 2;
    }
    if (BrowserScaleView.access$800(this.this$0))
    {
      RegionRectHelper localRegionRectHelper = BrowserScaleView.access$1100(this.this$0);
      Drawable localDrawable = BrowserScaleView.access$900(this.this$0);
      Matrix localMatrix = BrowserScaleView.access$1000(this.this$0);
      float f1 = BrowserScaleView.access$600(this.this$0);
      float f2 = BrowserScaleView.access$300(this.this$0);
      BrowserScaleView localBrowserScaleView = this.this$0;
      localRegionRectHelper.updateShowArea(localDrawable, localMatrix, f1, f2, localBrowserScaleView, true, 1, localBrowserScaleView.mScrollDirection);
    }
    return super.onScroll(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
  }
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    if (BrowserScaleView.access$700(this.this$0) != null)
    {
      BrowserScaleView.access$700(this.this$0).onClickEvent();
      return true;
    }
    return super.onSingleTapUp(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.richmediabrowser.view.recyclerview.BrowserScaleView.1
 * JD-Core Version:    0.7.0.1
 */