package com.tencent.mobileqq.widget;

import android.view.View;

public abstract interface ScrollListener
{
  public abstract void fling(View paramView, int paramInt);
  
  public abstract void onFingerDown(View paramView, float paramFloat1, float paramFloat2);
  
  public abstract void onFingerUpOrCancel(View paramView, float paramFloat1, float paramFloat2);
  
  public abstract void onScrollChanged(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ScrollListener
 * JD-Core Version:    0.7.0.1
 */