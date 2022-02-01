package com.tencent.mobileqq.onlinestatus.utils;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public class LottieHelper$ViewAlphaOnTouchListener
  implements View.OnTouchListener
{
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if ((i == 1) || (i == 3)) {
        LottieHelper.a(paramView, 1.0F);
      }
    }
    else {
      LottieHelper.a(paramView, 0.5F);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.utils.LottieHelper.ViewAlphaOnTouchListener
 * JD-Core Version:    0.7.0.1
 */