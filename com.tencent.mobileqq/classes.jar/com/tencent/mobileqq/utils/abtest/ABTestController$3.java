package com.tencent.mobileqq.utils.abtest;

import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;
import java.util.concurrent.atomic.AtomicInteger;

class ABTestController$3
  implements ThreadExcutor.IThreadListener
{
  ABTestController$3(ABTestController paramABTestController) {}
  
  public void onAdded() {}
  
  public void onPostRun()
  {
    if (ABTestController.b(this.a).get() == 1) {
      ABTestController.b(this.a).set(0);
    }
  }
  
  public void onPreRun() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.abtest.ABTestController.3
 * JD-Core Version:    0.7.0.1
 */