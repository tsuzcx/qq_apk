package com.tencent.mobileqq.transfile;

import betj;
import betq;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class ForwardSdkShareProcessor$RichStep$1
  implements Runnable
{
  public ForwardSdkShareProcessor$RichStep$1(betq parambetq) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.share.ForwardSdkShareProcessor", 2, "RichStep|run|retry=" + this.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger);
    }
    if (this.a.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      this.a.f();
      return;
    }
    int i = this.a.a();
    if (this.a.c.get())
    {
      if ((i == -1) && (this.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndIncrement() < 2))
      {
        ThreadManager.post(this, 8, null, true);
        return;
      }
      this.a.c.set(false);
      QLog.d("Q.share.ForwardSdkShareProcessor", 1, "RichStep|rich fail,lack=" + betj.a(this.a.jdField_b_of_type_Betj));
    }
    this.a.jdField_a_of_type_Boolean = true;
    this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ForwardSdkShareProcessor.RichStep.1
 * JD-Core Version:    0.7.0.1
 */