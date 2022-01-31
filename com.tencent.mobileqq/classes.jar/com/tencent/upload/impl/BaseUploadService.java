package com.tencent.upload.impl;

import com.tencent.upload.common.UploadGlobalConfig;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.IUploadEnv;
import com.tencent.upload.utils.Const.FileType;
import com.tencent.upload.utils.pool.ThreadPool;

public abstract class BaseUploadService
{
  UploadTaskManager mTaskManager;
  ThreadPool mThreadPool;
  
  public BaseUploadService(ThreadPool paramThreadPool)
  {
    this.mThreadPool = paramThreadPool;
  }
  
  public static int getBatchControlNumber()
  {
    return UploadGlobalConfig.getUploadEnv().getBatchControlCount();
  }
  
  public static int getFileSocketNumber()
  {
    return Math.max(1, UploadGlobalConfig.getUploadEnv().getSocketCount());
  }
  
  public static int getMaxSessionNum()
  {
    return getParallelFileNumber() * getFileSocketNumber();
  }
  
  public static int getParallelFileNumber()
  {
    return UploadGlobalConfig.getUploadEnv().getFileConcurrentCount();
  }
  
  abstract boolean cancel(AbstractUploadTask paramAbstractUploadTask);
  
  abstract void cancelAllTasks();
  
  abstract void close();
  
  abstract boolean isUploadIdle();
  
  protected void prepare(Const.FileType paramFileType)
  {
    this.mTaskManager.prepare(paramFileType);
  }
  
  protected void reset()
  {
    this.mTaskManager.reset();
  }
  
  abstract boolean upload(AbstractUploadTask paramAbstractUploadTask);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.upload.impl.BaseUploadService
 * JD-Core Version:    0.7.0.1
 */