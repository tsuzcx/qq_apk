package com.tencent.mobileqq.winkpublish.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.winkpublish.IPublishQueueListener;
import com.tencent.mobileqq.winkpublish.IQueueTask;
import com.tencent.upload.uinterface.AbstractUploadTask;
import java.util.concurrent.CopyOnWriteArrayList;

@QAPI(process={"all"})
public abstract interface IUploadTaskManager
  extends QRouteApi
{
  public abstract void addPublishQueueListener(IPublishQueueListener paramIPublishQueueListener);
  
  public abstract void completeTask(IQueueTask paramIQueueTask, boolean paramBoolean);
  
  public abstract CopyOnWriteArrayList<IQueueTask> getTaskList();
  
  public abstract boolean hasRunningTask();
  
  public abstract void initConfig(IUploadLocalConfig paramIUploadLocalConfig);
  
  public abstract void initQCConfig();
  
  public abstract void initQFSConfig();
  
  public abstract void initUpload();
  
  public abstract void pauseTask(IQueueTask paramIQueueTask);
  
  public abstract void removeTask(IQueueTask paramIQueueTask);
  
  public abstract void restore();
  
  public abstract void restoreAndResumeTask(String paramString);
  
  public abstract void resumeTask(IQueueTask paramIQueueTask);
  
  public abstract boolean upload(AbstractUploadTask paramAbstractUploadTask);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.api.IUploadTaskManager
 * JD-Core Version:    0.7.0.1
 */