package com.tencent.open.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View.MeasureSpec;
import android.widget.ScrollView;
import bcwh;

public class MaxHeightScrollView
  extends ScrollView
{
  private int a = 2147483647;
  
  public MaxHeightScrollView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public MaxHeightScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MaxHeightScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private int a(Context paramContext)
  {
    return paramContext.getResources().getDisplayMetrics().heightPixels;
  }
  
  private void a()
  {
    this.a = (a(getContext()) - bcwh.a(getContext(), 56.0F));
  }
  
  public int a()
  {
    return this.a;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int j = View.MeasureSpec.getMode(paramInt2);
    int i = paramInt2;
    if (View.MeasureSpec.getSize(paramInt2) > this.a)
    {
      i = paramInt2;
      if (j != 0) {
        i = View.MeasureSpec.makeMeasureSpec(this.a, j);
      }
    }
    super.onMeasure(paramInt1, i);
  }
  
  public void setMaxHeight(int paramInt)
  {
    this.a = paramInt;
    requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.widget.MaxHeightScrollView
 * JD-Core Version:    0.7.0.1
 */