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
public class MethodRoadie
{
  private final Description description;
  private final RunNotifier notifier;
  private final Object test;
  private TestMethod testMethod;
  
  public MethodRoadie(Object paramObject, TestMethod paramTestMethod, RunNotifier paramRunNotifier, Description paramDescription)
  {
    this.test = paramObject;
    this.notifier = paramRunNotifier;
    this.description = paramDescription;
    this.testMethod = paramTestMethod;
  }
  
  private void runAfters()
  {
    Iterator localIterator = this.testMethod.getAfters().iterator();
    while (localIterator.hasNext())
    {
      Method localMethod = (Method)localIterator.next();
      try
      {
        localMethod.invoke(this.test, new Object[0]);
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
        Iterator localIterator = this.testMethod.getBefores().iterator();
        while (localIterator.hasNext()) {
          ((Method)localIterator.next()).invoke(this.test, new Object[0]);
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
      label70:
      FailedBefore localFailedBefore;
      break label70;
    }
    localFailedBefore = new FailedBefore();
    for (;;)
    {
      throw localFailedBefore;
    }
  }
  
  private void runWithTimeout(long paramLong)
  {
    runBeforesThenTestThenAfters(new MethodRoadie.1(this, paramLong));
  }
  
  protected void addFailure(Throwable paramThrowable)
  {
    this.notifier.fireTestFailure(new Failure(this.description, paramThrowable));
  }
  
  public void run()
  {
    if (this.testMethod.isIgnored())
    {
      this.notifier.fireTestIgnored(this.description);
      return;
    }
    this.notifier.fireTestStarted(this.description);
    try
    {
      long l = this.testMethod.getTimeout();
      if (l > 0L) {
        runWithTimeout(l);
      } else {
        runTest();
      }
      return;
    }
    finally
    {
      this.notifier.fireTestFinished(this.description);
    }
  }
  
  public void runBeforesThenTestThenAfters(Runnable paramRunnable)
  {
    try
    {
      try
      {
        runBefores();
        paramRunnable.run();
      }
      finally
      {
        break label27;
      }
    }
    catch (FailedBefore paramRunnable)
    {
      break label33;
    }
    catch (Exception paramRunnable)
    {
      label17:
      label27:
      label33:
      break label17;
    }
    throw new RuntimeException("test should never throw an exception to this level");
    runAfters();
    throw paramRunnable;
    runAfters();
  }
  
  public void runTest()
  {
    runBeforesThenTestThenAfters(new MethodRoadie.2(this));
  }
  
  protected void runTestMethod()
  {
    try
    {
      this.testMethod.invoke(this.test);
      if (this.testMethod.expectsException())
      {
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("Expected exception: ");
        localStringBuilder1.append(this.testMethod.getExpectedException().getName());
        addFailure(new AssertionError(localStringBuilder1.toString()));
        return;
      }
    }
    catch (Throwable localThrowable1)
    {
      addFailure(localThrowable1);
      return;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      Throwable localThrowable2 = localInvocationTargetException.getTargetException();
      if ((localThrowable2 instanceof AssumptionViolatedException)) {
        return;
      }
      if (!this.testMethod.expectsException())
      {
        addFailure(localThrowable2);
        return;
      }
      if (this.testMethod.isUnexpected(localThrowable2))
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("Unexpected exception, expected<");
        localStringBuilder2.append(this.testMethod.getExpectedException().getName());
        localStringBuilder2.append("> but was<");
        localStringBuilder2.append(localThrowable2.getClass().getName());
        localStringBuilder2.append(">");
        addFailure(new Exception(localStringBuilder2.toString(), localThrowable2));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.junit.internal.runners.MethodRoadie
 * JD-Core Version:    0.7.0.1
 */