package com.tencent.mobileqq.forward;

import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageButton;

class ForwardFileOption$6
  implements View.OnTouchListener
{
  ForwardFileOption$6(ForwardFileOption paramForwardFileOption, ImageButton paramImageButton) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0) {
      this.jdField_a_of_type_AndroidWidgetImageButton.setBackgroundColor(Color.argb(25, 0, 0, 0));
    }
    while (paramMotionEvent.getAction() != 1) {
      return false;
    }
    this.jdField_a_of_type_AndroidWidgetImageButton.setBackgroundColor(Color.argb(0, 0, 0, 0));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardFileOption.6
 * JD-Core Version:    0.7.0.1
 */