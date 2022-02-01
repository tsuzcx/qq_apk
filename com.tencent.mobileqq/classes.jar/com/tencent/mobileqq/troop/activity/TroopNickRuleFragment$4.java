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
    int i;
    if (paramView == this.a.a)
    {
      i = paramMotionEvent.getAction();
      if (i != 0) {
        break label32;
      }
      paramView.getParent().requestDisallowInterceptTouchEvent(true);
    }
    label32:
    while ((i != 1) && (i != 3)) {
      return false;
    }
    paramView.getParent().requestDisallowInterceptTouchEvent(false);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopNickRuleFragment.4
 * JD-Core Version:    0.7.0.1
 */