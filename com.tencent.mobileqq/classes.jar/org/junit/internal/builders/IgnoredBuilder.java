package org.junit.internal.builders;

import org.junit.Ignore;
import org.junit.runner.Runner;
import org.junit.runners.model.RunnerBuilder;

public class IgnoredBuilder
  extends RunnerBuilder
{
  public Runner runnerForClass(Class<?> paramClass)
  {
    if (paramClass.getAnnotation(Ignore.class) != null) {
      return new IgnoredClassRunner(paramClass);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.junit.internal.builders.IgnoredBuilder
 * JD-Core Version:    0.7.0.1
 */