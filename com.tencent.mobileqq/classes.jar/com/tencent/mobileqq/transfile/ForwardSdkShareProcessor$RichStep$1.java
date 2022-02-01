package com.tencent.mobileqq.transfile;

import bdup;
import bduw;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class ForwardSdkShareProcessor$RichStep$1
  implements Runnable
{
  public ForwardSdkShareProcessor$RichStep$1(bduw parambduw) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.share.ForwardSdkShareProcessor", 2, "RichStep|run|retry=" + bduw.a(this.a));
    }
    if (this.a.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      this.a.f();
      return;
    }
    int i = bduw.a(this.a);
    if (bduw.a(this.a).get())
    {
      if ((i == -1) && (bduw.a(this.a).getAndIncrement() < 2))
      {
        ThreadManager.post(this, 8, null, true);
        return;
      }
      bduw.a(this.a).set(false);
      QLog.d("Q.share.ForwardSdkShareProcessor", 1, "RichStep|rich fail,lack=" + bdup.a(this.a.jdField_b_of_type_Bdup));
    }
    this.a.a = true;
    this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ForwardSdkShareProcessor.RichStep.1
 * JD-Core Version:    0.7.0.1
 */