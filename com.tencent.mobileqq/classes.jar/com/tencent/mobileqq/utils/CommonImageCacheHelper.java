package com.tencent.mobileqq.utils;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import com.tencent.commonsdk.cache.Sizeable;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.concurrent.ConcurrentHashMap;

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
  
  public static Drawable a(String paramString, int paramInt)
  {
    String str1 = paramString;
    if (paramString == null) {
      str1 = String.valueOf(paramInt);
    }
    if (GlobalImageCache.b != null) {
      paramString = (Bitmap)GlobalImageCache.b.get(str1);
    } else {
      paramString = null;
    }
    String str2 = paramString;
    if (paramString == null)
    {
      paramString = BitmapManager.a(BaseApplication.getContext().getResources(), paramInt);
      str2 = paramString;
      if (paramString != null)
      {
        str2 = paramString;
        if (GlobalImageCache.b != null)
        {
          GlobalImageCache.b.put(str1, paramString);
          str2 = paramString;
        }
      }
    }
    if (str2 != null) {
      return new BitmapDrawable(str2);
    }
    return new ColorDrawable();
  }
  
  public static void a(String paramString, Bitmap paramBitmap)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramBitmap == null) {
        return;
      }
      if (GlobalImageCache.a != null) {
        GlobalImageCache.a.put(paramString, paramBitmap);
      }
    }
  }
  
  public static void a(String paramString, Sizeable paramSizeable)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramSizeable == null) {
        return;
      }
      if (GlobalImageCache.a != null) {
        GlobalImageCache.a.put(paramString, paramSizeable);
      }
    }
  }
  
  public static Sizeable b(String paramString)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.CommonImageCacheHelper
 * JD-Core Version:    0.7.0.1
 */