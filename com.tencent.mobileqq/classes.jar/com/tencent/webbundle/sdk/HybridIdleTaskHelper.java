package com.tencent.webbundle.sdk;

import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import java.util.ArrayList;
import java.util.List;

public class HybridIdleTaskHelper
{
  private static volatile HybridIdleTaskHelper instance;
  private MessageQueue.IdleHandler sIdleHandler = new HybridIdleTaskHelper.1(this);
  private List<HybridIdleTaskHelper.IdleTask> sIdleTasks = new ArrayList(5);
  boolean sIsIdleHandlerInQueue = false;
  
  private void doAddIdleTask(HybridIdleTaskHelper.IdleTask paramIdleTask)
  {
    int i = 0;
    if (i < this.sIdleTasks.size()) {
      if (((HybridIdleTaskHelper.IdleTask)this.sIdleTasks.get(i)).taskId != paramIdleTask.taskId) {}
    }
    do
    {
      return;
      i += 1;
      break;
      this.sIdleTasks.add(paramIdleTask);
    } while ((this.sIdleTasks.isEmpty()) || (this.sIsIdleHandlerInQueue));
    this.sIsIdleHandlerInQueue = true;
    Looper.myQueue().addIdleHandler(this.sIdleHandler);
  }
  
  public static HybridIdleTaskHelper getInstance()
  {
    if (instance == null) {}
    try
    {
      if (instance == null) {
        instance = new HybridIdleTaskHelper();
      }
      return instance;
    }
    finally {}
  }
  
  public void addIdleTask(HybridIdleTaskHelper.IdleTask paramIdleTask)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      doAddIdleTask(paramIdleTask);
      return;
    }
    ThreadManager.getUiHandler().post(new HybridIdleTaskHelper.2(this, paramIdleTask));
  }
  
  public boolean removeIdleTask(int paramInt)
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < this.sIdleTasks.size())
      {
        if (((HybridIdleTaskHelper.IdleTask)this.sIdleTasks.get(i)).taskId == paramInt)
        {
          this.sIdleTasks.remove(i);
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.webbundle.sdk.HybridIdleTaskHelper
 * JD-Core Version:    0.7.0.1
 */