package com.tencent.mobileqq.wink.pick.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.RelativeLayout;

public class WinkSquareRelativeLayout
  extends RelativeLayout
{
  public WinkSquareRelativeLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public WinkSquareRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public WinkSquareRelativeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    paramInt1 = Math.min(View.MeasureSpec.getSize(paramInt1), View.MeasureSpec.getSize(paramInt2));
    setMeasuredDimension(paramInt1, paramInt1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.pick.view.WinkSquareRelativeLayout
 * JD-Core Version:    0.7.0.1
 */