package com.tencent.viola.core;

import android.view.MotionEvent;
import android.view.View;

public abstract interface ViolaInstance$ViolaPageListener
{
  public abstract void onComponentFloatBottom(View paramView, float paramFloat);
  
  public abstract void onComponentFloatCenter(View paramView, float paramFloat);
  
  public abstract void onComponentTopIndex(View paramView, float paramFloat);
  
  public abstract void onDispatchTouchEvent(String paramString, int paramInt1, MotionEvent paramMotionEvent, int paramInt2);
  
  public abstract void onScroll(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean);
  
  public abstract void onScrollStateChanged(String paramString, int paramInt1, int paramInt2, boolean paramBoolean);
  
  public abstract void pageOpenSuccess();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.core.ViolaInstance.ViolaPageListener
 * JD-Core Version:    0.7.0.1
 */