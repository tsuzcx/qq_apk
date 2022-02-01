package com.tencent.mobileqq.qqexpand.fragment;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class ExpandCampusNewFragment$4
  implements View.OnTouchListener
{
  ExpandCampusNewFragment$4(ExpandCampusNewFragment paramExpandCampusNewFragment, View paramView) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      this.a.setAlpha(0.5F);
      this.a.postInvalidate();
    }
    else if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3))
    {
      this.a.setAlpha(1.0F);
      this.a.postInvalidate();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.fragment.ExpandCampusNewFragment.4
 * JD-Core Version:    0.7.0.1
 */