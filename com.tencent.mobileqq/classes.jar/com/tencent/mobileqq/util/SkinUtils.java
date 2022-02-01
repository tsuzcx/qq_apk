package com.tencent.mobileqq.util;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.theme.SkinnableNinePatchDrawable;

public class SkinUtils
{
  @SuppressLint({"NewApi"})
  public static int a(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return -1;
    }
    return paramBitmap.getRowBytes() * paramBitmap.getHeight();
  }
  
  public static final Bitmap a(Drawable paramDrawable)
  {
    if (paramDrawable == null) {
      return null;
    }
    if ((paramDrawable instanceof BitmapDrawable)) {
      return ((BitmapDrawable)paramDrawable).getBitmap();
    }
    if ((paramDrawable instanceof SkinnableBitmapDrawable)) {
      return ((SkinnableBitmapDrawable)paramDrawable).getBitmap();
    }
    return null;
  }
  
  public static int b(Drawable paramDrawable)
  {
    if (paramDrawable == null) {
      return -1;
    }
    if ((paramDrawable instanceof BitmapDrawable)) {
      return a(((BitmapDrawable)paramDrawable).getBitmap());
    }
    if ((paramDrawable instanceof SkinnableBitmapDrawable)) {
      return a(((SkinnableBitmapDrawable)paramDrawable).getBitmap());
    }
    if ((paramDrawable instanceof SkinnableNinePatchDrawable)) {
      return a(((SkinnableNinePatchDrawable)paramDrawable).getBitmap());
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.util.SkinUtils
 * JD-Core Version:    0.7.0.1
 */