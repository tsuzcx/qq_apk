package com.tencent.qqmini.sdk.task;

import bhlu;
import bhlx;

public class TaskFlowEngine$1
  implements Runnable
{
  public TaskFlowEngine$1(bhlx parambhlx) {}
  
  public void run()
  {
    bhlu[] arrayOfbhlu = bhlx.access$000(this.this$0);
    int j = arrayOfbhlu.length;
    int i = 0;
    while (i < j)
    {
      bhlu localbhlu = arrayOfbhlu[i];
      this.this$0.executeTask(localbhlu);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.task.TaskFlowEngine.1
 * JD-Core Version:    0.7.0.1
 */