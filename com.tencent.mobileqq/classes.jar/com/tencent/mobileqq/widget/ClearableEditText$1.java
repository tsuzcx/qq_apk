package com.tencent.mobileqq.widget;

import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class ClearableEditText$1
  implements View.OnTouchListener
{
  ClearableEditText$1(ClearableEditText paramClearableEditText) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = 1;
    if (this.a.getCompoundDrawables()[2] == null) {}
    label107:
    for (;;)
    {
      return false;
      if (paramMotionEvent.getAction() == 1)
      {
        if (paramMotionEvent.getX() > this.a.getWidth() - this.a.getPaddingRight() - this.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth()) {}
        for (;;)
        {
          if (i == 0) {
            break label107;
          }
          this.a.setText("");
          this.a.setClearButtonVisible(false);
          if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText$OnTextClearedListener == null) {
            break;
          }
          this.a.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText$OnTextClearedListener.k();
          return false;
          i = 0;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ClearableEditText.1
 * JD-Core Version:    0.7.0.1
 */