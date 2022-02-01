package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.utils.ViewUtils;

public class ResizeURLImageView
  extends URLImageView
{
  public ResizeURLImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (getContext().getResources().getConfiguration().orientation == 1)
    {
      paramInt1 = ViewUtils.getScreenWidth() - getPaddingLeft();
      paramInt2 = getPaddingRight();
    }
    else
    {
      paramInt1 = ViewUtils.getScreenHeight() - getPaddingTop();
      paramInt2 = getPaddingBottom();
    }
    paramInt1 = View.MeasureSpec.makeMeasureSpec(paramInt1 - paramInt2, 1073741824);
    super.onMeasure(paramInt1, paramInt1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.ResizeURLImageView
 * JD-Core Version:    0.7.0.1
 */