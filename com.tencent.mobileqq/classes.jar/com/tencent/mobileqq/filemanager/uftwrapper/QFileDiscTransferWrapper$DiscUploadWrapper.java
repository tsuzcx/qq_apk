package com.tencent.mobileqq.filemanager.uftwrapper;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.commonsdk.util.HexUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.discoperation.FileHttpUtils;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.uftransfer.api.IUFTTransferKey;
import com.tencent.mobileqq.uftransfer.api.IUFTTransferService;
import com.tencent.mobileqq.uftransfer.api.IUFTUploadCompleteInfo;
import com.tencent.mobileqq.uftransfer.api.IUFTUploadSendMsgCallback;
import com.tencent.mobileqq.uftransfer.api.UFTDiscUploadInfo;
import com.tencent.mobileqq.uftransfer.api.UFTFileLocalInfo;
import com.tencent.mobileqq.uftransfer.api.UFTFileUploadBusinessInfo;

class QFileDiscTransferWrapper$DiscUploadWrapper
  extends QFileDiscTransferWrapper.DiscBaseUploadWrapper
{
  final FileManagerEntity a;
  
  QFileDiscTransferWrapper$DiscUploadWrapper(QQAppInterface paramQQAppInterface, FileManagerEntity paramFileManagerEntity, QFileDiscTransferWrapper.ITransferWrapperCallback paramITransferWrapperCallback)
  {
    super(paramQQAppInterface, paramITransferWrapperCallback);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = paramFileManagerEntity;
  }
  
  public int a(IUFTTransferKey paramIUFTTransferKey, Bundle paramBundle, IUFTUploadSendMsgCallback paramIUFTUploadSendMsgCallback)
  {
    paramBundle = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName;
    paramIUFTTransferKey = paramBundle;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nFileType == 5)
    {
      paramIUFTTransferKey = paramBundle;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strApkPackageName))
      {
        paramIUFTTransferKey = paramBundle;
        if (paramBundle.indexOf(".apk") < 0)
        {
          paramIUFTTransferKey = new StringBuilder();
          paramIUFTTransferKey.append(paramBundle);
          paramIUFTTransferKey.append(".apk");
          paramIUFTTransferKey = paramIUFTTransferKey.toString();
        }
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileTransferHandler().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramIUFTTransferKey, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.msgUid, new QFileDiscTransferWrapper.DiscUploadWrapper.1(this, paramIUFTUploadSendMsgCallback));
    return 0;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = false;
    UFTDiscUploadInfo localUFTDiscUploadInfo = new UFTDiscUploadInfo();
    localUFTDiscUploadInfo.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFilePath);
    localUFTDiscUploadInfo.a(true);
    localUFTDiscUploadInfo.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin);
    localUFTDiscUploadInfo.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType);
    localUFTDiscUploadInfo.a(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId));
    this.jdField_a_of_type_ComTencentMobileqqUftransferApiIUFTTransferKey = ((IUFTTransferService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IUFTTransferService.class, "")).uploadDiscFile(localUFTDiscUploadInfo, a(), this);
  }
  
  void a(int paramInt)
  {
    super.a(paramInt);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 3;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(true, 3, null);
  }
  
  public void a(IUFTTransferKey paramIUFTTransferKey)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    paramIUFTTransferKey = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    paramIUFTTransferKey.fProgress = 0.0F;
    if (paramIUFTTransferKey.status != 2)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 2;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 16, null, 0, null);
  }
  
  public void a(IUFTTransferKey paramIUFTTransferKey, int paramInt, IUFTUploadCompleteInfo paramIUFTUploadCompleteInfo)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    if (paramInt != 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 15, null, paramInt, paramIUFTUploadCompleteInfo.a());
    }
    else
    {
      if (paramIUFTUploadCompleteInfo.a())
      {
        FileManagerUtil.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, 5, "");
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress = 1.0F;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 1;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 14, new Object[] { this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath(), Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize), Boolean.valueOf(true), paramIUFTUploadCompleteInfo.b() }, 0, null);
    }
    paramIUFTTransferKey = this.jdField_a_of_type_ComTencentMobileqqUftransferApiIUFTTransferKey.a();
    if ((paramIUFTTransferKey instanceof Long)) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerUftwrapperQFileDiscTransferWrapper$ITransferWrapperCallback.a(((Long)paramIUFTTransferKey).longValue());
    }
  }
  
  public void a(IUFTTransferKey paramIUFTTransferKey, long paramLong1, long paramLong2, long paramLong3)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    paramIUFTTransferKey = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    paramIUFTTransferKey.fProgress = ((float)paramLong2 / (float)paramLong1);
    if (paramIUFTTransferKey.status != 2)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 2;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 16, null, 0, null);
  }
  
  public void a(IUFTTransferKey paramIUFTTransferKey, UFTFileLocalInfo paramUFTFileLocalInfo)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    if (paramUFTFileLocalInfo.a() != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5 = FileHttpUtils.a(paramUFTFileLocalInfo.a());
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.str10Md5 = HexUtil.bytes2HexStr(paramUFTFileLocalInfo.a());
    }
    if (paramUFTFileLocalInfo.d() != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileSHA = FileHttpUtils.a(paramUFTFileLocalInfo.d());
    }
    if (paramUFTFileLocalInfo.b() != 0) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.imgHeight = paramUFTFileLocalInfo.b();
    }
    if (paramUFTFileLocalInfo.a() != 0) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.imgWidth = paramUFTFileLocalInfo.a();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
  }
  
  public void a(IUFTTransferKey paramIUFTTransferKey, UFTFileUploadBusinessInfo paramUFTFileUploadBusinessInfo)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    if (!TextUtils.isEmpty(paramUFTFileUploadBusinessInfo.a())) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid = paramUFTFileUploadBusinessInfo.a();
    }
    if (!TextUtils.isEmpty(paramUFTFileUploadBusinessInfo.d())) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strServerPath = paramUFTFileUploadBusinessInfo.d();
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.svrPathIpType = paramUFTFileUploadBusinessInfo.a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.uftwrapper.QFileDiscTransferWrapper.DiscUploadWrapper
 * JD-Core Version:    0.7.0.1
 */