package com.tencent.richmediabrowser.view.recyclerview;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.richmediabrowser.listener.IBrowserItemEventListener;
import com.tencent.richmediabrowser.presenter.MainBrowserPresenter;

class BrowserScaleView$1
  extends GestureDetector.SimpleOnGestureListener
{
  BrowserScaleView$1(BrowserScaleView paramBrowserScaleView) {}
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    if (!BrowserScaleView.access$000(this.this$0)) {
      bool = false;
    }
    do
    {
      return bool;
      if (BrowserScaleView.access$100(this.this$0) != null) {
        BrowserScaleView.access$100(this.this$0).onDoubleTap();
      }
    } while (BrowserScaleView.access$200(this.this$0));
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if (BrowserScaleView.access$400(this.this$0, BrowserScaleView.access$300(this.this$0)))
    {
      if (BrowserScaleView.access$500(this.this$0) == BrowserScaleView.access$600(this.this$0))
      {
        BrowserScaleView.access$800(this.this$0, BrowserScaleView.access$700(this.this$0), f1, f2);
        return true;
      }
      BrowserScaleView.access$800(this.this$0, BrowserScaleView.access$600(this.this$0), f1, f2);
      return true;
    }
    if (BrowserScaleView.access$500(this.this$0) < BrowserScaleView.access$900(this.this$0))
    {
      BrowserScaleView.access$800(this.this$0, BrowserScaleView.access$900(this.this$0), f1, f2);
      return true;
    }
    BrowserScaleView.access$800(this.this$0, BrowserScaleView.access$700(this.this$0), f1, f2);
    return true;
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    if (BrowserScaleView.access$1000(this.this$0) != null) {
      BrowserScaleView.access$1000(this.this$0).onLongClickEvent();
    }
    super.onLongPress(paramMotionEvent);
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (paramFloat1 == 0.0F) {
      this.this$0.mScrollDirection = 0;
    }
    for (;;)
    {
      if (BrowserScaleView.access$1100(this.this$0)) {
        BrowserScaleView.access$1400(this.this$0).updateShowArea(BrowserScaleView.access$1200(this.this$0), BrowserScaleView.access$1300(this.this$0), BrowserScaleView.access$700(this.this$0), BrowserScaleView.access$500(this.this$0), this.this$0, true, 1, this.this$0.mScrollDirection);
      }
      return super.onScroll(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
      if (paramFloat1 < 0.0F) {
        this.this$0.mScrollDirection = 1;
      } else {
        this.this$0.mScrollDirection = 2;
      }
    }
  }
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    if (BrowserScaleView.access$1000(this.this$0) != null)
    {
      BrowserScaleView.access$1000(this.this$0).onClickEvent();
      return true;
    }
    return super.onSingleTapUp(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.richmediabrowser.view.recyclerview.BrowserScaleView.1
 * JD-Core Version:    0.7.0.1
 */