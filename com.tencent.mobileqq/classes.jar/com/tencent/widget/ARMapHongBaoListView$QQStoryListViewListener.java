package com.tencent.widget;

import android.view.MotionEvent;

public abstract interface ARMapHongBaoListView$QQStoryListViewListener
{
  public abstract int getMode();
  
  public abstract int getSpringbackOffset(ARMapHongBaoListView paramARMapHongBaoListView);
  
  public abstract void onFlingScrollHeader(int paramInt1, int paramInt2);
  
  public abstract void onTouchMoving(ARMapHongBaoListView paramARMapHongBaoListView, boolean paramBoolean, MotionEvent paramMotionEvent);
  
  public abstract int onViewCompleteAfterRefresh(ARMapHongBaoListView paramARMapHongBaoListView);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.ARMapHongBaoListView.QQStoryListViewListener
 * JD-Core Version:    0.7.0.1
 */