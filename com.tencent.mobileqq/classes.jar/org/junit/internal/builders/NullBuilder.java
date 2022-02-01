package org.junit.internal.builders;

import org.junit.runner.Runner;
import org.junit.runners.model.RunnerBuilder;

public class NullBuilder
  extends RunnerBuilder
{
  public Runner runnerForClass(Class<?> paramClass)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     org.junit.internal.builders.NullBuilder
 * JD-Core Version:    0.7.0.1
 */