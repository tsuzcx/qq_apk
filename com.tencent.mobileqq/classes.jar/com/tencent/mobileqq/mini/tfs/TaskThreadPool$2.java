package com.tencent.mobileqq.mini.tfs;

import com.tencent.qphone.base.util.QLog;
import java.util.Queue;
import java.util.concurrent.ThreadPoolExecutor;

class TaskThreadPool$2
  implements Runnable
{
  TaskThreadPool$2(TaskThreadPool paramTaskThreadPool) {}
  
  public void run()
  {
    try
    {
      if (TaskThreadPool.access$100(this.this$0)) {
        TaskThreadPool.access$200(this.this$0).execute((Runnable)TaskThreadPool.access$000(this.this$0).poll());
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ThreadPool", 1, "", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.tfs.TaskThreadPool.2
 * JD-Core Version:    0.7.0.1
 */