package com.tencent.mobileqq.uftransfer.taskqueue;

import android.os.Bundle;
import com.tencent.mobileqq.uftransfer.UFTLogicThread;
import com.tencent.mobileqq.uftransfer.depend.UFTLog;
import com.tencent.mobileqq.uftransfer.task.IUFTTaskCallback;
import com.tencent.mobileqq.uftransfer.task.UFTBaseTask;
import java.util.Iterator;
import java.util.LinkedList;

public class UFTTaskQueue
  implements IUFTTaskCallback
{
  private static int b = 1;
  private int a;
  private int c = 0;
  private LinkedList<UFTBaseTask> d = new LinkedList();
  private LinkedList<UFTBaseTask> e = new LinkedList();
  
  public UFTTaskQueue(int paramInt)
  {
    int i = b;
    b = i + 1;
    this.a = i;
    this.c = paramInt;
    if (paramInt <= 0)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("QID[");
      localStringBuilder.append(this.a);
      localStringBuilder.append("] maxRunningNum < 1 cannot run!!!!!");
      UFTLog.d("[UFTTransfer] UFTTaskQueue", 1, localStringBuilder.toString());
    }
  }
  
  private UFTBaseTask a(long paramLong)
  {
    Object localObject = this.d.iterator();
    while (((Iterator)localObject).hasNext())
    {
      UFTBaseTask localUFTBaseTask = (UFTBaseTask)((Iterator)localObject).next();
      if (localUFTBaseTask.m() == paramLong)
      {
        ((Iterator)localObject).remove();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("QID[");
        ((StringBuilder)localObject).append(this.a);
        ((StringBuilder)localObject).append("] delWaitTask:");
        ((StringBuilder)localObject).append(paramLong);
        ((StringBuilder)localObject).append(g());
        UFTLog.b("[UFTTransfer] UFTTaskQueue", 1, ((StringBuilder)localObject).toString());
        return localUFTBaseTask;
      }
    }
    return null;
  }
  
  private UFTBaseTask b(long paramLong)
  {
    Object localObject = this.e.iterator();
    while (((Iterator)localObject).hasNext())
    {
      UFTBaseTask localUFTBaseTask = (UFTBaseTask)((Iterator)localObject).next();
      if (localUFTBaseTask.m() == paramLong)
      {
        ((Iterator)localObject).remove();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("QID[");
        ((StringBuilder)localObject).append(this.a);
        ((StringBuilder)localObject).append("] delRunningTask:");
        ((StringBuilder)localObject).append(paramLong);
        ((StringBuilder)localObject).append(g());
        UFTLog.b("[UFTTransfer] UFTTaskQueue", 1, ((StringBuilder)localObject).toString());
        return localUFTBaseTask;
      }
    }
    return null;
  }
  
  private void e()
  {
    if (d()) {
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("QID[");
    ((StringBuilder)localObject).append(this.a);
    ((StringBuilder)localObject).append("] runNext...");
    UFTLog.b("[UFTTransfer] UFTTaskQueue", 1, ((StringBuilder)localObject).toString());
    localObject = f();
    if (localObject != null)
    {
      if (((UFTBaseTask)localObject).k())
      {
        this.e.add(localObject);
        c((UFTBaseTask)localObject);
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("QID[");
      localStringBuilder.append(this.a);
      localStringBuilder.append("] task start fail. taskId:");
      localStringBuilder.append(((UFTBaseTask)localObject).m());
      UFTLog.d("[UFTTransfer] UFTTaskQueue", 1, localStringBuilder.toString());
      a();
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("QID[");
    ((StringBuilder)localObject).append(this.a);
    ((StringBuilder)localObject).append("] current is no waiting task that can run.");
    UFTLog.b("[UFTTransfer] UFTTaskQueue", 1, ((StringBuilder)localObject).toString());
  }
  
  private boolean e(UFTBaseTask paramUFTBaseTask)
  {
    if (paramUFTBaseTask == null) {
      return false;
    }
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext()) {
      if (paramUFTBaseTask.a((UFTBaseTask)localIterator.next())) {
        return true;
      }
    }
    return false;
  }
  
  private UFTBaseTask f()
  {
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext())
    {
      UFTBaseTask localUFTBaseTask = (UFTBaseTask)localIterator.next();
      if (localUFTBaseTask == null)
      {
        localIterator.remove();
      }
      else if (e(localUFTBaseTask))
      {
        UFTLog.c("[UFTTransfer] UFTTaskQueue", 1, "my queue have same task is running");
      }
      else if (!b(localUFTBaseTask))
      {
        UFTLog.c("[UFTTransfer] UFTTaskQueue", 1, "other busi queue have same task is running");
      }
      else
      {
        localIterator.remove();
        return localUFTBaseTask;
      }
    }
    return null;
  }
  
  private String g()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" queueInfo [maxnum:");
    localStringBuilder.append(this.c);
    localStringBuilder.append(" waitnum:");
    localStringBuilder.append(this.d.size());
    localStringBuilder.append(" runnum:");
    localStringBuilder.append(this.e.size());
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  protected void a()
  {
    UFTLogicThread.a().a(new UFTTaskQueue.1(this));
  }
  
  public void a(long paramLong, Bundle paramBundle)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("QID[");
    ((StringBuilder)localObject).append(this.a);
    ((StringBuilder)localObject).append("] stopTask:");
    ((StringBuilder)localObject).append(paramLong);
    UFTLog.b("[UFTTransfer] UFTTaskQueue", 1, ((StringBuilder)localObject).toString());
    localObject = a(paramLong);
    if (localObject != null)
    {
      ((UFTBaseTask)localObject).a(paramBundle);
      return;
    }
    localObject = b(paramLong);
    if (localObject != null)
    {
      ((UFTBaseTask)localObject).a(paramBundle);
      d((UFTBaseTask)localObject);
      a();
    }
  }
  
  public void a(Bundle paramBundle)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("QID[");
    ((StringBuilder)localObject).append(this.a);
    ((StringBuilder)localObject).append("] stopAll");
    UFTLog.b("[UFTTransfer] UFTTaskQueue", 1, ((StringBuilder)localObject).toString());
    localObject = this.d.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((UFTBaseTask)((Iterator)localObject).next()).a(paramBundle);
    }
    localObject = this.e.iterator();
    while (((Iterator)localObject).hasNext())
    {
      UFTBaseTask localUFTBaseTask = (UFTBaseTask)((Iterator)localObject).next();
      localUFTBaseTask.a(paramBundle);
      d(localUFTBaseTask);
    }
    this.d.clear();
    this.e.clear();
  }
  
  public void a(UFTBaseTask paramUFTBaseTask)
  {
    if (paramUFTBaseTask == null) {
      return;
    }
    this.d.add(paramUFTBaseTask);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QID[");
    localStringBuilder.append(this.a);
    localStringBuilder.append("] addTask:");
    localStringBuilder.append(paramUFTBaseTask.m());
    localStringBuilder.append(g());
    UFTLog.b("[UFTTransfer] UFTTaskQueue", 1, localStringBuilder.toString());
    a();
  }
  
  public void a(UFTBaseTask paramUFTBaseTask, int paramInt)
  {
    if (paramUFTBaseTask != null)
    {
      if (b(paramUFTBaseTask.m()) != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("QID[");
        localStringBuilder.append(this.a);
        localStringBuilder.append("] onTaskCompleted. task:");
        localStringBuilder.append(paramUFTBaseTask.m());
        localStringBuilder.append(g());
        UFTLog.b("[UFTTransfer] UFTTaskQueue", 1, localStringBuilder.toString());
        d(paramUFTBaseTask);
      }
    }
    else
    {
      paramUFTBaseTask = new StringBuilder();
      paramUFTBaseTask.append("QID[");
      paramUFTBaseTask.append(this.a);
      paramUFTBaseTask.append("] onTaskCompleted. task=null");
      UFTLog.d("[UFTTransfer] UFTTaskQueue", 1, paramUFTBaseTask.toString());
    }
    a();
  }
  
  public int b()
  {
    return this.a;
  }
  
  protected boolean b(UFTBaseTask paramUFTBaseTask)
  {
    return true;
  }
  
  public int c()
  {
    return this.d.size();
  }
  
  protected void c(UFTBaseTask paramUFTBaseTask)
  {
    long l;
    if (paramUFTBaseTask != null) {
      l = paramUFTBaseTask.m();
    } else {
      l = 0L;
    }
    paramUFTBaseTask = new StringBuilder();
    paramUFTBaseTask.append("QID[");
    paramUFTBaseTask.append(this.a);
    paramUFTBaseTask.append("] task:");
    paramUFTBaseTask.append(l);
    paramUFTBaseTask.append(" start run");
    paramUFTBaseTask.append(g());
    UFTLog.b("[UFTTransfer] UFTTaskQueue", 1, paramUFTBaseTask.toString());
  }
  
  protected void d(UFTBaseTask paramUFTBaseTask)
  {
    long l;
    if (paramUFTBaseTask != null) {
      l = paramUFTBaseTask.m();
    } else {
      l = 0L;
    }
    paramUFTBaseTask = new StringBuilder();
    paramUFTBaseTask.append("QID[");
    paramUFTBaseTask.append(this.a);
    paramUFTBaseTask.append("] task:");
    paramUFTBaseTask.append(l);
    paramUFTBaseTask.append(" end run");
    paramUFTBaseTask.append(g());
    UFTLog.b("[UFTTransfer] UFTTaskQueue", 1, paramUFTBaseTask.toString());
  }
  
  public boolean d()
  {
    return this.e.size() >= this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.taskqueue.UFTTaskQueue
 * JD-Core Version:    0.7.0.1
 */