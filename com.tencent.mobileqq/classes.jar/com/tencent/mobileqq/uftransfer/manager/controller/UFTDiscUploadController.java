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
  private final AppRuntime a;
  private final UFTUploadTaskQueue b;
  
  public UFTDiscUploadController(AppRuntime paramAppRuntime, int paramInt)
  {
    this.a = paramAppRuntime;
    this.b = new UFTUploadTaskQueue(paramInt);
  }
  
  public void a()
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("REASON", 3);
    this.b.a(localBundle);
  }
  
  public void a(UFTTransferKey paramUFTTransferKey, Bundle paramBundle)
  {
    this.b.a(paramUFTTransferKey.b(), paramBundle);
  }
  
  public void a(UFTTransferKey paramUFTTransferKey, UFTDiscUploadInfo paramUFTDiscUploadInfo, UFTTransferConfig paramUFTTransferConfig, IUFTUploadCallback paramIUFTUploadCallback)
  {
    if (paramUFTDiscUploadInfo == null)
    {
      paramUFTDiscUploadInfo = new StringBuilder();
      paramUFTDiscUploadInfo.append("[");
      paramUFTDiscUploadInfo.append(paramUFTTransferKey.b());
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
    paramUFTTransferConfig.append(paramUFTTransferKey.b());
    paramUFTTransferConfig.append("] upload disc file, uploadinfo:");
    paramUFTTransferConfig.append(paramUFTDiscUploadInfo.toString());
    paramUFTTransferConfig.append(" config:");
    paramUFTTransferConfig.append(localUFTTransferConfig.toString());
    UFTLog.b("[UFTTransfer] UFTDiscUploadController", 1, paramUFTTransferConfig.toString());
    paramUFTTransferConfig = this.a;
    paramUFTTransferConfig = new UFTDiscReportData(paramUFTTransferConfig, paramUFTTransferConfig.getCurrentUin());
    paramUFTTransferConfig.i = "";
    paramUFTTransferConfig.j = paramUFTDiscUploadInfo.b();
    paramUFTTransferConfig.k = 3000;
    paramUFTTransferConfig.l = "";
    paramUFTTransferConfig.o = UFTTransferUtility.a(paramUFTDiscUploadInfo.a());
    paramUFTTransferConfig.p = 0;
    paramUFTTransferConfig.c = paramUFTTransferKey.b();
    paramUFTTransferConfig.e = 0L;
    paramUFTTransferConfig.e = 0L;
    paramUFTTransferConfig.f = 0L;
    paramUFTTransferConfig.g = 0L;
    paramUFTTransferConfig.m = 0L;
    paramUFTTransferConfig.q = "";
    paramUFTDiscUploadInfo = UFTDiscUploadTaskInfo.a(paramUFTTransferKey.b(), paramUFTTransferKey.c(), paramUFTDiscUploadInfo, localUFTTransferConfig);
    if (paramUFTDiscUploadInfo == null)
    {
      paramUFTDiscUploadInfo = new StringBuilder();
      paramUFTDiscUploadInfo.append("[");
      paramUFTDiscUploadInfo.append(paramUFTTransferKey.b());
      paramUFTDiscUploadInfo.append("] upload disc file, create task info fail");
      UFTLog.d("[UFTTransfer] UFTDiscUploadController", 1, paramUFTDiscUploadInfo.toString());
      paramUFTTransferConfig.a = 9005L;
      paramUFTTransferConfig.b = "create task info fail";
      paramUFTTransferConfig.b();
      new UFTUploadCbWrapper(new UFTDiscUploadController.2(this), paramIUFTUploadCallback).a(paramUFTTransferKey, 9005, new UFTUploadCompleteInfo());
      return;
    }
    paramUFTDiscUploadInfo = UFTDiscUploadTask.a(this.a, paramUFTTransferKey, paramUFTDiscUploadInfo, this.b, paramIUFTUploadCallback);
    if (paramUFTDiscUploadInfo == null)
    {
      paramUFTDiscUploadInfo = new StringBuilder();
      paramUFTDiscUploadInfo.append("[");
      paramUFTDiscUploadInfo.append(paramUFTTransferKey.b());
      paramUFTDiscUploadInfo.append("] upload disc file, create task fail");
      UFTLog.d("[UFTTransfer] UFTDiscUploadController", 1, paramUFTDiscUploadInfo.toString());
      paramUFTTransferConfig.a = 9005L;
      paramUFTTransferConfig.b = "create upload task fail";
      paramUFTTransferConfig.b();
      new UFTUploadCbWrapper(new UFTDiscUploadController.3(this), paramIUFTUploadCallback).a(paramUFTTransferKey, 9005, new UFTUploadCompleteInfo());
      return;
    }
    this.b.a(paramUFTDiscUploadInfo);
  }
  
  public void onNetMobile2None()
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("REASON", 2);
    this.b.a(localBundle);
  }
  
  public void onNetMobile2Wifi(String paramString) {}
  
  public void onNetNone2Mobile(String paramString)
  {
    paramString = new Bundle();
    paramString.putInt("REASON", 1);
    this.b.a(paramString);
  }
  
  public void onNetNone2Wifi(String paramString) {}
  
  public void onNetWifi2Mobile(String paramString)
  {
    paramString = new Bundle();
    paramString.putInt("REASON", 1);
    this.b.a(paramString);
  }
  
  public void onNetWifi2None()
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("REASON", 2);
    this.b.a(localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.manager.controller.UFTDiscUploadController
 * JD-Core Version:    0.7.0.1
 */