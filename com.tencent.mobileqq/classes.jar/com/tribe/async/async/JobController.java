package com.tribe.async.async;

import android.support.annotation.NonNull;
import com.tribe.async.dispatch.Dispatcher.Dispatchable;
import com.tribe.async.dispatch.Subscriber.EventBatchSubscriber;
import com.tribe.async.utils.AssertUtils;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class JobController
  extends Subscriber.EventBatchSubscriber
{
  private static final String TAG = "async.boss.JobController";
  private Boss mBoss;
  private JobControlHandler mDefaultHandler;
  private final CopyOnWriteArrayList<JobControlHandler> mHandlers = new CopyOnWriteArrayList();
  
  public JobController(Boss paramBoss)
  {
    AssertUtils.checkNotNull(paramBoss);
    this.mBoss = paramBoss;
    this.mDefaultHandler = new JobController.DefaultJobControlHandler();
  }
  
  public void accept(@NonNull List<Class<? extends Dispatcher.Dispatchable>> paramList)
  {
    paramList.add(Worker.class);
    paramList.add(JobController.CancelCommand.class);
    paramList.add(JobController.DoneEvent.class);
  }
  
  public JobControlHandler getDefaultHandler()
  {
    return this.mDefaultHandler;
  }
  
  public void onDispatch(@NonNull Dispatcher.Dispatchable paramDispatchable)
  {
    boolean bool = paramDispatchable instanceof Worker;
    int j = 1;
    int k = 1;
    int i = 1;
    Job localJob;
    Iterator localIterator;
    JobControlHandler localJobControlHandler;
    if (bool)
    {
      paramDispatchable = (Worker)paramDispatchable;
      localJob = paramDispatchable.getJob();
      AssertUtils.checkNotNull(localJob);
      localIterator = this.mHandlers.iterator();
      while (localIterator.hasNext())
      {
        localJobControlHandler = (JobControlHandler)localIterator.next();
        if (localJobControlHandler.accept(localJob))
        {
          localJobControlHandler.handleExecute(this.mBoss.getExecutors(), paramDispatchable);
          break label100;
        }
      }
      i = 0;
      label100:
      if (i == 0) {
        this.mDefaultHandler.handleExecute(this.mBoss.getExecutors(), paramDispatchable);
      }
    }
    else if ((paramDispatchable instanceof JobController.CancelCommand))
    {
      paramDispatchable = (JobController.CancelCommand)paramDispatchable;
      AssertUtils.checkNotNull(paramDispatchable.future);
      localJob = ((Worker)paramDispatchable.future).getJob();
      AssertUtils.checkNotNull(localJob);
      localIterator = this.mHandlers.iterator();
      while (localIterator.hasNext())
      {
        localJobControlHandler = (JobControlHandler)localIterator.next();
        if (localJobControlHandler.accept(localJob))
        {
          localJobControlHandler.handleCancel(paramDispatchable);
          i = j;
          break label220;
        }
      }
      i = 0;
      label220:
      if (i == 0) {
        this.mDefaultHandler.handleCancel(paramDispatchable);
      }
    }
    else if ((paramDispatchable instanceof JobController.DoneEvent))
    {
      paramDispatchable = ((JobController.DoneEvent)paramDispatchable).worker;
      AssertUtils.checkNotNull(paramDispatchable);
      localJob = paramDispatchable.getJob();
      AssertUtils.checkNotNull(localJob);
      localIterator = this.mHandlers.iterator();
      while (localIterator.hasNext())
      {
        localJobControlHandler = (JobControlHandler)localIterator.next();
        if (localJobControlHandler.accept(localJob))
        {
          localJobControlHandler.handleDone(paramDispatchable);
          i = k;
          break label326;
        }
      }
      i = 0;
      label326:
      if (i == 0) {
        this.mDefaultHandler.handleDone(paramDispatchable);
      }
    }
  }
  
  public void registerJobControlHandler(JobControlHandler paramJobControlHandler)
  {
    AssertUtils.checkNotNull(paramJobControlHandler);
    if (!this.mHandlers.contains(paramJobControlHandler)) {
      this.mHandlers.add(paramJobControlHandler);
    }
  }
  
  public void unRegisterDispatchHandler(JobControlHandler paramJobControlHandler)
  {
    AssertUtils.checkNotNull(paramJobControlHandler);
    this.mHandlers.remove(paramJobControlHandler);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tribe.async.async.JobController
 * JD-Core Version:    0.7.0.1
 */