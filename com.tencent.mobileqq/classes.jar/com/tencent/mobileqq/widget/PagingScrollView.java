package com.tencent.mobileqq.widget;

import aldd;
import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ScrollView;
import java.util.ArrayList;

public class PagingScrollView
  extends ScrollView
{
  protected GestureDetector a;
  protected PagingScrollView.OnScrollChangedListener a;
  protected ArrayList a;
  private boolean a;
  public boolean c = false;
  
  public PagingScrollView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Boolean = true;
    a(paramContext);
  }
  
  public PagingScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Boolean = true;
    a(paramContext);
  }
  
  protected void a(Context paramContext)
  {
    if (Build.VERSION.SDK_INT > 8) {
      setOverScrollMode(0);
    }
    setFadingEdgeLength(0);
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(paramContext, new PagingScrollView.YScrollDetector(this));
  }
  
  public void a(View paramView)
  {
    if (paramView == null) {
      return;
    }
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(paramView);
    paramView.setOnTouchListener(new aldd(this));
  }
  
  protected boolean a(View paramView, float paramFloat1, float paramFloat2)
  {
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    int i = arrayOfInt[1];
    int j = arrayOfInt[1];
    int k = paramView.getHeight();
    int m = arrayOfInt[0];
    int n = arrayOfInt[0];
    int i1 = paramView.getWidth();
    return (paramFloat2 >= i) && (paramFloat2 < j + k) && (paramFloat1 > m) && (paramFloat1 < n + i1);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        ((View)this.jdField_a_of_type_JavaUtilArrayList.get(i)).setOnTouchListener(null);
        i += 1;
      }
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int j = paramMotionEvent.getAction();
    float f1 = paramMotionEvent.getRawX();
    float f2 = paramMotionEvent.getRawY();
    int i;
    if (j == 0) {
      if (this.jdField_a_of_type_JavaUtilArrayList != null) {
        i = 0;
      }
    }
    for (;;)
    {
      if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        if (a((View)this.jdField_a_of_type_JavaUtilArrayList.get(i), f1, f2)) {
          this.c = true;
        }
      }
      else
      {
        if (this.c)
        {
          getParent().requestDisallowInterceptTouchEvent(true);
          if (QLog.isDevelopLevel()) {
            QLog.i("PageScrollView", 4, "P.ITE ACT_DOWNE onSpecialView");
          }
        }
        if ((this.c) && ((j == 1) || (j == 3)))
        {
          this.c = false;
          getParent().requestDisallowInterceptTouchEvent(false);
          this.jdField_a_of_type_Boolean = true;
          if (QLog.isDevelopLevel()) {
            QLog.i("PageScrollView", 4, "P.ITE ACT_UP or CANCEL");
          }
        }
        try
        {
          if (this.c)
          {
            super.onInterceptTouchEvent(paramMotionEvent);
            return this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
          }
          boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
          return bool;
        }
        catch (Exception paramMotionEvent)
        {
          paramMotionEvent.printStackTrace();
          return false;
        }
      }
      i += 1;
    }
  }
  
  public void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetPagingScrollView$OnScrollChangedListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPagingScrollView$OnScrollChangedListener.a(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.c)
    {
      int i = paramMotionEvent.getAction();
      if ((i == 1) || (i == 3))
      {
        this.c = false;
        getParent().requestDisallowInterceptTouchEvent(false);
        if (QLog.isDevelopLevel()) {
          QLog.i("PageScrollView", 4, "P.TE ACT_UP or CANCEL");
        }
      }
    }
    try
    {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      return bool;
    }
    catch (Exception paramMotionEvent)
    {
      paramMotionEvent.printStackTrace();
    }
    return false;
  }
  
  public void setOnScrollChangedListener(PagingScrollView.OnScrollChangedListener paramOnScrollChangedListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPagingScrollView$OnScrollChangedListener = paramOnScrollChangedListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.widget.PagingScrollView
 * JD-Core Version:    0.7.0.1
 */