package com.tencent.qcircle.tavcut.session;

import java.util.concurrent.Semaphore;

class TAVCutSession$11
  implements Runnable
{
  TAVCutSession$11(TAVCutSession paramTAVCutSession, Runnable paramRunnable, Semaphore paramSemaphore) {}
  
  public void run()
  {
    this.val$task.run();
    this.val$lock.release();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.tavcut.session.TAVCutSession.11
 * JD-Core Version:    0.7.0.1
 */