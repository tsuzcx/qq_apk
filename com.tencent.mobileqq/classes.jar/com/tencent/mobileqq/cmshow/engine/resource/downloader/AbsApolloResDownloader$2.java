package com.tencent.mobileqq.cmshow.engine.resource.downloader;

import com.tencent.biz.common.util.ZipUtils;
import com.tencent.mobileqq.cmshow.engine.resource.IApolloResDownloader.OnApolloDownLoadListener;
import com.tencent.mobileqq.cmshow.engine.resource.IApolloResManager;
import com.tencent.mobileqq.cmshow.engine.util.CMResUtil;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;
import mqq.util.LogUtil;

class AbsApolloResDownloader$2
  extends DownloadListener
{
  AbsApolloResDownloader$2(AbsApolloResDownloader paramAbsApolloResDownloader, File paramFile, AppRuntime paramAppRuntime, int paramInt1, int paramInt2, AtomicInteger paramAtomicInteger1, AtomicInteger paramAtomicInteger2, AtomicInteger paramAtomicInteger3, IApolloResDownloader.OnApolloDownLoadListener paramOnApolloDownLoadListener, String paramString, int paramInt3, int[] paramArrayOfInt, int paramInt4) {}
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    super.onDone(paramDownloadTask);
    Object localObject;
    if (3 == paramDownloadTask.e())
    {
      if (CMResUtil.b(this.a))
      {
        try
        {
          paramDownloadTask = this.a;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(this.a.getParent());
          ((StringBuilder)localObject).append(File.separator);
          ZipUtils.unZipFile(paramDownloadTask, ((StringBuilder)localObject).toString());
          this.m.a().a(this.b, this.c, this.d);
        }
        catch (Throwable paramDownloadTask)
        {
          this.e.getAndIncrement();
          QLog.e(this.m.b(), 1, new Object[] { "[downloadApolloRes] unZipFile file error!  resType = ", Integer.valueOf(this.c), " id = ", Integer.valueOf(this.d), paramDownloadTask });
        }
      }
      else
      {
        paramDownloadTask = this.m.b();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[downloadApolloRes] downloaded but local file is not exits, check if it is double download.resType = ");
        ((StringBuilder)localObject).append(this.c);
        ((StringBuilder)localObject).append(" id = ");
        ((StringBuilder)localObject).append(this.d);
        QLog.w(paramDownloadTask, 1, ((StringBuilder)localObject).toString());
      }
    }
    else
    {
      this.a.getParentFile().delete();
      this.e.getAndIncrement();
      QLog.e(this.m.b(), 1, new Object[] { "[downloadApolloRes] download failed!  resType = ", Integer.valueOf(this.c), " id = ", Integer.valueOf(this.d), " task.getStatus() = ", Integer.valueOf(paramDownloadTask.e()), " task.errCode=", Integer.valueOf(paramDownloadTask.c) });
    }
    this.f.getAndIncrement();
    if (this.f.get() == this.g.get())
    {
      paramDownloadTask = this.m;
      localObject = this.h;
      boolean bool;
      if (this.e.get() > 0) {
        bool = false;
      } else {
        bool = true;
      }
      AbsApolloResDownloader.a(paramDownloadTask, (IApolloResDownloader.OnApolloDownLoadListener)localObject, bool, this.i, this.j, this.k, this.l);
      if (QLog.isColorLevel()) {
        QLog.d(this.m.b(), 2, new Object[] { "[downloadApolloRes] download all done. uin = ", LogUtil.wrapLogUin(this.i), "resType = ", Integer.valueOf(this.c), " id = ", Integer.valueOf(this.d), " allCount = ", Integer.valueOf(this.g.get()), " errorCount = ", Integer.valueOf(this.e.get()) });
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.d(this.m.b(), 2, new Object[] { "[downloadApolloRes] download uin:", LogUtil.wrapLogUin(this.i), "resType = ", Integer.valueOf(this.c), " id = ", Integer.valueOf(this.d), " callBackCount = ", Integer.valueOf(this.f.get()), " allCount =  ", Integer.valueOf(this.g.get()) });
    }
    this.a.delete();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.engine.resource.downloader.AbsApolloResDownloader.2
 * JD-Core Version:    0.7.0.1
 */