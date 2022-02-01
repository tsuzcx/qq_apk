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
  protected final UFTUploadTaskRunNotesInfo a;
  protected final UFTUploadCbWrapper a;
  
  protected UFTBaseUploadTask(AppRuntime paramAppRuntime, UFTTransferKey paramUFTTransferKey, UFTBaseTaskInfo paramUFTBaseTaskInfo, IUFTTaskCallback paramIUFTTaskCallback, IUFTUploadCallback paramIUFTUploadCallback)
  {
    super(paramAppRuntime, paramUFTTransferKey, paramUFTBaseTaskInfo, paramIUFTTaskCallback);
    this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo = new UFTUploadTaskRunNotesInfo();
    this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTUploadCbWrapper = new UFTUploadCbWrapper(this, paramIUFTUploadCallback);
  }
  
  public abstract String a();
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(UFTBaseTask paramUFTBaseTask)
  {
    if (paramUFTBaseTask != null)
    {
      if (!(paramUFTBaseTask instanceof UFTBaseUploadTask)) {
        return false;
      }
      paramUFTBaseTask = (UFTBaseUploadTask)paramUFTBaseTask;
      if ((a() != null) && (a().equals(paramUFTBaseTask.a()))) {
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.task.upload.UFTBaseUploadTask
 * JD-Core Version:    0.7.0.1
 */