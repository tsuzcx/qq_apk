package org.junit.internal.runners;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import org.junit.internal.AssumptionViolatedException;
import org.junit.runner.Description;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunNotifier;

@Deprecated
public class ClassRoadie
{
  private Description description;
  private RunNotifier notifier;
  private final Runnable runnable;
  private TestClass testClass;
  
  public ClassRoadie(RunNotifier paramRunNotifier, TestClass paramTestClass, Description paramDescription, Runnable paramRunnable)
  {
    this.notifier = paramRunNotifier;
    this.testClass = paramTestClass;
    this.description = paramDescription;
    this.runnable = paramRunnable;
  }
  
  private void runAfters()
  {
    Iterator localIterator = this.testClass.getAfters().iterator();
    while (localIterator.hasNext())
    {
      Method localMethod = (Method)localIterator.next();
      try
      {
        localMethod.invoke(null, new Object[0]);
      }
      catch (Throwable localThrowable)
      {
        addFailure(localThrowable);
      }
      catch (InvocationTargetException localInvocationTargetException)
      {
        addFailure(localInvocationTargetException.getTargetException());
      }
    }
  }
  
  private void runBefores()
  {
    try
    {
      try
      {
        Iterator localIterator = this.testClass.getBefores().iterator();
        while (localIterator.hasNext()) {
          ((Method)localIterator.next()).invoke(null, new Object[0]);
        }
        return;
      }
      catch (Throwable localThrowable) {}catch (InvocationTargetException localInvocationTargetException)
      {
        throw localInvocationTargetException.getTargetException();
      }
      addFailure(localInvocationTargetException);
      throw new FailedBefore();
    }
    catch (AssumptionViolatedException localAssumptionViolatedException)
    {
      label67:
      FailedBefore localFailedBefore;
      break label67;
    }
    localFailedBefore = new FailedBefore();
    for (;;)
    {
      throw localFailedBefore;
    }
  }
  
  protected void addFailure(Throwable paramThrowable)
  {
    this.notifier.fireTestFailure(new Failure(this.description, paramThrowable));
  }
  
  /* Error */
  public void runProtected()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 91	org/junit/internal/runners/ClassRoadie:runBefores	()V
    //   4: aload_0
    //   5: invokevirtual 94	org/junit/internal/runners/ClassRoadie:runUnprotected	()V
    //   8: goto +10 -> 18
    //   11: astore_1
    //   12: aload_0
    //   13: invokespecial 96	org/junit/internal/runners/ClassRoadie:runAfters	()V
    //   16: aload_1
    //   17: athrow
    //   18: aload_0
    //   19: invokespecial 96	org/junit/internal/runners/ClassRoadie:runAfters	()V
    //   22: return
    //   23: astore_1
    //   24: goto -6 -> 18
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	27	0	this	ClassRoadie
    //   11	6	1	localObject	Object
    //   23	1	1	localFailedBefore	FailedBefore
    // Exception table:
    //   from	to	target	type
    //   0	8	11	finally
    //   0	8	23	org/junit/internal/runners/FailedBefore
  }
  
  protected void runUnprotected()
  {
    this.runnable.run();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.junit.internal.runners.ClassRoadie
 * JD-Core Version:    0.7.0.1
 */