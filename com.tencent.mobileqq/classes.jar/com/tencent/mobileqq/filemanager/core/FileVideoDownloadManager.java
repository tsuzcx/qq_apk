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
    
    if (!QQVideoPlaySDKManager.isSDKReady()) {
      QQVideoPlaySDKManager.initSDKAsync(BaseApplicationImpl.getApplication(), new FileVideoDownloadManager.1());
    }
  }
  
  public static void a()
  {
    ??? = a.iterator();
    while (((Iterator)???).hasNext()) {
      ((IFileVideoDownloader)((Iterator)???).next()).d();
    }
    synchronized (a)
    {
      a.clear();
      return;
    }
    for (;;)
    {
      throw localObject2;
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
    paramString = f(paramString);
    if (paramString == null) {
      return;
    }
    paramString.a(paramBoolean ^ true);
  }
  
  public static IFileVideoDownloader b(BaseVideoBiz arg0)
  {
    String str1 = ???.a();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("try create downloader:");
    ((StringBuilder)localObject2).append(str1);
    QLog.i("FileVideoDownloadManager<FileAssistant>XOXO", 1, ((StringBuilder)localObject2).toString());
    localObject2 = f(str1);
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("new downloader:");
      localStringBuilder.append(str2);
      QLog.i("FileVideoDownloadManager<FileAssistant>XOXO", 1, localStringBuilder.toString());
      a.add(0, localObject2);
      return localObject2;
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
      if (localIFileVideoDownloader.e())
      {
        QLog.i("FileVideoDownloadManager<FileAssistant>XOXO", 1, String.format("%s downloading", new Object[] { localIFileVideoDownloader.b() }));
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
      localIFileVideoDownloader.c();
      QLog.i("FileVideoDownloadManager<FileAssistant>XOXO", 1, String.format("start %s to download", new Object[] { localIFileVideoDownloader.b() }));
      return;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public static void b(String paramString)
  {
    IFileVideoDownloader localIFileVideoDownloader1 = f(paramString);
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
          localIFileVideoDownloader2.d();
        }
      }
      a.remove(localIFileVideoDownloader1);
      a.add(0, localIFileVideoDownloader1);
      QLog.i("FileVideoDownloadManager<FileAssistant>XOXO", 1, String.format("downloa %s set to head and stop other succ!", new Object[] { paramString }));
      localIFileVideoDownloader1.c();
      return;
    }
    for (;;)
    {
      throw paramString;
    }
  }
  
  public static void c(String paramString)
  {
    IFileVideoDownloader localIFileVideoDownloader = f(paramString);
    if (localIFileVideoDownloader == null)
    {
      QLog.w("FileVideoDownloadManager<FileAssistant>XOXO", 1, String.format("%s not in downloadList", new Object[] { paramString }));
      return;
    }
    localIFileVideoDownloader.f();
  }
  
  public static void d(String paramString)
  {
    IFileVideoDownloader localIFileVideoDownloader = f(paramString);
    if (localIFileVideoDownloader == null)
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("cann't find downloader with:");
      ((StringBuilder)???).append(paramString);
      QLog.i("FileVideoDownloadManager<FileAssistant>XOXO", 1, ((StringBuilder)???).toString());
      return;
    }
    localIFileVideoDownloader.d();
    synchronized (a)
    {
      a.remove(localIFileVideoDownloader);
      QLog.i("FileVideoDownloadManager<FileAssistant>XOXO", 1, String.format("####  remove downloader:%s, mapsize:%d", new Object[] { paramString, Integer.valueOf(a.size()) }));
      return;
    }
  }
  
  private static void e(String paramString)
  {
    IFileVideoDownloader localIFileVideoDownloader = f(paramString);
    if (localIFileVideoDownloader != null)
    {
      QLog.i("FileVideoDownloadManager<FileAssistant>XOXO", 1, String.format("####   %s pause!", new Object[] { paramString }));
      localIFileVideoDownloader.d();
    }
    else
    {
      QLog.w("FileVideoDownloadManager<FileAssistant>XOXO", 1, String.format("####   %s pause failed, not find!", new Object[] { paramString }));
    }
    d(paramString);
  }
  
  private static IFileVideoDownloader f(String paramString)
  {
    synchronized (a)
    {
      Iterator localIterator = a.iterator();
      IFileVideoDownloader localIFileVideoDownloader;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localIFileVideoDownloader = (IFileVideoDownloader)localIterator.next();
      } while (!localIFileVideoDownloader.b().equalsIgnoreCase(paramString));
      paramString = localIFileVideoDownloader;
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.FileVideoDownloadManager
 * JD-Core Version:    0.7.0.1
 */