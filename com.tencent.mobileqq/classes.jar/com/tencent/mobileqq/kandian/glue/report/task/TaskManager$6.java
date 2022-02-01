package com.tencent.mobileqq.kandian.glue.report.task;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

class TaskManager$6
  implements Runnable
{
  TaskManager$6(TaskManager paramTaskManager, String paramString) {}
  
  public void run()
  {
    int i;
    label745:
    synchronized (this.this$0)
    {
      if (TaskManager.c(this.this$0).size() == 0) {
        return;
      }
      Iterator localIterator = TaskManager.c(this.this$0).iterator();
      while (localIterator.hasNext())
      {
        Task localTask = (Task)localIterator.next();
        Object localObject2;
        if (localTask.i == Task.e)
        {
          localObject2 = localTask.p.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            Object localObject3 = (Task.ConfigItem)((Iterator)localObject2).next();
            if ((!TextUtils.isEmpty(((Task.ConfigItem)localObject3).b)) && (!TextUtils.isEmpty(this.a)))
            {
              boolean bool = this.a.contains(((Task.ConfigItem)localObject3).b);
              if (bool) {
                try
                {
                  localObject3 = TaskManager.a(this.this$0, localTask.p, ((Task.ConfigItem)localObject3).b);
                  if ((localObject3 != null) && (((ArrayList)localObject3).size() > 0))
                  {
                    localObject3 = TaskManager.a(this.this$0, localTask.q, (ArrayList)localObject3);
                    if ((localObject3 != null) && (localObject3.length > 0))
                    {
                      int j = localObject3.length;
                      i = 0;
                      if (i < j)
                      {
                        localObject4 = localObject3[i];
                        localObject5 = TaskManager.b(this.this$0, localTask.q, (String)localObject4);
                        StringBuilder localStringBuilder = new StringBuilder();
                        localStringBuilder.append((String)localObject4);
                        localStringBuilder.append("('");
                        localStringBuilder.append(this.a);
                        localStringBuilder.append("',");
                        localStringBuilder.append(TaskManager.a(this.this$0, (ArrayList)localObject5));
                        localStringBuilder.append(")");
                        localObject5 = localStringBuilder.toString();
                        if (localTask.a == null) {
                          break label745;
                        }
                        localObject4 = new StringBuffer();
                        localObject5 = ((String)localObject5).replaceAll("\"", "\\\\\"");
                        localTask.a.a((String)localObject5, (StringBuffer)localObject4);
                        if (TextUtils.isEmpty((CharSequence)localObject4)) {
                          break label745;
                        }
                        this.this$0.a(localTask);
                        localObject3 = new StringBuilder();
                        ((StringBuilder)localObject3).append("evaluate js exception: ");
                        ((StringBuilder)localObject3).append((String)localObject5);
                        ((StringBuilder)localObject3).append(" ");
                        ((StringBuilder)localObject3).append(localObject4);
                        QLog.d("kandianreport.taskmanager", 1, ((StringBuilder)localObject3).toString());
                        localObject3 = localTask.b;
                        localStringBuilder = new StringBuilder();
                        localStringBuilder.append("evaluate js exception: ");
                        localStringBuilder.append((String)localObject5);
                        localStringBuilder.append(" ");
                        localStringBuilder.append(localObject4);
                        TaskException.a((String)localObject3, localStringBuilder.toString());
                        return;
                      }
                    }
                  }
                }
                catch (Error localError)
                {
                  this.this$0.a(localTask);
                  localObject4 = new StringBuilder();
                  ((StringBuilder)localObject4).append("accept unexpected error: ");
                  ((StringBuilder)localObject4).append(localError.getMessage());
                  QLog.d("kandianreport.taskmanager", 1, ((StringBuilder)localObject4).toString());
                  localObject4 = localTask.b;
                  localObject5 = new StringBuilder();
                  ((StringBuilder)localObject5).append("accept unexpected error: ");
                  ((StringBuilder)localObject5).append(localError.getMessage());
                  TaskException.a((String)localObject4, ((StringBuilder)localObject5).toString());
                }
                catch (Exception localException)
                {
                  this.this$0.a(localTask);
                  Object localObject4 = new StringBuilder();
                  ((StringBuilder)localObject4).append("accept unexpected exception: ");
                  ((StringBuilder)localObject4).append(localException.getMessage());
                  QLog.d("kandianreport.taskmanager", 1, ((StringBuilder)localObject4).toString());
                  localObject4 = localTask.b;
                  Object localObject5 = new StringBuilder();
                  ((StringBuilder)localObject5).append("accept unexpected exception: ");
                  ((StringBuilder)localObject5).append(localException.getMessage());
                  TaskException.a((String)localObject4, ((StringBuilder)localObject5).toString());
                }
              }
            }
          }
        }
        else
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(localTask.b);
          ((StringBuilder)localObject2).append(" not accept status is ");
          ((StringBuilder)localObject2).append(localTask.i);
          QLog.d("kandianreport.taskmanager", 2, ((StringBuilder)localObject2).toString());
        }
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.report.task.TaskManager.6
 * JD-Core Version:    0.7.0.1
 */