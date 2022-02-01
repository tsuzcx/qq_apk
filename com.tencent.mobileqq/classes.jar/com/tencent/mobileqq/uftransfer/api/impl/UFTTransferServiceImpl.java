package com.tencent.mobileqq.uftransfer.api.impl;

import android.os.Bundle;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.uftransfer.UFTLogicThread;
import com.tencent.mobileqq.uftransfer.api.IUFTTransferKey;
import com.tencent.mobileqq.uftransfer.api.IUFTTransferService;
import com.tencent.mobileqq.uftransfer.api.IUFTUploadCallback;
import com.tencent.mobileqq.uftransfer.api.UFTC2CUploadInfo;
import com.tencent.mobileqq.uftransfer.api.UFTDiscUploadInfo;
import com.tencent.mobileqq.uftransfer.api.UFTTransferConfig;
import com.tencent.mobileqq.uftransfer.api.UFTTroopUploadInfo;
import com.tencent.mobileqq.uftransfer.depend.UFTLog;
import com.tencent.mobileqq.uftransfer.guild.UFTGuildUploadController;
import com.tencent.mobileqq.uftransfer.guild.UFTGuildUploadInfo;
import com.tencent.mobileqq.uftransfer.manager.controller.UFTC2CUploadController;
import com.tencent.mobileqq.uftransfer.manager.controller.UFTDiscUploadController;
import com.tencent.mobileqq.uftransfer.manager.controller.UFTTroopUploadController;
import mqq.app.AppRuntime;

public class UFTTransferServiceImpl
  implements INetInfoHandler, IUFTTransferService
{
  public static final String TAG = "[UFTTransfer] UFTTransferService";
  private AppRuntime mApp;
  private UFTC2CUploadController mC2CUploadController;
  private UFTC2CUploadController mC2CUploadController4MutilFwd;
  private UFTDiscUploadController mDiscUploadController;
  private UFTDiscUploadController mDiscUploadController4MutilFwd;
  private UFTGuildUploadController mGuildUploadController;
  private UFTTroopUploadController mTroopUploadController;
  private UFTTroopUploadController mTroopUploadController4MutilFwd;
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    UFTLog.b("[UFTTransfer] UFTTransferService", 1, "on service create...");
    this.mApp = paramAppRuntime;
    this.mC2CUploadController = new UFTC2CUploadController(this.mApp, 2);
    this.mDiscUploadController = new UFTDiscUploadController(this.mApp, 2);
    this.mTroopUploadController = new UFTTroopUploadController(this.mApp, 8);
    this.mGuildUploadController = new UFTGuildUploadController(this.mApp, 2);
    this.mC2CUploadController4MutilFwd = new UFTC2CUploadController(this.mApp, 100);
    this.mDiscUploadController4MutilFwd = new UFTDiscUploadController(this.mApp, 100);
    this.mTroopUploadController4MutilFwd = new UFTTroopUploadController(this.mApp, 100);
    AppNetConnInfo.registerConnectionChangeReceiver(this.mApp.getApplication(), this);
  }
  
  public void onDestroy()
  {
    UFTLog.c("[UFTTransfer] UFTTransferService", 1, "on service destroy...");
    UFTLogicThread.a().a(new UFTTransferServiceImpl.1(this));
    this.mApp = null;
    AppNetConnInfo.unregisterNetInfoHandler(this);
  }
  
  public void onNetMobile2None()
  {
    UFTLog.c("[UFTTransfer] UFTTransferService", 1, "on net work change: mobile->none");
    UFTLogicThread.a().a(new UFTTransferServiceImpl.11(this));
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    UFTLog.c("[UFTTransfer] UFTTransferService", 1, "on net work change: mobile->wifi");
    UFTLogicThread.a().a(new UFTTransferServiceImpl.10(this, paramString));
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    UFTLog.c("[UFTTransfer] UFTTransferService", 1, "on net work change: none->mobile");
    UFTLogicThread.a().a(new UFTTransferServiceImpl.7(this, paramString));
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    UFTLog.c("[UFTTransfer] UFTTransferService", 1, "on net work change: none->wifi");
    UFTLogicThread.a().a(new UFTTransferServiceImpl.9(this, paramString));
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    UFTLog.c("[UFTTransfer] UFTTransferService", 1, "on net work change: wifi->mobile");
    UFTLogicThread.a().a(new UFTTransferServiceImpl.8(this, paramString));
  }
  
  public void onNetWifi2None()
  {
    UFTLog.c("[UFTTransfer] UFTTransferService", 1, "on net work change: wifi->none");
    UFTLogicThread.a().a(new UFTTransferServiceImpl.12(this));
  }
  
  public void stop(IUFTTransferKey paramIUFTTransferKey, Bundle paramBundle)
  {
    if (paramIUFTTransferKey == null)
    {
      UFTLog.d("[UFTTransfer] UFTTransferService", 1, "stop fail. trans key is null");
      return;
    }
    UFTTransferKey localUFTTransferKey = null;
    if ((paramIUFTTransferKey instanceof UFTTransferKey)) {
      localUFTTransferKey = (UFTTransferKey)paramIUFTTransferKey;
    }
    if (localUFTTransferKey == null)
    {
      UFTLog.d("[UFTTransfer] UFTTransferService", 1, "stop fail. trans key err");
      return;
    }
    UFTLogicThread.a().a(new UFTTransferServiceImpl.6(this, localUFTTransferKey, paramBundle));
  }
  
  public IUFTTransferKey uploadC2CFile(UFTC2CUploadInfo paramUFTC2CUploadInfo, UFTTransferConfig paramUFTTransferConfig, IUFTUploadCallback paramIUFTUploadCallback)
  {
    UFTTransferKey localUFTTransferKey = new UFTTransferKey(1, paramUFTC2CUploadInfo.f());
    localUFTTransferKey.a(paramUFTC2CUploadInfo.e());
    UFTLogicThread.a().a(new UFTTransferServiceImpl.2(this, paramUFTC2CUploadInfo, localUFTTransferKey, paramUFTTransferConfig, paramIUFTUploadCallback));
    return localUFTTransferKey;
  }
  
  public IUFTTransferKey uploadDiscFile(UFTDiscUploadInfo paramUFTDiscUploadInfo, UFTTransferConfig paramUFTTransferConfig, IUFTUploadCallback paramIUFTUploadCallback)
  {
    UFTTransferKey localUFTTransferKey = new UFTTransferKey(3, paramUFTDiscUploadInfo.f());
    localUFTTransferKey.a(paramUFTDiscUploadInfo.e());
    UFTLogicThread.a().a(new UFTTransferServiceImpl.5(this, paramUFTDiscUploadInfo, localUFTTransferKey, paramUFTTransferConfig, paramIUFTUploadCallback));
    return localUFTTransferKey;
  }
  
  public IUFTTransferKey uploadGuildFile(UFTGuildUploadInfo paramUFTGuildUploadInfo, UFTTransferConfig paramUFTTransferConfig, IUFTUploadCallback paramIUFTUploadCallback)
  {
    UFTTransferKey localUFTTransferKey = new UFTTransferKey(10, paramUFTGuildUploadInfo.f());
    localUFTTransferKey.a(paramUFTGuildUploadInfo.e());
    UFTLogicThread.a().a(new UFTTransferServiceImpl.3(this, localUFTTransferKey, paramUFTGuildUploadInfo, paramUFTTransferConfig, paramIUFTUploadCallback));
    return localUFTTransferKey;
  }
  
  public IUFTTransferKey uploadTroopFile(UFTTroopUploadInfo paramUFTTroopUploadInfo, UFTTransferConfig paramUFTTransferConfig, IUFTUploadCallback paramIUFTUploadCallback)
  {
    UFTTransferKey localUFTTransferKey = new UFTTransferKey(2, paramUFTTroopUploadInfo.f());
    localUFTTransferKey.a(paramUFTTroopUploadInfo.e());
    UFTLogicThread.a().a(new UFTTransferServiceImpl.4(this, paramUFTTroopUploadInfo, localUFTTransferKey, paramUFTTransferConfig, paramIUFTUploadCallback));
    return localUFTTransferKey;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.api.impl.UFTTransferServiceImpl
 * JD-Core Version:    0.7.0.1
 */