package org.junit.runners.parameterized;

import org.junit.runner.Runner;

public abstract interface ParametersRunnerFactory
{
  public abstract Runner createRunnerForTestWithParameters(TestWithParameters paramTestWithParameters);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     org.junit.runners.parameterized.ParametersRunnerFactory
 * JD-Core Version:    0.7.0.1
 */