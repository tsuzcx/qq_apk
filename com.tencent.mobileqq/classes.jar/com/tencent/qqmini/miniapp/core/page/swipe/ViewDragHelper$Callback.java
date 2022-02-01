package com.tencent.qqmini.miniapp.core.page.swipe;

import android.view.MotionEvent;
import android.view.View;

public abstract class ViewDragHelper$Callback
{
  public int clampViewPositionHorizontal(View paramView, int paramInt1, int paramInt2)
  {
    return 0;
  }
  
  public int clampViewPositionVertical(View paramView, int paramInt1, int paramInt2)
  {
    return 0;
  }
  
  public int getOrderedChildIndex(int paramInt)
  {
    return paramInt;
  }
  
  public int getViewHorizontalDragRange(View paramView)
  {
    return 0;
  }
  
  public int getViewVerticalDragRange(View paramView)
  {
    return 0;
  }
  
  public void onEdgeDragStarted(int paramInt1, int paramInt2) {}
  
  public boolean onEdgeLock(int paramInt)
  {
    return false;
  }
  
  public void onEdgeTouched(int paramInt1, int paramInt2) {}
  
  public void onViewCaptured(View paramView, int paramInt) {}
  
  public void onViewDragStateChanged(int paramInt) {}
  
  public void onViewPositionChanged(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void onViewReleased(View paramView, float paramFloat1, float paramFloat2, MotionEvent paramMotionEvent) {}
  
  public abstract boolean tryCaptureView(View paramView, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.page.swipe.ViewDragHelper.Callback
 * JD-Core Version:    0.7.0.1
 */