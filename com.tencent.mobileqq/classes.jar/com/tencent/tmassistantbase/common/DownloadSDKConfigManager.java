package com.tencent.tmassistantbase.common;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.tmassistant.common.jce.NewQqCenterConfig;
import com.tencent.tmassistantbase.util.ab;
import com.tencent.tmassistantbase.util.k;
import com.tencent.tmdownloader.internal.storage.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class DownloadSDKConfigManager
{
  private static final String TAG = "DownloadSDKConfigManager";
  
  public static boolean canGotoNewAppListPage()
  {
    NewQqCenterConfig localNewQqCenterConfig = b.a().c();
    if (localNewQqCenterConfig == null) {
      ab.e("DownloadSDKConfigManager", "[canGotoNewDetailPage] cfg is empty!");
    }
    while (localNewQqCenterConfig.entranceSwitch != 1) {
      return true;
    }
    return false;
  }
  
  public static boolean canGotoNewDetailPage(String paramString)
  {
    Object localObject = b.a().c();
    if ((localObject == null) || (((NewQqCenterConfig)localObject).enterOldViaList == null) || (TextUtils.isEmpty(paramString)))
    {
      ab.e("DownloadSDKConfigManager", "[canGotoNewDetailPage] cfg is empty!");
      return true;
    }
    if (((NewQqCenterConfig)localObject).detailSwitch == 0) {
      return true;
    }
    if (((NewQqCenterConfig)localObject).detailSwitch == 1)
    {
      localObject = ((NewQqCenterConfig)localObject).enterOldViaList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        if ((!TextUtils.isEmpty(str)) && (paramString.startsWith(str))) {
          return false;
        }
      }
    }
    return true;
  }
  
  public static String getPageUrl(String paramString)
  {
    NewQqCenterConfig localNewQqCenterConfig = b.a().c();
    if ((localNewQqCenterConfig == null) || (localNewQqCenterConfig.appNewsUrlMap == null) || (TextUtils.isEmpty(paramString)))
    {
      ab.e("DownloadSDKConfigManager", "[getPageUrl] cfg is empty!");
      return "";
    }
    return (String)localNewQqCenterConfig.appNewsUrlMap.get(paramString);
  }
  
  public static boolean isDownloadUrlBlocked(Context paramContext, String paramString)
  {
    long l = System.currentTimeMillis();
    k.a().post(new c());
    ab.c("DownloadSDKConfigManager", "<checkDownloadUrl>url is : " + paramString);
    paramContext = b.a().a(paramContext);
    if ((TextUtils.isEmpty(paramString)) || (paramContext == null) || (paramContext.size() == 0))
    {
      ab.c("DownloadSDKConfigManager", "<checkDownloadUrl> blackList isEmpty or null,time cost = " + (System.currentTimeMillis() - l) + "ms");
      return false;
    }
    paramContext = paramContext.iterator();
    while (paramContext.hasNext())
    {
      String str = (String)paramContext.next();
      if (paramString.contains(str))
      {
        ab.c("DownloadSDKConfigManager", "<checkDownloadUrl> contains : " + str + ",time cost = " + (System.currentTimeMillis() - l) + "ms");
        return true;
      }
    }
    ab.c("DownloadSDKConfigManager", "<checkDownloadUrl> non key word match return false ,time cost = " + (System.currentTimeMillis() - l) + "ms");
    return false;
  }
  
  public static void refreshNewAppCenterConfig()
  {
    k.a().post(new d());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tmassistantbase.common.DownloadSDKConfigManager
 * JD-Core Version:    0.7.0.1
 */