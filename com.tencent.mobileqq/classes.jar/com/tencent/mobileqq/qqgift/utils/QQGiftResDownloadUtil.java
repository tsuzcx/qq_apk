package com.tencent.mobileqq.qqgift.utils;

import android.util.LruCache;
import androidx.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;

public class QQGiftResDownloadUtil
{
  private static final LruCache<String, Long> a = new LruCache(100);
  
  public static boolean a(@NonNull String paramString)
  {
    Long localLong1 = (Long)a.get(paramString);
    Long localLong2 = Long.valueOf(System.currentTimeMillis());
    if (localLong1 == null)
    {
      a.put(paramString, localLong2);
      return false;
    }
    if (Math.abs(localLong2.longValue() - localLong1.longValue()) >= 300000L)
    {
      a.put(paramString, localLong2);
      return false;
    }
    return true;
  }
  
  public static void b(@NonNull String paramString)
  {
    try
    {
      a.remove(paramString);
      return;
    }
    catch (Exception paramString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("clearNeedDownload e:");
      localStringBuilder.append(paramString.getMessage());
      QLog.e("QQGiftResDownloadUtil", 1, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.utils.QQGiftResDownloadUtil
 * JD-Core Version:    0.7.0.1
 */