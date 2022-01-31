package com.tencent.mobileqq.minigame.task;

import com.tencent.mobileqq.minigame.utils.thread.TTHandleThread;
import java.util.concurrent.Executor;

class TritonEngineInitTask$1
  implements Executor
{
  TritonEngineInitTask$1(TritonEngineInitTask paramTritonEngineInitTask) {}
  
  public void execute(Runnable paramRunnable)
  {
    TTHandleThread.getInstance().execute_FILE(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.task.TritonEngineInitTask.1
 * JD-Core Version:    0.7.0.1
 */