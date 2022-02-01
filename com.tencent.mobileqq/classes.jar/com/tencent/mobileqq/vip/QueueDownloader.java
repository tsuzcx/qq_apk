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
  }
  
  public int a(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QueueDownloader", 2, "cancelTask stopAll=" + paramBoolean + ",key=" + paramString);
    }
    Object localObject;
    synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
    {
      if (this.jdField_a_of_type_JavaUtilLinkedList.isEmpty()) {
        break label115;
      }
      if (!paramBoolean) {
        break label119;
      }
      paramString = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
      if (paramString.hasNext())
      {
        localObject = (DownloadTask)paramString.next();
        ((DownloadTask)localObject).a(true);
        ((DownloadTask)localObject).j();
      }
    }
    this.jdField_a_of_type_JavaUtilLinkedList.clear();
    for (;;)
    {
      label115:
      return 0;
      label119:
      if ((paramString == null) || (TextUtils.isEmpty(paramString))) {
        break;
      }
      localObject = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
      ArrayList localArrayList = new ArrayList();
      while (((Iterator)localObject).hasNext())
      {
        DownloadTask localDownloadTask = (DownloadTask)((Iterator)localObject).next();
        if (paramString.equals(localDownloadTask.jdField_a_of_type_JavaLangString))
        {
          if (!localDownloadTask.a())
          {
            ((Iterator)localObject).remove();
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
          ((Iterator)localObject).remove();
          localArrayList.add(localDownloadTask);
        }
      }
      if (localArrayList.size() > 0) {
        this.jdField_a_of_type_JavaUtilLinkedList.removeAll(localArrayList);
      }
    }
    return -1;
  }
  
  public DownloadTask a(String paramString)
  {
    LinkedList localLinkedList = this.jdField_a_of_type_JavaUtilLinkedList;
    if (paramString != null) {}
    try
    {
      if (!this.jdField_a_of_type_JavaUtilLinkedList.isEmpty())
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
        while (localIterator.hasNext())
        {
          DownloadTask localDownloadTask = (DownloadTask)localIterator.next();
          if (paramString.equals(localDownloadTask.jdField_a_of_type_JavaLangString))
          {
            if (QLog.isColorLevel()) {
              QLog.d("QueueDownloader", 2, "getTask | " + paramString + " task find =" + localDownloadTask);
            }
            return localDownloadTask;
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("QueueDownloader", 2, "getTask | " + paramString + " task not find");
      }
      return null;
    }
    finally {}
  }
  
  void a()
  {
    for (;;)
    {
      try
      {
        synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
        {
          Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
          if (!localIterator.hasNext()) {
            break label185;
          }
          DownloadTask localDownloadTask2 = (DownloadTask)localIterator.next();
          if (localDownloadTask2.d <= 0L) {
            break label316;
          }
          long l = System.currentTimeMillis() / 1000L;
          if ((!localDownloadTask2.a()) && (l > localDownloadTask2.c + localDownloadTask2.d))
          {
            bool = true;
            if ((!localDownloadTask2.b()) && (!bool)) {
              continue;
            }
            localIterator.remove();
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("QueueDownloader", 2, "remove task[" + localDownloadTask2.jdField_a_of_type_JavaLangString + "], isCancal=" + localDownloadTask2.b() + ", timeOut=" + bool);
          }
        }
        bool = false;
      }
      finally {}
      continue;
      label185:
      if (QLog.isColorLevel()) {
        QLog.d("QueueDownloader", 2, "doTask | downloadLimitCount=" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() + ",maxDownloadCount=" + 3 + ",downloadQueue size=" + this.jdField_a_of_type_JavaUtilLinkedList.size());
      }
      for (;;)
      {
        DownloadTask localDownloadTask1;
        if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() <= 3)
        {
          localDownloadTask1 = a();
          if (localDownloadTask1 != null) {
            break label288;
          }
          if (QLog.isColorLevel()) {
            QLog.d("QueueDownloader", 2, "doTask | run() null");
          }
        }
        return;
        label288:
        ThreadManager.postDownLoadTask(new QueueDownloader.1(this, localDownloadTask1), 2, null, false);
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.addAndGet(1);
      }
      label316:
      boolean bool = false;
    }
  }
  
  public void a(DownloadTask paramDownloadTask)
  {
    LinkedList localLinkedList = this.jdField_a_of_type_JavaUtilLinkedList;
    if (paramDownloadTask != null) {}
    try
    {
      if ((!this.jdField_a_of_type_JavaUtilLinkedList.isEmpty()) && (this.jdField_a_of_type_JavaUtilLinkedList.contains(paramDownloadTask)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QueueDownloader", 2, "removeTask | task=" + paramDownloadTask);
        }
        paramDownloadTask.j();
        this.jdField_a_of_type_JavaUtilLinkedList.remove(paramDownloadTask);
      }
      return;
    }
    finally {}
  }
  
  public void a(DownloadTask paramDownloadTask, DownloadListener arg2, Bundle paramBundle)
  {
    if ((!DownloaderFactory.a(paramDownloadTask)) || (a(paramDownloadTask.jdField_a_of_type_JavaLangString) == paramDownloadTask)) {}
    DownloadTask localDownloadTask;
    do
    {
      return;
      localDownloadTask = a(paramDownloadTask.jdField_a_of_type_JavaLangString);
      if (localDownloadTask == null) {
        break;
      }
    } while ((localDownloadTask == null) || (!localDownloadTask.s));
    paramDownloadTask.a(???);
    paramDownloadTask.a(paramBundle);
    ??? = BaseApplicationImpl.getApplication().getRuntime();
    if ((??? != null) && (paramDownloadTask.jdField_a_of_type_ComTencentMobileqqVipDownloadTask$ReportInfo.a < 0L)) {
      paramDownloadTask.jdField_a_of_type_ComTencentMobileqqVipDownloadTask$ReportInfo.a = ???.getLongAccountUin();
    }
    localDownloadTask.a(paramDownloadTask);
    return;
    paramDownloadTask.a(???);
    paramDownloadTask.a(paramBundle);
    ??? = BaseApplicationImpl.getApplication().getRuntime();
    if ((??? != null) && (paramDownloadTask.jdField_a_of_type_ComTencentMobileqqVipDownloadTask$ReportInfo.a < 0L)) {
      paramDownloadTask.jdField_a_of_type_ComTencentMobileqqVipDownloadTask$ReportInfo.a = ???.getLongAccountUin();
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
      {
        paramBundle = a(paramDownloadTask.jdField_a_of_type_JavaLangString);
        if (paramBundle == null)
        {
          paramDownloadTask.c = ((int)(System.currentTimeMillis() / 1000L));
          if (paramDownloadTask.b)
          {
            this.jdField_a_of_type_JavaUtilLinkedList.addFirst(paramDownloadTask);
            if (QLog.isColorLevel()) {
              QLog.d("QueueDownloader", 2, "startDownload | task=" + paramDownloadTask.jdField_a_of_type_JavaLangString);
            }
            a();
            return;
          }
          this.jdField_a_of_type_JavaUtilLinkedList.addLast(paramDownloadTask);
        }
      }
      if ((paramDownloadTask.b) && (!paramBundle.a()) && (this.jdField_a_of_type_JavaUtilLinkedList.remove(paramBundle))) {
        this.jdField_a_of_type_JavaUtilLinkedList.addFirst(paramBundle);
      }
    }
  }
  
  public void b()
  {
    a(true, null);
  }
  
  public void onNetMobile2None()
  {
    if ((this.jdField_a_of_type_JavaUtilLinkedList != null) && (this.jdField_a_of_type_JavaUtilLinkedList.size() > 0))
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
    if ((this.jdField_a_of_type_JavaUtilLinkedList != null) && (this.jdField_a_of_type_JavaUtilLinkedList.size() > 0)) {
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
      }
    }
  }
  
  public void onNetWifi2None()
  {
    if ((this.jdField_a_of_type_JavaUtilLinkedList != null) && (this.jdField_a_of_type_JavaUtilLinkedList.size() > 0))
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
      }
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if ((this.jdField_a_of_type_JavaUtilLinkedList != null) && (this.jdField_a_of_type_JavaUtilLinkedList.size() > 0)) {
      synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
        if (localIterator.hasNext())
        {
          DownloadTask localDownloadTask = (DownloadTask)localIterator.next();
          localStringBuilder.append("key=").append(localDownloadTask.jdField_a_of_type_JavaLangString);
          if ((localDownloadTask.jdField_a_of_type_JavaUtilList != null) && (localDownloadTask.jdField_a_of_type_JavaUtilList.size() > 0)) {
            localStringBuilder.append(",size=").append(localDownloadTask.jdField_a_of_type_JavaUtilList.size()).append(",url=").append((String)localDownloadTask.jdField_a_of_type_JavaUtilList.get(0));
          }
          localStringBuilder.append(";");
        }
      }
    }
    return "QueueDownloader task url:" + localObject.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vip.QueueDownloader
 * JD-Core Version:    0.7.0.1
 */