package com.tencent.mobileqq.emosm.control;

import com.tencent.qphone.base.util.QLog;
import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class EmoCaptureAsyncAutomator
  extends EmoAutomator
  implements Runnable
{
  protected EmoAsyncStep a;
  protected ThreadPoolExecutor a;
  protected final LinkedList<EmoAsyncStep> b;
  
  public EmoCaptureAsyncAutomator()
  {
    this.jdField_a_of_type_ComTencentMobileqqEmosmControlEmoAsyncStep = null;
    this.jdField_b_of_type_JavaUtilLinkedList = new LinkedList();
  }
  
  private void b()
  {
    this.jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor = new ThreadPoolExecutor(3, 3, 1000L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(24), new EmoCaptureAsyncAutomator.MyThreadFactory(this, null));
    this.jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor.allowCoreThreadTimeOut(true);
  }
  
  private void c(EmoAsyncStep paramEmoAsyncStep)
  {
    this.jdField_b_of_type_JavaUtilLinkedList.add(paramEmoAsyncStep);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("addWaitingMode_Locked ");
      localStringBuilder.append(paramEmoAsyncStep.a);
      QLog.d("EmoCaptureAsyncAutomator", 2, localStringBuilder.toString());
    }
  }
  
  public void a(EmoAsyncStep paramEmoAsyncStep)
  {
    synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("CameraEmo, mCountRunning ");
      localStringBuilder.append(this.jdField_b_of_type_Int);
      QLog.d("EmoCaptureAsyncAutomator", 1, localStringBuilder.toString());
      if (this.jdField_b_of_type_Int < 3)
      {
        this.jdField_b_of_type_Int += 1;
        if (this.jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor == null) {
          b();
        }
        this.jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor.execute(paramEmoAsyncStep);
      }
      else
      {
        this.jdField_a_of_type_JavaUtilLinkedList.add(paramEmoAsyncStep);
      }
      return;
    }
  }
  
  public void b(EmoAsyncStep paramEmoAsyncStep)
  {
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("start ");
      ((StringBuilder)???).append(paramEmoAsyncStep.a);
      QLog.d("EmoCaptureAsyncAutomator", 2, ((StringBuilder)???).toString());
    }
    synchronized (this.jdField_b_of_type_JavaUtilLinkedList)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqEmosmControlEmoAsyncStep == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqEmosmControlEmoAsyncStep = paramEmoAsyncStep;
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("run ");
          localStringBuilder.append(paramEmoAsyncStep.a);
          QLog.d("EmoCaptureAsyncAutomator", 2, localStringBuilder.toString());
        }
        if (this.jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor == null) {
          b();
        }
        this.jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor.execute(this);
      }
      else
      {
        c(paramEmoAsyncStep);
      }
      return;
    }
  }
  
  public void run()
  {
    for (;;)
    {
      ??? = this.jdField_a_of_type_ComTencentMobileqqEmosmControlEmoAsyncStep;
      if (??? != null) {
        ((EmoAsyncStep)???).run();
      }
      synchronized (this.jdField_b_of_type_JavaUtilLinkedList)
      {
        this.jdField_a_of_type_ComTencentMobileqqEmosmControlEmoAsyncStep = ((EmoAsyncStep)this.jdField_b_of_type_JavaUtilLinkedList.poll());
        if (this.jdField_a_of_type_ComTencentMobileqqEmosmControlEmoAsyncStep == null) {
          return;
        }
      }
    }
    for (;;)
    {
      throw localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.control.EmoCaptureAsyncAutomator
 * JD-Core Version:    0.7.0.1
 */