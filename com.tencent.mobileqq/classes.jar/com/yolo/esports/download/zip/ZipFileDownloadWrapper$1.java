package com.yolo.esports.download.zip;

import com.tencent.qphone.base.util.QLog;
import com.yolo.esports.download.cb.DownloadTaskListener;
import com.yolo.esports.download.cb.ZipFileDownloadListener;
import com.yolo.esports.download.common.DownloadInfo;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

class ZipFileDownloadWrapper$1
  implements DownloadTaskListener
{
  public void a(DownloadInfo paramDownloadInfo)
  {
    this.a.b(paramDownloadInfo);
    ZipFileDownloadWrapper.a(this.b).lock();
    paramDownloadInfo = (ZipFileDownloadWrapper.ZipDownloadListenerStruct)ZipFileDownloadWrapper.b(this.b).get(this.a.a());
    if (paramDownloadInfo == null)
    {
      ZipFileDownloadWrapper.a(this.b).unlock();
      return;
    }
    paramDownloadInfo = paramDownloadInfo.a;
    ZipFileDownloadWrapper.a(this.b).unlock();
    paramDownloadInfo = paramDownloadInfo.iterator();
    while (paramDownloadInfo.hasNext())
    {
      ZipFileDownloadListener localZipFileDownloadListener = (ZipFileDownloadListener)paramDownloadInfo.next();
      if (localZipFileDownloadListener != null) {
        try
        {
          localZipFileDownloadListener.a(this.a);
        }
        catch (Exception localException)
        {
          QLog.e("ZipFileDownloadUtils_", 1, "onTaskStart callback error", localException);
        }
      }
    }
  }
  
  public void b(DownloadInfo paramDownloadInfo)
  {
    this.a.b(paramDownloadInfo);
    ZipFileDownloadWrapper.a(this.b).lock();
    paramDownloadInfo = (ZipFileDownloadWrapper.ZipDownloadListenerStruct)ZipFileDownloadWrapper.b(this.b).get(this.a.a());
    if (paramDownloadInfo == null)
    {
      ZipFileDownloadWrapper.a(this.b).unlock();
      return;
    }
    paramDownloadInfo = paramDownloadInfo.a;
    ZipFileDownloadWrapper.a(this.b).unlock();
    Iterator localIterator = paramDownloadInfo.iterator();
    while (localIterator.hasNext())
    {
      ZipFileDownloadListener localZipFileDownloadListener = (ZipFileDownloadListener)localIterator.next();
      if (localZipFileDownloadListener != null) {
        try
        {
          localZipFileDownloadListener.b(this.a);
        }
        catch (Exception localException)
        {
          QLog.e("ZipFileDownloadUtils_", 1, "onTaskStateChanged callback error", localException);
        }
      }
    }
    if ((this.a.c()) && (this.a.y)) {
      ZipFileDownloadWrapper.a(this.b, this.a, paramDownloadInfo);
    }
  }
  
  public void c(DownloadInfo paramDownloadInfo)
  {
    this.a.b(paramDownloadInfo);
    ZipFileDownloadWrapper.a(this.b).lock();
    paramDownloadInfo = (ZipFileDownloadWrapper.ZipDownloadListenerStruct)ZipFileDownloadWrapper.b(this.b).get(this.a.a());
    if (paramDownloadInfo == null)
    {
      ZipFileDownloadWrapper.a(this.b).unlock();
      return;
    }
    paramDownloadInfo = paramDownloadInfo.a;
    ZipFileDownloadWrapper.a(this.b).unlock();
    paramDownloadInfo = paramDownloadInfo.iterator();
    while (paramDownloadInfo.hasNext())
    {
      ZipFileDownloadListener localZipFileDownloadListener = (ZipFileDownloadListener)paramDownloadInfo.next();
      if (localZipFileDownloadListener != null) {
        try
        {
          localZipFileDownloadListener.c(this.a);
        }
        catch (Exception localException)
        {
          QLog.e("ZipFileDownloadUtils_", 1, "onTaskProgressChanged callback error", localException);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.yolo.esports.download.zip.ZipFileDownloadWrapper.1
 * JD-Core Version:    0.7.0.1
 */