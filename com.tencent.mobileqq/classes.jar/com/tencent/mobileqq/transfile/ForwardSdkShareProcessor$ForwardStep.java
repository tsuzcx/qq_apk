package com.tencent.mobileqq.transfile;

import atqa;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

abstract class ForwardSdkShareProcessor$ForwardStep
{
  protected long beginTime;
  protected AtomicBoolean isCancelled = new AtomicBoolean(false);
  protected AtomicBoolean isRunning = new AtomicBoolean(false);
  private ForwardStep[] lastSteps;
  private ForwardStep nextStep;
  protected String stepName = "ForwardStep";
  
  ForwardSdkShareProcessor$ForwardStep(ForwardSdkShareProcessor paramForwardSdkShareProcessor) {}
  
  protected void cancel()
  {
    if (isFinished()) {}
    for (;;)
    {
      return;
      this.isCancelled.set(true);
      if ((this.lastSteps != null) && (this.lastSteps.length > 0))
      {
        ForwardStep[] arrayOfForwardStep = this.lastSteps;
        int j = arrayOfForwardStep.length;
        int i = 0;
        while (i < j)
        {
          arrayOfForwardStep[i].cancel();
          i += 1;
        }
      }
    }
  }
  
  protected void doCancel()
  {
    long l = 0L;
    this.isRunning.set(false);
    if (this.beginTime != 0L) {
      l = System.currentTimeMillis() - this.beginTime;
    }
    QLog.d("Q.share.ForwardSdkShareProcessor", 1, this.stepName + "|doCancel,cost=" + l);
  }
  
  void doError()
  {
    long l = 0L;
    this.isRunning.set(false);
    if (this.beginTime != 0L) {
      l = System.currentTimeMillis() - this.beginTime;
    }
    QLog.d("Q.share.ForwardSdkShareProcessor", 1, this.stepName + "|doError,cost=" + l);
    this.this$0.onError();
  }
  
  void doNextStep()
  {
    long l = 0L;
    this.isRunning.set(false);
    if (this.beginTime != 0L) {
      l = System.currentTimeMillis() - this.beginTime;
    }
    QLog.d("Q.share.ForwardSdkShareProcessor", 1, this.stepName + "|finished,cost=" + l);
    atqa.a(this.stepName, l);
    if ((this.nextStep != null) && (!this.isCancelled.get())) {
      this.this$0.mController.mHandler.post(new ForwardSdkShareProcessor.ForwardStep.1(this));
    }
  }
  
  void doStep()
  {
    QLog.d("Q.share.ForwardSdkShareProcessor", 1, this.stepName + "|doStep");
    if ((this.lastSteps != null) && (this.lastSteps.length > 0))
    {
      ForwardStep[] arrayOfForwardStep = this.lastSteps;
      int m = arrayOfForwardStep.length;
      int j = 0;
      int i = 1;
      for (;;)
      {
        k = i;
        if (j >= m) {
          break;
        }
        ForwardStep localForwardStep = arrayOfForwardStep[j];
        QLog.d("Q.share.ForwardSdkShareProcessor", 1, new Object[] { localForwardStep.stepName, "|finished=", Boolean.valueOf(localForwardStep.isFinished()), ", processing=", Boolean.valueOf(localForwardStep.isProcessing()) });
        if (!localForwardStep.isFinished())
        {
          if (!localForwardStep.isProcessing()) {
            localForwardStep.doStep();
          }
          i = 0;
        }
        j += 1;
      }
    }
    int k = 1;
    if ((k != 0) && (!isFinished()) && (!isProcessing()))
    {
      this.isRunning.set(true);
      this.beginTime = System.currentTimeMillis();
      process();
    }
  }
  
  protected boolean isFinished()
  {
    return false;
  }
  
  protected boolean isProcessing()
  {
    return this.isRunning.get();
  }
  
  protected abstract void process();
  
  void setLastSteps(ForwardStep[] paramArrayOfForwardStep)
  {
    this.lastSteps = paramArrayOfForwardStep;
    if ((this.lastSteps != null) && (this.lastSteps.length > 0))
    {
      paramArrayOfForwardStep = this.lastSteps;
      int j = paramArrayOfForwardStep.length;
      int i = 0;
      while (i < j)
      {
        paramArrayOfForwardStep[i].nextStep = this;
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ForwardSdkShareProcessor.ForwardStep
 * JD-Core Version:    0.7.0.1
 */