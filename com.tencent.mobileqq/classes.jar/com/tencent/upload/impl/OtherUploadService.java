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
    UploadLog.w("OtherUploadService", "cancel AbstractUploadTask flowId: " + paramAbstractUploadTask.flowId);
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
    UploadLog.w("OtherUploadService", "upload task flowId: " + paramAbstractUploadTask.flowId + " type:" + paramAbstractUploadTask.getClass().getSimpleName());
    this.mTaskManager.sendAsync(paramAbstractUploadTask);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.upload.impl.OtherUploadService
 * JD-Core Version:    0.7.0.1
 */