package com.tencent.qqmini.sdk.task;

import bhhn;
import bhhq;

public class TaskFlowEngine$1
  implements Runnable
{
  public TaskFlowEngine$1(bhhq parambhhq) {}
  
  public void run()
  {
    bhhn[] arrayOfbhhn = bhhq.access$000(this.this$0);
    int j = arrayOfbhhn.length;
    int i = 0;
    while (i < j)
    {
      bhhn localbhhn = arrayOfbhhn[i];
      this.this$0.executeTask(localbhhn);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.task.TaskFlowEngine.1
 * JD-Core Version:    0.7.0.1
 */