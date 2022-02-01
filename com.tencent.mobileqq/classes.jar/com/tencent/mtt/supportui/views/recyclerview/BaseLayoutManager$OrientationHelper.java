package com.tencent.mtt.supportui.views.recyclerview;

import android.view.View;

public abstract interface BaseLayoutManager$OrientationHelper
{
  public abstract int getDecoratedEnd(View paramView);
  
  public abstract int getDecoratedMeasurement(View paramView);
  
  public abstract int getDecoratedMeasurementInOther(View paramView);
  
  public abstract int getDecoratedStart(View paramView);
  
  public abstract int getEndAfterPadding();
  
  public abstract int getStartAfterPadding();
  
  public abstract int getTotalSpace();
  
  public abstract void offsetChildren(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.supportui.views.recyclerview.BaseLayoutManager.OrientationHelper
 * JD-Core Version:    0.7.0.1
 */