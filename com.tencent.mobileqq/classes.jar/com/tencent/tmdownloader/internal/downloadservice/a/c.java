package com.tencent.tmdownloader.internal.downloadservice.a;

import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import com.tencent.tmassistantbase.util.ab;
import com.tencent.tmdownloader.internal.downloadservice.ApkDownloadManager;
import com.tencent.tmdownloader.internal.downloadservice.h;
import com.tencent.tmdownloader.internal.storage.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class c
  implements h
{
  protected List<b> a = Collections.synchronizedList(new ArrayList());
  protected a b = null;
  
  public c(ArrayList<b> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0)) {
      synchronized (this.a)
      {
        this.a.addAll(paramArrayList);
        return;
      }
    }
  }
  
  private TMAssistantDownloadTaskInfo a(com.tencent.tmdownloader.internal.downloadservice.c paramc)
  {
    if (paramc == null) {
      return null;
    }
    TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo = new TMAssistantDownloadTaskInfo(paramc.b, d.a(paramc.j), paramc.g, paramc.h, paramc.i, paramc.a);
    localTMAssistantDownloadTaskInfo.mAppId = paramc.q;
    localTMAssistantDownloadTaskInfo.mTaskPackageName = paramc.r;
    localTMAssistantDownloadTaskInfo.mTaskVersionCode = paramc.s;
    localTMAssistantDownloadTaskInfo.mIconUrl = paramc.D;
    localTMAssistantDownloadTaskInfo.mAppName = paramc.E;
    localTMAssistantDownloadTaskInfo.mVia = paramc.x;
    localTMAssistantDownloadTaskInfo.mChannelid = paramc.y;
    localTMAssistantDownloadTaskInfo.mStartTime = paramc.t;
    localTMAssistantDownloadTaskInfo.mEndTime = paramc.u;
    localTMAssistantDownloadTaskInfo.showNotification = paramc.K;
    localTMAssistantDownloadTaskInfo.isAutoInstallBySDK = paramc.F;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TMAssistantDownloadTaskInfo pkg is: ");
    localStringBuilder.append(localTMAssistantDownloadTaskInfo.mTaskPackageName);
    localStringBuilder.append(", mAppName is: ");
    localStringBuilder.append(localTMAssistantDownloadTaskInfo.mAppName);
    localStringBuilder.append(" dt mAppName is: ");
    localStringBuilder.append(paramc.E);
    localStringBuilder.append(", isAutoInstallBySDK is: ");
    localStringBuilder.append(localTMAssistantDownloadTaskInfo.isAutoInstallBySDK);
    ab.c("ServiceDownloadTaskManager", localStringBuilder.toString());
    return localTMAssistantDownloadTaskInfo;
  }
  
  private List<TMAssistantDownloadTaskInfo> a(List<com.tencent.tmdownloader.internal.downloadservice.c> paramList)
  {
    if (paramList == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(a((com.tencent.tmdownloader.internal.downloadservice.c)paramList.next()));
    }
    return localArrayList;
  }
  
  public int a(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, Map<String, String> paramMap)
  {
    if ((paramString1 != null) && (paramString2 != null))
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("clientKey:");
      ((StringBuilder)localObject1).append(paramString1);
      ab.c("ServiceDownloadTaskManager", ((StringBuilder)localObject1).toString());
      if (e(paramString1, paramString2) != null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("clientKey:");
        ((StringBuilder)localObject1).append(paramString1);
        ((StringBuilder)localObject1).append(",taskItem is not null");
        ab.c("ServiceDownloadTaskManager", ((StringBuilder)localObject1).toString());
        return ApkDownloadManager.getInstance().startDownload(paramString2, paramInt, paramString3, paramString4, paramMap);
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("clientKey:");
      ((StringBuilder)localObject1).append(paramString1);
      ((StringBuilder)localObject1).append(",taskItem is null");
      ab.c("ServiceDownloadTaskManager", ((StringBuilder)localObject1).toString());
      Object localObject2 = c(paramString2);
      localObject1 = new b(paramString1, paramString2);
      ((b)localObject1).c = 1;
      synchronized (this.a)
      {
        this.a.add(localObject1);
        ??? = new StringBuilder();
        ((StringBuilder)???).append("clientKey:");
        ((StringBuilder)???).append(paramString1);
        ((StringBuilder)???).append(",add newTask");
        ab.c("ServiceDownloadTaskManager", ((StringBuilder)???).toString());
        localObject2 = ((ArrayList)localObject2).iterator();
        int j = 0;
        int i = 0;
        while (((Iterator)localObject2).hasNext())
        {
          ??? = (b)((Iterator)localObject2).next();
          if (((b)???).c == 2) {
            j = 1;
          } else if (((b)???).c == 1) {
            i = 1;
          }
        }
        if ((j != 1) && (i != 1))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("clientKey:");
          ((StringBuilder)localObject1).append(paramString1);
          ((StringBuilder)localObject1).append(",start newTask download");
          ab.c("ServiceDownloadTaskManager", ((StringBuilder)localObject1).toString());
          return ApkDownloadManager.getInstance().startDownload(paramString2, paramInt, paramString3, paramString4, paramMap);
        }
        if (j == 1) {
          ((b)localObject1).c = 2;
        } else if (i == 1) {
          ((b)localObject1).c = 1;
        }
        paramString3 = this.b;
        if (paramString3 != null) {
          paramString3.OnDownloadStateChanged(paramString1, paramString2, ((b)localObject1).c, 0, null);
        }
        paramString2 = new StringBuilder();
        paramString2.append("clientKey:");
        paramString2.append(paramString1);
        paramString2.append(",newTask is downloading");
        ab.c("ServiceDownloadTaskManager", paramString2.toString());
        return 0;
      }
    }
    return 3;
  }
  
  public TMAssistantDownloadTaskInfo a(String paramString1, String paramString2)
  {
    paramString1 = ApkDownloadManager.getInstance().queryDownloadInfo(paramString2);
    if (paramString1 != null) {
      return a(paramString1);
    }
    Object localObject;
    if (com.tencent.tmdownloader.internal.downloadservice.b.b(paramString2, "application/vnd.android.package-archive"))
    {
      localObject = com.tencent.tmdownloader.internal.downloadservice.b.b(paramString2);
      paramString1 = d.a((String)localObject);
      localObject = new d((String)localObject, (String)localObject);
      paramString1 = new TMAssistantDownloadTaskInfo(paramString2, paramString1, 4, ((d)localObject).a(), ((d)localObject).a(), "application/vnd.android.package-archive");
      paramString2 = new StringBuilder();
      paramString2.append("getDownloadTaskInfo downloadTaskInfo savePath | ");
      paramString2.append(paramString1.mSavePath);
      ab.c("ServiceDownloadTaskManager", paramString2.toString());
      return paramString1;
    }
    if (com.tencent.tmdownloader.internal.downloadservice.b.b(paramString2, "application/tm.android.apkdiff"))
    {
      localObject = com.tencent.tmdownloader.internal.downloadservice.b.a(paramString2, "application/tm.android.apkdiff");
      paramString1 = d.a((String)localObject);
      localObject = new d((String)localObject, (String)localObject);
      return new TMAssistantDownloadTaskInfo(paramString2, paramString1, 4, ((d)localObject).a(), ((d)localObject).a(), "application/tm.android.apkdiff");
    }
    d(paramString2);
    return null;
  }
  
  public void a()
  {
    ApkDownloadManager.getInstance().AddDownloadListener(this);
  }
  
  public void a(a parama)
  {
    this.b = parama;
  }
  
  public void a(String paramString) {}
  
  public void a(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    if (this.b == null) {
      return;
    }
    Object localObject = c(paramString1);
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        b localb = (b)((Iterator)localObject).next();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("clientKey:");
        localStringBuilder.append(localb.a);
        localStringBuilder.append(",state:");
        localStringBuilder.append(paramInt1);
        localStringBuilder.append(",errorcode:");
        localStringBuilder.append(paramInt2);
        localStringBuilder.append(",url:");
        localStringBuilder.append(paramString1.hashCode());
        ab.c("ServiceDownloadTaskManager", localStringBuilder.toString());
        localb.c = paramInt1;
        this.b.OnDownloadStateChanged(localb.a, paramString1, paramInt1, paramInt2, paramString2);
      }
    }
  }
  
  public void a(String paramString, long paramLong1, long paramLong2)
  {
    if (this.b == null) {
      return;
    }
    Object localObject = c(paramString);
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      long l = System.currentTimeMillis();
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        b localb = (b)((Iterator)localObject).next();
        if (localb.a(paramLong1, paramLong2, l) == true)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("clientKey:");
          localStringBuilder.append(localb.a);
          localStringBuilder.append(",receivedLen:");
          localStringBuilder.append(paramLong1);
          localStringBuilder.append(",url:");
          localStringBuilder.append(paramString.hashCode());
          ab.c("ServiceDownloadTaskManager", localStringBuilder.toString());
          this.b.OnDownloadProgressChanged(localb.a, paramString, paramLong1, paramLong2);
        }
      }
    }
  }
  
  public List<TMAssistantDownloadTaskInfo> b(String paramString)
  {
    return a(ApkDownloadManager.getInstance().queryDownloadInfoByVia(paramString));
  }
  
  public void b()
  {
    ApkDownloadManager.getInstance().RemoveDownloadListener(this);
  }
  
  public void b(String paramString1, String paramString2)
  {
    ab.c("ServiceDownloadTaskManager", "enter");
    if (paramString1 != null)
    {
      if (paramString2 == null) {
        return;
      }
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("pauseDownload clientKey:");
      ((StringBuilder)localObject1).append(paramString1);
      ((StringBuilder)localObject1).append("; url: ");
      ((StringBuilder)localObject1).append(paramString2);
      ab.c("ServiceDownloadTaskManager", ((StringBuilder)localObject1).toString());
      localObject1 = e(paramString1, paramString2);
      ??? = new StringBuilder();
      ((StringBuilder)???).append("pauseDownload taskItem:");
      ((StringBuilder)???).append(localObject1);
      ab.c("ServiceDownloadTaskManager", ((StringBuilder)???).toString());
      if (localObject1 != null)
      {
        ((b)localObject1).c = 3;
        synchronized (this.a)
        {
          this.a.remove(localObject1);
          ??? = new StringBuilder();
          ((StringBuilder)???).append("clientKey:");
          ((StringBuilder)???).append(paramString1);
          ((StringBuilder)???).append(",remove taskItem");
          ab.c("ServiceDownloadTaskManager", ((StringBuilder)???).toString());
          ??? = c(paramString2);
          if ((??? == null) || (((ArrayList)???).size() == 0))
          {
            ??? = new StringBuilder();
            ((StringBuilder)???).append("clientKey:");
            ((StringBuilder)???).append(paramString1);
            ((StringBuilder)???).append(",taskItem is the only on pauseAll");
            ab.c("ServiceDownloadTaskManager", ((StringBuilder)???).toString());
            ApkDownloadManager.getInstance().pauseDownload(paramString2);
          }
          ??? = this.b;
          if (??? == null) {
            break label321;
          }
          ((a)???).OnDownloadStateChanged(paramString1, paramString2, ((b)localObject1).c, 0, null);
        }
      }
      paramString2 = new StringBuilder();
      paramString2.append("clientKey:");
      paramString2.append(paramString1);
      paramString2.append(",taskItem is null");
      ab.d("ServiceDownloadTaskManager", paramString2.toString());
      label321:
      ab.c("ServiceDownloadTaskManager", "exit");
    }
  }
  
  protected ArrayList<b> c(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      ArrayList localArrayList = new ArrayList();
      synchronized (this.a)
      {
        Iterator localIterator = this.a.iterator();
        while (localIterator.hasNext())
        {
          b localb = (b)localIterator.next();
          if (localb.b.equals(paramString)) {
            localArrayList.add(localb);
          }
        }
        return localArrayList;
      }
      throw paramString;
    }
    finally {}
    for (;;) {}
  }
  
  public void c(String paramString1, String paramString2)
  {
    if (paramString1 != null)
    {
      if (paramString2 == null) {
        return;
      }
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("cancelDownload clientKey:");
      ((StringBuilder)localObject1).append(paramString1);
      ab.c("ServiceDownloadTaskManager", ((StringBuilder)localObject1).toString());
      localObject1 = e(paramString1, paramString2);
      ??? = new StringBuilder();
      ((StringBuilder)???).append("cancelDownload taskItem:");
      ((StringBuilder)???).append(localObject1);
      ab.c("ServiceDownloadTaskManager", ((StringBuilder)???).toString());
      if (localObject1 != null)
      {
        ((b)localObject1).c = 6;
        synchronized (this.a)
        {
          this.a.remove(localObject1);
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("clientKey:");
          ((StringBuilder)localObject1).append(paramString1);
          ((StringBuilder)localObject1).append(",remove taskItem");
          ab.c("ServiceDownloadTaskManager", ((StringBuilder)localObject1).toString());
        }
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("clientKey:");
      ((StringBuilder)localObject1).append(paramString1);
      ((StringBuilder)localObject1).append(",taskItem is null");
      ab.d("ServiceDownloadTaskManager", ((StringBuilder)localObject1).toString());
      localObject1 = c(paramString2);
      if ((localObject1 != null) && (((ArrayList)localObject1).size() != 0))
      {
        paramString2 = new StringBuilder();
        paramString2.append("cancelDownload clientKey:");
        paramString2.append(paramString1);
        paramString2.append(",taskItem is null");
        ab.d("ServiceDownloadTaskManager", paramString2.toString());
        return;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("clientKey:");
      ((StringBuilder)localObject1).append(paramString1);
      ((StringBuilder)localObject1).append(",taskItem is the only on cancelAll");
      ab.c("ServiceDownloadTaskManager", ((StringBuilder)localObject1).toString());
      ApkDownloadManager.getInstance().cancelDownload(paramString2);
      localObject1 = this.b;
      if (localObject1 != null) {
        ((a)localObject1).OnDownloadStateChanged(paramString1, paramString2, 6, 0, null);
      }
    }
  }
  
  protected void d(String arg1)
  {
    if (??? == null) {
      return;
    }
    try
    {
      ArrayList localArrayList = new ArrayList();
      synchronized (this.a)
      {
        Iterator localIterator = this.a.iterator();
        while (localIterator.hasNext())
        {
          b localb = (b)localIterator.next();
          if (localb.b.equals(???)) {
            localArrayList.add(localb);
          }
        }
        if (localArrayList.size() > 0) {
          synchronized (this.a)
          {
            this.a.removeAll(localArrayList);
          }
        }
        return;
      }
      throw ???;
    }
    finally {}
    for (;;) {}
  }
  
  public void d(String paramString1, String paramString2)
  {
    if (paramString1 != null)
    {
      if (paramString2 == null) {
        return;
      }
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("deleteDownload clientKey:");
      ((StringBuilder)localObject1).append(paramString1);
      ab.c("ServiceDownloadTaskManager", ((StringBuilder)localObject1).toString());
      localObject1 = e(paramString1, paramString2);
      ??? = new StringBuilder();
      ((StringBuilder)???).append("deleteDownload taskItem:");
      ((StringBuilder)???).append(localObject1);
      ab.c("ServiceDownloadTaskManager", ((StringBuilder)???).toString());
      if (localObject1 != null)
      {
        ((b)localObject1).c = 6;
        synchronized (this.a)
        {
          this.a.remove(localObject1);
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("clientKey:");
          ((StringBuilder)localObject1).append(paramString1);
          ((StringBuilder)localObject1).append(",remove taskItem");
          ab.c("ServiceDownloadTaskManager", ((StringBuilder)localObject1).toString());
        }
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("clientKey:");
      ((StringBuilder)localObject1).append(paramString1);
      ((StringBuilder)localObject1).append(",taskItem is null");
      ab.d("ServiceDownloadTaskManager", ((StringBuilder)localObject1).toString());
      localObject1 = c(paramString2);
      if ((localObject1 != null) && (((ArrayList)localObject1).size() != 0))
      {
        paramString2 = new StringBuilder();
        paramString2.append("deleteDownload clientKey:");
        paramString2.append(paramString1);
        paramString2.append(",taskItem is null");
        ab.d("ServiceDownloadTaskManager", paramString2.toString());
        return;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("clientKey:");
      ((StringBuilder)localObject1).append(paramString1);
      ((StringBuilder)localObject1).append(",taskItem is the only on deleteAll");
      ab.c("ServiceDownloadTaskManager", ((StringBuilder)localObject1).toString());
      ApkDownloadManager.getInstance().deleteDownload(paramString2);
      localObject1 = this.b;
      if (localObject1 != null) {
        ((a)localObject1).OnDownloadStateChanged(paramString1, paramString2, 6, 0, null);
      }
    }
  }
  
  protected b e(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (paramString2 != null)) {
      try
      {
        synchronized (this.a)
        {
          Iterator localIterator = this.a.iterator();
          while (localIterator.hasNext())
          {
            b localb = (b)localIterator.next();
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("taskItem mClientKey is: ");
            localStringBuilder.append(localb.a);
            localStringBuilder.append(" mUrl is: ");
            localStringBuilder.append(localb.b);
            ab.b("ServiceDownloadTaskManager", localStringBuilder.toString());
            if ((localb.a != null) && (localb.a.equals(paramString1)) && (localb.b.equals(paramString2))) {
              return localb;
            }
          }
          return null;
        }
      }
      finally {}
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tmdownloader.internal.downloadservice.a.c
 * JD-Core Version:    0.7.0.1
 */