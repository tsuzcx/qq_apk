package com.tencent.plato.sdk;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;

public abstract interface IImageLoader
{
  public abstract void loadDrawable(String paramString, Context paramContext, Listener paramListener);
  
  public abstract void loadImage(String paramString, ImageView paramImageView, Option paramOption);
  
  public static abstract interface Listener
  {
    public abstract void onLoad(BitmapDrawable paramBitmapDrawable);
  }
  
  public static class Option
  {
    public int height;
    public String resizeMode;
    public int roundRadius;
    public int width;
    
    public Option(String paramString, int paramInt1, int paramInt2, int paramInt3)
    {
      this.resizeMode = paramString;
      this.roundRadius = paramInt1;
      this.width = paramInt2;
      this.height = paramInt3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.plato.sdk.IImageLoader
 * JD-Core Version:    0.7.0.1
 */