package com.tencent.mobileqq.qqexpand.fragment;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class ExpandProfileEditFragment$2
  implements View.OnTouchListener
{
  ExpandProfileEditFragment$2(ExpandProfileEditFragment paramExpandProfileEditFragment) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i == 0)
    {
      ExpandProfileEditFragment.a(this.a).setVisibility(0);
      return false;
    }
    if ((i == 1) || (i == 3)) {
      ExpandProfileEditFragment.a(this.a).setVisibility(8);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.fragment.ExpandProfileEditFragment.2
 * JD-Core Version:    0.7.0.1
 */