package com.tencent.mobileqq.uftransfer.manager.controller;

import android.os.Bundle;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.uftransfer.api.IUFTUploadCallback;
import com.tencent.mobileqq.uftransfer.api.UFTTransferConfig;
import com.tencent.mobileqq.uftransfer.api.UFTTroopUploadInfo;
import com.tencent.mobileqq.uftransfer.api.impl.UFTTransferKey;
import com.tencent.mobileqq.uftransfer.taskqueue.UFTUploadTaskQueue;
import mqq.app.AppRuntime;

public class UFTTroopUploadController
  implements INetInfoHandler
{
  private final UFTUploadTaskQueue jdField_a_of_type_ComTencentMobileqqUftransferTaskqueueUFTUploadTaskQueue;
  private final AppRuntime jdField_a_of_type_MqqAppAppRuntime;
  
  public UFTTroopUploadController(AppRuntime paramAppRuntime, int paramInt)
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
  
  public void a(UFTTransferKey paramUFTTransferKey, UFTTroopUploadInfo paramUFTTroopUploadInfo, UFTTransferConfig paramUFTTransferConfig, IUFTUploadCallback paramIUFTUploadCallback)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
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
 * Qualified Name:     com.tencent.mobileqq.uftransfer.manager.controller.UFTTroopUploadController
 * JD-Core Version:    0.7.0.1
 */