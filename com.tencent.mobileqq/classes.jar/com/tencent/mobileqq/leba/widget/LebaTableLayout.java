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
  public int g = 3;
  private int h;
  
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
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = getChildCount();
    if (i > 0)
    {
      if (this.g == 0) {
        return;
      }
      paramInt1 = this.e;
      paramInt2 = this.c;
      paramInt3 = 0;
      while (paramInt3 < i)
      {
        View localView = getChildAt(paramInt3);
        int j = this.h;
        localView.layout(paramInt1, paramInt2, paramInt1 + j, paramInt2 + j);
        paramInt1 += this.a + j;
        paramInt4 = paramInt3 + 1;
        paramInt3 = paramInt4;
        if (paramInt4 % this.g == 0)
        {
          paramInt1 = this.e;
          paramInt2 += j + this.b;
          paramInt3 = paramInt4;
        }
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    int i = getChildCount();
    paramInt2 = 0;
    if ((i > 0) && (this.g != 0))
    {
      int j = View.MeasureSpec.getSize(paramInt1);
      paramInt1 = this.e;
      int k = this.f;
      int m = this.a;
      int n = this.g;
      this.h = ((j - paramInt1 - k - m * (n - 1)) / n);
      k = this.h;
      paramInt1 = paramInt2;
      while (paramInt1 < i)
      {
        measureChild(getChildAt(paramInt1), View.MeasureSpec.makeMeasureSpec(this.h, 1073741824), View.MeasureSpec.makeMeasureSpec(k, 1073741824));
        paramInt1 += 1;
      }
      paramInt1 = this.g;
      if (i % paramInt1 == 0) {
        paramInt1 = i / paramInt1;
      } else {
        paramInt1 = i / paramInt1 + 1;
      }
      setMeasuredDimension(j, k * paramInt1 + this.b * ((i - 1) / this.g) + this.c + this.d);
      return;
    }
    setMeasuredDimension(0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.widget.LebaTableLayout
 * JD-Core Version:    0.7.0.1
 */