package com.tencent.mobileqq.transfile;

import android.os.Looper;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.forward.ForwardStatisticsReporter;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

abstract class ForwardSdkShareProcessor$ForwardStep
{
  protected long beginTime = 0L;
  protected AtomicBoolean isCancelled = new AtomicBoolean(false);
  protected AtomicBoolean isRunning = new AtomicBoolean(false);
  private ForwardStep[] lastSteps;
  private ForwardStep nextStep;
  protected String stepName = "ForwardStep";
  
  ForwardSdkShareProcessor$ForwardStep(ForwardSdkShareProcessor paramForwardSdkShareProcessor) {}
  
  protected void cancel()
  {
    if (isFinished()) {
      return;
    }
    this.isCancelled.set(true);
    ForwardStep[] arrayOfForwardStep = this.lastSteps;
    if ((arrayOfForwardStep != null) && (arrayOfForwardStep.length > 0))
    {
      int j = arrayOfForwardStep.length;
      int i = 0;
      while (i < j)
      {
        arrayOfForwardStep[i].cancel();
        i += 1;
      }
    }
  }
  
  protected void doCancel()
  {
    this.isRunning.set(false);
    long l2 = this.beginTime;
    long l1 = 0L;
    if (l2 != 0L) {
      l1 = System.currentTimeMillis() - this.beginTime;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.stepName);
    localStringBuilder.append("|doCancel,cost=");
    localStringBuilder.append(l1);
    QLog.d("Q.share.ForwardSdkShareProcessor", 1, localStringBuilder.toString());
  }
  
  void doError()
  {
    this.isRunning.set(false);
    long l2 = this.beginTime;
    long l1 = 0L;
    if (l2 != 0L) {
      l1 = System.currentTimeMillis() - this.beginTime;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.stepName);
    localStringBuilder.append("|doError,cost=");
    localStringBuilder.append(l1);
    QLog.d("Q.share.ForwardSdkShareProcessor", 1, localStringBuilder.toString());
    this.this$0.onError();
  }
  
  void doNextStep()
  {
    this.isRunning.set(false);
    long l2 = this.beginTime;
    long l1 = 0L;
    if (l2 != 0L) {
      l1 = System.currentTimeMillis() - this.beginTime;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.stepName);
    localStringBuilder.append("|finished,cost=");
    localStringBuilder.append(l1);
    QLog.d("Q.share.ForwardSdkShareProcessor", 1, localStringBuilder.toString());
    ForwardStatisticsReporter.a(this.stepName, l1);
    if ((this.nextStep != null) && (!this.isCancelled.get()))
    {
      if (Looper.getMainLooper() == Looper.myLooper())
      {
        ThreadManager.excute(new ForwardSdkShareProcessor.ForwardStep.1(this), 128, null, true);
        return;
      }
      this.nextStep.doStep();
    }
  }
  
  void doStep()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(this.stepName);
    ((StringBuilder)localObject1).append("|doStep");
    QLog.d("Q.share.ForwardSdkShareProcessor", 1, ((StringBuilder)localObject1).toString());
    localObject1 = this.lastSteps;
    if ((localObject1 != null) && (localObject1.length > 0))
    {
      int m = localObject1.length;
      int j = 0;
      int i = 1;
      for (;;)
      {
        k = i;
        if (j >= m) {
          break;
        }
        Object localObject2 = localObject1[j];
        QLog.d("Q.share.ForwardSdkShareProcessor", 1, new Object[] { localObject2.stepName, "|finished=", Boolean.valueOf(localObject2.isFinished()), ", processing=", Boolean.valueOf(localObject2.isProcessing()) });
        if (!localObject2.isFinished())
        {
          if (!localObject2.isProcessing()) {
            localObject2.doStep();
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
    paramArrayOfForwardStep = this.lastSteps;
    if ((paramArrayOfForwardStep != null) && (paramArrayOfForwardStep.length > 0))
    {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ForwardSdkShareProcessor.ForwardStep
 * JD-Core Version:    0.7.0.1
 */