package com.tencent.mobileqq.uftransfer.api;

import android.os.Bundle;

public abstract interface IUFTUploadCallback
{
  public abstract int a(IUFTTransferKey paramIUFTTransferKey, Bundle paramBundle, IUFTUploadSendMsgCallback paramIUFTUploadSendMsgCallback);
  
  public abstract void a(IUFTTransferKey paramIUFTTransferKey);
  
  public abstract void a(IUFTTransferKey paramIUFTTransferKey, int paramInt, Bundle paramBundle);
  
  public abstract void a(IUFTTransferKey paramIUFTTransferKey, int paramInt, IUFTUploadCompleteInfo paramIUFTUploadCompleteInfo);
  
  public abstract void a(IUFTTransferKey paramIUFTTransferKey, long paramLong1, long paramLong2);
  
  public abstract void a(IUFTTransferKey paramIUFTTransferKey, long paramLong1, long paramLong2, long paramLong3);
  
  public abstract void a(IUFTTransferKey paramIUFTTransferKey, UFTFileLocalInfo paramUFTFileLocalInfo);
  
  public abstract void a(IUFTTransferKey paramIUFTTransferKey, UFTFileUploadBusinessInfo paramUFTFileUploadBusinessInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.api.IUFTUploadCallback
 * JD-Core Version:    0.7.0.1
 */