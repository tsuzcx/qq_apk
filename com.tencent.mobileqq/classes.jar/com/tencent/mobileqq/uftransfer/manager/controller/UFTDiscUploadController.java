package com.tencent.mobileqq.uftransfer.manager.controller;

import android.os.Bundle;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.uftransfer.api.IUFTUploadCallback;
import com.tencent.mobileqq.uftransfer.api.UFTDiscUploadInfo;
import com.tencent.mobileqq.uftransfer.api.UFTTransferConfig;
import com.tencent.mobileqq.uftransfer.api.impl.UFTTransferKey;
import com.tencent.mobileqq.uftransfer.depend.UFTLog;
import com.tencent.mobileqq.uftransfer.task.taskinfo.UFTDiscUploadTaskInfo;
import com.tencent.mobileqq.uftransfer.task.upload.UFTDiscReportData;
import com.tencent.mobileqq.uftransfer.task.upload.UFTDiscUploadTask;
import com.tencent.mobileqq.uftransfer.task.upload.UFTUploadCbWrapper;
import com.tencent.mobileqq.uftransfer.task.upload.UFTUploadCompleteInfo;
import com.tencent.mobileqq.uftransfer.taskqueue.UFTUploadTaskQueue;
import com.tencent.mobileqq.uftransfer.utility.UFTTransferUtility;
import mqq.app.AppRuntime;

public class UFTDiscUploadController
  implements INetInfoHandler
{
  private final UFTUploadTaskQueue jdField_a_of_type_ComTencentMobileqqUftransferTaskqueueUFTUploadTaskQueue;
  private final AppRuntime jdField_a_of_type_MqqAppAppRuntime;
  
  public UFTDiscUploadController(AppRuntime paramAppRuntime, int paramInt)
  {
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
    this.jdField_a_of_type_ComTencentMobileqqUftransferTaskqueueUFTUploadTaskQueue = new UFTUploadTaskQueue(paramInt);
  }
  
  public void a()
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("REASON", 3);
    this.jdField_a_of_type_ComTencentMobileqqUftransferTaskqueueUFTUploadTaskQueue.a(localBundle);
  }
  
  public void a(UFTTransferKey paramUFTTransferKey, Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentMobileqqUftransferTaskqueueUFTUploadTaskQueue.a(paramUFTTransferKey.a(), paramBundle);
  }
  
  public void a(UFTTransferKey paramUFTTransferKey, UFTDiscUploadInfo paramUFTDiscUploadInfo, UFTTransferConfig paramUFTTransferConfig, IUFTUploadCallback paramIUFTUploadCallback)
  {
    if (paramUFTDiscUploadInfo == null)
    {
      paramUFTDiscUploadInfo = new StringBuilder();
      paramUFTDiscUploadInfo.append("[");
      paramUFTDiscUploadInfo.append(paramUFTTransferKey.a());
      paramUFTDiscUploadInfo.append("] upload disc file, upload info is null");
      UFTLog.d("[UFTTransfer] UFTDiscUploadController", 1, paramUFTDiscUploadInfo.toString());
      new UFTUploadCbWrapper(new UFTDiscUploadController.1(this), paramIUFTUploadCallback).a(paramUFTTransferKey, 9005, new UFTUploadCompleteInfo());
      return;
    }
    UFTTransferConfig localUFTTransferConfig = paramUFTTransferConfig;
    if (paramUFTTransferConfig == null) {
      localUFTTransferConfig = new UFTTransferConfig(true);
    }
    paramUFTTransferConfig = new StringBuilder();
    paramUFTTransferConfig.append("[");
    paramUFTTransferConfig.append(paramUFTTransferKey.a());
    paramUFTTransferConfig.append("] upload disc file, uploadinfo:");
    paramUFTTransferConfig.append(paramUFTDiscUploadInfo.toString());
    paramUFTTransferConfig.append(" config:");
    paramUFTTransferConfig.append(localUFTTransferConfig.toString());
    UFTLog.b("[UFTTransfer] UFTDiscUploadController", 1, paramUFTTransferConfig.toString());
    paramUFTTransferConfig = this.jdField_a_of_type_MqqAppAppRuntime;
    paramUFTTransferConfig = new UFTDiscReportData(paramUFTTransferConfig, paramUFTTransferConfig.getCurrentUin());
    paramUFTTransferConfig.jdField_b_of_type_JavaLangString = "";
    paramUFTTransferConfig.c = paramUFTDiscUploadInfo.b();
    paramUFTTransferConfig.jdField_a_of_type_Int = 3000;
    paramUFTTransferConfig.jdField_d_of_type_JavaLangString = "";
    paramUFTTransferConfig.j = UFTTransferUtility.a(paramUFTDiscUploadInfo.a());
    paramUFTTransferConfig.jdField_b_of_type_Int = 0;
    paramUFTTransferConfig.jdField_b_of_type_Long = paramUFTTransferKey.a();
    paramUFTTransferConfig.jdField_d_of_type_Long = 0L;
    paramUFTTransferConfig.jdField_d_of_type_Long = 0L;
    paramUFTTransferConfig.jdField_e_of_type_Long = 0L;
    paramUFTTransferConfig.f = 0L;
    paramUFTTransferConfig.h = 0L;
    paramUFTTransferConfig.jdField_e_of_type_JavaLangString = "";
    paramUFTDiscUploadInfo = UFTDiscUploadTaskInfo.a(paramUFTTransferKey.a(), paramUFTTransferKey.a(), paramUFTDiscUploadInfo, localUFTTransferConfig);
    if (paramUFTDiscUploadInfo == null)
    {
      paramUFTDiscUploadInfo = new StringBuilder();
      paramUFTDiscUploadInfo.append("[");
      paramUFTDiscUploadInfo.append(paramUFTTransferKey.a());
      paramUFTDiscUploadInfo.append("] upload disc file, create task info fail");
      UFTLog.d("[UFTTransfer] UFTDiscUploadController", 1, paramUFTDiscUploadInfo.toString());
      paramUFTTransferConfig.jdField_a_of_type_Long = 9005L;
      paramUFTTransferConfig.jdField_a_of_type_JavaLangString = "create task info fail";
      paramUFTTransferConfig.b();
      new UFTUploadCbWrapper(new UFTDiscUploadController.2(this), paramIUFTUploadCallback).a(paramUFTTransferKey, 9005, new UFTUploadCompleteInfo());
      return;
    }
    paramUFTDiscUploadInfo = UFTDiscUploadTask.a(this.jdField_a_of_type_MqqAppAppRuntime, paramUFTTransferKey, paramUFTDiscUploadInfo, this.jdField_a_of_type_ComTencentMobileqqUftransferTaskqueueUFTUploadTaskQueue, paramIUFTUploadCallback);
    if (paramUFTDiscUploadInfo == null)
    {
      paramUFTDiscUploadInfo = new StringBuilder();
      paramUFTDiscUploadInfo.append("[");
      paramUFTDiscUploadInfo.append(paramUFTTransferKey.a());
      paramUFTDiscUploadInfo.append("] upload disc file, create task fail");
      UFTLog.d("[UFTTransfer] UFTDiscUploadController", 1, paramUFTDiscUploadInfo.toString());
      paramUFTTransferConfig.jdField_a_of_type_Long = 9005L;
      paramUFTTransferConfig.jdField_a_of_type_JavaLangString = "create upload task fail";
      paramUFTTransferConfig.b();
      new UFTUploadCbWrapper(new UFTDiscUploadController.3(this), paramIUFTUploadCallback).a(paramUFTTransferKey, 9005, new UFTUploadCompleteInfo());
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqUftransferTaskqueueUFTUploadTaskQueue.a(paramUFTDiscUploadInfo);
  }
  
  public void onNetMobile2None()
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("REASON", 2);
    this.jdField_a_of_type_ComTencentMobileqqUftransferTaskqueueUFTUploadTaskQueue.a(localBundle);
  }
  
  public void onNetMobile2Wifi(String paramString) {}
  
  public void onNetNone2Mobile(String paramString)
  {
    paramString = new Bundle();
    paramString.putInt("REASON", 1);
    this.jdField_a_of_type_ComTencentMobileqqUftransferTaskqueueUFTUploadTaskQueue.a(paramString);
  }
  
  public void onNetNone2Wifi(String paramString) {}
  
  public void onNetWifi2Mobile(String paramString)
  {
    paramString = new Bundle();
    paramString.putInt("REASON", 1);
    this.jdField_a_of_type_ComTencentMobileqqUftransferTaskqueueUFTUploadTaskQueue.a(paramString);
  }
  
  public void onNetWifi2None()
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("REASON", 2);
    this.jdField_a_of_type_ComTencentMobileqqUftransferTaskqueueUFTUploadTaskQueue.a(localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.manager.controller.UFTDiscUploadController
 * JD-Core Version:    0.7.0.1
 */