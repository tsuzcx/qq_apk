package com.tencent.mobileqq.extendfriend.wiget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import aoll;

public class TabLayout
  extends HorizontalScrollView
{
  protected float a;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private aoll jdField_a_of_type_Aoll;
  protected float b;
  protected float c;
  protected float d;
  
  public TabLayout(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public TabLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public TabLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    setOverScrollMode(2);
    setHorizontalScrollBarEnabled(false);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(getContext());
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(0);
    addView(this.jdField_a_of_type_AndroidWidgetLinearLayout, new ViewGroup.LayoutParams(-1, -1));
  }
  
  public ViewGroup a()
  {
    return this.jdField_a_of_type_AndroidWidgetLinearLayout;
  }
  
  public void a(aoll paramaoll)
  {
    int i = 1;
    int k = 0;
    int m;
    if (paramaoll != null)
    {
      m = paramaoll.a();
      if (m > 0) {
        break label23;
      }
    }
    for (;;)
    {
      return;
      label23:
      this.jdField_a_of_type_Aoll = paramaoll;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
      int j;
      if (m <= paramaoll.b())
      {
        setFillViewport(true);
        j = 0;
      }
      while (k < m)
      {
        View localView = paramaoll.a(k);
        if (localView != null)
        {
          LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(j, -1, i);
          Rect localRect = paramaoll.a(k);
          localLayoutParams.leftMargin = localRect.left;
          localLayoutParams.topMargin = localRect.top;
          localLayoutParams.rightMargin = localRect.right;
          localLayoutParams.bottomMargin = localRect.bottom;
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView, localLayoutParams);
        }
        k += 1;
        continue;
        j = paramaoll.c();
        setFillViewport(false);
        i = 0;
      }
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.dispatchTouchEvent(paramMotionEvent);
      this.b = 0.0F;
      this.jdField_a_of_type_Float = 0.0F;
      this.c = paramMotionEvent.getX();
      this.d = paramMotionEvent.getY();
      getParent().requestDisallowInterceptTouchEvent(true);
      continue;
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      this.jdField_a_of_type_Float += Math.abs(f1 - this.c);
      this.b += Math.abs(f2 - this.d);
      this.c = f1;
      this.d = f2;
      if (this.jdField_a_of_type_Float <= this.b) {
        getParent().requestDisallowInterceptTouchEvent(false);
      } else {
        getParent().requestDisallowInterceptTouchEvent(true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.wiget.TabLayout
 * JD-Core Version:    0.7.0.1
 */