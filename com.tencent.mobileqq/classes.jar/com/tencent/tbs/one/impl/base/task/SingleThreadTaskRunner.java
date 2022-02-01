package com.tencent.tbs.one.impl.base.task;

import java.util.LinkedList;
import java.util.Queue;

public class SingleThreadTaskRunner
  extends TaskRunner
{
  private Queue<Task> mExecutionQueue = new LinkedList();
  private boolean mLooping;
  private int mTaskCount;
  
  private void runLoop()
  {
    this.mLooping = true;
    for (;;)
    {
      Task localTask = (Task)this.mExecutionQueue.poll();
      if (localTask == null) {
        break;
      }
      localTask.run();
    }
    this.mLooping = false;
  }
  
  public void onTaskEvaluated(Task paramTask)
  {
    this.mTaskCount += 1;
  }
  
  public void onTaskFinished(Task paramTask)
  {
    this.mTaskCount -= 1;
    if (this.mTaskCount <= 0) {
      finish();
    }
    while (this.mLooping) {
      return;
    }
    runLoop();
  }
  
  public void onTaskPrepared(Task paramTask)
  {
    this.mExecutionQueue.offer(paramTask);
  }
  
  public void run(Task paramTask)
  {
    paramTask.setTaskRunner(this);
    paramTask.evaluate();
    runLoop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.base.task.SingleThreadTaskRunner
 * JD-Core Version:    0.7.0.1
 */