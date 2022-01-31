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
  private int jdField_a_of_type_Int = 0;
  private int[] jdField_a_of_type_ArrayOfInt;
  public int i = 12;
  
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
  
  protected FrameLayout.LayoutParams a()
  {
    return new FrameLayout.LayoutParams(-2, -2, 16);
  }
  
  public FrameLayout.LayoutParams a(AttributeSet paramAttributeSet)
  {
    return new FrameLayout.LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof FrameLayout.LayoutParams;
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return new FrameLayout.LayoutParams(paramLayoutParams);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i6 = getChildCount();
    int i7 = paramInt3 - paramInt1 - getPaddingLeft() - getPaddingRight();
    int i8 = getPaddingLeft();
    int i9 = getPaddingTop();
    int i10 = i7 / 2;
    paramInt2 = 0;
    int j = 0;
    int m;
    int k;
    label99:
    View localView;
    ViewGroup.MarginLayoutParams localMarginLayoutParams;
    int i3;
    int i2;
    int i1;
    int n;
    if (((this.jdField_a_of_type_ArrayOfInt == null) && (i6 > 0)) || ((this.jdField_a_of_type_ArrayOfInt != null) && (this.jdField_a_of_type_ArrayOfInt.length < i6)))
    {
      this.jdField_a_of_type_ArrayOfInt = new int[i6];
      paramInt4 = 0;
      m = 0;
      k = 0;
      paramInt3 = 0;
      paramInt1 = paramInt2;
      paramInt2 = k;
      if (m >= i6) {
        break label508;
      }
      localView = getChildAt(m);
      localMarginLayoutParams = (ViewGroup.MarginLayoutParams)localView.getLayoutParams();
      i3 = j;
      i2 = paramInt4;
      i1 = paramInt2;
      n = paramInt3;
      k = paramInt1;
      if (localView.getVisibility() != 8)
      {
        k = localView.getMeasuredWidth();
        i1 = localView.getMeasuredHeight();
        k = localMarginLayoutParams.leftMargin + k + localMarginLayoutParams.rightMargin;
        i2 = localMarginLayoutParams.topMargin;
        i3 = localMarginLayoutParams.bottomMargin;
        if (this.jdField_a_of_type_Int != 1) {
          break label411;
        }
        if (paramInt3 != 0) {
          break label395;
        }
        paramInt1 = Math.max(i10, k);
        label217:
        if (paramInt3 + paramInt1 <= i7) {
          break label1047;
        }
        this.jdField_a_of_type_ArrayOfInt[j] = paramInt2;
        k = j + 1;
        j = 0;
        paramInt3 = paramInt4 + paramInt2;
        paramInt4 = 0;
        paramInt2 = k;
      }
    }
    for (;;)
    {
      k = j + paramInt1;
      j = paramInt1;
      paramInt1 = k;
      k = paramInt4;
      paramInt4 = paramInt3;
      paramInt3 = paramInt2;
      i1 = Math.max(k, i2 + i1 + i3);
      k = j;
      n = paramInt1;
      i2 = paramInt4;
      i3 = paramInt3;
      if ((m == i6 - 1) && (i3 < this.jdField_a_of_type_ArrayOfInt.length)) {
        this.jdField_a_of_type_ArrayOfInt[i3] = i1;
      }
      m += 1;
      j = i3;
      paramInt4 = i2;
      paramInt2 = i1;
      paramInt3 = n;
      paramInt1 = k;
      break label99;
      if (this.jdField_a_of_type_ArrayOfInt == null) {
        break;
      }
      paramInt1 = 0;
      while (paramInt1 < this.jdField_a_of_type_ArrayOfInt.length)
      {
        this.jdField_a_of_type_ArrayOfInt[paramInt1] = 0;
        paramInt1 += 1;
      }
      break;
      label395:
      paramInt1 = Math.max(i10, this.i + k);
      break label217;
      label411:
      if ((paramInt3 + k > i7) && (paramInt3 + k - localMarginLayoutParams.rightMargin <= i7)) {
        k -= localMarginLayoutParams.rightMargin;
      }
      for (;;)
      {
        n = k + paramInt3;
        paramInt3 = j;
        j = paramInt1;
        k = paramInt2;
        paramInt1 = n;
        break;
        if (paramInt3 + k > i7)
        {
          paramInt4 += paramInt2;
          this.jdField_a_of_type_ArrayOfInt[j] = paramInt2;
          j += 1;
          paramInt2 = 0;
          paramInt3 = 0;
          continue;
          label508:
          i1 = 0;
          m = 0;
          i3 = 0;
          k = 0;
          paramInt3 = 0;
          n = paramInt1;
          int i5;
          int i11;
          label631:
          int i4;
          if (i3 < i6)
          {
            localView = getChildAt(i3);
            localMarginLayoutParams = (ViewGroup.MarginLayoutParams)localView.getLayoutParams();
            if (localView.getVisibility() == 8) {
              break label1031;
            }
            int i12 = localView.getMeasuredWidth();
            int i13 = localView.getMeasuredHeight();
            i5 = localMarginLayoutParams.leftMargin + i12 + localMarginLayoutParams.rightMargin;
            paramInt1 = localMarginLayoutParams.topMargin;
            i11 = localMarginLayoutParams.bottomMargin + (paramInt1 + i13);
            if (this.jdField_a_of_type_Int == 1) {
              if (paramInt3 == 0)
              {
                n = Math.max(i10, i5);
                paramInt1 = m;
                paramInt4 = n;
                i4 = i5;
                paramInt2 = i1;
                j = k;
                i2 = paramInt3;
                if (paramInt3 + n > i7)
                {
                  paramInt2 = i1 + k;
                  paramInt1 = m + 1;
                  j = 0;
                  i2 = 0;
                  i4 = i5;
                  paramInt4 = n;
                }
                label688:
                n = localMarginLayoutParams.leftMargin + (i8 + i2);
                k = i9 + paramInt2 + localMarginLayoutParams.topMargin;
                if (((localMarginLayoutParams instanceof FrameLayout.LayoutParams)) && (paramInt1 < this.jdField_a_of_type_ArrayOfInt.length))
                {
                  m = ((FrameLayout.LayoutParams)localMarginLayoutParams).gravity;
                  paramInt3 = m;
                  if (m == -1) {
                    paramInt3 = 16;
                  }
                }
                switch (paramInt3 & 0x70)
                {
                default: 
                  paramInt3 = k;
                  label788:
                  localView.layout(n, paramInt3, n + i12, paramInt3 + i13);
                  if (this.jdField_a_of_type_Int == 1)
                  {
                    paramInt3 = i2 + paramInt4;
                    label822:
                    k = Math.max(j, i11);
                  }
                  break;
                }
              }
            }
          }
          for (;;)
          {
            i3 += 1;
            m = paramInt1;
            n = paramInt4;
            i1 = paramInt2;
            break;
            n = Math.max(i10, this.i + i5);
            break label631;
            if ((paramInt3 + i5 > i7) && (paramInt3 + i5 - localMarginLayoutParams.rightMargin <= i7))
            {
              i4 = i5 - localMarginLayoutParams.rightMargin;
              paramInt1 = m;
              paramInt4 = n;
              paramInt2 = i1;
              j = k;
              i2 = paramInt3;
              break label688;
            }
            paramInt1 = m;
            paramInt4 = n;
            i4 = i5;
            paramInt2 = i1;
            j = k;
            i2 = paramInt3;
            if (paramInt3 + i5 <= i7) {
              break label688;
            }
            paramInt2 = i1 + k;
            paramInt1 = m + 1;
            j = 0;
            i2 = 0;
            paramInt4 = n;
            i4 = i5;
            break label688;
            paramInt3 = (this.jdField_a_of_type_ArrayOfInt[paramInt1] - i11) / 2 + k;
            break label788;
            paramInt3 = this.jdField_a_of_type_ArrayOfInt[paramInt1] - i11 + k;
            break label788;
            paramInt3 = i2 + i4;
            break label822;
            return;
            label1031:
            paramInt1 = m;
            paramInt4 = n;
            paramInt2 = i1;
          }
        }
      }
      label1047:
      k = paramInt2;
      n = paramInt3;
      paramInt2 = j;
      paramInt3 = paramInt4;
      paramInt4 = k;
      j = n;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i8 = getChildCount();
    int i9 = View.MeasureSpec.getSize(paramInt1) - getPaddingLeft() - getPaddingRight();
    int i10 = i9 / 2;
    int k = 0;
    int n = 0;
    int m = 0;
    int j = 0;
    int i4 = 0;
    ViewGroup.MarginLayoutParams localMarginLayoutParams;
    int i1;
    int i7;
    if (i4 < i8)
    {
      View localView = getChildAt(i4);
      localMarginLayoutParams = (ViewGroup.MarginLayoutParams)localView.getLayoutParams();
      if (localView.getVisibility() == 8) {
        break label471;
      }
      measureChildWithMargins(localView, paramInt1, 0, paramInt2, 0);
      i1 = localView.getMeasuredWidth();
      int i11 = localView.getMeasuredHeight();
      i7 = i1 + localMarginLayoutParams.leftMargin + localMarginLayoutParams.rightMargin;
      int i12 = localMarginLayoutParams.topMargin;
      int i13 = localMarginLayoutParams.bottomMargin;
      if (this.jdField_a_of_type_Int == 1) {
        if (k == 0)
        {
          i1 = Math.max(i10, i7);
          label153:
          if (k + i1 <= i9) {
            break label452;
          }
          k = Math.max(m, k);
          j += n;
          m = 0;
          n = 0;
          label183:
          n += i1;
          i1 = Math.max(m, i11 + i12 + i13);
          m = n;
        }
      }
    }
    for (;;)
    {
      i4 += 1;
      n = k;
      k = m;
      m = n;
      n = i1;
      break;
      i1 = Math.max(i10, i7 + this.i);
      break label153;
      int i5;
      int i6;
      int i3;
      if ((k + i7 > i9) && (k + i7 - localMarginLayoutParams.rightMargin <= i9))
      {
        i5 = i7 - localMarginLayoutParams.rightMargin;
        i6 = k;
        i3 = n;
        i2 = m;
        i1 = j;
      }
      for (;;)
      {
        k = i2;
        n = i5 + i6;
        j = i1;
        m = i3;
        break;
        i5 = i7;
        i1 = j;
        i2 = m;
        i3 = n;
        i6 = k;
        if (k + i7 > i9)
        {
          i2 = Math.max(m, k);
          i1 = j + n;
          i3 = 0;
          i6 = 0;
          i5 = i7;
        }
      }
      k = Math.max(m, k);
      m = getPaddingLeft();
      i1 = getPaddingRight();
      j = Math.max(j + n + (getPaddingTop() + getPaddingBottom()), getSuggestedMinimumHeight());
      setMeasuredDimension(resolveSize(Math.max(k + (m + i1), getSuggestedMinimumWidth()), paramInt1), resolveSize(j, paramInt2));
      return;
      label452:
      int i2 = k;
      k = m;
      m = n;
      n = i2;
      break label183;
      label471:
      i1 = k;
      k = m;
      m = i1;
      i1 = n;
    }
  }
  
  public void setStyle(int paramInt)
  {
    if (paramInt == 1)
    {
      this.jdField_a_of_type_Int = 1;
      this.i = ((int)(getContext().getResources().getDisplayMetrics().density * 6.0F));
      return;
    }
    this.jdField_a_of_type_Int = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.widget.HorizontalLabelLayout
 * JD-Core Version:    0.7.0.1
 */