package com.tencent.mobileqq.uniformdownload.data;

import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.uniformdownload.core.UniformDownloadNfn;
import com.tencent.mobileqq.uniformdownload.downloader.UniformDownloader;
import com.tencent.mobileqq.uniformdownload.filemanager.FileManagerUtil;
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
  private UniformDownloaderListenerMgr jdField_a_of_type_ComTencentMobileqqUniformdownloadDataUniformDownloaderListenerMgr;
  private Map<String, DownloadInstContextMgr.DownloadInstContext> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  public DownloadInstContextMgr(UniformDownloaderListenerMgr paramUniformDownloaderListenerMgr)
  {
    this.jdField_a_of_type_ComTencentMobileqqUniformdownloadDataUniformDownloaderListenerMgr = paramUniformDownloaderListenerMgr;
  }
  
  private void f()
  {
    ArrayList localArrayList = new ArrayList();
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      if (this.jdField_a_of_type_JavaUtilMap.size() > 0)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
        while (localIterator.hasNext())
        {
          DownloadInstContextMgr.DownloadInstContext localDownloadInstContext = (DownloadInstContextMgr.DownloadInstContext)((Map.Entry)localIterator.next()).getValue();
          if ((localDownloadInstContext != null) && (localDownloadInstContext.jdField_a_of_type_ComTencentMobileqqUniformdownloadDownloaderUniformDownloader != null) && (localDownloadInstContext.jdField_a_of_type_ComTencentMobileqqUniformdownloadDownloaderUniformDownloader.b()) && (2 == localDownloadInstContext.jdField_a_of_type_ComTencentMobileqqUniformdownloadDownloaderUniformDownloader.a())) {
            localArrayList.add(localDownloadInstContext);
          }
        }
      }
    }
    ??? = localObject2.iterator();
    while (((Iterator)???).hasNext()) {
      ((DownloadInstContextMgr.DownloadInstContext)((Iterator)???).next()).jdField_a_of_type_ComTencentMobileqqUniformdownloadDownloaderUniformDownloader.f();
    }
    b();
  }
  
  public int a(String paramString)
  {
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      DownloadInstContextMgr.DownloadInstContext localDownloadInstContext = (DownloadInstContextMgr.DownloadInstContext)this.jdField_a_of_type_JavaUtilMap.remove(paramString);
      if (localDownloadInstContext != null)
      {
        IUniformDownloaderListener localIUniformDownloaderListener = this.jdField_a_of_type_ComTencentMobileqqUniformdownloadDataUniformDownloaderListenerMgr.a(paramString);
        if ((localDownloadInstContext.jdField_a_of_type_ComTencentMobileqqUniformdownloadDownloaderUniformDownloader != null) && (localIUniformDownloaderListener != null)) {
          localDownloadInstContext.jdField_a_of_type_ComTencentMobileqqUniformdownloadDownloaderUniformDownloader.a(localIUniformDownloaderListener);
        }
      }
      int i = this.jdField_a_of_type_JavaUtilMap.size();
      QLog.i("DownloadInstContextMgr", 1, "[UniformDL] delDownloadInst.. total[" + this.jdField_a_of_type_JavaUtilMap.size() + "] del it. url[" + paramString + "]");
      return i;
    }
  }
  
  public int a(String paramString, Bundle paramBundle)
  {
    if ((paramString == null) || (paramBundle == null))
    {
      QLog.e("DownloadInstContextMgr", 1, "[UniformDL] pauseDownloaderByUrl. param error!!");
      return -1;
    }
    int i = paramBundle.getInt("_notify_param_Id");
    QLog.i("DownloadInstContextMgr", 1, "[UniformDL] >>>pauseDownloaderByUrl. URL:" + paramString + " nofiyid:" + i);
    if (-1 == c(paramString))
    {
      UniformDownloadUtil.a(paramString, new DownloadInstContextMgr.3(this));
      UniformDownloadNfn.a().a(i, (Bundle)paramBundle.clone());
      e(null);
    }
    return 0;
  }
  
  public DownloadInstContextMgr.DownloadInstContext a(String paramString)
  {
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      paramString = (DownloadInstContextMgr.DownloadInstContext)this.jdField_a_of_type_JavaUtilMap.get(paramString);
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
    if ((paramString == null) || (paramDownloadInstContext == null))
    {
      QLog.e("DownloadInstContextMgr", 1, "[UniformDL] addDownloadInst.. param null");
      return false;
    }
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramString))
      {
        QLog.i("DownloadInstContextMgr", 1, "[UniformDL] url[" + paramString + "] exsited! total[" + this.jdField_a_of_type_JavaUtilMap.size() + "]");
        return false;
      }
    }
    this.jdField_a_of_type_JavaUtilMap.put(paramString, paramDownloadInstContext);
    QLog.i("DownloadInstContextMgr", 1, "[UniformDL] addDownloadInst.. total[" + this.jdField_a_of_type_JavaUtilMap.size() + "] add it. url[" + paramString + "]");
    return true;
  }
  
  public int b(String paramString)
  {
    DownloadInstContextMgr.DownloadInstContext localDownloadInstContext = a(paramString);
    if (localDownloadInstContext == null)
    {
      QLog.w("DownloadInstContextMgr", 1, "[UniformDL] inPResumeDownload.. inst not exsited. url:" + paramString);
      return -1;
    }
    if (localDownloadInstContext.jdField_a_of_type_ComTencentMobileqqUniformdownloadDownloaderUniformDownloader != null)
    {
      paramString = this.jdField_a_of_type_ComTencentMobileqqUniformdownloadDataUniformDownloaderListenerMgr.a(paramString);
      if (paramString != null) {
        localDownloadInstContext.jdField_a_of_type_ComTencentMobileqqUniformdownloadDownloaderUniformDownloader.a(paramString, false);
      }
      localDownloadInstContext.jdField_a_of_type_ComTencentMobileqqUniformdownloadDownloaderUniformDownloader.d();
    }
    e(null);
    return 0;
  }
  
  public void b() {}
  
  public int c(String paramString)
  {
    DownloadInstContextMgr.DownloadInstContext localDownloadInstContext = a(paramString);
    if (localDownloadInstContext != null)
    {
      if (localDownloadInstContext.jdField_a_of_type_ComTencentMobileqqUniformdownloadDownloaderUniformDownloader != null) {
        localDownloadInstContext.jdField_a_of_type_ComTencentMobileqqUniformdownloadDownloaderUniformDownloader.c();
      }
      e(null);
      return 0;
    }
    QLog.e("DownloadInstContextMgr", 1, "[UniformDL] inPPauseDownload.. inst not exsited. url:" + paramString);
    return -1;
  }
  
  public void c()
  {
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      if (this.jdField_a_of_type_JavaUtilMap.size() == 0) {
        return;
      }
      Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
      if (localIterator.hasNext())
      {
        DownloadInstContextMgr.DownloadInstContext localDownloadInstContext = (DownloadInstContextMgr.DownloadInstContext)((Map.Entry)localIterator.next()).getValue();
        if ((localDownloadInstContext.jdField_a_of_type_ComTencentMobileqqUniformdownloadDownloaderUniformDownloader != null) && (localDownloadInstContext.jdField_a_of_type_ComTencentMobileqqUniformdownloadDownloaderUniformDownloader.b())) {
          QLog.i("DownloadInstContextMgr", 1, "[UniformDL] >>>onQQProcessExit. stop download:url:" + localDownloadInstContext.jdField_a_of_type_JavaLangString);
        }
        Bundle localBundle = new Bundle();
        localBundle.putString("_notify_param_Url", localDownloadInstContext.jdField_a_of_type_JavaLangString);
        UniformDownloadNfn.a().c(localDownloadInstContext.b, localBundle);
        QLog.i("DownloadInstContextMgr", 1, "[UniformDL] >>>onQQProcessExit. cancel notification:" + localDownloadInstContext.b);
      }
    }
  }
  
  public int d(String paramString)
  {
    DownloadInstContextMgr.DownloadInstContext localDownloadInstContext = a(paramString);
    if (localDownloadInstContext != null)
    {
      if (localDownloadInstContext.jdField_a_of_type_ComTencentMobileqqUniformdownloadDownloaderUniformDownloader != null) {
        localDownloadInstContext.jdField_a_of_type_ComTencentMobileqqUniformdownloadDownloaderUniformDownloader.e();
      }
      return 0;
    }
    QLog.e("DownloadInstContextMgr", 1, "[UniformDL] stopDownloaderByUrl.. inst not exsited. url:" + paramString);
    return -1;
  }
  
  public void d()
  {
    ArrayList localArrayList = new ArrayList();
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      if (this.jdField_a_of_type_JavaUtilMap.size() > 0)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
        while (localIterator.hasNext())
        {
          DownloadInstContextMgr.DownloadInstContext localDownloadInstContext2 = (DownloadInstContextMgr.DownloadInstContext)((Map.Entry)localIterator.next()).getValue();
          if ((localDownloadInstContext2.jdField_a_of_type_ComTencentMobileqqUniformdownloadDownloaderUniformDownloader != null) && (8 == localDownloadInstContext2.jdField_a_of_type_ComTencentMobileqqUniformdownloadDownloaderUniformDownloader.g()) && (2 == localDownloadInstContext2.jdField_a_of_type_ComTencentMobileqqUniformdownloadDownloaderUniformDownloader.a())) {
            localArrayList.add(localDownloadInstContext2);
          }
        }
      }
    }
    ??? = localObject2.iterator();
    while (((Iterator)???).hasNext())
    {
      DownloadInstContextMgr.DownloadInstContext localDownloadInstContext1 = (DownloadInstContextMgr.DownloadInstContext)((Iterator)???).next();
      QLog.w("DownloadInstContextMgr", 1, "[UniformDL] >>> resumeRuningGenDownloadOfOldApp, url:[" + localDownloadInstContext1.jdField_a_of_type_JavaLangString + "]");
      localDownloadInstContext1.jdField_a_of_type_ComTencentMobileqqUniformdownloadDownloaderUniformDownloader.b();
    }
  }
  
  public int e(String paramString)
  {
    int i = 0;
    if ((NetworkUtil.d(BaseApplication.getContext())) && (!FileManagerUtil.a())) {}
    for (int m = 2;; m = 1)
    {
      QLog.i("DownloadInstContextMgr", 1, "[UniformDL] startWaitingDownloaderForMaxCount. togetherDownloadMaxCount=" + m);
      Object localObject2 = new ArrayList();
      synchronized (this.jdField_a_of_type_JavaUtilMap)
      {
        if (this.jdField_a_of_type_JavaUtilMap.size() <= 0) {
          break label532;
        }
        Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
        j = 0;
        i = 0;
        if (localIterator.hasNext())
        {
          DownloadInstContextMgr.DownloadInstContext localDownloadInstContext = (DownloadInstContextMgr.DownloadInstContext)((Map.Entry)localIterator.next()).getValue();
          int n = j;
          k = i;
          if (localDownloadInstContext.jdField_a_of_type_ComTencentMobileqqUniformdownloadDownloaderUniformDownloader != null)
          {
            n = j;
            k = i;
            if (localDownloadInstContext.jdField_a_of_type_ComTencentMobileqqUniformdownloadDownloaderUniformDownloader.b())
            {
              i += 1;
              n = j;
              k = i;
              if (paramString != null)
              {
                n = j;
                k = i;
                if (paramString.equalsIgnoreCase(localDownloadInstContext.jdField_a_of_type_JavaLangString))
                {
                  QLog.i("DownloadInstContextMgr", 1, "[UniformDL] startWaitingDownloaderForMaxCount.. download is runing. traceUrl:" + paramString);
                  n = 1;
                  k = i;
                }
              }
            }
          }
          ((List)localObject2).add(localDownloadInstContext);
          j = n;
          i = k;
        }
      }
      int k = j;
      int j = i;
      i = k;
      for (;;)
      {
        if (j < m)
        {
          ??? = ((List)localObject2).iterator();
          k = i;
          if (((Iterator)???).hasNext())
          {
            localObject2 = (DownloadInstContextMgr.DownloadInstContext)((Iterator)???).next();
            k = j;
            if (((DownloadInstContextMgr.DownloadInstContext)localObject2).jdField_a_of_type_ComTencentMobileqqUniformdownloadDownloaderUniformDownloader == null) {
              break label526;
            }
            k = j;
            if (!((DownloadInstContextMgr.DownloadInstContext)localObject2).jdField_a_of_type_ComTencentMobileqqUniformdownloadDownloaderUniformDownloader.c()) {
              break label526;
            }
            if (j == m)
            {
              QLog.i("DownloadInstContextMgr", 1, "[UniformDL] startWaitingDownloaderForMaxCount.. total[" + this.jdField_a_of_type_JavaUtilMap.size() + "] the task of downloading is overload,other need waiting... 1");
              k = i;
            }
          }
          else
          {
            label372:
            b();
            return k;
          }
          QLog.i("DownloadInstContextMgr", 1, "[UniformDL] >>> Happy. start a download task, url:[" + ((DownloadInstContextMgr.DownloadInstContext)localObject2).jdField_a_of_type_JavaLangString + "]");
          j += 1;
          ((DownloadInstContextMgr.DownloadInstContext)localObject2).jdField_a_of_type_ComTencentMobileqqUniformdownloadDownloaderUniformDownloader.b();
          k = j;
          if (paramString == null) {
            break label526;
          }
          k = j;
          if (!paramString.equalsIgnoreCase(((DownloadInstContextMgr.DownloadInstContext)localObject2).jdField_a_of_type_JavaLangString)) {
            break label526;
          }
          QLog.i("DownloadInstContextMgr", 1, "[UniformDL] startWaitingDownloaderForMaxCount.. download is started. traceUrl:" + paramString);
          i = 2;
        }
        for (;;)
        {
          break;
          QLog.i("DownloadInstContextMgr", 1, "[UniformDL] startWaitingDownloaderForMaxCount.. total[" + this.jdField_a_of_type_JavaUtilMap.size() + "] the task of downloading is overload,other need waiting... 2");
          k = i;
          break label372;
          label526:
          j = k;
        }
        label532:
        j = 0;
      }
    }
  }
  
  public void e()
  {
    ThreadManager.getSubThreadHandler().post(new DownloadInstContextMgr.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.uniformdownload.data.DownloadInstContextMgr
 * JD-Core Version:    0.7.0.1
 */