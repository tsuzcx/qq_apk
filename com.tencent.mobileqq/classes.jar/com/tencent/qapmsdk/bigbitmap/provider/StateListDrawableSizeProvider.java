package com.tencent.qapmsdk.bigbitmap.provider;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.support.annotation.Nullable;
import android.support.v4.graphics.BitmapCompat;
import com.tencent.qapmsdk.bigbitmap.datainfo.DrawableInfo;

public class StateListDrawableSizeProvider
  extends AbstractDrawableSizeProvider
{
  private DrawableInfo check(@Nullable Drawable paramDrawable, int paramInt)
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
  public DrawableInfo checkBackground(@Nullable Drawable paramDrawable)
  {
    return check(paramDrawable, 0);
  }
  
  @Nullable
  public DrawableInfo checkSrc(@Nullable Drawable paramDrawable)
  {
    return check(paramDrawable, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.bigbitmap.provider.StateListDrawableSizeProvider
 * JD-Core Version:    0.7.0.1
 */