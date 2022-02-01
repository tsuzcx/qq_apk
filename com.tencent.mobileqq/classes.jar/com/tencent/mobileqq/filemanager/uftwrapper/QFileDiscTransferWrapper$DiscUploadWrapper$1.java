package com.tencent.mobileqq.filemanager.uftwrapper;

import android.os.Bundle;
import com.tencent.mobileqq.filemanager.app.FileTransferObserver;
import com.tencent.mobileqq.uftransfer.api.IUFTUploadSendMsgCallback;

class QFileDiscTransferWrapper$DiscUploadWrapper$1
  extends FileTransferObserver
{
  QFileDiscTransferWrapper$DiscUploadWrapper$1(QFileDiscTransferWrapper.DiscUploadWrapper paramDiscUploadWrapper, IUFTUploadSendMsgCallback paramIUFTUploadSendMsgCallback) {}
  
  protected void a(boolean paramBoolean, Long paramLong)
  {
    IUFTUploadSendMsgCallback localIUFTUploadSendMsgCallback = this.a;
    if (localIUFTUploadSendMsgCallback != null) {
      localIUFTUploadSendMsgCallback.a(paramBoolean, paramLong.longValue(), new Bundle());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.uftwrapper.QFileDiscTransferWrapper.DiscUploadWrapper.1
 * JD-Core Version:    0.7.0.1
 */