package com.tencent.mobileqq.kandian.biz.ugc.coverselect.capture;

import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerExecutor;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.Executor;

public class PreviewCaptureManager
  implements CapturePreparedListener, CaptureTask.OnTaskListener
{
  private Handler jdField_a_of_type_AndroidOsHandler = new PreviewCaptureManager.1(this);
  private ICaptureProxy jdField_a_of_type_ComTencentMobileqqKandianBizUgcCoverselectCaptureICaptureProxy;
  private Queue<CaptureTask> jdField_a_of_type_JavaUtilQueue = new ArrayDeque();
  private Executor jdField_a_of_type_JavaUtilConcurrentExecutor = ThreadManagerExecutor.getExecutorService(64);
  private boolean jdField_a_of_type_Boolean = false;
  private Queue<CaptureTask> b = new ArrayDeque();
  
  public PreviewCaptureManager(ICaptureProxy paramICaptureProxy)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcCoverselectCaptureICaptureProxy = paramICaptureProxy;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcCoverselectCaptureICaptureProxy.a(this);
  }
  
  private void b()
  {
    if ((this.jdField_a_of_type_Boolean) && (!this.jdField_a_of_type_JavaUtilQueue.isEmpty()))
    {
      int j = Math.min(3 - this.b.size(), this.jdField_a_of_type_JavaUtilQueue.size());
      int i = j;
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("fetchTaskToExe concurrentCount:");
        ((StringBuilder)localObject).append(j);
        QLog.d("PreviewCaptureManager", 2, ((StringBuilder)localObject).toString());
        i = j;
      }
      while (i > 0)
      {
        j = i - 1;
        localObject = (CaptureTask)this.jdField_a_of_type_JavaUtilQueue.poll();
        i = j;
        if (localObject != null)
        {
          e((CaptureTask)localObject);
          i = j;
        }
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.w("PreviewCaptureManager", 2, "fetchTaskToExe return for capturePrepared is false or waittingTaskQueue is Empty");
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1000);
  }
  
  private void d(CaptureTask paramCaptureTask)
  {
    paramCaptureTask.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcCoverselectCaptureICaptureProxy);
    paramCaptureTask.a(this);
  }
  
  private void e(CaptureTask paramCaptureTask)
  {
    this.b.add(paramCaptureTask);
    d(paramCaptureTask);
    paramCaptureTask.executeOnExecutor(this.jdField_a_of_type_JavaUtilConcurrentExecutor, null);
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    Object localObject = new ArrayList(this.jdField_a_of_type_JavaUtilQueue);
    ((List)localObject).addAll(this.b);
    this.jdField_a_of_type_JavaUtilQueue.clear();
    this.b.clear();
    int i = 0;
    while (i < ((List)localObject).size())
    {
      CaptureTask localCaptureTask = (CaptureTask)((List)localObject).get(i);
      if (localCaptureTask != null) {
        localCaptureTask.cancel(true);
      }
      i += 1;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcCoverselectCaptureICaptureProxy;
    if (localObject != null) {
      ((ICaptureProxy)localObject).a();
    }
  }
  
  public void a(int paramInt1, int paramInt2, long paramLong)
  {
    this.jdField_a_of_type_Boolean = true;
    c();
  }
  
  public void a(CaptureTask paramCaptureTask) {}
  
  public void b(CaptureTask paramCaptureTask)
  {
    this.b.remove(paramCaptureTask);
    c();
  }
  
  public void c(CaptureTask paramCaptureTask)
  {
    if (!this.jdField_a_of_type_JavaUtilQueue.contains(paramCaptureTask))
    {
      if (this.b.contains(paramCaptureTask)) {
        return;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("addCaptureTask task:");
        localStringBuilder.append(paramCaptureTask);
        QLog.d("PreviewCaptureManager", 2, localStringBuilder.toString());
      }
      this.jdField_a_of_type_JavaUtilQueue.add(paramCaptureTask);
      c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.coverselect.capture.PreviewCaptureManager
 * JD-Core Version:    0.7.0.1
 */