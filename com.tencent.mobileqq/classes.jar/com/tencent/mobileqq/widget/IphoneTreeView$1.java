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
    boolean bool = true;
    switch (paramMotionEvent.getAction())
    {
    case 2: 
    default: 
      bool = false;
    }
    do
    {
      return bool;
      paramView.setPressed(true);
      this.a.invalidate();
      return true;
      paramView.setPressed(false);
      this.a.invalidate();
      break;
    } while (!paramView.isPressed());
    paramView.setPressed(false);
    this.a.collapseGroup(this.a.jdField_a_of_type_Int);
    this.a.setSelectedGroup(this.a.jdField_a_of_type_Int);
    this.a.jdField_a_of_type_AndroidViewView = null;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.widget.IphoneTreeView.1
 * JD-Core Version:    0.7.0.1
 */