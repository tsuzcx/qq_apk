package com.tencent.mtt.supportui.adapters.image;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

public abstract interface IDrawableTarget
{
  public abstract Bitmap getBitmap();
  
  public abstract Drawable getDrawable();
  
  public abstract Object getExtraData();
  
  public abstract String getSource();
  
  public abstract void onDrawableAttached();
  
  public abstract void onDrawableDetached();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.supportui.adapters.image.IDrawableTarget
 * JD-Core Version:    0.7.0.1
 */