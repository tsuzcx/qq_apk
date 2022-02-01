package com.tencent.mobileqq.uniformdownload.data;

import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil;
import com.tencent.mobileqq.uniformdownload.core.UniformDownloadNfn;
import com.tencent.mobileqq.uniformdownload.downloader.UniformDownloader;
import com.tencent.mobileqq.uniformdownload.util.IUniformDownloaderListener;
import com.tencent.mobileqq.uniformdownload.util.UniformDownloadUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.os.MqqHandler;

public class DownloadInstContextMgr
{
  private Map<String, DownloadInstContextMgr.DownloadInstContext> a = new HashMap();
  private UniformDownloaderListenerMgr b;
  
  public DownloadInstContextMgr(UniformDownloaderListenerMgr paramUniformDownloaderListenerMgr)
  {
    this.b = paramUniformDownloaderListenerMgr;
  }
  
  private void f()
  {
    ArrayList localArrayList = new ArrayList();
    synchronized (this.a)
    {
      if (this.a.size() > 0)
      {
        Iterator localIterator = this.a.entrySet().iterator();
        while (localIterator.hasNext())
        {
          DownloadInstContextMgr.DownloadInstContext localDownloadInstContext = (DownloadInstContextMgr.DownloadInstContext)((Map.Entry)localIterator.next()).getValue();
          if ((localDownloadInstContext != null) && (localDownloadInstContext.e != null) && (localDownloadInstContext.e.j()) && (2 == localDownloadInstContext.e.b())) {
            localArrayList.add(localDownloadInstContext);
          }
        }
      }
      ??? = localArrayList.iterator();
      while (((Iterator)???).hasNext()) {
        ((DownloadInstContextMgr.DownloadInstContext)((Iterator)???).next()).e.h();
      }
      b();
      return;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public int a(String paramString, Bundle paramBundle)
  {
    if ((paramString != null) && (paramBundle != null))
    {
      int i = paramBundle.getInt("_notify_param_Id");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[UniformDL] >>>pauseDownloaderByUrl. URL:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" nofiyid:");
      localStringBuilder.append(i);
      QLog.i("DownloadInstContextMgr", 1, localStringBuilder.toString());
      if (-1 == d(paramString))
      {
        UniformDownloadUtil.a(paramString, new DownloadInstContextMgr.3(this));
        UniformDownloadNfn.a().a(i, (Bundle)paramBundle.clone());
        f(null);
      }
      return 0;
    }
    QLog.e("DownloadInstContextMgr", 1, "[UniformDL] pauseDownloaderByUrl. param error!!");
    return -1;
  }
  
  public DownloadInstContextMgr.DownloadInstContext a(String paramString)
  {
    synchronized (this.a)
    {
      paramString = (DownloadInstContextMgr.DownloadInstContext)this.a.get(paramString);
      return paramString;
    }
  }
  
  public void a()
  {
    QLog.i("DownloadInstContextMgr", 1, "[UniformDL] pauseSlienceRuningGenDownloadOfOldApp ...");
    ThreadManager.getSubThreadHandler().post(new DownloadInstContextMgr.1(this));
  }
  
  public boolean a(String paramString, DownloadInstContextMgr.DownloadInstContext paramDownloadInstContext)
  {
    if ((paramString != null) && (paramDownloadInstContext != null)) {
      synchronized (this.a)
      {
        if (this.a.containsKey(paramString))
        {
          paramDownloadInstContext = new StringBuilder();
          paramDownloadInstContext.append("[UniformDL] url[");
          paramDownloadInstContext.append(paramString);
          paramDownloadInstContext.append("] exsited! total[");
          paramDownloadInstContext.append(this.a.size());
          paramDownloadInstContext.append("]");
          QLog.i("DownloadInstContextMgr", 1, paramDownloadInstContext.toString());
          return false;
        }
        this.a.put(paramString, paramDownloadInstContext);
        paramDownloadInstContext = new StringBuilder();
        paramDownloadInstContext.append("[UniformDL] addDownloadInst.. total[");
        paramDownloadInstContext.append(this.a.size());
        paramDownloadInstContext.append("] add it. url[");
        paramDownloadInstContext.append(paramString);
        paramDownloadInstContext.append("]");
        QLog.i("DownloadInstContextMgr", 1, paramDownloadInstContext.toString());
        return true;
      }
    }
    QLog.e("DownloadInstContextMgr", 1, "[UniformDL] addDownloadInst.. param null");
    return false;
  }
  
  public int b(String paramString)
  {
    synchronized (this.a)
    {
      Object localObject = (DownloadInstContextMgr.DownloadInstContext)this.a.remove(paramString);
      if (localObject != null)
      {
        IUniformDownloaderListener localIUniformDownloaderListener = this.b.a(paramString);
        if ((((DownloadInstContextMgr.DownloadInstContext)localObject).e != null) && (localIUniformDownloaderListener != null)) {
          ((DownloadInstContextMgr.DownloadInstContext)localObject).e.a(localIUniformDownloaderListener);
        }
      }
      int i = this.a.size();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[UniformDL] delDownloadInst.. total[");
      ((StringBuilder)localObject).append(this.a.size());
      ((StringBuilder)localObject).append("] del it. url[");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("]");
      QLog.i("DownloadInstContextMgr", 1, ((StringBuilder)localObject).toString());
      return i;
    }
  }
  
  public void b() {}
  
  public int c(String paramString)
  {
    Object localObject = a(paramString);
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[UniformDL] inPResumeDownload.. inst not exsited. url:");
      ((StringBuilder)localObject).append(paramString);
      QLog.w("DownloadInstContextMgr", 1, ((StringBuilder)localObject).toString());
      return -1;
    }
    if (((DownloadInstContextMgr.DownloadInstContext)localObject).e != null)
    {
      paramString = this.b.a(paramString);
      if (paramString != null) {
        ((DownloadInstContextMgr.DownloadInstContext)localObject).e.a(paramString, false);
      }
      ((DownloadInstContextMgr.DownloadInstContext)localObject).e.f();
    }
    f(null);
    return 0;
  }
  
  public void c()
  {
    synchronized (this.a)
    {
      if (this.a.size() == 0) {
        return;
      }
      Iterator localIterator = this.a.entrySet().iterator();
      while (localIterator.hasNext())
      {
        DownloadInstContextMgr.DownloadInstContext localDownloadInstContext = (DownloadInstContextMgr.DownloadInstContext)((Map.Entry)localIterator.next()).getValue();
        if ((localDownloadInstContext.e != null) && (localDownloadInstContext.e.j()))
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("[UniformDL] >>>onQQProcessExit. stop download:url:");
          ((StringBuilder)localObject2).append(localDownloadInstContext.d);
          QLog.i("DownloadInstContextMgr", 1, ((StringBuilder)localObject2).toString());
        }
        Object localObject2 = new Bundle();
        ((Bundle)localObject2).putString("_notify_param_Url", localDownloadInstContext.d);
        UniformDownloadNfn.a().c(localDownloadInstContext.f, (Bundle)localObject2);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[UniformDL] >>>onQQProcessExit. cancel notification:");
        ((StringBuilder)localObject2).append(localDownloadInstContext.f);
        QLog.i("DownloadInstContextMgr", 1, ((StringBuilder)localObject2).toString());
      }
      return;
    }
    for (;;)
    {
      throw localObject1;
    }
  }
  
  public int d(String paramString)
  {
    Object localObject = a(paramString);
    if (localObject != null)
    {
      if (((DownloadInstContextMgr.DownloadInstContext)localObject).e != null) {
        ((DownloadInstContextMgr.DownloadInstContext)localObject).e.e();
      }
      f(null);
      return 0;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[UniformDL] inPPauseDownload.. inst not exsited. url:");
    ((StringBuilder)localObject).append(paramString);
    QLog.e("DownloadInstContextMgr", 1, ((StringBuilder)localObject).toString());
    return -1;
  }
  
  public void d()
  {
    Object localObject2 = new ArrayList();
    synchronized (this.a)
    {
      Object localObject4;
      if (this.a.size() > 0)
      {
        localObject4 = this.a.entrySet().iterator();
        while (((Iterator)localObject4).hasNext())
        {
          DownloadInstContextMgr.DownloadInstContext localDownloadInstContext = (DownloadInstContextMgr.DownloadInstContext)((Map.Entry)((Iterator)localObject4).next()).getValue();
          if ((localDownloadInstContext.e != null) && (8 == localDownloadInstContext.e.i()) && (2 == localDownloadInstContext.e.b())) {
            ((List)localObject2).add(localDownloadInstContext);
          }
        }
      }
      ??? = ((List)localObject2).iterator();
      while (((Iterator)???).hasNext())
      {
        localObject2 = (DownloadInstContextMgr.DownloadInstContext)((Iterator)???).next();
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("[UniformDL] >>> resumeRuningGenDownloadOfOldApp, url:[");
        ((StringBuilder)localObject4).append(((DownloadInstContextMgr.DownloadInstContext)localObject2).d);
        ((StringBuilder)localObject4).append("]");
        QLog.w("DownloadInstContextMgr", 1, ((StringBuilder)localObject4).toString());
        ((DownloadInstContextMgr.DownloadInstContext)localObject2).e.d();
      }
      return;
    }
    for (;;)
    {
      throw localObject3;
    }
  }
  
  public int e(String paramString)
  {
    Object localObject = a(paramString);
    if (localObject != null)
    {
      if (((DownloadInstContextMgr.DownloadInstContext)localObject).e != null) {
        ((DownloadInstContextMgr.DownloadInstContext)localObject).e.g();
      }
      return 0;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[UniformDL] stopDownloaderByUrl.. inst not exsited. url:");
    ((StringBuilder)localObject).append(paramString);
    QLog.e("DownloadInstContextMgr", 1, ((StringBuilder)localObject).toString());
    return -1;
  }
  
  public void e()
  {
    ThreadManager.getSubThreadHandler().post(new DownloadInstContextMgr.2(this));
  }
  
  public int f(String paramString)
  {
    int n;
    if ((NetworkUtil.isNetSupport(BaseApplication.getContext())) && (!QQFileManagerUtil.h())) {
      n = 2;
    } else {
      n = 1;
    }
    ??? = new StringBuilder();
    ((StringBuilder)???).append("[UniformDL] startWaitingDownloaderForMaxCount. togetherDownloadMaxCount=");
    ((StringBuilder)???).append(n);
    QLog.i("DownloadInstContextMgr", 1, ((StringBuilder)???).toString());
    Object localObject2 = new ArrayList();
    int i;
    synchronized (this.a)
    {
      i = this.a.size();
      int m = 0;
      int k = 0;
      if (i > 0)
      {
        Object localObject3 = this.a.entrySet().iterator();
        for (int j = 0;; j = m)
        {
          m = k;
          i = j;
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
          DownloadInstContextMgr.DownloadInstContext localDownloadInstContext = (DownloadInstContextMgr.DownloadInstContext)((Map.Entry)((Iterator)localObject3).next()).getValue();
          i = k;
          m = j;
          if (localDownloadInstContext.e != null)
          {
            i = k;
            m = j;
            if (localDownloadInstContext.e.j())
            {
              k += 1;
              i = k;
              m = j;
              if (paramString != null)
              {
                i = k;
                m = j;
                if (paramString.equalsIgnoreCase(localDownloadInstContext.d))
                {
                  StringBuilder localStringBuilder = new StringBuilder();
                  localStringBuilder.append("[UniformDL] startWaitingDownloaderForMaxCount.. download is runing. traceUrl:");
                  localStringBuilder.append(paramString);
                  QLog.i("DownloadInstContextMgr", 1, localStringBuilder.toString());
                  m = 1;
                  i = k;
                }
              }
            }
          }
          ((List)localObject2).add(localDownloadInstContext);
          k = i;
        }
        if (m < n)
        {
          ??? = ((List)localObject2).iterator();
          for (;;)
          {
            j = i;
            if (!((Iterator)???).hasNext()) {
              break;
            }
            localObject2 = (DownloadInstContextMgr.DownloadInstContext)((Iterator)???).next();
            if ((((DownloadInstContextMgr.DownloadInstContext)localObject2).e != null) && (((DownloadInstContextMgr.DownloadInstContext)localObject2).e.k()))
            {
              if (m == n)
              {
                paramString = new StringBuilder();
                paramString.append("[UniformDL] startWaitingDownloaderForMaxCount.. total[");
                paramString.append(this.a.size());
                paramString.append("] the task of downloading is overload,other need waiting... 1");
                QLog.i("DownloadInstContextMgr", 1, paramString.toString());
                j = i;
                break;
              }
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("[UniformDL] >>> Happy. start a download task, url:[");
              ((StringBuilder)localObject3).append(((DownloadInstContextMgr.DownloadInstContext)localObject2).d);
              ((StringBuilder)localObject3).append("]");
              QLog.i("DownloadInstContextMgr", 1, ((StringBuilder)localObject3).toString());
              j = m + 1;
              ((DownloadInstContextMgr.DownloadInstContext)localObject2).e.d();
              m = j;
              if (paramString != null)
              {
                m = j;
                if (paramString.equalsIgnoreCase(((DownloadInstContextMgr.DownloadInstContext)localObject2).d))
                {
                  localObject2 = new StringBuilder();
                  ((StringBuilder)localObject2).append("[UniformDL] startWaitingDownloaderForMaxCount.. download is started. traceUrl:");
                  ((StringBuilder)localObject2).append(paramString);
                  QLog.i("DownloadInstContextMgr", 1, ((StringBuilder)localObject2).toString());
                  i = 2;
                  m = j;
                }
              }
            }
          }
        }
        paramString = new StringBuilder();
        paramString.append("[UniformDL] startWaitingDownloaderForMaxCount.. total[");
        paramString.append(this.a.size());
        paramString.append("] the task of downloading is overload,other need waiting... 2");
        QLog.i("DownloadInstContextMgr", 1, paramString.toString());
        j = i;
        b();
        return j;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uniformdownload.data.DownloadInstContextMgr
 * JD-Core Version:    0.7.0.1
 */