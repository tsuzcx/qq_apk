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
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int j = getChildCount();
    if (j > 0)
    {
      if (this.h == 0) {
        return;
      }
      paramInt1 = this.f;
      paramInt2 = this.d;
      paramInt3 = 0;
      while (paramInt3 < j)
      {
        View localView = getChildAt(paramInt3);
        int k = this.i;
        localView.layout(paramInt1, paramInt2, paramInt1 + k, paramInt2 + k);
        paramInt1 += this.b + k;
        paramInt4 = paramInt3 + 1;
        paramInt3 = paramInt4;
        if (paramInt4 % this.h == 0)
        {
          paramInt1 = this.f;
          paramInt2 += k + this.c;
          paramInt3 = paramInt4;
        }
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    int j = getChildCount();
    paramInt2 = 0;
    if ((j > 0) && (this.h != 0))
    {
      int k = View.MeasureSpec.getSize(paramInt1);
      paramInt1 = this.f;
      int m = this.g;
      int n = this.b;
      int i1 = this.h;
      this.i = ((k - paramInt1 - m - n * (i1 - 1)) / i1);
      m = this.i;
      paramInt1 = paramInt2;
      while (paramInt1 < j)
      {
        measureChild(getChildAt(paramInt1), View.MeasureSpec.makeMeasureSpec(this.i, 1073741824), View.MeasureSpec.makeMeasureSpec(m, 1073741824));
        paramInt1 += 1;
      }
      paramInt1 = this.h;
      if (j % paramInt1 == 0) {
        paramInt1 = j / paramInt1;
      } else {
        paramInt1 = j / paramInt1 + 1;
      }
      setMeasuredDimension(k, m * paramInt1 + this.c * ((j - 1) / this.h) + this.d + this.e);
      return;
    }
    setMeasuredDimension(0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.leba.widget.LebaTableLayout
 * JD-Core Version:    0.7.0.1
 */