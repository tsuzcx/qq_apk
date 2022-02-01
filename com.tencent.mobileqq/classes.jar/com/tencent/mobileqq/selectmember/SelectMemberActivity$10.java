package com.tencent.mobileqq.selectmember;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class SelectMemberActivity$10
  implements View.OnTouchListener
{
  float a = 0.0F;
  float b = 0.0F;
  
  SelectMemberActivity$10(SelectMemberActivity paramSelectMemberActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i == 0)
    {
      this.a = paramMotionEvent.getRawX();
      this.b = paramMotionEvent.getRawY();
    }
    else if ((i == 2) && ((paramMotionEvent.getRawX() - this.a > 10.0F) || (paramMotionEvent.getRawY() - this.b > 10.0F)))
    {
      this.c.mSelectedAndSearchBar.c();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.SelectMemberActivity.10
 * JD-Core Version:    0.7.0.1
 */