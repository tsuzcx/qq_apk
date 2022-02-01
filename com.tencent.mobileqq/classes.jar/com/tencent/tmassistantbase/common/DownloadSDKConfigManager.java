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
    if (localNewQqCenterConfig == null)
    {
      ab.e("DownloadSDKConfigManager", "[canGotoNewDetailPage] cfg is empty!");
      return true;
    }
    return localNewQqCenterConfig.entranceSwitch != 1;
  }
  
  public static boolean canGotoNewDetailPage(String paramString)
  {
    Object localObject = b.a().c();
    if ((localObject != null) && (((NewQqCenterConfig)localObject).enterOldViaList != null) && (!TextUtils.isEmpty(paramString)))
    {
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
    ab.e("DownloadSDKConfigManager", "[canGotoNewDetailPage] cfg is empty!");
    return true;
  }
  
  public static String getPageUrl(String paramString)
  {
    NewQqCenterConfig localNewQqCenterConfig = b.a().c();
    if ((localNewQqCenterConfig != null) && (localNewQqCenterConfig.appNewsUrlMap != null) && (!TextUtils.isEmpty(paramString))) {
      return (String)localNewQqCenterConfig.appNewsUrlMap.get(paramString);
    }
    ab.e("DownloadSDKConfigManager", "[getPageUrl] cfg is empty!");
    return "";
  }
  
  public static boolean isDownloadUrlBlocked(Context paramContext, String paramString)
  {
    long l = System.currentTimeMillis();
    k.a().post(new c());
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("<checkDownloadUrl>url is : ");
    ((StringBuilder)localObject).append(paramString);
    ab.c("DownloadSDKConfigManager", ((StringBuilder)localObject).toString());
    paramContext = b.a().a(paramContext);
    if ((!TextUtils.isEmpty(paramString)) && (paramContext != null) && (paramContext.size() != 0))
    {
      localObject = paramContext.iterator();
      while (((Iterator)localObject).hasNext())
      {
        paramContext = (String)((Iterator)localObject).next();
        if (paramString.contains(paramContext))
        {
          paramString = new StringBuilder();
          paramString.append("<checkDownloadUrl> contains : ");
          paramString.append(paramContext);
          paramString.append(",time cost = ");
          paramString.append(System.currentTimeMillis() - l);
          paramString.append("ms");
          ab.c("DownloadSDKConfigManager", paramString.toString());
          return true;
        }
      }
      paramContext = new StringBuilder();
      paramContext.append("<checkDownloadUrl> non key word match return false ,time cost = ");
      paramContext.append(System.currentTimeMillis() - l);
      paramContext.append("ms");
      ab.c("DownloadSDKConfigManager", paramContext.toString());
      return false;
    }
    paramContext = new StringBuilder();
    paramContext.append("<checkDownloadUrl> blackList isEmpty or null,time cost = ");
    paramContext.append(System.currentTimeMillis() - l);
    paramContext.append("ms");
    ab.c("DownloadSDKConfigManager", paramContext.toString());
    return false;
  }
  
  public static void refreshNewAppCenterConfig()
  {
    k.a().post(new d());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tmassistantbase.common.DownloadSDKConfigManager
 * JD-Core Version:    0.7.0.1
 */