package org.junit.runner.notification;

import org.junit.runner.Description;

class RunNotifier$6
  extends RunNotifier.SafeNotifier
{
  RunNotifier$6(RunNotifier paramRunNotifier, Description paramDescription)
  {
    super(paramRunNotifier);
  }
  
  protected void notifyListener(RunListener paramRunListener)
  {
    paramRunListener.testIgnored(this.val$description);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.junit.runner.notification.RunNotifier.6
 * JD-Core Version:    0.7.0.1
 */