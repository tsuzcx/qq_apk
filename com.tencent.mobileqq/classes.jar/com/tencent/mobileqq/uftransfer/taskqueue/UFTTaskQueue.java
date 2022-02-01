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
  private static int jdField_b_of_type_Int = 1;
  private int jdField_a_of_type_Int;
  private LinkedList<UFTBaseTask> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  private LinkedList<UFTBaseTask> jdField_b_of_type_JavaUtilLinkedList = new LinkedList();
  private int c = 0;
  
  public UFTTaskQueue(int paramInt)
  {
    int i = jdField_b_of_type_Int;
    jdField_b_of_type_Int = i + 1;
    this.jdField_a_of_type_Int = i;
    this.c = paramInt;
    if (paramInt <= 0)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("QID[");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      localStringBuilder.append("] maxRunningNum < 1 cannot run!!!!!");
      UFTLog.d("[UFTTransfer] UFTTaskQueue", 1, localStringBuilder.toString());
    }
  }
  
  private UFTBaseTask a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
    while (localIterator.hasNext())
    {
      UFTBaseTask localUFTBaseTask = (UFTBaseTask)localIterator.next();
      if (localUFTBaseTask == null)
      {
        localIterator.remove();
      }
      else if (b(localUFTBaseTask))
      {
        UFTLog.c("[UFTTransfer] UFTTaskQueue", 1, "my queue have same task is running");
      }
      else if (!a(localUFTBaseTask))
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
  
  private UFTBaseTask a(long paramLong)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      UFTBaseTask localUFTBaseTask = (UFTBaseTask)((Iterator)localObject).next();
      if (localUFTBaseTask.a() == paramLong)
      {
        ((Iterator)localObject).remove();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("QID[");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
        ((StringBuilder)localObject).append("] delWaitTask:");
        ((StringBuilder)localObject).append(paramLong);
        ((StringBuilder)localObject).append(a());
        UFTLog.b("[UFTTransfer] UFTTaskQueue", 1, ((StringBuilder)localObject).toString());
        return localUFTBaseTask;
      }
    }
    return null;
  }
  
  private String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" queueInfo [maxnum:");
    localStringBuilder.append(this.c);
    localStringBuilder.append(" waitnum:");
    localStringBuilder.append(this.jdField_a_of_type_JavaUtilLinkedList.size());
    localStringBuilder.append(" runnum:");
    localStringBuilder.append(this.jdField_b_of_type_JavaUtilLinkedList.size());
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  private UFTBaseTask b(long paramLong)
  {
    Object localObject = this.jdField_b_of_type_JavaUtilLinkedList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      UFTBaseTask localUFTBaseTask = (UFTBaseTask)((Iterator)localObject).next();
      if (localUFTBaseTask.a() == paramLong)
      {
        ((Iterator)localObject).remove();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("QID[");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
        ((StringBuilder)localObject).append("] delRunningTask:");
        ((StringBuilder)localObject).append(paramLong);
        ((StringBuilder)localObject).append(a());
        UFTLog.b("[UFTTransfer] UFTTaskQueue", 1, ((StringBuilder)localObject).toString());
        return localUFTBaseTask;
      }
    }
    return null;
  }
  
  private void b()
  {
    if (a()) {
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("QID[");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
    ((StringBuilder)localObject).append("] runNext...");
    UFTLog.b("[UFTTransfer] UFTTaskQueue", 1, ((StringBuilder)localObject).toString());
    localObject = a();
    if (localObject != null)
    {
      if (((UFTBaseTask)localObject).b())
      {
        this.jdField_b_of_type_JavaUtilLinkedList.add(localObject);
        b((UFTBaseTask)localObject);
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("QID[");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      localStringBuilder.append("] task start fail. taskId:");
      localStringBuilder.append(((UFTBaseTask)localObject).a());
      UFTLog.d("[UFTTransfer] UFTTaskQueue", 1, localStringBuilder.toString());
      a();
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("QID[");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
    ((StringBuilder)localObject).append("] current is no waiting task that can run.");
    UFTLog.b("[UFTTransfer] UFTTaskQueue", 1, ((StringBuilder)localObject).toString());
  }
  
  private boolean b(UFTBaseTask paramUFTBaseTask)
  {
    if (paramUFTBaseTask == null) {
      return false;
    }
    Iterator localIterator = this.jdField_b_of_type_JavaUtilLinkedList.iterator();
    while (localIterator.hasNext()) {
      if (paramUFTBaseTask.a((UFTBaseTask)localIterator.next())) {
        return true;
      }
    }
    return false;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  protected void a()
  {
    UFTLogicThread.a().a(new UFTTaskQueue.1(this));
  }
  
  public void a(long paramLong, Bundle paramBundle)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("QID[");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
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
      c((UFTBaseTask)localObject);
      a();
    }
  }
  
  public void a(Bundle paramBundle)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("QID[");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
    ((StringBuilder)localObject).append("] stopAll");
    UFTLog.b("[UFTTransfer] UFTTaskQueue", 1, ((StringBuilder)localObject).toString());
    localObject = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((UFTBaseTask)((Iterator)localObject).next()).a(paramBundle);
    }
    localObject = this.jdField_b_of_type_JavaUtilLinkedList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      UFTBaseTask localUFTBaseTask = (UFTBaseTask)((Iterator)localObject).next();
      localUFTBaseTask.a(paramBundle);
      c(localUFTBaseTask);
    }
    this.jdField_a_of_type_JavaUtilLinkedList.clear();
    this.jdField_b_of_type_JavaUtilLinkedList.clear();
  }
  
  public void a(UFTBaseTask paramUFTBaseTask)
  {
    if (paramUFTBaseTask == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilLinkedList.add(paramUFTBaseTask);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QID[");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append("] addTask:");
    localStringBuilder.append(paramUFTBaseTask.a());
    localStringBuilder.append(a());
    UFTLog.b("[UFTTransfer] UFTTaskQueue", 1, localStringBuilder.toString());
    a();
  }
  
  public void a(UFTBaseTask paramUFTBaseTask, int paramInt)
  {
    if (paramUFTBaseTask != null)
    {
      if (b(paramUFTBaseTask.a()) != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("QID[");
        localStringBuilder.append(this.jdField_a_of_type_Int);
        localStringBuilder.append("] onTaskCompleted. task:");
        localStringBuilder.append(paramUFTBaseTask.a());
        localStringBuilder.append(a());
        UFTLog.b("[UFTTransfer] UFTTaskQueue", 1, localStringBuilder.toString());
        c(paramUFTBaseTask);
      }
    }
    else
    {
      paramUFTBaseTask = new StringBuilder();
      paramUFTBaseTask.append("QID[");
      paramUFTBaseTask.append(this.jdField_a_of_type_Int);
      paramUFTBaseTask.append("] onTaskCompleted. task=null");
      UFTLog.d("[UFTTransfer] UFTTaskQueue", 1, paramUFTBaseTask.toString());
    }
    a();
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_JavaUtilLinkedList.size() >= this.c;
  }
  
  protected boolean a(UFTBaseTask paramUFTBaseTask)
  {
    return true;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_JavaUtilLinkedList.size();
  }
  
  protected void b(UFTBaseTask paramUFTBaseTask)
  {
    long l;
    if (paramUFTBaseTask != null) {
      l = paramUFTBaseTask.a();
    } else {
      l = 0L;
    }
    paramUFTBaseTask = new StringBuilder();
    paramUFTBaseTask.append("QID[");
    paramUFTBaseTask.append(this.jdField_a_of_type_Int);
    paramUFTBaseTask.append("] task:");
    paramUFTBaseTask.append(l);
    paramUFTBaseTask.append(" start run");
    paramUFTBaseTask.append(a());
    UFTLog.b("[UFTTransfer] UFTTaskQueue", 1, paramUFTBaseTask.toString());
  }
  
  protected void c(UFTBaseTask paramUFTBaseTask)
  {
    long l;
    if (paramUFTBaseTask != null) {
      l = paramUFTBaseTask.a();
    } else {
      l = 0L;
    }
    paramUFTBaseTask = new StringBuilder();
    paramUFTBaseTask.append("QID[");
    paramUFTBaseTask.append(this.jdField_a_of_type_Int);
    paramUFTBaseTask.append("] task:");
    paramUFTBaseTask.append(l);
    paramUFTBaseTask.append(" end run");
    paramUFTBaseTask.append(a());
    UFTLog.b("[UFTTransfer] UFTTaskQueue", 1, paramUFTBaseTask.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.taskqueue.UFTTaskQueue
 * JD-Core Version:    0.7.0.1
 */