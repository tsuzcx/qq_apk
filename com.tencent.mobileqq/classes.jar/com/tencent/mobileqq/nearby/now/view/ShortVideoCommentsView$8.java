package com.tencent.mobileqq.nearby.now.view;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class ShortVideoCommentsView$8
  implements View.OnTouchListener
{
  ShortVideoCommentsView$8(ShortVideoCommentsView paramShortVideoCommentsView) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      ShortVideoCommentsView.access$500(this.a);
      this.a.showComment();
      ShortVideoCommentsView.access$600(this.a);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.ShortVideoCommentsView.8
 * JD-Core Version:    0.7.0.1
 */