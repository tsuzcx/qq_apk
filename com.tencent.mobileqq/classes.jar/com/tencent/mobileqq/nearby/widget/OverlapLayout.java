package com.tencent.mobileqq.nearby.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.mobileqq.R.styleable;
import com.tencent.mobileqq.activity.aio.AIOUtils;

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
    this.a = paramAttributeSet.getDimension(1, AIOUtils.b(4.0F, paramContext.getResources()));
    this.b = paramAttributeSet.getDimension(0, AIOUtils.b(15.0F, paramContext.getResources()));
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
    int k = getPaddingLeft();
    int i = getPaddingTop();
    int i2 = getChildCount();
    paramInt4 = 0;
    int j = 0;
    int m = 0;
    while (m < i2)
    {
      View localView = getChildAt(m);
      int n;
      if (localView.getVisibility() == 8)
      {
        paramInt2 = i;
        n = paramInt4;
      }
      else
      {
        ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)localView.getLayoutParams();
        int i3 = localMarginLayoutParams.leftMargin + localView.getMeasuredWidth() + localMarginLayoutParams.rightMargin;
        int i1 = k;
        paramInt2 = i;
        n = paramInt4;
        if (k + i3 + getPaddingRight() > paramInt3 - paramInt1)
        {
          i1 = getPaddingLeft();
          paramInt2 = (int)(i + (paramInt4 + this.a));
          n = 0;
          j = 0;
        }
        localView.layout(localMarginLayoutParams.leftMargin + i1, localMarginLayoutParams.topMargin + paramInt2, localMarginLayoutParams.leftMargin + i1 + localView.getMeasuredWidth(), localMarginLayoutParams.topMargin + paramInt2 + localView.getMeasuredHeight());
        i = i1 + i3;
        k = localMarginLayoutParams.topMargin;
        i1 = localView.getMeasuredHeight();
        i3 = localMarginLayoutParams.bottomMargin;
        paramInt4 = i;
        if (j != i2 - 1) {
          paramInt4 = (int)(i - this.b);
        }
        n = Math.max(n, k + i1 + i3);
        j += 1;
        k = paramInt4;
      }
      m += 1;
      i = paramInt2;
      paramInt4 = n;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    int i8 = View.MeasureSpec.getMode(paramInt1);
    int i5 = View.MeasureSpec.getSize(paramInt1);
    int i7 = View.MeasureSpec.getMode(paramInt2);
    int k = View.MeasureSpec.getSize(paramInt2);
    int i9 = getChildCount();
    int i2 = 0;
    int i = 0;
    int i3 = 0;
    int j = 0;
    int i4 = 0;
    int i1;
    for (int m = 0; i3 < i9; m = i1)
    {
      View localView = getChildAt(i3);
      int n;
      if (localView.getVisibility() == 8)
      {
        i1 = i;
        n = j;
        if (i3 == i9 - 1)
        {
          i1 = i + i2;
          n = Math.max(j, i4);
        }
        i = i1;
        j = n;
        i1 = m;
      }
      else
      {
        measureChildWithMargins(localView, paramInt1, 0, paramInt2, 0);
        ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)localView.getLayoutParams();
        n = localView.getMeasuredWidth() + localMarginLayoutParams.leftMargin + localMarginLayoutParams.rightMargin;
        i1 = localView.getMeasuredHeight() + localMarginLayoutParams.topMargin + localMarginLayoutParams.bottomMargin;
        int i6 = i4 + n;
        float f2 = i6;
        float f1;
        if (m > 0) {
          f1 = this.b;
        } else {
          f1 = 0.0F;
        }
        if (f2 - f1 > i5 - getPaddingLeft() - getPaddingRight())
        {
          m = Math.max(j, i4);
          i2 = (int)(i + (i2 + this.a));
          i4 = 0;
          j = n;
          i = i1;
          i1 = i2;
          i2 = m;
        }
        else
        {
          n = i6;
          if (m > 0) {
            n = (int)(f2 - this.b);
          }
          i6 = Math.max(i2, i1);
          i4 = m;
          i2 = j;
          i1 = i;
          i = i6;
          j = n;
        }
        m = i1;
        n = i2;
        if (i3 == i9 - 1)
        {
          n = Math.max(j, i2);
          m = i1 + i;
        }
        i1 = i4 + 1;
        i2 = i;
        i4 = j;
        j = n;
        i = m;
      }
      i3 += 1;
    }
    if (i8 == 1073741824) {
      paramInt1 = i5;
    } else {
      paramInt1 = j + getPaddingLeft() + getPaddingRight();
    }
    if (i7 != 1073741824) {
      k = i + getPaddingTop() + getPaddingBottom();
    }
    setMeasuredDimension(paramInt1, k);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.widget.OverlapLayout
 * JD-Core Version:    0.7.0.1
 */