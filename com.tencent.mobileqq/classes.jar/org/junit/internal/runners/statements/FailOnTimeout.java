package org.junit.internal.runners.statements;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.junit.runners.model.MultipleFailureException;
import org.junit.runners.model.Statement;
import org.junit.runners.model.TestTimedOutException;

public class FailOnTimeout
  extends Statement
{
  private final boolean lookForStuckThread;
  private final Statement originalStatement;
  private volatile ThreadGroup threadGroup = null;
  private final TimeUnit timeUnit;
  private final long timeout;
  
  private FailOnTimeout(FailOnTimeout.Builder paramBuilder, Statement paramStatement)
  {
    this.originalStatement = paramStatement;
    this.timeout = FailOnTimeout.Builder.access$100(paramBuilder);
    this.timeUnit = FailOnTimeout.Builder.access$200(paramBuilder);
    this.lookForStuckThread = FailOnTimeout.Builder.access$300(paramBuilder);
  }
  
  @Deprecated
  public FailOnTimeout(Statement paramStatement, long paramLong)
  {
    this(builder().withTimeout(paramLong, TimeUnit.MILLISECONDS), paramStatement);
  }
  
  public static FailOnTimeout.Builder builder()
  {
    return new FailOnTimeout.Builder(null);
  }
  
  private Thread[] copyThreads(Thread[] paramArrayOfThread, int paramInt)
  {
    int i = Math.min(paramInt, paramArrayOfThread.length);
    Thread[] arrayOfThread = new Thread[i];
    paramInt = 0;
    while (paramInt < i)
    {
      arrayOfThread[paramInt] = paramArrayOfThread[paramInt];
      paramInt += 1;
    }
    return arrayOfThread;
  }
  
  private long cpuTime(Thread paramThread)
  {
    ThreadMXBean localThreadMXBean = ManagementFactory.getThreadMXBean();
    if (localThreadMXBean.isThreadCpuTimeSupported()) {}
    try
    {
      long l = localThreadMXBean.getThreadCpuTime(paramThread.getId());
      return l;
    }
    catch (UnsupportedOperationException paramThread)
    {
      label29:
      break label29;
    }
    return 0L;
  }
  
  private Exception createTimeoutException(Thread paramThread)
  {
    StackTraceElement[] arrayOfStackTraceElement = paramThread.getStackTrace();
    Thread localThread;
    if (this.lookForStuckThread) {
      localThread = getStuckThread(paramThread);
    } else {
      localThread = null;
    }
    TestTimedOutException localTestTimedOutException = new TestTimedOutException(this.timeout, this.timeUnit);
    if (arrayOfStackTraceElement != null)
    {
      localTestTimedOutException.setStackTrace(arrayOfStackTraceElement);
      paramThread.interrupt();
    }
    if (localThread != null)
    {
      paramThread = new StringBuilder();
      paramThread.append("Appears to be stuck in thread ");
      paramThread.append(localThread.getName());
      paramThread = new Exception(paramThread.toString());
      paramThread.setStackTrace(getStackTrace(localThread));
      return new MultipleFailureException(Arrays.asList(new Throwable[] { localTestTimedOutException, paramThread }));
    }
    return localTestTimedOutException;
  }
  
  private Throwable getResult(FutureTask<Throwable> paramFutureTask, Thread paramThread)
  {
    try
    {
      if (this.timeout > 0L) {
        return (Throwable)paramFutureTask.get(this.timeout, this.timeUnit);
      }
      paramFutureTask = (Throwable)paramFutureTask.get();
      return paramFutureTask;
    }
    catch (ExecutionException paramFutureTask)
    {
      return paramFutureTask.getCause();
    }
    catch (InterruptedException paramFutureTask)
    {
      return paramFutureTask;
    }
    catch (TimeoutException paramFutureTask)
    {
      label35:
      break label35;
    }
    return createTimeoutException(paramThread);
  }
  
  private StackTraceElement[] getStackTrace(Thread paramThread)
  {
    try
    {
      paramThread = paramThread.getStackTrace();
      return paramThread;
    }
    catch (SecurityException paramThread)
    {
      label7:
      break label7;
    }
    return new StackTraceElement[0];
  }
  
  private Thread getStuckThread(Thread paramThread)
  {
    if (this.threadGroup == null) {
      return null;
    }
    Thread[] arrayOfThread = getThreadArray(this.threadGroup);
    if (arrayOfThread == null) {
      return null;
    }
    int j = arrayOfThread.length;
    int i = 0;
    long l1 = 0L;
    Object localObject1 = null;
    while (i < j)
    {
      Thread localThread = arrayOfThread[i];
      Object localObject2 = localObject1;
      long l2 = l1;
      if (localThread.getState() == Thread.State.RUNNABLE)
      {
        long l3 = cpuTime(localThread);
        if (localObject1 != null)
        {
          localObject2 = localObject1;
          l2 = l1;
          if (l3 <= l1) {}
        }
        else
        {
          localObject2 = localThread;
          l2 = l3;
        }
      }
      i += 1;
      localObject1 = localObject2;
      l1 = l2;
    }
    if (localObject1 == paramThread) {
      return null;
    }
    return localObject1;
  }
  
  private Thread[] getThreadArray(ThreadGroup paramThreadGroup)
  {
    int j = Math.max(paramThreadGroup.activeCount() * 2, 100);
    int i = 0;
    int k;
    do
    {
      Thread[] arrayOfThread = new Thread[j];
      k = paramThreadGroup.enumerate(arrayOfThread);
      if (k < j) {
        return copyThreads(arrayOfThread, k);
      }
      j += 100;
      k = i + 1;
      i = k;
    } while (k < 5);
    return null;
  }
  
  public void evaluate()
  {
    Object localObject = new FailOnTimeout.CallableStatement(this, null);
    FutureTask localFutureTask = new FutureTask((Callable)localObject);
    this.threadGroup = new ThreadGroup("FailOnTimeoutGroup");
    Thread localThread = new Thread(this.threadGroup, localFutureTask, "Time-limited test");
    localThread.setDaemon(true);
    localThread.start();
    ((FailOnTimeout.CallableStatement)localObject).awaitStarted();
    localObject = getResult(localFutureTask, localThread);
    if (localObject == null) {
      return;
    }
    throw ((Throwable)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.junit.internal.runners.statements.FailOnTimeout
 * JD-Core Version:    0.7.0.1
 */