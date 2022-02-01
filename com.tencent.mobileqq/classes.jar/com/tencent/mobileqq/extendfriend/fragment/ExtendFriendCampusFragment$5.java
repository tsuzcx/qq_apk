package com.tencent.mobileqq.extendfriend.fragment;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class ExtendFriendCampusFragment$5
  implements View.OnTouchListener
{
  ExtendFriendCampusFragment$5(ExtendFriendCampusFragment paramExtendFriendCampusFragment, View paramView) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      this.jdField_a_of_type_AndroidViewView.setAlpha(0.5F);
      this.jdField_a_of_type_AndroidViewView.postInvalidate();
    }
    for (;;)
    {
      return false;
      if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3))
      {
        this.jdField_a_of_type_AndroidViewView.setAlpha(1.0F);
        this.jdField_a_of_type_AndroidViewView.postInvalidate();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.fragment.ExtendFriendCampusFragment.5
 * JD-Core Version:    0.7.0.1
 */