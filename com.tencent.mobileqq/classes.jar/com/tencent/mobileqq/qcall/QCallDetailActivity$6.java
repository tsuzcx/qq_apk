package com.tencent.mobileqq.qcall;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.RelativeLayout;

class QCallDetailActivity$6
  implements View.OnTouchListener
{
  QCallDetailActivity$6(QCallDetailActivity paramQCallDetailActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      QCallDetailActivity.f(this.a).setPressed(true);
      return false;
    }
    if (1 == paramMotionEvent.getAction()) {
      QCallDetailActivity.f(this.a).setPressed(false);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qcall.QCallDetailActivity.6
 * JD-Core Version:    0.7.0.1
 */