package com.tencent.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import com.tencent.mobileqq.R.styleable;

public class ScaleFitXYFrameLayout
  extends FrameLayout
{
  private Context a;
  private float b = 1.0F;
  private float c = 1.0F;
  
  public ScaleFitXYFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.a = paramContext;
    paramContext = this.a.obtainStyledAttributes(paramAttributeSet, R.styleable.ScaleFitXYFrameLayout);
    this.b = paramContext.getFloat(1, 1.0F);
    this.c = paramContext.getFloat(0, 1.0F);
    paramContext.recycle();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int j = View.MeasureSpec.getMode(paramInt1);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    int i = View.MeasureSpec.getMode(paramInt2);
    View.MeasureSpec.getSize(paramInt2);
    if (this.b == 1.0F)
    {
      if (j != 0)
      {
        paramInt2 = (int)(paramInt1 * this.c);
        setMeasuredDimension(paramInt1, paramInt2);
        paramInt1 = View.MeasureSpec.makeMeasureSpec(paramInt1, j);
        paramInt2 = View.MeasureSpec.makeMeasureSpec(paramInt2, i);
      }
      else
      {
        setMeasuredDimension(0, 0);
        paramInt1 = View.MeasureSpec.makeMeasureSpec(0, j);
        paramInt2 = View.MeasureSpec.makeMeasureSpec(0, i);
      }
      measureChildren(paramInt1, paramInt2);
      return;
    }
    float f = this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.ScaleFitXYFrameLayout
 * JD-Core Version:    0.7.0.1
 */