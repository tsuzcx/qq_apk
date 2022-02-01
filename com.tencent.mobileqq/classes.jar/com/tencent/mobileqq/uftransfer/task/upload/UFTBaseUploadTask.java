package com.tencent.mobileqq.uftransfer.task.upload;

import com.tencent.mobileqq.uftransfer.api.IUFTUploadCallback;
import com.tencent.mobileqq.uftransfer.api.impl.UFTTransferKey;
import com.tencent.mobileqq.uftransfer.task.IUFTTaskCallback;
import com.tencent.mobileqq.uftransfer.task.UFTBaseTask;
import com.tencent.mobileqq.uftransfer.task.taskinfo.UFTBaseTaskInfo;
import com.tencent.mobileqq.uftransfer.task.taskinfo.UFTUploadTaskRunNotesInfo;
import mqq.app.AppRuntime;

public abstract class UFTBaseUploadTask
  extends UFTBaseTask
  implements UFTUploadCbWrapper.IWrapperHost
{
  protected final UFTUploadTaskRunNotesInfo j = new UFTUploadTaskRunNotesInfo();
  protected final UFTUploadCbWrapper k;
  
  protected UFTBaseUploadTask(AppRuntime paramAppRuntime, UFTTransferKey paramUFTTransferKey, UFTBaseTaskInfo paramUFTBaseTaskInfo, IUFTTaskCallback paramIUFTTaskCallback, IUFTUploadCallback paramIUFTUploadCallback)
  {
    super(paramAppRuntime, paramUFTTransferKey, paramUFTBaseTaskInfo, paramIUFTTaskCallback);
    this.k = new UFTUploadCbWrapper(this, paramIUFTUploadCallback);
  }
  
  public boolean a()
  {
    return this.i;
  }
  
  public boolean a(UFTBaseTask paramUFTBaseTask)
  {
    if (paramUFTBaseTask != null)
    {
      if (!(paramUFTBaseTask instanceof UFTBaseUploadTask)) {
        return false;
      }
      paramUFTBaseTask = (UFTBaseUploadTask)paramUFTBaseTask;
      if ((i() != null) && (i().equals(paramUFTBaseTask.i()))) {
        return true;
      }
    }
    return false;
  }
  
  public abstract String i();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.task.upload.UFTBaseUploadTask
 * JD-Core Version:    0.7.0.1
 */