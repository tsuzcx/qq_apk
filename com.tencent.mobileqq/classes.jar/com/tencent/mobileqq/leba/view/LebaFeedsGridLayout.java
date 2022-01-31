package com.tencent.mobileqq.leba.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;

public class LebaFeedsGridLayout
  extends ViewGroup
{
  private int a;
  private int b;
  private int c = 1;
  
  public LebaFeedsGridLayout(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public LebaFeedsGridLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public LebaFeedsGridLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a() {}
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof LebaFeedsGridLayout.LayoutParams;
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new LebaFeedsGridLayout.LayoutParams(-2, -2);
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new LebaFeedsGridLayout.LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return new LebaFeedsGridLayout.LayoutParams(paramLayoutParams);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt2 = getChildCount();
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      View localView = getChildAt(paramInt1);
      LebaFeedsGridLayout.LayoutParams localLayoutParams = (LebaFeedsGridLayout.LayoutParams)localView.getLayoutParams();
      localView.layout(localLayoutParams.a, localLayoutParams.b, localLayoutParams.a + localView.getMeasuredWidth(), localLayoutParams.b + localView.getMeasuredHeight());
      paramInt1 += 1;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i7 = View.MeasureSpec.getMode(paramInt1);
    int i6 = View.MeasureSpec.getMode(paramInt2);
    int i3 = View.MeasureSpec.getSize(paramInt1);
    int i2 = View.MeasureSpec.getSize(paramInt2);
    measureChildren(paramInt1, paramInt2);
    paramInt1 = 0;
    int i10 = getPaddingLeft();
    int i11 = getPaddingRight();
    int i8 = getPaddingTop();
    int i9 = getPaddingBottom();
    int i12 = getChildCount();
    paramInt2 = 0;
    int i = 0;
    int n = 1;
    int k = 0;
    int j = 0;
    int m = 0;
    if (m < i12)
    {
      Object localObject = getChildAt(m);
      int i4 = ((View)localObject).getMeasuredWidth();
      int i5 = ((View)localObject).getMeasuredHeight();
      localObject = (LebaFeedsGridLayout.LayoutParams)((View)localObject).getLayoutParams();
      int i1;
      if (n != 0)
      {
        i1 = 0;
        label125:
        if ((i1 + (i10 + k) + i4 + i11 > i3) && (i >= this.c)) {
          break label283;
        }
        if (n == 0) {
          break label274;
        }
        n = 0;
        label160:
        k = n + k;
        ((LebaFeedsGridLayout.LayoutParams)localObject).a = (i10 + k);
        ((LebaFeedsGridLayout.LayoutParams)localObject).b = (i8 + paramInt1);
        i1 = i4 + k;
        k = Math.max(j, i5);
        n = Math.max(i1, paramInt2);
        j = i + 1;
        i = i1;
        paramInt2 = paramInt1;
        paramInt1 = k;
        k = n;
      }
      for (;;)
      {
        m += 1;
        n = k;
        i1 = j;
        i4 = 0;
        k = i;
        j = paramInt1;
        paramInt1 = paramInt2;
        paramInt2 = n;
        i = i1;
        n = i4;
        break;
        i1 = this.a;
        break label125;
        label274:
        n = this.a;
        break label160;
        label283:
        ((LebaFeedsGridLayout.LayoutParams)localObject).a = i10;
        paramInt1 = paramInt1 + j + this.b;
        ((LebaFeedsGridLayout.LayoutParams)localObject).b = (i8 + paramInt1);
        k = Math.max(i4, paramInt2);
        j = 1;
        paramInt2 = paramInt1;
        paramInt1 = i5;
        i = i4;
      }
    }
    paramInt2 = i10 + paramInt2 + i11;
    i = i8 + paramInt1 + j + i9;
    paramInt1 = paramInt2;
    if (i7 == 1073741824) {
      paramInt1 = i3;
    }
    paramInt2 = i;
    if (i6 == 1073741824) {
      paramInt2 = i2;
    }
    setMeasuredDimension(paramInt1, paramInt2);
  }
  
  public void setItemMargin(int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
  }
  
  public void setRowItemCount(int paramInt)
  {
    this.c = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.leba.view.LebaFeedsGridLayout
 * JD-Core Version:    0.7.0.1
 */