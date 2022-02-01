package com.tencent.widget;

import android.content.Context;
import android.graphics.PointF;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearSmoothScroller;
import android.util.DisplayMetrics;

class PhotoGridView$1
  extends LinearSmoothScroller
{
  PhotoGridView$1(PhotoGridView paramPhotoGridView, Context paramContext)
  {
    super(paramContext);
  }
  
  public float calculateSpeedPerPixel(DisplayMetrics paramDisplayMetrics)
  {
    return 500.0F / paramDisplayMetrics.densityDpi;
  }
  
  public PointF computeScrollVectorForPosition(int paramInt)
  {
    if ((this.this$0.gridLayoutManager == null) || (this.this$0.gridLayoutManager.getChildCount() == 0) || (this.this$0.gridLayoutManager.getChildAt(0) == null)) {
      return null;
    }
    if (paramInt < this.this$0.gridLayoutManager.getPosition(this.this$0.gridLayoutManager.getChildAt(0))) {}
    for (paramInt = -1;; paramInt = 1) {
      return new PointF(0.0F, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.PhotoGridView.1
 * JD-Core Version:    0.7.0.1
 */