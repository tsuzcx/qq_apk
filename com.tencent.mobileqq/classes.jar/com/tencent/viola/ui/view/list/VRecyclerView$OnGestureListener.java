package com.tencent.viola.ui.view.list;

import android.view.MotionEvent;

public abstract interface VRecyclerView$OnGestureListener
{
  public abstract void onDispatchTouchEvent(int paramInt1, MotionEvent paramMotionEvent, int paramInt2);
  
  public abstract void onLoadMore(VRecyclerView paramVRecyclerView, int paramInt1, int paramInt2);
  
  public abstract void onScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  
  public abstract void onScroll(VRecyclerView paramVRecyclerView, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract void onScrollEnd(VRecyclerView paramVRecyclerView, int paramInt1, int paramInt2);
  
  public abstract void onScrollStateChanged(VRecyclerView paramVRecyclerView, int paramInt1, int paramInt2);
  
  public abstract void onStickItemChange(int paramInt, String paramString);
  
  public abstract void onTouchDown(VRecyclerView paramVRecyclerView, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2);
  
  public abstract void onTouchUp(VRecyclerView paramVRecyclerView, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.ui.view.list.VRecyclerView.OnGestureListener
 * JD-Core Version:    0.7.0.1
 */