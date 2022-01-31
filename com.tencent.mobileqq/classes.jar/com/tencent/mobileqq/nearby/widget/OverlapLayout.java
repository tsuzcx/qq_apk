package com.tencent.mobileqq.nearby.widget;

import aekt;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.mobileqq.R.styleable;

public class OverlapLayout
  extends ViewGroup
{
  protected float a;
  protected float b;
  
  public OverlapLayout(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public OverlapLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public OverlapLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.OverlapLayout);
    this.a = paramAttributeSet.getDimension(1, aekt.a(4.0F, paramContext.getResources()));
    this.b = paramAttributeSet.getDimension(0, aekt.a(15.0F, paramContext.getResources()));
    paramAttributeSet.recycle();
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new ViewGroup.MarginLayoutParams(-2, -2);
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new ViewGroup.MarginLayoutParams(getContext(), paramAttributeSet);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return new ViewGroup.MarginLayoutParams(paramLayoutParams);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int j = getPaddingLeft();
    int i = getPaddingTop();
    paramInt4 = 0;
    paramInt2 = 0;
    int i2 = getChildCount();
    int k = 0;
    int m;
    int n;
    int i1;
    while (k < i2)
    {
      View localView = getChildAt(k);
      if (localView.getVisibility() == 8)
      {
        m = j;
        j = i;
        i = paramInt4;
        paramInt4 = paramInt2;
        k += 1;
        paramInt2 = paramInt4;
        paramInt4 = i;
        i = j;
        j = m;
      }
      else
      {
        ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)localView.getLayoutParams();
        int i3 = localMarginLayoutParams.leftMargin + localView.getMeasuredWidth() + localMarginLayoutParams.rightMargin;
        m = paramInt2;
        n = paramInt4;
        paramInt2 = i;
        i1 = j;
        if (j + i3 + getPaddingRight() > paramInt3 - paramInt1)
        {
          i1 = getPaddingLeft();
          paramInt2 = (int)(i + (paramInt4 + this.a));
          n = 0;
          m = 0;
        }
        localView.layout(localMarginLayoutParams.leftMargin + i1, localMarginLayoutParams.topMargin + paramInt2, localMarginLayoutParams.leftMargin + i1 + localView.getMeasuredWidth(), localMarginLayoutParams.topMargin + paramInt2 + localView.getMeasuredHeight());
        paramInt4 = i1 + i3;
        i = localMarginLayoutParams.topMargin;
        j = localView.getMeasuredHeight();
        i1 = localMarginLayoutParams.bottomMargin;
        if (m == i2 - 1) {
          break label307;
        }
        paramInt4 = (int)(paramInt4 - this.b);
      }
    }
    label307:
    for (;;)
    {
      i = Math.max(n, j + i + i1);
      j = m + 1;
      m = paramInt4;
      paramInt4 = j;
      j = paramInt2;
      break;
      return;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    int i8 = View.MeasureSpec.getMode(paramInt1);
    int i5 = View.MeasureSpec.getSize(paramInt1);
    int i7 = View.MeasureSpec.getMode(paramInt2);
    int i4 = View.MeasureSpec.getSize(paramInt2);
    int m = 0;
    int j = 0;
    int n = 0;
    int k = 0;
    int i = 0;
    int i9 = getChildCount();
    int i2 = 0;
    View localView;
    int i3;
    int i1;
    if (i2 < i9)
    {
      localView = getChildAt(i2);
      if (localView.getVisibility() == 8)
      {
        if (i2 != i9 - 1) {
          break label462;
        }
        i3 = Math.max(m, n);
        i1 = n;
        m = j + k;
        n = i3;
        j = k;
        k = i1;
      }
    }
    for (;;)
    {
      i3 = i2 + 1;
      i1 = k;
      i2 = n;
      k = j;
      n = i1;
      j = m;
      m = i2;
      i2 = i3;
      break;
      measureChildWithMargins(localView, paramInt1, 0, paramInt2, 0);
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)localView.getLayoutParams();
      int i6 = localView.getMeasuredWidth() + localMarginLayoutParams.leftMargin + localMarginLayoutParams.rightMargin;
      i1 = localView.getMeasuredHeight() + localMarginLayoutParams.topMargin + localMarginLayoutParams.bottomMargin;
      float f2 = n + i6;
      float f1;
      if (i > 0)
      {
        f1 = this.b;
        label233:
        if (f2 - f1 <= i5 - getPaddingLeft() - getPaddingRight()) {
          break label344;
        }
        n = Math.max(m, n);
        m = (int)(j + (k + this.a));
        i3 = 0;
        k = i6;
        j = i1;
      }
      for (;;)
      {
        i = m;
        i1 = n;
        if (i2 == i9 - 1)
        {
          i1 = Math.max(k, n);
          i = m + j;
        }
        n = i1;
        m = i;
        i = i3 + 1;
        break;
        f1 = 0.0F;
        break label233;
        label344:
        i3 = n + i6;
        n = i3;
        if (i > 0) {
          n = (int)(i3 - this.b);
        }
        i1 = Math.max(k, i1);
        k = n;
        n = m;
        m = j;
        j = i1;
        i3 = i;
      }
      if (i8 == 1073741824)
      {
        paramInt1 = i5;
        if (i7 != 1073741824) {
          break label446;
        }
      }
      label446:
      for (paramInt2 = i4;; paramInt2 = getPaddingTop() + j + getPaddingBottom())
      {
        setMeasuredDimension(paramInt1, paramInt2);
        return;
        paramInt1 = getPaddingLeft() + m + getPaddingRight();
        break;
      }
      label462:
      i1 = j;
      i3 = m;
      j = k;
      k = n;
      m = i1;
      n = i3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.widget.OverlapLayout
 * JD-Core Version:    0.7.0.1
 */