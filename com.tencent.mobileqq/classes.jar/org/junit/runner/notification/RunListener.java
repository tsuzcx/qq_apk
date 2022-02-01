package org.junit.runner.notification;

import org.junit.runner.Description;
import org.junit.runner.Result;

public class RunListener
{
  public void testAssumptionFailure(Failure paramFailure) {}
  
  public void testFailure(Failure paramFailure) {}
  
  public void testFinished(Description paramDescription) {}
  
  public void testIgnored(Description paramDescription) {}
  
  public void testRunFinished(Result paramResult) {}
  
  public void testRunStarted(Description paramDescription) {}
  
  public void testStarted(Description paramDescription) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.junit.runner.notification.RunListener
 * JD-Core Version:    0.7.0.1
 */