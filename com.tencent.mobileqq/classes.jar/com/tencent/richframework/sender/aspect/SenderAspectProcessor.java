package com.tencent.richframework.sender.aspect;

import android.os.SystemClock;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.sender.util.EventControlUtils;
import java.util.Timer;
import org.aspectj.lang.NoAspectBoundException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class SenderAspectProcessor
{
  static
  {
    try
    {
      b();
      return;
    }
    catch (Throwable localThrowable)
    {
      b = localThrowable;
    }
  }
  
  public static SenderAspectProcessor a()
  {
    SenderAspectProcessor localSenderAspectProcessor = a;
    if (localSenderAspectProcessor != null) {
      return localSenderAspectProcessor;
    }
    throw new NoAspectBoundException("com.tencent.richframework.sender.aspect.SenderAspectProcessor", b);
  }
  
  @Around("execution(@com.tencent.richframework.sender.aspect.ThrottlingDelay * *(..)) && @annotation(throttlingDelayParam)")
  public void a(ProceedingJoinPoint paramProceedingJoinPoint, ThrottlingDelay paramThrottlingDelay)
  {
    if (paramThrottlingDelay == null)
    {
      QLog.d("SenderAspectProcessor", 4, "throttlingDelayParam is null");
      return;
    }
    String str = paramThrottlingDelay.a();
    long l1 = paramThrottlingDelay.b();
    paramThrottlingDelay = EventControlUtils.b(str);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("tag:");
    localStringBuilder.append(str);
    localStringBuilder.append(" timeInterval:");
    localStringBuilder.append(l1);
    QLog.d("SenderAspectProcessor", 4, localStringBuilder.toString());
    long l2 = SystemClock.elapsedRealtime();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("currentTime");
    localStringBuilder.append(l2);
    QLog.d("SenderAspectProcessor", 4, localStringBuilder.toString());
    if ((paramThrottlingDelay != null) && (l2 - paramThrottlingDelay.longValue() < l1))
    {
      paramProceedingJoinPoint = new StringBuilder();
      paramProceedingJoinPoint.append("throttling in timeInterval");
      paramProceedingJoinPoint.append(l1);
      QLog.d("SenderAspectProcessor", 4, paramProceedingJoinPoint.toString());
      return;
    }
    EventControlUtils.b(str, l2);
    paramThrottlingDelay = EventControlUtils.a(str);
    if (paramThrottlingDelay != null) {
      paramThrottlingDelay.cancel();
    }
    paramThrottlingDelay = new Timer();
    paramThrottlingDelay.schedule(new SenderAspectProcessor.1(this, paramProceedingJoinPoint), l1);
    EventControlUtils.a(str, paramThrottlingDelay);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.richframework.sender.aspect.SenderAspectProcessor
 * JD-Core Version:    0.7.0.1
 */