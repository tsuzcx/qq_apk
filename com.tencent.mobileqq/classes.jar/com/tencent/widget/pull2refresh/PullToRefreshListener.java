package com.tencent.widget.pull2refresh;

import android.view.View;

public abstract interface PullToRefreshListener
{
  public abstract void onNotCompleteVisable(View paramView, int paramInt);
  
  public abstract void onRefreshCompleted(View paramView, boolean paramBoolean);
  
  public abstract void onViewCompleteVisable(View paramView);
  
  public abstract boolean onViewCompleteVisableAndReleased(View paramView);
  
  public abstract void onViewNotCompleteVisableAndReleased(View paramView);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.pull2refresh.PullToRefreshListener
 * JD-Core Version:    0.7.0.1
 */