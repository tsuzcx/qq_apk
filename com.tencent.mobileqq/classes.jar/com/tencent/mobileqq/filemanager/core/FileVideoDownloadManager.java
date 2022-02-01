package com.tencent.mobileqq.filemanager.core;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.filemanager.fileviewer.data.BaseVideoBiz;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FileVideoDownloadManager
{
  private static List<IFileVideoDownloader> a = new ArrayList();
  
  static
  {
    
    if (!QQVideoPlaySDKManager.a()) {
      QQVideoPlaySDKManager.a(BaseApplicationImpl.getApplication(), new FileVideoDownloadManager.1());
    }
  }
  
  public static IFileVideoDownloader a(BaseVideoBiz arg0)
  {
    String str1 = ???.a();
    QLog.i("FileVideoDownloadManager<FileAssistant>XOXO", 1, "try create downloader:" + str1);
    Object localObject2 = a(str1);
    if (localObject2 != null)
    {
      a(???);
      synchronized (a)
      {
        a.add(0, localObject2);
        QLog.i("FileVideoDownloadManager<FileAssistant>XOXO", 1, String.format("find downloader %s and set to head", new Object[] { str1 }));
        return localObject2;
      }
    }
    localObject2 = new FileVideoDownloaderImpl(???);
    synchronized (a)
    {
      QLog.i("FileVideoDownloadManager<FileAssistant>XOXO", 1, "new downloader:" + str2);
      a.add(0, localObject2);
      return localObject2;
    }
  }
  
  private static IFileVideoDownloader a(String paramString)
  {
    for (;;)
    {
      synchronized (a)
      {
        Iterator localIterator = a.iterator();
        if (localIterator.hasNext())
        {
          IFileVideoDownloader localIFileVideoDownloader = (IFileVideoDownloader)localIterator.next();
          if (!localIFileVideoDownloader.a().equalsIgnoreCase(paramString)) {
            continue;
          }
          paramString = localIFileVideoDownloader;
          return paramString;
        }
      }
      paramString = null;
    }
  }
  
  public static void a()
  {
    ??? = a.iterator();
    while (((Iterator)???).hasNext()) {
      ((IFileVideoDownloader)((Iterator)???).next()).b();
    }
    synchronized (a)
    {
      a.clear();
      return;
    }
  }
  
  public static void a(BaseVideoBiz paramBaseVideoBiz)
  {
    d(paramBaseVideoBiz.a());
  }
  
  public static void a(String paramString)
  {
    e(paramString);
    d(paramString);
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    paramString = a(paramString);
    if (paramString == null) {
      return;
    }
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramString.a(paramBoolean);
      return;
    }
  }
  
  public static void b()
  {
    if (a.size() == 0)
    {
      QLog.i("FileVideoDownloadManager<FileAssistant>XOXO", 1, "download queue is empty");
      return;
    }
    ??? = a.iterator();
    IFileVideoDownloader localIFileVideoDownloader;
    while (((Iterator)???).hasNext())
    {
      localIFileVideoDownloader = (IFileVideoDownloader)((Iterator)???).next();
      if (localIFileVideoDownloader.b())
      {
        QLog.i("FileVideoDownloadManager<FileAssistant>XOXO", 1, String.format("%s downloading", new Object[] { localIFileVideoDownloader.a() }));
        return;
      }
    }
    synchronized (a)
    {
      localIFileVideoDownloader = (IFileVideoDownloader)a.get(0);
      if (localIFileVideoDownloader == null)
      {
        QLog.w("FileVideoDownloadManager<FileAssistant>XOXO", 1, "next queue has elment, why get head is null?");
        return;
      }
    }
    localObject2.a();
    QLog.i("FileVideoDownloadManager<FileAssistant>XOXO", 1, String.format("start %s to download", new Object[] { localObject2.a() }));
  }
  
  public static void b(String paramString)
  {
    IFileVideoDownloader localIFileVideoDownloader1 = a(paramString);
    if (localIFileVideoDownloader1 == null)
    {
      QLog.w("FileVideoDownloadManager<FileAssistant>XOXO", 1, String.format("%s not in downloadList", new Object[] { paramString }));
      return;
    }
    synchronized (a)
    {
      Iterator localIterator = a.iterator();
      while (localIterator.hasNext())
      {
        IFileVideoDownloader localIFileVideoDownloader2 = (IFileVideoDownloader)localIterator.next();
        if (localIFileVideoDownloader2 != localIFileVideoDownloader1) {
          localIFileVideoDownloader2.b();
        }
      }
    }
    a.remove(localIFileVideoDownloader1);
    a.add(0, localIFileVideoDownloader1);
    QLog.i("FileVideoDownloadManager<FileAssistant>XOXO", 1, String.format("downloa %s set to head and stop other succ!", new Object[] { paramString }));
    localIFileVideoDownloader1.a();
  }
  
  public static void c(String paramString)
  {
    IFileVideoDownloader localIFileVideoDownloader = a(paramString);
    if (localIFileVideoDownloader == null)
    {
      QLog.w("FileVideoDownloadManager<FileAssistant>XOXO", 1, String.format("%s not in downloadList", new Object[] { paramString }));
      return;
    }
    localIFileVideoDownloader.c();
  }
  
  public static void d(String paramString)
  {
    IFileVideoDownloader localIFileVideoDownloader = a(paramString);
    if (localIFileVideoDownloader == null)
    {
      QLog.i("FileVideoDownloadManager<FileAssistant>XOXO", 1, "cann't find downloader with:" + paramString);
      return;
    }
    localIFileVideoDownloader.b();
    synchronized (a)
    {
      a.remove(localIFileVideoDownloader);
      QLog.i("FileVideoDownloadManager<FileAssistant>XOXO", 1, String.format("####  remove downloader:%s, mapsize:%d", new Object[] { paramString, Integer.valueOf(a.size()) }));
      return;
    }
  }
  
  private static void e(String paramString)
  {
    IFileVideoDownloader localIFileVideoDownloader = a(paramString);
    if (localIFileVideoDownloader != null)
    {
      QLog.i("FileVideoDownloadManager<FileAssistant>XOXO", 1, String.format("####   %s pause!", new Object[] { paramString }));
      localIFileVideoDownloader.b();
    }
    for (;;)
    {
      d(paramString);
      return;
      QLog.w("FileVideoDownloadManager<FileAssistant>XOXO", 1, String.format("####   %s pause failed, not find!", new Object[] { paramString }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.FileVideoDownloadManager
 * JD-Core Version:    0.7.0.1
 */