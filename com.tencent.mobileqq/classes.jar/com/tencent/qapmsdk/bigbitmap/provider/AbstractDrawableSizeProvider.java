package com.tencent.qapmsdk.bigbitmap.provider;

import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qapmsdk.bigbitmap.datainfo.DrawableInfo;

public abstract class AbstractDrawableSizeProvider
{
  @Nullable
  public abstract DrawableInfo checkBackground(@Nullable Drawable paramDrawable);
  
  @Nullable
  public abstract DrawableInfo checkSrc(@Nullable Drawable paramDrawable);
  
  @NonNull
  public String type()
  {
    return getClass().getName();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.bigbitmap.provider.AbstractDrawableSizeProvider
 * JD-Core Version:    0.7.0.1
 */