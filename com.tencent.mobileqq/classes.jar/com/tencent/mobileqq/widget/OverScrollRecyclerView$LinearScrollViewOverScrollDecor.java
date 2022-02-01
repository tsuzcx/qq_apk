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
      return paramView.canScrollVertically(-1) ^ true;
    }
    return paramView.canScrollHorizontally(-1) ^ true;
  }
  
  public boolean a(View paramView, OverScrollRecyclerView.MotionAttributes paramMotionAttributes, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getHistorySize();
    boolean bool2 = false;
    boolean bool1 = false;
    if (i == 0) {
      return false;
    }
    float f1 = paramMotionEvent.getY(0) - paramMotionEvent.getHistoricalY(0, 0);
    float f2 = paramMotionEvent.getX(0) - paramMotionEvent.getHistoricalX(0, 0);
    if (this.a == 1)
    {
      if (Math.abs(f1) < Math.abs(f2)) {
        return false;
      }
      paramMotionAttributes.jdField_a_of_type_Float = paramView.getTranslationY();
      paramMotionAttributes.b = f1;
      if (paramMotionAttributes.b > 0.0F) {
        bool1 = true;
      }
      paramMotionAttributes.jdField_a_of_type_Boolean = bool1;
      return true;
    }
    if (Math.abs(f2) < Math.abs(f1)) {
      return false;
    }
    paramMotionAttributes.jdField_a_of_type_Float = paramView.getTranslationX();
    paramMotionAttributes.b = f2;
    bool1 = bool2;
    if (paramMotionAttributes.b > 0.0F) {
      bool1 = true;
    }
    paramMotionAttributes.jdField_a_of_type_Boolean = bool1;
    return true;
  }
  
  public boolean b(View paramView)
  {
    if (this.a == 1) {
      return paramView.canScrollVertically(1) ^ true;
    }
    return paramView.canScrollHorizontally(1) ^ true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.OverScrollRecyclerView.LinearScrollViewOverScrollDecor
 * JD-Core Version:    0.7.0.1
 */