package com.tencent.mobileqq.troop.activity;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewParent;

class TroopNickRuleFragment$4
  implements View.OnTouchListener
{
  TroopNickRuleFragment$4(TroopNickRuleFragment paramTroopNickRuleFragment) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramView == this.a.a)
    {
      int i = paramMotionEvent.getAction();
      if (i == 0)
      {
        paramView.getParent().requestDisallowInterceptTouchEvent(true);
        return false;
      }
      if ((i == 1) || (i == 3)) {
        paramView.getParent().requestDisallowInterceptTouchEvent(false);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopNickRuleFragment.4
 * JD-Core Version:    0.7.0.1
 */