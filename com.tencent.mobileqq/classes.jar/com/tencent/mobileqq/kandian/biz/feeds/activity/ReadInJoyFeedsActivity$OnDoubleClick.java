package com.tencent.mobileqq.kandian.biz.feeds.activity;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.mobileqq.kandian.biz.feeds.controller.ReadInJoyBaseViewController;
import java.lang.ref.WeakReference;

class ReadInJoyFeedsActivity$OnDoubleClick
  extends GestureDetector.SimpleOnGestureListener
{
  private WeakReference<ReadInJoyBaseViewController> a = null;
  
  public ReadInJoyFeedsActivity$OnDoubleClick(ReadInJoyBaseViewController paramReadInJoyBaseViewController)
  {
    this.a = new WeakReference(paramReadInJoyBaseViewController);
  }
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    paramMotionEvent = this.a;
    if ((paramMotionEvent != null) && (paramMotionEvent.get() != null)) {
      ((ReadInJoyBaseViewController)this.a.get()).a(true);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.activity.ReadInJoyFeedsActivity.OnDoubleClick
 * JD-Core Version:    0.7.0.1
 */