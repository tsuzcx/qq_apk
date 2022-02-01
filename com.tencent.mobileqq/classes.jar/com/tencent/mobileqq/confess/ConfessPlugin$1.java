package com.tencent.mobileqq.confess;

import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;

class ConfessPlugin$1
  implements View.OnTouchListener
{
  ConfessPlugin$1(ConfessPlugin paramConfessPlugin) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if (((i == 1) || (i == 3)) && ((paramView instanceof TextView)))
      {
        paramView = (TextView)paramView;
        i = paramView.getCurrentTextColor();
        paramView.setTextColor(Color.argb(255, Color.red(i), Color.green(i), Color.blue(i)));
      }
    }
    else if ((paramView instanceof TextView))
    {
      paramView = (TextView)paramView;
      i = paramView.getCurrentTextColor();
      paramView.setTextColor(Color.argb(128, Color.red(i), Color.green(i), Color.blue(i)));
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.confess.ConfessPlugin.1
 * JD-Core Version:    0.7.0.1
 */