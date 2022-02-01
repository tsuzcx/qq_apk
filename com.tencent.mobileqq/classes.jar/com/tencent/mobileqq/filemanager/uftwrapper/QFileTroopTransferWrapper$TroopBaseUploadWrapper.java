package com.tencent.mobileqq.filemanager.uftwrapper;

import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.business.qfile.IQFileExcitingGroupUploadConfigBean;
import com.tencent.mobileqq.filemanager.api.IExcitingTransferAdapter;
import com.tencent.mobileqq.filemanager.api.IFileIPv6StrateyController;
import com.tencent.mobileqq.filemanager.api.IQFileConfigManager;
import com.tencent.mobileqq.filemanager.core.FileIPv6StrateyController;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploadChnConfigInfo;
import com.tencent.mobileqq.uftransfer.api.IUFTTransferKey;
import com.tencent.mobileqq.uftransfer.api.IUFTTransferService;
import com.tencent.mobileqq.uftransfer.api.IUFTUploadCallback;
import com.tencent.mobileqq.uftransfer.api.IUFTUploadCompleteInfo;
import com.tencent.mobileqq.uftransfer.api.IUFTUploadSendMsgCallback;
import com.tencent.mobileqq.uftransfer.api.UFTFileLocalInfo;
import com.tencent.mobileqq.uftransfer.api.UFTFileUploadBusinessInfo;
import com.tencent.mobileqq.uftransfer.api.UFTTransferConfig;
import com.tencent.mobileqq.uftransfer.api.UFTTransferConfig.ExtfUploadCfg;
import com.tencent.mobileqq.uftransfer.api.UFTTransferConfig.UploadConfig;

abstract class QFileTroopTransferWrapper$TroopBaseUploadWrapper
  implements IUFTUploadCallback
{
  final QQAppInterface a;
  boolean b = true;
  final long c;
  final QFileTroopTransferWrapper.ITransferWrapperCallback d;
  IUFTTransferKey e;
  
  QFileTroopTransferWrapper$TroopBaseUploadWrapper(QQAppInterface paramQQAppInterface, long paramLong, QFileTroopTransferWrapper.ITransferWrapperCallback paramITransferWrapperCallback)
  {
    this.a = paramQQAppInterface;
    this.c = paramLong;
    this.d = paramITransferWrapperCallback;
  }
  
  public int a(IUFTTransferKey paramIUFTTransferKey, Bundle paramBundle, IUFTUploadSendMsgCallback paramIUFTUploadSendMsgCallback)
  {
    return -1;
  }
  
  abstract long a();
  
  void a(int paramInt)
  {
    this.b = true;
    if (this.e != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("REASON", paramInt);
      ((IUFTTransferService)this.a.getRuntimeService(IUFTTransferService.class, "")).stop(this.e, localBundle);
    }
  }
  
  public void a(IUFTTransferKey paramIUFTTransferKey) {}
  
  public void a(IUFTTransferKey paramIUFTTransferKey, int paramInt, Bundle paramBundle) {}
  
  public void a(IUFTTransferKey paramIUFTTransferKey, int paramInt, IUFTUploadCompleteInfo paramIUFTUploadCompleteInfo) {}
  
  public void a(IUFTTransferKey paramIUFTTransferKey, long paramLong1, long paramLong2) {}
  
  public void a(IUFTTransferKey paramIUFTTransferKey, long paramLong1, long paramLong2, long paramLong3) {}
  
  public void a(IUFTTransferKey paramIUFTTransferKey, UFTFileLocalInfo paramUFTFileLocalInfo) {}
  
  public void a(IUFTTransferKey paramIUFTTransferKey, UFTFileUploadBusinessInfo paramUFTFileUploadBusinessInfo) {}
  
  UFTTransferConfig b()
  {
    UFTTransferConfig localUFTTransferConfig = new UFTTransferConfig(true);
    localUFTTransferConfig.a().c(true);
    localUFTTransferConfig.a().d(FileIPv6StrateyController.b().isConfigEnableIPV6(this.a, 3));
    if (a() > ((IExcitingTransferAdapter)this.a.getRuntimeService(IExcitingTransferAdapter.class, "")).getGroupUploadLimitedSize())
    {
      localUFTTransferConfig.a().a(true);
      localUFTTransferConfig.a().b(true);
    }
    Object localObject = (IQFileConfigManager)this.a.getRuntimeService(IQFileConfigManager.class, "");
    if (((IQFileConfigManager)localObject).getExcitingGroupUploadConfig() != null) {
      localObject = ((IQFileConfigManager)localObject).getExcitingGroupUploadConfig().c();
    } else {
      localObject = new ExcitingTransferUploadChnConfigInfo();
    }
    UFTTransferConfig.ExtfUploadCfg localExtfUploadCfg = new UFTTransferConfig.ExtfUploadCfg();
    localExtfUploadCfg.b(((ExcitingTransferUploadChnConfigInfo)localObject).nConnectTimeout);
    localExtfUploadCfg.c(((ExcitingTransferUploadChnConfigInfo)localObject).nDataTimeout);
    localExtfUploadCfg.a(((ExcitingTransferUploadChnConfigInfo)localObject).uMaxChannelNum);
    localExtfUploadCfg.d(((ExcitingTransferUploadChnConfigInfo)localObject).nMaxEachHostErrorCount);
    localExtfUploadCfg.e(((ExcitingTransferUploadChnConfigInfo)localObject).nMaxEachHostParallelUseCount);
    localExtfUploadCfg.c(((ExcitingTransferUploadChnConfigInfo)localObject).nMaxEachHostTotalUseCount);
    localExtfUploadCfg.a(((ExcitingTransferUploadChnConfigInfo)localObject).uMuliFileSizeLimit);
    localExtfUploadCfg.b(((ExcitingTransferUploadChnConfigInfo)localObject).uPieceSize);
    localExtfUploadCfg.d(((ExcitingTransferUploadChnConfigInfo)localObject).nTotoalDataTimeout);
    localUFTTransferConfig.a().a(localExtfUploadCfg);
    return localUFTTransferConfig;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.uftwrapper.QFileTroopTransferWrapper.TroopBaseUploadWrapper
 * JD-Core Version:    0.7.0.1
 */