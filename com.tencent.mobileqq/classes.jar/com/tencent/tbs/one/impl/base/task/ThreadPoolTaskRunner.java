package com.tencent.tbs.one.impl.base.task;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPoolTaskRunner
  extends TaskRunner
{
  private boolean mEvaluating;
  private Executor mExecutor;
  private List<Task> mPendingTasks = new ArrayList();
  private AtomicInteger mTaskCount = new AtomicInteger();
  
  public ThreadPoolTaskRunner(Executor paramExecutor)
  {
    this.mExecutor = paramExecutor;
  }
  
  public void onTaskEvaluated(Task paramTask)
  {
    this.mTaskCount.incrementAndGet();
  }
  
  public void onTaskFinished(Task paramTask)
  {
    if (this.mTaskCount.decrementAndGet() <= 0) {
      finish();
    }
  }
  
  public void onTaskPrepared(Task paramTask)
  {
    if (this.mEvaluating)
    {
      this.mPendingTasks.add(paramTask);
      return;
    }
    this.mExecutor.execute(paramTask);
  }
  
  public void run(Task paramTask)
  {
    int i = 0;
    paramTask.setTaskRunner(this);
    this.mEvaluating = true;
    paramTask.evaluate();
    this.mEvaluating = false;
    paramTask = (Task[])this.mPendingTasks.toArray(new Task[0]);
    this.mPendingTasks.clear();
    int j = paramTask.length;
    while (i < j)
    {
      Runnable localRunnable = paramTask[i];
      this.mExecutor.execute(localRunnable);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.base.task.ThreadPoolTaskRunner
 * JD-Core Version:    0.7.0.1
 */