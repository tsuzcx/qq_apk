package com.tencent.mtt.supportui.views.viewpager;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;

public class ViewPager$LayoutParams
  extends ViewGroup.LayoutParams
{
  int childIndex;
  public int gravity;
  public boolean isDecor;
  boolean needsMeasure;
  int position;
  public float sizeFactor = 0.0F;
  boolean takeHeightspace;
  
  public ViewPager$LayoutParams()
  {
    super(-1, -1);
  }
  
  public ViewPager$LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, ViewPager.LAYOUT_ATTRS);
    this.gravity = paramContext.getInteger(0, 48);
    paramContext.recycle();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.supportui.views.viewpager.ViewPager.LayoutParams
 * JD-Core Version:    0.7.0.1
 */