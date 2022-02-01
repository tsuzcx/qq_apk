package com.tencent.tmdownloader;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import com.tencent.tmassistantbase.util.ab;
import com.tencent.tmassistantsdk.internal.openSDK.param.jce.BatchSDKDownloadActionResponse;
import com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCSDKDownloadInfo;
import com.tencent.tmassistantsdk.internal.openSDK.param.jce.SubScribeSDKDownloadTaskByViaResponse;
import com.tencent.tmdownloader.internal.downloadservice.a;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class u
  implements ITMAssistantDownloadClientListener
{
  protected ReferenceQueue<e> a;
  protected ArrayList<WeakReference<e>> b;
  private List<TMAssistantDownloadTaskInfo> c = new ArrayList();
  private List<String> d = new ArrayList();
  private TMAssistantDownloadClient e;
  private Context f;
  private String g;
  
  public u(Context paramContext, String paramString)
  {
    ab.c("TMAssistantDownloadQQGameClient", "TMAssistantDownloadQQGameClient init.......");
    this.f = paramContext;
    this.g = paramString;
    if (paramContext != null) {
      b();
    }
    this.a = new ReferenceQueue();
    this.b = new ArrayList();
  }
  
  private TMAssistantDownloadTaskInfo a(String paramString)
  {
    if (paramString != null)
    {
      if (this.c.size() == 0) {
        return null;
      }
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext())
      {
        TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo = (TMAssistantDownloadTaskInfo)localIterator.next();
        if (paramString.equals(localTMAssistantDownloadTaskInfo.mUrl)) {
          return localTMAssistantDownloadTaskInfo;
        }
      }
    }
    return null;
  }
  
  private void a(TMAssistantDownloadTaskInfo paramTMAssistantDownloadTaskInfo)
  {
    ab.c("TMAssistantDownloadQQGameClient", "syncDownloadTaskInfo......");
    if (paramTMAssistantDownloadTaskInfo == null) {
      return;
    }
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      e locale = (e)((WeakReference)localIterator.next()).get();
      if (locale != null) {
        locale.a(paramTMAssistantDownloadTaskInfo);
      }
    }
  }
  
  private void b()
  {
    if (this.e != null) {
      return;
    }
    this.e = new TMAssistantDownloadClient(this.f, this.g);
    if (this.e.initTMAssistantDownloadSDK())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("TMAssistantDownloadQQGameClient registerDownloadTaskListener.......");
      localStringBuilder.append(this.e);
      ab.c("TMAssistantDownloadQQGameClient", localStringBuilder.toString());
      this.e.registerDownloadTaskListener(this);
      return;
    }
    this.e = null;
  }
  
  private void b(TMAssistantDownloadTaskInfo paramTMAssistantDownloadTaskInfo)
  {
    if (paramTMAssistantDownloadTaskInfo == null) {
      return;
    }
    if (paramTMAssistantDownloadTaskInfo.mState != 4) {
      return;
    }
    if (TextUtils.isEmpty(paramTMAssistantDownloadTaskInfo.mSavePath)) {
      return;
    }
    a.a(paramTMAssistantDownloadTaskInfo.mSavePath);
  }
  
  private boolean b(String paramString)
  {
    try
    {
      Intent localIntent2 = this.f.getPackageManager().getLaunchIntentForPackage(paramString);
      Intent localIntent1 = localIntent2;
      if (localIntent2 == null)
      {
        localIntent1 = localIntent2;
        if (this.f.getPackageManager().getPackageInfo(paramString, 1) != null) {
          localIntent1 = new Intent(paramString);
        }
      }
      if (localIntent1 != null)
      {
        localIntent1.setFlags(268435456);
        this.f.startActivity(localIntent1);
        return true;
      }
    }
    catch (Exception paramString)
    {
      label65:
      break label65;
    }
    return false;
  }
  
  private void c(List<TMAssistantDownloadTaskInfo> paramList)
  {
    if (paramList == null) {
      return;
    }
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      e locale = (e)((WeakReference)localIterator.next()).get();
      if (locale != null) {
        locale.a(this.d, paramList);
      }
    }
  }
  
  public List<TMAssistantDownloadTaskInfo> a(List<String> paramList)
  {
    if (paramList == null) {}
    try
    {
      paramList = this.c;
      return paramList;
    }
    finally
    {
      break label125;
    }
    this.d.clear();
    this.d.addAll(paramList);
    this.c.clear();
    paramList = this.d.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (String)paramList.next();
      localObject = this.e.getDownloadTaskInfosByVia((String)localObject);
      if (localObject != null) {
        this.c.addAll((Collection)localObject);
      }
    }
    c(this.c);
    paramList = this.c;
    return paramList;
    label125:
    for (;;)
    {
      throw paramList;
    }
  }
  
  public void a()
  {
    TMAssistantDownloadClient localTMAssistantDownloadClient = this.e;
    if (localTMAssistantDownloadClient != null)
    {
      localTMAssistantDownloadClient.unInitTMAssistantDownloadSDK();
      this.e = null;
    }
  }
  
  public void a(BatchSDKDownloadActionResponse paramBatchSDKDownloadActionResponse)
  {
    try
    {
      if (this.e == null) {
        b();
      }
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("batchDownloadTaskAction downloadClient:");
      ((StringBuilder)localObject1).append(this.e);
      ab.c("TMAssistantDownloadQQGameClient", ((StringBuilder)localObject1).toString());
      if (paramBatchSDKDownloadActionResponse == null) {
        return;
      }
      Object localObject2;
      switch (paramBatchSDKDownloadActionResponse.batchRequestType)
      {
      case 6: 
        paramBatchSDKDownloadActionResponse = paramBatchSDKDownloadActionResponse.batchData.iterator();
        while (paramBatchSDKDownloadActionResponse.hasNext())
        {
          localObject1 = (IPCSDKDownloadInfo)paramBatchSDKDownloadActionResponse.next();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("batchDownloadTaskAction open package:");
          ((StringBuilder)localObject2).append(((IPCSDKDownloadInfo)localObject1).packageName);
          ab.c("TMAssistantDownloadQQGameClient", ((StringBuilder)localObject2).toString());
          if (!TextUtils.isEmpty(((IPCSDKDownloadInfo)localObject1).packageName)) {
            b(((IPCSDKDownloadInfo)localObject1).packageName);
          }
        }
      case 5: 
        paramBatchSDKDownloadActionResponse = paramBatchSDKDownloadActionResponse.batchData.iterator();
        while (paramBatchSDKDownloadActionResponse.hasNext())
        {
          localObject1 = (IPCSDKDownloadInfo)paramBatchSDKDownloadActionResponse.next();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("batchDownloadTaskAction install package:");
          ((StringBuilder)localObject2).append(((IPCSDKDownloadInfo)localObject1).packageName);
          ab.c("TMAssistantDownloadQQGameClient", ((StringBuilder)localObject2).toString());
          b(this.e.getDownloadTaskState(((IPCSDKDownloadInfo)localObject1).url));
        }
      case 4: 
        paramBatchSDKDownloadActionResponse = paramBatchSDKDownloadActionResponse.batchData.iterator();
        while (paramBatchSDKDownloadActionResponse.hasNext())
        {
          localObject1 = (IPCSDKDownloadInfo)paramBatchSDKDownloadActionResponse.next();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("batchDownloadTaskAction delete url:");
          ((StringBuilder)localObject2).append(((IPCSDKDownloadInfo)localObject1).url);
          ab.c("TMAssistantDownloadQQGameClient", ((StringBuilder)localObject2).toString());
          this.e.deleteDownloadTask(((IPCSDKDownloadInfo)localObject1).url);
        }
      case 3: 
        paramBatchSDKDownloadActionResponse = paramBatchSDKDownloadActionResponse.batchData.iterator();
        while (paramBatchSDKDownloadActionResponse.hasNext())
        {
          localObject1 = (IPCSDKDownloadInfo)paramBatchSDKDownloadActionResponse.next();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("batchDownloadTaskAction cancel url:");
          ((StringBuilder)localObject2).append(((IPCSDKDownloadInfo)localObject1).url);
          ab.c("TMAssistantDownloadQQGameClient", ((StringBuilder)localObject2).toString());
          this.e.cancelDownloadTask(((IPCSDKDownloadInfo)localObject1).url);
        }
      case 2: 
        paramBatchSDKDownloadActionResponse = paramBatchSDKDownloadActionResponse.batchData.iterator();
        while (paramBatchSDKDownloadActionResponse.hasNext())
        {
          localObject1 = (IPCSDKDownloadInfo)paramBatchSDKDownloadActionResponse.next();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("batchDownloadTaskAction PAUSE url:");
          ((StringBuilder)localObject2).append(((IPCSDKDownloadInfo)localObject1).url);
          ab.c("TMAssistantDownloadQQGameClient", ((StringBuilder)localObject2).toString());
          this.e.pauseDownloadTask(((IPCSDKDownloadInfo)localObject1).url);
        }
      case 1: 
        paramBatchSDKDownloadActionResponse = paramBatchSDKDownloadActionResponse.batchData.iterator();
        while (paramBatchSDKDownloadActionResponse.hasNext())
        {
          localObject1 = (IPCSDKDownloadInfo)paramBatchSDKDownloadActionResponse.next();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("batchDownloadTaskAction start url:");
          ((StringBuilder)localObject2).append(((IPCSDKDownloadInfo)localObject1).url);
          ab.c("TMAssistantDownloadQQGameClient", ((StringBuilder)localObject2).toString());
          localObject2 = new HashMap();
          this.e.startDownloadTask(((IPCSDKDownloadInfo)localObject1).url, "application/vnd.android.package-archive", (Map)localObject2);
        }
      }
    }
    finally
    {
      for (;;)
      {
        for (;;)
        {
          throw paramBatchSDKDownloadActionResponse;
        }
      }
    }
    ab.c("TMAssistantDownloadQQGameClient", "batchDownloadTaskAction undo anythings......");
  }
  
  public void a(SubScribeSDKDownloadTaskByViaResponse paramSubScribeSDKDownloadTaskByViaResponse)
  {
    if (this.e == null) {
      b();
    }
    if (paramSubScribeSDKDownloadTaskByViaResponse.subscribeType == 1)
    {
      a(paramSubScribeSDKDownloadTaskByViaResponse.viaList);
      return;
    }
    b(paramSubScribeSDKDownloadTaskByViaResponse.viaList);
  }
  
  public boolean a(e parame)
  {
    try
    {
      ab.c("TMAssistantDownloadQQGameClient", "enter");
      if (parame == null)
      {
        ab.c("TMAssistantDownloadQQGameClient", "listener == null");
        ab.c("TMAssistantDownloadQQGameClient", "returnValue: false");
        ab.c("TMAssistantDownloadQQGameClient", "exit");
        return false;
      }
      for (;;)
      {
        localObject = this.a.poll();
        if (localObject == null) {
          break;
        }
        ab.c("TMAssistantDownloadQQGameClient", "registerDownloadTaskListener removed listener!!!!");
        this.b.remove(localObject);
      }
      Object localObject = this.b.iterator();
      while (((Iterator)localObject).hasNext()) {
        if ((e)((WeakReference)((Iterator)localObject).next()).get() == parame)
        {
          ab.c("TMAssistantDownloadQQGameClient", "returnValue: true");
          ab.c("TMAssistantDownloadQQGameClient", "exit");
          return true;
        }
      }
      parame = new WeakReference(parame, this.a);
      this.b.add(parame);
      ab.c("TMAssistantDownloadQQGameClient", "returnValue: true");
      ab.c("TMAssistantDownloadQQGameClient", "exit");
      return true;
    }
    finally {}
    for (;;)
    {
      throw parame;
    }
  }
  
  public void b(List<String> paramList)
  {
    if (paramList != null) {
      try
      {
        if (paramList.size() != 0)
        {
          this.d.removeAll(paramList);
          ArrayList localArrayList = new ArrayList();
          Iterator localIterator = this.c.iterator();
          while (localIterator.hasNext())
          {
            TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo = (TMAssistantDownloadTaskInfo)localIterator.next();
            if (paramList.contains(localTMAssistantDownloadTaskInfo.mVia)) {
              localArrayList.add(localTMAssistantDownloadTaskInfo);
            }
          }
          this.c.removeAll(localArrayList);
          return;
        }
      }
      finally {}
    }
  }
  
  public void onDownloadSDKTaskProgressChanged(TMAssistantDownloadClient paramTMAssistantDownloadClient, String paramString, long paramLong1, long paramLong2)
  {
    ab.c("jimluo", "OnDownloadSDKTaskProgressChanged......");
    paramTMAssistantDownloadClient = a(paramString);
    if (paramTMAssistantDownloadClient != null)
    {
      ab.c("jimluo", "OnDownloadSDKTaskProgressChanged taskInfo is null......");
      paramTMAssistantDownloadClient.mReceiveDataLen = paramLong1;
      paramTMAssistantDownloadClient.mTotalDataLen = paramLong2;
      a(paramTMAssistantDownloadClient);
      return;
    }
    try
    {
      paramTMAssistantDownloadClient = this.e.getDownloadTaskState(paramString);
      if (paramTMAssistantDownloadClient != null)
      {
        a(paramTMAssistantDownloadClient);
        return;
      }
    }
    catch (Exception paramTMAssistantDownloadClient)
    {
      paramTMAssistantDownloadClient.printStackTrace();
    }
  }
  
  public void onDownloadSDKTaskStateChanged(TMAssistantDownloadClient paramTMAssistantDownloadClient, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    ab.c("TMAssistantDownloadQQGameClient", "OnDownloadSDKTaskStateChanged......");
    paramTMAssistantDownloadClient = a(paramString1);
    if (paramTMAssistantDownloadClient != null)
    {
      paramTMAssistantDownloadClient.mState = paramInt1;
      a(paramTMAssistantDownloadClient);
      return;
    }
    try
    {
      paramTMAssistantDownloadClient = this.e.getDownloadTaskState(paramString1);
      if (paramTMAssistantDownloadClient != null)
      {
        a(paramTMAssistantDownloadClient);
        return;
      }
    }
    catch (Exception paramTMAssistantDownloadClient)
    {
      paramTMAssistantDownloadClient.printStackTrace();
    }
  }
  
  public void onDwonloadSDKServiceInvalid(TMAssistantDownloadClient paramTMAssistantDownloadClient)
  {
    paramTMAssistantDownloadClient = this.b.iterator();
    while (paramTMAssistantDownloadClient.hasNext())
    {
      e locale = (e)((WeakReference)paramTMAssistantDownloadClient.next()).get();
      if (locale != null) {
        locale.a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmdownloader.u
 * JD-Core Version:    0.7.0.1
 */