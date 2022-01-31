package org.junit.runner;

import org.junit.runners.Suite;
import org.junit.runners.model.RunnerBuilder;

public class Computer
{
  public static Computer serial()
  {
    return new Computer();
  }
  
  protected Runner getRunner(RunnerBuilder paramRunnerBuilder, Class<?> paramClass)
  {
    return paramRunnerBuilder.runnerForClass(paramClass);
  }
  
  public Runner getSuite(RunnerBuilder paramRunnerBuilder, Class<?>[] paramArrayOfClass)
  {
    return new Suite(new Computer.1(this, paramRunnerBuilder), paramArrayOfClass);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     org.junit.runner.Computer
 * JD-Core Version:    0.7.0.1
 */