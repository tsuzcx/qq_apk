package com.tencent.mobileqq.utils;

import android.graphics.Bitmap;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import com.tencent.commonsdk.cache.Sizeable;
import com.tencent.mobileqq.app.GlobalImageCache;

public class CommonImageCacheHelper
{
  public static Bitmap a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (GlobalImageCache.a != null)
    {
      paramString = GlobalImageCache.a.get(paramString);
      if ((paramString != null) && ((paramString instanceof Bitmap))) {
        return (Bitmap)paramString;
      }
    }
    return null;
  }
  
  public static Sizeable a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (GlobalImageCache.a != null)
    {
      paramString = GlobalImageCache.a.get(paramString);
      if ((paramString != null) && ((paramString instanceof Sizeable))) {
        return (Sizeable)paramString;
      }
    }
    return null;
  }
  
  public static void a(String paramString, Bitmap paramBitmap)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramBitmap == null)) {}
    while (GlobalImageCache.a == null) {
      return;
    }
    GlobalImageCache.a.put(paramString, paramBitmap);
  }
  
  public static void a(String paramString, Sizeable paramSizeable)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramSizeable == null)) {}
    while (GlobalImageCache.a == null) {
      return;
    }
    GlobalImageCache.a.put(paramString, paramSizeable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.CommonImageCacheHelper
 * JD-Core Version:    0.7.0.1
 */