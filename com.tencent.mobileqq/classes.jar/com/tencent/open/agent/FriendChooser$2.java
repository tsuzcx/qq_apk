package com.tencent.open.agent;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.inputmethod.InputMethodManager;

class FriendChooser$2
  implements View.OnTouchListener
{
  float a = 0.0F;
  float b = 0.0F;
  
  FriendChooser$2(FriendChooser paramFriendChooser) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i == 0)
    {
      this.a = paramMotionEvent.getRawX();
      this.b = paramMotionEvent.getRawY();
      return false;
    }
    if ((i == 2) && ((paramMotionEvent.getRawX() - this.a > 10.0F) || (paramMotionEvent.getRawY() - this.b > 10.0F))) {
      this.c.F.hideSoftInputFromWindow(paramView.getWindowToken(), 0);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.FriendChooser.2
 * JD-Core Version:    0.7.0.1
 */