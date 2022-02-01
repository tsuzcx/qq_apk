package com.tencent.mobileqq.forward;

import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class ForwardFileOption$9
  implements View.OnTouchListener
{
  ForwardFileOption$9(ForwardFileOption paramForwardFileOption, View paramView) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      paramView = this.jdField_a_of_type_AndroidViewView;
      if (paramView != null)
      {
        paramView.setBackgroundColor(Color.argb(25, 0, 0, 0));
        return false;
      }
    }
    else if (paramMotionEvent.getAction() == 1)
    {
      paramView = this.jdField_a_of_type_AndroidViewView;
      if (paramView != null) {
        paramView.setBackgroundColor(Color.argb(0, 0, 0, 0));
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardFileOption.9
 * JD-Core Version:    0.7.0.1
 */