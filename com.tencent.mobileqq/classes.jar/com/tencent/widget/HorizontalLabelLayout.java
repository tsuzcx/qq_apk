package com.tencent.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout.LayoutParams;

public class HorizontalLabelLayout
  extends ViewGroup
{
  private int[] a;
  private int b = 0;
  public int o = 12;
  
  public HorizontalLabelLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public HorizontalLabelLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public HorizontalLabelLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public FrameLayout.LayoutParams a(AttributeSet paramAttributeSet)
  {
    return new FrameLayout.LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof FrameLayout.LayoutParams;
  }
  
  protected FrameLayout.LayoutParams e()
  {
    return new FrameLayout.LayoutParams(-2, -2, 16);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return new FrameLayout.LayoutParams(paramLayoutParams);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i3 = getChildCount();
    int i2 = paramInt3 - paramInt1 - getPaddingLeft() - getPaddingRight();
    int i1 = getPaddingLeft();
    int i5 = getPaddingTop();
    int i9 = i2 / 2;
    Object localObject;
    if ((this.a != null) || (i3 <= 0))
    {
      localObject = this.a;
      if ((localObject == null) || (localObject.length >= i3)) {}
    }
    else
    {
      this.a = new int[i3];
      break label116;
    }
    if (this.a != null)
    {
      paramInt1 = 0;
      for (;;)
      {
        localObject = this.a;
        if (paramInt1 >= localObject.length) {
          break;
        }
        localObject[paramInt1] = 0;
        paramInt1 += 1;
      }
    }
    label116:
    int j = 0;
    paramInt4 = 0;
    paramInt3 = 0;
    paramInt2 = 0;
    ViewGroup.MarginLayoutParams localMarginLayoutParams;
    int m;
    int i6;
    int i7;
    int i8;
    for (paramInt1 = 0; j < i3; paramInt1 = i)
    {
      localObject = getChildAt(j);
      localMarginLayoutParams = (ViewGroup.MarginLayoutParams)((View)localObject).getLayoutParams();
      n = paramInt4;
      m = paramInt3;
      k = paramInt2;
      i = paramInt1;
      if (((View)localObject).getVisibility() != 8)
      {
        i = ((View)localObject).getMeasuredWidth();
        i4 = ((View)localObject).getMeasuredHeight();
        n = i + localMarginLayoutParams.leftMargin + localMarginLayoutParams.rightMargin;
        i6 = localMarginLayoutParams.topMargin;
        i7 = localMarginLayoutParams.bottomMargin;
        if (this.b == 1)
        {
          if (paramInt4 == 0) {
            paramInt1 = Math.max(i9, n);
          } else {
            paramInt1 = Math.max(i9, n + this.o);
          }
          k = paramInt1;
          m = paramInt4;
          i = paramInt3;
          paramInt1 = paramInt2;
          if (paramInt4 + k > i2)
          {
            this.a[paramInt3] = paramInt2;
            i = paramInt3 + 1;
            m = 0;
            paramInt1 = 0;
          }
          paramInt2 = m + k;
          paramInt4 = i;
          i = paramInt1;
          paramInt1 = k;
        }
        else
        {
          i8 = paramInt4 + n;
          if ((i8 > i2) && (i8 - localMarginLayoutParams.rightMargin <= i2))
          {
            k = n - localMarginLayoutParams.rightMargin;
            m = paramInt4;
            paramInt4 = paramInt3;
            i = paramInt2;
          }
          else
          {
            k = n;
            m = paramInt4;
            paramInt4 = paramInt3;
            i = paramInt2;
            if (i8 > i2)
            {
              this.a[paramInt3] = paramInt2;
              paramInt4 = paramInt3 + 1;
              m = 0;
              i = 0;
              k = n;
            }
          }
          paramInt2 = m + k;
        }
        k = Math.max(i, i4 + i6 + i7);
        i = paramInt1;
        m = paramInt4;
        n = paramInt2;
      }
      if (j == i3 - 1)
      {
        localObject = this.a;
        if (m < localObject.length) {
          localObject[m] = k;
        }
      }
      j += 1;
      paramInt4 = n;
      paramInt3 = m;
      paramInt2 = k;
    }
    int i4 = 0;
    int i = 0;
    j = 0;
    paramInt2 = 0;
    int k = 0;
    int n = i5;
    while (i4 < i3)
    {
      localObject = getChildAt(i4);
      localMarginLayoutParams = (ViewGroup.MarginLayoutParams)((View)localObject).getLayoutParams();
      if (((View)localObject).getVisibility() != 8)
      {
        int i11 = ((View)localObject).getMeasuredWidth();
        int i12 = ((View)localObject).getMeasuredHeight();
        i5 = localMarginLayoutParams.leftMargin + i11 + localMarginLayoutParams.rightMargin;
        int i10 = i12 + localMarginLayoutParams.topMargin + localMarginLayoutParams.bottomMargin;
        if (this.b == 1)
        {
          if (i == 0) {
            m = Math.max(i9, i5);
          } else {
            m = Math.max(i9, this.o + i5);
          }
          i6 = i;
          paramInt3 = j;
          paramInt4 = paramInt2;
          i7 = k;
          paramInt1 = m;
          i8 = i5;
          if (i + m <= i2) {
            break label784;
          }
          paramInt3 = j + k;
          paramInt4 = paramInt2 + 1;
          paramInt1 = m;
        }
        else
        {
          paramInt4 = i + i5;
          if ((paramInt4 > i2) && (paramInt4 - localMarginLayoutParams.rightMargin <= i2))
          {
            paramInt3 = i5 - localMarginLayoutParams.rightMargin;
            break label765;
          }
          paramInt3 = i5;
          if (paramInt4 <= i2) {
            break label765;
          }
          paramInt3 = j + k;
          paramInt4 = paramInt2 + 1;
        }
        i6 = 0;
        i7 = 0;
        i8 = i5;
        break label784;
        label765:
        i8 = paramInt3;
        i7 = k;
        paramInt4 = paramInt2;
        paramInt3 = j;
        i6 = i;
        label784:
        k = i1 + i6 + localMarginLayoutParams.leftMargin;
        i = n + paramInt3 + localMarginLayoutParams.topMargin;
        if (((localMarginLayoutParams instanceof FrameLayout.LayoutParams)) && (paramInt4 < this.a.length))
        {
          j = ((FrameLayout.LayoutParams)localMarginLayoutParams).gravity;
          paramInt2 = j;
          if (j == -1) {
            paramInt2 = 16;
          }
          paramInt2 &= 0x70;
          if (paramInt2 != 16)
          {
            if (paramInt2 != 80)
            {
              paramInt2 = i;
              break label911;
            }
            paramInt2 = this.a[paramInt4] - i10;
          }
          else
          {
            paramInt2 = (this.a[paramInt4] - i10) / 2;
          }
          paramInt2 = i + paramInt2;
        }
        else
        {
          paramInt2 = i;
        }
        label911:
        ((View)localObject).layout(k, paramInt2, i11 + k, paramInt2 + i12);
        if (this.b == 1) {
          paramInt2 = i6 + paramInt1;
        } else {
          paramInt2 = i6 + i8;
        }
        k = Math.max(i7, i10);
      }
      else
      {
        paramInt4 = paramInt2;
        paramInt3 = j;
        paramInt2 = i;
      }
      i4 += 1;
      i = paramInt2;
      j = paramInt3;
      paramInt2 = paramInt4;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i7 = getChildCount();
    int i8 = View.MeasureSpec.getSize(paramInt1) - getPaddingLeft() - getPaddingRight();
    int i9 = i8 / 2;
    int i4 = 0;
    int i1 = 0;
    int n = 0;
    int m = 0;
    for (int k = 0; i4 < i7; k = i)
    {
      View localView = getChildAt(i4);
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)localView.getLayoutParams();
      int i2 = i1;
      j = n;
      int i3 = m;
      i = k;
      if (localView.getVisibility() != 8)
      {
        measureChildWithMargins(localView, paramInt1, 0, paramInt2, 0);
        i = localView.getMeasuredWidth();
        int i10 = localView.getMeasuredHeight();
        j = i + localMarginLayoutParams.leftMargin + localMarginLayoutParams.rightMargin;
        int i11 = localMarginLayoutParams.topMargin;
        int i12 = localMarginLayoutParams.bottomMargin;
        if (this.b == 1)
        {
          if (n == 0) {
            j = Math.max(i9, j);
          } else {
            j = Math.max(i9, j + this.o);
          }
          i = j;
          i2 = i1;
          i6 = n;
          i3 = m;
          i5 = k;
          if (n + j <= i8) {
            break label334;
          }
          i2 = Math.max(i1, n);
          i = j;
        }
        else
        {
          int i13 = n + j;
          if ((i13 > i8) && (i13 - localMarginLayoutParams.rightMargin <= i8))
          {
            i = j - localMarginLayoutParams.rightMargin;
            i2 = i1;
            i6 = n;
            i3 = m;
            i5 = k;
            break label334;
          }
          i = j;
          i2 = i1;
          i6 = n;
          i3 = m;
          i5 = k;
          if (i13 <= i8) {
            break label334;
          }
          i2 = Math.max(i1, n);
          i = j;
        }
        i3 = m + k;
        int i6 = 0;
        int i5 = 0;
        label334:
        j = i6 + i;
        i = Math.max(i5, i10 + i11 + i12);
      }
      i4 += 1;
      i1 = i2;
      n = j;
      m = i3;
    }
    int i = Math.max(i1, n);
    int j = getPaddingLeft();
    n = getPaddingRight();
    k = Math.max(m + k + (getPaddingTop() + getPaddingBottom()), getSuggestedMinimumHeight());
    setMeasuredDimension(resolveSize(Math.max(i + (j + n), getSuggestedMinimumWidth()), paramInt1), resolveSize(k, paramInt2));
  }
  
  public void setStyle(int paramInt)
  {
    if (paramInt == 1)
    {
      this.b = 1;
      this.o = ((int)(getContext().getResources().getDisplayMetrics().density * 6.0F));
      return;
    }
    this.b = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.HorizontalLabelLayout
 * JD-Core Version:    0.7.0.1
 */