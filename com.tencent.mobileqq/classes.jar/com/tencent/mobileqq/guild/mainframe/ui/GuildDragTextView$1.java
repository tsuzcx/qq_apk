package com.tencent.mobileqq.guild.mainframe.ui;

import android.view.MotionEvent;
import com.tencent.mobileqq.guild.mainframe.attachcontainer.AbsGestureListener;

class GuildDragTextView$1
  extends AbsGestureListener
{
  GuildDragTextView$1(GuildDragTextView paramGuildDragTextView) {}
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    int i = this.a.getVisibility();
    boolean bool2 = false;
    if (i != 0) {
      return false;
    }
    float f1 = paramMotionEvent.getRawX();
    float f2 = paramMotionEvent.getRawY();
    paramMotionEvent = new int[2];
    this.a.getLocationOnScreen(paramMotionEvent);
    i = paramMotionEvent[0];
    int j = paramMotionEvent[1];
    int k = this.a.getMeasuredWidth();
    int m = this.a.getMeasuredHeight();
    boolean bool1 = bool2;
    if (f2 >= j)
    {
      bool1 = bool2;
      if (f2 <= m + j)
      {
        bool1 = bool2;
        if (f1 >= i)
        {
          bool1 = bool2;
          if (f1 <= k + i) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.ui.GuildDragTextView.1
 * JD-Core Version:    0.7.0.1
 */