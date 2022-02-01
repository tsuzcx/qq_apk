package com.tencent.richframework.sender.aspect;

import com.tencent.qphone.base.util.QLog;
import java.util.TimerTask;
import org.aspectj.lang.ProceedingJoinPoint;

class SenderAspectProcessor$1
  extends TimerTask
{
  SenderAspectProcessor$1(SenderAspectProcessor paramSenderAspectProcessor, ProceedingJoinPoint paramProceedingJoinPoint) {}
  
  public void run()
  {
    try
    {
      this.a.proceed();
      QLog.d("SenderAspectProcessor", 4, "proceedingJoinPoint proceed()");
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("SenderAspectProcessor", 4, localThrowable.getMessage());
      localThrowable.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.richframework.sender.aspect.SenderAspectProcessor.1
 * JD-Core Version:    0.7.0.1
 */