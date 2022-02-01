package com.tencent.open.appcommon.now.download.local;

import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.appcommon.now.download.DownloadCenterImpl;
import com.tencent.open.appcommon.now.download.IDownloadCallback;
import com.tencent.open.downloadnew.DownloadInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;

public class DownloadCallbackNativeImpl
  implements IDownloadCallback
{
  private ArrayList<DownloadNativeApi.IDownloadObserver> a = new ArrayList();
  private Map<String, DownloadTaskInfo> b = new HashMap();
  
  public void a()
  {
    Map localMap = this.b;
    if (localMap != null) {
      localMap.clear();
    }
  }
  
  public void a(int paramInt)
  {
    ThreadManager.getSubThreadHandler().postDelayed(new DownloadCallbackNativeImpl.1(this, paramInt), 3000L);
  }
  
  public void a(DownloadNativeApi.IDownloadObserver paramIDownloadObserver)
  {
    if (paramIDownloadObserver != null)
    {
      ArrayList localArrayList = this.a;
      if ((localArrayList != null) && (!localArrayList.contains(paramIDownloadObserver))) {
        this.a.add(paramIDownloadObserver);
      }
    }
  }
  
  public void a(DownloadTaskInfo paramDownloadTaskInfo)
  {
    if (this.b == null) {
      this.b = new HashMap();
    }
    if (paramDownloadTaskInfo != null)
    {
      if (TextUtils.isEmpty(paramDownloadTaskInfo.a)) {
        return;
      }
      if (!this.b.containsKey(paramDownloadTaskInfo.a)) {
        this.b.put(paramDownloadTaskInfo.a, paramDownloadTaskInfo);
      }
    }
  }
  
  public void a(DownloadInfo paramDownloadInfo, int paramInt) {}
  
  public void a(String paramString)
  {
    Map localMap = this.b;
    if ((localMap != null) && (localMap.containsKey(paramString))) {
      ((DownloadTaskInfo)this.b.get(paramString)).h = true;
    }
  }
  
  public void a(List<DownloadInfo> paramList)
  {
    if (paramList == null) {
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (DownloadInfo)paramList.next();
      if (localObject != null)
      {
        DownloadStateInfo localDownloadStateInfo = new DownloadStateInfo();
        localDownloadStateInfo.a((DownloadInfo)localObject);
        localObject = this.a.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((DownloadNativeApi.IDownloadObserver)((Iterator)localObject).next()).d(localDownloadStateInfo);
        }
      }
    }
  }
  
  public void b(DownloadNativeApi.IDownloadObserver paramIDownloadObserver)
  {
    ArrayList localArrayList = this.a;
    if (localArrayList != null) {
      localArrayList.remove(paramIDownloadObserver);
    }
  }
  
  public void installSucceed(String paramString1, String paramString2)
  {
    if (this.a != null)
    {
      DownloadStateInfo localDownloadStateInfo = new DownloadStateInfo();
      localDownloadStateInfo.a = paramString1;
      localDownloadStateInfo.b = paramString2;
      localDownloadStateInfo.c = 7;
      paramString1 = this.a.iterator();
      while (paramString1.hasNext()) {
        ((DownloadNativeApi.IDownloadObserver)paramString1.next()).a(localDownloadStateInfo);
      }
    }
  }
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo)
  {
    if ((this.a != null) && (paramDownloadInfo != null))
    {
      DownloadStateInfo localDownloadStateInfo = new DownloadStateInfo();
      localDownloadStateInfo.a(paramDownloadInfo);
      paramDownloadInfo = this.a.iterator();
      while (paramDownloadInfo.hasNext()) {
        ((DownloadNativeApi.IDownloadObserver)paramDownloadInfo.next()).a(localDownloadStateInfo);
      }
    }
  }
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    if ((this.a != null) && (paramDownloadInfo != null))
    {
      DownloadStateInfo localDownloadStateInfo = new DownloadStateInfo();
      localDownloadStateInfo.a(paramDownloadInfo);
      localDownloadStateInfo.c = localDownloadStateInfo.a(paramDownloadInfo.a());
      localDownloadStateInfo.g = localDownloadStateInfo.b(paramInt1);
      localDownloadStateInfo.h = paramString;
      paramString = this.a.iterator();
      while (paramString.hasNext()) {
        ((DownloadNativeApi.IDownloadObserver)paramString.next()).b(localDownloadStateInfo);
      }
      if (localDownloadStateInfo.g == 201)
      {
        paramString = (DownloadTaskInfo)this.b.get(localDownloadStateInfo.a);
        if ((paramString != null) && (!paramString.g)) {
          DownloadCenterImpl.a().a(paramDownloadInfo);
        }
      }
    }
  }
  
  public void onDownloadFinish(DownloadInfo paramDownloadInfo)
  {
    if ((this.a != null) && (paramDownloadInfo != null))
    {
      DownloadStateInfo localDownloadStateInfo = new DownloadStateInfo();
      localDownloadStateInfo.a(paramDownloadInfo);
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((DownloadNativeApi.IDownloadObserver)localIterator.next()).a(localDownloadStateInfo);
      }
      if (this.b.containsKey(paramDownloadInfo.c)) {
        this.b.remove(paramDownloadInfo.c);
      }
    }
  }
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo)
  {
    if ((this.a != null) && (paramDownloadInfo != null))
    {
      DownloadStateInfo localDownloadStateInfo = new DownloadStateInfo();
      localDownloadStateInfo.a(paramDownloadInfo);
      paramDownloadInfo = this.a.iterator();
      while (paramDownloadInfo.hasNext()) {
        ((DownloadNativeApi.IDownloadObserver)paramDownloadInfo.next()).a(localDownloadStateInfo);
      }
    }
  }
  
  public void onDownloadUpdate(List<DownloadInfo> paramList)
  {
    if (paramList == null) {
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (DownloadInfo)paramList.next();
      if (localObject != null)
      {
        DownloadStateInfo localDownloadStateInfo = new DownloadStateInfo();
        localDownloadStateInfo.a((DownloadInfo)localObject);
        localObject = this.a.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((DownloadNativeApi.IDownloadObserver)((Iterator)localObject).next()).c(localDownloadStateInfo);
        }
      }
    }
  }
  
  public void onDownloadWait(DownloadInfo paramDownloadInfo)
  {
    if ((this.a != null) && (paramDownloadInfo != null))
    {
      DownloadStateInfo localDownloadStateInfo = new DownloadStateInfo();
      localDownloadStateInfo.a(paramDownloadInfo);
      paramDownloadInfo = this.a.iterator();
      while (paramDownloadInfo.hasNext()) {
        ((DownloadNativeApi.IDownloadObserver)paramDownloadInfo.next()).a(localDownloadStateInfo);
      }
    }
  }
  
  public void packageReplaced(String paramString1, String paramString2)
  {
    if (this.a != null)
    {
      DownloadStateInfo localDownloadStateInfo = new DownloadStateInfo();
      localDownloadStateInfo.a = paramString1;
      localDownloadStateInfo.b = paramString2;
      localDownloadStateInfo.c = 9;
      paramString1 = this.a.iterator();
      while (paramString1.hasNext()) {
        ((DownloadNativeApi.IDownloadObserver)paramString1.next()).a(localDownloadStateInfo);
      }
    }
  }
  
  public void uninstallSucceed(String paramString1, String paramString2)
  {
    if (this.a != null)
    {
      DownloadStateInfo localDownloadStateInfo = new DownloadStateInfo();
      localDownloadStateInfo.a = paramString1;
      localDownloadStateInfo.b = paramString2;
      localDownloadStateInfo.c = 8;
      paramString1 = this.a.iterator();
      while (paramString1.hasNext()) {
        ((DownloadNativeApi.IDownloadObserver)paramString1.next()).a(localDownloadStateInfo);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.appcommon.now.download.local.DownloadCallbackNativeImpl
 * JD-Core Version:    0.7.0.1
 */