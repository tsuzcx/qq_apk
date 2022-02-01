package com.tencent.mobileqq.troop.widget;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class PinnedHeaderIphoneTreeView$1
  implements View.OnTouchListener
{
  PinnedHeaderIphoneTreeView$1(PinnedHeaderIphoneTreeView paramPinnedHeaderIphoneTreeView) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 3) {
          return false;
        }
        paramView.setPressed(false);
        this.a.invalidate();
        return false;
      }
      if (paramView.isPressed())
      {
        paramView.setPressed(false);
        paramView = this.a;
        paramView.collapseGroup(paramView.d);
        paramView = this.a;
        paramView.setSelectedGroup(paramView.d);
        this.a.a = null;
      }
      return true;
    }
    paramView.setPressed(true);
    this.a.invalidate();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.PinnedHeaderIphoneTreeView.1
 * JD-Core Version:    0.7.0.1
 */