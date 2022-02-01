package com.tencent.widget;

import android.view.View;

public abstract interface OverScrollViewListener
{
  public static final int OVERSCROLL_POSITION_BOTTOM = 1;
  public static final int OVERSCROLL_POSITION_TOP = 0;
  
  public abstract void onNotCompleteVisable(int paramInt, View paramView, ListView paramListView);
  
  public abstract void onViewCompleteVisable(int paramInt, View paramView, ListView paramListView);
  
  public abstract boolean onViewCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView);
  
  public abstract void onViewNotCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.widget.OverScrollViewListener
 * JD-Core Version:    0.7.0.1
 */