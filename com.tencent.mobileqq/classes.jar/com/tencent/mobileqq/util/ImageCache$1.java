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
    int i = 0;
    int j = 0;
    if ((paramDrawable instanceof BitmapDrawable))
    {
      paramString = ((BitmapDrawable)paramDrawable).getBitmap();
      if (paramString != null) {
        j = paramString.getRowBytes() * paramString.getHeight();
      }
    }
    int m;
    int k;
    do
    {
      do
      {
        return j;
      } while (!(paramDrawable instanceof AnimationDrawable));
      paramString = (AnimationDrawable)paramDrawable;
      m = paramString.getNumberOfFrames();
      k = 0;
      j = i;
    } while (k >= m);
    paramDrawable = paramString.getFrame(k);
    if ((paramDrawable instanceof BitmapDrawable))
    {
      paramDrawable = ((BitmapDrawable)paramDrawable).getBitmap();
      if (paramDrawable != null)
      {
        j = paramDrawable.getRowBytes();
        i = paramDrawable.getHeight() * j + i;
      }
    }
    for (;;)
    {
      k += 1;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.util.ImageCache.1
 * JD-Core Version:    0.7.0.1
 */