package com.tencent.tmdownloader;

import android.os.RemoteCallbackList;
import android.text.TextUtils;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import com.tencent.tmassistant.aidl.e;
import com.tencent.tmassistantbase.common.TMAssistantDownloadConst;
import com.tencent.tmassistantbase.util.r;
import com.tencent.tmdownloader.internal.downloadservice.ApkDownloadManager;
import com.tencent.tmdownloader.internal.downloadservice.a.c;
import com.tencent.tmdownloader.internal.downloadservice.g;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class x
  extends e
{
  protected x(TMAssistantDownloadService paramTMAssistantDownloadService) {}
  
  public int a()
  {
    r.c("TMAssistantDownloadSDKService", "returnValue: 1");
    return 1;
  }
  
  public int a(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, Map paramMap)
  {
    r.c("TMAssistantDownloadSDKService", "<startDownloadTask>enter");
    r.c("TMAssistantDownloadSDKService", "<startDownloadTask>clientkey:" + paramString1 + ",url:" + paramString2 + ",manager:" + this.a.mServiceDownloadTaskManager + ",fileName:" + paramString4);
    String str;
    if (paramMap != null)
    {
      r.c("TMAssistantDownloadSDKService", "startDownloadTask params size : " + paramMap.size());
      if (paramMap.containsKey(TMAssistantDownloadConst.PARAM_SHOW_NOTIFICATION))
      {
        str = (String)paramMap.get(TMAssistantDownloadConst.PARAM_SHOW_NOTIFICATION);
        r.c("TMAssistantDownloadSDKService", "startDownloadTask showNotificationStr : " + str);
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
          r.c("TMAssistantDownloadSDKService", "startDownloadTask showNotificationStr : " + str);
        }
        try
        {
          if ((!TextUtils.isEmpty(str)) && (Integer.valueOf(str).intValue() == TMAssistantDownloadConst.SHOW_NOTIFICATION_TRUE) && (this.a.mNotificationManager == null))
          {
            this.a.mNotificationManager = com.tencent.tmdownloader.internal.notification.a.a();
            this.a.mNotificationManager.b();
          }
          paramInt = this.a.mServiceDownloadTaskManager.a(paramString1, paramString2, paramInt, paramString3, paramString4, paramMap);
          r.c("TMAssistantDownloadSDKService", "<startDownloadTask>returnValue: " + paramInt);
          r.c("TMAssistantDownloadSDKService", "<startDownloadTask>exit");
          return paramInt;
          r.c("TMAssistantDownloadSDKService", "startDownloadTask params do not cotain notification");
          continue;
          r.c("TMAssistantDownloadSDKService", "startDownloadTask params null");
        }
        catch (Exception localException)
        {
          for (;;)
          {
            r.c("TMAssistantDownloadSDKService", "call startDownload showNotificationStr parse Exception: ", localException);
          }
        }
      }
    }
    r.c("TMAssistantDownloadSDKService", "<startDownloadTask>returnValue: TMAssistantDownloadErrorCode.DownloadSDK_START_FAILED_PARAMETERS_INVALID");
    r.c("TMAssistantDownloadSDKService", "<startDownloadTask>exit");
    return 3;
  }
  
  public TMAssistantDownloadTaskInfo a(String paramString1, String paramString2)
  {
    r.c("TMAssistantDownloadSDKService", "<getDownloadTaskInfo>enter");
    if (this.a.mServiceDownloadTaskManager != null)
    {
      paramString1 = this.a.mServiceDownloadTaskManager.a(paramString1, paramString2);
      r.c("TMAssistantDownloadSDKService", "<getDownloadTaskInfo>returnValue: " + paramString1);
      r.c("TMAssistantDownloadSDKService", "<getDownloadTaskInfo>exit");
      return paramString1;
    }
    r.c("TMAssistantDownloadSDKService", "<getDownloadTaskInfo>mServiceDownloadTaskManager is null");
    r.c("TMAssistantDownloadSDKService", "<getDownloadTaskInfo>returnValue: null");
    r.c("TMAssistantDownloadSDKService", "<getDownloadTaskInfo>exit");
    return null;
  }
  
  public List<TMAssistantDownloadTaskInfo> a(String paramString)
  {
    if (this.a.mServiceDownloadTaskManager != null)
    {
      paramString = this.a.mServiceDownloadTaskManager.b(paramString);
      r.c("TMAssistantDownloadSDKService", "<getDownloadTaskInfoByVia>jimluo service return " + paramString);
      return paramString;
    }
    return null;
  }
  
  public void a(int paramInt)
  {
    r.c("TMAssistantDownloadSDKService", "<setServiceSetingMaxTaskNum>enter");
    r.c("TMAssistantDownloadSDKService", "<setServiceSetingMaxTaskNum>maxTaskNum: " + paramInt);
    g.a().a(paramInt);
    r.c("TMAssistantDownloadSDKService", "<setServiceSetingMaxTaskNum>exit");
  }
  
  public void a(String paramString, com.tencent.tmassistant.aidl.a parama)
  {
    r.c("TMAssistantDownloadSDKService", "<registerDownloadTaskCallback>enter");
    r.c("TMAssistantDownloadSDKService", "<registerDownloadTaskCallback>clientKey:" + paramString);
    if ((paramString != null) && (parama != null))
    {
      this.a.mCallbacks.register(parama);
      r.c("TMAssistantDownloadSDKService", "<registerDownloadTaskCallback>register callback");
    }
    try
    {
      this.a.mCallbackHashMap.put(parama, paramString);
      r.c("TMAssistantDownloadSDKService", "<registerDownloadTaskCallback>exit");
      return;
    }
    finally {}
  }
  
  public void a(boolean paramBoolean)
  {
    r.c("TMAssistantDownloadSDKService", "<setServiceSetingIsTaskAutoResume>enter");
    r.c("TMAssistantDownloadSDKService", "<setServiceSetingIsTaskAutoResume>isTaskAutoResume: " + paramBoolean);
    g.a().a(paramBoolean);
    r.c("TMAssistantDownloadSDKService", "<setServiceSetingIsTaskAutoResume>exit");
  }
  
  public void b(String paramString, com.tencent.tmassistant.aidl.a parama)
  {
    r.c("TMAssistantDownloadSDKService", "<unregisterDownloadTaskCallback>enter");
    r.c("TMAssistantDownloadSDKService", "<unregisterDownloadTaskCallback>clientKey:" + paramString);
    if ((paramString != null) && (parama != null))
    {
      this.a.mCallbacks.unregister(parama);
      r.c("TMAssistantDownloadSDKService", "<unregisterDownloadTaskCallback>unregister callback");
    }
    try
    {
      this.a.mCallbackHashMap.remove(parama);
      r.c("TMAssistantDownloadSDKService", "<unregisterDownloadTaskCallback>exit");
      return;
    }
    finally {}
  }
  
  public void b(String paramString1, String paramString2)
  {
    r.c("TMAssistantDownloadSDKService", "<pauseDownloadTask>enter");
    r.c("TMAssistantDownloadSDKService", "<pauseDownloadTask>clientkey:" + paramString1 + ",url:" + paramString2);
    try
    {
      if (this.a.mServiceDownloadTaskManager != null)
      {
        this.a.mServiceDownloadTaskManager.b(paramString1, paramString2);
        r.c("TMAssistantDownloadSDKService", "<pauseDownloadTask>pauseDownload");
      }
      r.c("TMAssistantDownloadSDKService", "<pauseDownloadTask>exit");
      return;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        r.c("TMAssistantDownloadSDKService", "<pauseDownloadTask>exception: ", paramString1);
        paramString1.printStackTrace();
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    r.c("TMAssistantDownloadSDKService", "<setServiceSetingIsDownloadWifiOnly>enter");
    r.c("TMAssistantDownloadSDKService", "<setServiceSetingIsDownloadWifiOnly>isDownloadWifiOnly: " + paramBoolean);
    g.a().b(paramBoolean);
    r.c("TMAssistantDownloadSDKService", "<setServiceSetingIsDownloadWifiOnly>exit");
  }
  
  public boolean b()
  {
    r.c("TMAssistantDownloadSDKService", "<isAllDownloadFinished>enter");
    boolean bool = ApkDownloadManager.getInstance().isAllDownloadFinished().booleanValue();
    r.c("TMAssistantDownloadSDKService", "<isAllDownloadFinished>returnValue: " + bool);
    r.c("TMAssistantDownloadSDKService", "<isAllDownloadFinished>exit");
    return bool;
  }
  
  public void c()
  {
    if (TMAssistantDownloadService.access$100(this.a) == null)
    {
      r.c("TMAssistantDownloadSDKService", "Enter openLogListener ");
      TMAssistantDownloadService.access$102(this.a, new y(this));
      r.a(TMAssistantDownloadService.access$100(this.a));
    }
  }
  
  public void c(String paramString1, String paramString2)
  {
    r.c("TMAssistantDownloadSDKService", "<cancelDownloadTask>enter");
    r.c("TMAssistantDownloadSDKService", "<cancelDownloadTask>clientkey:" + paramString1 + ",url:" + paramString2);
    if (this.a.mServiceDownloadTaskManager != null)
    {
      this.a.mServiceDownloadTaskManager.c(paramString1, paramString2);
      r.c("TMAssistantDownloadSDKService", "<cancelDownloadTask>cancelDownload");
    }
    r.c("TMAssistantDownloadSDKService", "<cancelDownloadTask>exit");
  }
  
  public void d()
  {
    if (TMAssistantDownloadService.access$100(this.a) != null)
    {
      r.b(TMAssistantDownloadService.access$100(this.a));
      TMAssistantDownloadService.access$102(this.a, null);
    }
  }
  
  public void d(String paramString1, String paramString2)
  {
    r.c("TMAssistantDownloadSDKService", "<deleteDownloadTask>deleteDownloadTask enter");
    r.c("TMAssistantDownloadSDKService", "<deleteDownloadTask>clientkey:" + paramString1 + ",url:" + paramString2);
    if (this.a.mServiceDownloadTaskManager != null)
    {
      this.a.mServiceDownloadTaskManager.d(paramString1, paramString2);
      r.c("TMAssistantDownloadSDKService", "<deleteDownloadTask>deleteDownloadTask");
    }
    r.c("TMAssistantDownloadSDKService", "<deleteDownloadTask>deleteDownloadTask exit");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tmdownloader.x
 * JD-Core Version:    0.7.0.1
 */