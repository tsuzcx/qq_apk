package com.tencent.mobileqq.vip;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;

class QueueDownloader$1
  implements Runnable
{
  QueueDownloader$1(QueueDownloader paramQueueDownloader, DownloadTask paramDownloadTask) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("doTask | run() downloadLimitCount=");
      ((StringBuilder)localObject).append(this.this$0.a.get());
      ((StringBuilder)localObject).append(",task=");
      ((StringBuilder)localObject).append(this.a);
      QLog.d("QueueDownloader", 2, ((StringBuilder)localObject).toString());
    }
    if ((this.a.c) && (DownloaderFactory.a(this.a.jdField_a_of_type_JavaLangString)))
    {
      localObject = this.a;
      ((DownloadTask)localObject).jdField_a_of_type_Int = -101;
      ((DownloadTask)localObject).a(-1);
      this.a.f();
      this.this$0.a(this.a);
      this.this$0.a.addAndGet(-1);
      this.this$0.a();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("doTask | run() task is limit of failTime, task=");
        ((StringBuilder)localObject).append(this.a);
        QLog.d("QueueDownloader", 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    int i = DownloaderFactory.a(this.a, (AppRuntime)localObject);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("doTask | run() download task result=");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(",task=");
      ((StringBuilder)localObject).append(this.a);
      QLog.d("QueueDownloader", 2, ((StringBuilder)localObject).toString());
    }
    this.this$0.a(this.a);
    this.this$0.a.addAndGet(-1);
    this.this$0.a();
  }
  
  public String toString()
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      if ((this.a.jdField_a_of_type_JavaUtilList != null) && (this.a.jdField_a_of_type_JavaUtilList.size() != 0)) {
        str = (String)this.a.jdField_a_of_type_JavaUtilList.get(0);
      } else {
        str = this.a.jdField_a_of_type_JavaLangString;
      }
      localStringBuilder.append("QueueDownloader");
      localStringBuilder.append(" current task:");
      localStringBuilder.append(str);
      localStringBuilder.append(",downloadQueue size:");
      int i;
      if (QueueDownloader.a(this.this$0) == null) {
        i = 0;
      } else {
        i = QueueDownloader.a(this.this$0).size();
      }
      localStringBuilder.append(i);
      String str = localStringBuilder.toString();
      return str;
    }
    catch (Exception localException)
    {
      QLog.e("QueueDownloader", 1, localException, new Object[0]);
    }
    return super.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vip.QueueDownloader.1
 * JD-Core Version:    0.7.0.1
 */