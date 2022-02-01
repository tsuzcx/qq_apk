package org.junit.internal.builders;

import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.notification.RunNotifier;

public class IgnoredClassRunner
  extends Runner
{
  private final Class<?> clazz;
  
  public IgnoredClassRunner(Class<?> paramClass)
  {
    this.clazz = paramClass;
  }
  
  public Description getDescription()
  {
    return Description.createSuiteDescription(this.clazz);
  }
  
  public void run(RunNotifier paramRunNotifier)
  {
    paramRunNotifier.fireTestIgnored(getDescription());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     org.junit.internal.builders.IgnoredClassRunner
 * JD-Core Version:    0.7.0.1
 */