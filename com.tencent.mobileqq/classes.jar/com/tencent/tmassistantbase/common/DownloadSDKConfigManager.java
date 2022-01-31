package com.tencent.tmassistantbase.common;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.tmassistantbase.util.f;
import com.tencent.tmassistantbase.util.r;
import com.tencent.tmdownloader.internal.storage.b;
import java.util.Iterator;
import java.util.List;

public class DownloadSDKConfigManager
{
  private static final String TAG = "DownloadSDKConfigManager";
  
  public static boolean isDownloadUrlBlocked(Context paramContext, String paramString)
  {
    long l = System.currentTimeMillis();
    f.a().post(new c());
    r.c("DownloadSDKConfigManager", "<checkDownloadUrl>url is : " + paramString);
    paramContext = b.a().a(paramContext);
    if ((TextUtils.isEmpty(paramString)) || (paramContext == null) || (paramContext.size() == 0))
    {
      r.c("DownloadSDKConfigManager", "<checkDownloadUrl> blackList isEmpty or null,time cost = " + (System.currentTimeMillis() - l) + "ms");
      return false;
    }
    paramContext = paramContext.iterator();
    while (paramContext.hasNext())
    {
      String str = (String)paramContext.next();
      if (paramString.contains(str))
      {
        r.c("DownloadSDKConfigManager", "<checkDownloadUrl> contains : " + str + ",time cost = " + (System.currentTimeMillis() - l) + "ms");
        return true;
      }
    }
    r.c("DownloadSDKConfigManager", "<checkDownloadUrl> non key word match return false ,time cost = " + (System.currentTimeMillis() - l) + "ms");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tmassistantbase.common.DownloadSDKConfigManager
 * JD-Core Version:    0.7.0.1
 */