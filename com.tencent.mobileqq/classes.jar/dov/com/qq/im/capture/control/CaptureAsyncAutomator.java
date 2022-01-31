package dov.com.qq.im.capture.control;

import bjbr;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CaptureAsyncAutomator
  extends Automator
  implements Runnable
{
  private AsyncStep jdField_a_of_type_ComTencentMobileqqAppAutomatorAsyncStep;
  private ThreadPoolExecutor jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor;
  private final LinkedList<AsyncStep> b = new LinkedList();
  
  public CaptureAsyncAutomator(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private void c(AsyncStep paramAsyncStep)
  {
    this.b.add(paramAsyncStep);
    if (QLog.isColorLevel()) {
      QLog.d("CaptureAsyncAutomator", 2, "addWaitingMode_Locked " + paramAsyncStep.a);
    }
  }
  
  private void e()
  {
    this.jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor = new ThreadPoolExecutor(3, 3, 1000L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(24), new bjbr(this, null));
    this.jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor.allowCoreThreadTimeOut(true);
  }
  
  public void a(AsyncStep paramAsyncStep)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CaptureAsyncAutomator", 2, "start " + paramAsyncStep.a);
    }
    synchronized (this.b)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAsyncStep == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAsyncStep = paramAsyncStep;
        if (QLog.isColorLevel()) {
          QLog.d("CaptureAsyncAutomator", 2, "run " + paramAsyncStep.a);
        }
        if (this.jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor == null) {
          e();
        }
        this.jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor.execute(this);
        return;
      }
      c(paramAsyncStep);
    }
  }
  
  public void b(AsyncStep paramAsyncStep)
  {
    synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
    {
      QLog.d("CaptureAsyncAutomator", 1, "CameraEmo, mCountRunning " + this.c);
      if (this.c < 3)
      {
        this.c += 1;
        if (this.jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor == null) {
          e();
        }
        this.jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor.execute(paramAsyncStep);
        return;
      }
      this.jdField_a_of_type_JavaUtilLinkedList.add(paramAsyncStep);
    }
  }
  
  public void run()
  {
    for (;;)
    {
      ??? = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAsyncStep;
      if (??? != null) {
        ((AsyncStep)???).run();
      }
      synchronized (this.b)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAsyncStep = ((AsyncStep)this.b.poll());
        if (this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAsyncStep == null) {
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.control.CaptureAsyncAutomator
 * JD-Core Version:    0.7.0.1
 */