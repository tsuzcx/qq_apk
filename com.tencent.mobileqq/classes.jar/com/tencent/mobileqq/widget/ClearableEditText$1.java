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
    if (this.a.getCompoundDrawables()[2] == null) {
      return false;
    }
    int j = paramMotionEvent.getAction();
    int i = 1;
    if (j != 1) {
      return false;
    }
    if (paramMotionEvent.getX() <= this.a.getWidth() - this.a.getPaddingRight() - this.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth()) {
      i = 0;
    }
    if (i != 0)
    {
      this.a.setText("");
      this.a.setClearButtonVisible(false);
      if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText$OnTextClearedListener != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText$OnTextClearedListener.a();
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ClearableEditText.1
 * JD-Core Version:    0.7.0.1
 */