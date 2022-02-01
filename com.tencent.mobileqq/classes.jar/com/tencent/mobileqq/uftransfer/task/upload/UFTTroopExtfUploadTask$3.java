package com.tencent.mobileqq.uftransfer.task.upload;

import android.os.Bundle;
import com.tencent.mobileqq.uftransfer.api.IUFTTransferKey;
import com.tencent.mobileqq.uftransfer.api.IUFTUploadCallback;
import com.tencent.mobileqq.uftransfer.api.IUFTUploadCompleteInfo;
import com.tencent.mobileqq.uftransfer.api.IUFTUploadSendMsgCallback;
import com.tencent.mobileqq.uftransfer.api.UFTFileLocalInfo;
import com.tencent.mobileqq.uftransfer.api.UFTFileUploadBusinessInfo;

class UFTTroopExtfUploadTask$3
  implements IUFTUploadCallback
{
  UFTTroopExtfUploadTask$3(UFTTroopExtfUploadTask paramUFTTroopExtfUploadTask) {}
  
  public int a(IUFTTransferKey paramIUFTTransferKey, Bundle paramBundle, IUFTUploadSendMsgCallback paramIUFTUploadSendMsgCallback)
  {
    if (this.a.a != null) {
      return this.a.a.a(paramIUFTTransferKey, paramBundle, paramIUFTUploadSendMsgCallback);
    }
    return -1;
  }
  
  public void a(IUFTTransferKey paramIUFTTransferKey) {}
  
  public void a(IUFTTransferKey paramIUFTTransferKey, int paramInt, Bundle paramBundle)
  {
    if (this.a.a != null) {
      this.a.a.a(paramIUFTTransferKey, paramInt, paramBundle);
    }
  }
  
  public void a(IUFTTransferKey paramIUFTTransferKey, int paramInt, IUFTUploadCompleteInfo paramIUFTUploadCompleteInfo)
  {
    if (this.a.a != null) {
      this.a.a.a(paramIUFTTransferKey, paramInt, paramIUFTUploadCompleteInfo);
    }
  }
  
  public void a(IUFTTransferKey paramIUFTTransferKey, long paramLong1, long paramLong2)
  {
    if (this.a.a != null) {
      this.a.a.a(paramIUFTTransferKey, paramLong1, paramLong2);
    }
  }
  
  public void a(IUFTTransferKey paramIUFTTransferKey, long paramLong1, long paramLong2, long paramLong3)
  {
    if (this.a.a != null) {
      this.a.a.a(paramIUFTTransferKey, paramLong1, paramLong2, paramLong3);
    }
  }
  
  public void a(IUFTTransferKey paramIUFTTransferKey, UFTFileLocalInfo paramUFTFileLocalInfo)
  {
    if (this.a.a != null) {
      this.a.a.a(paramIUFTTransferKey, paramUFTFileLocalInfo);
    }
  }
  
  public void a(IUFTTransferKey paramIUFTTransferKey, UFTFileUploadBusinessInfo paramUFTFileUploadBusinessInfo)
  {
    if (this.a.a != null) {
      this.a.a.a(paramIUFTTransferKey, paramUFTFileUploadBusinessInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.task.upload.UFTTroopExtfUploadTask.3
 * JD-Core Version:    0.7.0.1
 */