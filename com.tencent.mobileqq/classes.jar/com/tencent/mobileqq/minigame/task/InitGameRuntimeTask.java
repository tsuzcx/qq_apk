package com.tencent.mobileqq.minigame.task;

import android.content.Context;
import com.tencent.mobileqq.mini.tfs.MainThreadTask;

public class InitGameRuntimeTask
  extends MainThreadTask
{
  public InitGameRuntimeTask(Context paramContext)
  {
    super(paramContext);
  }
  
  public void executeInMainThread()
  {
    onTaskSucceed();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.task.InitGameRuntimeTask
 * JD-Core Version:    0.7.0.1
 */