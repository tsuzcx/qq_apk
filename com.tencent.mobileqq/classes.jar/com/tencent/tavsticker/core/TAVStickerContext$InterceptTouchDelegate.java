package com.tencent.tavsticker.core;

import android.graphics.PointF;

public abstract interface TAVStickerContext$InterceptTouchDelegate
{
  public abstract boolean checkInterceptArea(PointF paramPointF);
  
  public abstract boolean shouldInterceptTouch();
  
  public abstract void touchInterceptArea(PointF paramPointF);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavsticker.core.TAVStickerContext.InterceptTouchDelegate
 * JD-Core Version:    0.7.0.1
 */