package com.tencent.qplus.task;

import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class TaskMonitor
  extends AbstractBean
{
  private boolean autoUpdateForegroundTask = true;
  private Task foregroundTask = null;
  private final PropertyChangeListener taskPCL = new TaskMonitor.TaskPCL(this, null);
  private final LinkedList<Task> taskQueue = new LinkedList();
  private final PropertyChangeListener taskServicePCL = new TaskMonitor.TaskServicePCL(this, null);
  
  public TaskMonitor(TaskService paramTaskService)
  {
    paramTaskService.addPropertyChangeListener(this.taskServicePCL);
  }
  
  private List<Task> copyTaskQueue()
  {
    synchronized (this.taskQueue)
    {
      if (this.taskQueue.isEmpty())
      {
        localObject1 = Collections.emptyList();
        return localObject1;
      }
      Object localObject1 = new ArrayList(this.taskQueue);
      return localObject1;
    }
  }
  
  private void updateTasks(List<Task> paramList1, List<Task> paramList2)
  {
    List localList = copyTaskQueue();
    paramList1 = paramList1.iterator();
    int i = 0;
    if (!paramList1.hasNext())
    {
      paramList1 = paramList2.iterator();
      label31:
      if (paramList1.hasNext()) {
        break label144;
      }
      paramList1 = this.taskQueue.iterator();
      label48:
      if (paramList1.hasNext()) {
        break label178;
      }
      if (i != 0) {
        firePropertyChange("tasks", localList, copyTaskQueue());
      }
      if ((this.autoUpdateForegroundTask) && (getForegroundTask() == null)) {
        if (!this.taskQueue.isEmpty()) {
          break label204;
        }
      }
    }
    label144:
    label178:
    label204:
    for (paramList1 = null;; paramList1 = (Task)this.taskQueue.getLast())
    {
      setForegroundTask(paramList1);
      return;
      Task localTask = (Task)paramList1.next();
      if ((paramList2.contains(localTask)) || (!this.taskQueue.remove(localTask))) {
        break;
      }
      i = 1;
      break;
      paramList2 = (Task)paramList1.next();
      if (this.taskQueue.contains(paramList2)) {
        break label31;
      }
      this.taskQueue.addLast(paramList2);
      i = 1;
      break label31;
      if (!((Task)paramList1.next()).isDone()) {
        break label48;
      }
      paramList1.remove();
      i = 1;
      break label48;
    }
  }
  
  public boolean getAutoUpdateForegroundTask()
  {
    return this.autoUpdateForegroundTask;
  }
  
  public Task getForegroundTask()
  {
    return this.foregroundTask;
  }
  
  public List<Task> getTasks()
  {
    return copyTaskQueue();
  }
  
  public void setAutoUpdateForegroundTask(boolean paramBoolean)
  {
    boolean bool = this.autoUpdateForegroundTask;
    this.autoUpdateForegroundTask = paramBoolean;
    firePropertyChange("autoUpdateForegroundTask", Boolean.valueOf(bool), Boolean.valueOf(this.autoUpdateForegroundTask));
  }
  
  public void setForegroundTask(Task paramTask)
  {
    Task localTask = this.foregroundTask;
    if (localTask != null) {
      localTask.removePropertyChangeListener(this.taskPCL);
    }
    this.foregroundTask = paramTask;
    paramTask = this.foregroundTask;
    if (paramTask != null) {
      paramTask.addPropertyChangeListener(this.taskPCL);
    }
    firePropertyChange("foregroundTask", localTask, paramTask);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qplus.task.TaskMonitor
 * JD-Core Version:    0.7.0.1
 */