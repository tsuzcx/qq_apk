package com.tencent.mobileqq.vip;

import beae;
import beag;
import beau;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;

public class QueueDownloader$1
  implements Runnable
{
  public QueueDownloader$1(beau parambeau, beae parambeae) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QueueDownloader", 2, "doTask | run() downloadLimitCount=" + this.this$0.a.get() + ",task=" + this.a);
    }
    if ((this.a.c) && (beag.a(this.a.jdField_a_of_type_JavaLangString)))
    {
      this.a.jdField_a_of_type_Int = -101;
      this.a.a(-1);
      this.a.e();
      this.this$0.a(this.a);
      this.this$0.a.addAndGet(-1);
      this.this$0.a();
      if (QLog.isColorLevel()) {
        QLog.d("QueueDownloader", 2, "doTask | run() task is limit of failTime, task=" + this.a);
      }
      return;
    }
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    int i = beag.a(this.a, localAppRuntime);
    if (QLog.isColorLevel()) {
      QLog.d("QueueDownloader", 2, "doTask | run() download task result=" + i + ",task=" + this.a);
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
      Object localObject;
      if ((this.a.jdField_a_of_type_JavaUtilList == null) || (this.a.jdField_a_of_type_JavaUtilList.size() == 0))
      {
        localObject = this.a.jdField_a_of_type_JavaLangString;
        localObject = localStringBuilder.append("QueueDownloader").append(" current task:").append((String)localObject).append(",downloadQueue size:");
        if (beau.a(this.this$0) != null) {
          break label105;
        }
      }
      label105:
      for (int i = 0;; i = beau.a(this.this$0).size())
      {
        ((StringBuilder)localObject).append(i);
        return localStringBuilder.toString();
        localObject = (String)this.a.jdField_a_of_type_JavaUtilList.get(0);
        break;
      }
      return super.toString();
    }
    catch (Exception localException)
    {
      QLog.e("QueueDownloader", 1, localException, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vip.QueueDownloader.1
 * JD-Core Version:    0.7.0.1
 */