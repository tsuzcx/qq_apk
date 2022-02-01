package org.junit.experimental;

import org.junit.runner.Computer;
import org.junit.runner.Runner;
import org.junit.runners.ParentRunner;
import org.junit.runners.model.RunnerBuilder;

public class ParallelComputer
  extends Computer
{
  private final boolean classes;
  private final boolean methods;
  
  public ParallelComputer(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.classes = paramBoolean1;
    this.methods = paramBoolean2;
  }
  
  public static Computer classes()
  {
    return new ParallelComputer(true, false);
  }
  
  public static Computer methods()
  {
    return new ParallelComputer(false, true);
  }
  
  private static Runner parallelize(Runner paramRunner)
  {
    if ((paramRunner instanceof ParentRunner)) {
      ((ParentRunner)paramRunner).setScheduler(new ParallelComputer.1());
    }
    return paramRunner;
  }
  
  public Runner getRunner(RunnerBuilder paramRunnerBuilder, Class<?> paramClass)
  {
    paramClass = super.getRunner(paramRunnerBuilder, paramClass);
    paramRunnerBuilder = paramClass;
    if (this.methods) {
      paramRunnerBuilder = parallelize(paramClass);
    }
    return paramRunnerBuilder;
  }
  
  public Runner getSuite(RunnerBuilder paramRunnerBuilder, Class<?>[] paramArrayOfClass)
  {
    paramArrayOfClass = super.getSuite(paramRunnerBuilder, paramArrayOfClass);
    paramRunnerBuilder = paramArrayOfClass;
    if (this.classes) {
      paramRunnerBuilder = parallelize(paramArrayOfClass);
    }
    return paramRunnerBuilder;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     org.junit.experimental.ParallelComputer
 * JD-Core Version:    0.7.0.1
 */