package com.tencent.mobileqq.forward;

import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;

class ForwardFileOption$7
  implements View.OnTouchListener
{
  ForwardFileOption$7(ForwardFileOption paramForwardFileOption) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = ForwardFileOption.c(this.a);
    if (paramMotionEvent.getAction() == 0)
    {
      paramMotionEvent = paramView.findViewById(2131433642);
      if (paramMotionEvent != null) {
        paramMotionEvent.setBackgroundColor(Color.argb(25, 0, 0, 0));
      }
      if (i == 1) {
        return false;
      }
      if (i == 3)
      {
        paramView = (ImageView)paramView.findViewById(2131433648);
        if (paramView != null)
        {
          paramView.setImageResource(2130840440);
          return false;
        }
      }
    }
    else if (paramMotionEvent.getAction() == 1)
    {
      paramMotionEvent = paramView.findViewById(2131433642);
      if (paramMotionEvent != null) {
        paramMotionEvent.setBackgroundColor(Color.argb(0, 0, 0, 0));
      }
      if (i == 1) {
        return false;
      }
      if (i == 3)
      {
        paramView = (ImageView)paramView.findViewById(2131433648);
        if (paramView != null) {
          paramView.setImageResource(2130840439);
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardFileOption.7
 * JD-Core Version:    0.7.0.1
 */