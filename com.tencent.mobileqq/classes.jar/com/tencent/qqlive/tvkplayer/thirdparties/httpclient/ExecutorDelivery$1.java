package com.tencent.qqlive.tvkplayer.thirdparties.httpclient;

import android.os.Handler;
import java.util.concurrent.Executor;

class ExecutorDelivery$1
  implements Executor
{
  ExecutorDelivery$1(ExecutorDelivery paramExecutorDelivery, Handler paramHandler) {}
  
  public void execute(Runnable paramRunnable)
  {
    this.val$handler.post(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.thirdparties.httpclient.ExecutorDelivery.1
 * JD-Core Version:    0.7.0.1
 */