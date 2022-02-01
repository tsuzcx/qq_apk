package com.tencent.mobileqq.kandian.glue.report.task;

import java.util.TimerTask;

class TaskManager$28$1
  extends TimerTask
{
  public void run()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    JSContext localJSContext = this.a;
    if (localJSContext != null)
    {
      localJSContext.a(this.b, localStringBuffer);
      TaskManager.a(this.c.b, localStringBuffer, this.c.a, this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.report.task.TaskManager.28.1
 * JD-Core Version:    0.7.0.1
 */