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
    int j = 1;
    int i = 1;
    Job localJob;
    Iterator localIterator;
    JobControlHandler localJobControlHandler;
    if ((paramDispatchable instanceof Worker))
    {
      localJob = ((Worker)paramDispatchable).getJob();
      AssertUtils.checkNotNull(localJob);
      localIterator = this.mHandlers.iterator();
      while (localIterator.hasNext())
      {
        localJobControlHandler = (JobControlHandler)localIterator.next();
        if (localJobControlHandler.accept(localJob)) {
          localJobControlHandler.handleExecute(this.mBoss.getExecutors(), (Worker)paramDispatchable);
        }
      }
    }
    for (;;)
    {
      if (i == 0) {
        this.mDefaultHandler.handleExecute(this.mBoss.getExecutors(), (Worker)paramDispatchable);
      }
      label330:
      for (;;)
      {
        return;
        if ((paramDispatchable instanceof JobController.CancelCommand))
        {
          paramDispatchable = (JobController.CancelCommand)paramDispatchable;
          AssertUtils.checkNotNull(paramDispatchable.future);
          localJob = ((Worker)paramDispatchable.future).getJob();
          AssertUtils.checkNotNull(localJob);
          localIterator = this.mHandlers.iterator();
          while (localIterator.hasNext())
          {
            localJobControlHandler = (JobControlHandler)localIterator.next();
            if (localJobControlHandler.accept(localJob)) {
              localJobControlHandler.handleCancel(paramDispatchable);
            }
          }
        }
        for (i = j;; i = 0)
        {
          if (i != 0) {
            break label330;
          }
          this.mDefaultHandler.handleCancel(paramDispatchable);
          return;
          if (!(paramDispatchable instanceof JobController.DoneEvent)) {
            break;
          }
          paramDispatchable = ((JobController.DoneEvent)paramDispatchable).worker;
          AssertUtils.checkNotNull(paramDispatchable);
          localJob = paramDispatchable.getJob();
          AssertUtils.checkNotNull(localJob);
          localIterator = this.mHandlers.iterator();
          while (localIterator.hasNext())
          {
            localJobControlHandler = (JobControlHandler)localIterator.next();
            if (localJobControlHandler.accept(localJob)) {
              localJobControlHandler.handleDone(paramDispatchable);
            }
          }
          for (i = 1; i == 0; i = 0)
          {
            this.mDefaultHandler.handleDone(paramDispatchable);
            return;
          }
          break;
        }
      }
      i = 0;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tribe.async.async.JobController
 * JD-Core Version:    0.7.0.1
 */