package com.tencent.mobileqq.onlinestatus;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public class OnlineStatusUtil$MyTouchViewOnTouchListener
  implements View.OnTouchListener
{
  private View a;
  
  public OnlineStatusUtil$MyTouchViewOnTouchListener(View paramView)
  {
    this.a = paramView;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if ((i != 1) && (i != 3)) {
        return false;
      }
      this.a.setVisibility(8);
      return false;
    }
    this.a.setVisibility(0);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.OnlineStatusUtil.MyTouchViewOnTouchListener
 * JD-Core Version:    0.7.0.1
 */