package com.tencent.mobileqq.qwallet.hb.send.view.impl;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;

public class HorizontalLabelLayout
  extends ViewGroup
{
  private int a;
  private int b;
  
  public HorizontalLabelLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public HorizontalLabelLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public HorizontalLabelLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int k = getPaddingLeft();
    paramInt2 = getPaddingTop();
    int i2 = getPaddingRight();
    int i3 = getChildCount();
    int m = 0;
    int j = 0;
    int i = 1;
    int n;
    for (paramInt4 = 0; m < i3; paramInt4 = n)
    {
      View localView = getChildAt(m);
      if (localView.getVisibility() == 8)
      {
        n = paramInt4;
      }
      else
      {
        int i4 = localView.getMeasuredWidth();
        n = localView.getMeasuredHeight();
        j = Math.max(n, j);
        if (i != 0)
        {
          if (m > 0)
          {
            paramInt2 = paramInt2 + this.a + j;
            i = k;
            paramInt4 = n;
          }
          else
          {
            i = k;
            paramInt4 = j;
          }
        }
        else
        {
          i = this.b + paramInt4;
          paramInt4 = j;
        }
        int i1 = i + i4;
        if (i4 + i1 + i2 > paramInt3 - paramInt1) {
          j = 1;
        } else {
          j = 0;
        }
        localView.layout(i, paramInt2, i1, n + paramInt2);
        i = j;
        n = i1;
        j = paramInt4;
      }
      m += 1;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int m = resolveSize(0, paramInt1);
    int i4 = getPaddingLeft();
    int i3 = getPaddingTop();
    int i5 = getPaddingRight();
    int i6 = getPaddingBottom();
    int k = getChildCount();
    int i1 = i3;
    int n = 0;
    int i2 = 0;
    int j = 1;
    int i = 0;
    while (n < k)
    {
      View localView = getChildAt(n);
      ViewGroup.LayoutParams localLayoutParams = localView.getLayoutParams();
      localView.measure(getChildMeasureSpec(paramInt1, i4 + i5, localLayoutParams.width), getChildMeasureSpec(paramInt2, i3 + i6, localLayoutParams.height));
      int i7 = localView.getMeasuredWidth();
      i2 = Math.max(localView.getMeasuredHeight(), i2);
      if (j != 0)
      {
        if (n == 0) {
          i = i1 + i2;
        } else {
          i = i1 + i2 + this.a;
        }
        j = i4 + i7 + i5;
        i1 = i;
        i = j;
      }
      else
      {
        i = i + i7 + this.b;
      }
      if (i7 + i > m) {
        j = 1;
      } else {
        j = 0;
      }
      n += 1;
    }
    setMeasuredDimension(m, resolveSize(i1 + i6, paramInt2));
  }
  
  public void setHorizontalSpacing(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void setVerticalSpacing(int paramInt)
  {
    this.a = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.send.view.impl.HorizontalLabelLayout
 * JD-Core Version:    0.7.0.1
 */