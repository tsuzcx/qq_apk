package com.tencent.mobileqq.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;

public class FixRatioPAHighLightImageView
  extends PAHighLightImageView
{
  private float c;
  
  public FixRatioPAHighLightImageView(Context paramContext)
  {
    super(paramContext);
  }
  
  public FixRatioPAHighLightImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public FixRatioPAHighLightImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.c == 0.0F)
    {
      super.onMeasure(paramInt1, paramInt2);
      return;
    }
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec((int)(View.MeasureSpec.getSize(paramInt1) / this.c), 1073741824));
  }
  
  public void setRatio(float paramFloat)
  {
    this.c = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.FixRatioPAHighLightImageView
 * JD-Core Version:    0.7.0.1
 */