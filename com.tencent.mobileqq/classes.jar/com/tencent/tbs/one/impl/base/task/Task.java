package com.tencent.tbs.one.impl.base.task;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class Task
  implements Runnable
{
  private List<Runnable> mClosures = new ArrayList();
  private List<Task> mDependencies = new ArrayList();
  private boolean mEvaluated;
  private AtomicBoolean mExecuted = new AtomicBoolean();
  private AtomicBoolean mScheduled = new AtomicBoolean();
  private TaskRunner mTaskRunner;
  
  private void afterTask(Runnable paramRunnable)
  {
    this.mClosures.add(paramRunnable);
  }
  
  private boolean isExecuted()
  {
    return this.mExecuted.get();
  }
  
  private void schedule()
  {
    if (this.mScheduled.compareAndSet(false, true)) {
      this.mTaskRunner.onTaskPrepared(this);
    }
  }
  
  private void scheduleIfReady()
  {
    Iterator localIterator = this.mDependencies.iterator();
    while (localIterator.hasNext()) {
      if (!((Task)localIterator.next()).isExecuted()) {
        return;
      }
    }
    schedule();
  }
  
  public void dependsOn(Task paramTask)
  {
    this.mDependencies.add(paramTask);
  }
  
  void evaluate()
  {
    if (this.mEvaluated) {
      return;
    }
    this.mEvaluated = true;
    if ((this.mDependencies == null) || (this.mDependencies.size() <= 0)) {
      schedule();
    }
    for (;;)
    {
      this.mTaskRunner.onTaskEvaluated(this);
      return;
      Iterator localIterator = this.mDependencies.iterator();
      while (localIterator.hasNext())
      {
        Task localTask = (Task)localIterator.next();
        localTask.setTaskRunner(this.mTaskRunner);
        localTask.afterTask(new Task.1(this));
        localTask.evaluate();
      }
    }
  }
  
  public void fail(int paramInt, String paramString)
  {
    fail(paramInt, paramString, null);
  }
  
  public void fail(int paramInt, String paramString, Throwable paramThrowable)
  {
    this.mTaskRunner.onTaskError(this, paramInt, paramString, paramThrowable);
  }
  
  public void finish()
  {
    if (this.mExecuted.compareAndSet(false, true))
    {
      Iterator localIterator = this.mClosures.iterator();
      while (localIterator.hasNext()) {
        ((Runnable)localIterator.next()).run();
      }
      this.mTaskRunner.onTaskFinished(this);
    }
  }
  
  void setTaskRunner(TaskRunner paramTaskRunner)
  {
    this.mTaskRunner = paramTaskRunner;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.base.task.Task
 * JD-Core Version:    0.7.0.1
 */