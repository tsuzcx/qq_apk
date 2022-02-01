package org.junit.runner;

import org.junit.runner.notification.RunNotifier;

public abstract class Runner
  implements Describable
{
  public abstract Description getDescription();
  
  public abstract void run(RunNotifier paramRunNotifier);
  
  public int testCount()
  {
    return getDescription().testCount();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     org.junit.runner.Runner
 * JD-Core Version:    0.7.0.1
 */