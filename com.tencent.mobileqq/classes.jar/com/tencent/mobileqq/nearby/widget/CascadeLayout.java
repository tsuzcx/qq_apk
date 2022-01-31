package com.tencent.mobileqq.nearby.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.R.styleable;

public class CascadeLayout
  extends ViewGroup
{
  private int a;
  private int b;
  private int c;
  
  public CascadeLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public CascadeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CascadeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.CascadeLayout);
    this.a = paramContext.getDimensionPixelSize(0, 0);
    this.b = paramContext.getDimensionPixelSize(1, 0);
    paramContext.recycle();
    this.c = 0;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt2 = 0;
    paramInt1 = 0;
    paramInt3 = getChildCount();
    View localView;
    if (this.c == 0) {
      while (paramInt1 < paramInt3)
      {
        localView = getChildAt(paramInt1);
        paramInt2 = getPaddingLeft() + this.a * paramInt1;
        paramInt4 = getPaddingTop() + this.b * paramInt1;
        localView.layout(paramInt2, paramInt4, localView.getMeasuredWidth() + paramInt2, localView.getMeasuredHeight() + paramInt4);
        paramInt1 += 1;
      }
    }
    if (this.c == 1)
    {
      paramInt1 = paramInt2;
      while (paramInt1 < paramInt3)
      {
        localView = getChildAt(paramInt1);
        paramInt2 = getMeasuredWidth() - localView.getMeasuredWidth() - this.a * paramInt1 - getPaddingRight();
        paramInt4 = getPaddingTop() + this.b * paramInt1;
        localView.layout(paramInt2, paramInt4, localView.getMeasuredWidth() + paramInt2, localView.getMeasuredHeight() + paramInt4);
        paramInt1 += 1;
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = 0;
    int m = getChildCount();
    int j = 0;
    int k = 0;
    while (i < m)
    {
      View localView = getChildAt(i);
      measureChild(localView, paramInt1, paramInt2);
      j = getPaddingLeft();
      k = this.a;
      n = localView.getMeasuredWidth();
      k = getPaddingRight() + (n + (j + k * i));
      j = this.b;
      i += 1;
    }
    i = getPaddingRight();
    m = getChildAt(getChildCount() - 1).getMeasuredHeight();
    int n = getPaddingBottom();
    setMeasuredDimension(resolveSize(i + k, paramInt1), resolveSize(j + (m + n), paramInt2));
  }
  
  public void setHorizontalSpacing(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void setOrder(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void setVerticalSpacing(int paramInt)
  {
    this.b = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.widget.CascadeLayout
 * JD-Core Version:    0.7.0.1
 */