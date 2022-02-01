package org.junit.internal.runners;

import junit.framework.AssertionFailedError;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestListener;
import org.junit.runner.Describable;
import org.junit.runner.Description;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunNotifier;

final class JUnit38ClassRunner$OldTestClassAdaptingListener
  implements TestListener
{
  private final RunNotifier notifier;
  
  private JUnit38ClassRunner$OldTestClassAdaptingListener(RunNotifier paramRunNotifier)
  {
    this.notifier = paramRunNotifier;
  }
  
  private Description asDescription(Test paramTest)
  {
    if ((paramTest instanceof Describable)) {
      return ((Describable)paramTest).getDescription();
    }
    return Description.createTestDescription(getEffectiveClass(paramTest), getName(paramTest));
  }
  
  private Class<? extends Test> getEffectiveClass(Test paramTest)
  {
    return paramTest.getClass();
  }
  
  private String getName(Test paramTest)
  {
    if ((paramTest instanceof TestCase)) {
      return ((TestCase)paramTest).getName();
    }
    return paramTest.toString();
  }
  
  public void addError(Test paramTest, Throwable paramThrowable)
  {
    paramTest = new Failure(asDescription(paramTest), paramThrowable);
    this.notifier.fireTestFailure(paramTest);
  }
  
  public void addFailure(Test paramTest, AssertionFailedError paramAssertionFailedError)
  {
    addError(paramTest, paramAssertionFailedError);
  }
  
  public void endTest(Test paramTest)
  {
    this.notifier.fireTestFinished(asDescription(paramTest));
  }
  
  public void startTest(Test paramTest)
  {
    this.notifier.fireTestStarted(asDescription(paramTest));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.junit.internal.runners.JUnit38ClassRunner.OldTestClassAdaptingListener
 * JD-Core Version:    0.7.0.1
 */