package com.tencent.qqmini.v8rt.engine;

import java.util.concurrent.CountDownLatch;

class Engine$1
  implements V8TimerThread.IListener
{
  Engine$1(Engine paramEngine, CountDownLatch paramCountDownLatch) {}
  
  public void onExit() {}
  
  public boolean onPrepare()
  {
    this.val$latch.countDown();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.v8rt.engine.Engine.1
 * JD-Core Version:    0.7.0.1
 */