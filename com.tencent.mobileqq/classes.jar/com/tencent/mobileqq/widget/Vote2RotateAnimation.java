package com.tencent.mobileqq.widget;

import android.view.View;
import android.widget.FrameLayout;

public class Vote2RotateAnimation
{
  private static long a = 400L;
  private static boolean b = false;
  
  public static void a()
  {
    b = false;
  }
  
  public static void a(FrameLayout paramFrameLayout)
  {
    if (b) {
      return;
    }
    b = true;
    paramFrameLayout.invalidate();
    View localView = paramFrameLayout.getChildAt(1);
    paramFrameLayout = paramFrameLayout.getChildAt(0);
    CubeLeftOutAnimation localCubeLeftOutAnimation = new CubeLeftOutAnimation(localView);
    localCubeLeftOutAnimation.setDuration(a);
    localCubeLeftOutAnimation.setFillAfter(true);
    CubeRightInAnimation localCubeRightInAnimation = new CubeRightInAnimation(paramFrameLayout);
    localCubeRightInAnimation.setDuration(a);
    localCubeRightInAnimation.setFillAfter(true);
    localView.startAnimation(localCubeLeftOutAnimation);
    paramFrameLayout.startAnimation(localCubeRightInAnimation);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.Vote2RotateAnimation
 * JD-Core Version:    0.7.0.1
 */