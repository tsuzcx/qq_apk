package com.tribe.async.async;

import android.support.annotation.NonNull;
import com.tribe.async.dispatch.Dispatcher.Command;
import com.tribe.async.dispatch.Dispatcher.Dispatchable;
import com.tribe.async.dispatch.Dispatcher.Event;
import com.tribe.async.dispatch.Subscriber.EventBatchSubscriber;
import com.tribe.async.utils.AssertUtils;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;

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
    this.mDefaultHandler = new DefaultJobControlHandler();
  }
  
  public void accept(@NonNull List<Class<? extends Dispatcher.Dispatchable>> paramList)
  {
    paramList.add(Worker.class);
    paramList.add(CancelCommand.class);
    paramList.add(DoneEvent.class);
  }
  
  public JobControlHandler getDefaultHandler()
  {
    return this.mDefaultHandler;
  }
  
  public void onDispatch(@NonNull Dispatcher.Dispatchable paramDispatchable)
  {
    int j;
    Job localJob;
    Iterator localIterator;
    int i;
    JobControlHandler localJobControlHandler;
    if ((paramDispatchable instanceof Worker))
    {
      j = 0;
      localJob = ((Worker)paramDispatchable).getJob();
      AssertUtils.checkNotNull(localJob);
      localIterator = this.mHandlers.iterator();
      do
      {
        i = j;
        if (!localIterator.hasNext()) {
          break;
        }
        localJobControlHandler = (JobControlHandler)localIterator.next();
      } while (!localJobControlHandler.accept(localJob));
      localJobControlHandler.handleExecute(this.mBoss.getExecutors(), (Worker)paramDispatchable);
      i = 1;
      if (i == 0) {
        this.mDefaultHandler.handleExecute(this.mBoss.getExecutors(), (Worker)paramDispatchable);
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          if (!(paramDispatchable instanceof CancelCommand)) {
            break;
          }
          paramDispatchable = (CancelCommand)paramDispatchable;
          AssertUtils.checkNotNull(paramDispatchable.future);
          localJob = ((Worker)paramDispatchable.future).getJob();
          AssertUtils.checkNotNull(localJob);
          j = 0;
          localIterator = this.mHandlers.iterator();
          do
          {
            i = j;
            if (!localIterator.hasNext()) {
              break;
            }
            localJobControlHandler = (JobControlHandler)localIterator.next();
          } while (!localJobControlHandler.accept(localJob));
          localJobControlHandler.handleCancel(paramDispatchable);
          i = 1;
        } while (i != 0);
        this.mDefaultHandler.handleCancel(paramDispatchable);
        return;
      } while (!(paramDispatchable instanceof DoneEvent));
      paramDispatchable = ((DoneEvent)paramDispatchable).worker;
      AssertUtils.checkNotNull(paramDispatchable);
      localJob = paramDispatchable.getJob();
      AssertUtils.checkNotNull(localJob);
      j = 0;
      localIterator = this.mHandlers.iterator();
      do
      {
        i = j;
        if (!localIterator.hasNext()) {
          break;
        }
        localJobControlHandler = (JobControlHandler)localIterator.next();
      } while (!localJobControlHandler.accept(localJob));
      localJobControlHandler.handleDone(paramDispatchable);
      i = 1;
    } while (i != 0);
    this.mDefaultHandler.handleDone(paramDispatchable);
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
  
  public static class CancelCommand
    implements Dispatcher.Command
  {
    public final Future future;
    public final boolean mayInterrupt;
    
    public CancelCommand(Future paramFuture, boolean paramBoolean)
    {
      AssertUtils.checkNotNull(paramFuture);
      this.future = paramFuture;
      this.mayInterrupt = paramBoolean;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("CancelCommand").append("{");
      localStringBuilder.append("job=").append(((Worker)this.future).getJob());
      localStringBuilder.append('}');
      return localStringBuilder.toString();
    }
  }
  
  public static class DefaultJobControlHandler
    implements JobControlHandler
  {
    public boolean accept(@NonNull Job paramJob)
    {
      return true;
    }
    
    public void handleCancel(@NonNull JobController.CancelCommand paramCancelCommand)
    {
      Future localFuture = paramCancelCommand.future;
      boolean bool = paramCancelCommand.mayInterrupt;
      if (localFuture != null) {
        localFuture.cancel(bool);
      }
    }
    
    public void handleDone(@NonNull Worker paramWorker) {}
    
    public void handleExecute(@NonNull Executor[] paramArrayOfExecutor, @NonNull Worker paramWorker)
    {
      if (paramArrayOfExecutor.length > 0) {}
      for (boolean bool = true;; bool = false)
      {
        AssertUtils.assertTrue(bool);
        int i = paramWorker.getJobType();
        Bosses.get().getExecutor(i).execute(paramWorker);
        return;
      }
    }
  }
  
  public static class DoneEvent
    implements Dispatcher.Event
  {
    public final Worker worker;
    
    public DoneEvent(Worker paramWorker)
    {
      this.worker = paramWorker;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tribe.async.async.JobController
 * JD-Core Version:    0.7.0.1
 */