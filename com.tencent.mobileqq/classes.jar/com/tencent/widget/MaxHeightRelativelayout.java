package com.tencent.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.RelativeLayout;
import com.tencent.qphone.base.util.QLog;

public class MaxHeightRelativelayout
  extends RelativeLayout
{
  private int a = 2147483647;
  
  public MaxHeightRelativelayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public MaxHeightRelativelayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  @TargetApi(11)
  public MaxHeightRelativelayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
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
    try
    {
      super.onMeasure(paramInt1, i);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("MaxHeightRelativelayout", 1, "-->MaxHeightRelativelayout.onMeasure : ", localException);
    }
  }
  
  public void setMaxHeight(int paramInt)
  {
    this.a = paramInt;
    if (this.a < getMeasuredHeight()) {
      requestLayout();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.MaxHeightRelativelayout
 * JD-Core Version:    0.7.0.1
 */