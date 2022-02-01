package com.tencent.open.appstore.dl;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.monitor.network.NetworkMonitor;
import com.tencent.tmdownloader.notify.DownloadGlobalListener;
import com.tencent.tmdownloader.notify.DownloadTaskInfo;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class TMADownloadMonitor
  implements DownloadGlobalListener
{
  private static TMADownloadMonitor a;
  
  private TMADownloadMonitor()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TMADownloadMonitor", 2, "TMADownloadMonitor Init");
    }
  }
  
  public static TMADownloadMonitor a()
  {
    TMADownloadMonitor localTMADownloadMonitor = a;
    if (localTMADownloadMonitor != null) {
      return localTMADownloadMonitor;
    }
    try
    {
      a = new TMADownloadMonitor();
      localTMADownloadMonitor = a;
      return localTMADownloadMonitor;
    }
    finally {}
  }
  
  public static void a(Context paramContext, DownloadTaskInfo paramDownloadTaskInfo)
  {
    if ((paramDownloadTaskInfo != null) && (paramContext != null))
    {
      NetworkMonitor.a().addDownloadURL(paramDownloadTaskInfo.url);
      if (a(paramDownloadTaskInfo.url)) {
        return;
      }
      HashMap localHashMap = new HashMap();
      localHashMap.put("url", paramDownloadTaskInfo.url);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(NetworkUtil.getNetworkType(paramContext));
      ((StringBuilder)localObject).append("");
      localHashMap.put("NetworkType", ((StringBuilder)localObject).toString());
      localHashMap.put("reportVia", "5");
      if (paramDownloadTaskInfo.stackInfo.length() < 950)
      {
        localHashMap.put("Stack", paramDownloadTaskInfo.stackInfo);
      }
      else
      {
        localHashMap.put("Stack", paramDownloadTaskInfo.stackInfo.substring(0, 950));
        if (paramDownloadTaskInfo.stackInfo.length() < 1901) {
          localHashMap.put("Stack1", paramDownloadTaskInfo.stackInfo.substring(950));
        } else {
          localHashMap.put("Stack1", paramDownloadTaskInfo.stackInfo.substring(950, 1900));
        }
      }
      localHashMap.put("_filesize_from_dlg", "0");
      localHashMap.put("_filename_from_dlg", paramDownloadTaskInfo.pkgName);
      if (paramDownloadTaskInfo.versionCode > 0) {
        localHashMap.put("isAPK", "1");
      } else {
        localHashMap.put("isAPK", "0");
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramDownloadTaskInfo.versionCode);
      ((StringBuilder)localObject).append("");
      localHashMap.put("VersionCode", ((StringBuilder)localObject).toString());
      paramDownloadTaskInfo = paramDownloadTaskInfo.source;
      if (TextUtils.isEmpty(paramDownloadTaskInfo))
      {
        StatisticCollector.getInstance(paramContext).collectPerformance(null, "UniformDownloadEvent_NO_SOURCE", true, 0L, 0L, localHashMap, "");
      }
      else
      {
        localHashMap.put("DOWNLOAD_BIG_BROTHER_SOURCE", paramDownloadTaskInfo);
        StatisticCollector.getInstance(paramContext).collectPerformance(null, "UniformDownloadEvent", true, 0L, 0L, localHashMap, "");
      }
      if (QLog.isColorLevel())
      {
        paramContext = new StringBuilder();
        paramDownloadTaskInfo = localHashMap.keySet().iterator();
        while (paramDownloadTaskInfo.hasNext())
        {
          localObject = (String)paramDownloadTaskInfo.next();
          paramContext.append((String)localObject);
          paramContext.append("=");
          paramContext.append((String)localHashMap.get(localObject));
          paramContext.append("\n");
        }
        QLog.d("UniformDownloadEvent", 2, paramContext.toString());
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("UniformDownloadEvent", 2, "downloadTaskInfo is null or context==null");
    }
  }
  
  private static boolean a(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && ((paramString.endsWith("patch")) || (paramString.endsWith("zip")) || (paramString.endsWith("7z")));
  }
  
  public void onTaskCompleted(DownloadTaskInfo paramDownloadTaskInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TMADownloadMonitor", 2, new Object[] { "onTaskCompleted,", paramDownloadTaskInfo });
    }
  }
  
  public void onTaskFailed(DownloadTaskInfo paramDownloadTaskInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TMADownloadMonitor", 2, new Object[] { "onTaskFailed,", paramDownloadTaskInfo });
    }
  }
  
  public void onTaskPaused(DownloadTaskInfo paramDownloadTaskInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TMADownloadMonitor", 2, new Object[] { "onTaskPaused,", paramDownloadTaskInfo });
    }
  }
  
  public void onTaskStarted(DownloadTaskInfo paramDownloadTaskInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TMADownloadMonitor", 2, new Object[] { "onTaskStarted,", paramDownloadTaskInfo });
    }
    a(BaseApplicationImpl.getContext(), paramDownloadTaskInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.appstore.dl.TMADownloadMonitor
 * JD-Core Version:    0.7.0.1
 */