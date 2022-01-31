package com.tencent.mobileqq.vas;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.earlydownload.EarlyDownloadManager;
import com.tencent.mobileqq.earlydownload.handler.ApngHandler;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;

public class VasApngUtil
{
  public static int[] a = { 2, 3, 4, 5, 6, 8 };
  
  public static URLDrawable a(AppRuntime paramAppRuntime, String paramString1, String paramString2, Drawable paramDrawable, int[] paramArrayOfInt, String paramString3, Bundle paramBundle)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return null;
    }
    long l1 = SystemClock.uptimeMillis();
    if (!a(paramAppRuntime))
    {
      QLog.d("VasApngUtil", 1, "apng.so load fail");
      return null;
    }
    long l2 = SystemClock.uptimeMillis();
    QLog.d("ChatBackground_Time", 1, "apng.so load succ " + (l2 - l1));
    paramAppRuntime = paramBundle;
    if (paramBundle == null) {}
    for (;;)
    {
      try
      {
        paramAppRuntime = new Bundle();
        boolean bool = paramAppRuntime.getBoolean("key_play_apng", true);
        int i = paramAppRuntime.getInt("key_loop");
        paramBundle = new StringBuilder().append(paramString2);
        if (bool)
        {
          paramString2 = "";
          paramString2 = paramString2;
          paramBundle = new StringBuilder().append(paramString2);
          if (i == 0)
          {
            paramString2 = "";
            paramString2 = paramString2;
            paramBundle = new URL("vasapngdownloader", paramString1, paramString2);
            URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
            localURLDrawableOptions.mUseApngImage = bool;
            localURLDrawableOptions.mUseMemoryCache = paramAppRuntime.getBoolean("key_use_cache", true);
            i = paramAppRuntime.getInt("key_width", 0);
            int j = paramAppRuntime.getInt("key_height", 0);
            if ((i > 0) && (j > 0))
            {
              localURLDrawableOptions.mRequestWidth = i;
              localURLDrawableOptions.mRequestHeight = j;
            }
            localURLDrawableOptions.mLoadingDrawable = paramDrawable;
            localURLDrawableOptions.mFailedDrawable = paramDrawable;
            paramAppRuntime.putIntArray("key_tagId_arr", paramArrayOfInt);
            paramAppRuntime.putString("key_name", paramString3);
            localURLDrawableOptions.mExtraInfo = paramAppRuntime;
            if ("-Dynamic-".equals(paramString2)) {
              localURLDrawableOptions.mUseAutoScaleParams = false;
            }
            paramAppRuntime = URLDrawable.getDrawable(paramBundle, localURLDrawableOptions);
            if (QLog.isColorLevel()) {
              QLog.d("VasApngUtil", 2, "getApngDrawable ApngImage ok path:" + paramString1 + ", name=" + paramString3);
            }
          }
          else
          {
            paramString2 = "&l=" + i;
            continue;
          }
          return paramAppRuntime;
        }
      }
      catch (Exception paramAppRuntime)
      {
        QLog.e("VasApngUtil", 1, "getApngDrawable ApngImage err:" + paramAppRuntime.toString() + ", path:" + paramString1 + ", name=" + paramString3);
        return null;
      }
      paramString2 = "?p=0";
    }
  }
  
  public static boolean a(AppRuntime paramAppRuntime)
  {
    boolean bool2 = ApngHandler.b.get();
    if (!bool2) {
      if (!ApngHandler.c())
      {
        if (paramAppRuntime != null) {
          break label135;
        }
        if (BaseApplicationImpl.getApplication() != null) {
          paramAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
        }
      }
    }
    label135:
    for (;;)
    {
      if (paramAppRuntime != null)
      {
        paramAppRuntime = (EarlyDownloadManager)paramAppRuntime.getManager(76);
        StringBuilder localStringBuilder;
        if (paramAppRuntime != null)
        {
          paramAppRuntime = (ApngHandler)paramAppRuntime.a("qq.android.native.apng_v700");
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder().append("isSoPrepared = false, goto load. apngHandler = ");
            if (paramAppRuntime == null) {
              break label117;
            }
          }
        }
        label117:
        for (boolean bool1 = true;; bool1 = false)
        {
          QLog.d("VasApngUtil", 2, bool1);
          if (paramAppRuntime != null) {
            paramAppRuntime.a(true);
          }
          return bool2;
          paramAppRuntime = null;
          break;
        }
        ApngHandler.d_();
        return ApngHandler.b.get();
      }
      return bool2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp2\com34.jar
 * Qualified Name:     com.tencent.mobileqq.vas.VasApngUtil
 * JD-Core Version:    0.7.0.1
 */