package com.tencent.mobileqq.uftransfer.task.upload;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.uftransfer.api.IUFTTransferKey;
import com.tencent.mobileqq.uftransfer.api.IUFTUploadCallback;
import com.tencent.mobileqq.uftransfer.api.IUFTUploadCompleteInfo;
import com.tencent.mobileqq.uftransfer.api.IUFTUploadSendMsgCallback;
import com.tencent.mobileqq.uftransfer.api.UFTFileLocalInfo;
import com.tencent.mobileqq.uftransfer.api.UFTFileUploadBusinessInfo;

public class UFTUploadCbWrapper
  implements IUFTUploadCallback
{
  long jdField_a_of_type_Long = 0L;
  final Handler jdField_a_of_type_AndroidOsHandler;
  final IUFTUploadCallback jdField_a_of_type_ComTencentMobileqqUftransferApiIUFTUploadCallback;
  final UFTUploadCbWrapper.IWrapperHost jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTUploadCbWrapper$IWrapperHost;
  boolean jdField_a_of_type_Boolean = false;
  
  public UFTUploadCbWrapper(UFTUploadCbWrapper.IWrapperHost paramIWrapperHost, IUFTUploadCallback paramIUFTUploadCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTUploadCbWrapper$IWrapperHost = paramIWrapperHost;
    this.jdField_a_of_type_ComTencentMobileqqUftransferApiIUFTUploadCallback = paramIUFTUploadCallback;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  }
  
  private boolean a()
  {
    UFTUploadCbWrapper.IWrapperHost localIWrapperHost = this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTUploadCbWrapper$IWrapperHost;
    if (localIWrapperHost != null) {
      return localIWrapperHost.a();
    }
    return false;
  }
  
  public int a(IUFTTransferKey paramIUFTTransferKey, Bundle paramBundle, IUFTUploadSendMsgCallback paramIUFTUploadSendMsgCallback)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new UFTUploadCbWrapper.7(this, paramIUFTTransferKey, paramBundle, paramIUFTUploadSendMsgCallback));
    return 0;
  }
  
  public void a(IUFTTransferKey paramIUFTTransferKey)
  {
    if (a()) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new UFTUploadCbWrapper.1(this, paramIUFTTransferKey));
  }
  
  public void a(IUFTTransferKey paramIUFTTransferKey, int paramInt, Bundle paramBundle)
  {
    if (a()) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new UFTUploadCbWrapper.4(this, paramIUFTTransferKey, paramInt, paramBundle));
  }
  
  public void a(IUFTTransferKey paramIUFTTransferKey, int paramInt, IUFTUploadCompleteInfo paramIUFTUploadCompleteInfo)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new UFTUploadCbWrapper.3(this, paramIUFTTransferKey, paramInt, paramIUFTUploadCompleteInfo));
  }
  
  public void a(IUFTTransferKey paramIUFTTransferKey, long paramLong1, long paramLong2)
  {
    if (a()) {
      return;
    }
    IUFTUploadCallback localIUFTUploadCallback = this.jdField_a_of_type_ComTencentMobileqqUftransferApiIUFTUploadCallback;
    if (localIUFTUploadCallback != null) {
      localIUFTUploadCallback.a(paramIUFTTransferKey, paramLong1, paramLong2);
    }
  }
  
  public void a(IUFTTransferKey paramIUFTTransferKey, long paramLong1, long paramLong2, long paramLong3)
  {
    if (a()) {
      return;
    }
    long l1 = System.currentTimeMillis();
    long l2 = this.jdField_a_of_type_Long;
    if ((l2 == 0L) || (l1 - l2 >= 1000L))
    {
      this.jdField_a_of_type_Long = l1;
      this.jdField_a_of_type_AndroidOsHandler.post(new UFTUploadCbWrapper.2(this, paramIUFTTransferKey, paramLong1, paramLong2, paramLong3));
    }
  }
  
  public void a(IUFTTransferKey paramIUFTTransferKey, UFTFileLocalInfo paramUFTFileLocalInfo)
  {
    if (a()) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new UFTUploadCbWrapper.5(this, paramIUFTTransferKey, paramUFTFileLocalInfo));
  }
  
  public void a(IUFTTransferKey paramIUFTTransferKey, UFTFileUploadBusinessInfo paramUFTFileUploadBusinessInfo)
  {
    if (a()) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new UFTUploadCbWrapper.6(this, paramIUFTTransferKey, paramUFTFileUploadBusinessInfo));
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.task.upload.UFTUploadCbWrapper
 * JD-Core Version:    0.7.0.1
 */