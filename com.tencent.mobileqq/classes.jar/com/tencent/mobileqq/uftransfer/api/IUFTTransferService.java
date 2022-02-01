package com.tencent.mobileqq.uftransfer.api;

import android.os.Bundle;
import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.mobileqq.uftransfer.guild.UFTGuildUploadInfo;
import mqq.app.api.IRuntimeService;

@Service(process={""})
public abstract interface IUFTTransferService
  extends IRuntimeService
{
  public abstract void stop(IUFTTransferKey paramIUFTTransferKey, Bundle paramBundle);
  
  public abstract IUFTTransferKey uploadC2CFile(UFTC2CUploadInfo paramUFTC2CUploadInfo, UFTTransferConfig paramUFTTransferConfig, IUFTUploadCallback paramIUFTUploadCallback);
  
  public abstract IUFTTransferKey uploadDiscFile(UFTDiscUploadInfo paramUFTDiscUploadInfo, UFTTransferConfig paramUFTTransferConfig, IUFTUploadCallback paramIUFTUploadCallback);
  
  public abstract IUFTTransferKey uploadGuildFile(UFTGuildUploadInfo paramUFTGuildUploadInfo, UFTTransferConfig paramUFTTransferConfig, IUFTUploadCallback paramIUFTUploadCallback);
  
  public abstract IUFTTransferKey uploadTroopFile(UFTTroopUploadInfo paramUFTTroopUploadInfo, UFTTransferConfig paramUFTTransferConfig, IUFTUploadCallback paramIUFTUploadCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.api.IUFTTransferService
 * JD-Core Version:    0.7.0.1
 */