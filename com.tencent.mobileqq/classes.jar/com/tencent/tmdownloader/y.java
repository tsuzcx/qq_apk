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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("<startDownloadTask>clientkey:");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(",url:");
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append(",manager:");
    ((StringBuilder)localObject).append(this.a.mServiceDownloadTaskManager);
    ((StringBuilder)localObject).append(",fileName:");
    ((StringBuilder)localObject).append(paramString4);
    ab.c("TMADownloadSDKService", ((StringBuilder)localObject).toString());
    StringBuilder localStringBuilder;
    if (paramMap != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("startDownloadTask params size : ");
      ((StringBuilder)localObject).append(paramMap.size());
      ab.c("TMADownloadSDKService", ((StringBuilder)localObject).toString());
      if (paramMap.containsKey(TMAssistantDownloadConst.PARAM_SHOW_NOTIFICATION))
      {
        localObject = (String)paramMap.get(TMAssistantDownloadConst.PARAM_SHOW_NOTIFICATION);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("startDownloadTask showNotificationStr : ");
        localStringBuilder.append((String)localObject);
        ab.c("TMADownloadSDKService", localStringBuilder.toString());
      }
      else
      {
        ab.c("TMADownloadSDKService", "startDownloadTask params do not cotain notification");
      }
    }
    else
    {
      ab.c("TMADownloadSDKService", "startDownloadTask params null");
    }
    if (this.a.mServiceDownloadTaskManager != null)
    {
      com.tencent.tmdownloader.internal.storage.a.a().a(paramString1, paramString2);
      if ((paramMap != null) && (paramMap.containsKey(TMAssistantDownloadConst.PARAM_SHOW_NOTIFICATION)))
      {
        localObject = (String)paramMap.get(TMAssistantDownloadConst.PARAM_SHOW_NOTIFICATION);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("startDownloadTask showNotificationStr : ");
        localStringBuilder.append((String)localObject);
        ab.c("TMADownloadSDKService", localStringBuilder.toString());
        try
        {
          if ((!TextUtils.isEmpty((CharSequence)localObject)) && (Integer.valueOf((String)localObject).intValue() == TMAssistantDownloadConst.SHOW_NOTIFICATION_TRUE) && (this.a.mNotificationManager == null))
          {
            this.a.mNotificationManager = com.tencent.tmdownloader.internal.notification.a.a();
            this.a.mNotificationManager.b();
          }
        }
        catch (Exception localException)
        {
          ab.c("TMADownloadSDKService", "call startDownload showNotificationStr parse Exception: ", localException);
        }
      }
      paramInt = this.a.mServiceDownloadTaskManager.a(paramString1, paramString2, paramInt, paramString3, paramString4, paramMap);
      paramString1 = new StringBuilder();
      paramString1.append("<startDownloadTask>returnValue: ");
      paramString1.append(paramInt);
      ab.c("TMADownloadSDKService", paramString1.toString());
      ab.c("TMADownloadSDKService", "<startDownloadTask>exit");
      return paramInt;
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
      paramString2 = new StringBuilder();
      paramString2.append("<getDownloadTaskInfo>returnValue: ");
      paramString2.append(paramString1);
      ab.c("TMADownloadSDKService", paramString2.toString());
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("<getDownloadTaskInfoByVia>jimluo service return ");
      localStringBuilder.append(paramString);
      ab.c("TMADownloadSDKService", localStringBuilder.toString());
      return paramString;
    }
    return null;
  }
  
  public void a(int paramInt)
  {
    ab.c("TMADownloadSDKService", "<setServiceSetingMaxTaskNum>enter");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<setServiceSetingMaxTaskNum>maxTaskNum: ");
    localStringBuilder.append(paramInt);
    ab.c("TMADownloadSDKService", localStringBuilder.toString());
    g.a().a(paramInt);
    ab.c("TMADownloadSDKService", "<setServiceSetingMaxTaskNum>exit");
  }
  
  public void a(String paramString, com.tencent.tmassistant.aidl.a parama)
  {
    ab.c("TMADownloadSDKService", "<registerDownloadTaskCallback>enter");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<registerDownloadTaskCallback>clientKey:");
    localStringBuilder.append(paramString);
    ab.c("TMADownloadSDKService", localStringBuilder.toString());
    if ((paramString != null) && (parama != null))
    {
      this.a.mCallbacks.register(parama);
      ab.c("TMADownloadSDKService", "<registerDownloadTaskCallback>register callback");
      try
      {
        this.a.mCallbackHashMap.put(parama, paramString);
      }
      finally {}
    }
    ab.c("TMADownloadSDKService", "<registerDownloadTaskCallback>exit");
  }
  
  public void a(boolean paramBoolean)
  {
    ab.c("TMADownloadSDKService", "<setServiceSetingIsTaskAutoResume>enter");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<setServiceSetingIsTaskAutoResume>isTaskAutoResume: ");
    localStringBuilder.append(paramBoolean);
    ab.c("TMADownloadSDKService", localStringBuilder.toString());
    g.a().a(paramBoolean);
    ab.c("TMADownloadSDKService", "<setServiceSetingIsTaskAutoResume>exit");
  }
  
  public void b(String paramString, com.tencent.tmassistant.aidl.a parama)
  {
    ab.c("TMADownloadSDKService", "<unregisterDownloadTaskCallback>enter");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<unregisterDownloadTaskCallback>clientKey:");
    localStringBuilder.append(paramString);
    ab.c("TMADownloadSDKService", localStringBuilder.toString());
    if ((paramString != null) && (parama != null))
    {
      this.a.mCallbacks.unregister(parama);
      ab.c("TMADownloadSDKService", "<unregisterDownloadTaskCallback>unregister callback");
      try
      {
        this.a.mCallbackHashMap.remove(parama);
      }
      finally {}
    }
    ab.c("TMADownloadSDKService", "<unregisterDownloadTaskCallback>exit");
  }
  
  public void b(String paramString1, String paramString2)
  {
    ab.c("TMADownloadSDKService", "<pauseDownloadTask>enter");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<pauseDownloadTask>clientkey:");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(",url:");
    localStringBuilder.append(paramString2);
    ab.c("TMADownloadSDKService", localStringBuilder.toString());
    try
    {
      if (this.a.mServiceDownloadTaskManager != null)
      {
        this.a.mServiceDownloadTaskManager.b(paramString1, paramString2);
        ab.c("TMADownloadSDKService", "<pauseDownloadTask>pauseDownload");
      }
    }
    catch (Exception paramString1)
    {
      ab.c("TMADownloadSDKService", "<pauseDownloadTask>exception: ", paramString1);
      paramString1.printStackTrace();
    }
    ab.c("TMADownloadSDKService", "<pauseDownloadTask>exit");
  }
  
  public void b(boolean paramBoolean)
  {
    ab.c("TMADownloadSDKService", "<setServiceSetingIsDownloadWifiOnly>enter");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<setServiceSetingIsDownloadWifiOnly>isDownloadWifiOnly: ");
    localStringBuilder.append(paramBoolean);
    ab.c("TMADownloadSDKService", localStringBuilder.toString());
    g.a().b(paramBoolean);
    ab.c("TMADownloadSDKService", "<setServiceSetingIsDownloadWifiOnly>exit");
  }
  
  public boolean b()
  {
    ab.c("TMADownloadSDKService", "<isAllDownloadFinished>enter");
    boolean bool = ApkDownloadManager.getInstance().isAllDownloadFinished().booleanValue();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<isAllDownloadFinished>returnValue: ");
    localStringBuilder.append(bool);
    ab.c("TMADownloadSDKService", localStringBuilder.toString());
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<cancelDownloadTask>clientkey:");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(",url:");
    localStringBuilder.append(paramString2);
    ab.c("TMADownloadSDKService", localStringBuilder.toString());
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<deleteDownloadTask>clientkey:");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(",url:");
    localStringBuilder.append(paramString2);
    ab.c("TMADownloadSDKService", localStringBuilder.toString());
    if (this.a.mServiceDownloadTaskManager != null)
    {
      this.a.mServiceDownloadTaskManager.d(paramString1, paramString2);
      ab.c("TMADownloadSDKService", "<deleteDownloadTask>deleteDownloadTask");
    }
    ab.c("TMADownloadSDKService", "<deleteDownloadTask>deleteDownloadTask exit");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmdownloader.y
 * JD-Core Version:    0.7.0.1
 */