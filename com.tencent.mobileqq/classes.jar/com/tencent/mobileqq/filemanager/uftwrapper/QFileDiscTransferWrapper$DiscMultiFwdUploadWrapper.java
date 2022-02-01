package com.tencent.mobileqq.filemanager.uftwrapper;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.discoperation.FileHttpUtils;
import com.tencent.mobileqq.uftransfer.api.IUFTTransferKey;
import com.tencent.mobileqq.uftransfer.api.IUFTTransferService;
import com.tencent.mobileqq.uftransfer.api.IUFTUploadCompleteInfo;
import com.tencent.mobileqq.uftransfer.api.UFTDiscUploadInfo;
import com.tencent.mobileqq.uftransfer.api.UFTFileLocalInfo;
import com.tencent.mobileqq.uftransfer.api.UFTFileUploadBusinessInfo;

class QFileDiscTransferWrapper$DiscMultiFwdUploadWrapper
  extends QFileDiscTransferWrapper.DiscBaseUploadWrapper
{
  int jdField_a_of_type_Int;
  final long jdField_a_of_type_Long;
  final QFileDiscTransferWrapper.IDiscMultiFwdCallback jdField_a_of_type_ComTencentMobileqqFilemanagerUftwrapperQFileDiscTransferWrapper$IDiscMultiFwdCallback;
  String jdField_a_of_type_JavaLangString;
  int jdField_b_of_type_Int;
  String jdField_b_of_type_JavaLangString;
  int jdField_c_of_type_Int;
  String jdField_c_of_type_JavaLangString;
  String d;
  String e;
  
  QFileDiscTransferWrapper$DiscMultiFwdUploadWrapper(QQAppInterface paramQQAppInterface, long paramLong, String paramString1, String paramString2, QFileDiscTransferWrapper.ITransferWrapperCallback paramITransferWrapperCallback, QFileDiscTransferWrapper.IDiscMultiFwdCallback paramIDiscMultiFwdCallback)
  {
    super(paramQQAppInterface, paramITransferWrapperCallback);
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerUftwrapperQFileDiscTransferWrapper$IDiscMultiFwdCallback = paramIDiscMultiFwdCallback;
  }
  
  void a()
  {
    this.jdField_a_of_type_Boolean = false;
    UFTDiscUploadInfo localUFTDiscUploadInfo = new UFTDiscUploadInfo();
    localUFTDiscUploadInfo.a(this.jdField_a_of_type_JavaLangString);
    localUFTDiscUploadInfo.a(false);
    localUFTDiscUploadInfo.b(true);
    localUFTDiscUploadInfo.b(this.jdField_b_of_type_JavaLangString);
    localUFTDiscUploadInfo.a(3000);
    localUFTDiscUploadInfo.a(Long.valueOf(this.jdField_a_of_type_Long));
    this.jdField_a_of_type_ComTencentMobileqqUftransferApiIUFTTransferKey = ((IUFTTransferService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IUFTTransferService.class, "")).uploadDiscFile(localUFTDiscUploadInfo, a(), this);
  }
  
  public void a(IUFTTransferKey paramIUFTTransferKey, int paramInt, IUFTUploadCompleteInfo paramIUFTUploadCompleteInfo)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerUftwrapperQFileDiscTransferWrapper$IDiscMultiFwdCallback != null)
    {
      paramIUFTTransferKey = new Bundle();
      paramIUFTTransferKey.putString("strFileId", this.jdField_c_of_type_JavaLangString);
      paramIUFTTransferKey.putString("str10MMd5", this.d);
      paramIUFTTransferKey.putString("strSha", this.e);
      paramIUFTTransferKey.putInt("width", this.jdField_a_of_type_Int);
      paramIUFTTransferKey.putInt("height", this.jdField_b_of_type_Int);
      paramIUFTTransferKey.putInt("duration", this.jdField_c_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerUftwrapperQFileDiscTransferWrapper$IDiscMultiFwdCallback.a(paramInt, true, paramIUFTTransferKey);
    }
    paramIUFTTransferKey = this.jdField_a_of_type_ComTencentMobileqqUftransferApiIUFTTransferKey.a();
    if ((paramIUFTTransferKey instanceof Long)) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerUftwrapperQFileDiscTransferWrapper$ITransferWrapperCallback.a(((Long)paramIUFTTransferKey).longValue());
    }
  }
  
  public void a(IUFTTransferKey paramIUFTTransferKey, UFTFileLocalInfo paramUFTFileLocalInfo)
  {
    this.d = FileHttpUtils.a(paramUFTFileLocalInfo.a());
    this.e = FileHttpUtils.a(paramUFTFileLocalInfo.d());
    this.jdField_a_of_type_Int = paramUFTFileLocalInfo.a();
    this.jdField_b_of_type_Int = paramUFTFileLocalInfo.b();
    this.jdField_c_of_type_Int = paramUFTFileLocalInfo.c();
  }
  
  public void a(IUFTTransferKey paramIUFTTransferKey, UFTFileUploadBusinessInfo paramUFTFileUploadBusinessInfo)
  {
    if (!TextUtils.isEmpty(paramUFTFileUploadBusinessInfo.a())) {
      this.jdField_c_of_type_JavaLangString = paramUFTFileUploadBusinessInfo.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.uftwrapper.QFileDiscTransferWrapper.DiscMultiFwdUploadWrapper
 * JD-Core Version:    0.7.0.1
 */