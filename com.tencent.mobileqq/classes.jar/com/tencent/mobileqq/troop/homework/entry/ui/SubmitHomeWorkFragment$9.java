package com.tencent.mobileqq.troop.homework.entry.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class SubmitHomeWorkFragment$9
  implements View.OnTouchListener
{
  SubmitHomeWorkFragment$9(SubmitHomeWorkFragment paramSubmitHomeWorkFragment) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if ((i == 1) || (i == 3)) {
        paramView.setAlpha(1.0F);
      }
    }
    else {
      paramView.setAlpha(0.5F);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.entry.ui.SubmitHomeWorkFragment.9
 * JD-Core Version:    0.7.0.1
 */