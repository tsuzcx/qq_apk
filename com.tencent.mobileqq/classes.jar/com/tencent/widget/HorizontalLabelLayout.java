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
    int i4 = getChildCount();
    int i3 = paramInt3 - paramInt1 - getPaddingLeft() - getPaddingRight();
    int i2 = getPaddingLeft();
    int i6 = getPaddingTop();
    int i10 = i3 / 2;
    Object localObject;
    if ((this.jdField_a_of_type_ArrayOfInt != null) || (i4 <= 0))
    {
      localObject = this.jdField_a_of_type_ArrayOfInt;
      if ((localObject == null) || (localObject.length >= i4)) {}
    }
    else
    {
      this.jdField_a_of_type_ArrayOfInt = new int[i4];
      break label116;
    }
    if (this.jdField_a_of_type_ArrayOfInt != null)
    {
      paramInt1 = 0;
      for (;;)
      {
        localObject = this.jdField_a_of_type_ArrayOfInt;
        if (paramInt1 >= localObject.length) {
          break;
        }
        localObject[paramInt1] = 0;
        paramInt1 += 1;
      }
    }
    label116:
    int k = 0;
    paramInt4 = 0;
    paramInt3 = 0;
    paramInt2 = 0;
    ViewGroup.MarginLayoutParams localMarginLayoutParams;
    int n;
    int i7;
    int i8;
    int i9;
    for (paramInt1 = 0; k < i4; paramInt1 = j)
    {
      localObject = getChildAt(k);
      localMarginLayoutParams = (ViewGroup.MarginLayoutParams)((View)localObject).getLayoutParams();
      i1 = paramInt4;
      n = paramInt3;
      m = paramInt2;
      j = paramInt1;
      if (((View)localObject).getVisibility() != 8)
      {
        j = ((View)localObject).getMeasuredWidth();
        i5 = ((View)localObject).getMeasuredHeight();
        i1 = j + localMarginLayoutParams.leftMargin + localMarginLayoutParams.rightMargin;
        i7 = localMarginLayoutParams.topMargin;
        i8 = localMarginLayoutParams.bottomMargin;
        if (this.jdField_a_of_type_Int == 1)
        {
          if (paramInt4 == 0) {
            paramInt1 = Math.max(i10, i1);
          } else {
            paramInt1 = Math.max(i10, i1 + this.i);
          }
          m = paramInt1;
          n = paramInt4;
          j = paramInt3;
          paramInt1 = paramInt2;
          if (paramInt4 + m > i3)
          {
            this.jdField_a_of_type_ArrayOfInt[paramInt3] = paramInt2;
            j = paramInt3 + 1;
            n = 0;
            paramInt1 = 0;
          }
          paramInt2 = n + m;
          paramInt4 = j;
          j = paramInt1;
          paramInt1 = m;
        }
        else
        {
          i9 = paramInt4 + i1;
          if ((i9 > i3) && (i9 - localMarginLayoutParams.rightMargin <= i3))
          {
            m = i1 - localMarginLayoutParams.rightMargin;
            n = paramInt4;
            paramInt4 = paramInt3;
            j = paramInt2;
          }
          else
          {
            m = i1;
            n = paramInt4;
            paramInt4 = paramInt3;
            j = paramInt2;
            if (i9 > i3)
            {
              this.jdField_a_of_type_ArrayOfInt[paramInt3] = paramInt2;
              paramInt4 = paramInt3 + 1;
              n = 0;
              j = 0;
              m = i1;
            }
          }
          paramInt2 = n + m;
        }
        m = Math.max(j, i5 + i7 + i8);
        j = paramInt1;
        n = paramInt4;
        i1 = paramInt2;
      }
      if (k == i4 - 1)
      {
        localObject = this.jdField_a_of_type_ArrayOfInt;
        if (n < localObject.length) {
          localObject[n] = m;
        }
      }
      k += 1;
      paramInt4 = i1;
      paramInt3 = n;
      paramInt2 = m;
    }
    int i5 = 0;
    int j = 0;
    k = 0;
    paramInt2 = 0;
    int m = 0;
    int i1 = i6;
    while (i5 < i4)
    {
      localObject = getChildAt(i5);
      localMarginLayoutParams = (ViewGroup.MarginLayoutParams)((View)localObject).getLayoutParams();
      if (((View)localObject).getVisibility() != 8)
      {
        int i12 = ((View)localObject).getMeasuredWidth();
        int i13 = ((View)localObject).getMeasuredHeight();
        i6 = localMarginLayoutParams.leftMargin + i12 + localMarginLayoutParams.rightMargin;
        int i11 = i13 + localMarginLayoutParams.topMargin + localMarginLayoutParams.bottomMargin;
        if (this.jdField_a_of_type_Int == 1)
        {
          if (j == 0) {
            n = Math.max(i10, i6);
          } else {
            n = Math.max(i10, this.i + i6);
          }
          i7 = j;
          paramInt3 = k;
          paramInt4 = paramInt2;
          i8 = m;
          paramInt1 = n;
          i9 = i6;
          if (j + n <= i3) {
            break label784;
          }
          paramInt3 = k + m;
          paramInt4 = paramInt2 + 1;
          paramInt1 = n;
        }
        else
        {
          paramInt4 = j + i6;
          if ((paramInt4 > i3) && (paramInt4 - localMarginLayoutParams.rightMargin <= i3))
          {
            paramInt3 = i6 - localMarginLayoutParams.rightMargin;
            break label765;
          }
          paramInt3 = i6;
          if (paramInt4 <= i3) {
            break label765;
          }
          paramInt3 = k + m;
          paramInt4 = paramInt2 + 1;
        }
        i7 = 0;
        i8 = 0;
        i9 = i6;
        break label784;
        label765:
        i9 = paramInt3;
        i8 = m;
        paramInt4 = paramInt2;
        paramInt3 = k;
        i7 = j;
        label784:
        m = i2 + i7 + localMarginLayoutParams.leftMargin;
        j = i1 + paramInt3 + localMarginLayoutParams.topMargin;
        if (((localMarginLayoutParams instanceof FrameLayout.LayoutParams)) && (paramInt4 < this.jdField_a_of_type_ArrayOfInt.length))
        {
          k = ((FrameLayout.LayoutParams)localMarginLayoutParams).gravity;
          paramInt2 = k;
          if (k == -1) {
            paramInt2 = 16;
          }
          paramInt2 &= 0x70;
          if (paramInt2 != 16)
          {
            if (paramInt2 != 80)
            {
              paramInt2 = j;
              break label911;
            }
            paramInt2 = this.jdField_a_of_type_ArrayOfInt[paramInt4] - i11;
          }
          else
          {
            paramInt2 = (this.jdField_a_of_type_ArrayOfInt[paramInt4] - i11) / 2;
          }
          paramInt2 = j + paramInt2;
        }
        else
        {
          paramInt2 = j;
        }
        label911:
        ((View)localObject).layout(m, paramInt2, i12 + m, paramInt2 + i13);
        if (this.jdField_a_of_type_Int == 1) {
          paramInt2 = i7 + paramInt1;
        } else {
          paramInt2 = i7 + i9;
        }
        m = Math.max(i8, i11);
      }
      else
      {
        paramInt4 = paramInt2;
        paramInt3 = k;
        paramInt2 = j;
      }
      i5 += 1;
      j = paramInt2;
      k = paramInt3;
      paramInt2 = paramInt4;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i8 = getChildCount();
    int i9 = View.MeasureSpec.getSize(paramInt1) - getPaddingLeft() - getPaddingRight();
    int i10 = i9 / 2;
    int i5 = 0;
    int i2 = 0;
    int i1 = 0;
    int n = 0;
    for (int m = 0; i5 < i8; m = j)
    {
      View localView = getChildAt(i5);
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)localView.getLayoutParams();
      int i3 = i2;
      k = i1;
      int i4 = n;
      j = m;
      if (localView.getVisibility() != 8)
      {
        measureChildWithMargins(localView, paramInt1, 0, paramInt2, 0);
        j = localView.getMeasuredWidth();
        int i11 = localView.getMeasuredHeight();
        k = j + localMarginLayoutParams.leftMargin + localMarginLayoutParams.rightMargin;
        int i12 = localMarginLayoutParams.topMargin;
        int i13 = localMarginLayoutParams.bottomMargin;
        if (this.jdField_a_of_type_Int == 1)
        {
          if (i1 == 0) {
            k = Math.max(i10, k);
          } else {
            k = Math.max(i10, k + this.i);
          }
          j = k;
          i3 = i2;
          i7 = i1;
          i4 = n;
          i6 = m;
          if (i1 + k <= i9) {
            break label334;
          }
          i3 = Math.max(i2, i1);
          j = k;
        }
        else
        {
          int i14 = i1 + k;
          if ((i14 > i9) && (i14 - localMarginLayoutParams.rightMargin <= i9))
          {
            j = k - localMarginLayoutParams.rightMargin;
            i3 = i2;
            i7 = i1;
            i4 = n;
            i6 = m;
            break label334;
          }
          j = k;
          i3 = i2;
          i7 = i1;
          i4 = n;
          i6 = m;
          if (i14 <= i9) {
            break label334;
          }
          i3 = Math.max(i2, i1);
          j = k;
        }
        i4 = n + m;
        int i7 = 0;
        int i6 = 0;
        label334:
        k = i7 + j;
        j = Math.max(i6, i11 + i12 + i13);
      }
      i5 += 1;
      i2 = i3;
      i1 = k;
      n = i4;
    }
    int j = Math.max(i2, i1);
    int k = getPaddingLeft();
    i1 = getPaddingRight();
    m = Math.max(n + m + (getPaddingTop() + getPaddingBottom()), getSuggestedMinimumHeight());
    setMeasuredDimension(resolveSize(Math.max(j + (k + i1), getSuggestedMinimumWidth()), paramInt1), resolveSize(m, paramInt2));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.HorizontalLabelLayout
 * JD-Core Version:    0.7.0.1
 */