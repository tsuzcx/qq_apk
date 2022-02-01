package com.tencent.mobileqq.uftransfer.guild;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.uftransfer.api.IUFTUploadCallback;
import com.tencent.mobileqq.uftransfer.api.UFTTransferConfig;
import com.tencent.mobileqq.uftransfer.api.UFTTransferConfig.UploadConfig;
import com.tencent.mobileqq.uftransfer.api.impl.UFTTransferKey;
import com.tencent.mobileqq.uftransfer.depend.UFTLog;
import com.tencent.mobileqq.uftransfer.task.upload.UFTUploadCbWrapper;
import com.tencent.mobileqq.uftransfer.task.upload.UFTUploadCompleteInfo;
import com.tencent.mobileqq.uftransfer.taskqueue.UFTUploadTaskQueue;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class UFTGuildUploadController
  implements INetInfoHandler
{
  private final AppRuntime a;
  private final UFTUploadTaskQueue b;
  
  public UFTGuildUploadController(AppRuntime paramAppRuntime, int paramInt)
  {
    this.a = paramAppRuntime;
    this.b = new UFTUploadTaskQueue(paramInt);
  }
  
  public void a(UFTTransferKey paramUFTTransferKey, Bundle paramBundle)
  {
    this.b.a(paramUFTTransferKey.b(), paramBundle);
  }
  
  public void a(UFTTransferKey paramUFTTransferKey, UFTGuildUploadInfo paramUFTGuildUploadInfo, UFTTransferConfig paramUFTTransferConfig, IUFTUploadCallback paramIUFTUploadCallback)
  {
    if (paramUFTGuildUploadInfo == null)
    {
      paramUFTGuildUploadInfo = new StringBuilder();
      paramUFTGuildUploadInfo.append("[");
      paramUFTGuildUploadInfo.append(paramUFTTransferKey.b());
      paramUFTGuildUploadInfo.append("] upload c2c file, upload info is null");
      UFTLog.d("[UFTTransfer] UFTGuildUploadController", 1, paramUFTGuildUploadInfo.toString());
      new UFTUploadCbWrapper(new UFTGuildUploadController.1(this), paramIUFTUploadCallback).a(paramUFTTransferKey, 9005, new UFTUploadCompleteInfo());
      return;
    }
    UFTTransferConfig localUFTTransferConfig = paramUFTTransferConfig;
    if (paramUFTTransferConfig == null) {
      localUFTTransferConfig = new UFTTransferConfig(true);
    }
    paramUFTTransferConfig = new StringBuilder();
    paramUFTTransferConfig.append("[");
    paramUFTTransferConfig.append(paramUFTTransferKey.b());
    paramUFTTransferConfig.append("] uploadGuildFile, uploadinfo:");
    paramUFTTransferConfig.append(paramUFTGuildUploadInfo.toString());
    paramUFTTransferConfig.append(" config:");
    paramUFTTransferConfig.append(paramUFTGuildUploadInfo.toString());
    UFTLog.b("[UFTTransfer] UFTGuildUploadController", 1, paramUFTTransferConfig.toString());
    if (TextUtils.isEmpty(paramUFTGuildUploadInfo.a()))
    {
      paramUFTGuildUploadInfo = new StringBuilder();
      paramUFTGuildUploadInfo.append("[");
      paramUFTGuildUploadInfo.append(paramUFTTransferKey.b());
      paramUFTGuildUploadInfo.append("] upload c2c file, file path is null");
      UFTLog.d("[UFTTransfer] UFTGuildUploadController", 1, paramUFTGuildUploadInfo.toString());
      new UFTUploadCbWrapper(new UFTGuildUploadController.2(this), paramIUFTUploadCallback).a(paramUFTTransferKey, 9042, new UFTUploadCompleteInfo());
      return;
    }
    paramUFTTransferConfig = UFTGuildUploadTaskInfo.a(paramUFTTransferKey.b(), paramUFTTransferKey.c(), paramUFTGuildUploadInfo, localUFTTransferConfig);
    if (paramUFTTransferConfig == null)
    {
      paramUFTGuildUploadInfo = new StringBuilder();
      paramUFTGuildUploadInfo.append("[");
      paramUFTGuildUploadInfo.append(paramUFTTransferKey.b());
      paramUFTGuildUploadInfo.append("] upload guild file, create task info fail");
      UFTLog.d("[UFTTransfer] UFTGuildUploadController", 1, paramUFTGuildUploadInfo.toString());
      new UFTUploadCbWrapper(new UFTGuildUploadController.3(this), paramIUFTUploadCallback).a(paramUFTTransferKey, 9005, new UFTUploadCompleteInfo());
      return;
    }
    paramUFTGuildUploadInfo = null;
    if (paramUFTTransferConfig.s().a().a()) {
      paramUFTGuildUploadInfo = UFTGuildExtfUploadTask.a(this.a, paramUFTTransferKey, paramUFTTransferConfig, this.b, paramIUFTUploadCallback);
    } else {
      QLog.e("[UFTTransfer] UFTGuildUploadController", 1, "Guild need useExtf");
    }
    if (paramUFTGuildUploadInfo == null)
    {
      paramUFTGuildUploadInfo = new StringBuilder();
      paramUFTGuildUploadInfo.append("[");
      paramUFTGuildUploadInfo.append(paramUFTTransferKey.b());
      paramUFTGuildUploadInfo.append("] upload guild file, create task fail");
      UFTLog.d("[UFTTransfer] UFTGuildUploadController", 1, paramUFTGuildUploadInfo.toString());
      new UFTUploadCbWrapper(new UFTGuildUploadController.4(this), paramIUFTUploadCallback).a(paramUFTTransferKey, 9005, new UFTUploadCompleteInfo());
      return;
    }
    this.b.a(paramUFTGuildUploadInfo);
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
 * Qualified Name:     com.tencent.mobileqq.uftransfer.guild.UFTGuildUploadController
 * JD-Core Version:    0.7.0.1
 */