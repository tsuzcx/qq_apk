package com.tencent.mobileqq.winkpublish.api.impl;

import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import com.tencent.mobileqq.winkpublish.IPublishQueueListener;
import com.tencent.mobileqq.winkpublish.IQueueTask;
import com.tencent.mobileqq.winkpublish.api.IUploadLocalConfig;
import com.tencent.mobileqq.winkpublish.api.IUploadTaskManager;
import com.tencent.mobileqq.winkpublish.common.AUploadCommonSetting;
import com.tencent.mobileqq.winkpublish.common.config.QCircleUploadLocalConfig;
import com.tencent.mobileqq.winkpublish.common.config.QFSUploadLocalConfig;
import com.tencent.mobileqq.winkpublish.queue.AUploadTaskQueue;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.IUploadService;
import com.tencent.upload.uinterface.UploadServiceBuilder;
import java.util.concurrent.CopyOnWriteArrayList;

public class UploadTaskManagerImpl
  implements IUploadTaskManager
{
  private static final String TAG = "[PublishUpload]UploadTaskManagerImpl";
  
  public void addPublishQueueListener(IPublishQueueListener paramIPublishQueueListener)
  {
    AUploadTaskQueue.a().a(paramIPublishQueueListener);
  }
  
  public void completeTask(IQueueTask paramIQueueTask, boolean paramBoolean)
  {
    AUploadTaskQueue.a().a(paramIQueueTask, paramBoolean);
  }
  
  public CopyOnWriteArrayList<IQueueTask> getTaskList()
  {
    return AUploadTaskQueue.a().e();
  }
  
  public boolean hasRunningTask()
  {
    return AUploadTaskQueue.a().d();
  }
  
  public void initConfig(IUploadLocalConfig paramIUploadLocalConfig)
  {
    AUploadCommonSetting.a(paramIUploadLocalConfig);
  }
  
  public void initQCConfig()
  {
    AUploadCommonSetting.a(new QCircleUploadLocalConfig());
  }
  
  public void initQFSConfig()
  {
    AUploadCommonSetting.a(new QFSUploadLocalConfig());
  }
  
  public void initUpload()
  {
    RFThreadManager.execute(new UploadTaskManagerImpl.1(this), RFThreadManager.Normal);
  }
  
  public void pauseTask(IQueueTask paramIQueueTask)
  {
    AUploadTaskQueue.a().d(paramIQueueTask);
  }
  
  public void removeTask(IQueueTask paramIQueueTask)
  {
    AUploadTaskQueue.a().c(paramIQueueTask);
  }
  
  public void restore()
  {
    AUploadTaskQueue.a().b();
  }
  
  public void restoreAndResumeTask(String paramString)
  {
    AUploadTaskQueue.a().a(paramString);
  }
  
  public void resumeTask(IQueueTask paramIQueueTask)
  {
    AUploadTaskQueue.a().e(paramIQueueTask);
  }
  
  public boolean upload(AbstractUploadTask paramAbstractUploadTask)
  {
    return UploadServiceBuilder.getInstance().upload(paramAbstractUploadTask);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.api.impl.UploadTaskManagerImpl
 * JD-Core Version:    0.7.0.1
 */