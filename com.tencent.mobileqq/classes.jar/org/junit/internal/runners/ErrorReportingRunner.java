package org.junit.internal.runners;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunNotifier;

public class ErrorReportingRunner
  extends Runner
{
  private final List<Throwable> causes;
  private final Class<?> testClass;
  
  public ErrorReportingRunner(Class<?> paramClass, Throwable paramThrowable)
  {
    if (paramClass != null)
    {
      this.testClass = paramClass;
      this.causes = getCauses(paramThrowable);
      return;
    }
    throw new NullPointerException("Test class cannot be null");
  }
  
  private Description describeCause(Throwable paramThrowable)
  {
    return Description.createTestDescription(this.testClass, "initializationError");
  }
  
  private List<Throwable> getCauses(Throwable paramThrowable)
  {
    if ((paramThrowable instanceof InvocationTargetException)) {
      return getCauses(paramThrowable.getCause());
    }
    if ((paramThrowable instanceof org.junit.runners.model.InitializationError)) {
      return ((org.junit.runners.model.InitializationError)paramThrowable).getCauses();
    }
    if ((paramThrowable instanceof InitializationError)) {
      return ((InitializationError)paramThrowable).getCauses();
    }
    return Arrays.asList(new Throwable[] { paramThrowable });
  }
  
  private void runCause(Throwable paramThrowable, RunNotifier paramRunNotifier)
  {
    Description localDescription = describeCause(paramThrowable);
    paramRunNotifier.fireTestStarted(localDescription);
    paramRunNotifier.fireTestFailure(new Failure(localDescription, paramThrowable));
    paramRunNotifier.fireTestFinished(localDescription);
  }
  
  public Description getDescription()
  {
    Description localDescription = Description.createSuiteDescription(this.testClass);
    Iterator localIterator = this.causes.iterator();
    while (localIterator.hasNext()) {
      localDescription.addChild(describeCause((Throwable)localIterator.next()));
    }
    return localDescription;
  }
  
  public void run(RunNotifier paramRunNotifier)
  {
    Iterator localIterator = this.causes.iterator();
    while (localIterator.hasNext()) {
      runCause((Throwable)localIterator.next(), paramRunNotifier);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.junit.internal.runners.ErrorReportingRunner
 * JD-Core Version:    0.7.0.1
 */