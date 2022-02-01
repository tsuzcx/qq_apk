package com.tencent.mobileqq.filemanager.uftwrapper;

import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.business.qfile.IQFileExcitingC2CUploadConfigBean;
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

abstract class QFileC2CTransferWrapper$C2CBaseUploadWrapper
  implements IUFTUploadCallback
{
  final QQAppInterface a;
  boolean b = true;
  final QFileC2CTransferWrapper.ITransferWrapperCallback c;
  IUFTTransferKey d;
  boolean e = false;
  
  public QFileC2CTransferWrapper$C2CBaseUploadWrapper(QQAppInterface paramQQAppInterface, QFileC2CTransferWrapper.ITransferWrapperCallback paramITransferWrapperCallback)
  {
    this.a = paramQQAppInterface;
    this.c = paramITransferWrapperCallback;
  }
  
  public int a(IUFTTransferKey paramIUFTTransferKey, Bundle paramBundle, IUFTUploadSendMsgCallback paramIUFTUploadSendMsgCallback)
  {
    return -1;
  }
  
  protected UFTTransferConfig a()
  {
    UFTTransferConfig localUFTTransferConfig = new UFTTransferConfig(true);
    Object localObject = (IQFileConfigManager)this.a.getRuntimeService(IQFileConfigManager.class, "");
    localUFTTransferConfig.a().c(true);
    localUFTTransferConfig.a().d(FileIPv6StrateyController.b().isConfigEnableIPV6(this.a, 1));
    localUFTTransferConfig.a().f(true);
    if (b() > ((IExcitingTransferAdapter)this.a.getRuntimeService(IExcitingTransferAdapter.class, "")).getC2CUploadLimitedSize())
    {
      localUFTTransferConfig.a().a(true);
      localUFTTransferConfig.a().b(true);
    }
    localUFTTransferConfig.a().e(false);
    if (((IQFileConfigManager)localObject).getExcitingC2CUploadConfig() != null) {
      localObject = ((IQFileConfigManager)localObject).getExcitingC2CUploadConfig().c();
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
    if (this.e)
    {
      localUFTTransferConfig.a().a(true);
      localUFTTransferConfig.a().b(false);
    }
    return localUFTTransferConfig;
  }
  
  public void a(IUFTTransferKey paramIUFTTransferKey) {}
  
  public void a(IUFTTransferKey paramIUFTTransferKey, int paramInt, Bundle paramBundle) {}
  
  public void a(IUFTTransferKey paramIUFTTransferKey, int paramInt, IUFTUploadCompleteInfo paramIUFTUploadCompleteInfo) {}
  
  public void a(IUFTTransferKey paramIUFTTransferKey, long paramLong1, long paramLong2) {}
  
  public void a(IUFTTransferKey paramIUFTTransferKey, long paramLong1, long paramLong2, long paramLong3) {}
  
  public void a(IUFTTransferKey paramIUFTTransferKey, UFTFileLocalInfo paramUFTFileLocalInfo) {}
  
  public void a(IUFTTransferKey paramIUFTTransferKey, UFTFileUploadBusinessInfo paramUFTFileUploadBusinessInfo) {}
  
  boolean a(int paramInt)
  {
    this.b = true;
    if (this.d != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("REASON", paramInt);
      ((IUFTTransferService)this.a.getRuntimeService(IUFTTransferService.class, "")).stop(this.d, localBundle);
    }
    return true;
  }
  
  abstract long b();
  
  abstract void c();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.uftwrapper.QFileC2CTransferWrapper.C2CBaseUploadWrapper
 * JD-Core Version:    0.7.0.1
 */