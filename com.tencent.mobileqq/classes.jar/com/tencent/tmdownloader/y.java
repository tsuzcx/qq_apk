package com.tencent.tmdownloader;

import android.os.RemoteCallbackList;
import android.text.TextUtils;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import com.tencent.tmassistant.aidl.e;
import com.tencent.tmassistantbase.common.TMAssistantDownloadConst;
import com.tencent.tmassistantbase.util.ab;
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
    ab.c("TMADownloadSDKService", "returnValue: 1");
    return 1;
  }
  
  public int a(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, Map paramMap)
  {
    ab.c("TMADownloadSDKService", "<startDownloadTask>enter");
    ab.c("TMADownloadSDKService", "<startDownloadTask>clientkey:" + paramString1 + ",url:" + paramString2 + ",manager:" + this.a.mServiceDownloadTaskManager + ",fileName:" + paramString4);
    String str;
    if (paramMap != null)
    {
      ab.c("TMADownloadSDKService", "startDownloadTask params size : " + paramMap.size());
      if (paramMap.containsKey(TMAssistantDownloadConst.PARAM_SHOW_NOTIFICATION))
      {
        str = (String)paramMap.get(TMAssistantDownloadConst.PARAM_SHOW_NOTIFICATION);
        ab.c("TMADownloadSDKService", "startDownloadTask showNotificationStr : " + str);
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
          ab.c("TMADownloadSDKService", "startDownloadTask showNotificationStr : " + str);
        }
        try
        {
          if ((!TextUtils.isEmpty(str)) && (Integer.valueOf(str).intValue() == TMAssistantDownloadConst.SHOW_NOTIFICATION_TRUE) && (this.a.mNotificationManager == null))
          {
            this.a.mNotificationManager = com.tencent.tmdownloader.internal.notification.a.a();
            this.a.mNotificationManager.b();
          }
          paramInt = this.a.mServiceDownloadTaskManager.a(paramString1, paramString2, paramInt, paramString3, paramString4, paramMap);
          ab.c("TMADownloadSDKService", "<startDownloadTask>returnValue: " + paramInt);
          ab.c("TMADownloadSDKService", "<startDownloadTask>exit");
          return paramInt;
          ab.c("TMADownloadSDKService", "startDownloadTask params do not cotain notification");
          continue;
          ab.c("TMADownloadSDKService", "startDownloadTask params null");
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ab.c("TMADownloadSDKService", "call startDownload showNotificationStr parse Exception: ", localException);
          }
        }
      }
    }
    ab.c("TMADownloadSDKService", "<startDownloadTask>returnValue: TMAssistantDownloadErrorCode.DownloadSDK_DB_DATA_NOT_READY");
    return 6;
  }
  
  public TMAssistantDownloadTaskInfo a(String paramString1, String paramString2)
  {
    ab.c("TMADownloadSDKService", "<getDownloadTaskInfo>enter");
    if (this.a.mServiceDownloadTaskManager != null)
    {
      paramString1 = this.a.mServiceDownloadTaskManager.a(paramString1, paramString2);
      ab.c("TMADownloadSDKService", "<getDownloadTaskInfo>returnValue: " + paramString1);
      ab.c("TMADownloadSDKService", "<getDownloadTaskInfo>exit");
      return paramString1;
    }
    ab.c("TMADownloadSDKService", "<getDownloadTaskInfo>mServiceDownloadTaskManager is null");
    ab.c("TMADownloadSDKService", "<getDownloadTaskInfo>returnValue: null");
    ab.c("TMADownloadSDKService", "<getDownloadTaskInfo>exit");
    return null;
  }
  
  public List<TMAssistantDownloadTaskInfo> a(String paramString)
  {
    if (this.a.mServiceDownloadTaskManager != null)
    {
      paramString = this.a.mServiceDownloadTaskManager.b(paramString);
      ab.c("TMADownloadSDKService", "<getDownloadTaskInfoByVia>jimluo service return " + paramString);
      return paramString;
    }
    return null;
  }
  
  public void a(int paramInt)
  {
    ab.c("TMADownloadSDKService", "<setServiceSetingMaxTaskNum>enter");
    ab.c("TMADownloadSDKService", "<setServiceSetingMaxTaskNum>maxTaskNum: " + paramInt);
    g.a().a(paramInt);
    ab.c("TMADownloadSDKService", "<setServiceSetingMaxTaskNum>exit");
  }
  
  public void a(String paramString, com.tencent.tmassistant.aidl.a parama)
  {
    ab.c("TMADownloadSDKService", "<registerDownloadTaskCallback>enter");
    ab.c("TMADownloadSDKService", "<registerDownloadTaskCallback>clientKey:" + paramString);
    if ((paramString != null) && (parama != null))
    {
      this.a.mCallbacks.register(parama);
      ab.c("TMADownloadSDKService", "<registerDownloadTaskCallback>register callback");
    }
    try
    {
      this.a.mCallbackHashMap.put(parama, paramString);
      ab.c("TMADownloadSDKService", "<registerDownloadTaskCallback>exit");
      return;
    }
    finally {}
  }
  
  public void a(boolean paramBoolean)
  {
    ab.c("TMADownloadSDKService", "<setServiceSetingIsTaskAutoResume>enter");
    ab.c("TMADownloadSDKService", "<setServiceSetingIsTaskAutoResume>isTaskAutoResume: " + paramBoolean);
    g.a().a(paramBoolean);
    ab.c("TMADownloadSDKService", "<setServiceSetingIsTaskAutoResume>exit");
  }
  
  public void b(String paramString, com.tencent.tmassistant.aidl.a parama)
  {
    ab.c("TMADownloadSDKService", "<unregisterDownloadTaskCallback>enter");
    ab.c("TMADownloadSDKService", "<unregisterDownloadTaskCallback>clientKey:" + paramString);
    if ((paramString != null) && (parama != null))
    {
      this.a.mCallbacks.unregister(parama);
      ab.c("TMADownloadSDKService", "<unregisterDownloadTaskCallback>unregister callback");
    }
    try
    {
      this.a.mCallbackHashMap.remove(parama);
      ab.c("TMADownloadSDKService", "<unregisterDownloadTaskCallback>exit");
      return;
    }
    finally {}
  }
  
  public void b(String paramString1, String paramString2)
  {
    ab.c("TMADownloadSDKService", "<pauseDownloadTask>enter");
    ab.c("TMADownloadSDKService", "<pauseDownloadTask>clientkey:" + paramString1 + ",url:" + paramString2);
    try
    {
      if (this.a.mServiceDownloadTaskManager != null)
      {
        this.a.mServiceDownloadTaskManager.b(paramString1, paramString2);
        ab.c("TMADownloadSDKService", "<pauseDownloadTask>pauseDownload");
      }
      ab.c("TMADownloadSDKService", "<pauseDownloadTask>exit");
      return;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        ab.c("TMADownloadSDKService", "<pauseDownloadTask>exception: ", paramString1);
        paramString1.printStackTrace();
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    ab.c("TMADownloadSDKService", "<setServiceSetingIsDownloadWifiOnly>enter");
    ab.c("TMADownloadSDKService", "<setServiceSetingIsDownloadWifiOnly>isDownloadWifiOnly: " + paramBoolean);
    g.a().b(paramBoolean);
    ab.c("TMADownloadSDKService", "<setServiceSetingIsDownloadWifiOnly>exit");
  }
  
  public boolean b()
  {
    ab.c("TMADownloadSDKService", "<isAllDownloadFinished>enter");
    boolean bool = ApkDownloadManager.getInstance().isAllDownloadFinished().booleanValue();
    ab.c("TMADownloadSDKService", "<isAllDownloadFinished>returnValue: " + bool);
    ab.c("TMADownloadSDKService", "<isAllDownloadFinished>exit");
    return bool;
  }
  
  public void c()
  {
    if (TMAssistantDownloadService.access$100(this.a) == null)
    {
      ab.c("TMADownloadSDKService", "Enter openLogListener ");
      TMAssistantDownloadService.access$102(this.a, new z(this));
      ab.a(TMAssistantDownloadService.access$100(this.a));
    }
  }
  
  public void c(String paramString1, String paramString2)
  {
    ab.c("TMADownloadSDKService", "<cancelDownloadTask>enter");
    ab.c("TMADownloadSDKService", "<cancelDownloadTask>clientkey:" + paramString1 + ",url:" + paramString2);
    if (this.a.mServiceDownloadTaskManager != null)
    {
      this.a.mServiceDownloadTaskManager.c(paramString1, paramString2);
      ab.c("TMADownloadSDKService", "<cancelDownloadTask>cancelDownload");
    }
    ab.c("TMADownloadSDKService", "<cancelDownloadTask>exit");
  }
  
  public void d()
  {
    if (TMAssistantDownloadService.access$100(this.a) != null)
    {
      ab.b(TMAssistantDownloadService.access$100(this.a));
      TMAssistantDownloadService.access$102(this.a, null);
    }
  }
  
  public void d(String paramString1, String paramString2)
  {
    ab.c("TMADownloadSDKService", "<deleteDownloadTask>deleteDownloadTask enter");
    ab.c("TMADownloadSDKService", "<deleteDownloadTask>clientkey:" + paramString1 + ",url:" + paramString2);
    if (this.a.mServiceDownloadTaskManager != null)
    {
      this.a.mServiceDownloadTaskManager.d(paramString1, paramString2);
      ab.c("TMADownloadSDKService", "<deleteDownloadTask>deleteDownloadTask");
    }
    ab.c("TMADownloadSDKService", "<deleteDownloadTask>deleteDownloadTask exit");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.tmdownloader.y
 * JD-Core Version:    0.7.0.1
 */