package com.tencent.mobileqq.widget;

import android.view.View;
import android.widget.FrameLayout;

public class Vote2RotateAnimation
{
  private static long jdField_a_of_type_Long = 400L;
  private static boolean jdField_a_of_type_Boolean = false;
  
  public static void a()
  {
    jdField_a_of_type_Boolean = false;
  }
  
  public static void a(FrameLayout paramFrameLayout)
  {
    if (jdField_a_of_type_Boolean) {
      return;
    }
    jdField_a_of_type_Boolean = true;
    paramFrameLayout.invalidate();
    View localView = paramFrameLayout.getChildAt(1);
    paramFrameLayout = paramFrameLayout.getChildAt(0);
    CubeLeftOutAnimation localCubeLeftOutAnimation = new CubeLeftOutAnimation(localView);
    localCubeLeftOutAnimation.setDuration(jdField_a_of_type_Long);
    localCubeLeftOutAnimation.setFillAfter(true);
    CubeRightInAnimation localCubeRightInAnimation = new CubeRightInAnimation(paramFrameLayout);
    localCubeRightInAnimation.setDuration(jdField_a_of_type_Long);
    localCubeRightInAnimation.setFillAfter(true);
    localView.startAnimation(localCubeLeftOutAnimation);
    paramFrameLayout.startAnimation(localCubeRightInAnimation);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.Vote2RotateAnimation
 * JD-Core Version:    0.7.0.1
 */