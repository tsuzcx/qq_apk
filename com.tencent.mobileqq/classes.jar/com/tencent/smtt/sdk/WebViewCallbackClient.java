package com.tencent.smtt.sdk;

import android.view.MotionEvent;
import android.view.View;

public abstract interface WebViewCallbackClient
{
  public abstract void computeScroll(View paramView);
  
  public abstract boolean dispatchTouchEvent(MotionEvent paramMotionEvent, View paramView);
  
  public abstract void invalidate();
  
  public abstract boolean onInterceptTouchEvent(MotionEvent paramMotionEvent, View paramView);
  
  public abstract void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, View paramView);
  
  public abstract void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView);
  
  public abstract boolean onTouchEvent(MotionEvent paramMotionEvent, View paramView);
  
  public abstract boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean, View paramView);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.smtt.sdk.WebViewCallbackClient
 * JD-Core Version:    0.7.0.1
 */