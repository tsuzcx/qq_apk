package com.tencent.mobileqq.nearby.now.view;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;

class ShortVideoCommentsView$17
  implements View.OnTouchListener
{
  ShortVideoCommentsView$17(ShortVideoCommentsView paramShortVideoCommentsView) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() != 0) && (paramMotionEvent.getAction() != 2)) {
      ShortVideoCommentsView.access$2300(this.a).setTextColor(-16777216);
    } else {
      ShortVideoCommentsView.access$2300(this.a).setTextColor(2130706432);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.ShortVideoCommentsView.17
 * JD-Core Version:    0.7.0.1
 */