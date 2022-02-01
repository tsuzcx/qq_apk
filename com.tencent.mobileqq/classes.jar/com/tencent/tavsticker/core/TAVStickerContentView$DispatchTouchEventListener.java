package com.tencent.tavsticker.core;

import android.view.MotionEvent;

public abstract interface TAVStickerContentView$DispatchTouchEventListener
{
  public abstract boolean onDispatchTouchEvent(MotionEvent paramMotionEvent);
  
  public abstract boolean onHackedTouchEvent(MotionEvent paramMotionEvent);
  
  public abstract void setInterceptEvent(Boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavsticker.core.TAVStickerContentView.DispatchTouchEventListener
 * JD-Core Version:    0.7.0.1
 */