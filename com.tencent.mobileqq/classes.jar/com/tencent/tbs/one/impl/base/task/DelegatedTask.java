package com.tencent.tbs.one.impl.base.task;

public abstract class DelegatedTask
  extends Task
{
  public void run()
  {
    run(this);
  }
  
  public abstract void run(Task paramTask);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.base.task.DelegatedTask
 * JD-Core Version:    0.7.0.1
 */