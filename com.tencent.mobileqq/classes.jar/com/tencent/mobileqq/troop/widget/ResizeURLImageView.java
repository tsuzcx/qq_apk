package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import bdoo;
import com.tencent.image.URLImageView;

public class ResizeURLImageView
  extends URLImageView
{
  public ResizeURLImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (getContext().getResources().getConfiguration().orientation == 1) {}
    for (paramInt1 = bdoo.a() - getPaddingLeft() - getPaddingRight();; paramInt1 = bdoo.b() - getPaddingTop() - getPaddingBottom())
    {
      paramInt1 = View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824);
      super.onMeasure(paramInt1, paramInt1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.ResizeURLImageView
 * JD-Core Version:    0.7.0.1
 */