package com.tencent.upload.impl;

import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.utils.UploadLog;
import com.tencent.upload.utils.pool.ThreadPool;

public class OtherUploadService
  extends BaseUploadService
{
  private static final String TAG = "OtherUploadService";
  
  public OtherUploadService(ThreadPool paramThreadPool)
  {
    super(paramThreadPool);
    this.mTaskManager = new UploadTaskManager(paramThreadPool, 1);
  }
  
  protected boolean cancel(AbstractUploadTask paramAbstractUploadTask)
  {
    if (paramAbstractUploadTask == null) {
      return false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("cancel AbstractUploadTask flowId: ");
    localStringBuilder.append(paramAbstractUploadTask.flowId);
    UploadLog.w("OtherUploadService", localStringBuilder.toString());
    this.mTaskManager.cancelTask(paramAbstractUploadTask);
    return true;
  }
  
  protected void cancelAllTasks()
  {
    this.mTaskManager.cancelAllTasks();
  }
  
  protected void close()
  {
    this.mTaskManager.close();
  }
  
  protected boolean isUploadIdle()
  {
    return this.mTaskManager.getRemainTaskSize() == 0;
  }
  
  protected boolean upload(AbstractUploadTask paramAbstractUploadTask)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("upload task flowId: ");
    localStringBuilder.append(paramAbstractUploadTask.flowId);
    localStringBuilder.append(" type:");
    localStringBuilder.append(paramAbstractUploadTask.getClass().getSimpleName());
    UploadLog.w("OtherUploadService", localStringBuilder.toString());
    this.mTaskManager.sendAsync(paramAbstractUploadTask);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.upload.impl.OtherUploadService
 * JD-Core Version:    0.7.0.1
 */