package com.tencent.mobileqq.troop.troopcreate.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.EditText;

class NewTroopContactView$9
  implements View.OnTouchListener
{
  float jdField_a_of_type_Float = 0.0F;
  float b = 0.0F;
  
  NewTroopContactView$9(NewTroopContactView paramNewTroopContactView) {}
  
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
      this.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateUiNewTroopContactView.a.clearFocus();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcreate.ui.NewTroopContactView.9
 * JD-Core Version:    0.7.0.1
 */