package com.tencent.mobileqq.transfile;

import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

class ForwardSdkShareProcessor$RichStep$1
  implements Runnable
{
  ForwardSdkShareProcessor$RichStep$1(ForwardSdkShareProcessor.RichStep paramRichStep) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("RichStep|run|retry=");
      ((StringBuilder)localObject).append(this.this$1.retryCount);
      QLog.d("Q.share.ForwardSdkShareProcessor", 2, ((StringBuilder)localObject).toString());
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
        run();
        return;
      }
      this.this$1.needRich.set(false);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("RichStep|rich fail,lack=");
      ((StringBuilder)localObject).append(ForwardSdkShareProcessor.access$000(this.this$1.this$0));
      QLog.d("Q.share.ForwardSdkShareProcessor", 1, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.this$1;
    ((ForwardSdkShareProcessor.RichStep)localObject).isDidRich = true;
    ((ForwardSdkShareProcessor.RichStep)localObject).doNextStep();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ForwardSdkShareProcessor.RichStep.1
 * JD-Core Version:    0.7.0.1
 */