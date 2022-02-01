package org.junit.internal.builders;

import org.junit.runner.Runner;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.RunnerBuilder;

public class JUnit4Builder
  extends RunnerBuilder
{
  public Runner runnerForClass(Class<?> paramClass)
  {
    return new BlockJUnit4ClassRunner(paramClass);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     org.junit.internal.builders.JUnit4Builder
 * JD-Core Version:    0.7.0.1
 */