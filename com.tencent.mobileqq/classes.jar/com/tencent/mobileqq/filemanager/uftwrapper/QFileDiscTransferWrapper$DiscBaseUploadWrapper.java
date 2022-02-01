package com.tencent.mobileqq.filemanager.uftwrapper;

import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.api.IFileIPv6StrateyController;
import com.tencent.mobileqq.filemanager.core.FileIPv6StrateyController;
import com.tencent.mobileqq.uftransfer.api.IUFTTransferKey;
import com.tencent.mobileqq.uftransfer.api.IUFTTransferService;
import com.tencent.mobileqq.uftransfer.api.IUFTUploadCallback;
import com.tencent.mobileqq.uftransfer.api.IUFTUploadCompleteInfo;
import com.tencent.mobileqq.uftransfer.api.IUFTUploadSendMsgCallback;
import com.tencent.mobileqq.uftransfer.api.UFTFileLocalInfo;
import com.tencent.mobileqq.uftransfer.api.UFTFileUploadBusinessInfo;
import com.tencent.mobileqq.uftransfer.api.UFTTransferConfig;
import com.tencent.mobileqq.uftransfer.api.UFTTransferConfig.UploadConfig;

abstract class QFileDiscTransferWrapper$DiscBaseUploadWrapper
  implements IUFTUploadCallback
{
  final QQAppInterface a;
  boolean b = true;
  final QFileDiscTransferWrapper.ITransferWrapperCallback c;
  IUFTTransferKey d;
  
  QFileDiscTransferWrapper$DiscBaseUploadWrapper(QQAppInterface paramQQAppInterface, QFileDiscTransferWrapper.ITransferWrapperCallback paramITransferWrapperCallback)
  {
    this.a = paramQQAppInterface;
    this.c = paramITransferWrapperCallback;
  }
  
  public int a(IUFTTransferKey paramIUFTTransferKey, Bundle paramBundle, IUFTUploadSendMsgCallback paramIUFTUploadSendMsgCallback)
  {
    return -1;
  }
  
  UFTTransferConfig a()
  {
    UFTTransferConfig localUFTTransferConfig = new UFTTransferConfig(true);
    localUFTTransferConfig.a().c(true);
    localUFTTransferConfig.a().d(FileIPv6StrateyController.b().isConfigEnableIPV6(this.a, 5));
    return localUFTTransferConfig;
  }
  
  void a(int paramInt)
  {
    this.b = true;
    if (this.d != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("REASON", paramInt);
      ((IUFTTransferService)this.a.getRuntimeService(IUFTTransferService.class, "")).stop(this.d, localBundle);
    }
  }
  
  public void a(IUFTTransferKey paramIUFTTransferKey) {}
  
  public void a(IUFTTransferKey paramIUFTTransferKey, int paramInt, Bundle paramBundle) {}
  
  public void a(IUFTTransferKey paramIUFTTransferKey, int paramInt, IUFTUploadCompleteInfo paramIUFTUploadCompleteInfo) {}
  
  public void a(IUFTTransferKey paramIUFTTransferKey, long paramLong1, long paramLong2) {}
  
  public void a(IUFTTransferKey paramIUFTTransferKey, long paramLong1, long paramLong2, long paramLong3) {}
  
  public void a(IUFTTransferKey paramIUFTTransferKey, UFTFileLocalInfo paramUFTFileLocalInfo) {}
  
  public void a(IUFTTransferKey paramIUFTTransferKey, UFTFileUploadBusinessInfo paramUFTFileUploadBusinessInfo) {}
  
  abstract void b();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.uftwrapper.QFileDiscTransferWrapper.DiscBaseUploadWrapper
 * JD-Core Version:    0.7.0.1
 */