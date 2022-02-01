package com.tencent.mobileqq.transfile;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

class ForwardSdkShareProcessor$RichStep$1
  implements Runnable
{
  ForwardSdkShareProcessor$RichStep$1(ForwardSdkShareProcessor.RichStep paramRichStep) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.share.ForwardSdkShareProcessor", 2, "RichStep|run|retry=" + this.this$1.retryCount);
    }
    if (this.this$1.isCancelled.get())
    {
      this.this$1.doCancel();
      return;
    }
    int i = this.this$1.doRich();
    if (this.this$1.needRich.get())
    {
      if ((i == -1) && (this.this$1.retryCount.getAndIncrement() < 2))
      {
        ThreadManager.post(this, 8, null, true);
        return;
      }
      this.this$1.needRich.set(false);
      QLog.d("Q.share.ForwardSdkShareProcessor", 1, "RichStep|rich fail,lack=" + ForwardSdkShareProcessor.access$000(this.this$1.this$0));
    }
    this.this$1.isDidRich = true;
    this.this$1.doNextStep();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ForwardSdkShareProcessor.RichStep.1
 * JD-Core Version:    0.7.0.1
 */