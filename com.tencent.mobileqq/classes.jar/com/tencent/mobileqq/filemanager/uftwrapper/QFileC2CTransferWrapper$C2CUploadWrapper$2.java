package com.tencent.mobileqq.filemanager.uftwrapper;

import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.forward.ForwardOrderManager;
import com.tencent.mobileqq.filemanager.app.FileTransferObserver;
import com.tencent.mobileqq.uftransfer.api.IUFTUploadSendMsgCallback;

class QFileC2CTransferWrapper$C2CUploadWrapper$2
  extends FileTransferObserver
{
  QFileC2CTransferWrapper$C2CUploadWrapper$2(QFileC2CTransferWrapper.C2CUploadWrapper paramC2CUploadWrapper, IUFTUploadSendMsgCallback paramIUFTUploadSendMsgCallback) {}
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, int paramInt, long paramLong3)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerUftwrapperQFileC2CTransferWrapper$C2CUploadWrapper.jdField_a_of_type_Boolean) {
      return;
    }
    if ((paramBoolean) && (paramLong1 != 58L)) {
      ForwardOrderManager.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerUftwrapperQFileC2CTransferWrapper$C2CUploadWrapper.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLong3);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUftransferApiIUFTUploadSendMsgCallback != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("seq", paramInt);
      localBundle.putLong("uniSeq", paramLong3);
      this.jdField_a_of_type_ComTencentMobileqqUftransferApiIUFTUploadSendMsgCallback.a(paramBoolean, paramLong1, localBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.uftwrapper.QFileC2CTransferWrapper.C2CUploadWrapper.2
 * JD-Core Version:    0.7.0.1
 */