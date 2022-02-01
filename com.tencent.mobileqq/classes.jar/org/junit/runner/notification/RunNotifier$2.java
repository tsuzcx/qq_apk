package org.junit.runner.notification;

import org.junit.runner.Result;

class RunNotifier$2
  extends RunNotifier.SafeNotifier
{
  RunNotifier$2(RunNotifier paramRunNotifier, Result paramResult)
  {
    super(paramRunNotifier);
  }
  
  protected void notifyListener(RunListener paramRunListener)
  {
    paramRunListener.testRunFinished(this.val$result);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.junit.runner.notification.RunNotifier.2
 * JD-Core Version:    0.7.0.1
 */