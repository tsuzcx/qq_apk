package com.tencent.mobileqq.widget;

import aktn;
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
  float a;
  public int a;
  public Handler a;
  public Runnable a;
  float b;
  public int b;
  float c;
  public int c;
  public int d;
  public int e = getResources().getDisplayMetrics().widthPixels;
  int f = 3;
  
  public CustomHorizontalScrollView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangRunnable = new aktn(this);
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
    this.jdField_b_of_type_Int = ((int)(this.jdField_a_of_type_Float * 70.0F + 0.5D));
    this.jdField_c_of_type_Int = ((int)(this.jdField_a_of_type_Float + 0.5D));
  }
  
  public CustomHorizontalScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangRunnable = new aktn(this);
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
    this.jdField_b_of_type_Int = ((int)(this.jdField_a_of_type_Float * 70.0F + 0.5D));
    this.jdField_c_of_type_Int = ((int)(this.jdField_a_of_type_Float + 0.5D));
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.dispatchTouchEvent(paramMotionEvent);
      getParent().requestDisallowInterceptTouchEvent(true);
      this.jdField_b_of_type_Float = f1;
      this.jdField_c_of_type_Float = f2;
      continue;
      if (((this.f * Math.abs(f1 - this.jdField_b_of_type_Float) > Math.abs(f2 - this.jdField_c_of_type_Float)) || ((f1 == this.jdField_b_of_type_Float) && (f2 == this.jdField_c_of_type_Float))) && (getScrollX() != 0)) {
        getParent().requestDisallowInterceptTouchEvent(true);
      } else {
        getParent().requestDisallowInterceptTouchEvent(false);
      }
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.widget.CustomHorizontalScrollView
 * JD-Core Version:    0.7.0.1
 */