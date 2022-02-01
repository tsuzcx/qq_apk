package com.tencent.mobileqq.uftransfer.taskqueue;

import com.tencent.mobileqq.uftransfer.depend.UFTLog;
import com.tencent.mobileqq.uftransfer.task.UFTBaseTask;
import com.tencent.mobileqq.uftransfer.task.upload.UFTBaseUploadTask;

public class UFTUploadTaskQueue
  extends UFTTaskQueue
{
  public UFTUploadTaskQueue(int paramInt)
  {
    super(paramInt);
    UFTUploadTaskQueueHelper.a().addObserver(new UFTUploadTaskQueue.1(this));
  }
  
  public void a(UFTBaseTask paramUFTBaseTask)
  {
    if ((paramUFTBaseTask instanceof UFTBaseUploadTask))
    {
      super.a(paramUFTBaseTask);
      return;
    }
    UFTLog.d("[UFTTransfer] UFTUploadTaskQueue", 1, "add task fail. task must is subclass of UFTBaseUploadTask");
  }
  
  protected boolean b(UFTBaseTask paramUFTBaseTask)
  {
    paramUFTBaseTask = (UFTBaseUploadTask)paramUFTBaseTask;
    return UFTUploadTaskQueueHelper.a().b(paramUFTBaseTask.i()) ^ true;
  }
  
  protected void c(UFTBaseTask paramUFTBaseTask)
  {
    paramUFTBaseTask = (UFTBaseUploadTask)paramUFTBaseTask;
    UFTUploadTaskQueueHelper.a().a(paramUFTBaseTask.i());
  }
  
  protected void d(UFTBaseTask paramUFTBaseTask)
  {
    paramUFTBaseTask = (UFTBaseUploadTask)paramUFTBaseTask;
    UFTUploadTaskQueueHelper.a().a(paramUFTBaseTask.i(), b());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.taskqueue.UFTUploadTaskQueue
 * JD-Core Version:    0.7.0.1
 */