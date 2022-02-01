package com.tencent.richmediabrowser.model;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;

public abstract class BrowserAnimation
{
  public boolean isImgCenterCropMode;
  public Rect thubmRect;
  
  public static int getCutValue(Rect paramRect, Drawable paramDrawable)
  {
    return 0;
  }
  
  public abstract Drawable getAnimationDrawable();
  
  public abstract int getCutValue();
  
  public Rect getStartSrcRect()
  {
    return null;
  }
  
  public int getStartX()
  {
    return 0;
  }
  
  public int getStartY()
  {
    return 0;
  }
  
  public Rect getThumbRect()
  {
    return this.thubmRect;
  }
  
  public boolean needAnimation(boolean paramBoolean)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.richmediabrowser.model.BrowserAnimation
 * JD-Core Version:    0.7.0.1
 */