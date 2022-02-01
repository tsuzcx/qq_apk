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
    switch (paramMotionEvent.getAction())
    {
    case 2: 
    default: 
      return false;
    case 0: 
      this.a.setVisibility(0);
      return false;
    }
    this.a.setVisibility(8);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.OnlineStatusUtil.MyTouchViewOnTouchListener
 * JD-Core Version:    0.7.0.1
 */