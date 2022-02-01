package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.widget.HorizontalScrollView;

public class CustomHorizontalScrollView
  extends HorizontalScrollView
{
  float jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
  int jdField_a_of_type_Int = -1;
  Handler jdField_a_of_type_AndroidOsHandler = new Handler();
  Runnable jdField_a_of_type_JavaLangRunnable = new CustomHorizontalScrollView.1(this);
  float jdField_b_of_type_Float;
  int jdField_b_of_type_Int;
  float jdField_c_of_type_Float;
  int jdField_c_of_type_Int;
  int d;
  int e = getResources().getDisplayMetrics().widthPixels;
  int f = 3;
  
  public CustomHorizontalScrollView(Context paramContext)
  {
    super(paramContext);
    float f1 = this.jdField_a_of_type_Float;
    double d1 = 70.0F * f1;
    Double.isNaN(d1);
    this.jdField_b_of_type_Int = ((int)(d1 + 0.5D));
    d1 = f1;
    Double.isNaN(d1);
    this.jdField_c_of_type_Int = ((int)(d1 + 0.5D));
  }
  
  public CustomHorizontalScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    float f1 = this.jdField_a_of_type_Float;
    double d1 = 70.0F * f1;
    Double.isNaN(d1);
    this.jdField_b_of_type_Int = ((int)(d1 + 0.5D));
    d1 = f1;
    Double.isNaN(d1);
    this.jdField_c_of_type_Int = ((int)(d1 + 0.5D));
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if ((i != 1) && (i != 2) && (i != 3)) {
        return bool;
      }
      if (((this.f * Math.abs(f1 - this.jdField_b_of_type_Float) > Math.abs(f2 - this.jdField_c_of_type_Float)) || ((f1 == this.jdField_b_of_type_Float) && (f2 == this.jdField_c_of_type_Float))) && (getScrollX() != 0))
      {
        getParent().requestDisallowInterceptTouchEvent(true);
        return bool;
      }
      getParent().requestDisallowInterceptTouchEvent(false);
      return bool;
    }
    getParent().requestDisallowInterceptTouchEvent(true);
    this.jdField_b_of_type_Float = f1;
    this.jdField_c_of_type_Float = f2;
    return bool;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3))
    {
      View localView = getChildAt(0);
      if (localView != null) {
        this.d = localView.getMeasuredWidth();
      }
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 5L);
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setOverScrollMode(int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 9) {
      super.setOverScrollMode(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.CustomHorizontalScrollView
 * JD-Core Version:    0.7.0.1
 */