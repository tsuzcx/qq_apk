package com.tencent.widget;

import android.view.View;

public abstract interface ReadInJoyOverScrollViewListener
  extends OverScrollViewListener
{
  public abstract void onNotCompleteVisable(int paramInt1, View paramView, ListView paramListView, int paramInt2);
  
  public abstract void onScrollView(View paramView, ListView paramListView, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.ReadInJoyOverScrollViewListener
 * JD-Core Version:    0.7.0.1
 */