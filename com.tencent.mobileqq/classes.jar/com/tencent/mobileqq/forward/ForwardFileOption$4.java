package com.tencent.mobileqq.forward;

import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageButton;

class ForwardFileOption$4
  implements View.OnTouchListener
{
  ForwardFileOption$4(ForwardFileOption paramForwardFileOption, ImageButton paramImageButton) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      this.a.setBackgroundColor(Color.argb(25, 0, 0, 0));
      return false;
    }
    if (paramMotionEvent.getAction() == 1) {
      this.a.setBackgroundColor(Color.argb(0, 0, 0, 0));
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardFileOption.4
 * JD-Core Version:    0.7.0.1
 */