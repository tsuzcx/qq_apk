package org.junit.internal.builders;

import org.junit.internal.runners.SuiteMethod;
import org.junit.runner.Runner;
import org.junit.runners.model.RunnerBuilder;

public class SuiteMethodBuilder
  extends RunnerBuilder
{
  public boolean hasSuiteMethod(Class<?> paramClass)
  {
    try
    {
      paramClass.getMethod("suite", new Class[0]);
      return true;
    }
    catch (NoSuchMethodException paramClass) {}
    return false;
  }
  
  public Runner runnerForClass(Class<?> paramClass)
  {
    if (hasSuiteMethod(paramClass)) {
      return new SuiteMethod(paramClass);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     org.junit.internal.builders.SuiteMethodBuilder
 * JD-Core Version:    0.7.0.1
 */