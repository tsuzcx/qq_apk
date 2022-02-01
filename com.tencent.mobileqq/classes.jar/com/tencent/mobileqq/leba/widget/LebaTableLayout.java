package com.tencent.mobileqq.leba.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;

public class LebaTableLayout
  extends ViewGroup
{
  public int a;
  public int b;
  public int c;
  public int d;
  public int e;
  public int f;
  public int g;
  public int h = 3;
  private int i;
  
  public LebaTableLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public LebaTableLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public LebaTableLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int j = getChildCount();
    if ((j <= 0) || (this.h == 0)) {}
    for (;;)
    {
      return;
      paramInt1 = this.f;
      paramInt3 = this.d;
      paramInt2 = 0;
      while (paramInt2 < j)
      {
        View localView = getChildAt(paramInt2);
        paramInt4 = this.i;
        int k = this.i;
        localView.layout(paramInt1, paramInt3, paramInt1 + paramInt4, paramInt3 + k);
        paramInt1 += this.b + paramInt4;
        paramInt4 = paramInt3;
        if ((paramInt2 + 1) % this.h == 0)
        {
          paramInt1 = this.f;
          paramInt4 = paramInt3 + (this.c + k);
        }
        paramInt2 += 1;
        paramInt3 = paramInt4;
      }
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    int j = 0;
    super.onMeasure(paramInt1, paramInt2);
    paramInt2 = getChildCount();
    if ((paramInt2 <= 0) || (this.h == 0))
    {
      setMeasuredDimension(0, 0);
      return;
    }
    int k = View.MeasureSpec.getSize(paramInt1);
    this.i = ((k - this.f - this.g - this.b * (this.h - 1)) / this.h);
    int m = this.i;
    paramInt1 = j;
    while (paramInt1 < paramInt2)
    {
      measureChild(getChildAt(paramInt1), View.MeasureSpec.makeMeasureSpec(this.i, 1073741824), View.MeasureSpec.makeMeasureSpec(m, 1073741824));
      paramInt1 += 1;
    }
    if (paramInt2 % this.h == 0) {}
    for (paramInt1 = paramInt2 / this.h;; paramInt1 = paramInt2 / this.h + 1)
    {
      j = this.c;
      setMeasuredDimension(k, paramInt1 * m + (paramInt2 - 1) / this.h * j + this.d + this.e);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.widget.LebaTableLayout
 * JD-Core Version:    0.7.0.1
 */