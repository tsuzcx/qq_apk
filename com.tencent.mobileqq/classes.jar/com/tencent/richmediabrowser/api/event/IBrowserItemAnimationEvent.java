package com.tencent.richmediabrowser.api.event;

import android.graphics.Rect;

public abstract interface IBrowserItemAnimationEvent
{
  public abstract Rect getAnimationEndDstRect();
  
  public abstract boolean needEnterRectAnimation();
  
  public abstract boolean needExitRectAnimation();
  
  public abstract void onEnterAnimationEnd();
  
  public abstract void onEnterAnimationStart();
  
  public abstract void onExitAnimationEnd();
  
  public abstract void onExitAnimationStart();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.richmediabrowser.api.event.IBrowserItemAnimationEvent
 * JD-Core Version:    0.7.0.1
 */