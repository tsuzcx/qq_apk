package com.tencent.mobileqq.multiaio.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;

public class MultiAIOBaseViewPager$LayoutParams
  extends ViewGroup.LayoutParams
{
  public boolean a;
  public int b;
  float c = 0.0F;
  boolean d;
  int e;
  int f;
  
  public MultiAIOBaseViewPager$LayoutParams()
  {
    super(-1, -1);
  }
  
  public MultiAIOBaseViewPager$LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, MultiAIOBaseViewPager.a);
    this.b = paramContext.getInteger(0, 48);
    paramContext.recycle();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.multiaio.widget.MultiAIOBaseViewPager.LayoutParams
 * JD-Core Version:    0.7.0.1
 */