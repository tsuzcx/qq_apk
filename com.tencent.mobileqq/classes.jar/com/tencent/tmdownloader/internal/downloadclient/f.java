package com.tencent.tmdownloader.internal.downloadclient;

import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import com.tencent.tmassistantbase.util.ab;
import com.tencent.tmassistantsdk.internal.b.b;
import com.tencent.tmassistantsdk.internal.openSDK.param.a;
import com.tencent.tmassistantsdk.internal.openSDK.param.jce.SubScribeSDKDownloadTaskByViaRequest;
import com.tencent.tmassistantsdk.internal.openSDK.param.jce.SyncSDKDownloadTaskRequest;
import com.tencent.tmdownloader.e;
import com.tencent.tmdownloader.u;
import java.util.ArrayList;
import java.util.List;

class f
  implements e
{
  f(c paramc) {}
  
  public void a()
  {
    if (c.b(this.a) != null)
    {
      c.b(this.a).a();
      c.a(this.a, null);
    }
  }
  
  public void a(TMAssistantDownloadTaskInfo paramTMAssistantDownloadTaskInfo)
  {
    ab.c(c.b(), "onSyncSDKDownloadInfo......");
    if (paramTMAssistantDownloadTaskInfo == null) {}
    for (;;)
    {
      return;
      SyncSDKDownloadTaskRequest localSyncSDKDownloadTaskRequest = new SyncSDKDownloadTaskRequest();
      localSyncSDKDownloadTaskRequest.data = a.a(paramTMAssistantDownloadTaskInfo);
      paramTMAssistantDownloadTaskInfo = c.a(localSyncSDKDownloadTaskRequest, "");
      if ((paramTMAssistantDownloadTaskInfo != null) && (paramTMAssistantDownloadTaskInfo.length > 0)) {
        try
        {
          if (c.a(this.a) != null)
          {
            c.a(this.a).b(paramTMAssistantDownloadTaskInfo);
            return;
          }
        }
        catch (Throwable paramTMAssistantDownloadTaskInfo)
        {
          paramTMAssistantDownloadTaskInfo.printStackTrace();
        }
      }
    }
  }
  
  public void a(List<String> paramList, List<TMAssistantDownloadTaskInfo> paramList1)
  {
    SubScribeSDKDownloadTaskByViaRequest localSubScribeSDKDownloadTaskByViaRequest = new SubScribeSDKDownloadTaskByViaRequest();
    localSubScribeSDKDownloadTaskByViaRequest.viaList = ((ArrayList)paramList);
    localSubScribeSDKDownloadTaskByViaRequest.data = ((ArrayList)a.a(paramList1));
    paramList = c.a(localSubScribeSDKDownloadTaskByViaRequest, "");
    if ((paramList != null) && (paramList.length > 0)) {}
    try
    {
      if (c.a(this.a) != null) {
        c.a(this.a).b(paramList);
      }
      return;
    }
    catch (Throwable paramList)
    {
      paramList.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tmdownloader.internal.downloadclient.f
 * JD-Core Version:    0.7.0.1
 */