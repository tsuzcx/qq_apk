package com.tencent.mobileqq.filemanager.uftwrapper;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.discoperation.FileHttpUtils;
import com.tencent.mobileqq.filemanager.fileassistant.util.QFileAssistantUtils;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.uftransfer.api.IUFTTransferKey;
import com.tencent.mobileqq.uftransfer.api.IUFTTransferService;
import com.tencent.mobileqq.uftransfer.api.IUFTUploadCompleteInfo;
import com.tencent.mobileqq.uftransfer.api.UFTC2CUploadInfo;
import com.tencent.mobileqq.uftransfer.api.UFTFileLocalInfo;
import com.tencent.mobileqq.uftransfer.api.UFTFileUploadBusinessInfo;

class QFileC2CTransferWrapper$C2CMultiFwdUploadWrapper
  extends QFileC2CTransferWrapper.C2CBaseUploadWrapper
{
  int jdField_a_of_type_Int;
  final long jdField_a_of_type_Long;
  final QFileC2CTransferWrapper.C2CFileMultiFwdInfo jdField_a_of_type_ComTencentMobileqqFilemanagerUftwrapperQFileC2CTransferWrapper$C2CFileMultiFwdInfo;
  final QFileC2CTransferWrapper.IC2CMultiFwdCallback jdField_a_of_type_ComTencentMobileqqFilemanagerUftwrapperQFileC2CTransferWrapper$IC2CMultiFwdCallback;
  String jdField_a_of_type_JavaLangString;
  int jdField_b_of_type_Int;
  final long jdField_b_of_type_Long;
  String jdField_b_of_type_JavaLangString;
  int jdField_c_of_type_Int;
  String jdField_c_of_type_JavaLangString;
  
  public QFileC2CTransferWrapper$C2CMultiFwdUploadWrapper(QFileC2CTransferWrapper paramQFileC2CTransferWrapper, QQAppInterface paramQQAppInterface, long paramLong, QFileC2CTransferWrapper.C2CFileMultiFwdInfo paramC2CFileMultiFwdInfo, QFileC2CTransferWrapper.ITransferWrapperCallback paramITransferWrapperCallback, QFileC2CTransferWrapper.IC2CMultiFwdCallback paramIC2CMultiFwdCallback)
  {
    super(paramQQAppInterface, paramITransferWrapperCallback);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerUftwrapperQFileC2CTransferWrapper$IC2CMultiFwdCallback = paramIC2CMultiFwdCallback;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerUftwrapperQFileC2CTransferWrapper$C2CFileMultiFwdInfo = paramC2CFileMultiFwdInfo;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_b_of_type_Long = FileManagerUtil.a(paramC2CFileMultiFwdInfo.jdField_a_of_type_JavaLangString);
    this.jdField_b_of_type_Boolean = QFileAssistantUtils.a(paramC2CFileMultiFwdInfo.jdField_b_of_type_JavaLangString);
  }
  
  long a()
  {
    return this.jdField_b_of_type_Long;
  }
  
  void a()
  {
    this.jdField_a_of_type_Boolean = false;
    UFTC2CUploadInfo localUFTC2CUploadInfo = new UFTC2CUploadInfo();
    localUFTC2CUploadInfo.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerUftwrapperQFileC2CTransferWrapper$C2CFileMultiFwdInfo.jdField_a_of_type_JavaLangString);
    localUFTC2CUploadInfo.a(false);
    localUFTC2CUploadInfo.b(true);
    localUFTC2CUploadInfo.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerUftwrapperQFileC2CTransferWrapper$C2CFileMultiFwdInfo.jdField_b_of_type_JavaLangString);
    localUFTC2CUploadInfo.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerUftwrapperQFileC2CTransferWrapper$C2CFileMultiFwdInfo.jdField_a_of_type_Int);
    localUFTC2CUploadInfo.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerUftwrapperQFileC2CTransferWrapper$C2CFileMultiFwdInfo.jdField_a_of_type_Long);
    localUFTC2CUploadInfo.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerUftwrapperQFileC2CTransferWrapper$C2CFileMultiFwdInfo.jdField_a_of_type_ArrayOfByte);
    localUFTC2CUploadInfo.c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerUftwrapperQFileC2CTransferWrapper$C2CFileMultiFwdInfo.jdField_c_of_type_JavaLangString);
    localUFTC2CUploadInfo.a(Long.valueOf(this.jdField_a_of_type_Long));
    this.jdField_a_of_type_ComTencentMobileqqUftransferApiIUFTTransferKey = ((IUFTTransferService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IUFTTransferService.class, "")).uploadC2CFile(localUFTC2CUploadInfo, a(), this);
  }
  
  public void a(IUFTTransferKey paramIUFTTransferKey, int paramInt, IUFTUploadCompleteInfo paramIUFTUploadCompleteInfo)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerUftwrapperQFileC2CTransferWrapper$IC2CMultiFwdCallback != null)
    {
      paramIUFTTransferKey = new Bundle();
      paramIUFTTransferKey.putString("strFileId", this.jdField_a_of_type_JavaLangString);
      paramIUFTTransferKey.putString("str10MMd5", this.jdField_b_of_type_JavaLangString);
      paramIUFTTransferKey.putString("strSha", this.jdField_c_of_type_JavaLangString);
      paramIUFTTransferKey.putInt("width", this.jdField_a_of_type_Int);
      paramIUFTTransferKey.putInt("height", this.jdField_b_of_type_Int);
      paramIUFTTransferKey.putInt("duration", this.jdField_c_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerUftwrapperQFileC2CTransferWrapper$IC2CMultiFwdCallback.a(paramInt, true, paramIUFTTransferKey);
    }
    paramIUFTTransferKey = this.jdField_a_of_type_ComTencentMobileqqUftransferApiIUFTTransferKey.a();
    if ((paramIUFTTransferKey instanceof Long)) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerUftwrapperQFileC2CTransferWrapper$ITransferWrapperCallback.a(((Long)paramIUFTTransferKey).longValue());
    }
  }
  
  public void a(IUFTTransferKey paramIUFTTransferKey, UFTFileLocalInfo paramUFTFileLocalInfo)
  {
    this.jdField_b_of_type_JavaLangString = FileHttpUtils.a(paramUFTFileLocalInfo.a());
    this.jdField_c_of_type_JavaLangString = FileHttpUtils.a(paramUFTFileLocalInfo.d());
    this.jdField_a_of_type_Int = paramUFTFileLocalInfo.a();
    this.jdField_b_of_type_Int = paramUFTFileLocalInfo.b();
    this.jdField_c_of_type_Int = paramUFTFileLocalInfo.c();
  }
  
  public void a(IUFTTransferKey paramIUFTTransferKey, UFTFileUploadBusinessInfo paramUFTFileUploadBusinessInfo)
  {
    if (!TextUtils.isEmpty(paramUFTFileUploadBusinessInfo.a())) {
      this.jdField_a_of_type_JavaLangString = paramUFTFileUploadBusinessInfo.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.uftwrapper.QFileC2CTransferWrapper.C2CMultiFwdUploadWrapper
 * JD-Core Version:    0.7.0.1
 */