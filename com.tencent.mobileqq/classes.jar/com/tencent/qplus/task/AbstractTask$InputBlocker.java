package com.tencent.qplus.task;

import android.view.View;

public abstract class AbstractTask$InputBlocker
{
  private final AbstractTask.BlockingScope scope;
  private final Object target;
  private final AbstractTask task;
  
  public AbstractTask$InputBlocker(AbstractTask paramAbstractTask, AbstractTask.BlockingScope paramBlockingScope, Object paramObject)
  {
    if (paramAbstractTask == null) {
      throw new IllegalArgumentException("null task");
    }
    if (paramAbstractTask.getTaskService() != null) {
      throw new IllegalStateException("task already being executed");
    }
    switch (paramBlockingScope)
    {
    }
    do
    {
      this.task = paramAbstractTask;
      this.scope = paramBlockingScope;
      this.target = paramObject;
      return;
    } while ((paramObject instanceof View));
    throw new IllegalArgumentException("target not a Component");
  }
  
  protected abstract void block();
  
  public final AbstractTask.BlockingScope getScope()
  {
    return this.scope;
  }
  
  public final Object getTarget()
  {
    return this.target;
  }
  
  public final AbstractTask getTask()
  {
    return this.task;
  }
  
  protected abstract void unblock();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qplus.task.AbstractTask.InputBlocker
 * JD-Core Version:    0.7.0.1
 */