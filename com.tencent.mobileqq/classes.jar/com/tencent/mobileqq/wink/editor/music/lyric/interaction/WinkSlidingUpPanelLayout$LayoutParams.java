package com.tencent.mobileqq.wink.editor.music.lyric.interaction;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;

public class WinkSlidingUpPanelLayout$LayoutParams
  extends ViewGroup.MarginLayoutParams
{
  private static final int[] b = { 16843137 };
  public float a = 0.0F;
  
  public WinkSlidingUpPanelLayout$LayoutParams()
  {
    super(-1, -1);
  }
  
  public WinkSlidingUpPanelLayout$LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, b);
    if (paramContext != null)
    {
      this.a = paramContext.getFloat(0, 0.0F);
      paramContext.recycle();
    }
  }
  
  public WinkSlidingUpPanelLayout$LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    super(paramLayoutParams);
  }
  
  public WinkSlidingUpPanelLayout$LayoutParams(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
  {
    super(paramMarginLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.music.lyric.interaction.WinkSlidingUpPanelLayout.LayoutParams
 * JD-Core Version:    0.7.0.1
 */