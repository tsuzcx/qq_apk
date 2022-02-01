package com.tencent.rmonitor.bigbitmap.provider;

import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.rmonitor.bigbitmap.datainfo.DrawableInfo;

public abstract class AbstractDrawableSizeProvider
{
  @Nullable
  public abstract DrawableInfo a(@Nullable Drawable paramDrawable);
  
  @NonNull
  public String a()
  {
    return getClass().getName();
  }
  
  @Nullable
  public abstract DrawableInfo b(@Nullable Drawable paramDrawable);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.bigbitmap.provider.AbstractDrawableSizeProvider
 * JD-Core Version:    0.7.0.1
 */