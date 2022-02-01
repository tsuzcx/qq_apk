package com.tencent.mobileqq.vip;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;

final class QueueDownloader
  implements INetInfoHandler, DownloaderInterface
{
  AtomicInteger a = new AtomicInteger(1);
  private DownloaderFactory.DownloadConfig b;
  private LinkedList<DownloadTask> c = new LinkedList();
  
  public QueueDownloader(AppRuntime paramAppRuntime, DownloaderFactory.DownloadConfig paramDownloadConfig)
  {
    DownloaderFactory.DownloadConfig localDownloadConfig = paramDownloadConfig;
    if (paramDownloadConfig == null) {
      localDownloadConfig = new DownloaderFactory.DownloadConfig();
    }
    this.b = localDownloadConfig;
    if (this.b.a) {
      AppNetConnInfo.registerConnectionChangeReceiver(paramAppRuntime.getApplication(), this);
    }
  }
  
  private DownloadTask b()
  {
    synchronized (this.c)
    {
      if (!this.c.isEmpty())
      {
        Iterator localIterator = this.c.iterator();
        while (localIterator.hasNext())
        {
          DownloadTask localDownloadTask = (DownloadTask)localIterator.next();
          if (!localDownloadTask.c())
          {
            localDownloadTask.d();
            return localDownloadTask;
          }
        }
      }
      return null;
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  private void b(@NotNull DownloadTask paramDownloadTask)
  {
    ThreadManager.postDownLoadTask(new QueueDownloader.1(this, paramDownloadTask), 2, null, false);
  }
  
  void a()
  {
    try
    {
      synchronized (this.c)
      {
        Iterator localIterator = this.c.iterator();
        while (localIterator.hasNext())
        {
          DownloadTask localDownloadTask = (DownloadTask)localIterator.next();
          long l = localDownloadTask.u;
          boolean bool2 = false;
          boolean bool1 = bool2;
          if (l > 0L)
          {
            l = System.currentTimeMillis() / 1000L;
            bool1 = bool2;
            if (!localDownloadTask.c())
            {
              bool1 = bool2;
              if (l > localDownloadTask.t + localDownloadTask.u) {
                bool1 = true;
              }
            }
          }
          if ((localDownloadTask.f()) || (bool1))
          {
            localIterator.remove();
            if (QLog.isColorLevel())
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("remove task[");
              localStringBuilder.append(localDownloadTask.b);
              localStringBuilder.append("], isCancal=");
              localStringBuilder.append(localDownloadTask.f());
              localStringBuilder.append(", timeOut=");
              localStringBuilder.append(bool1);
              QLog.d("QueueDownloader", 2, localStringBuilder.toString());
            }
          }
        }
        if (QLog.isColorLevel())
        {
          ??? = new StringBuilder();
          ((StringBuilder)???).append("doTask | downloadLimitCount=");
          ((StringBuilder)???).append(this.a.get());
          ((StringBuilder)???).append(",maxDownloadCount=");
          ((StringBuilder)???).append(3);
          ((StringBuilder)???).append(",downloadQueue size=");
          ((StringBuilder)???).append(this.c.size());
          QLog.d("QueueDownloader", 2, ((StringBuilder)???).toString());
        }
        while (this.a.get() <= 3)
        {
          ??? = b();
          if (??? == null)
          {
            QLog.d("QueueDownloader", 2, "doTask | run() null");
            return;
          }
          b((DownloadTask)???);
          this.a.addAndGet(1);
        }
        return;
      }
      throw localObject2;
    }
    finally {}
    for (;;) {}
  }
  
  public void a(DownloadTask paramDownloadTask)
  {
    LinkedList localLinkedList = this.c;
    if (paramDownloadTask != null) {}
    try
    {
      if ((!this.c.isEmpty()) && (this.c.contains(paramDownloadTask)))
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("removeTask | task=");
          localStringBuilder.append(paramDownloadTask);
          QLog.d("QueueDownloader", 2, localStringBuilder.toString());
        }
        paramDownloadTask.r();
        this.c.remove(paramDownloadTask);
      }
      return;
    }
    finally {}
  }
  
  public int cancelTask(boolean paramBoolean, String paramString)
  {
    ??? = new StringBuilder();
    ((StringBuilder)???).append("cancelTask stopAll=");
    ((StringBuilder)???).append(paramBoolean);
    ((StringBuilder)???).append(",key=");
    ((StringBuilder)???).append(paramString);
    QLog.d("QueueDownloader", 2, ((StringBuilder)???).toString());
    synchronized (this.c)
    {
      if (!this.c.isEmpty())
      {
        Object localObject2;
        if (paramBoolean)
        {
          paramString = this.c.iterator();
          while (paramString.hasNext())
          {
            localObject2 = (DownloadTask)paramString.next();
            ((DownloadTask)localObject2).a(true);
            ((DownloadTask)localObject2).r();
          }
          this.c.clear();
        }
        else if ((paramString != null) && (!TextUtils.isEmpty(paramString)))
        {
          localObject2 = this.c.iterator();
          ArrayList localArrayList = new ArrayList();
          while (((Iterator)localObject2).hasNext())
          {
            DownloadTask localDownloadTask = (DownloadTask)((Iterator)localObject2).next();
            if (paramString.equals(localDownloadTask.b))
            {
              if (!localDownloadTask.c())
              {
                ((Iterator)localObject2).remove();
                localArrayList.add(localDownloadTask);
              }
              else
              {
                localDownloadTask.a(true);
                localDownloadTask.r();
              }
            }
            else if ((localDownloadTask.f()) && (!localDownloadTask.c()))
            {
              ((Iterator)localObject2).remove();
              localArrayList.add(localDownloadTask);
            }
          }
          if (localArrayList.size() > 0) {
            this.c.removeAll(localArrayList);
          }
        }
        else
        {
          return -1;
        }
      }
      return 0;
    }
    for (;;)
    {
      throw paramString;
    }
  }
  
  public DownloadTask getTask(String paramString)
  {
    Object localObject1 = this.c;
    if (paramString != null) {}
    try
    {
      if (!this.c.isEmpty())
      {
        Object localObject2 = this.c.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          DownloadTask localDownloadTask = (DownloadTask)((Iterator)localObject2).next();
          if (paramString.equals(localDownloadTask.b))
          {
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("getTask | ");
              ((StringBuilder)localObject2).append(paramString);
              ((StringBuilder)localObject2).append(" task find =");
              ((StringBuilder)localObject2).append(localDownloadTask);
              QLog.d("QueueDownloader", 2, ((StringBuilder)localObject2).toString());
            }
            return localDownloadTask;
          }
        }
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("getTask | ");
        ((StringBuilder)localObject1).append(paramString);
        ((StringBuilder)localObject1).append(" task not find");
        QLog.d("QueueDownloader", 2, ((StringBuilder)localObject1).toString());
      }
      return null;
    }
    finally {}
    for (;;)
    {
      throw paramString;
    }
  }
  
  public void onDestroy()
  {
    cancelTask(true, null);
  }
  
  public void onNetMobile2None()
  {
    ??? = this.c;
    if ((??? != null) && (???.size() > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QueueDownloader", 2, "queueDownload network-onNetMobile2None");
      }
      synchronized (this.c)
      {
        Iterator localIterator = this.c.iterator();
        while (localIterator.hasNext())
        {
          DownloadTask localDownloadTask = (DownloadTask)localIterator.next();
          if (localDownloadTask.e() == 2) {
            localDownloadTask.q();
          }
        }
        return;
      }
    }
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QueueDownloader", 2, "queueDownload network-onNetMobile2Wifi");
    }
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QueueDownloader", 2, "queueDownload network-onNetNone2Mobile");
    }
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QueueDownloader", 2, "queueDownload network-onNetNone2Wifi");
    }
  }
  
  public void onNetWifi2Mobile(String arg1)
  {
    ??? = this.c;
    if ((??? != null) && (???.size() > 0)) {
      synchronized (this.c)
      {
        Iterator localIterator = this.c.iterator();
        while (localIterator.hasNext())
        {
          DownloadTask localDownloadTask = (DownloadTask)localIterator.next();
          if (localDownloadTask.e() == 2) {
            localDownloadTask.o();
          }
        }
        return;
      }
    }
  }
  
  public void onNetWifi2None()
  {
    ??? = this.c;
    if ((??? != null) && (???.size() > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QueueDownloader", 2, "queueDownload network-onNetWifi2None");
      }
      synchronized (this.c)
      {
        Iterator localIterator = this.c.iterator();
        while (localIterator.hasNext())
        {
          DownloadTask localDownloadTask = (DownloadTask)localIterator.next();
          if (localDownloadTask.e() == 2) {
            localDownloadTask.p();
          }
        }
        return;
      }
    }
  }
  
  public void startDownload(DownloadTask paramDownloadTask, DownloadListener arg2, Bundle paramBundle)
  {
    if (DownloaderFactory.a(paramDownloadTask))
    {
      if (getTask(paramDownloadTask.b) == paramDownloadTask) {
        return;
      }
      DownloadTask localDownloadTask = getTask(paramDownloadTask.b);
      if (localDownloadTask != null)
      {
        if (localDownloadTask.T)
        {
          paramDownloadTask.a(???);
          paramDownloadTask.a(paramBundle);
          ??? = BaseApplicationImpl.getApplication().getRuntime();
          if ((??? != null) && (paramDownloadTask.S.b < 0L)) {
            paramDownloadTask.S.b = ???.getLongAccountUin();
          }
          localDownloadTask.a(paramDownloadTask);
        }
        return;
      }
      paramDownloadTask.a(???);
      paramDownloadTask.a(paramBundle);
      ??? = BaseApplicationImpl.getApplication().getRuntime();
      if ((??? != null) && (paramDownloadTask.S.b < 0L)) {
        paramDownloadTask.S.b = ???.getLongAccountUin();
      }
      synchronized (this.c)
      {
        paramBundle = getTask(paramDownloadTask.b);
        if (paramBundle == null)
        {
          paramDownloadTask.t = ((int)(System.currentTimeMillis() / 1000L));
          if (paramDownloadTask.m) {
            this.c.addFirst(paramDownloadTask);
          } else {
            this.c.addLast(paramDownloadTask);
          }
        }
        else if ((paramDownloadTask.m) && (!paramBundle.c()) && (this.c.remove(paramBundle)))
        {
          this.c.addFirst(paramBundle);
        }
        ??? = new StringBuilder();
        ???.append("startDownload | task=");
        ???.append(paramDownloadTask.b);
        QLog.d("QueueDownloader", 2, ???.toString());
        a();
        return;
      }
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    ??? = this.c;
    if ((??? != null) && (((LinkedList)???).size() > 0)) {
      synchronized (this.c)
      {
        Iterator localIterator = this.c.iterator();
        while (localIterator.hasNext())
        {
          DownloadTask localDownloadTask = (DownloadTask)localIterator.next();
          localStringBuilder.append("key=");
          localStringBuilder.append(localDownloadTask.b);
          if ((localDownloadTask.f != null) && (localDownloadTask.f.size() > 0))
          {
            localStringBuilder.append(",size=");
            localStringBuilder.append(localDownloadTask.f.size());
            localStringBuilder.append(",url=");
            localStringBuilder.append((String)localDownloadTask.f.get(0));
          }
          localStringBuilder.append(";");
        }
      }
    }
    ??? = new StringBuilder();
    ((StringBuilder)???).append("QueueDownloader task url:");
    ((StringBuilder)???).append(localObject1.toString());
    return ((StringBuilder)???).toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vip.QueueDownloader
 * JD-Core Version:    0.7.0.1
 */