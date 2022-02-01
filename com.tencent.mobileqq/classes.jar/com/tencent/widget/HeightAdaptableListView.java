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
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int j = this.b;
    int i;
    if (j != 1)
    {
      i = paramInt2;
      if (j != 2) {}
    }
    else
    {
      int k = View.MeasureSpec.getMode(paramInt2);
      j = View.MeasureSpec.getSize(paramInt2);
      if (this.mAdapter == null) {
        i = 0;
      } else {
        i = this.mAdapter.getCount();
      }
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
          i = View.MeasureSpec.makeMeasureSpec(Math.max(j, localView.getMeasuredHeight() * paramInt2), -2147483648);
        }
      }
    }
    super.onMeasure(paramInt1, i);
  }
  
  public void setHeightAdaptMode(int paramInt1, int paramInt2)
  {
    if ((paramInt1 <= 2) && (paramInt1 >= 0))
    {
      if ((paramInt1 == 1) && (paramInt2 < 0)) {
        return;
      }
      this.b = paramInt1;
      this.a = paramInt2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.HeightAdaptableListView
 * JD-Core Version:    0.7.0.1
 */