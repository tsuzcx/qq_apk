package org.junit.runners;

import java.util.Collections;
import java.util.List;
import org.junit.internal.builders.AllDefaultPossibilitiesBuilder;
import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.RunnerBuilder;

public class Suite
  extends ParentRunner<Runner>
{
  private final List<Runner> runners;
  
  protected Suite(Class<?> paramClass, List<Runner> paramList)
  {
    super(paramClass);
    this.runners = Collections.unmodifiableList(paramList);
  }
  
  public Suite(Class<?> paramClass, RunnerBuilder paramRunnerBuilder)
  {
    this(paramRunnerBuilder, paramClass, getAnnotatedClasses(paramClass));
  }
  
  protected Suite(Class<?> paramClass, Class<?>[] paramArrayOfClass)
  {
    this(new AllDefaultPossibilitiesBuilder(true), paramClass, paramArrayOfClass);
  }
  
  protected Suite(RunnerBuilder paramRunnerBuilder, Class<?> paramClass, Class<?>[] paramArrayOfClass)
  {
    this(paramClass, paramRunnerBuilder.runners(paramClass, paramArrayOfClass));
  }
  
  public Suite(RunnerBuilder paramRunnerBuilder, Class<?>[] paramArrayOfClass)
  {
    this(null, paramRunnerBuilder.runners(null, paramArrayOfClass));
  }
  
  public static Runner emptySuite()
  {
    try
    {
      Suite localSuite = new Suite((Class)null, new Class[0]);
      return localSuite;
    }
    catch (InitializationError localInitializationError)
    {
      label18:
      break label18;
    }
    throw new RuntimeException("This shouldn't be possible");
  }
  
  private static Class<?>[] getAnnotatedClasses(Class<?> paramClass)
  {
    Suite.SuiteClasses localSuiteClasses = (Suite.SuiteClasses)paramClass.getAnnotation(Suite.SuiteClasses.class);
    if (localSuiteClasses != null) {
      return localSuiteClasses.value();
    }
    throw new InitializationError(String.format("class '%s' must have a SuiteClasses annotation", new Object[] { paramClass.getName() }));
  }
  
  protected Description describeChild(Runner paramRunner)
  {
    return paramRunner.getDescription();
  }
  
  protected List<Runner> getChildren()
  {
    return this.runners;
  }
  
  protected void runChild(Runner paramRunner, RunNotifier paramRunNotifier)
  {
    paramRunner.run(paramRunNotifier);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.junit.runners.Suite
 * JD-Core Version:    0.7.0.1
 */