package com.tencent.qqmini.sdk.task;

import bffi;
import bffl;

public class TaskFlowEngine$1
  implements Runnable
{
  public TaskFlowEngine$1(bffl parambffl) {}
  
  public void run()
  {
    bffi[] arrayOfbffi = bffl.access$000(this.this$0);
    int j = arrayOfbffi.length;
    int i = 0;
    while (i < j)
    {
      bffi localbffi = arrayOfbffi[i];
      bffl.access$100(this.this$0, localbffi);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.task.TaskFlowEngine.1
 * JD-Core Version:    0.7.0.1
 */