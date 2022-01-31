package com.tencent.mobileqq.mini.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View.MeasureSpec;
import android.widget.ScrollView;

public class MiniAppScrollView
  extends ScrollView
{
  public MiniAppScrollView(Context paramContext)
  {
    super(paramContext);
    setHorizontalScrollBarEnabled(false);
    setVerticalScrollBarEnabled(false);
    setOverScrollMode(2);
  }
  
  public MiniAppScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setHorizontalScrollBarEnabled(false);
    setVerticalScrollBarEnabled(false);
    setOverScrollMode(2);
  }
  
  public MiniAppScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setHorizontalScrollBarEnabled(false);
    setVerticalScrollBarEnabled(false);
    setOverScrollMode(2);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(getResources().getDisplayMetrics().heightPixels / 2, -2147483648));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.MiniAppScrollView
 * JD-Core Version:    0.7.0.1
 */