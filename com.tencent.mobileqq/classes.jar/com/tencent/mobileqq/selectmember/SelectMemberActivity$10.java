package com.tencent.mobileqq.selectmember;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class SelectMemberActivity$10
  implements View.OnTouchListener
{
  float jdField_a_of_type_Float = 0.0F;
  float b = 0.0F;
  
  SelectMemberActivity$10(SelectMemberActivity paramSelectMemberActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i == 0)
    {
      this.jdField_a_of_type_Float = paramMotionEvent.getRawX();
      this.b = paramMotionEvent.getRawY();
    }
    else if ((i == 2) && ((paramMotionEvent.getRawX() - this.jdField_a_of_type_Float > 10.0F) || (paramMotionEvent.getRawY() - this.b > 10.0F)))
    {
      this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.mSelectedAndSearchBar.b();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.SelectMemberActivity.10
 * JD-Core Version:    0.7.0.1
 */