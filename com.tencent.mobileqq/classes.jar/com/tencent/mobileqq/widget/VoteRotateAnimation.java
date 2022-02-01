package com.tencent.mobileqq.widget;

import android.view.View;
import android.view.ViewGroup;

public class VoteRotateAnimation
{
  private static long a = 400L;
  private static boolean b = false;
  
  public static void a()
  {
    b = false;
  }
  
  public static void a(ViewGroup paramViewGroup)
  {
    if (b) {
      return;
    }
    b = true;
    paramViewGroup.invalidate();
    View localView = paramViewGroup.getChildAt(0);
    paramViewGroup = paramViewGroup.getChildAt(1);
    RotatePageOutAnimation localRotatePageOutAnimation = new RotatePageOutAnimation(paramViewGroup);
    localRotatePageOutAnimation.setDuration(a);
    localRotatePageOutAnimation.setFillAfter(true);
    localRotatePageOutAnimation.setAnimationListener(new VoteRotateAnimation.1(localView, paramViewGroup));
    paramViewGroup.startAnimation(localRotatePageOutAnimation);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.VoteRotateAnimation
 * JD-Core Version:    0.7.0.1
 */