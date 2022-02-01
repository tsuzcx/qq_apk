package com.tencent.open.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View.MeasureSpec;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.util.DisplayUtil;

public class HalfScreenRelativelayout
  extends RelativeLayout
{
  private int a = 2147483647;
  
  public HalfScreenRelativelayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public HalfScreenRelativelayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  @TargetApi(11)
  public HalfScreenRelativelayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
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
    this.a = ((int)(a(getContext()) / 2.0F) + DisplayUtil.a(getContext(), 56.0F));
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int j = View.MeasureSpec.getMode(paramInt2);
    int k = View.MeasureSpec.getSize(paramInt2);
    int m = this.a;
    int i = paramInt2;
    if (k > m)
    {
      i = paramInt2;
      if (j != 0) {
        i = View.MeasureSpec.makeMeasureSpec(m, j);
      }
    }
    super.onMeasure(paramInt1, i);
  }
  
  public void setMaxHeight(int paramInt)
  {
    this.a = paramInt;
    if (this.a < getMeasuredHeight()) {
      requestLayout();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.widget.HalfScreenRelativelayout
 * JD-Core Version:    0.7.0.1
 */