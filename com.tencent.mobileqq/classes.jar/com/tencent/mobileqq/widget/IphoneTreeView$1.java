package com.tencent.mobileqq.widget;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class IphoneTreeView$1
  implements View.OnTouchListener
{
  IphoneTreeView$1(IphoneTreeView paramIphoneTreeView) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 3) {
          return false;
        }
        paramView.setPressed(false);
        this.a.invalidate();
        return false;
      }
      if (paramView.isPressed())
      {
        paramView.setPressed(false);
        paramView = this.a;
        paramView.collapseGroup(paramView.jdField_a_of_type_Int);
        paramView = this.a;
        paramView.setSelectedGroup(paramView.jdField_a_of_type_Int);
        this.a.jdField_a_of_type_AndroidViewView = null;
      }
      return true;
    }
    paramView.setPressed(true);
    this.a.invalidate();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.IphoneTreeView.1
 * JD-Core Version:    0.7.0.1
 */