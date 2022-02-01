package com.tencent.rmonitor.bigbitmap.provider;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.support.annotation.Nullable;
import android.support.v4.graphics.BitmapCompat;
import com.tencent.rmonitor.bigbitmap.datainfo.DrawableInfo;

public class StateListDrawableSizeProvider
  extends AbstractDrawableSizeProvider
{
  private DrawableInfo a(@Nullable Drawable paramDrawable, int paramInt)
  {
    if ((paramDrawable instanceof StateListDrawable))
    {
      paramDrawable = paramDrawable.getCurrent();
      if ((paramDrawable instanceof BitmapDrawable))
      {
        paramDrawable = ((BitmapDrawable)paramDrawable).getBitmap();
        if (paramDrawable != null) {
          return new DrawableInfo(paramInt, paramDrawable.getWidth(), paramDrawable.getHeight(), BitmapCompat.getAllocationByteCount(paramDrawable));
        }
      }
    }
    return null;
  }
  
  @Nullable
  public DrawableInfo a(@Nullable Drawable paramDrawable)
  {
    return a(paramDrawable, 0);
  }
  
  @Nullable
  public DrawableInfo b(@Nullable Drawable paramDrawable)
  {
    return a(paramDrawable, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.bigbitmap.provider.StateListDrawableSizeProvider
 * JD-Core Version:    0.7.0.1
 */