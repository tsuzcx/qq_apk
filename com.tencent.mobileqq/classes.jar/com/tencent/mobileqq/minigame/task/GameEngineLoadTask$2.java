package com.tencent.mobileqq.minigame.task;

import com.tencent.mobileqq.minigame.utils.thread.TTHandleThread;
import java.util.concurrent.Executor;

class GameEngineLoadTask$2
  implements Executor
{
  GameEngineLoadTask$2(GameEngineLoadTask paramGameEngineLoadTask) {}
  
  public void execute(Runnable paramRunnable)
  {
    TTHandleThread.getInstance().execute_FILE(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.task.GameEngineLoadTask.2
 * JD-Core Version:    0.7.0.1
 */