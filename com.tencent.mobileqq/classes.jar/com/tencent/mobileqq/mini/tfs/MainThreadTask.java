package com.tencent.mobileqq.mini.tfs;

import android.content.Context;
import android.os.Handler;

public abstract class MainThreadTask
  extends BaseTask
{
  public MainThreadTask(Context paramContext)
  {
    super(paramContext, 3);
  }
  
  public final void execute()
  {
    this.mainHander.post(new MainThreadTask.1(this));
  }
  
  public abstract void executeInMainThread();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.tfs.MainThreadTask
 * JD-Core Version:    0.7.0.1
 */