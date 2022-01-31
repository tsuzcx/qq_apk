package com.tencent.mobileqq.utils;

import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.cache.Sizeable;

public class CommonImageCacheHelper
{
  public static Sizeable a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (BaseApplicationImpl.sImageCache != null)
    {
      paramString = BaseApplicationImpl.sImageCache.get(paramString);
      if ((paramString != null) && ((paramString instanceof Sizeable))) {
        return (Sizeable)paramString;
      }
    }
    return null;
  }
  
  public static void a(String paramString, Sizeable paramSizeable)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramSizeable == null)) {}
    while (BaseApplicationImpl.sImageCache == null) {
      return;
    }
    BaseApplicationImpl.sImageCache.put(paramString, paramSizeable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.utils.CommonImageCacheHelper
 * JD-Core Version:    0.7.0.1
 */