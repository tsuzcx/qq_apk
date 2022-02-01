package com.tencent.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.ListAdapter;

public class HeightAdaptableListView
  extends ListView
{
  private int a = 0;
  private int b = 0;
  
  public HeightAdaptableListView(Context paramContext)
  {
    super(paramContext);
  }
  
  public HeightAdaptableListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public HeightAdaptableListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  @TargetApi(11)
  public void onMeasure(int paramInt1, int paramInt2)
  {
    int k;
    int j;
    if (this.b != 1)
    {
      i = paramInt2;
      if (this.b != 2) {}
    }
    else
    {
      k = View.MeasureSpec.getMode(paramInt2);
      j = View.MeasureSpec.getSize(paramInt2);
      if (this.mAdapter != null) {
        break label129;
      }
    }
    label129:
    for (int i = 0;; i = this.mAdapter.getCount())
    {
      this.mItemCount = i;
      i = paramInt2;
      if (this.mItemCount > 0)
      {
        i = paramInt2;
        if (k == 0)
        {
          paramInt2 = Math.min(this.mItemCount, this.a);
          if (this.b == 2) {
            paramInt2 = this.mItemCount;
          }
          View localView = obtainView(0, this.mIsScrap);
          measureScrapChild(localView, 0, paramInt1);
          i = View.MeasureSpec.makeMeasureSpec(Math.max(j, paramInt2 * localView.getMeasuredHeight()), -2147483648);
        }
      }
      super.onMeasure(paramInt1, i);
      return;
    }
  }
  
  public void setHeightAdaptMode(int paramInt1, int paramInt2)
  {
    if ((paramInt1 > 2) || (paramInt1 < 0) || ((paramInt1 == 1) && (paramInt2 < 0))) {
      return;
    }
    this.b = paramInt1;
    this.a = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.widget.HeightAdaptableListView
 * JD-Core Version:    0.7.0.1
 */