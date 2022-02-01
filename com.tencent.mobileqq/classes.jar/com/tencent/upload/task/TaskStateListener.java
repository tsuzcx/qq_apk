package com.tencent.upload.task;

public abstract interface TaskStateListener
{
  public abstract void onTaskFinished(BaseTask paramBaseTask, int paramInt, String paramString);
  
  public abstract void onTaskInfoChanged(BaseTask paramBaseTask);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.upload.task.TaskStateListener
 * JD-Core Version:    0.7.0.1
 */