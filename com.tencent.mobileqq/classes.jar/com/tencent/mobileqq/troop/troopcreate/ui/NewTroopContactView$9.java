package com.tencent.mobileqq.troop.troopcreate.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.EditText;

class NewTroopContactView$9
  implements View.OnTouchListener
{
  float a = 0.0F;
  float b = 0.0F;
  
  NewTroopContactView$9(NewTroopContactView paramNewTroopContactView) {}
  
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
      this.c.f.clearFocus();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcreate.ui.NewTroopContactView.9
 * JD-Core Version:    0.7.0.1
 */