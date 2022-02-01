package com.tencent.mobileqq.troop.troopsetting.activity;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public class TroopSettingActivity$MyViewAlphaOnTouchListener
  implements View.OnTouchListener
{
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if ((i == 1) || (i == 3)) {
        TroopSettingActivity.a(paramView, 1.0F);
      }
    }
    else {
      TroopSettingActivity.a(paramView, 0.5F);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopsetting.activity.TroopSettingActivity.MyViewAlphaOnTouchListener
 * JD-Core Version:    0.7.0.1
 */