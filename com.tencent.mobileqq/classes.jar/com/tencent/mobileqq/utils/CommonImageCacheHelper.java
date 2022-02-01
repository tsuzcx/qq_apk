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
    if (GlobalImageCache.jdField_a_of_type_AndroidSupportV4UtilMQLruCache != null)
    {
      paramString = GlobalImageCache.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.get(paramString);
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
    if (GlobalImageCache.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
      paramString = (Bitmap)GlobalImageCache.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str1);
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
        if (GlobalImageCache.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null)
        {
          GlobalImageCache.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str1, paramString);
          str2 = paramString;
        }
      }
    }
    if (str2 != null) {
      return new BitmapDrawable(str2);
    }
    return new ColorDrawable();
  }
  
  public static Sizeable a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (GlobalImageCache.jdField_a_of_type_AndroidSupportV4UtilMQLruCache != null)
    {
      paramString = GlobalImageCache.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.get(paramString);
      if ((paramString != null) && ((paramString instanceof Sizeable))) {
        return (Sizeable)paramString;
      }
    }
    return null;
  }
  
  public static void a(String paramString, Bitmap paramBitmap)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramBitmap == null) {
        return;
      }
      if (GlobalImageCache.jdField_a_of_type_AndroidSupportV4UtilMQLruCache != null) {
        GlobalImageCache.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.put(paramString, paramBitmap);
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
      if (GlobalImageCache.jdField_a_of_type_AndroidSupportV4UtilMQLruCache != null) {
        GlobalImageCache.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.put(paramString, paramSizeable);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.CommonImageCacheHelper
 * JD-Core Version:    0.7.0.1
 */