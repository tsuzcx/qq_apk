package com.tencent.tavcut.session;

import java.util.concurrent.Semaphore;

class TAVCutSession$10
  implements Runnable
{
  TAVCutSession$10(TAVCutSession paramTAVCutSession, Runnable paramRunnable, Semaphore paramSemaphore) {}
  
  public void run()
  {
    this.val$task.run();
    this.val$lock.release();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tavcut.session.TAVCutSession.10
 * JD-Core Version:    0.7.0.1
 */