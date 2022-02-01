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
  final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  final QFileC2CTransferWrapper.ITransferWrapperCallback jdField_a_of_type_ComTencentMobileqqFilemanagerUftwrapperQFileC2CTransferWrapper$ITransferWrapperCallback;
  IUFTTransferKey jdField_a_of_type_ComTencentMobileqqUftransferApiIUFTTransferKey;
  boolean jdField_a_of_type_Boolean = true;
  boolean b = false;
  
  public QFileC2CTransferWrapper$C2CBaseUploadWrapper(QQAppInterface paramQQAppInterface, QFileC2CTransferWrapper.ITransferWrapperCallback paramITransferWrapperCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerUftwrapperQFileC2CTransferWrapper$ITransferWrapperCallback = paramITransferWrapperCallback;
  }
  
  public int a(IUFTTransferKey paramIUFTTransferKey, Bundle paramBundle, IUFTUploadSendMsgCallback paramIUFTUploadSendMsgCallback)
  {
    return -1;
  }
  
  abstract long a();
  
  protected UFTTransferConfig a()
  {
    UFTTransferConfig localUFTTransferConfig = new UFTTransferConfig(true);
    Object localObject = (IQFileConfigManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IQFileConfigManager.class, "");
    localUFTTransferConfig.a().c(true);
    localUFTTransferConfig.a().d(FileIPv6StrateyController.a().isConfigEnableIPV6(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1));
    localUFTTransferConfig.a().f(true);
    if (a() > ((IExcitingTransferAdapter)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IExcitingTransferAdapter.class, "")).getC2CUploadLimitedSize())
    {
      localUFTTransferConfig.a().a(true);
      localUFTTransferConfig.a().b(true);
    }
    localUFTTransferConfig.a().e(false);
    if (((IQFileConfigManager)localObject).getExcitingC2CUploadConfig() != null) {
      localObject = ((IQFileConfigManager)localObject).getExcitingC2CUploadConfig().a();
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
    if (this.b)
    {
      localUFTTransferConfig.a().a(true);
      localUFTTransferConfig.a().b(false);
    }
    return localUFTTransferConfig;
  }
  
  abstract void a();
  
  public void a(IUFTTransferKey paramIUFTTransferKey) {}
  
  public void a(IUFTTransferKey paramIUFTTransferKey, int paramInt, Bundle paramBundle) {}
  
  public void a(IUFTTransferKey paramIUFTTransferKey, int paramInt, IUFTUploadCompleteInfo paramIUFTUploadCompleteInfo) {}
  
  public void a(IUFTTransferKey paramIUFTTransferKey, long paramLong1, long paramLong2) {}
  
  public void a(IUFTTransferKey paramIUFTTransferKey, long paramLong1, long paramLong2, long paramLong3) {}
  
  public void a(IUFTTransferKey paramIUFTTransferKey, UFTFileLocalInfo paramUFTFileLocalInfo) {}
  
  public void a(IUFTTransferKey paramIUFTTransferKey, UFTFileUploadBusinessInfo paramUFTFileUploadBusinessInfo) {}
  
  boolean a(int paramInt)
  {
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentMobileqqUftransferApiIUFTTransferKey != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("REASON", paramInt);
      ((IUFTTransferService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IUFTTransferService.class, "")).stop(this.jdField_a_of_type_ComTencentMobileqqUftransferApiIUFTTransferKey, localBundle);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.uftwrapper.QFileC2CTransferWrapper.C2CBaseUploadWrapper
 * JD-Core Version:    0.7.0.1
 */