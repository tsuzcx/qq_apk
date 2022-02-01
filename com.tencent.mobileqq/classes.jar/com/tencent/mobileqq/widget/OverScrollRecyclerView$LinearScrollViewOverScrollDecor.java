package com.tencent.mobileqq.widget;

import android.view.MotionEvent;
import android.view.View;

public class OverScrollRecyclerView$LinearScrollViewOverScrollDecor
  implements OverScrollRecyclerView.IOverScrollDecor
{
  protected int a = 1;
  
  public void a(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void a(View paramView, float paramFloat)
  {
    if (this.a == 1)
    {
      paramView.setTranslationY(paramFloat);
      return;
    }
    paramView.setTranslationX(paramFloat);
  }
  
  public void a(View paramView, float paramFloat, MotionEvent paramMotionEvent)
  {
    if (this.a == 1)
    {
      paramView.setTranslationY(paramFloat);
      paramMotionEvent.offsetLocation(0.0F, paramFloat - paramMotionEvent.getY(0));
      return;
    }
    paramView.setTranslationX(paramFloat);
    paramMotionEvent.offsetLocation(paramFloat - paramMotionEvent.getX(0), 0.0F);
  }
  
  public void a(View paramView, OverScrollRecyclerView.AnimationAttributes paramAnimationAttributes)
  {
    if (this.a == 1)
    {
      paramAnimationAttributes.jdField_a_of_type_AndroidUtilProperty = View.TRANSLATION_Y;
      paramAnimationAttributes.jdField_a_of_type_Float = paramView.getTranslationY();
      paramAnimationAttributes.b = paramView.getHeight();
      return;
    }
    paramAnimationAttributes.jdField_a_of_type_AndroidUtilProperty = View.TRANSLATION_X;
    paramAnimationAttributes.jdField_a_of_type_Float = paramView.getTranslationX();
    paramAnimationAttributes.b = paramView.getWidth();
  }
  
  public boolean a(View paramView)
  {
    if (this.a == 1) {
      if (paramView.canScrollVertically(-1)) {}
    }
    while (!paramView.canScrollHorizontally(-1))
    {
      return true;
      return false;
    }
    return false;
  }
  
  public boolean a(View paramView, OverScrollRecyclerView.MotionAttributes paramMotionAttributes, MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (paramMotionEvent.getHistorySize() == 0) {}
    float f1;
    float f2;
    do
    {
      return false;
      f1 = paramMotionEvent.getY(0) - paramMotionEvent.getHistoricalY(0, 0);
      f2 = paramMotionEvent.getX(0) - paramMotionEvent.getHistoricalX(0, 0);
      if (this.a != 1) {
        break;
      }
    } while (Math.abs(f1) < Math.abs(f2));
    paramMotionAttributes.jdField_a_of_type_Float = paramView.getTranslationY();
    paramMotionAttributes.b = f1;
    if (paramMotionAttributes.b > 0.0F) {
      bool1 = true;
    }
    for (paramMotionAttributes.jdField_a_of_type_Boolean = bool1;; paramMotionAttributes.jdField_a_of_type_Boolean = bool1)
    {
      return true;
      if (Math.abs(f2) < Math.abs(f1)) {
        break;
      }
      paramMotionAttributes.jdField_a_of_type_Float = paramView.getTranslationX();
      paramMotionAttributes.b = f2;
      bool1 = bool2;
      if (paramMotionAttributes.b > 0.0F) {
        bool1 = true;
      }
    }
  }
  
  public boolean b(View paramView)
  {
    if (this.a == 1) {
      if (paramView.canScrollVertically(1)) {}
    }
    while (!paramView.canScrollHorizontally(1))
    {
      return true;
      return false;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.widget.OverScrollRecyclerView.LinearScrollViewOverScrollDecor
 * JD-Core Version:    0.7.0.1
 */