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
  private DownloaderFactory.DownloadConfig jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory$DownloadConfig;
  private LinkedList<DownloadTask> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(1);
  
  public QueueDownloader(AppRuntime paramAppRuntime, DownloaderFactory.DownloadConfig paramDownloadConfig)
  {
    DownloaderFactory.DownloadConfig localDownloadConfig = paramDownloadConfig;
    if (paramDownloadConfig == null) {
      localDownloadConfig = new DownloaderFactory.DownloadConfig();
    }
    this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory$DownloadConfig = localDownloadConfig;
    if (this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory$DownloadConfig.a) {
      AppNetConnInfo.registerConnectionChangeReceiver(paramAppRuntime.getApplication(), this);
    }
  }
  
  private DownloadTask a()
  {
    synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
    {
      if (!this.jdField_a_of_type_JavaUtilLinkedList.isEmpty())
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
        while (localIterator.hasNext())
        {
          DownloadTask localDownloadTask = (DownloadTask)localIterator.next();
          if (!localDownloadTask.a())
          {
            localDownloadTask.a();
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
      synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
        while (localIterator.hasNext())
        {
          DownloadTask localDownloadTask = (DownloadTask)localIterator.next();
          long l = localDownloadTask.d;
          boolean bool2 = false;
          boolean bool1 = bool2;
          if (l > 0L)
          {
            l = System.currentTimeMillis() / 1000L;
            bool1 = bool2;
            if (!localDownloadTask.a())
            {
              bool1 = bool2;
              if (l > localDownloadTask.c + localDownloadTask.d) {
                bool1 = true;
              }
            }
          }
          if ((localDownloadTask.b()) || (bool1))
          {
            localIterator.remove();
            if (QLog.isColorLevel())
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("remove task[");
              localStringBuilder.append(localDownloadTask.jdField_a_of_type_JavaLangString);
              localStringBuilder.append("], isCancal=");
              localStringBuilder.append(localDownloadTask.b());
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
          ((StringBuilder)???).append(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
          ((StringBuilder)???).append(",maxDownloadCount=");
          ((StringBuilder)???).append(3);
          ((StringBuilder)???).append(",downloadQueue size=");
          ((StringBuilder)???).append(this.jdField_a_of_type_JavaUtilLinkedList.size());
          QLog.d("QueueDownloader", 2, ((StringBuilder)???).toString());
        }
        while (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() <= 3)
        {
          ??? = a();
          if (??? == null)
          {
            QLog.d("QueueDownloader", 2, "doTask | run() null");
            return;
          }
          b((DownloadTask)???);
          this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.addAndGet(1);
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
    LinkedList localLinkedList = this.jdField_a_of_type_JavaUtilLinkedList;
    if (paramDownloadTask != null) {}
    try
    {
      if ((!this.jdField_a_of_type_JavaUtilLinkedList.isEmpty()) && (this.jdField_a_of_type_JavaUtilLinkedList.contains(paramDownloadTask)))
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("removeTask | task=");
          localStringBuilder.append(paramDownloadTask);
          QLog.d("QueueDownloader", 2, localStringBuilder.toString());
        }
        paramDownloadTask.j();
        this.jdField_a_of_type_JavaUtilLinkedList.remove(paramDownloadTask);
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
    synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
    {
      if (!this.jdField_a_of_type_JavaUtilLinkedList.isEmpty())
      {
        Object localObject2;
        if (paramBoolean)
        {
          paramString = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
          while (paramString.hasNext())
          {
            localObject2 = (DownloadTask)paramString.next();
            ((DownloadTask)localObject2).a(true);
            ((DownloadTask)localObject2).j();
          }
          this.jdField_a_of_type_JavaUtilLinkedList.clear();
        }
        else if ((paramString != null) && (!TextUtils.isEmpty(paramString)))
        {
          localObject2 = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
          ArrayList localArrayList = new ArrayList();
          while (((Iterator)localObject2).hasNext())
          {
            DownloadTask localDownloadTask = (DownloadTask)((Iterator)localObject2).next();
            if (paramString.equals(localDownloadTask.jdField_a_of_type_JavaLangString))
            {
              if (!localDownloadTask.a())
              {
                ((Iterator)localObject2).remove();
                localArrayList.add(localDownloadTask);
              }
              else
              {
                localDownloadTask.a(true);
                localDownloadTask.j();
              }
            }
            else if ((localDownloadTask.b()) && (!localDownloadTask.a()))
            {
              ((Iterator)localObject2).remove();
              localArrayList.add(localDownloadTask);
            }
          }
          if (localArrayList.size() > 0) {
            this.jdField_a_of_type_JavaUtilLinkedList.removeAll(localArrayList);
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
    Object localObject1 = this.jdField_a_of_type_JavaUtilLinkedList;
    if (paramString != null) {}
    try
    {
      if (!this.jdField_a_of_type_JavaUtilLinkedList.isEmpty())
      {
        Object localObject2 = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          DownloadTask localDownloadTask = (DownloadTask)((Iterator)localObject2).next();
          if (paramString.equals(localDownloadTask.jdField_a_of_type_JavaLangString))
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
    ??? = this.jdField_a_of_type_JavaUtilLinkedList;
    if ((??? != null) && (???.size() > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QueueDownloader", 2, "queueDownload network-onNetMobile2None");
      }
      synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
        while (localIterator.hasNext())
        {
          DownloadTask localDownloadTask = (DownloadTask)localIterator.next();
          if (localDownloadTask.a() == 2) {
            localDownloadTask.i();
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
    ??? = this.jdField_a_of_type_JavaUtilLinkedList;
    if ((??? != null) && (???.size() > 0)) {
      synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
        while (localIterator.hasNext())
        {
          DownloadTask localDownloadTask = (DownloadTask)localIterator.next();
          if (localDownloadTask.a() == 2) {
            localDownloadTask.g();
          }
        }
        return;
      }
    }
  }
  
  public void onNetWifi2None()
  {
    ??? = this.jdField_a_of_type_JavaUtilLinkedList;
    if ((??? != null) && (???.size() > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QueueDownloader", 2, "queueDownload network-onNetWifi2None");
      }
      synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
        while (localIterator.hasNext())
        {
          DownloadTask localDownloadTask = (DownloadTask)localIterator.next();
          if (localDownloadTask.a() == 2) {
            localDownloadTask.h();
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
      if (getTask(paramDownloadTask.jdField_a_of_type_JavaLangString) == paramDownloadTask) {
        return;
      }
      DownloadTask localDownloadTask = getTask(paramDownloadTask.jdField_a_of_type_JavaLangString);
      if (localDownloadTask != null)
      {
        if (localDownloadTask.s)
        {
          paramDownloadTask.a(???);
          paramDownloadTask.a(paramBundle);
          ??? = BaseApplicationImpl.getApplication().getRuntime();
          if ((??? != null) && (paramDownloadTask.jdField_a_of_type_ComTencentMobileqqVipDownloadTask$ReportInfo.a < 0L)) {
            paramDownloadTask.jdField_a_of_type_ComTencentMobileqqVipDownloadTask$ReportInfo.a = ???.getLongAccountUin();
          }
          localDownloadTask.a(paramDownloadTask);
        }
        return;
      }
      paramDownloadTask.a(???);
      paramDownloadTask.a(paramBundle);
      ??? = BaseApplicationImpl.getApplication().getRuntime();
      if ((??? != null) && (paramDownloadTask.jdField_a_of_type_ComTencentMobileqqVipDownloadTask$ReportInfo.a < 0L)) {
        paramDownloadTask.jdField_a_of_type_ComTencentMobileqqVipDownloadTask$ReportInfo.a = ???.getLongAccountUin();
      }
      synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
      {
        paramBundle = getTask(paramDownloadTask.jdField_a_of_type_JavaLangString);
        if (paramBundle == null)
        {
          paramDownloadTask.c = ((int)(System.currentTimeMillis() / 1000L));
          if (paramDownloadTask.b) {
            this.jdField_a_of_type_JavaUtilLinkedList.addFirst(paramDownloadTask);
          } else {
            this.jdField_a_of_type_JavaUtilLinkedList.addLast(paramDownloadTask);
          }
        }
        else if ((paramDownloadTask.b) && (!paramBundle.a()) && (this.jdField_a_of_type_JavaUtilLinkedList.remove(paramBundle)))
        {
          this.jdField_a_of_type_JavaUtilLinkedList.addFirst(paramBundle);
        }
        ??? = new StringBuilder();
        ???.append("startDownload | task=");
        ???.append(paramDownloadTask.jdField_a_of_type_JavaLangString);
        QLog.d("QueueDownloader", 2, ???.toString());
        a();
        return;
      }
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    ??? = this.jdField_a_of_type_JavaUtilLinkedList;
    if ((??? != null) && (((LinkedList)???).size() > 0)) {
      synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
        while (localIterator.hasNext())
        {
          DownloadTask localDownloadTask = (DownloadTask)localIterator.next();
          localStringBuilder.append("key=");
          localStringBuilder.append(localDownloadTask.jdField_a_of_type_JavaLangString);
          if ((localDownloadTask.jdField_a_of_type_JavaUtilList != null) && (localDownloadTask.jdField_a_of_type_JavaUtilList.size() > 0))
          {
            localStringBuilder.append(",size=");
            localStringBuilder.append(localDownloadTask.jdField_a_of_type_JavaUtilList.size());
            localStringBuilder.append(",url=");
            localStringBuilder.append((String)localDownloadTask.jdField_a_of_type_JavaUtilList.get(0));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vip.QueueDownloader
 * JD-Core Version:    0.7.0.1
 */