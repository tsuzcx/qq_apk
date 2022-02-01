package com.tencent.mobileqq.wink.pick.circle.widget;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewParent;

class WinkCircleVideoPreviewItemView$4
  implements View.OnTouchListener
{
  WinkCircleVideoPreviewItemView$4(WinkCircleVideoPreviewItemView paramWinkCircleVideoPreviewItemView) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    paramView.getParent().requestDisallowInterceptTouchEvent(true);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.pick.circle.widget.WinkCircleVideoPreviewItemView.4
 * JD-Core Version:    0.7.0.1
 */