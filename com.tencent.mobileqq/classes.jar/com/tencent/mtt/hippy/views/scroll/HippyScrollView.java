package com.tencent.mtt.hippy.views.scroll;

import com.tencent.mtt.hippy.common.HippyMap;

public abstract interface HippyScrollView
{
  public abstract void callSmoothScrollTo(int paramInt1, int paramInt2, int paramInt3);
  
  public abstract void setContentOffset4Reuse(HippyMap paramHippyMap);
  
  public abstract void setFlingEnabled(boolean paramBoolean);
  
  public abstract void setMomentumScrollBeginEventEnable(boolean paramBoolean);
  
  public abstract void setMomentumScrollEndEventEnable(boolean paramBoolean);
  
  public abstract void setPagingEnabled(boolean paramBoolean);
  
  public abstract void setScrollAnimationEndEventEnable(boolean paramBoolean);
  
  public abstract void setScrollBeginDragEventEnable(boolean paramBoolean);
  
  public abstract void setScrollEnabled(boolean paramBoolean);
  
  public abstract void setScrollEndDragEventEnable(boolean paramBoolean);
  
  public abstract void setScrollEventEnable(boolean paramBoolean);
  
  public abstract void setScrollEventThrottle(int paramInt);
  
  public abstract void setScrollMinOffset(int paramInt);
  
  public abstract void showScrollIndicator(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.hippy.views.scroll.HippyScrollView
 * JD-Core Version:    0.7.0.1
 */