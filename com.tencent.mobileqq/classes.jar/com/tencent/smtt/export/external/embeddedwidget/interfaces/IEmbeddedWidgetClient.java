package com.tencent.smtt.export.external.embeddedwidget.interfaces;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.Surface;

public abstract interface IEmbeddedWidgetClient
{
  public abstract void onActive();
  
  public abstract void onDeactive();
  
  public abstract void onDestroy();
  
  public abstract void onRectChanged(Rect paramRect);
  
  public abstract void onRequestRedraw();
  
  public abstract void onSurfaceCreated(Surface paramSurface);
  
  public abstract void onSurfaceDestroyed(Surface paramSurface);
  
  public abstract boolean onTouchEvent(MotionEvent paramMotionEvent);
  
  public abstract void onVisibilityChanged(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.smtt.export.external.embeddedwidget.interfaces.IEmbeddedWidgetClient
 * JD-Core Version:    0.7.0.1
 */