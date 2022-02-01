package com.tencent.mobileqq.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;

public class RatioLayout
  extends ViewGroup
{
  boolean a = false;
  
  public RatioLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public RatioLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public RatioLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a(View paramView, float paramFloat1, float paramFloat2)
  {
    a(paramView, (int)(paramFloat1 * getWidth()), (int)(paramFloat2 * getHeight()));
  }
  
  public void a(View paramView, int paramInt1, int paramInt2)
  {
    if ((paramView != null) && (paramView.getParent() == this))
    {
      RatioLayout.LayoutParams localLayoutParams = (RatioLayout.LayoutParams)paramView.getLayoutParams();
      float f2 = 0.0F;
      float f1;
      if (localLayoutParams != null)
      {
        f2 = localLayoutParams.c;
        f1 = localLayoutParams.d;
      }
      else
      {
        f1 = 0.0F;
      }
      int j = paramView.getWidth();
      int i = paramView.getHeight();
      j = (int)(f2 * j);
      i = (int)(f1 * i);
      paramView.offsetLeftAndRight(paramInt1 - j - paramView.getLeft());
      paramView.offsetTopAndBottom(paramInt2 - i - paramView.getTop());
    }
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof RatioLayout.LayoutParams;
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new RatioLayout.LayoutParams(-2, -2, 0.0F, 0.0F);
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new RatioLayout.LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt2 = getChildCount();
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      View localView = getChildAt(paramInt1);
      if (localView.getVisibility() != 8)
      {
        RatioLayout.LayoutParams localLayoutParams = (RatioLayout.LayoutParams)localView.getLayoutParams();
        paramInt3 = localView.getMeasuredWidth();
        paramInt4 = localView.getMeasuredHeight();
        int i = getPaddingLeft() + (int)(localLayoutParams.a * getMeasuredWidth()) - (int)(localLayoutParams.c * paramInt3);
        int j = getPaddingTop() + (int)(localLayoutParams.b * getMeasuredHeight()) - (int)(localLayoutParams.d * paramInt4);
        localView.layout(i, j, paramInt3 + i, paramInt4 + j);
      }
      paramInt1 += 1;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i1 = getChildCount();
    if (this.a)
    {
      super.onMeasure(paramInt1, paramInt2);
      return;
    }
    measureChildren(paramInt1, paramInt2);
    int i2 = View.MeasureSpec.getSize(paramInt1);
    int i3 = View.MeasureSpec.getSize(paramInt2);
    int k = 0;
    int j = 0;
    for (int i = 0; k < i1; i = m)
    {
      View localView = getChildAt(k);
      int n = j;
      m = i;
      if (localView.getVisibility() != 8)
      {
        RatioLayout.LayoutParams localLayoutParams = (RatioLayout.LayoutParams)localView.getLayoutParams();
        n = localView.getMeasuredWidth();
        m = localView.getMeasuredHeight();
        int i6 = (int)(localLayoutParams.a * i2);
        int i7 = (int)(localLayoutParams.c * n);
        int i4 = (int)(localLayoutParams.b * i3);
        int i5 = (int)(localLayoutParams.d * m);
        n = Math.max(j, i6 - i7 + n);
        m = Math.max(i, i4 - i5 + m);
      }
      k += 1;
      j = n;
    }
    k = getPaddingLeft();
    int m = getPaddingRight();
    i = Math.max(i + (getPaddingTop() + getPaddingBottom()), getSuggestedMinimumHeight());
    setMeasuredDimension(resolveSize(Math.max(j + (k + m), getSuggestedMinimumWidth()), paramInt1), resolveSize(i, paramInt2));
  }
  
  public void setSkipMeasure(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.RatioLayout
 * JD-Core Version:    0.7.0.1
 */