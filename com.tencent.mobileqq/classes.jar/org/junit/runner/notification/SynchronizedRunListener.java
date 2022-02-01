package org.junit.runner.notification;

import org.junit.runner.Description;
import org.junit.runner.Result;

@RunListener.ThreadSafe
final class SynchronizedRunListener
  extends RunListener
{
  private final RunListener listener;
  private final Object monitor;
  
  SynchronizedRunListener(RunListener paramRunListener, Object paramObject)
  {
    this.listener = paramRunListener;
    this.monitor = paramObject;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof SynchronizedRunListener)) {
      return false;
    }
    paramObject = (SynchronizedRunListener)paramObject;
    return this.listener.equals(paramObject.listener);
  }
  
  public int hashCode()
  {
    return this.listener.hashCode();
  }
  
  public void testAssumptionFailure(Failure paramFailure)
  {
    synchronized (this.monitor)
    {
      this.listener.testAssumptionFailure(paramFailure);
      return;
    }
  }
  
  public void testFailure(Failure paramFailure)
  {
    synchronized (this.monitor)
    {
      this.listener.testFailure(paramFailure);
      return;
    }
  }
  
  public void testFinished(Description paramDescription)
  {
    synchronized (this.monitor)
    {
      this.listener.testFinished(paramDescription);
      return;
    }
  }
  
  public void testIgnored(Description paramDescription)
  {
    synchronized (this.monitor)
    {
      this.listener.testIgnored(paramDescription);
      return;
    }
  }
  
  public void testRunFinished(Result paramResult)
  {
    synchronized (this.monitor)
    {
      this.listener.testRunFinished(paramResult);
      return;
    }
  }
  
  public void testRunStarted(Description paramDescription)
  {
    synchronized (this.monitor)
    {
      this.listener.testRunStarted(paramDescription);
      return;
    }
  }
  
  public void testStarted(Description paramDescription)
  {
    synchronized (this.monitor)
    {
      this.listener.testStarted(paramDescription);
      return;
    }
  }
  
  public String toString()
  {
    return this.listener.toString() + " (with synchronization wrapper)";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     org.junit.runner.notification.SynchronizedRunListener
 * JD-Core Version:    0.7.0.1
 */