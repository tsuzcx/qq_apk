package com.tencent.tmdownloader;

import android.os.RemoteCallbackList;
import android.text.TextUtils;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import com.tencent.tmassistant.aidl.e;
import com.tencent.tmassistantbase.common.TMAssistantDownloadConst;
import com.tencent.tmassistantbase.util.ac;
import com.tencent.tmdownloader.internal.downloadservice.ApkDownloadManager;
import com.tencent.tmdownloader.internal.downloadservice.a.c;
import com.tencent.tmdownloader.internal.downloadservice.g;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class y
  extends e
{
  protected y(TMAssistantDownloadService paramTMAssistantDownloadService) {}
  
  public int a()
  {
    ac.c("TMADownloadSDKService", "returnValue: 1");
    return 1;
  }
  
  public int a(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, Map paramMap)
  {
    ac.c("TMADownloadSDKService", "<startDownloadTask>enter");
    ac.c("TMADownloadSDKService", "<startDownloadTask>clientkey:" + paramString1 + ",url:" + paramString2 + ",manager:" + this.a.mServiceDownloadTaskManager + ",fileName:" + paramString4);
    String str;
    if (paramMap != null)
    {
      ac.c("TMADownloadSDKService", "startDownloadTask params size : " + paramMap.size());
      if (paramMap.containsKey(TMAssistantDownloadConst.PARAM_SHOW_NOTIFICATION))
      {
        str = (String)paramMap.get(TMAssistantDownloadConst.PARAM_SHOW_NOTIFICATION);
        ac.c("TMADownloadSDKService", "startDownloadTask showNotificationStr : " + str);
      }
    }
    for (;;)
    {
      if (this.a.mServiceDownloadTaskManager != null)
      {
        com.tencent.tmdownloader.internal.storage.a.a().a(paramString1, paramString2);
        if ((paramMap != null) && (paramMap.containsKey(TMAssistantDownloadConst.PARAM_SHOW_NOTIFICATION)))
        {
          str = (String)paramMap.get(TMAssistantDownloadConst.PARAM_SHOW_NOTIFICATION);
          ac.c("TMADownloadSDKService", "startDownloadTask showNotificationStr : " + str);
        }
        try
        {
          if ((!TextUtils.isEmpty(str)) && (Integer.valueOf(str).intValue() == TMAssistantDownloadConst.SHOW_NOTIFICATION_TRUE) && (this.a.mNotificationManager == null))
          {
            this.a.mNotificationManager = com.tencent.tmdownloader.internal.notification.a.a();
            this.a.mNotificationManager.b();
          }
          paramInt = this.a.mServiceDownloadTaskManager.a(paramString1, paramString2, paramInt, paramString3, paramString4, paramMap);
          ac.c("TMADownloadSDKService", "<startDownloadTask>returnValue: " + paramInt);
          ac.c("TMADownloadSDKService", "<startDownloadTask>exit");
          return paramInt;
          ac.c("TMADownloadSDKService", "startDownloadTask params do not cotain notification");
          continue;
          ac.c("TMADownloadSDKService", "startDownloadTask params null");
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ac.c("TMADownloadSDKService", "call startDownload showNotificationStr parse Exception: ", localException);
          }
        }
      }
    }
    ac.c("TMADownloadSDKService", "<startDownloadTask>returnValue: TMAssistantDownloadErrorCode.DownloadSDK_DB_DATA_NOT_READY");
    return 6;
  }
  
  public TMAssistantDownloadTaskInfo a(String paramString1, String paramString2)
  {
    ac.c("TMADownloadSDKService", "<getDownloadTaskInfo>enter");
    if (this.a.mServiceDownloadTaskManager != null)
    {
      paramString1 = this.a.mServiceDownloadTaskManager.a(paramString1, paramString2);
      ac.c("TMADownloadSDKService", "<getDownloadTaskInfo>returnValue: " + paramString1);
      ac.c("TMADownloadSDKService", "<getDownloadTaskInfo>exit");
      return paramString1;
    }
    ac.c("TMADownloadSDKService", "<getDownloadTaskInfo>mServiceDownloadTaskManager is null");
    ac.c("TMADownloadSDKService", "<getDownloadTaskInfo>returnValue: null");
    ac.c("TMADownloadSDKService", "<getDownloadTaskInfo>exit");
    return null;
  }
  
  public List<TMAssistantDownloadTaskInfo> a(String paramString)
  {
    if (this.a.mServiceDownloadTaskManager != null)
    {
      paramString = this.a.mServiceDownloadTaskManager.b(paramString);
      ac.c("TMADownloadSDKService", "<getDownloadTaskInfoByVia>jimluo service return " + paramString);
      return paramString;
    }
    return null;
  }
  
  public void a(int paramInt)
  {
    ac.c("TMADownloadSDKService", "<setServiceSetingMaxTaskNum>enter");
    ac.c("TMADownloadSDKService", "<setServiceSetingMaxTaskNum>maxTaskNum: " + paramInt);
    g.a().a(paramInt);
    ac.c("TMADownloadSDKService", "<setServiceSetingMaxTaskNum>exit");
  }
  
  public void a(String paramString, com.tencent.tmassistant.aidl.a parama)
  {
    ac.c("TMADownloadSDKService", "<registerDownloadTaskCallback>enter");
    ac.c("TMADownloadSDKService", "<registerDownloadTaskCallback>clientKey:" + paramString);
    if ((paramString != null) && (parama != null))
    {
      this.a.mCallbacks.register(parama);
      ac.c("TMADownloadSDKService", "<registerDownloadTaskCallback>register callback");
    }
    try
    {
      this.a.mCallbackHashMap.put(parama, paramString);
      ac.c("TMADownloadSDKService", "<registerDownloadTaskCallback>exit");
      return;
    }
    finally {}
  }
  
  public void a(boolean paramBoolean)
  {
    ac.c("TMADownloadSDKService", "<setServiceSetingIsTaskAutoResume>enter");
    ac.c("TMADownloadSDKService", "<setServiceSetingIsTaskAutoResume>isTaskAutoResume: " + paramBoolean);
    g.a().a(paramBoolean);
    ac.c("TMADownloadSDKService", "<setServiceSetingIsTaskAutoResume>exit");
  }
  
  public void b(String paramString, com.tencent.tmassistant.aidl.a parama)
  {
    ac.c("TMADownloadSDKService", "<unregisterDownloadTaskCallback>enter");
    ac.c("TMADownloadSDKService", "<unregisterDownloadTaskCallback>clientKey:" + paramString);
    if ((paramString != null) && (parama != null))
    {
      this.a.mCallbacks.unregister(parama);
      ac.c("TMADownloadSDKService", "<unregisterDownloadTaskCallback>unregister callback");
    }
    try
    {
      this.a.mCallbackHashMap.remove(parama);
      ac.c("TMADownloadSDKService", "<unregisterDownloadTaskCallback>exit");
      return;
    }
    finally {}
  }
  
  public void b(String paramString1, String paramString2)
  {
    ac.c("TMADownloadSDKService", "<pauseDownloadTask>enter");
    ac.c("TMADownloadSDKService", "<pauseDownloadTask>clientkey:" + paramString1 + ",url:" + paramString2);
    try
    {
      if (this.a.mServiceDownloadTaskManager != null)
      {
        this.a.mServiceDownloadTaskManager.b(paramString1, paramString2);
        ac.c("TMADownloadSDKService", "<pauseDownloadTask>pauseDownload");
      }
      ac.c("TMADownloadSDKService", "<pauseDownloadTask>exit");
      return;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        ac.c("TMADownloadSDKService", "<pauseDownloadTask>exception: ", paramString1);
        paramString1.printStackTrace();
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    ac.c("TMADownloadSDKService", "<setServiceSetingIsDownloadWifiOnly>enter");
    ac.c("TMADownloadSDKService", "<setServiceSetingIsDownloadWifiOnly>isDownloadWifiOnly: " + paramBoolean);
    g.a().b(paramBoolean);
    ac.c("TMADownloadSDKService", "<setServiceSetingIsDownloadWifiOnly>exit");
  }
  
  public boolean b()
  {
    ac.c("TMADownloadSDKService", "<isAllDownloadFinished>enter");
    boolean bool = ApkDownloadManager.getInstance().isAllDownloadFinished().booleanValue();
    ac.c("TMADownloadSDKService", "<isAllDownloadFinished>returnValue: " + bool);
    ac.c("TMADownloadSDKService", "<isAllDownloadFinished>exit");
    return bool;
  }
  
  public void c()
  {
    if (TMAssistantDownloadService.access$100(this.a) == null)
    {
      ac.c("TMADownloadSDKService", "Enter openLogListener ");
      TMAssistantDownloadService.access$102(this.a, new z(this));
      ac.a(TMAssistantDownloadService.access$100(this.a));
    }
  }
  
  public void c(String paramString1, String paramString2)
  {
    ac.c("TMADownloadSDKService", "<cancelDownloadTask>enter");
    ac.c("TMADownloadSDKService", "<cancelDownloadTask>clientkey:" + paramString1 + ",url:" + paramString2);
    if (this.a.mServiceDownloadTaskManager != null)
    {
      this.a.mServiceDownloadTaskManager.c(paramString1, paramString2);
      ac.c("TMADownloadSDKService", "<cancelDownloadTask>cancelDownload");
    }
    ac.c("TMADownloadSDKService", "<cancelDownloadTask>exit");
  }
  
  public void d()
  {
    if (TMAssistantDownloadService.access$100(this.a) != null)
    {
      ac.b(TMAssistantDownloadService.access$100(this.a));
      TMAssistantDownloadService.access$102(this.a, null);
    }
  }
  
  public void d(String paramString1, String paramString2)
  {
    ac.c("TMADownloadSDKService", "<deleteDownloadTask>deleteDownloadTask enter");
    ac.c("TMADownloadSDKService", "<deleteDownloadTask>clientkey:" + paramString1 + ",url:" + paramString2);
    if (this.a.mServiceDownloadTaskManager != null)
    {
      this.a.mServiceDownloadTaskManager.d(paramString1, paramString2);
      ac.c("TMADownloadSDKService", "<deleteDownloadTask>deleteDownloadTask");
    }
    ac.c("TMADownloadSDKService", "<deleteDownloadTask>deleteDownloadTask exit");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.tmdownloader.y
 * JD-Core Version:    0.7.0.1
 */