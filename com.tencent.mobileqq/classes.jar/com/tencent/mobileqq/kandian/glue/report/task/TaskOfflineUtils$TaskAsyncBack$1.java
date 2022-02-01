package com.tencent.mobileqq.kandian.glue.report.task;

import com.tencent.qphone.base.util.QLog;

class TaskOfflineUtils$TaskAsyncBack$1
  implements Runnable
{
  TaskOfflineUtils$TaskAsyncBack$1(TaskOfflineUtils.TaskAsyncBack paramTaskAsyncBack, String paramString, int paramInt) {}
  
  public void run()
  {
    Object localObject1 = TaskOfflineUtils.a();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("loaded: bid : ");
    ((StringBuilder)localObject2).append(TaskOfflineUtils.TaskAsyncBack.a(this.this$0));
    ((StringBuilder)localObject2).append(" param ");
    ((StringBuilder)localObject2).append(this.jdField_a_of_type_JavaLangString);
    ((StringBuilder)localObject2).append(" code : ");
    ((StringBuilder)localObject2).append(this.jdField_a_of_type_Int);
    QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    int m = this.jdField_a_of_type_Int;
    int j = -1;
    int i = m;
    int k = j;
    if (m == 0)
    {
      k = j;
      i = j;
      try
      {
        if (this.jdField_a_of_type_JavaLangString == null)
        {
          k = j;
          localObject1 = TaskOfflineUtils.a(TaskOfflineUtils.TaskAsyncBack.a(this.this$0), TaskOfflineUtils.TaskAsyncBack.a(this.this$0));
          k = j;
          j = ((TaskOfflineUtils.ConfigData)localObject1).jdField_a_of_type_Int;
          k = j;
          boolean bool = ((TaskOfflineUtils.ConfigData)localObject1).jdField_a_of_type_Boolean;
          i = j;
          if (bool)
          {
            i = 0;
            k = j;
          }
        }
      }
      catch (Exception localException)
      {
        localObject2 = TaskOfflineUtils.a();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("loaded: bid : ");
        localStringBuilder.append(TaskOfflineUtils.TaskAsyncBack.a(this.this$0));
        QLog.d((String)localObject2, 1, localStringBuilder.toString(), localException);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("loaded: bid : ");
        ((StringBuilder)localObject2).append(TaskOfflineUtils.TaskAsyncBack.a(this.this$0));
        ((StringBuilder)localObject2).append(" ");
        ((StringBuilder)localObject2).append(localException.getMessage());
        TaskException.b(((StringBuilder)localObject2).toString());
        i = k;
        j = 4;
        k = i;
        i = j;
      }
    }
    if (TaskOfflineUtils.TaskAsyncBack.a(this.this$0) != null) {
      TaskOfflineUtils.TaskAsyncBack.a(this.this$0).a(i, k);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.report.task.TaskOfflineUtils.TaskAsyncBack.1
 * JD-Core Version:    0.7.0.1
 */