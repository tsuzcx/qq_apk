package com.tencent.mobileqq.filemanager.uftwrapper;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.discoperation.FileHttpUtils;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.uftransfer.api.IUFTTransferKey;
import com.tencent.mobileqq.uftransfer.api.IUFTTransferService;
import com.tencent.mobileqq.uftransfer.api.IUFTUploadCompleteInfo;
import com.tencent.mobileqq.uftransfer.api.UFTFileLocalInfo;
import com.tencent.mobileqq.uftransfer.api.UFTFileUploadBusinessInfo;
import com.tencent.mobileqq.uftransfer.api.UFTTroopFileUploadBusinessInfo;
import com.tencent.mobileqq.uftransfer.api.UFTTroopUploadInfo;
import java.util.UUID;

class QFileTroopTransferWrapper$TroopMultiFwdUploadWrapper
  extends QFileTroopTransferWrapper.TroopBaseUploadWrapper
{
  int jdField_a_of_type_Int = 102;
  final QFileTroopTransferWrapper.ITroopMultiFwdCallback jdField_a_of_type_ComTencentMobileqqFilemanagerUftwrapperQFileTroopTransferWrapper$ITroopMultiFwdCallback;
  final String jdField_a_of_type_JavaLangString;
  final UUID jdField_a_of_type_JavaUtilUUID;
  int jdField_b_of_type_Int;
  long jdField_b_of_type_Long;
  final String jdField_b_of_type_JavaLangString = "";
  int jdField_c_of_type_Int;
  String jdField_c_of_type_JavaLangString;
  int jdField_d_of_type_Int;
  String jdField_d_of_type_JavaLangString;
  String e;
  
  public QFileTroopTransferWrapper$TroopMultiFwdUploadWrapper(QQAppInterface paramQQAppInterface, UUID paramUUID, long paramLong, String paramString, QFileTroopTransferWrapper.ITransferWrapperCallback paramITransferWrapperCallback, QFileTroopTransferWrapper.ITroopMultiFwdCallback paramITroopMultiFwdCallback)
  {
    super(paramQQAppInterface, paramLong, paramITransferWrapperCallback);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaUtilUUID = paramUUID;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerUftwrapperQFileTroopTransferWrapper$ITroopMultiFwdCallback = paramITroopMultiFwdCallback;
  }
  
  long a()
  {
    if (this.jdField_b_of_type_Long == 0L) {
      this.jdField_b_of_type_Long = FileManagerUtil.a(this.jdField_a_of_type_JavaLangString);
    }
    return this.jdField_b_of_type_Long;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = false;
    UFTTroopUploadInfo localUFTTroopUploadInfo = new UFTTroopUploadInfo();
    localUFTTroopUploadInfo.a(this.jdField_a_of_type_JavaLangString);
    localUFTTroopUploadInfo.a(false);
    localUFTTroopUploadInfo.b(true);
    localUFTTroopUploadInfo.b(String.valueOf(this.jdField_a_of_type_Long));
    localUFTTroopUploadInfo.a(1);
    localUFTTroopUploadInfo.a(this.jdField_a_of_type_JavaUtilUUID);
    localUFTTroopUploadInfo.b(this.jdField_a_of_type_Int);
    localUFTTroopUploadInfo.c("");
    localUFTTroopUploadInfo.c(5);
    this.jdField_a_of_type_ComTencentMobileqqUftransferApiIUFTTransferKey = ((IUFTTransferService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IUFTTransferService.class, "")).uploadTroopFile(localUFTTroopUploadInfo, a(), this);
  }
  
  public void a(IUFTTransferKey paramIUFTTransferKey, int paramInt, IUFTUploadCompleteInfo paramIUFTUploadCompleteInfo)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerUftwrapperQFileTroopTransferWrapper$ITroopMultiFwdCallback != null)
    {
      paramIUFTTransferKey = new Bundle();
      paramIUFTTransferKey.putLong("fileSize", this.jdField_b_of_type_Long);
      paramIUFTTransferKey.putString("strFileId", this.e);
      paramIUFTTransferKey.putString("strMd5", this.jdField_c_of_type_JavaLangString);
      paramIUFTTransferKey.putString("strSha", this.jdField_d_of_type_JavaLangString);
      paramIUFTTransferKey.putInt("width", this.jdField_b_of_type_Int);
      paramIUFTTransferKey.putInt("height", this.jdField_c_of_type_Int);
      paramIUFTTransferKey.putInt("duration", this.jdField_d_of_type_Int);
      paramIUFTTransferKey.putInt("busiId", this.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerUftwrapperQFileTroopTransferWrapper$ITroopMultiFwdCallback.a(paramInt, true, paramIUFTTransferKey);
    }
    paramIUFTTransferKey = this.jdField_a_of_type_ComTencentMobileqqUftransferApiIUFTTransferKey.a();
    if ((paramIUFTTransferKey instanceof UUID)) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerUftwrapperQFileTroopTransferWrapper$ITransferWrapperCallback.a((UUID)paramIUFTTransferKey);
    }
  }
  
  public void a(IUFTTransferKey paramIUFTTransferKey, UFTFileLocalInfo paramUFTFileLocalInfo)
  {
    this.jdField_c_of_type_JavaLangString = FileHttpUtils.a(paramUFTFileLocalInfo.b());
    this.jdField_d_of_type_JavaLangString = FileHttpUtils.a(paramUFTFileLocalInfo.d());
    this.jdField_b_of_type_Int = paramUFTFileLocalInfo.a();
    this.jdField_c_of_type_Int = paramUFTFileLocalInfo.b();
    this.jdField_d_of_type_Int = paramUFTFileLocalInfo.c();
  }
  
  public void a(IUFTTransferKey paramIUFTTransferKey, UFTFileUploadBusinessInfo paramUFTFileUploadBusinessInfo)
  {
    if (!TextUtils.isEmpty(paramUFTFileUploadBusinessInfo.a())) {
      this.e = paramUFTFileUploadBusinessInfo.a();
    }
    if ((paramUFTFileUploadBusinessInfo instanceof UFTTroopFileUploadBusinessInfo)) {
      this.jdField_a_of_type_Int = ((UFTTroopFileUploadBusinessInfo)paramUFTFileUploadBusinessInfo).b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.uftwrapper.QFileTroopTransferWrapper.TroopMultiFwdUploadWrapper
 * JD-Core Version:    0.7.0.1
 */