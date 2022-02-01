package com.tencent.mobileqq.transfile;

import bbos;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class LightVideoUploadProcessor$TransactionListener
  implements ITransactionCallback
{
  public int index;
  public bbos sendInfo;
  public Transaction trans;
  
  LightVideoUploadProcessor$TransactionListener(LightVideoUploadProcessor paramLightVideoUploadProcessor) {}
  
  public void onFailed(int paramInt, byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LightVideoUploadProcessor", 2, "<BDH_LOG>TransactionListener.onFailed  erroCode: " + paramInt + " sendInfo:" + this.sendInfo);
    }
    this.this$0.onSendFileSliceFailed(paramInt);
  }
  
  public void onSuccess(byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LightVideoUploadProcessor", 2, "<BDH_LOG>TransactionListener.onSuccess  erroCode:  sendInfo:" + this.sendInfo);
    }
    paramArrayOfByte = this.this$0.file;
    paramArrayOfByte.transferedSize += this.trans.totalLength;
    if (this.this$0.mCombineInfo != null) {
      this.this$0.sendProgressMessage();
    }
    this.this$0.onSendSliceFinish(this.sendInfo);
  }
  
  public void onSwitch2BackupChannel() {}
  
  public void onTransStart() {}
  
  public void onUpdateProgress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.LightVideoUploadProcessor.TransactionListener
 * JD-Core Version:    0.7.0.1
 */