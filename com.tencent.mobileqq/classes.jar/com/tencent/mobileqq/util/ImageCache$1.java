package com.tencent.mobileqq.util;

import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

class ImageCache$1
  extends CustomLruCache<String, Drawable>
{
  ImageCache$1(ImageCache paramImageCache, int paramInt)
  {
    super(paramInt);
  }
  
  protected int a(String paramString, Drawable paramDrawable)
  {
    boolean bool = paramDrawable instanceof BitmapDrawable;
    int i = 0;
    if (bool)
    {
      paramString = ((BitmapDrawable)paramDrawable).getBitmap();
      if (paramString != null) {
        return paramString.getRowBytes() * paramString.getHeight();
      }
      return 0;
    }
    if ((paramDrawable instanceof AnimationDrawable))
    {
      paramString = (AnimationDrawable)paramDrawable;
      int m = paramString.getNumberOfFrames();
      int k;
      for (int j = 0; i < m; j = k)
      {
        paramDrawable = paramString.getFrame(i);
        k = j;
        if ((paramDrawable instanceof BitmapDrawable))
        {
          paramDrawable = ((BitmapDrawable)paramDrawable).getBitmap();
          k = j;
          if (paramDrawable != null) {
            k = j + paramDrawable.getRowBytes() * paramDrawable.getHeight();
          }
        }
        i += 1;
      }
      return j;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.util.ImageCache.1
 * JD-Core Version:    0.7.0.1
 */